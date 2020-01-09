package pmcg.fcn.siat.domain.ws;
/**
 * Classe que representa as mensagens do arquivo de saida do retorno dos processos
 * do F�rum. Classe n�o persistida.
 * @author Eule Castro e Davison Oliveira
 * @version 1.0
 * @created 02-ago-2010 08:26:36
 */
public enum MensagemRetornoForum {
	
	M1("Dados de entrada inconsistentes") /* Dados de entrada inconsistentes */ ,
	M2("CDA n�o cadastrada")              /* CDA n�o cadastrada */ ,
	M3("Dados atualizados com sucesso")   /* Dados atualizados com sucesso */ ,
	M4("Dados n�o atualizados")           /* Dados n�o atualizados */ ;

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