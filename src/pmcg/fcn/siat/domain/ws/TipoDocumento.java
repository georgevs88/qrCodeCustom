package pmcg.fcn.siat.domain.ws;
/**
 * Classe que representa o tipo de documento do Arquivo de Entrada do serviço Solicita Código Autenticidade. Classe não persistida.
 * 
 * @author George do Valle
 * @version 1.0
 * @created 04-ago-2010 15:01:36
 */
public enum TipoDocumento {
	
	A 	/* Alvará 					*/ ,
	AP 	/* Alvará Provisório 		*/ ,
	CA 	/* Cartão de Inscrição 		*/ ;

	public String getCodigo() {
		return this.toString();
	}
}