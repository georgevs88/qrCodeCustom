package pmcg.imti.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.ZimDAO;
import pmcg.fcn.dao.ibatis.ZonDAO;
import pmcg.fcn.domain.ZimVO;
import pmcg.fcn.domain.ZonVO;
import pmcg.framework.ui.WindowCrud;

public class Zimcad extends WindowCrud{

	private static final long serialVersionUID = 1L;
	public String inscricao;
	public ZimVO zimVO = new ZimVO();
	public List<ZonVO> listZona; //lista de zonas
	public ZonVO zonVO = new ZonVO(); // Zona selecionada no combo
	public List<ZimVO> listZim = new ArrayList<ZimVO>(); //lista de Zona-imóvel
	public Boolean disableResult = true;
	
	public void initComponentes() {
		this.getCrdBar().getBotao(0).setVisible(false);
		this.getCrdBar().getBotao(1).setVisible(false);
		this.getCrdBar().getBotao(2).setVisible(false);
		this.getCrdBar().getBotao(3).setVisible(false);
		this.getCrdBar().getBotao(4).setVisible(false);
		this.getCrdBar().getBotao(5).setVisible(false);
		this.getCrdBar().getBotao(6).setVisible(true);
		this.vincular();
	}
	
	public void pesquisarInsc() {
		if (inscricao == null || inscricao.isEmpty()) {
			throw new WrongValueException(this.getComponente("insc"),"Informe a Inscrição Imobiliária!");
		}
		listZim = new ZimDAO().getRegByInsc(inscricao);
		zonVO = new ZonVO();
		((Combobox) this.getComponente("zona")).setText("");
		if(listZim==null || listZim.size()<=0){
			try {
				Messagebox.show("Inscrição não encontrada!", "Aviso!",Messagebox.OK, Messagebox.ERROR);
				zonVO = new ZonVO();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				listZona = new ZonDAO().getTodos(null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			listZona = new ZonDAO().getZonNaoCad(inscricao);
		}
		disableResult = false;
		((Combobox) this.getComponente("zona")).setFocus(true);
		this.vincular();
	}
	
	public void inserirZona() throws InterruptedException {
		if (inscricao == null || inscricao.isEmpty()) {
			throw new WrongValueException(this.getComponente("insc"),"Informe a Inscrição Imobiliária!");
		}
		if (zonVO == null || zonVO.getCodzon() == null || zonVO.getCodzon().isEmpty()) {
			throw new WrongValueException(this.getComponente("zona"),"Informe a Zona!");
		}
		if (Messagebox.show("Tem certeza que deseja inserir a Zona " + zonVO.getCodzon() + " a inscrição " + inscricao + "?","Aviso!!!", Messagebox.YES | Messagebox.NO,
				Messagebox.QUESTION) == Messagebox.YES) {
			ZimVO z = new ZimVO();
			z.setImozim(inscricao);
			z.setZonzim(zonVO.getCodzon());
			z.setMunzim(9051);
			z.setUsualt(getLogin());
			z.setAltzim("S");
			try {
				new ZimDAO().insReg(z);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.pesquisarInsc();
		}
	}
	
	public void excluirZona(Object obj) throws InterruptedException {
		ZimVO zim = (ZimVO) obj;
		if (Messagebox.show("Tem certeza que deseja remover a Zona " + zim.getZonzim() + "?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			Integer codexc = null;
			codexc = (Integer) new ZimDAO().delZona(zim);
			if(codexc<=0){
				try {
					Messagebox.show("Erro ao excluir a zona!", "Zona - Imóvel!",Messagebox.OK, Messagebox.ERROR);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.pesquisarInsc();
		}
	}
	
	public void alterouInsc() {
		disableResult = true;
		listZim = null;
		((Combobox) this.getComponente("zona")).setFocus(true);
		this.vincular();
	}
	
	public Boolean isEnableResult() {
		return !disableResult;
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
	}
	@Override
	public void imprimir() throws InterruptedException {
	}
	@Override
	public void sair() throws InterruptedException {
		this.detach();
	}
}
