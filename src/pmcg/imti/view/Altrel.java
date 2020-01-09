package pmcg.imti.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Altrel extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public String usualt;
	public Date datini;
	public Date datfim;

	public void initComponentes() throws ParseException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		usualt = getLogin();
		datfim = new Date();
		String mesAno = new SimpleDateFormat("MM/yyyy").format(datfim);
		datini = new SimpleDateFormat("dd/MM/yyyy").parse("01/" + mesAno);
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
		param.put("usualt", usualt!=null&&(!usualt.isEmpty())?usualt.toUpperCase():"-");
		param.put("datini", datini!=null?sdf.format(datini):"-");
		param.put("datfim", datfim!=null?sdf.format(datfim):"-");
		new WinUtils().abrirBirt("altrel.rptdesign", param);
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
