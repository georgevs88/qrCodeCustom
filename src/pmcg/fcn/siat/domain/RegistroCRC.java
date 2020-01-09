package pmcg.fcn.siat.domain;

/**
 * Representa os Tipos de Registros CRC de um Respons�vel Cont�bil.
 * @author George do Valle
 * @version 1.0
 * @created 31-out-2007 08:48:38
 */
public enum RegistroCRC {
	O, // Origin�rio
	T, // Transferido
	S, //Secund�rio
	P,// Provis�rio
	F;// Filiais
	
	public String getCodigo(){
		return toString();
	}
}