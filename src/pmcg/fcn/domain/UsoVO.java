package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Uso", sequence = "sequso")
public class UsoVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long idduso; //idduso
	private String coduso; //codigo uso
	private String desuso; //descricao uso
	private Integer orduso; //ordem
	private String usualt; //usualt
	private Date datalt; //datalt
	private Boolean atvuso; //ativo
	private String poruso; //porte
	private String decuso; //descrição completa com porte
	
	public Long getIdduso() {
		return idduso;
	}
	public void setIdduso(Long idduso) {
		this.idduso = idduso;
	}
	public String getCoduso() {
		return coduso;
	}
	public void setCoduso(String coduso) {
		this.coduso = coduso;
	}
	public String getDesuso() {
		return desuso;
	}
	public void setDesuso(String desuso) {
		this.desuso = desuso;
	}
	public Integer getOrduso() {
		return orduso;
	}
	public void setOrduso(Integer orduso) {
		this.orduso = orduso;
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
	public Boolean getAtvuso() {
		return atvuso;
	}
	public void setAtvuso(Boolean atvuso) {
		this.atvuso = atvuso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coduso == null) ? 0 : coduso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsoVO other = (UsoVO) obj;
		if (coduso == null) {
			if (other.coduso != null)
				return false;
		} else if (!coduso.equals(other.coduso))
			return false;
		return true;
	}
	public String getPoruso() {
		return poruso;
	}
	public void setPoruso(String poruso) {
		this.poruso = poruso;
	}
	public String getDecuso() {
		return decuso;
	}
	public void setDecuso(String decuso) {
		this.decuso = decuso;
	}

	
}
