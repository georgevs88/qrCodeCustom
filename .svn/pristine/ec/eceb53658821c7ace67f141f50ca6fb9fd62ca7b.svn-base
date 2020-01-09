package pmcg.imti.domain;

import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;
import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Estados", sequence = "SE_ITEMNFAVINA.NEXTVAL")
public class EstVO implements ConcorrenciaVO {
	@ZKId
	@ZKField(label = "Codest", artigo = "o", readonly = true, maxsize = 80, tooltip = "Sigla do Estado!")
	private Long codest; //CODIGO
	private String nomcom; //NOME COMPLETO
	private String nomres; //NOME RESUMIDO
	private String unifed; //UNIDADE FEDERATIVA
	private Date datalt; //
	private String codusualt; //
	private Integer numver; //

	public Long getCodest() {
		return codest;
	}

	public void setCodest(Long codest) {
		this.codest = codest;
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

	public String getUnifed() {
		return unifed;
	}

	public void setUnifed(String unifed) {
		this.unifed = unifed;
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

	public Integer getNumver() {
		return numver;
	}

	public void setNumver(Integer numver) {
		this.numver = numver;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unifed == null) ? 0 : unifed.hashCode());
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
		EstVO other = (EstVO) obj;
		if (unifed == null) {
			if (other.unifed != null)
				return false;
		} else if (!unifed.equals(other.unifed))
			return false;
		return true;
	}

	@Override
	public Date getAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAge(Date arg0) {
		// TODO Auto-generated method stub

	}

}
