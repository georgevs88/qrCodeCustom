package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do serviço emitir certidao
 * Classe não persistida.
 * @author Eule Castro
 * @version 1.0
 * @created 24-set-2010 11:06:24
 */
public enum MensagemSaidaVerificaAutenticidadeCertidao {
	
	M1(1,"Inconsistência - Arquivo"),
	M2(1,"Campos obrigatórios não informados"),
	M3(1,"Certidão inexistente"),
	M4(0,"Consulta efetuada - Certidão Autêntica"),
	M5(1,"Consulta efetuada - Certidão Não Autêntica"),
	M6(1,"Consulta não efetuada"),
	M7(1,"Inconsistência nos dados da verificação");

	private String mensagem;
	private Integer numeroMensagem;
	
	private MensagemSaidaVerificaAutenticidadeCertidao(Integer numeroMensagem, String mensagem){
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