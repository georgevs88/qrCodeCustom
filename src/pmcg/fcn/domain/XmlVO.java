package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;

@ZKEntity(label = "Xml", sequence = "seqxml")
public class XmlVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddxml; //iddxml
	private String tipxml; //Tipo xml: V = Viabilidade, E=Empreendimento
	private String xmlxml; //XML recebido
	private String usualt; //usualt
	private Date datalt; //datalt
	
	public Long getIddxml() {
		return iddxml;
	}
	public void setIddxml(Long iddxml) {
		this.iddxml = iddxml;
	}
	public String getTipxml() {
		return tipxml;
	}
	public void setTipxml(String tipxml) {
		this.tipxml = tipxml;
	}
	public String getXmlxml() {
		return xmlxml;
	}
	public void setXmlxml(String xmlxml) {
		this.xmlxml = xmlxml;
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
