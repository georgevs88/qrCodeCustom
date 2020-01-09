package pmcg.fcn.siat.domain.ws;

import pmcg.fcn.siat.domain.Datum;
import pmcg.fcn.siat.domain.Direcao;
import pmcg.fcn.siat.domain.TipoLocalizacao;

public class EntradaEnderecoGravaCadastroEconomico {

	private TipoLocalizacao tipoLocalizacao; //NotNull Tipo de Localização; obrigatório
	private String pais; // País; obrigatório
	private String tipoLogradouro; // TipoLogradouro
	private String logradouro; //Length(max = 60) Logradouro; obrigatório
	private Integer numero; //Número do endereço; obrigatório
	private String complemento; //Length(max = 156) Complemento; opcional
	private String tipoBairro;
	private String bairro; //Length(max = 50) Nome do Bairro; obrigatório
	private String distrito; //Length(max = 30) Distrito; opcional
	private String cidade; //Length(max = 50) Cidade; obrigatório
	private String uf; //Length(max = 2) Estado; obrigatório
	private String cep;//Length(max = 9) CEP; obrigatório
	private String enderecoReferencia; //Length(max = 250) Endereço Referência; opcional
	private String zipCode; //Length(max = 20) ZipCode; opcional
	private String inscricaoImobiliaria; //Length(max = 30) Inscrição Imobiliária; opcional
	private String povoado; //Length(max = 14) Povoado do endereço rural; opcional
	private String zonaRural;//Length(max = 50) Zona Rural do endereço rural; opcional
	private String ccir; //Length(max = 10) Número do Certificado do Cadastro de Imóvel Rural no Incra; opcional
	private String nirf; //Length(max = 10) Número do Imóvel Rural na Receita federal; opcional
	private Datum datum; //Datum; opcional
	private String latitude; //Length(max = 13) Latitude; opcional
	private String longitude;//Length(max = 13) Longitude; opcional
	private String dddTelefone; //Length(max = 4) DDD do telefone; opcional
	private String telefone; //Length(max = 9) Telefone; opcional
	private String dddFax; //Length(max = 4) DDD do Fax; opcional
	private String fax; //Length(max = 9)  Fax; opcional
	private String email;//Length(max = 115)  Email; opcional
	
	private String inscricaoRural; //Length(max = 30) Inscrição Rural; opcional
	private Direcao direcao;
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEnderecoReferencia() {
		return enderecoReferencia;
	}

	public void setEnderecoReferencia(String enderecoReferencia) {
		this.enderecoReferencia = enderecoReferencia;
	}


	public String getInscricaoImobiliaria() {
		return inscricaoImobiliaria;
	}

	public void setInscricaoImobiliaria(String inscricaoImobiliaria) {
		this.inscricaoImobiliaria = inscricaoImobiliaria;
	}

	public String getInscricaoRural() {
		return inscricaoRural;
	}

	public void setInscricaoRural(String inscricaoRural) {
		this.inscricaoRural = inscricaoRural;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public TipoLocalizacao getTipoLocalizacao() {
		return tipoLocalizacao;
	}

	public void setTipoLocalizacao(TipoLocalizacao tipoLocalizacao) {
		this.tipoLocalizacao = tipoLocalizacao;
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

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getTipoBairro() {
		return tipoBairro;
	}

	public void setTipoBairro(String tipoBairro) {
		this.tipoBairro = tipoBairro;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

	public String getPovoado() {
		return povoado;
	}

	public void setPovoado(String povoado) {
		this.povoado = povoado;
	}

	public String getZonaRural() {
		return zonaRural;
	}

	public void setZonaRural(String zonaRural) {
		this.zonaRural = zonaRural;
	}

	public String getCcir() {
		return ccir;
	}

	public void setCcir(String ccir) {
		this.ccir = ccir;
	}

	public String getNirf() {
		return nirf;
	}

	public void setNirf(String nirf) {
		this.nirf = nirf;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Datum getDatum() {
		return datum;
	}

	public void setDatum(Datum datum) {
		this.datum = datum;
	}
	
	public String getDddFax() {
		return dddFax;
	}

	public void setDddFax(String dddFax) {
		this.dddFax = dddFax;
	}

	public String getDddTelefone() {
		return dddTelefone;
	}

	public void setDddTelefone(String dddTelefone) {
		this.dddTelefone = dddTelefone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}