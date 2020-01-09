package pmcg.imti.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.fcn.dao.ibatis.AenDAO;
import pmcg.framework.dao.ibatis.WebusuDAO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Aengra extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public String tipoGrafico = "PIZZA";
	public Integer mes = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));
	public Integer ano = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));

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
		if (mes <= 0 || mes >= 13) {
			throw new WrongValueException(getComponente("mes"), "Informe um valor de 1 a 13!");
		} 
		if (ano < 1900 || ano > Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()))) {
			throw new WrongValueException(getComponente("ano"), "Informe um ano válido!");
		}
		List<HashMap<String, Object>> resumo = new AenDAO().getQtdAenByUsuario((mes<10?"0"+mes:mes) + "/" + ano);
		String labelsDados = "";
		String dados = "";
		if(resumo!= null && resumo.size() > 0){
			for(HashMap<String, Object> item : resumo){
				labelsDados = labelsDados + new WebusuDAO().getNomByLog(item.get("usualt").toString()) + "|";
				dados = dados + item.get("qtd").toString() + ",";
			}
			labelsDados = labelsDados.substring(0, labelsDados.length() - 1);
			dados = dados.substring(0, dados.length() - 1);
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("labelsDados", labelsDados);
			param.put("stringDados", dados);
			param.put("tipoGrafico", tipoGrafico);
			param.put("labelsLegenda", "Alterações|Atendidas");
			param.put("curva", "false");
			param.put("titulo", "Análise de Viabilidade por Usuário");
			new WinUtils().openWin("/graph.zul", param);
		} else {
			throw new WrongValueException(getComponente("mes"), "Não foram encontrados dados para esse período!");
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
}