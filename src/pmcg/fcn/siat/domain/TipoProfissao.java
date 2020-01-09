package pmcg.fcn.siat.domain;



/**
 * Representa os tipos de Profissões.
 * @author George do Valle
 * @version 1.0
 * @created 14-dez-2007 14:23:17
 */
public enum TipoProfissao {
	P /* Principal */ ,
	S /* Secundária */ ;
	
	public String getCodigo() {
		return this.toString();
	}
	
}