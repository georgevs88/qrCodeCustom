package pmcg.fcn.siat.domain.ws;


/**
 * Enum responsavel por disponibilizar as mensagens de saida para o web service solicitaDocArrecadacaoAutoInfracao. 
 * 
 * @author Andr� Bandera 02/04/2009
 */
public enum MensagemSolicitaDocArrecadacaoAutoInfracao {

	/**
	 * formato: 
	 * - parametro : descricao da mensagem, conforme o numero da mensagem
	 */
	
	M1("Solicita��o efetuada."),
	M2("Auto Infra��o inexistente."),
	M3("Solicita��o n�o efetuada."),
	M4("Atributos obrigat�rios: [inscricaoMunicipal] [dataLavratura] [tipoAutoInfracao]."),
	M5("Inconsist�ncia dados da entrada.");
	
	private final String descricaoMensagem;
	
	MensagemSolicitaDocArrecadacaoAutoInfracao(String descricaoMensagem) {
		this.descricaoMensagem 	= descricaoMensagem;
	}
	
	public String getDescricaoMensagem() {
		return descricaoMensagem;
	}
}