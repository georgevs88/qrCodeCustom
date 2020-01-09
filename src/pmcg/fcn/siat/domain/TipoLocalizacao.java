package pmcg.fcn.siat.domain;

public enum TipoLocalizacao {
	
	INT, 		// Internacional
	NAC, 		// Nacional
	MUN, 		// Municipal
	MUNURB, 	// Municipal Zona Urbana
	MUNRUR, 	// Municipal Zona Rural
	MUNAP; 		// Municipal Área Publica
	
	public String getCodigo() {
		return this.toString();
	}
}