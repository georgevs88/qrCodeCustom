package pmcg.fcn.siat.domain;

/**
 * Representa os Tipos de Responsável Contábil que uma empresa ou autônomo pode
 * possuir.
 * @author George do Valle
 * @version 1.0
 * @created 31-out-2007 08:47:23
 */
public enum TipoResponsavelContabil {
	A, /*Autônomo*/
	E, /*Empresa de Contabilidade*/
	F; /*Funcionário de Empresa*/
	
	
	public String getCodigo() {
		return this.toString();
	}
}