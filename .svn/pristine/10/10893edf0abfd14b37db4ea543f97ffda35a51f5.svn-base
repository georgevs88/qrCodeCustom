package pmcg.imti.view;

import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.AifDAO;
import pmcg.fcn.domain.AifVO;
import pmcg.framework.ui.WindowList;

public class Aiflis extends WindowList<HashMap<String,Object>>{

	private static final long serialVersionUID = 1L;
	public List<AifVO> lista;
	public AifVO aif = new AifVO();
		
	public Aiflis() {
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
		Paging pag = (Paging) this.getComponente("paging");
		try {
			pag.setTotalSize(new AifDAO().getCountByCriterio(aif));
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
		redraw(aif, 0, PAGE_SIZE);
		pag.setActivePage(0);
		pag.setDetailed(true);
		pag.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZE;
				redraw(aif, ofs, PAGE_SIZE);
				vincular();
			}
		});
		vincular();
	}
	
	private void redraw(AifVO obj, Integer inicial, Integer maximoPermitido) {
		this.lista = new AifDAO().getByCriterioLimit(obj, inicial, maximoPermitido);
	}
	
	public void limpar() {
		aif = new AifVO();
		this.pesquisar();
	}
	
	public void sair(){
		this.detach();
	}

}
