package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa o Status do Arquivo de Entrada do serviço Solicita Código Autenticidade. Classe não persistida.
 * 
 * @author George do Valle
 * @version 1.0
 * @created 04-ago-2010 15:01:50
 */
public enum Status {
	
	B /* Bloqueado 		*/ ,
	C /* Condicionado 	*/ ,
	L /* Liberado 		*/ ;

	public String getCodigo() {
		return this.toString();
	}
}