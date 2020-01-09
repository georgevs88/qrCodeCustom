package pmcg.fcn.siat.domain;

public enum TipoDocumento {
	RG,//Registro Geral
	RM,//Registro Militar
	RNE;//Registro Nacional de Estrangeiro
	
	public String getCodigo() {
		return this.toString();
	}
}