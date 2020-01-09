package pmcg.imti.domain;

import java.util.Date;

public class CarVO {

	private Integer codcar;
	private String descar;
	private Date datalt;
	private String usualt;

	public Integer getCodcar() {
		return this.codcar;
	}

	public String getDescar() {
		return this.descar;
	}

	public void setCodcar(Integer codcar) {
		this.codcar = codcar;
	}

	public void setDescar(String descar) {
		if (descar != null) {
			this.descar = descar.toUpperCase();
		} else {
			this.descar = descar;
		}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codcar == null) ? 0 : codcar.hashCode());
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
		CarVO other = (CarVO) obj;
		if (codcar == null) {
			if (other.codcar != null)
				return false;
		} else if (!codcar.equals(other.codcar))
			return false;
		return true;
	}

}