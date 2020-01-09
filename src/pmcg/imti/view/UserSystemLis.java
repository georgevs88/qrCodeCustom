package pmcg.imti.view;

import java.sql.SQLException;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.framework.ui.WindowList;
import pmcg.imti.dao.ibatis.WebusuDAO;
import pmcg.imti.domain.WebusuVO;

public class UserSystemLis  extends WindowList<WebusuVO>{
	private static final long serialVersionUID = 1L;
	public List<WebusuVO> lista;
	public WebusuVO usuSystem = new WebusuVO();
	
	@Override
	public void pesquisar() {
		Paging pag = (Paging) this.getComponente("usuariosDoSistema");
		try {
			pag.setTotalSize(new WebusuDAO().countUserSis(usuSystem));		

			final int PAGE_SIZE = pag.getPageSize();
			redraw(usuSystem, 0, PAGE_SIZE);
			pag.setActivePage(0);
			pag.setDetailed(true);
			pag.addEventListener("onPaging", new EventListener() {
				public void onEvent(Event event) {
					PagingEvent pe = (PagingEvent) event;
					int pgno = pe.getActivePage();
					int ofs = pgno * PAGE_SIZE;
					redraw(usuSystem, ofs, PAGE_SIZE);
					vincular();
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		vincular();
	}
	
	private void redraw(WebusuVO obj, Integer inicial, Integer maximoPermitido){
		try {
			this.lista = new WebusuDAO().getUserSis(obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void initComponentes() {
		this.getCrdBar().getBotao(0).setVisible(false); /*Incluir*/
		this.getCrdBar().getBotao(1).setVisible(false); /*Salvar*/
		this.getCrdBar().getBotao(2).setVisible(false); /*Apagar*/
		this.getCrdBar().getBotao(3).setVisible(true);  /*Limpar*/
		this.getCrdBar().getBotao(4).setVisible(true);  /*Pesquisar*/
		this.getCrdBar().getBotao(5).setVisible(false); /*Imprimir*/
		this.getCrdBar().getBotao(6).setVisible(true);  /*Sair*/
		
		pesquisar();
	}
	
	public void limpar() {
		usuSystem = new WebusuVO();
		
		this.pesquisar();
	}
	
	public void sair(){
		this.detach();
	}
}
