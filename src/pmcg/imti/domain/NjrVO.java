package pmcg.imti.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Njr", sequence = "seqnjr")
public class NjrVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddnjr; //iddnjr
	private String codnjr; //Código Natureza juridica
	private String desnjr; //Descricao njr
	
	public Long getIddnjr() {
		return iddnjr;
	}
	public void setIddnjr(Long iddnjr) {
		this.iddnjr = iddnjr;
	}
	public String getCodnjr() {
		return codnjr;
	}
	public void setCodnjr(String codnjr) {
		this.codnjr = codnjr;
	}
	public String getDesnjr() {
		return desnjr;
	}
	public void setDesnjr(String desnjr) {
		this.desnjr = desnjr;
	}

	public String getCodDescNjr(){
		return codnjr + " - " + desnjr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codnjr == null) ? 0 : codnjr.hashCode());
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
		NjrVO other = (NjrVO) obj;
		if (codnjr == null) {
			if (other.codnjr != null)
				return false;
		} else if (!codnjr.equals(other.codnjr))
			return false;
		return true;
	}
	
}
