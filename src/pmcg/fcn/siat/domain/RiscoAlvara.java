package pmcg.fcn.siat.domain;

/**
 * Classe que representa os tipos de Riscos do Cadastro Econ�mico. Informa��o �
 * enviada pelo sistema CIM.
 * @author George do Valle
 * @version 1.0
 * @created 02-ago-2010 10:57:11
 */
public enum RiscoAlvara {
	/**
	 * Indica que o Cadastro Econ�mico � de risco Alto.
	 */
	A /* Alto */ ,
	/**
	 * Indica que o Cadastro Econ�mico � de risco M�dio.
	 */
	M /* M�dio */ ,
	/**
	 * Indica que o Cadastro Econ�mico � de risco Baixo.
	 */
	B /* Baixo */ ;

	public String getCodigo() {
		return this.toString();
	}
}