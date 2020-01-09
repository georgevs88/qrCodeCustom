package pmcg.imti.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;

public class VreVO implements ConcorrenciaVO {

	private Integer codvre;
	private Integer codvrl;
	private Integer codves;
	private Date datini;
	private Date datfim;
	private Integer codcar;
	private Date datalt;
	private String usualt;

	private VesVO vesVO;
	private VrlVO vrlVO; // representante legal
	private CarVO carVO; // cargo
	private Boolean privre;

	public Integer getCodvre() {
		return this.codvre;
	}

	public Integer getCodvrl() {
		return this.codvrl;
	}

	public Integer getCodves() {
		return this.codves;
	}

	public java.util.Date getDatini() {
		return this.datini;
	}

	public java.util.Date getDatfim() {
		return this.datfim;
	}

	public void setCodvre(Integer codvre) {
		this.codvre = codvre;
	}

	public void setCodvrl(Integer codvrl) {
		this.codvrl = codvrl;
	}

	public void setCodves(Integer codves) {
		this.codves = codves;
	}

	public void setDatini(Date datini) {
		this.datini = datini;
	}

	public void setDatfim(Date datfim) {
		this.datfim = datfim;
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
			this.vesVO = new VesVO();
		}
	}

	public VrlVO getVrlVO() {
		return vrlVO;
	}

	public void setVrlVO(VrlVO vrlVO) {
		if (vrlVO != null) {
			this.vrlVO = vrlVO;
			this.codvrl = vrlVO.getCodvrl();
		} else {
			this.codvrl = null;
			this.vrlVO = new VrlVO();
		}
	}

	public Integer getCodcar() {
		return codcar;
	}

	public void setCodcar(Integer codcar) {
		this.codcar = codcar;
	}

	public CarVO getCarVO() {
		return carVO;
	}

	public void setCarVO(CarVO carVO) {
		if (carVO != null) {
			this.carVO = carVO;
			this.codcar = carVO.getCodcar();
		} else {
			this.codcar = null;
			this.carVO = new CarVO();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codvre == null) ? 0 : codvre.hashCode());
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
		VreVO other = (VreVO) obj;
		if (codvre == null) {
			if (other.codvre != null)
				return false;
		} else if (!codvre.equals(other.codvre))
			return false;
		return true;
	}

	public String getDatiniformatada() {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		if (this.datini != null)
			return data.format(this.datini);
		else
			return "";
	}

	public String getDatfimformatada() {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		if (this.datfim != null)
			return data.format(this.datfim);
		else
			return "";
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

	public Boolean getPrivre() {
		return privre;
	}

	public void setPrivre(Boolean privre) {
		if (privre == null) {
			this.privre = Boolean.FALSE;
		} else {
			this.privre = privre;
		}
	}

	public String getLabelPrincipal() {
		if (this.privre.equals(Boolean.TRUE)) {
			return "SIM";
		} else if (this.privre.equals(Boolean.FALSE)) {
			return "N�O";
		} else {
			return "";
		}
	}

}