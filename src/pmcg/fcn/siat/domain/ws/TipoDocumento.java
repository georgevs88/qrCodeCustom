package pmcg.fcn.siat.domain.ws;
/**
 * Classe que representa o tipo de documento do Arquivo de Entrada do servi�o Solicita C�digo Autenticidade. Classe n�o persistida.
 * 
 * @author George do Valle
 * @version 1.0
 * @created 04-ago-2010 15:01:36
 */
public enum TipoDocumento {
	
	A 	/* Alvar� 					*/ ,
	AP 	/* Alvar� Provis�rio 		*/ ,
	CA 	/* Cart�o de Inscri��o 		*/ ;

	public String getCodigo() {
		return this.toString();
	}
}