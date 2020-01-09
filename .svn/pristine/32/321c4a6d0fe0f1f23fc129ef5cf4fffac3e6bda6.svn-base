package pmcg.imti.view;

import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.framework.ui.WindowList;
import pmcg.imti.util.FormatUtils;

public class Epdlis extends WindowList<HashMap<String,Object>>{

	private static final long serialVersionUID = 1L;
	public List<HashMap<String, Object>> lista;
	public String paramProc; //nr_processo FILTRO
	public String paramCnpj; //CNPJ filtro
	public String paramNire; //NIRE filtro
	public String paramNome; //Nome/RazãoSocial filtro
	public String paramVia; //Protocolo Viabilidade filtro
	public String paramImo; //Inscricao Imobiliaria filtro
		
	public Epdlis() {
		super();
	}
	
	public void initComponentes() {
		this.getCrdBar().getBotao(0).setVisible(false);
		this.getCrdBar().getBotao(1).setVisible(false);
		this.getCrdBar().getBotao(2).setVisible(false);
		this.getCrdBar().getBotao(3).setVisible(true);
		this.getCrdBar().getBotao(4).setVisible(true);
		this.getCrdBar().getBotao(5).setVisible(false);
		this.getCrdBar().getBotao(6).setVisible(true);
		pesquisar();
	}

	@Override
	public void pesquisar() {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("nprepd", paramProc!=null&&(!paramProc.isEmpty())?paramProc:null); 
		param.put("cnpepd", paramCnpj!=null&&(!paramCnpj.isEmpty())?FormatUtils.onlyNumbers(paramCnpj):null); 
		param.put("nirepd", paramNire!=null&&(!paramNire.isEmpty())?FormatUtils.onlyNumbers(paramNire):null);
		param.put("nommat", paramNome!=null&&(!paramNome.isEmpty())?paramNome:null);
		param.put("pvimat", paramVia!=null&&(!paramVia.isEmpty())?paramVia:null);
		param.put("iptcen", paramImo!=null&&(!paramImo.isEmpty())?paramImo:null);
		
		Paging pag = (Paging) this.getComponente("paging");
		try {
			pag.setTotalSize(new EpdDAO().countEpd(param));
		} catch (WrongValueException e1) {
			e1.printStackTrace();
		}
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
		param.put("iptcen", paramImo!=null&&(!paramImo.isEmpty())?paramImo:null);
		this.lista = new EpdDAO().getEpdLimit(param, inicial, maximoPermitido);
	}
	
	public void limpar() {
		paramProc = ""; //nr_processo FILTRO
		paramCnpj = ""; //CNPJ filtro
		paramNire = ""; //NIRE filtro
		paramNome = ""; //NIRE filtro
		paramVia = "";
		paramImo = "";
		this.pesquisar();
	}
	
	public void sair(){
		this.detach();
	}



}
