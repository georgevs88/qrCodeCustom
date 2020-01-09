package pmcg.imti.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Pmarel extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public Date datini;
	public Date datfim;
	public String especie;
	public String tipo_especie;
	public String regiao;
	

	public void initComponentes() throws ParseException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		datfim = new Date();
		String mesAno = new SimpleDateFormat("MM/yyyy").format(datfim);
		datini = new SimpleDateFormat("dd/MM/yyyy").parse("01/" + mesAno);
		especie = "TODAS";
		tipo_especie = "TODAS";
		regiao = "TODAS";
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
		if(datini == null){
			throw new WrongValueException(this.getComponente("datini"), "Informe a Data Inicial!");
		}
		if(datfim == null){
			throw new WrongValueException(this.getComponente("datfim"), "Informe a Data Final!");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("datini", datini!=null?sdf.format(datini):"-");
		param.put("datfim", datfim!=null?sdf.format(datfim):"-");
		param.put("especie", especie.equalsIgnoreCase("TODAS")?"-":especie);
		param.put("tipo_especie", tipo_especie.equalsIgnoreCase("TODAS")?"-":tipo_especie);
		param.put("regiao", regiao.equalsIgnoreCase("TODAS")?"-":regiao);
		new WinUtils().abrirBirt("pmarel.rptdesign", param);
	}
	
	@Override
	public void apagar() throws InterruptedException {
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

	@Override
	public void salvar() throws InterruptedException {
	}

}
