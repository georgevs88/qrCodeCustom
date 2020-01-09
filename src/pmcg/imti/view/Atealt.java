package pmcg.imti.view;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.EevDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.FilDAO;
import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.dao.ibatis.ProDAO;
import pmcg.fcn.dao.ibatis.RepDAO;
import pmcg.fcn.dao.ibatis.ReqDAO;
import pmcg.fcn.dao.ibatis.SadDAO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.ProVO;
import pmcg.fcn.domain.ReqVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Atealt extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public List<HashMap<String, Object>> listEpd; //lista de empreendimentos (alteracoes pendentes)
	public HashMap<String, Object> epdSel; //Empreendimento selecionado da lista
	public String paramProc; //nr_processo FILTRO
	public String paramNome; //Nome/RazãoSocial filtro
	public ProVO processo;
	public ReqVO requerente;
	public HashMap<String, Object> matriz;
	public List<HashMap<String, Object>> listCnaMat; //Lista de Atividades da Matriz
	public List<HashMap<String, Object>> listSadMat; //Lista de Socios da Matriz
	public List<HashMap<String, Object>> listFil; //Lista de Filiais
	public List<HashMap<String, Object>> listEventos;
	
	public void initComponentes(){
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		//paramProc = "70718";
		filtrar();
	}
	
	@Override
	public void salvar() throws InterruptedException {
		if(epdSel != null && epdSel.get("iddepd") != null){
			try {
				if (Messagebox.show("Tem certeza que deseja Concluir as Alterações?", "Atendimento Alteração", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
					EpdVO epdupd = new EpdVO();
					epdupd.setIddepd((Long) epdSel.get("iddepd"));
					epdupd.setUsuepd(getLogin());
					new EpdDAO().updAtendimento(epdupd);
					Messagebox.show("Registro Salvo com Sucesso!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
					paramProc = "";
					limpar();
					filtrar();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selecionaProt(){
		retornaEpd();
	}
	
	public void retornaEpd(){
		try {
			processo = new ProDAO().getRegByCodComplex(Long.parseLong(epdSel.get("proepd").toString()));
			requerente = new ReqDAO().getRegByCod(processo.getReqpro());
			listEventos = new EevDAO().getEventosByPro(processo.getIddpro());
			matriz = new MatDAO().getMatrizByProcesso(processo.getIddpro()); //ASSUMINDO QUE SEMPRE SERÁ 1 MATRIZ PARA CADA PROCESSO
			listCnaMat = new CnaDAO().getRegByMatriz(Long.parseLong(matriz.get("iddmat").toString()));
			listSadMat = new SadDAO().getSadByMatriz(Long.parseLong(matriz.get("iddmat").toString()));
			listFil = new FilDAO().getFilByMatriz(Long.parseLong(matriz.get("iddmat").toString()));
			for(HashMap<String, Object> sad :listSadMat){
				sad.put("listRep", new RepDAO().getRepBySad((Long) sad.get("iddsad")));
			}
			vincular();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void filtrar(){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("nprepd", paramProc!=null&&(!paramProc.isEmpty())?paramProc:null); 
		param.put("nommat", paramNome!=null&&(!paramNome.isEmpty())?paramNome:null);
		param.put("alteracoespendentes", true);
		
		Paging pag = (Paging) this.getComponente("pagProt");
		pag.setTotalSize(new EpdDAO().countEpd(param));
		Integer qtd = pag.getTotalSize();
		if (qtd == 0) {
			try {
				Messagebox.show("Nenhum resultado encontrado!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		final int PAGE_SIZE = pag.getPageSize();
		redraw(0, PAGE_SIZE);
		pag.setActivePage(0);
		pag.setDetailed(true);
		pag.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZE;
				redraw(ofs, PAGE_SIZE);
				vincular();
			}
		});
		vincular();
	}

	private void redraw(Integer inicial, Integer maximoPermitido) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("nprepd", paramProc!=null&&(!paramProc.isEmpty())?paramProc:null); 
		param.put("nommat", paramNome!=null&&(!paramNome.isEmpty())?paramNome:null);
		param.put("alteracoespendentes", true);
		
		this.listEpd = new EpdDAO().getEpdLimit(param, inicial, maximoPermitido);
	}
	
	public Boolean isTemFilial(){
		if(listFil != null && listFil.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public void imprimirConsulta(Listitem item){
		@SuppressWarnings("unchecked")
		HashMap<String, Object> epd = (HashMap<String, Object>) item.getValue();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("nprepd", epd.get("nprepd").toString());
		new WinUtils().abrirBirt("consulta_empreendimento.rptdesign", param);
	}
	
	@Override
	public void incluir() throws InterruptedException {
	}

	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void pesquisar() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
		epdSel = null;
		processo = null;
		requerente = null;
		listEventos = null;
		matriz = null; 
		listCnaMat = null;
		listSadMat = null;
		listFil = null;
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}

}
