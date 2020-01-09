package pmcg.fcn.siat.domain;

/**
 * Datum de referência do Endereço Rural.
 * 
 * Refere-se ao modelo matemático teórico da representação da superfície da Terra
 * ao nível do mar utilizado pelos cartógrafos numa dada carta ou mapa.
 * @author George do Valle
 * @version 1.0
 * @created 30-jun-2010 14:56:44
 */
public enum Datum {
	WGS /* wgs84(google) */ ,
	SAD /* Sad-69 */ ,
	SIG /* Sirgas2000 */ ;

	public String getCodigo() {
		return this.toString();
	}
}