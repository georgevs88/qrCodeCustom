package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do arquivo de saida de Obter CDAs. 
 * 
 * Classe não persistida.
 * 
 * @author Eule Castro
 * @version 1.0
 * @created 21-jul-2010 16:21:03
 */
public enum MensagemObterCDA {
	
	M1(1, "Entrada Inconsistente.") 			/* Entrada Inconsistente 		*/ ,
	M2(2, "Não existe CDA no período.") 		/* Não existe CDA no período 	*/ ,
	M3(3, "Dados obtidos com sucesso.") 		/* Dados obtidos com sucesso 	*/ ,
	M4(4, "Consulta não efetuada.") 			/* Consulta não efetuada 		*/ ;

	private Integer numeroMensagem;
	private String mensagem;
	
	MensagemObterCDA (Integer numeroMensagem, String mensagem){
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