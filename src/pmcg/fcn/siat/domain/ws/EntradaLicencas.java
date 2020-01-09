package pmcg.fcn.siat.domain.ws;

import java.util.Date;

/**
 * Classe que representa as Entradas das Licen�as. Classe n�o persistida.
 * @author George do Valle
 * @version 1.0
 * @created 03-ago-2010 08:57:32
 */
public class EntradaLicencas {

	/**
	 * C�digo da Licen�a; obrigat�rio
	 */
	//NotNull #########################
	private String codigoLicenca;
	
	/**
	 * Data Fim da Licen�a; obrigat�rio
	 */
	//NotNull #########################
	private Date dataFim;
	
	/**
	 * Data In�cio da Licen�a; obrigat�rio
	 */
	//NotNull #########################
	private Date dataInicio;

	public String getCodigoLicenca() {
		return codigoLicenca;
	}

	public void setCodigoLicenca(String codigoLicenca) {
		this.codigoLicenca = codigoLicenca;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
}