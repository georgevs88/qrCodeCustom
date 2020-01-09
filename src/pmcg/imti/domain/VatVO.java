package pmcg.imti.domain;

import java.util.Date;

import pmcg.fcn.domain.SerVO;
import pmcg.framework.domain.ConcorrenciaVO;

public class VatVO implements ConcorrenciaVO{

	private Integer codvat;
	private String desvat;
	private String comvat;
	private String cnae;
	private Date datalt;
	private String usualt;
	private Integer codser;
	private SerVO serVO;
	private Integer cnae_id;
//	private CnaeClasseVO cnaeClasseVO;
	

	public Integer getCodvat() {
		return codvat;
	}

	public void setCodvat(Integer codvat) {
		this.codvat = codvat;
	}

	public String getDesvat() {
		return desvat;
	}

	public void setDesvat(String desvat) {
		if (desvat != null) {
			this.desvat = desvat.toUpperCase();
		} else {
			this.desvat = desvat;
		}
	}

	public String getComvat() {
		return comvat;
	}

	public void setComvat(String comvat) {
		if (comvat != null) {
			this.comvat = comvat.toUpperCase();
		} else {
			this.comvat = comvat;
		}
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
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

	public Integer getCodser() {
		return codser;
	}

	public void setCodser(Integer codser) {
		this.codser = codser;
	}

	public SerVO getSerVO() {
		return serVO;
	}

	public void setSerVO(SerVO serVO) {
		if (serVO != null){
			this.serVO = serVO;
			this.codser = serVO.getCodser();
		}else{
			this.serVO = new SerVO();
			this.codser = null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codvat == null) ? 0 : codvat.hashCode());
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
		VatVO other = (VatVO) obj;
		if (codvat == null) {
			if (other.codvat != null)
				return false;
		} else if (!codvat.equals(other.codvat))
			return false;
		return true;
	}

	@Override
	public Date getAge() {
		return datalt;
	}

	@Override
	public void setAge(Date age) {
		datalt = age;
		
	}

	public Integer getCnae_id() {
		return cnae_id;
	}


	public void setCnae_id(Integer cnae_id) {
		this.cnae_id = cnae_id;
	}

//	public CnaeClasseVO getCnaeClasseVO() {
//		return cnaeClasseVO;
//	}
//
//	public void setCnaeClasseVO(CnaeClasseVO cnaeClasseVO) {
//		if (cnaeClasseVO != null){
//			this.cnaeClasseVO = cnaeClasseVO;
//			this.cnae_id = cnaeClasseVO.getCnae_id();
//		}else{
//			this.cnaeClasseVO = new CnaeClasseVO();
//			this.cnae_id = null;
//			
//		}
//	}
	
	
}
