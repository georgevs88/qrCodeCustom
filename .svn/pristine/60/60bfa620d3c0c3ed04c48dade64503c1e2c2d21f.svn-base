package pmcg.imti.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Viadia extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public Date data;

	public void initComponentes() throws ParseException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		//String mesAno = new SimpleDateFormat("MM/yyyy").format(datfim);
		data = new Date(); //new SimpleDateFormat("dd/MM/yyyy").parse("01/" + mesAno);
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
		if(data == null){
			throw new WrongValueException(this.getComponente("data"), "Informe o Mês/Ano!");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("mesano", sdf.format(data));
		new WinUtils().abrirBirt("ViaPorDia.rptdesign", param);
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
