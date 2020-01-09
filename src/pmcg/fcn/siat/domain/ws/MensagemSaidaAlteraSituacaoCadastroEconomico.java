package pmcg.fcn.siat.domain.ws;

public enum MensagemSaidaAlteraSituacaoCadastroEconomico {

	M1(1, "Inconsistência na entrada XML."), 				/* Inconsistência na entrada XML. */
	M2(1, "Inscrição Municipal não informada"), 			/* Inscrição Municipal não informada. */
	M3(1, "Inscrição Municipal inexistente."), 				/* Inscrição Municipal inexistente. */
	M4(1, "Situação não informada."), 						/* Situação não informada. */
	M5(1, "Situação inválida."),  							/* Situação inválida. */
	M6(1, "Data de referência não informada."), 			/* Data de referência não informada. */
	M7(1, "Data de referência inválida."),					/* Data de referência inválida. */
	M8(1, "Motivo Suspensão não informado."), 				/* Motivo Suspensão não informado. */
	M9(1, "Motivo Suspensão inválido."),					/* Motivo Suspensão inválido.  */
	M10(2, "Alteração da Situação efetuada com sucesso."),	/* Alteração da Situação efetuada com sucesso.	*/
	M11(3, "Problemas na alteração da Situação."); 			/* Problemas na alteração da Situação.	*/

	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemSaidaAlteraSituacaoCadastroEconomico (Integer numeroMensagem, String mensagem){
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
