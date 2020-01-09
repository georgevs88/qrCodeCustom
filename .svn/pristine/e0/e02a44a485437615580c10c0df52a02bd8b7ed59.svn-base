package pmcg.imti.view;

import java.sql.SQLException;
import java.util.HashMap;

import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.framework.ui.WindowCrud;

public class Cfgcad extends WindowCrud{
	private static final long serialVersionUID = 1L;
	
	public String grava_via;
	public String resp_via;
	public String grava_emp;
	public String resp_emp;
	public Integer maxvia;
	public Integer maxepd;

	public void initComponentes(){
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(true);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		grava_via = new CfgDAO().getValorByParam("GRAVA_VIABILIDADE");
		resp_via = new CfgDAO().getValorByParam("RESPONDE_VIABILIDADE");
		grava_emp = new CfgDAO().getValorByParam("GRAVA_EMPREENDIMENTO");
		resp_emp = new CfgDAO().getValorByParam("RESPONDE_EMPREENDIMENTO");
		maxvia = Integer.parseInt(new CfgDAO().getValorByParam("MAXIMO_REGISTROS_VIA"));
		maxepd = Integer.parseInt(new CfgDAO().getValorByParam("MAXIMO_REGISTROS_EPD"));
		vincular();
	}
	
	@Override
	public void salvar() throws InterruptedException {
		if (Messagebox.show("Tem certeza que deseja salvar?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				HashMap<String, Object> param = new HashMap<String, Object>();
				param.put("parcfg", "GRAVA_VIABILIDADE");
				param.put("valcfg", grava_via);
				new CfgDAO().updValByPar(param);
				
				param = new HashMap<String, Object>();
				param.put("parcfg", "RESPONDE_VIABILIDADE");
				param.put("valcfg", resp_via);
				new CfgDAO().updValByPar(param);
				
				param = new HashMap<String, Object>();
				param.put("parcfg", "GRAVA_EMPREENDIMENTO");
				param.put("valcfg", grava_emp);
				new CfgDAO().updValByPar(param);
				
				param = new HashMap<String, Object>();
				param.put("parcfg", "RESPONDE_EMPREENDIMENTO");
				param.put("valcfg", resp_emp);
				new CfgDAO().updValByPar(param);
				
				param = new HashMap<String, Object>();
				param.put("parcfg", "MAXIMO_REGISTROS_VIA");
				param.put("valcfg", maxvia.toString());
				new CfgDAO().updValByPar(param);
				
				param = new HashMap<String, Object>();
				param.put("parcfg", "MAXIMO_REGISTROS_EPD");
				param.put("valcfg", maxepd.toString());
				new CfgDAO().updValByPar(param);
				
				Messagebox.show("Registro Salvo com Sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}

}
