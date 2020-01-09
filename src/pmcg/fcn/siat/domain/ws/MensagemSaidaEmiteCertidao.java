package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do serviço emitir certidao
 * Classe não persistida.
 * @author Eule Castro
 * @version 1.0
 * @created 24-set-2010 11:06:24
 */
public enum MensagemSaidaEmiteCertidao {
	
	M1("Inconsistência - Arquivo"),
	M2("Campos obrigatórios não informados"),
	M3("Tipo Certidão inexistente"),
	M4("Código Cadastro inexistente"),
	M5("Número Cadastro inexistente"),
	M6("Certidão Emitida"),
	M7("Certidão Não Emitida"), 
	M8("Certidão Reemitida");

	private String mensagem;
	
	private MensagemSaidaEmiteCertidao(String mensagem){
		this.mensagem = mensagem;
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