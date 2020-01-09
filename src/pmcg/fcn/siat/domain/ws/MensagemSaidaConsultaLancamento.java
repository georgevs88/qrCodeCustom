package pmcg.fcn.siat.domain.ws;



/**
 * Classe que representa a mensagem de saida da consulta de lançamento. Classe não persistida.
 * 
 * @author George do Valle
 * @version 1.0
 * @updated 07-out-2009 10:07:12
 */
public enum MensagemSaidaConsultaLancamento {

	M1("Lançamento não informado"),			/* Lançamento não informado */
	M2("Lançamento inexistente"),			/* Lançamento inexistente */
	M3("Consulta efetuada com sucesso"), 	/* Consulta efetuada com sucesso */
	M4("Consulta não efetuada"), 			/* Consulta não efetuada */ 
	M5("Entrada inconsistente"); 			/* Entrada inconsistente */ 
	
	private final String descricaoMensagem;

	/*
	 * Constructor default
	 */
	MensagemSaidaConsultaLancamento(String descricaoMensagem) {
		this.descricaoMensagem 	= descricaoMensagem;
	}
	
	public String getDescricaoMensagem() {
		return descricaoMensagem;
	}
}