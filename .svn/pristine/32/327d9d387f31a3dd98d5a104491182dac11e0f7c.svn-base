package pmcg.fcn.siat.domain.ws;

/**
 * 
 * Classe que representa as Mensagens de Saída do Grava Licenças. 
 * 
 * Classe não persistida.
 * 
 * @author George do Valle
 * @version 1.0
 * @created 03-ago-2010 08:57:46
 */
public enum MensagemSaidaGravaLicencas {
	
	M1(1, "Inconsistência na entrada XML."), 							/* Inconsistência na entrada XML 							*/
	M2(3, "Ocorreu um erro na execução do serviço: Grava Licença."), 	/* Ocorreu um erro na execução do serviço: Grava Licença.	*/
	M3(1, "Inscrição Municipal inexistente."), 							/* Inscrição Municipal inexistente 							*/
	M4(1, "Inconsistência nos dados das Licenças."), 					/* Inconsistência nos dados das Licenças 					*/
	M5(2, "Licenças gravadas com sucesso."), 							/* Licenças gravadas com sucesso 							*/
	M6(1, "Problemas na gravação das Licenças."), 						/* Problemas na gravação das Licenças 						*/
	M7(1, "Código Licença Inexistente."),								/* Código Licença Inexistente 								*/
	M8(1, "Problema na gravação da Licença de código:"), 				/* Problemas na gravação das Licenças 						*/
	M9(1, "Licença inválida."); 										/* Licença inválida. 										*/

	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemSaidaGravaLicencas (Integer numeroMensagem, String mensagem){
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
		return super.toString();
	}
	
	@Override
	public String toString() {
		return getMensagem();
	}
}