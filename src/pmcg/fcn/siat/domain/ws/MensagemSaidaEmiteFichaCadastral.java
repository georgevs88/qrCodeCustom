package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do servi�o emitir ficha cadastral
 * Classe n�o persistida.
 * @author erick.lascalla
 * @version 1.0
 */
public enum MensagemSaidaEmiteFichaCadastral {
	
	M1("Inconsist�ncia - Arquivo"),
	M2("Campos obrigat�rios n�o informados"),
	M3("C�digo Cadastro inexistente"),
	M4("N�mero Cadastro inexistente"),
	M5("Ficha Cadastral Emitida"),
	M6("Ficha Cadastral N�o Emitida");

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