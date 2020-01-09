package pmcg.fcn.siat.domain.ws;

public enum TipoEntrada {
	
	I, /** Inclusão 	**/
	A; /** Alteração 	**/
	
	public String getCodigo(){
		return this.toString();
	}
}