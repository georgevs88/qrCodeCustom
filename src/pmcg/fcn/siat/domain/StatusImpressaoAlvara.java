package pmcg.fcn.siat.domain;

/**
 * Classe que representa os Status de impressão do Alvará. Informação é enviada pelo sistema CIM.
 * @author George do Valle
 */
public enum StatusImpressaoAlvara {
	/**
	 * Indica que o Alvará está liberado para impressão.
	 */
	L /* Liberado */ ,
	/**
	 * Indica que o Alvará está bloqueado para impressão, ou seja, depende do
	 * deferimento das licenças.
	 */
	B /* Bloqueado */ ,
	/**
	 * Indica que o Alvará está condicionado para impressão, ou seja, depende do
	 * deferimento das licenças. Pode ser impresso o Alvará Provisório.
	 */
	C /* Condicionado */ ;

	public String getCodigo() {
		return this.toString();
	}
}