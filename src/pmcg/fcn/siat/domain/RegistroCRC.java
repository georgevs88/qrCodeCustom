package pmcg.fcn.siat.domain;

/**
 * Representa os Tipos de Registros CRC de um Responsável Contábil.
 * @author George do Valle
 * @version 1.0
 * @created 31-out-2007 08:48:38
 */
public enum RegistroCRC {
	O, // Originário
	T, // Transferido
	S, //Secundário
	P,// Provisório
	F;// Filiais
	
	public String getCodigo(){
		return toString();
	}
}