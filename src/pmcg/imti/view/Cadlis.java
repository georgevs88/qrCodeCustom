package pmcg.imti.view;

import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.CadDAO;
import pmcg.fcn.domain.CadVO;
import pmcg.framework.ui.WindowList;
import pmcg.imti.util.FormatUtils;

public class Cadlis extends WindowList<HashMap<String,Object>>{

	private static final long serialVersionUID = 1L;
	public List<CadVO> lista;
	public CadVO cad = new CadVO();
	public String cpf = "";
		
	public Cadlis() {
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
		if(cpf != null && !cpf.isEmpty()){
			cad.setCpfcad(FormatUtils.onlyNumbers(cpf));
		}
		Paging pag = (Paging) this.getComponente("paging");
		pag.setTotalSize(new CadDAO().getCountByCriterio(cad));
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
		this.lista = new CadDAO().getByCriterioLimit(cad, inicial, maximoPermitido);
	}
	
	public void limpar() {
		cad = new CadVO();
		this.pesquisar();
	}
	
	public void sair(){
		this.detach();
	}

}
