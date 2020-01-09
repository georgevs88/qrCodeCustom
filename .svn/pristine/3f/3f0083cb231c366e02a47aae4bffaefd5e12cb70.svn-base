package pmcg.imti.view;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Tab;
import org.zkoss.zul.event.PagingEvent;

import pmcg.framework.ui.WindowCrud;
import pmcg.imti.dao.ibatis.CclDAO;
import pmcg.imti.domain.CnaVO;

public class Cclcad extends WindowCrud{
	
	private static final long serialVersionUID = 1L;
	public CnaVO filtro = new CnaVO();
	public HashMap<String, String> selecionadoNA = new HashMap<String, String>();
	public HashMap<String, String> selecionadoA = new HashMap<String, String>();
	public List<HashMap<String, Object>> listNAlt; //Lista de NÃO Alterados (À Alterar)
	public HashMap<String, String> selNA; //item selecionado da lista acima
	public List<HashMap<String, Object>> listAlt; //Lista de Alterados
	public HashMap<String, String> selA; //item selecionado da lista acima
	public String riscoNA = null; //valor do risco a atualizar
	public String riscoA = null; //valor do risco a atualizar
	public Boolean checkTodosNA;
	public Boolean checkTodosA;
	public String coduni;
	
	public Cclcad(){
		super("cclcad.zul");
	}
	
	public void initComponentes() {
		this.getCrdBar().getBotao(0).setVisible(false);
		this.getCrdBar().getBotao(1).setVisible(false);
		this.getCrdBar().getBotao(2).setVisible(false);
		this.getCrdBar().getBotao(3).setVisible(false);
		this.getCrdBar().getBotao(4).setVisible(false);
		this.getCrdBar().getBotao(5).setVisible(false);
		this.getCrdBar().getBotao(6).setVisible(true);
		((Tab) getComponente("tNA")).setSelected(true);
		checkTodosNA = false;
		checkTodosA = false;
		coduni = getCodUnidade();
		if(coduni == null || (!coduni.equals("24")) || (!coduni.equals("2")) || (!coduni.equals("26"))){
			coduni = "24";
			((Combobox) getComponente("cbUni")).setDisabled(false);
		} else {
			((Combobox) getComponente("cbUni")).setDisabled(true);
		}
		filtrar();
	}
	
	@SuppressWarnings("unchecked")
	public void filtrar(){
		HashMap param = new HashMap<String ,String>();
		param.put("cnaecdcna",filtro.getCnaecdcna());
		param.put("cnaenmcna",filtro.getCnaenmcna());
		param.put("uniccl", Integer.parseInt(coduni));
		
		Paging pagNA = (Paging) this.getComponente("pagNA");
		Paging pagA = (Paging) this.getComponente("pagA");
		pagNA.setTotalSize(new CclDAO().countRegNA(param));
		pagA.setTotalSize(new CclDAO().countRegA(param));
		final int PAGE_SIZENA = pagNA.getPageSize();
		final int PAGE_SIZEA = pagNA.getPageSize();
		redrawNA(0, PAGE_SIZENA);
		redrawA(0, PAGE_SIZENA);
		pagNA.setActivePage(0);
		pagNA.setDetailed(true);
		pagNA.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZENA;
				redrawNA(ofs, PAGE_SIZENA);
				checkTodosNA = false;
				vincular();
			}
		});
		pagA.setActivePage(0);
		pagA.setDetailed(true);
		pagA.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event evento) {
				PagingEvent pev = (PagingEvent) evento;
				int pgnor = pev.getActivePage();
				int ofss = pgnor * PAGE_SIZEA;
				redrawA(ofss, PAGE_SIZEA);
				checkTodosA = false;
				vincular();
			}
		});
		selecionadoNA = new HashMap<String, String>();
		selecionadoA = new HashMap<String, String>();
		riscoNA = null;
		riscoA = null;
		checkTodosNA = false;
		checkTodosA = false;
		vincular();
	}
	
	@SuppressWarnings("unchecked")
	private void redrawNA(Integer inicial, Integer maximoPermitido) {
		HashMap param = new HashMap<String ,String>();
		param.put("cnaecdcna",filtro.getCnaecdcna());
		param.put("cnaenmcna",filtro.getCnaenmcna());
		param.put("uniccl", Integer.parseInt(coduni));
		this.listNAlt = new CclDAO().getRegNA(param, inicial, maximoPermitido);
	}
	
	@SuppressWarnings("unchecked")
	private void redrawA(Integer inicial, Integer maximoPermitido) {
		HashMap param = new HashMap<String ,String>();
		param.put("cnaecdcna",filtro.getCnaecdcna());
		param.put("cnaenmcna",filtro.getCnaenmcna());
		param.put("uniccl", Integer.parseInt(coduni));
		this.listAlt = (List<HashMap<String, Object>>) new CclDAO().getRegA(param, inicial, maximoPermitido);
	}

	public void selecionar() {
		// O binder abaixo é um "vincular" utilizado só no componente (para não fazer o vincular da tela inteira e mudar a posição do
		//item selecionado na lista)
		AnnotateDataBinder binder = new AnnotateDataBinder();
		if(((Tab) getComponente("tNA")).isSelected()){
			selecionadoNA = selNA;
			binder.init(getComponente("cnaena"), true);
			binder.init(getComponente("descna"), true);
			binder.init(getComponente("cbna"), true);
		} else {
			selecionadoA = selA;
			binder.init(getComponente("cnaea"), true);
			binder.init(getComponente("desca"), true);
			binder.init(getComponente("cba"), true);
		}
		binder.loadAll();
		//this.vincular();
	}
	
	@Override
	public void pesquisar() throws InterruptedException {
//		Map<String, String> param = new HashMap<String, String>();
//		//passar paramentro para listar somentes os CNAEs da unidade do usuario
//		param.put("coduni", getCodUnidade());
//		new WinUtils().abrirLis("/forms/ccllis.zul", param, this, "retCclVO");
	}

//	public void retCclVO(Object ret) {
//		this.cclVO = (CclVO) ret;
//		//risco = cclVO.getGurb();
//		vincular();
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void salvar() throws InterruptedException {
		Integer count = 0;
		if(((Tab) getComponente("tNA")).isSelected()){
			for (HashMap<String, Object> obj : listNAlt) {  
				if(obj.get("checkbox") != null && ((Boolean) obj.get("checkbox"))){
					count++;
				}
			}
			if (count > 0) {
				if(riscoNA == null) {
					throw new WrongValueException(getComponente("cbna"),"Selecione o risco!");
				} else {
					if (Messagebox.show("Tem certeza que deseja atualizar " + count.toString() + " registro(s)?", "Aviso!!!",
							Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
						for (HashMap<String, Object> obj : listNAlt) {  
							if(obj.get("checkbox") != null && ((Boolean) obj.get("checkbox"))){
								HashMap paramupd = new HashMap<String ,String>();
								paramupd.put("rinccl",riscoNA);
								paramupd.put("usualt",getLogin());
								paramupd.put("iddccl",obj.get("iddccl"));
								try {
									new CclDAO().updClasse(paramupd);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						} 
						Messagebox.show("Registros atualizados com sucesso!","CNAE - Classe",Messagebox.OK,Messagebox.INFORMATION);
						this.filtrar();
					}
				}
			} else {
				Messagebox.show("Selecione pelo menos um item!","CNAE - Classe",Messagebox.OK,Messagebox.ERROR);
			}
		} else {
			for (HashMap<String, Object> obj : listAlt) {  
				if(obj.get("checkbox") != null && ((Boolean) obj.get("checkbox"))){
					count++;
				}
			}
			if (count > 0) {
				if(riscoA == null) {
					throw new WrongValueException(getComponente("cba"),"Selecione o risco!");
				} else {
					if (Messagebox.show("Tem certeza que deseja atualizar " + count.toString() + " registro(s)?", "Aviso!!!",
							Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
						for (HashMap<String, Object> obj : listAlt) {  
							if(obj.get("checkbox") != null && ((Boolean) obj.get("checkbox"))){
								HashMap paramupd = new HashMap<String ,String>();
								paramupd.put("rinccl",riscoA);
								paramupd.put("usualt",getLogin());
								paramupd.put("iddccl",obj.get("iddccl"));
								try {
									new CclDAO().updClasse(paramupd);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						} 
						Messagebox.show("Registros atualizados com sucesso!","CNAE - Classe",Messagebox.OK,Messagebox.INFORMATION);
						this.filtrar();
					}
				}
			} else {
				Messagebox.show("Selecione pelo menos um item!","CNAE - Classe",Messagebox.OK,Messagebox.ERROR);
			}
		}
	}
	
	public void selTodosNA(){
		if(checkTodosNA){
			//MARCA TODOS
			for (HashMap<String, Object> obj : listNAlt) {  
					if(obj.get("checkbox") == null){
						obj.put("checkbox", true);
					} else {
						obj.remove("checkbox");
						obj.put("checkbox", true);
					}
			}
		} else {
			//DESMARCA TODOS
			for (HashMap<String, Object> obj : listNAlt) {  
				if(obj.get("checkbox") == null){
					obj.put("checkbox", false);
				} else {
					obj.remove("checkbox");
					obj.put("checkbox", false);
				}
			}
		}
		this.vincular();
	}
	
	public void selTodosA(){
		if(checkTodosA){
			//MARCA TODOS
			for (HashMap<String, Object> obj : listAlt) {  
					if(obj.get("checkbox") == null){
						obj.put("checkbox", true);
					} else {
						obj.remove("checkbox");
						obj.put("checkbox", true);
					}
			}
		} else {
			//DESMARCA TODOS
			for (HashMap<String, Object> obj : listAlt) {  
				if(obj.get("checkbox") == null){
					obj.put("checkbox", false);
				} else {
					obj.remove("checkbox");
					obj.put("checkbox", false);
				}
			}
		}
		this.vincular();
	}
	@Override
	public void apagar() throws InterruptedException {
	}
	@Override
	public void imprimir() throws InterruptedException {
	}
	@Override
	public void incluir() throws InterruptedException {
	}
	@Override
	public void limpar() throws InterruptedException {
	}
	@Override
	public void sair() throws InterruptedException {
		this.detach();
	}	

}
