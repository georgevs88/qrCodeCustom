package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do arquivo de saida de Obter dados da CDA.
 * Classe não persistida.
 * @author Eule Castro
 * @version 1.0
 * @created 22-jul-2010 14:53:26
 */
public enum MensagemObterDadosCDA {
	
	M1(1,"Dados de Entrada Inconsistentes.") 	/* Dados de Entrada Inconsistentes 	*/ ,
	M2(2,"CDA não cadastrada.") 				/* CDA não cadastrada 				*/ ,
	M3(3,"Código não é de CDA.") 				/* Código não é de CDA 				*/ ,
	M4(4,"CDA Cancelada.") 						/* CDA Cancelada 					*/ ,
	M5(5,"Consulta efetuada com sucesso.") 		/* Consulta efetuada com sucesso 	*/ ,
	M6(6,"Consulta não efetuada.") 				/* Consulta não efetuada 			*/ ;

	private Integer numeroMensagem;
	private String mensagem;
	
	MensagemObterDadosCDA (Integer numeroMensagem, String mensagem){
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
	
	@Override
	public String toString() {
		return getMensagem();
	}
}