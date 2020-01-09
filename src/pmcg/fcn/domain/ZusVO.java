package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "fcnzus", sequence = "seqzus")
public class ZusVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Double iddzus; //iddzus
	private String zonzus; //zonzus
	private String usozus; //usozus
	private String usualt; //usualt
	private Date datalt; //datalt
	public Double getIddzus() {
		return iddzus;
	}
	public void setIddzus(Double iddzus) {
		this.iddzus = iddzus;
	}
	public String getZonzus() {
		return zonzus;
	}
	public void setZonzus(String zonzus) {
		this.zonzus = zonzus;
	}
	public String getUsozus() {
		return usozus;
	}
	public void setUsozus(String usozus) {
		this.usozus = usozus;
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
