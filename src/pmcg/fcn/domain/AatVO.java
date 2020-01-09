package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Aat", sequence = "seqaat")
public class AatVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddaat; //iddaat
	private Long aenaat; //Chave Análise de Endereço
	private String cnaaat; //codigoCNAE
	private String staaat; //status
	private String usoaat; //usoConforme
	private Boolean exeaat; //exercida no local
	private String ambaat; //Risco Meio Ambiente
	private String bomaat; //Risco Bombeiros
	private String vigaat; //Risco Visgilancia Sanitaria
	private String posaat; //Risco Posturas
	private String traaat; //Risco Transito
	private String siaaat; //Risco SIA
	
	public Long getIddaat() {
		return iddaat;
	}
	public void setIddaat(Long iddaat) {
		this.iddaat = iddaat;
	}
	public String getCnaaat() {
		return cnaaat;
	}
	public void setCnaaat(String cnaaat) {
		this.cnaaat = cnaaat;
	}
	public Long getAenaat() {
		return aenaat;
	}
	public void setAenaat(Long aenaat) {
		this.aenaat = aenaat;
	}
	public String getStaaat() {
		return staaat;
	}
	public void setStaaat(String staaat) {
		this.staaat = staaat;
	}
	public String getUsoaat() {
		return usoaat;
	}
	public void setUsoaat(String usoaat) {
		this.usoaat = usoaat;
	}
	public String getAmbaat() {
		return ambaat;
	}
	public void setAmbaat(String ambaat) {
		this.ambaat = ambaat;
	}
	public String getBomaat() {
		return bomaat;
	}
	public void setBomaat(String bomaat) {
		this.bomaat = bomaat;
	}
	public String getVigaat() {
		return vigaat;
	}
	public void setVigaat(String vigaat) {
		this.vigaat = vigaat;
	}
	public String getPosaat() {
		return posaat;
	}
	public void setPosaat(String posaat) {
		this.posaat = posaat;
	}
	public String getTraaat() {
		return traaat;
	}
	public void setTraaat(String traaat) {
		this.traaat = traaat;
	}
	public String getSiaaat() {
		return siaaat;
	}
	public void setSiaaat(String siaaat) {
		this.siaaat = siaaat;
	}
	public Boolean getExeaat() {
		return exeaat;
	}
	public void setExeaat(Boolean exeaat) {
		this.exeaat = exeaat;
	}

}
