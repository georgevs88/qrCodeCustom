package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa a mensagem do Arquivo de Sa�da do servi�o GravaGuiaDam.
 * Classe n�o persistida.
 * @author George do Valle
 * @version 1.0
 * @created 01-jul-2010 16:19:58
 */
public enum MensagemSaidaGravaGuiaDam {
	
	M1(1, "Inconsist�ncia - Arquivo") ,
	M2(2, "Guia Dam j� gravada"),
	M3(3, "Cadastro n�o encontrado"),
	M4(4, "Inconsist�ncia - Valores"),
	M5(5, "Inconsist�ncia - Tributo"),
	M6(6, "Grava��o n�o Realizada"),
	M7(7, "Grava��o Realizada"),
	M8(3, "Ocorreu um erro na inclus�o da Guia Dam."),;

	private Integer numeroMensagem;
	private String mensagem;
	
	MensagemSaidaGravaGuiaDam (Integer numeroMensagem, String mensagem){
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