package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do servi�o VerificaPagamentoGuia
 * Classe n�o persistida.
 * @author erick.lascalla
 */
public enum MensagemSaidaVerificaPagamentoGuia {
	
	M1(1,"Inconsist�ncia - Arquivo"),
	M2(1,"Campos obrigat�rios n�o informados"),
	M3(1,"Guia Dam inexistente"),
	M4(0,"Consulta efetuada - Guia Paga"),
	M5(1,"Consulta efetuada - Guia N�o Paga"),
	M6(1,"Consulta n�o efetuada"),
	M7(1,"Inconsist�ncia nos dados da verifica��o");

	private String mensagem;
	private Integer numeroMensagem;
	
	private MensagemSaidaVerificaPagamentoGuia(Integer numeroMensagem, String mensagem){
		this.mensagem = mensagem;
		this.numeroMensagem = numeroMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Integer getNumeroMensagem() {
		return numeroMensagem;
	}

	public void setNumeroMensagem(Integer numeroMensagem) {
		this.numeroMensagem = numeroMensagem;
	}

	public String getCodigo() {
		return super.toString();
	}
	
	@Override
	public String toString() {
		return getMensagem();
	}
}