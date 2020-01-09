package pmcg.imti.view;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import pmcg.framework.ui.WindowCrud;

public class Graph extends WindowCrud{
	private static final long serialVersionUID = 1L;
	
	//CAMPOS PARA GRÁFICOS LINHA OU BARRA
	public String labelsEixoX; // "Janeiro|Fevereiro|Março"  - OBS: DEVE CONTER UMA ARRAY COM O NR VALORES QUE A LINHA TEM
	public String stringDados; // "0|1|2,3|4|5,6|7|8"  - OBS: DEVE CONTER UMA ARRAY COM O TAMANHO DO NR DE LINHAS DO GRÁFICO
	public String tipoGrafico; // "LINHA", "BARRA", "DONUT", "PIZZA"
	public String labelsLegenda; //"Valor ISS|Valor ISS PAGO|Valor X"  - OBS: DEVE CONTER UMA ARRAY COM O TAMANHO DO NR DE LINHAS DO GRÁFICO
	public String curva; //"true","false"
	public String titulo;
	
	//CAMPOS PARA GRÁFICOS PIZZA OU DONUT
	public String labelsDados; // "ISS|Taxas|Pascelamentos"  - OBS: DEVE CONTER UMA ARRAY COM O NR VALORES QUE A LINHA TEM
	
	public Graph() {
		this.getCrdBar().setVisible(false);
		Map map = Executions.getCurrent().getArg();
		if(map != null && map.get("stringDados") != null){
			labelsEixoX = (String) map.get("labelsEixoX");
			stringDados = (String) map.get("stringDados");
			tipoGrafico = (String) map.get("tipoGrafico");
			labelsLegenda = (String) map.get("labelsLegenda");
			labelsDados = map.get("labelsDados")!=null?(String) map.get("labelsDados"):"";
			curva = (String) map.get("curva");
			titulo = (String) map.get("titulo");
		}
	}
	
	public void initComponentes() {
		//GRAFICO LINHA OU BARRA
		labelsEixoX = labelsEixoX==null?"2013|2014|2015":labelsEixoX;
		stringDados = stringDados==null?"15|8|9,1|3|4,3|4|2":stringDados;
		tipoGrafico = tipoGrafico == null?"LINHA":tipoGrafico;
		labelsLegenda = labelsLegenda==null?"A|B|C":labelsLegenda;
		titulo = titulo==null?"Título do Gráfico":titulo;
		curva = curva==null?"false":curva;
		
		//GRÁFICO PIZZA OU DONUT
		labelsDados = labelsDados == null?"ISS|Taxas|Parcelamentos":labelsDados;
//		stringDados = stringDados==null?"242377382.47,112651427.94,23275574.29":stringDados;
//		tipoGrafico = "PIZZA";
		
		if(tipoGrafico.equals("LINHA") || tipoGrafico.equals("BARRA")){
			Clients.evalJavaScript("carregaGraficoLinha('" + labelsEixoX + "','" + stringDados + "','" + tipoGrafico + "','" + labelsLegenda + "'," + curva +")");
		} else {
			Clients.evalJavaScript("carregaGraficoDonut('" + labelsDados + "','" + stringDados + "','" + tipoGrafico + "')");
		}
		vincular();
	}

	@Override
	public void incluir() throws InterruptedException {
	}

	@Override
	public void salvar() throws InterruptedException {
	}

	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void pesquisar() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		this.detach();
	}

}
