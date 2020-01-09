package pmcg.imti.domain;

import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;

public class VeaVO implements ConcorrenciaVO {

	private Integer codvea;
	private Integer codves;
	private Integer codvat;
	private Boolean principal;
	private Date datalt;
	private String usualt;

	private VesVO vesVO;
	private VatVO vatVO; // ATIVIDADES DA VIGILANCIA

	public Integer getCodvea() {
		return this.codvea;
	}

	public Integer getCodves() {
		return this.codves;
	}

	public Integer getCodvat() {
		return this.codvat;
	}

	public Boolean getPrincipal() {
		return this.principal;
	}

	public void setCodvea(Integer codvea) {
		this.codvea = codvea;
	}

	public void setCodves(Integer codves) {
		this.codves = codves;
	}

	public void setCodvat(Integer codvat) {
		this.codvat = codvat;
	}

	public void setPrincipal(Boolean principal) {
		if (principal == null) {
			this.principal = Boolean.FALSE;
		} else {
			this.principal = principal;
		}
	}

	public VesVO getVesVO() {
		return vesVO;
	}

	public void setVesVO(VesVO vesVO) {
		if (vesVO != null) {
			this.vesVO = vesVO;
			this.codves = vesVO.getCodves();
		} else {
			this.codves = null;
			vesVO = new VesVO();
		}
	}

	public VatVO getVatVO() {
		return vatVO;
	}

	public void setVatVO(VatVO vatVO) {
		if (vatVO != null) {
			this.vatVO = vatVO;
			this.codvat = vatVO.getCodvat();
		} else {
			this.codvat = null;
			vatVO = new VatVO();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codvea == null) ? 0 : codvea.hashCode());
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
		VeaVO other = (VeaVO) obj;
		if (codvea == null) {
			if (other.codvea != null)
				return false;
		} else if (!codvea.equals(other.codvea))
			return false;
		return true;
	}

	public String getLabelPrincipal() {
		if (this.principal.equals(Boolean.TRUE)) {
			return "SIM";
		} else {
			return "N�O";
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
	public Date getAge() {
		return datalt;
	}

	@Override
	public void setAge(Date age) {
		datalt = age;

	}

}