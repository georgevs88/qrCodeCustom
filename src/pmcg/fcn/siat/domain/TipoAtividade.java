package pmcg.fcn.siat.domain;

/**
 * Representa os tipos de Atividades.
 * @author George do Valle
 * @version 1.0
 * @created 31-out-2007 08:34:09
 */
public enum TipoAtividade {
	P, /*  Principal   */
	S; /*  Secundaria  */
	
	public String getCodigo(){
		return toString();
	}
}