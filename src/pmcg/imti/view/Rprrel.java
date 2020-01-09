package pmcg.imti.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class Rprrel extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public String mes;
	public String ano;
	public String nr_edital = "0" + new SimpleDateFormat("MM").format(new Date()) + "/" + new SimpleDateFormat("yyyy").format(new Date());
	public String modelo = "LAI"; // LAI = Lei de Acesso a informação, CMMA = CMMA
	public String formato = "PDF"; // formato do relatório
	public String ordem = "tipo"; // Tipo de ordenação do relatório
	public Boolean formatoHTML = true;
	
	public void initComponentes() throws ParseException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		mes = new SimpleDateFormat("MM").format(new Date());
		ano = new SimpleDateFormat("yyyy").format(new Date());
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
		if(mes == null){
			throw new WrongValueException(this.getComponente("mes"), "Informe o Mês!");
		}
		if(ano == null){
			throw new WrongValueException(this.getComponente("ano"), "Informe o Ano!");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("datini", "01/" + Formatacao.zeroEsquerda(mes.toString(), 2) + "/" + ano);
		try {
			param.put("datref", FormatUtils.getMonthName(sdf.parse(param.get("datini").toString())).replace("ç", "c") + " de " + ano);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		param.put("datrel", new SimpleDateFormat("dd").format(new Date()) + " de " + FormatUtils.getMonthName(new Date()).replace("ç", "c") + " de " + new SimpleDateFormat("yyyy").format(new Date()));
		param.put("nr_edital", nr_edital);
		param.put("modelo", modelo);
		param.put("ordem", ordem);
		if(formato.equals("PDF"))
		new WinUtils().abrirBirt("rprrel.rptdesign", param);
		else if (formato.equals("HTML")) {
			new WinUtils().abrirBirt("rprrelDiogrande.rptdesign", param);
			//new WinUtils().abrirBirt(getCodSis(), null, null, null, "HTML", null, "rprrelDiogrande.rptdesign", param);
		}
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

	public void selectModelo(){
		if(modelo.equals("LAI")){
			formatoHTML = true;
		}
			else{
			formatoHTML = false;
			formato = "PDF";
			}
		this.vincular();
	}
	
}
