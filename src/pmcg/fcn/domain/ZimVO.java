package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Zona - Imóvel", sequence = "seqzim")
public class ZimVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddzim; //iddzim
	private String zonzim; //codigo zona
	private String imozim; //inscricao imobiliaria
	private Integer munzim; //municipio
	private String altzim; //alterado
	private String usualt; //usualt
	private Date datalt; //datalt
	
	public Long getIddzim() {
		return iddzim;
	}
	public void setIddzim(Long iddzim) {
		this.iddzim = iddzim;
	}
	public String getZonzim() {
		return zonzim;
	}
	public void setZonzim(String zonzim) {
		this.zonzim = zonzim;
	}
	public String getImozim() {
		return imozim;
	}
	public void setImozim(String imozim) {
		this.imozim = imozim;
	}
	public Integer getMunzim() {
		return munzim;
	}
	public void setMunzim(Integer munzim) {
		this.munzim = munzim;
	}
	public String getAltzim() {
		return altzim;
	}
	public void setAltzim(String altzim) {
		this.altzim = altzim;
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
