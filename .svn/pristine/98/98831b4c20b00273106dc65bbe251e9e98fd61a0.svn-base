package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do serviço VerificaPagamentoGuia
 * Classe não persistida.
 * @author erick.lascalla
 */
public enum MensagemSaidaVerificaPagamentoGuia {
	
	M1(1,"Inconsistência - Arquivo"),
	M2(1,"Campos obrigatórios não informados"),
	M3(1,"Guia Dam inexistente"),
	M4(0,"Consulta efetuada - Guia Paga"),
	M5(1,"Consulta efetuada - Guia Não Paga"),
	M6(1,"Consulta não efetuada"),
	M7(1,"Inconsistência nos dados da verificação");

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