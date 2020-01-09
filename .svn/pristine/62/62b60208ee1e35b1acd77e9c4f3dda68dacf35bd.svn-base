package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;
import pmcg.imti.util.Formatacao;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@ZKEntity(label = "Sad", sequence = "seqsad")
@XStreamAlias(value = "sociosAdm")
public class SadVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddsad; //iddsad
	@XStreamAlias("nome") @XStreamAsAttribute
	private String nomsad; //nome
	@XStreamAlias("tipoPessoa") @XStreamAsAttribute
	private String tipsad; //tipoPessoa
	@XStreamAlias("cpf") @XStreamAsAttribute
	private String cpfsad; //cpf
	@XStreamAlias("estadoCivil") @XStreamAsAttribute
	private EciVO estadoCivil;
	private Long estsad; //estadoCivil
	@XStreamAlias("nacionalidade") @XStreamAsAttribute
	private NacVO nacionalidade;
	private Long nacsad; //nacionalidade
	@XStreamAlias("sexo") @XStreamAsAttribute
	private String sexsad; //sexo
	@XStreamAlias("dataNascimento") @XStreamAsAttribute
	private String dataNascimento;
	private Date dnasad; //dataNascimento
	@XStreamAlias("regimeBens") @XStreamAsAttribute
	private RebVO regimeBens;
	private Long regsad; //regimeBens
	@XStreamAlias("emancipacao") @XStreamAsAttribute
	private EmaVO emancipacao;
	private Long emcsad; //emancipacao
	@XStreamAlias("identidade") @XStreamAsAttribute
	private String idesad; //identidade
	@XStreamAlias("orgaoEmissor") @XStreamAsAttribute
	private String oemsad; //orgaoEmissor
	@XStreamAlias("ufOrgaoEmissor") @XStreamAsAttribute
	private UfVO ufOrgaoEmissor;
	private String ufosad; //ufOrgaoEmissor
	@XStreamAlias("nomePai") @XStreamAsAttribute
	private String npasad; //nomePai
	@XStreamAlias("nomeMae") @XStreamAsAttribute
	private String nmasad; //nomeMae
	@XStreamAlias("profissao") @XStreamAsAttribute
	private String prosad; //profissao
	@XStreamAlias("endereco") @XStreamAsAttribute
	private EdrVO endereco;
	private Long endsad; //endereco
	@XStreamAlias("email") @XStreamAsAttribute
	private String emasad; //email
	@XStreamAlias("nire") @XStreamAsAttribute
	private String nirsad; //nire
	@XStreamAlias("cnpj") @XStreamAsAttribute
	private String cnpsad; //cnpj
	@XStreamAlias("numCartorio") @XStreamAsAttribute
	private String ncasad; //numCartorio
	@XStreamAlias("socio") @XStreamAsAttribute
	private SocVO socio; //socio
	private Long socsad; //socio
	@XStreamAlias("administrador") @XStreamAsAttribute
	private AdmVO administrador; //administrador
	private Long admsad; //administrador
	@XStreamAlias("administradorEireli") @XStreamAsAttribute
	private String adesad; //administradorEireli
	@XStreamAlias("ddd") @XStreamAsAttribute
	private String dddsad; //ddd
	@XStreamAlias("telefone") @XStreamAsAttribute
	private String telsad; //telefone
	@XStreamAlias("representantesLegais") @XStreamAsAttribute
	private RepsVO repsVO; 
	
	private Long matsad; //matriz
	
	private String tdcsad; //tipo documento (sado no bae)
	private Long baesad; //Ficha BAE
	private String qsisad; //Qualificacao SIAT
	private String desqlf; //descricao qlf/só pra mostrar na tela
	private Boolean possuiRep = false;
	private List<RepVO> representantesLegais; // para o BAE
	
	public List<RepVO> getRepresentantesLegais() {
		return representantesLegais;
	}
	public void setRepresentantesLegais(List<RepVO> representantesLegais) {
		this.representantesLegais = representantesLegais;
	}
	public String getCpfCnpjFormatado(){
		if(cpfsad != null){
			return Formatacao.formataCpfCnpj(cpfsad);
		} else if(cnpsad != null){
			return Formatacao.formataCpfCnpj(cnpsad);
		} else {
			return "";
		}
	}
	public Long getIddsad() {
		return iddsad;
	}
	public void setIddsad(Long iddsad) {
		this.iddsad = iddsad;
	}
	public String getNomsad() {
		return nomsad;
	}
	public void setNomsad(String nomsad) {
		this.nomsad = nomsad;
	}
	public String getTipsad() {
		return tipsad;
	}
	public void setTipsad(String tipsad) {
		this.tipsad = tipsad;
	}
	public String getCpfsad() {
		return cpfsad;
	}
	public void setCpfsad(String cpfsad) {
		this.cpfsad = cpfsad;
	}
	public Long getEstsad() {
		return estsad;
	}
	public void setEstsad(Long estsad) {
		this.estsad = estsad;
	}
	public Long getNacsad() {
		return nacsad;
	}
	public void setNacsad(Long nacsad) {
		this.nacsad = nacsad;
	}
	public String getSexsad() {
		return sexsad;
	}
	public void setSexsad(String sexsad) {
		this.sexsad = sexsad;
	}
	public Date getDnasad() {
		return dnasad;
	}
	public void setDnasad(Date dnasad) {
		this.dnasad = dnasad;
	}
	public Long getRegsad() {
		return regsad;
	}
	public void setRegsad(Long regsad) {
		this.regsad = regsad;
	}
	public Long getEmcsad() {
		return emcsad;
	}
	public void setEmcsad(Long emcsad) {
		this.emcsad = emcsad;
	}
	public String getIdesad() {
		return idesad;
	}
	public void setIdesad(String idesad) {
		this.idesad = idesad;
	}
	public String getOemsad() {
		return oemsad;
	}
	public void setOemsad(String oemsad) {
		this.oemsad = oemsad;
	}
	public String getUfosad() {
		return ufosad;
	}
	public void setUfosad(String ufosad) {
		this.ufosad = ufosad;
	}
	public String getNpasad() {
		return npasad;
	}
	public void setNpasad(String npasad) {
		this.npasad = npasad;
	}
	public String getNmasad() {
		return nmasad;
	}
	public void setNmasad(String nmasad) {
		this.nmasad = nmasad;
	}
	public String getProsad() {
		return prosad;
	}
	public void setProsad(String prosad) {
		this.prosad = prosad;
	}
	public Long getEndsad() {
		return endsad;
	}
	public void setEndsad(Long endsad) {
		this.endsad = endsad;
	}
	public String getEmasad() {
		return emasad;
	}
	public void setEmasad(String emasad) {
		this.emasad = emasad;
	}
	public String getNirsad() {
		return nirsad;
	}
	public void setNirsad(String nirsad) {
		this.nirsad = nirsad;
	}
	public String getCnpsad() {
		return cnpsad;
	}
	public void setCnpsad(String cnpsad) {
		this.cnpsad = cnpsad;
	}
	public String getNcasad() {
		return ncasad;
	}
	public void setNcasad(String ncasad) {
		this.ncasad = ncasad;
	}
	public Long getSocsad() {
		return socsad;
	}
	public void setSocsad(Long socsad) {
		this.socsad = socsad;
	}
	public Long getAdmsad() {
		return admsad;
	}
	public void setAdmsad(Long admsad) {
		this.admsad = admsad;
	}
	public String getAdesad() {
		return adesad;
	}
	public void setAdesad(String adesad) {
		this.adesad = adesad;
	}
	public String getDddsad() {
		return dddsad;
	}
	public void setDddsad(String dddsad) {
		this.dddsad = dddsad;
	}
	public String getTelsad() {
		return telsad;
	}
	public void setTelsad(String telsad) {
		this.telsad = telsad;
	}
	public SocVO getSocio() {
		return socio;
	}
	public void setSocio(SocVO socio) {
		this.socio = socio;
	}
	public AdmVO getAdministrador() {
		return administrador;
	}
	public void setAdministrador(AdmVO administrador) {
		this.administrador = administrador;
	}
	
	public RepsVO getRepsVO() {
		return repsVO;
	}
	public void setRepsVO(RepsVO repsVO) {
		this.repsVO = repsVO;
	}
	public EciVO getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EciVO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public NacVO getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(NacVO nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public RebVO getRegimeBens() {
		return regimeBens;
	}
	public void setRegimeBens(RebVO regimeBens) {
		this.regimeBens = regimeBens;
	}
	public EmaVO getEmancipacao() {
		return emancipacao;
	}
	public void setEmancipacao(EmaVO emancipacao) {
		this.emancipacao = emancipacao;
	}
	public UfVO getUfOrgaoEmissor() {
		return ufOrgaoEmissor;
	}
	public void setUfOrgaoEmissor(UfVO ufOrgaoEmissor) {
		this.ufOrgaoEmissor = ufOrgaoEmissor;
	}
	public EdrVO getEndereco() {
		return endereco;
	}
	public void setEndereco(EdrVO endereco) {
		this.endereco = endereco;
	}
	public Long getMatsad() {
		return matsad;
	}
	public void setMatsad(Long matsad) {
		this.matsad = matsad;
	}
	public String getTdcsad() {
		return tdcsad;
	}
	public void setTdcsad(String tdcsad) {
		this.tdcsad = tdcsad;
	}
	public Long getBaesad() {
		return baesad;
	}
	public void setBaesad(Long baesad) {
		this.baesad = baesad;
	}
	public String getQsisad() {
		return qsisad;
	}
	public void setQsisad(String qsisad) {
		this.qsisad = qsisad;
	}
	public String getDesqlf() {
		return desqlf;
	}
	public void setDesqlf(String desqlf) {
		this.desqlf = desqlf;
	}
	public Boolean getPossuiRep() {
		return possuiRep;
	}
	public void setPossuiRep(Boolean possuiRep) {
		this.possuiRep = possuiRep;
	}

	
	
}
