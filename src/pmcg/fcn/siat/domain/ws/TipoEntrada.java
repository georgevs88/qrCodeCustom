package pmcg.fcn.siat.domain.ws;

public enum TipoEntrada {
	
	I, /** Inclus�o 	**/
	A; /** Altera��o 	**/
	
	public String getCodigo(){
		return this.toString();
	}
}