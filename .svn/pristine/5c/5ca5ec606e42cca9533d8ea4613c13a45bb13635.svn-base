package pmcg.fcn.siat.domain.ws;


/**
 * Enum responsavel por disponibilizar as mensagens de saida para o web service solicitaDocArrecadacaoAutoInfracao. 
 * 
 * @author André Bandera 02/04/2009
 */
public enum MensagemSolicitaDocArrecadacaoAutoInfracao {

	/**
	 * formato: 
	 * - parametro : descricao da mensagem, conforme o numero da mensagem
	 */
	
	M1("Solicitação efetuada."),
	M2("Auto Infração inexistente."),
	M3("Solicitação não efetuada."),
	M4("Atributos obrigatórios: [inscricaoMunicipal] [dataLavratura] [tipoAutoInfracao]."),
	M5("Inconsistência dados da entrada.");
	
	private final String descricaoMensagem;
	
	MensagemSolicitaDocArrecadacaoAutoInfracao(String descricaoMensagem) {
		this.descricaoMensagem 	= descricaoMensagem;
	}
	
	public String getDescricaoMensagem() {
		return descricaoMensagem;
	}
}