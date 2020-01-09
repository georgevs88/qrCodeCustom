package pmcg.imti.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Cid", sequence = "seqcid")
public class CidVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	public Long codcid; //CODIGO CIDADE
	public String nomcom; //NOME COMPLETO
	public String nomres; //NOME RESUMIDO
	public Long codest; //CODIGO ESTADO
	public Date datalt;
	public String codusualt;
	public Long numver;
	public Long codcidant;
	public Long codsiafi;
	
	public Long getCodcid() {
		return codcid;
	}
	public void setCodcid(Long codcid) {
		this.codcid = codcid;
	}
	public String getNomcom() {
		return nomcom;
	}
	public void setNomcom(String nomcom) {
		this.nomcom = nomcom;
	}
	public String getNomres() {
		return nomres;
	}
	public void setNomres(String nomres) {
		this.nomres = nomres;
	}
	public Long getCodest() {
		return codest;
	}
	public void setCodest(Long codest) {
		this.codest = codest;
	}
	public Date getDatalt() {
		return datalt;
	}
	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}
	public String getCodusualt() {
		return codusualt;
	}
	public void setCodusualt(String codusualt) {
		this.codusualt = codusualt;
	}
	public Long getNumver() {
		return numver;
	}
	public void setNumver(Long numver) {
		this.numver = numver;
	}
	public Long getCodcidant() {
		return codcidant;
	}
	public void setCodcidant(Long codcidant) {
		this.codcidant = codcidant;
	}
	public Long getCodsiafi() {
		return codsiafi;
	}
	public void setCodsiafi(Long codsiafi) {
		this.codsiafi = codsiafi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codcid == null) ? 0 : codcid.hashCode());
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
		CidVO other = (CidVO) obj;
		if (codcid == null) {
			if (other.codcid != null)
				return false;
		} else if (!codcid.equals(other.codcid))
			return false;
		return true;
	}
	

}
