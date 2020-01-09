package pmcg.imti.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Usu", sequence = "sequsu")
public class UsuVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long codusu; 
	private String logusu;
	private String nomusu;
	private Boolean atvusu;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codusu == null) ? 0 : codusu.hashCode());
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
		UsuVO other = (UsuVO) obj;
		if (codusu == null) {
			if (other.codusu != null)
				return false;
		} else if (!codusu.equals(other.codusu))
			return false;
		return true;
	}
	
	public Long getCodusu() {
		return codusu;
	}
	public void setCodusu(Long codusu) {
		this.codusu = codusu;
	}
	public String getLogusu() {
		return logusu;
	}
	public void setLogusu(String logusu) {
		this.logusu = logusu;
	}
	public String getNomusu() {
		return nomusu;
	}
	public void setNomusu(String nomusu) {
		this.nomusu = nomusu;
	}
	public Boolean getAtvusu() {
		return atvusu;
	}
	public void setAtvusu(Boolean atvusu) {
		this.atvusu = atvusu;
	}
	
	
}
