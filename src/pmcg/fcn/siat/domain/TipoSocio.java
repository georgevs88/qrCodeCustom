package pmcg.fcn.siat.domain;



/**
 * Representa os Tipos de S�cios (Pessoa F�sica ou Pessoa Jur�dica).
 * @author George do Valle
 * @version 1.0
 * @created 21-nov-2007 13:52:54
 */
public enum TipoSocio {
	PF /* Pessoa F�sica */ ,
	PJ /* Pessoa Jur�dica */;
	
	public String getCodigo() {
		return this.toString();
	}
}