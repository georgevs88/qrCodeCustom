package pmcg.fcn.domain;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "representantesLegais")
public class RepVO {
	
	private Long iddrep; //iddrep
	private Long sadrep;
	@XStreamAlias("nome") @XStreamAsAttribute
	private String nomrep; //nome
	@XStreamAlias("cpf") @XStreamAsAttribute
	private String cpfrep; //cpf
	@XStreamAlias("identidade") @XStreamAsAttribute
	private String iderep; //identidade
	@XStreamAlias("orgaoEmissor") @XStreamAsAttribute
	private String oemrep; //orgaoEmissor
	@XStreamAlias("ufOrgaoEmissor") @XStreamAsAttribute
	private UfVO ufOrgaoEmissor;
	private String uforep; //ufOrgaoEmissor
	@XStreamAlias("dataNascimento") @XStreamAsAttribute
	private String dataNascimento;
	private Date dnarep; //dataNascimento
	@XStreamAlias("sexo") @XStreamAsAttribute
	private String sexrep; //sexo
	@XStreamAlias("nomeMae") @XStreamAsAttribute
	private String nmarep; //nomeMae
	@XStreamAlias("nomePai") @XStreamAsAttribute
	private String nparep; //nomePai
	@XStreamAlias("dataInicioMandato") @XStreamAsAttribute
	private String dataInicioMandato;
	private Date dinrep; //dataInicioMandato
	@XStreamAlias("dataFimMandato") @XStreamAsAttribute
	private String dataFimMandato;
	private Date dfirep; //dataFimMandato
	@XStreamAlias("profissao") @XStreamAsAttribute
	private String prorep; //profissao
	@XStreamAlias("nacionalidade") @XStreamAsAttribute
	private NacVO nacionalidade;
	private Long nacrep; //nacionalidade
	@XStreamAlias("endereco") @XStreamAsAttribute
	private EdrVO endereco;
	private Long endrep; //endereco
	@XStreamAlias("estadoCivil") @XStreamAsAttribute
	private EciVO estadoCivil;
	private Long estrep; //estadoCivil
	@XStreamAlias("tipoRepresentanteLegal") @XStreamAsAttribute
	private TrlVO tipoRepresentanteLegal;
	private Long trlrep; //tipoRepresentanteLegal
	private String qsirep; //Qualificação Rep SIAT
		
	public Long getIddrep() {
		return iddrep;
	}
	public void setIddrep(Long iddrep) {
		this.iddrep = iddrep;
	}
	public String getNomrep() {
		return nomrep;
	}
	public void setNomrep(String nomrep) {
		this.nomrep = nomrep;
	}
	public String getCpfrep() {
		return cpfrep;
	}
	public void setCpfrep(String cpfrep) {
		this.cpfrep = cpfrep;
	}
	public String getIderep() {
		return iderep;
	}
	public void setIderep(String iderep) {
		this.iderep = iderep;
	}
	public String getOemrep() {
		return oemrep;
	}
	public void setOemrep(String oemrep) {
		this.oemrep = oemrep;
	}
	public String getUforep() {
		return uforep;
	}
	public void setUforep(String uforep) {
		this.uforep = uforep;
	}
	public Date getDnarep() {
		return dnarep;
	}
	public void setDnarep(Date dnarep) {
		this.dnarep = dnarep;
	}
	public String getSexrep() {
		return sexrep;
	}
	public void setSexrep(String sexrep) {
		this.sexrep = sexrep;
	}
	public String getNmarep() {
		return nmarep;
	}
	public void setNmarep(String nmarep) {
		this.nmarep = nmarep;
	}
	public String getNparep() {
		return nparep;
	}
	public void setNparep(String nparep) {
		this.nparep = nparep;
	}
	public Date getDinrep() {
		return dinrep;
	}
	public void setDinrep(Date dinrep) {
		this.dinrep = dinrep;
	}
	public Date getDfirep() {
		return dfirep;
	}
	public void setDfirep(Date dfirep) {
		this.dfirep = dfirep;
	}
	public String getProrep() {
		return prorep;
	}
	public void setProrep(String prorep) {
		this.prorep = prorep;
	}
	public Long getNacrep() {
		return nacrep;
	}
	public void setNacrep(Long nacrep) {
		this.nacrep = nacrep;
	}
	public Long getEndrep() {
		return endrep;
	}
	public void setEndrep(Long endrep) {
		this.endrep = endrep;
	}
	public Long getEstrep() {
		return estrep;
	}
	public void setEstrep(Long estrep) {
		this.estrep = estrep;
	}
	public Long getTrlrep() {
		return trlrep;
	}
	public void setTrlrep(Long trlrep) {
		this.trlrep = trlrep;
	}
	public UfVO getUfOrgaoEmissor() {
		return ufOrgaoEmissor;
	}
	public void setUfOrgaoEmissor(UfVO ufOrgaoEmissor) {
		this.ufOrgaoEmissor = ufOrgaoEmissor;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDataInicioMandato() {
		return dataInicioMandato;
	}
	public void setDataInicioMandato(String dataInicioMandato) {
		this.dataInicioMandato = dataInicioMandato;
	}
	public String getDataFimMandato() {
		return dataFimMandato;
	}
	public void setDataFimMandato(String dataFimMandato) {
		this.dataFimMandato = dataFimMandato;
	}
	public NacVO getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(NacVO nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public EdrVO getEndereco() {
		return endereco;
	}
	public void setEndereco(EdrVO endereco) {
		this.endereco = endereco;
	}
	public TrlVO getTipoRepresentanteLegal() {
		return tipoRepresentanteLegal;
	}
	public void setTipoRepresentanteLegal(TrlVO tipoRepresentanteLegal) {
		this.tipoRepresentanteLegal = tipoRepresentanteLegal;
	}
	public Long getSadrep() {
		return sadrep;
	}
	public void setSadrep(Long sadrep) {
		this.sadrep = sadrep;
	}
	public EciVO getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EciVO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getQsirep() {
		return qsirep;
	}
	public void setQsirep(String qsirep) {
		this.qsirep = qsirep;
	}

	
	
}
