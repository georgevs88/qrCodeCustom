package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Lvs", sequence = "seqlvs")
public class LvsVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddlvs; //iddlvs
	private Long epdlvs; //Empreendimento
	private Integer veslvs; //codves (sosweb - tabela sosves) - Estabelecimento
	private Integer liclvs; //codves (sosweb - tabela sosves) - Estabelecimento
	private String usualt;
	private Date datalt;
	
	public Long getEpdlvs() {
		return epdlvs;
	}
	public void setEpdlvs(Long epdlvs) {
		this.epdlvs = epdlvs;
	}
	public Long getIddlvs() {
		return iddlvs;
	}
	public void setIddlvs(Long iddlvs) {
		this.iddlvs = iddlvs;
	}
	public Integer getVeslvs() {
		return veslvs;
	}
	public void setVeslvs(Integer veslvs) {
		this.veslvs = veslvs;
	}
	public Integer getLiclvs() {
		return liclvs;
	}
	public void setLiclvs(Integer liclvs) {
		this.liclvs = liclvs;
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
