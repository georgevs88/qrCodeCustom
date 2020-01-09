package pmcg.fcn.siat.domain.ws;

import java.util.Date;

import pmcg.fcn.siat.domain.RegistroCRC;
import pmcg.fcn.siat.domain.TipoCRC;
import pmcg.fcn.siat.domain.TipoResponsavelContabil;

/**
 * Classe que representa a Entrada do Responsável Contábil do Cadastro
 * Sincronizado. Classe não persistida.
 * @author George do Valle
 * @version 1.0
 * @created 04-ago-2009 10:31:07
 */
public class EntradaResponsavelContabilGravaCadastroEconomico {

	/**
	 * Data Fim; opcional
	 */
	private Date dataFimContador;
	
	/**
	 * Data Início; obrigatório
	 */
	//NotNull #########################
	private Date dataInicioContador;
	
	/**
	 * Data de Registro; opcional
	 */
	private Date dataRegistro;
	
	/**
	 * Inscrição Municipal Contador; opcional
	 */
	//Length(max = 30)
	private String inscricaoMunicipalCadEco;
	
	/**
	 * Número CRC; opcional
	 */
	//Length(max = 15)
	private String numeroCrc;
	
	/**
	 * Registro CRC; opcional
	 */
	private RegistroCRC registroCrc;
	
	/**
	 * Tipo CRC; opcional
	 */
	private TipoCRC tipoCrc;
	
	/**
	 * Tipo Responsável Contábil; obrigatório
	 */
	//NotNull #########################
	private TipoResponsavelContabil tipoResponsavelContabil;
	
	/**
	 * UF Registro; opcional
	 */
	//Length(max = 2)
	private String ufRegistro;
	
	private EntradaPessoaGravaCadastroEconomico entradaPessoa;
	
	private EntradaGravaCadastroEconomico entradaGravaCadastroEconomico;

	public EntradaGravaCadastroEconomico getEntradaGravaCadastroEconomico() {
		return entradaGravaCadastroEconomico;
	}

	public void setEntradaGravaCadastroEconomico(EntradaGravaCadastroEconomico entradaGravaCadastroEconomico) {
		this.entradaGravaCadastroEconomico = entradaGravaCadastroEconomico;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getInscricaoMunicipalCadEco() {
		return inscricaoMunicipalCadEco;
	}

	public void setInscricaoMunicipalCadEco(String inscricaoMunicipalCadEco) {
		this.inscricaoMunicipalCadEco = inscricaoMunicipalCadEco;
	}

	public String getNumeroCrc() {
		return numeroCrc;
	}

	public void setNumeroCrc(String numeroCrc) {
		this.numeroCrc = numeroCrc;
	}

	public RegistroCRC getRegistroCrc() {
		return registroCrc;
	}

	public void setRegistroCrc(RegistroCRC registroCrc) {
		this.registroCrc = registroCrc;
	}

	public TipoCRC getTipoCrc() {
		return tipoCrc;
	}

	public void setTipoCrc(TipoCRC tipoCrc) {
		this.tipoCrc = tipoCrc;
	}

	public TipoResponsavelContabil getTipoResponsavelContabil() {
		return tipoResponsavelContabil;
	}

	public void setTipoResponsavelContabil(TipoResponsavelContabil tipoResponsavelContabil) {
		this.tipoResponsavelContabil = tipoResponsavelContabil;
	}

	public String getUfRegistro() {
		return ufRegistro;
	}

	public void setUfRegistro(String ufRegistro) {
		this.ufRegistro = ufRegistro;
	}

	public EntradaPessoaGravaCadastroEconomico getEntradaPessoa() {
		return entradaPessoa;
	}

	public void setEntradaPessoa(EntradaPessoaGravaCadastroEconomico entradaPessoa) {
		this.entradaPessoa = entradaPessoa;
	}

	public Date getDataFimContador() {
		return dataFimContador;
	}

	public void setDataFimContador(Date dataFimContador) {
		this.dataFimContador = dataFimContador;
	}

	public Date getDataInicioContador() {
		return dataInicioContador;
	}

	public void setDataInicioContador(Date dataInicioContador) {
		this.dataInicioContador = dataInicioContador;
	}
}