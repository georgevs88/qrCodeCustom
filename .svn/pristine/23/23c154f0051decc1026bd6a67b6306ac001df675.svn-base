package pmcg.imti.view;

import java.util.HashMap;
import java.util.List;

import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.framework.ui.Window;

@SuppressWarnings({ "serial" })
public class PgCentral extends Window {
	
	public List<HashMap<String, Object>> listAtualizacoes;
	public HashMap<String, Object> estatisticas;

	public void initComponentes() {
		listAtualizacoes = new CfgDAO().getAtualizacoesSistema();
		estatisticas = new ViaDAO().getEstatisticas();
		vincular();
	}

	
}