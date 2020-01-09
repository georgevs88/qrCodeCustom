package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa a Mensagem de Saida da Consulta do Cadastro Econômico.
 * 
 * Classe não persistida.
 * 
 * @author George do Valle
 * @version 1.0
 * @created 28-mar-2011 16:44:48
 */
public enum MensagemSaidaConsultaCadastroEconomico {
	
	M1(1, "Inconsistência - Arquivo."), 				
	M2(1, "Campos obrigatórios não informados."), 		
	M3(1, "Inscrição Municipal inexistente."), 			
	M4(1, "CPF/CNPJ inexistente."), 					
	M6(2, "Consulta efetuada com sucesso."), 			
	M7(1, "Consulta não realizada."); 					

	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemSaidaConsultaCadastroEconomico(Integer numeroMensagem, String mensagem){
		this.mensagem 		= mensagem;
		this.numeroMensagem = numeroMensagem;
	}

	public Integer getNumeroMensagem() {
		return numeroMensagem;
	}

	public void setNumeroMensagem(Integer numeroMensagem) {
		this.numeroMensagem = numeroMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getCodigo() {
		return this.toString();
	}
}