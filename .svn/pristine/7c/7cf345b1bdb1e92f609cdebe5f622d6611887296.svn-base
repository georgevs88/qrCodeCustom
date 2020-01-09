package pmcg.imti.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.util.Formatacao;

public class Ategra extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public String tipoGrafico = "LINHA";
	public Integer ano = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
	public Integer mes = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));

	public void initComponentes() throws ParseException, InterruptedException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
		List<HashMap<String, Object>> resumoAte;
		if(mes != null && (mes >= 1 && mes <= 12)){
			resumoAte = new EpdDAO().getGraficoAteEpdMes(Formatacao.zeroEsquerda(mes.toString(),2) + "/" + ano.toString());
		} else {
			resumoAte = new EpdDAO().getGraficoAteEpd(ano.toString());
		}
		String labelsEixoX = "";
		String dadosVia = "";
		String dadosEpd = "";
		for(HashMap<String, Object> item : resumoAte){
			labelsEixoX = labelsEixoX + item.get("competencia").toString() + "|";
			dadosVia = dadosVia + item.get("qtdepd").toString() + "|";
			dadosEpd = dadosEpd + item.get("qtdate").toString() + "|";
		}
		labelsEixoX = labelsEixoX.substring(0, labelsEixoX.length() - 1);
		dadosVia = dadosVia.substring(0, dadosVia.length() - 1);
		dadosEpd = dadosEpd.substring(0, dadosEpd.length() - 1);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("labelsEixoX", labelsEixoX);
		param.put("stringDados", dadosVia + "," + dadosEpd);
		param.put("tipoGrafico", tipoGrafico);
		param.put("labelsLegenda", "Alterações|Atendidas");
		param.put("curva", "false");
		param.put("titulo", "Empreendimento - Atendimento de Alterações");
		new WinUtils().openWin("/graph.zul", param);
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
