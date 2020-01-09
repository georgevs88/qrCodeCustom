package pmcg.imti.view;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Executions;
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
import pmcg.fcn.dao.ibatis.LvsDAO;
import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.dao.ibatis.ProDAO;
import pmcg.fcn.dao.ibatis.RepDAO;
import pmcg.fcn.dao.ibatis.ReqDAO;
import pmcg.fcn.dao.ibatis.SadDAO;
import pmcg.fcn.domain.LvsVO;
import pmcg.fcn.domain.ProVO;
import pmcg.fcn.domain.ReqVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.util.FormatUtils;

public class Conepd extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public List<HashMap<String, Object>> listEpd; //lista de empreendimentos
	public HashMap<String, Object> epdSel; //Empreendimento selecionado da lista
	public String paramProc; //nr_processo FILTRO
	public String paramCnpj; //CNPJ filtro
	public String paramNire; //NIRE filtro
	public String paramNome; //Nome/RazãoSocial filtro
	public String paramVia; //Protocolo Viabilidade filtro
	public ProVO processo;
	public ReqVO requerente;
	public HashMap<String, Object> matriz;
	public List<HashMap<String, Object>> listCnaMat; //Lista de Atividades da Matriz
	public List<HashMap<String, Object>> listSadMat; //Lista de Socios da Matriz
	public List<HashMap<String, Object>> listFil; //Lista de Filiais
	public List<HashMap<String, Object>> listEventos;
	public Boolean visibleList = true; //Caso a tela receba um processo por parametro nao precisa mostrar a lista
	
	public Conepd() {
		super("conepd.zul");
		Map map = Executions.getCurrent().getArg();
		if(map != null && map.get("nprepd") != null){
			paramProc = (String) map.get("nprepd");
			visibleList = false;
		}
	}
	
	public void initComponentes(){
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		//paramProc = "68008";
		filtrar();
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
			if(listFil != null && listFil.size() > 0){
				for(HashMap<String, Object> fil :listFil){
					fil.put("listCna", new CnaDAO().getRegByFilial((Long) fil.get("iddfil")));
				}
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
		param.put("cnpepd", paramCnpj!=null&&(!paramCnpj.isEmpty())?FormatUtils.onlyNumbers(paramCnpj):null); 
		param.put("nirepd", paramNire!=null&&(!paramNire.isEmpty())?FormatUtils.onlyNumbers(paramNire):null);
		param.put("nommat", paramNome!=null&&(!paramNome.isEmpty())?paramNome:null);
		param.put("pvimat", paramVia!=null&&(!paramVia.isEmpty())?paramVia:null);
		
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
		param.put("cnpepd", paramCnpj!=null&&(!paramCnpj.isEmpty())?FormatUtils.onlyNumbers(paramCnpj):null); 
		param.put("nirepd", paramNire!=null&&(!paramNire.isEmpty())?FormatUtils.onlyNumbers(paramNire):null);
		param.put("nommat", paramNome!=null&&(!paramNome.isEmpty())?paramNome:null);
		param.put("pvimat", paramVia!=null&&(!paramVia.isEmpty())?paramVia:null);
		
		this.listEpd = new EpdDAO().getEpdLimit(param, inicial, maximoPermitido);
		if(listEpd != null && listEpd.size() == 1){
			epdSel = listEpd.get(0);
			selecionaProt();
		}
	}
	
	public Boolean isTemEventos(){
		if(listEventos != null && listEventos.size() > 0){
			return true;
		} else {
			return false;
		}
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
	
	public void imprimirLicenca(Integer opcao) throws NumberFormatException, SQLException{
		if(opcao == 1){
			//Meio Ambiente
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("iddlma", epdSel.get("lmaepd").toString());
			new WinUtils().abrirBirt("dispensa_amb.rptdesign", param);
		} else {
			//Vigilância
			LvsVO lvs = new LvsDAO().getRegByCod(Long.parseLong(epdSel.get("lvsepd").toString()));
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("codlic", lvs.getLiclvs().toString());
			param.put("codves", lvs.getVeslvs().toString());
			new WinUtils().abrirBirt(77, "/sosweb", "3.7", "aplbirt.pmcg.ms.gov.br:8080", "PDF", "LICENCA", "soslicsimplificadarel.rptdesign", param);
		}
	}
	
	public void consultaViabilidade(){
		if(matriz != null && matriz.get("pvimat") != null){
			Map<String, String> param = new HashMap<String, String>();
			param.put("provia", matriz.get("pvimat").toString());
			new WinUtils().abrirLis("/forms/acopro.zul", param, this, null);
		}
	}
	
	@Override
	public void salvar() throws InterruptedException {

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
		paramProc = ""; //nr_processo FILTRO
		paramCnpj = ""; //CNPJ filtro
		paramNire = ""; //NIRE filtro
		paramNome = ""; //NIRE filtro
		paramVia = "";
		filtrar();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}

}
