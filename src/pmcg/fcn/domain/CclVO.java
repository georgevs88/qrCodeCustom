package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Ccl", sequence = "seqccl")
public class CclVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Integer iddccl; //cnae_id
	private String nomccl; //cnae_nome
	private String codccl; //cnae_codigo
	private String cbeccl; //cbo_estab
	private String staccl; //atv_status
	private String cboccl; //cnae_cbo
	private String gurccl; //gurb
	private String vigccl; //vigilancia
	private String ambccl; //ambiente
	private String bomccl; //bombeiro
	private String catccl; //categoria
	private String traccl; //transito
	private String meiccl; //cnae_mei
	private String nieccl; //cnae_nivelEscolar
	private String secccl; //secao
	private Date dinccl; //cnae_data_inicio
	private Date dficcl; //cnae_data_fim
	private Integer demccl; //desm
	private String sedccl; //secao_desc
	private String divccl; //divisao
	private String grpccl; //grp
	private String claccl; //classe
	private String sclccl; //subclasse
	private String urlccl; //url_notas
	private String altccl; //alterado
	private String alcccl; //alteradog
	private String alrccl; //altreplica
	private String usualt; //usualt
	private Date datalt; //datalt
	
	public CclVO() {
		super();
	}
	
	public CclVO(String codccl, String meiccl) {
		super();
		this.codccl = codccl;
		this.meiccl = meiccl;
	}
	
	public Integer getIddccl() {
		return iddccl;
	}
	public void setIddccl(Integer iddccl) {
		this.iddccl = iddccl;
	}
	public String getNomccl() {
		return nomccl;
	}
	public void setNomccl(String nomccl) {
		this.nomccl = nomccl;
	}
	public String getCodccl() {
		return codccl;
	}
	public void setCodccl(String codccl) {
		this.codccl = codccl;
	}
	public String getCbeccl() {
		return cbeccl;
	}
	public void setCbeccl(String cbeccl) {
		this.cbeccl = cbeccl;
	}
	public String getStaccl() {
		return staccl;
	}
	public void setStaccl(String staccl) {
		this.staccl = staccl;
	}
	public String getCboccl() {
		return cboccl;
	}
	public void setCboccl(String cboccl) {
		this.cboccl = cboccl;
	}
	public String getGurccl() {
		return gurccl;
	}
	public void setGurccl(String gurccl) {
		this.gurccl = gurccl;
	}
	public String getVigccl() {
		return vigccl;
	}
	public void setVigccl(String vigccl) {
		this.vigccl = vigccl;
	}
	public String getAmbccl() {
		return ambccl;
	}
	public void setAmbccl(String ambccl) {
		this.ambccl = ambccl;
	}
	public String getBomccl() {
		return bomccl;
	}
	public void setBomccl(String bomccl) {
		this.bomccl = bomccl;
	}
	public String getCatccl() {
		return catccl;
	}
	public void setCatccl(String catccl) {
		this.catccl = catccl;
	}
	public String getTraccl() {
		return traccl;
	}
	public void setTraccl(String traccl) {
		this.traccl = traccl;
	}
	public String getMeiccl() {
		return meiccl;
	}
	public void setMeiccl(String meiccl) {
		this.meiccl = meiccl;
	}
	public String getNieccl() {
		return nieccl;
	}
	public void setNieccl(String nieccl) {
		this.nieccl = nieccl;
	}
	public String getSecccl() {
		return secccl;
	}
	public void setSecccl(String secccl) {
		this.secccl = secccl;
	}
	public Date getDinccl() {
		return dinccl;
	}
	public void setDinccl(Date dinccl) {
		this.dinccl = dinccl;
	}
	public Date getDficcl() {
		return dficcl;
	}
	public void setDficcl(Date dficcl) {
		this.dficcl = dficcl;
	}
	public Integer getDemccl() {
		return demccl;
	}
	public void setDemccl(Integer demccl) {
		this.demccl = demccl;
	}
	public String getSedccl() {
		return sedccl;
	}
	public void setSedccl(String sedccl) {
		this.sedccl = sedccl;
	}
	public String getDivccl() {
		return divccl;
	}
	public void setDivccl(String divccl) {
		this.divccl = divccl;
	}
	public String getGrpccl() {
		return grpccl;
	}
	public void setGrpccl(String grpccl) {
		this.grpccl = grpccl;
	}
	public String getClaccl() {
		return claccl;
	}
	public void setClaccl(String claccl) {
		this.claccl = claccl;
	}
	public String getSclccl() {
		return sclccl;
	}
	public void setSclccl(String sclccl) {
		this.sclccl = sclccl;
	}
	public String getUrlccl() {
		return urlccl;
	}
	public void setUrlccl(String urlccl) {
		this.urlccl = urlccl;
	}
	public String getAltccl() {
		return altccl;
	}
	public void setAltccl(String altccl) {
		this.altccl = altccl;
	}
	public String getAlcccl() {
		return alcccl;
	}
	public void setAlcccl(String alcccl) {
		this.alcccl = alcccl;
	}
	public String getAlrccl() {
		return alrccl;
	}
	public void setAlrccl(String alrccl) {
		this.alrccl = alrccl;
	}
	public String getUsualt() {
		return usualt;
	}
	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}
	public Date getDatalt() {
		return datalt;
	}
	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}

	
}
