package pmcg.imti.domain;

import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;

public class VrlVO implements ConcorrenciaVO{

	private Integer codvrl;
	private String nomvrl;
	private String cpfvrl;
	private Date datalt;
	private String usualt;

	public Integer getCodvrl() {
		return this.codvrl;
	}

	public String getNomvrl() {
		return this.nomvrl;
	}

	public String getCpfvrl() {
		return this.cpfvrl;
	}

	public void setCodvrl(Integer codvrl) {
		this.codvrl = codvrl;
	}

	public void setNomvrl(String nomvrl) {
		if(nomvrl != null){
			this.nomvrl = nomvrl.toUpperCase();
		}else{
			this.nomvrl = nomvrl;
		}
	}

	public void setCpfvrl(String cpfvrl) {
		this.cpfvrl = cpfvrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codvrl == null) ? 0 : codvrl.hashCode());
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
		VrlVO other = (VrlVO) obj;
		if (codvrl == null) {
			if (other.codvrl != null)
				return false;
		} else if (!codvrl.equals(other.codvrl))
			return false;
		return true;
	}

	public Date getDatalt() {
		return datalt;
	}

	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}

	public String getUsualt() {
		return usualt;
	}

	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}

	@Override
	public Date getAge() {
		return datalt;
	}

	@Override
	public void setAge(Date age) {
		datalt = age;
		
	}

}