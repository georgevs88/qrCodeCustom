package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Tab", sequence = "seqtab")
public class TabVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddtab; //iddtab
	private String tabtab; //tabtab
	private String inftab; //inftab
	private String codtab; //codtab
	private String destab; //destab
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codtab == null) ? 0 : codtab.hashCode());
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
		TabVO other = (TabVO) obj;
		if (codtab == null) {
			if (other.codtab != null)
				return false;
		} else if (!codtab.equals(other.codtab))
			return false;
		return true;
	}
	public TabVO() {
		super();
	}
	public TabVO(String tabtab) {
		super();
		this.tabtab = tabtab;
	}
	public Long getIddtab() {
		return iddtab;
	}
	public void setIddtab(Long iddtab) {
		this.iddtab = iddtab;
	}
	public String getTabtab() {
		return tabtab;
	}
	public void setTabtab(String tabtab) {
		this.tabtab = tabtab;
	}
	public String getInftab() {
		return inftab;
	}
	public void setInftab(String inftab) {
		this.inftab = inftab;
	}
	public String getCodtab() {
		return codtab;
	}
	public void setCodtab(String codtab) {
		this.codtab = codtab;
	}
	public String getDestab() {
		return destab;
	}
	public void setDestab(String destab) {
		this.destab = destab;
	}

}
