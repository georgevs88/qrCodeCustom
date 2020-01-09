package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;

@ZKEntity(label = "fcncai", sequence = "seqcai")
public class CaiVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcai; //iddcai
	private String nprcai; //numeroProcesso - protocoloFCNRE
	private String sitcai; //codSituacao - D=Deferido, E=Em Exigencia, I=Indeferido, P=Parcialmente deferido
	private String motcai; //motivo - Apenas para situacao E e I
	private String imucai; //inscricaoMunicipal - Apenas para situacao D e P
	private String alvcai; //alvara - Apenas para situacao D e P
	private Date datcai; //data Confirmacao
	private Boolean dcocai; //documentos conferidos
	private String usualt; //PARA BAE
	private Date datalt; //PARA BAE
	
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
	public Long getIddcai() {
		return iddcai;
	}
	public void setIddcai(Long iddcai) {
		this.iddcai = iddcai;
	}
	public String getNprcai() {
		return nprcai;
	}
	public void setNprcai(String nprcai) {
		this.nprcai = nprcai;
	}
	public String getSitcai() {
		return sitcai;
	}
	public void setSitcai(String sitcai) {
		this.sitcai = sitcai;
	}
	public String getMotcai() {
		return motcai;
	}
	public void setMotcai(String motcai) {
		this.motcai = motcai;
	}
	public String getImucai() {
		return imucai;
	}
	public void setImucai(String imucai) {
		this.imucai = imucai;
	}
	public String getAlvcai() {
		return alvcai;
	}
	public void setAlvcai(String alvcai) {
		this.alvcai = alvcai;
	}
	public Date getDatcai() {
		return datcai;
	}
	public void setDatcai(Date datcai) {
		this.datcai = datcai;
	}
	public Boolean getDcocai() {
		return dcocai;
	}
	public void setDcocai(Boolean dcocai) {
		this.dcocai = dcocai;
	}

}
