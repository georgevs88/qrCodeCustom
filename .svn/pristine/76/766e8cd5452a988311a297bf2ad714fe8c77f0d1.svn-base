package pmcg.imti.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CclDAO;
import pmcg.fcn.dao.ibatis.CusDAO;
import pmcg.fcn.dao.ibatis.UsoDAO;
import pmcg.fcn.domain.CclVO;
import pmcg.fcn.domain.CusVO;
import pmcg.fcn.domain.UsoVO;
import pmcg.framework.ui.WindowCrud;

public class Cnacfg extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public List<UsoVO> listUsos = new ArrayList<UsoVO>();
	public CusVO cus;
	public CclVO ccl;
	public String cnae;
	
	public void initComponentes(){
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		UsoVO usoVazio = new UsoVO();
		usoVazio.setCoduso("/");
		usoVazio.setDesuso("/");
		listUsos.add(usoVazio);
		try {
			listUsos.addAll(new UsoDAO().getTodos(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String coduni = getCodUnidade();
		String nomuni = getUnidade();
		if(coduni != null && (coduni.equals("24") || nomuni.indexOf("SEMADUR") >= 0)){
			//MEIO AMBIENTE
			((Combobox) getComponente("ambccl")).setDisabled(false);
			((Combobox) getComponente("vigccl")).setDisabled(true);
			((Combobox) getComponente("bomccl")).setDisabled(true);
			((Combobox) getComponente("gurccl")).setDisabled(true);
		} else if(coduni != null && coduni.equals("2")){
			//VIGILÂNCIA SANITÁRIA
			((Combobox) getComponente("ambccl")).setDisabled(true);
			((Combobox) getComponente("vigccl")).setDisabled(false);
			((Combobox) getComponente("bomccl")).setDisabled(true);
			((Combobox) getComponente("gurccl")).setDisabled(true);
		} else if(coduni != null && coduni.equals("26")){
			//BOMBEIROS
			((Combobox) getComponente("ambccl")).setDisabled(true);
			((Combobox) getComponente("vigccl")).setDisabled(true);
			((Combobox) getComponente("bomccl")).setDisabled(false);
			((Combobox) getComponente("gurccl")).setDisabled(true);
		} else if(coduni != null && coduni.equals("1")){
			//GURB (ANÁLISE DE ENDEREÇO)
			((Combobox) getComponente("ambccl")).setDisabled(true);
			((Combobox) getComponente("vigccl")).setDisabled(true);
			((Combobox) getComponente("bomccl")).setDisabled(true);
			((Combobox) getComponente("gurccl")).setDisabled(false);
		} else if(coduni != null && coduni.equals("4")){
			//ADMIN/IMTI
			((Combobox) getComponente("ambccl")).setDisabled(false);
			((Combobox) getComponente("vigccl")).setDisabled(false);
			((Combobox) getComponente("bomccl")).setDisabled(false);
			((Combobox) getComponente("gurccl")).setDisabled(false);
		} else {
			((Combobox) getComponente("ambccl")).setDisabled(true);
			((Combobox) getComponente("vigccl")).setDisabled(true);
			((Combobox) getComponente("bomccl")).setDisabled(true);
			((Combobox) getComponente("gurccl")).setDisabled(true);
		}
		vincular();
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
	public void pesquisar() throws InterruptedException {
		cus = new CusDAO().getRegByCnae(cnae);
		ccl = new CclDAO().getRegByCnae(cnae);
		if(cus == null || cus.getIddcus() == null || ccl == null || ccl.getIddccl() == null){
			Messagebox.show("CNAE Não Encontrado!","Configuração CNAE",Messagebox.OK, Messagebox.ERROR);
		}
		vincular();
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}

	@Override
	public void salvar() throws InterruptedException {
		if(cus != null && cus.getIddcus() != null){
			try {
				cus.setUsualt(getLogin());
				ccl.setUsualt(cus.getUsualt());
				Integer codupd = new CusDAO().updUsosByCod(cus);
				Integer codupdccl = new CclDAO().updRiscosByCod(ccl);
				if(codupd != null && codupd > 0 && codupdccl != null && codupdccl > 0){
					Messagebox.show("Configuração Salva com Sucesso!","Configuração CNAE",Messagebox.OK, Messagebox.INFORMATION);
				} else {
					Messagebox.show("Erro ao Salvar Configuração!","Configuração CNAE",Messagebox.OK, Messagebox.ERROR);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
