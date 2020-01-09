package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do serviço emitir ficha cadastral
 * Classe não persistida.
 * @author erick.lascalla
 * @version 1.0
 */
public enum MensagemSaidaEmiteExtratoDebitos {
	
	M1("Inconsistência - Arquivo"),
	M2("Campos obrigatórios não informados"),
	M3("Código Cadastro inexistente"),
	M4("Número Cadastro inexistente"),
	M5("Extrato Débitos Emitida"),
	M6("Extrato Débitos Não Emitida"),
	M7("Extrato Débitos Não Emitida, não existem débitos");

	private String mensagem;
	
	private MensagemSaidaEmiteExtratoDebitos(String mensagem){
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