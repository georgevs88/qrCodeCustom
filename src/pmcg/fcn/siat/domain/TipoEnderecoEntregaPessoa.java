package pmcg.fcn.siat.domain;

/**
 * Representa o Tipo de Endereço Entrega da Pessoa (Residencial, Comercial)
 * @author George do Valle
 * @version 1.0
 * @created 13-nov-2009 10:28:46
 */
public enum TipoEnderecoEntregaPessoa {
	R /* Residencial */ ,
	C /* Comercial */ ;

	public String getCodigo() {
		return this.toString();
	}
}