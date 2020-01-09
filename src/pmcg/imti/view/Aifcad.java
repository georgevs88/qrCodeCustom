package pmcg.imti.view;

import java.sql.SQLException;

import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.AifDAO;
import pmcg.fcn.domain.AifVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Aifcad extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public AifVO aifVO = new AifVO();
	
	public void initComponentes() throws SQLException{
		//aifVO = new AifDAO().getRegByCod(2753L);
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		//retPma(new AifDAO().getRegByCod(5687L));
		atualizaTela();
	}
	
	public void atualizaTela(){
		if(aifVO != null && aifVO.getIddaif() != null){
			getCrdBar().getBotao(0).setVisible(false);
			getCrdBar().getBotao(1).setVisible(true);
			getCrdBar().getBotao(2).setVisible(true);
			getCrdBar().getBotao(3).setVisible(true);
			getCrdBar().getBotao(4).setVisible(true);
			getCrdBar().getBotao(5).setVisible(false);
		} else {
			getCrdBar().getBotao(0).setVisible(true);
			getCrdBar().getBotao(1).setVisible(false);
			getCrdBar().getBotao(2).setVisible(false);
			getCrdBar().getBotao(3).setVisible(true);
			getCrdBar().getBotao(4).setVisible(true);
			getCrdBar().getBotao(5).setVisible(false);
		}
		vincular();
	}
	
//	public void verificaProcesso() throws InterruptedException{
//		if(aifVO.getIddaif() == null){
//			AifVO pma = new AifDAO().getRegByPrapma(aifVO.getPrapma());
//			if(pma != null && pma.getIddaif() != null){
//				if (Messagebox.show("Processo já cadastrado! Deseja recuperar o registro?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
//					try {
//						retPma(pma);
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//	}
	
	@Override
	public void salvar() throws InterruptedException {
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Salvar o Processo?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				Integer codupd = new AifDAO().updRegByCod(aifVO);
				if(codupd != null && codupd > 0){
					Messagebox.show("Processo salvo com sucesso!");
					atualizaTela();
				} else {
					Messagebox.show("Não foi possível salvar o Processo!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void trataVO() {
//		if(aifVO.getPrapma() == null){
//			throw new WrongValueException(getComponente("prapma"),"Informe o Nr do Processo Administrativo!");
//		}
//		if(aifVO.getDatpma() == null){
//			throw new WrongValueException(getComponente("datpma"),"Informe a Data do Processo!");
//		}
//		if(aifVO.getReqpma() == null){
//			throw new WrongValueException(getComponente("reqpma"),"Informe o Requerente!");
//		}
//		if(aifVO.getAtvpma() == null){
//			throw new WrongValueException(getComponente("atvpma"),"Informe a Atividade!");
//		}
//		if(aifVO.getEdrpma() == null){
//			throw new WrongValueException(getComponente("edrpma"),"Informe o Endereço!");
//		}
		aifVO.setUsualt(getLogin());
	}
	
	public void pesquisar() {
		new WinUtils().abrirLis("/forms/aiflis.zul", null, this, "retAif");
	}
	
	public void retAif(Object aif) throws SQLException {
		aifVO = (AifVO) aif;
		atualizaTela();
	}
		
	@Override
	public void incluir() throws InterruptedException {
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Cadastrar o Processo?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
//				AifVO pma = new AifDAO().getRegByPrapma(aifVO.getPrapma());
//				if(pma != null && pma.getIddaif() != null){
//					Messagebox.show("Não foi possível cadastrar! Número de Processo já cadastrado!");
//				} else {
					Long idd = (Long) new AifDAO().insReg(aifVO);
					if(idd != null && idd > 0){
						aifVO = new AifDAO().getRegByCod(idd);
						Messagebox.show("Registro cadastrado com sucesso!");
						atualizaTela();
					} else {
						Messagebox.show("Não foi possível cadastrar o registro!");
					}
//				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void apagar() throws InterruptedException {
		if (Messagebox.show("Tem certeza que deseja o registro?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				Integer cod = new AifDAO().delReg(aifVO.getIddaif());
				if(cod != null && cod > 0){
					Messagebox.show("Processo excluído com sucesso!");
					limpar();
				} else {
					Messagebox.show("Não foi possível excluir o Processo!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void limpar() throws InterruptedException {
		aifVO = new AifVO();
		atualizaTela();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}
	
}
