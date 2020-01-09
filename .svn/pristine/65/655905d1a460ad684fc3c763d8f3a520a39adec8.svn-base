package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa a Mensagem de Saída do Grava Pessoa. Classe não
 * persistida.
 * 
 * @author George do Valle
 * @version 1.0
 * @created 15-fev-2011 14:57:39
 */
public enum MensagemSaidaGravaPessoa {
	
	M1(1,"Inconsistência - Dados Arquivo"),
	M2(2,"Campos obrigatórios não informados"),
	M3(3,"Gravação Pessoa não realizada"),
	M6(4,"Mensagem Siat");

	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemSaidaGravaPessoa(Integer numeroMensagem, String mensagem){
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
