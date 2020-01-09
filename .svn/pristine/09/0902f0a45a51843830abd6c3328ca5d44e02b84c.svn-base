package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Edr", sequence = "endereco")
@XStreamAlias(value = "endereco")
public class EdrVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddedr; //iddedr
	private String tipedr; //TIPO REQUERENTE - E=EMPREENDIMENTO, V=VIABILIDADE
	private String nloedr; //nomeLogradouro
	private String cepedr; //cep
	
	//EMPREENDIMENTO
	@XStreamAlias("cep") @XStreamAsAttribute
	private String cpeedr; //cep
	@XStreamAlias("nomeLogradouro") @XStreamAsAttribute
	private String nleedr; //nomeLogradouro
	@XStreamAlias("municipio") @XStreamAsAttribute
	private MunVO municipio; //municipio
	private String munedr; //municipio
	@XStreamAlias("uf") @XStreamAsAttribute
	private UffVO uf;
	private String uffedr; //uf
	@XStreamAlias("enderecoExterior") @XStreamAsAttribute
	private String eexedr; //enderecoExterior
	@XStreamAlias("pais") @XStreamAsAttribute
	private PaiVO pais;
	private Long paiedr; //pais
	
		
	//VIABILIDADE
	@XStreamAlias("numeroCep") @XStreamAsAttribute
	private String cpvedr; //numeroCep
	@XStreamAlias("logradouro") @XStreamAsAttribute
	private String logedr; //logradouro
	
	//COMUNS
	@XStreamAlias("numeroLogradouro") @XStreamAsAttribute
	private String numedr; //numeroLogradouro
	@XStreamAlias("complemento") @XStreamAsAttribute
	private String comedr; //complemento
	@XStreamAlias("bairro") @XStreamAsAttribute
	private String baiedr; //bairro
	@XStreamAlias("tipoLogradouro") @XStreamAsAttribute
	private TloVO tipoLogradouro;
	private String tloedr; //tipoLogradouro
	
	private String tbaedr; //tipo bairro
	
	public Long getIddedr() {
		return iddedr;
	}
	public void setIddedr(Long iddedr) {
		this.iddedr = iddedr;
	}
	public String getTloedr() {
		return tloedr;
	}
	public void setTloedr(String tloedr) {
		this.tloedr = tloedr;
	}
	public String getNloedr() {
		return nloedr;
	}
	public void setNloedr(String nloedr) {
		this.nloedr = nloedr;
	}
	public String getComedr() {
		return comedr;
	}
	public void setComedr(String comedr) {
		this.comedr = comedr;
	}
	public String getNumedr() {
		return numedr;
	}
	public void setNumedr(String numedr) {
		this.numedr = numedr;
	}
	public String getBaiedr() {
		return baiedr;
	}
	public void setBaiedr(String baiedr) {
		this.baiedr = baiedr;
	}
	public String getCepedr() {
		return cepedr;
	}
	public void setCepedr(String cepedr) {
		this.cepedr = cepedr;
	}
	public String getMunedr() {
		return munedr;
	}
	public void setMunedr(String munedr) {
		this.munedr = munedr;
	}
	public String getUffedr() {
		return uffedr;
	}
	public void setUffedr(String uffedr) {
		this.uffedr = uffedr;
	}
	public String getEexedr() {
		return eexedr;
	}
	public void setEexedr(String eexedr) {
		this.eexedr = eexedr;
	}
	public Long getPaiedr() {
		return paiedr;
	}
	public void setPaiedr(Long paiedr) {
		this.paiedr = paiedr;
	}
	public String getTipedr() {
		return tipedr;
	}
	public void setTipedr(String tipedr) {
		this.tipedr = tipedr;
	}
	public String getCpvedr() {
		return cpvedr;
	}
	public void setCpvedr(String cpvedr) {
		this.cpvedr = cpvedr;
	}
	public String getLogedr() {
		return logedr;
	}
	public void setLogedr(String logedr) {
		this.logedr = logedr;
	}
	public String getNleedr() {
		return nleedr;
	}
	public void setNleedr(String nleedr) {
		this.nleedr = nleedr;
	}
	public String getCpeedr() {
		return cpeedr;
	}
	public void setCpeedr(String cpeedr) {
		this.cpeedr = cpeedr;
	}
	public MunVO getMunicipio() {
		return municipio;
	}
	public void setMunicipio(MunVO municipio) {
		this.municipio = municipio;
	}
	public UffVO getUf() {
		return uf;
	}
	public void setUf(UffVO uf) {
		this.uf = uf;
	}
	public PaiVO getPais() {
		return pais;
	}
	public void setPais(PaiVO pais) {
		this.pais = pais;
	}
	public TloVO getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TloVO tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getTbaedr() {
		return tbaedr;
	}
	public void setTbaedr(String tbaedr) {
		this.tbaedr = tbaedr;
	}
	
	
}
