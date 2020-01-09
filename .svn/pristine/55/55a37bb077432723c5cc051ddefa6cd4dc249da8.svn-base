package pmcg.imti.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.AnxDAO;
import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.ConDAO;
import pmcg.fcn.dao.ibatis.RepDAO;
import pmcg.fcn.dao.ibatis.ReqDAO;
import pmcg.fcn.dao.ibatis.SadDAO;
import pmcg.fcn.domain.AnxVO;
import pmcg.fcn.domain.ConVO;
import pmcg.fcn.domain.ReqVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.ArqanxDAO;
import pmcg.imti.domain.ArqanxVO;
import pmcg.imti.ui.Upload;
import pmcg.imti.util.FormatUtils;

public class Conbae extends WindowCrud{
	private static final long serialVersionUID = 1L;

	public List<HashMap<String, Object>> listBae; //lista de BAEs pendentes de análise
	public HashMap<String, Object> baeSel; //BAE selecionado da lista
	public Upload up; //Arquivo a ser anexado na lista abaixo
	public String descricaoArquivo = "";
	public List<AnxVO> listAnx; //lista de anexos do BAE
	public String paramProt; //nr_protocolo(viabilidade) FILTRO
	public String paramCpf; //CPF/CNPJ filtro
	public String paramNomNfa; //Nome/fantasia filtro
	public ReqVO requerente;
	public List<HashMap<String, Object>> listCna; //Lista de Atividades
	public List<HashMap<String, Object>> listSad; //Lista de Socios
	public String dataAnalise = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	public String status = "I";
	public String observacoes;
	
	public Conbae() {
		super("conbae.zul");
		Map map = Executions.getCurrent().getArg();
		if(map != null && map.get("viabae") != null){
			paramProt = (String) map.get("viabae");
		}
	}
	
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
	}
	
	public void selecionaProt(){
		retornaBae();
	}
	
	public void retornaBae(){
		try {
			requerente = new ReqDAO().getRegByCod(Long.parseLong(baeSel.get("reqbae").toString()));
			ConVO contador = new ConDAO().getRegByCodComplex((Long) baeSel.get("conbae"));
			baeSel.put("respCont", contador);
			listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) baeSel.get("iddbae"), "B"));
			listCna = new CnaDAO().getRegByProvia(baeSel.get("viabae").toString());
			listSad = new SadDAO().getSadByBae((Long) baeSel.get("iddbae"));
			for(HashMap<String, Object> sad : listSad){
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
		param.put("viabae", paramProt!=null&&(!paramProt.isEmpty())?paramProt:null); 
		param.put("cpfbae", paramCpf!=null&&(!paramCpf.isEmpty())?paramCpf:null);
		param.put("nomnfabae", paramNomNfa!=null&&(!paramNomNfa.isEmpty())?paramNomNfa:null);
		param.put("pendente", null);
		
		Paging pag = (Paging) this.getComponente("pagProt");
		pag.setTotalSize(new BaeDAO().countBae(param));
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
		param.put("viabae", paramProt!=null&&(!paramProt.isEmpty())?paramProt:null); 
		param.put("cpfbae", paramCpf!=null&&(!paramCpf.isEmpty())?FormatUtils.onlyNumbers(paramCpf):null);
		param.put("nomnfabae", paramNomNfa!=null&&(!paramNomNfa.isEmpty())?paramNomNfa:null);
		param.put("pendente", null);
		
		this.listBae = new BaeDAO().getBaeLimit(param, inicial, maximoPermitido);
		if(listBae != null && listBae.size() == 1){
			baeSel = listBae.get(0);
			selecionaProt();
		}
	}
	
	public void imprimirConsulta(Listitem item){
		@SuppressWarnings("unchecked")
		HashMap<String, Object> bae = (HashMap<String, Object>) item.getValue();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("provia", bae.get("viabae").toString());
		new WinUtils().abrirBirt("consulta_bae.rptdesign", param);
	}
	
	public void download(AnxVO anexo) throws InterruptedException {
		ArqanxVO arqanxVO = null;
		if (anexo.getIddanx() != null) {
			Long seqarq = anexo.getArqanx();
			arqanxVO = new ArqanxDAO().getRegByCodComplex(seqarq);
			anexo.setArqanxVO(arqanxVO);
		} else {
			arqanxVO = anexo.getArqanxVO();
		}
		// Busca arquivo no DBIMGFCN
		if (arqanxVO == null) {
			Messagebox.show("Arquivo não encontrado.");
		} else {
			Filedownload.save((byte[]) anexo.getArqanxVO().getAnxarq(), anexo.getArqanxVO().getTiparq(), anexo.getNomanx());
		}
	}
	
	public Boolean isBaeSelecionado(){
		if(baeSel != null && baeSel.get("iddbae") != null){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isTemSocios(){
		if(listSad != null && listSad.size() > 0){
			return true;
		} else {
			return false;
		}
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
		baeSel = null;
		paramProt = paramCpf = paramNomNfa = "";
		requerente = null;
		listCna = null;
		listSad = null;
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