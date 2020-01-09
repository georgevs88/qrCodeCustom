package pmcg.fcn.siat.domain;



/**
 * Representa os Tipos de Sócios (Pessoa Física ou Pessoa Jurídica).
 * @author George do Valle
 * @version 1.0
 * @created 21-nov-2007 13:52:54
 */
public enum TipoSocio {
	PF /* Pessoa Física */ ,
	PJ /* Pessoa Jurídica */;
	
	public String getCodigo() {
		return this.toString();
	}
}