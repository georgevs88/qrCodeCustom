package pmcg.imti.view;

import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.framework.ui.WindowList;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.dao.ibatis.TipDAO;
import pmcg.imti.domain.TipVO;

public class Simlis extends WindowList<HashMap<String,Object>>{

	private static final long serialVersionUID = 1L;
	public List<HashMap<String,Object>> lista;
	public List<TipVO> listTpLVO = new TipDAO().getRegByTipo("TLOG"); // Lista de tipos de logradouro
	public TipVO tplVO; // Tipo de logradouro selecionado
	public List<TipVO> listTpBVO = new TipDAO().getRegByTipo("TBAIR"); // Lista de tipos de bairro
	public TipVO tpbVO; // Tipo de bairro selecionado
	public String logradouro;
	public Integer numero;
	public String bairro;
		
	public Simlis() {
		super();
	}
	
	public void initComponentes() {
		this.getCrdBar().setVisible(false);
		vincular();
	}

	@Override
	public void pesquisar() {
		if((tplVO == null || tplVO.getCodigo() == null) &&
			(logradouro == null || logradouro.isEmpty()) &&	
			(numero == null) &&
			(tpbVO == null || tpbVO.getCodigo() == null) &&
			(bairro == null || bairro.isEmpty()) ) {
			try {
				Messagebox.show("Informe pelo menos um parâmetro!","Busca Inscrição",Messagebox.OK,Messagebox.INFORMATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			HashMap param = new HashMap<String ,Object>();
			if(tplVO != null && tplVO.getCodigo() != null){
				param.put("TIP_LOGRA",tplVO.getCodigo());
			} else {
				param.put("TIP_LOGRA",null);
			}
			if(logradouro != null && (!logradouro.isEmpty())) {
				param.put("LOGRADOURO",logradouro);
			} else {
				param.put("LOGRADOURO",null);
			}
			if(numero != null) {
				param.put("NUMERO",numero);
			} else {
				param.put("NUMERO",null);
			}
			if(tpbVO != null && tpbVO.getCodigo() != null){
				param.put("TIP_BAI",tpbVO.getCodigo());
			} else {
				param.put("TIP_BAI",null);
			}
			if(bairro != null && (!bairro.isEmpty())) {
				param.put("BAIRRO",bairro);
			} else {
				param.put("BAIRRO",null);
			}
			Paging pag = (Paging) this.getComponente("paging");
			pag.setTotalSize(new ImoDAO().countInscricao(param));
			//Integer qtd = pag.getTotalSize();
	//		if (qtd == 0){
	//			try {
	//				Messagebox.show("Nenhum resultado encontrado!");
	//			} catch (InterruptedException e) {
	//				e.printStackTrace();
	//			}
	//		}
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
	}
	
	private void redraw(Integer inicial, Integer maximoPermitido) {
		HashMap params = new HashMap<String ,Object>();
		if(tplVO != null && tplVO.getCodigo() != null){
			params.put("TIP_LOGRA",tplVO.getCodigo());
		}
		if(logradouro != null && (!logradouro.isEmpty())) {
			params.put("LOGRADOURO",logradouro);
		}
		if(numero != null) {
			params.put("NUMERO",numero);
		}
		if(tpbVO != null && tpbVO.getCodigo() != null){
			params.put("TIP_BAI",tpbVO.getCodigo());
		}
		if(bairro != null && (!bairro.isEmpty())) {
			params.put("BAIRRO",bairro);
		}
		this.lista = new ImoDAO().getInscricao(params, inicial, maximoPermitido);
	}
	
	public void limpar() {
		tplVO = new TipVO(); // Tipo de logradouro selecionado
		tpbVO = new TipVO(); // Tipo de bairro selecionado
		logradouro = "";
		numero = null;
		bairro = "";
		this.pesquisar();
	}
	
	public void sair(){
		this.detach();
	}

}
