package pmcg.fcn.siat.domain;

/**
 * Representa os Tipos de Respons�vel Cont�bil que uma empresa ou aut�nomo pode
 * possuir.
 * @author George do Valle
 * @version 1.0
 * @created 31-out-2007 08:47:23
 */
public enum TipoResponsavelContabil {
	A, /*Aut�nomo*/
	E, /*Empresa de Contabilidade*/
	F; /*Funcion�rio de Empresa*/
	
	
	public String getCodigo() {
		return this.toString();
	}
}