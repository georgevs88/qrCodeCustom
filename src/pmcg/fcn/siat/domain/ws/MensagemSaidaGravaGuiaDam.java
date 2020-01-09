package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa a mensagem do Arquivo de Saída do serviço GravaGuiaDam.
 * Classe não persistida.
 * @author George do Valle
 * @version 1.0
 * @created 01-jul-2010 16:19:58
 */
public enum MensagemSaidaGravaGuiaDam {
	
	M1(1, "Inconsistência - Arquivo") ,
	M2(2, "Guia Dam já gravada"),
	M3(3, "Cadastro não encontrado"),
	M4(4, "Inconsistência - Valores"),
	M5(5, "Inconsistência - Tributo"),
	M6(6, "Gravação não Realizada"),
	M7(7, "Gravação Realizada"),
	M8(3, "Ocorreu um erro na inclusão da Guia Dam."),;

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