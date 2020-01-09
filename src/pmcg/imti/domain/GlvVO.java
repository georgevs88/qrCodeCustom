package pmcg.imti.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Glv", sequence = "seqglv")
public class GlvVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddglv; //iddglv
	private Long guiglv; //Código Guia SIAT
	private Long proglv; //idd processo (epd/bae)
	private String tipglv; //Tipo Processo E=EPD, B=BAE
	private String usualt; //usualt
	private Date datalt; //datalt
	
	public Long getIddglv() {
		return iddglv;
	}
	public void setIddglv(Long iddglv) {
		this.iddglv = iddglv;
	}
	public Long getGuiglv() {
		return guiglv;
	}
	public void setGuiglv(Long guiglv) {
		this.guiglv = guiglv;
	}
	public Long getProglv() {
		return proglv;
	}
	public void setProglv(Long proglv) {
		this.proglv = proglv;
	}
	public String getTipglv() {
		return tipglv;
	}
	public void setTipglv(String tipglv) {
		this.tipglv = tipglv;
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
