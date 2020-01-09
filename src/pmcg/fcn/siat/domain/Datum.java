package pmcg.fcn.siat.domain;

/**
 * Datum de refer�ncia do Endere�o Rural.
 * 
 * Refere-se ao modelo matem�tico te�rico da representa��o da superf�cie da Terra
 * ao n�vel do mar utilizado pelos cart�grafos numa dada carta ou mapa.
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