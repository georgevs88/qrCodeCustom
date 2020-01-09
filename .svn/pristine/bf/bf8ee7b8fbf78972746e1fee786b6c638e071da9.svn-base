package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;
import java.util.List;

@ZKEntity(label = "Aen", sequence = "seqaen")
public class AenVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddaen; //iddaen
	private String proaen; //protocolo viabilidade
	private String sitaen; //situacao analise endereco
	private Date valaen; //dataValidadeAnalise
	private String docaen; //documentacao
	private String oriaen; //orientacao
	private String jusaen; //justificativa
	private String obsaen; //observacao
	private String taxaen; //taxa
	private Date dataen; //data analise
	private String usualt; 
	private String zonaen; //zona(s) em que o imóvel se enquadrou
	private String usoaen; //usos em que o imóvel se enquadrou
	private String timaen; //tipo de imóvel que se enquadrou
	private String risaen; //Risco Geral da Análise de Endereço
	private String ambaen; //Risco Geral da Análise de Endereço
	private String bomaen; //Risco Geral da Análise de Endereço
	private String vigaen; //Risco Geral da Análise de Endereço
	private String posaen; //Risco Geral da Análise de Endereço
	private String traaen; //Risco Geral da Análise de Endereço
	private String siaaen; //Risco Geral da Análise de Endereço
	
	private List<AatVO> listAat; //Lista de analise de atividades
		
	public String getUsualt() {
		return usualt;
	}
	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}
	public List<AatVO> getListAat() {
		return listAat;
	}
	public void setListAat(List<AatVO> listAat) {
		this.listAat = listAat;
	}
	public Long getIddaen() {
		return iddaen;
	}
	public void setIddaen(Long iddaen) {
		this.iddaen = iddaen;
	}
	
	public String getSitaen() {
		return sitaen;
	}
	public void setSitaen(String sitaen) {
		this.sitaen = sitaen;
	}
	public String getStyleSit(){
		if(sitaen != null){
			if(sitaen.equalsIgnoreCase("Deferida")){
				return "font-size:12px;font-weight:bold;color:rgb(0,128,0)";
			} else if(sitaen.equalsIgnoreCase("Indeferida")){
				return "font-size:12px;font-weight:bold;color:rgb(209,0,0)";
			} else {
				return "font-size:12px;font-weight:bold;color:rgb(201,161,0)";
			}
		} else {
			return "font-size:12px;font-weight:bold;";
		}
	}
	public String getProaen() {
		return proaen;
	}
	public void setProaen(String proaen) {
		this.proaen = proaen;
	}
	public Date getValaen() {
		return valaen;
	}
	public void setValaen(Date valaen) {
		this.valaen = valaen;
	}
	public String getDocaen() {
		return docaen;
	}
	public void setDocaen(String docaen) {
		this.docaen = docaen;
	}
	public String getOriaen() {
		return oriaen;
	}
	public void setOriaen(String oriaen) {
		this.oriaen = oriaen;
	}
	public String getJusaen() {
		return jusaen;
	}
	public void setJusaen(String jusaen) {
		this.jusaen = jusaen;
	}
	public String getObsaen() {
		return obsaen;
	}
	public void setObsaen(String obsaen) {
		this.obsaen = obsaen;
	}
	public String getTaxaen() {
		return taxaen;
	}
	public void setTaxaen(String taxaen) {
		this.taxaen = taxaen;
	}
	public Date getDataen() {
		return dataen;
	}
	public void setDataen(Date dataen) {
		this.dataen = dataen;
	}
	public String getZonaen() {
		return zonaen;
	}
	public void setZonaen(String zonaen) {
		this.zonaen = zonaen;
	}
	public String getUsoaen() {
		return usoaen;
	}
	public void setUsoaen(String usoaen) {
		this.usoaen = usoaen;
	}
	public String getTimaen() {
		return timaen;
	}
	public void setTimaen(String timaen) {
		this.timaen = timaen;
	}
	public String getRisaen() {
		return risaen;
	}
	public void setRisaen(String risaen) {
		this.risaen = risaen;
	}
	public String getAmbaen() {
		return ambaen;
	}
	public void setAmbaen(String ambaen) {
		this.ambaen = ambaen;
	}
	public String getBomaen() {
		return bomaen;
	}
	public void setBomaen(String bomaen) {
		this.bomaen = bomaen;
	}
	public String getVigaen() {
		return vigaen;
	}
	public void setVigaen(String vigaen) {
		this.vigaen = vigaen;
	}
	public String getPosaen() {
		return posaen;
	}
	public void setPosaen(String posaen) {
		this.posaen = posaen;
	}
	public String getTraaen() {
		return traaen;
	}
	public void setTraaen(String traaen) {
		this.traaen = traaen;
	}
	public String getSiaaen() {
		return siaaen;
	}
	public void setSiaaen(String siaaen) {
		this.siaaen = siaaen;
	}
	public String getRiscoAmb(){
		return getRisco(ambaen);
	}
	public String getRiscoBom(){
		return getRisco(bomaen);
	}
	public String getRiscoVig(){
		return getRisco(vigaen);
	}
	public String getRiscoPos(){
		return getRisco(posaen);
	}
	public String getRiscoTra(){
		return getRisco(traaen);
	}
	public String getRiscoSia(){
		return getRisco(siaaen);
	}
	public String getRisco(String risco){
		if(risco!=null && risco.equalsIgnoreCase("A")){
			return "ALTO";
		} else if(risco!=null && risco.equalsIgnoreCase("M")){
			return "MÉDIO";
		} else if(risco!=null && risco.equalsIgnoreCase("B")){
			return "BAIXO";
		} else {
			return "";
		}
	}

}
