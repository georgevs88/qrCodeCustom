package pmcg.fcn.siat.domain;

/**
 * Representa o Tipo de Endereço (Residencial, Comercial, Fiscal, Cobrança)
 */
public enum TipoEnderecoCobrancaPessoa {
	R,//Residencial
	C,//Comercial
	F,//Fiscal
	CB;//CoBrança
	
	public String getCodigo() {
		return this.toString();
	}
}