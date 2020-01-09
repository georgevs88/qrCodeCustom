package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do serviço emitir ficha cadastral
 * Classe não persistida.
 * @author erick.lascalla
 * @version 1.0
 */
public enum MensagemSaidaEmiteFichaCadastral {
	
	M1("Inconsistência - Arquivo"),
	M2("Campos obrigatórios não informados"),
	M3("Código Cadastro inexistente"),
	M4("Número Cadastro inexistente"),
	M5("Ficha Cadastral Emitida"),
	M6("Ficha Cadastral Não Emitida");

	private String mensagem;
	
	private MensagemSaidaEmiteFichaCadastral(String mensagem){
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