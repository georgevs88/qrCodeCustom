package pmcg.fcn.siat.domain.ws;

import pmcg.fcn.siat.domain.Datum;
import pmcg.fcn.siat.domain.Direcao;
import pmcg.fcn.siat.domain.TipoEnderecoCobrancaPessoa;
import pmcg.fcn.siat.domain.TipoLocalizacao;


/**
 * Classe que representa a Entrada do Endereço do Grava Pessoa. 
 * Classe não persistida.
 * 
 * @author Eule Castro
 * 
 * @version 1.0
 * @created 15-fev-2011 14:10:30
 */
public class EntradaGravaEnderecoPessoa {
	/**
	 * Nome do Bairro; obrigatório
	 */
	//NotNull #########################
	//Length(max=50)
	private String bairro;
	/**
	 * CCIR; opcional
	 */
	//Length(max=10)
	private String ccir;
	/**
	 * Celular; opcional
	 */
	//Length(max=9)
	private Integer celular;
	/**
	 * CEP; obrigatório
	 */
	//NotNull #########################
	//Length(max=9)
	private String cep;
	/**
	 * Cidade; obrigatório
	 */
	//NotNull #########################
	//Length(max=50)
	private String cidade;
	/**
	 * Complemento; opcional
	 */
	//Length(max=156)
	private String complemento;
	/**
	 * DatumMapa; opcional
	 */
	private Datum datumMapa;
	/**
	 * DDD Celular; opcional
	 */
	//Length(max=3)
	private Integer dddCelular;
	/**
	 * DDD do Fax; opcional
	 */
	//Length(max=4)
	private Integer dddFax;
	/**
	 * DDD do telefone; opcional
	 */
	private Integer dddTelefone;
	/**
	 * Direção; opcional
	 */
	//Length(max=2)
	private Direcao direcao;
	/**
	 * Distrito; opcional
	 */
	//Length(max=30)
	private String distrito;
	/**
	 * Email; opcional
	 */
	//Length(max=115)
	private String email;
	/**
	 * Endereço Referência; opcional
	 */
	//Length(max=250)
	private String enderecoReferencia;
	/**
	 * Fax; opcional
	 */
	//Length(max=9)
	private Integer fax;
	/**
	 * Inscrição Imobiliária; opcional
	 */
	//Length(max=30)
	private String inscricaoImobiliaria;
	/**
	 * Latitude; opcional
	 */
	//Length(max=13)
	private String latitude;
	/**
	 * Logradouro; obrigatório
	 */
	//Length(max=60)
	private String logradouro;
	/**
	 * Longitude; opcional
	 */
	//Length(max=13)
	private String longitude;
	/**
	 * NIRF; opcional
	 */
	//Length(max=10)
	private String nirf;
	/**
	 * Número do endereço; obrigatório
	 */	
	private Integer numero;
	/**
	 * País; obrigatório
	 */
	//Length(max=50)
	private String pais;
	/**
	 * Inscrição Rural; opcional
	 */
	//Length(max=50)
	private String povoado;
	/**
	 * Telefone; opcional
	 */
	//Length(max=9)
	private Integer telefone;
	/**
	 * Tipo de Bairro; obrigatório
	 */
	//NotNull #########################
	private String tipoBairro;
	/**
	 * Tipo do Endereço; obrigatório
	 */
	//NotNull #########################
	private TipoEnderecoCobrancaPessoa tipoEndereco;
	/**
	 * Tipo de Localização; obrigatório
	 */
	//NotNull #########################
	private TipoLocalizacao tipoLocalizacao;
	/**
	 * Tipo Logradouro; obrigatório
	 */
	//NotNull #########################
	private String tipoLogradouro;
	/**
	 * Estado; obrigatório
	 */
	//NotNull #########################
	//Length(max=2)
	private String uf;
	/**
	 * ZipCode; opcional
	 */
	//Length(max=20)
	private String zipCode;
	/**
	 * Povoado; opcional
	 */
	//Length(max=50)
	private String zonaRural;
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCcir() {
		return ccir;
	}

	public void setCcir(String ccir) {
		this.ccir = ccir;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Datum getDatumMapa() {
		return datumMapa;
	}

	public void setDatumMapa(Datum datumMapa) {
		this.datumMapa = datumMapa;
	}

	public Integer getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}

	public Integer getDddFax() {
		return dddFax;
	}

	public void setDddFax(Integer dddFax) {
		this.dddFax = dddFax;
	}

	public Integer getDddTelefone() {
		return dddTelefone;
	}

	public void setDddTelefone(Integer dddTelefone) {
		this.dddTelefone = dddTelefone;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnderecoReferencia() {
		return enderecoReferencia;
	}

	public void setEnderecoReferencia(String enderecoReferencia) {
		this.enderecoReferencia = enderecoReferencia;
	}

	public Integer getFax() {
		return fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	public String getInscricaoImobiliaria() {
		return inscricaoImobiliaria;
	}

	public void setInscricaoImobiliaria(String inscricaoImobiliaria) {
		this.inscricaoImobiliaria = inscricaoImobiliaria;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNirf() {
		return nirf;
	}

	public void setNirf(String nirf) {
		this.nirf = nirf;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPovoado() {
		return povoado;
	}

	public void setPovoado(String povoado) {
		this.povoado = povoado;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getTipoBairro() {
		return tipoBairro;
	}

	public void setTipoBairro(String tipoBairro) {
		this.tipoBairro = tipoBairro;
	}

	public TipoEnderecoCobrancaPessoa getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEnderecoCobrancaPessoa tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public TipoLocalizacao getTipoLocalizacao() {
		return tipoLocalizacao;
	}

	public void setTipoLocalizacao(TipoLocalizacao tipoLocalizacao) {
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZonaRural() {
		return zonaRural;
	}

	public void setZonaRural(String zonaRural) {
		this.zonaRural = zonaRural;
	}	
}
