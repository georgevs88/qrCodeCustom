package pmcg.fcn.siat.domain.ws;
/**
 * Classe que representa as mensagens do arquivo de saida do retorno dos processos
 * do Fórum. Classe não persistida.
 * @author Eule Castro e Davison Oliveira
 * @version 1.0
 * @created 02-ago-2010 08:26:36
 */
public enum MensagemRetornoForum {
	
	M1("Dados de entrada inconsistentes") /* Dados de entrada inconsistentes */ ,
	M2("CDA não cadastrada")              /* CDA não cadastrada */ ,
	M3("Dados atualizados com sucesso")   /* Dados atualizados com sucesso */ ,
	M4("Dados não atualizados")           /* Dados não atualizados */ ;

	private final String descricaoMensagem;
	
	MensagemRetornoForum(String descricaoMensagem) {
		this.descricaoMensagem 	= descricaoMensagem;
	}
	public String getCodigo() {
		return this.toString();
	}
	
	
	public String getDescricaoMensagem() {
		return descricaoMensagem;
	}
}