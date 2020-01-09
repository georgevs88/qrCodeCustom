package pmcg.imti.domain;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;

public class VesVO implements ConcorrenciaVO {

	private Integer codves;// SERIAL, codigo
	private String tipves;// VARCHAR(1) NOT NULL,
	private Integer setves;// INTEGER NOT NULL,
	private Integer coddis;// INTEGER NOT NULL,
	private String razves;// VARCHAR(60) NOT NULL,
	private String nofves;// VARCHAR(60) NOT NULL, nome fantasia
	private String cpfves;// VARCHAR(11) NOT NULL,
	private String cnpves;// VARCHAR(14) NOT NULL, cnpj
	private String imuves;// VARCHAR(13) NOT NULL, Inscriçao municipal
	private String ineves;// VARCHAR(13) NOT NULL,
	private Date dtives;// DATE NOT NULL,
	private String cepves;// VARCHAR(8) NOT NULL, Cep estabelecimento
	private String comves;// VARCHAR(50) NOT NULL,
	private String nroves;// VARCHAR(7) NOT NULL, Numero estabelecimento
	private String telves;// VARCHAR(30) NOT NULL,
	private String emaves;// VARCHAR(60) NOT NULL,
	private Integer esgves;// INTEGER NOT NULL,
	private Date datalt;// TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	private String usualt;// VARCHAR(12) NOT NULL,
	private Date datultvis;// TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	private Integer codnat;
	private String sttves;
	private Long codtiplog;
	private Long codlog;
	private Long codbai;
	private Long codcid;
	private Long coduf;
	private String letves;
	private String teaves;
	private String senves;
	private String licves;
	
	private boolean validarInscricaoMunicipal;
	private boolean validarInscricaoMunicipalButton;
	
	//private DisVO disVO = new DisVO(); //DISTRITO SAN
	//private NatVO natVO = new NatVO(); //NATUREZA JUR
 	
	public boolean getValidarInscricaoMunicipal() {
		return validarInscricaoMunicipal;
	}

	
	public String getLicves() {
		return licves;
	}


	public void setLicves(String licves) {
		this.licves = licves;
	}


	public void setValidarInscricaoMunicipal(boolean validarInscricaoMunicipal) {
		this.validarInscricaoMunicipal = validarInscricaoMunicipal;
	}


	public void setValidarInscricaoMunicipalButton(
			boolean validarInscricaoMunicipalButton) {
		this.validarInscricaoMunicipalButton = validarInscricaoMunicipalButton;
	}


	public boolean getValidarInscricaoMunicipalButton() {
		return validarInscricaoMunicipalButton;
	}

	
//	public DisVO getDisVO() {
//		return disVO;
//	}
//
//	public void setDisVO(DisVO disVO) {
//		if (disVO != null) {
//			this.disVO = disVO;
//			this.coddis = disVO.getCoddis();
//		} else {
//			this.disVO = new DisVO();
//			this.coddis = null;
//		}
//	}

	public Integer getCodves() {
		return codves;
	}

	public void setCodves(Integer codves) {
		this.codves = codves;
	}

	public String getTipves() {
		return tipves;
	}

	public void setTipves(String tipves) {
		this.tipves = tipves;
	}

	public Integer getSetves() {
		return setves;
	}

	public void setSetves(Integer setves) {
		this.setves = setves;
	}

	public Integer getCoddis() {
		return coddis;
	}

	public void setCoddis(Integer coddis) {
		this.coddis = coddis;
	}

	public String getRazves() {
		return razves;
	}

	public void setRazves(String razves) {
		if (razves != null) {
			this.razves = razves.toUpperCase();
		} else {
			this.razves = razves;
		}
	}

	public String getNofves() {
		return nofves;
	}

	public void setNofves(String nofves) {
		if (nofves != null) {
			this.nofves = nofves.toUpperCase();
		} else {
			this.nofves = nofves;
		}
	}

	public String getCpfves() {
		return cpfves;
	}

	public void setCpfves(String cpfves) {
		this.cpfves = cpfves;
	}

	public String getCnpves() {
		return cnpves;
	}

	public void setCnpves(String cnpves) {
		this.cnpves = cnpves;
	}

	public String getImuves() {
		return imuves;
	}

	public void setImuves(String imuves) {
		this.imuves = imuves;
	}

	public String getIneves() {
		return ineves;
	}

	public void setIneves(String ineves) {
		this.ineves = ineves;
	}

	public Date getDtives() {
		return dtives;
	}

	public void setDtives(Date dtives) {
		this.dtives = dtives;
	}

	public String getCepves() {
		return cepves;
	}

	public void setCepves(String cepves) {
		this.cepves = cepves;
	}

	public String getComves() {
		return comves;
	}

	public void setComves(String comves) {
		if (comves != null) {
			this.comves = comves.toUpperCase();
		} else {
			this.comves = comves;
		}
	}

	public String getNroves() {
		return nroves;
	}

	public void setNroves(String nroves) {
		this.nroves = nroves;
	}

	public String getTelves() {
		return telves;
	}

	public void setTelves(String telves) {
		this.telves = telves;
	}

	public String getEmaves() {
		return emaves;
	}

	public void setEmaves(String emaves) {
		this.emaves = emaves;
	}

	public Integer getEsgves() {
		return esgves;
	}

	public void setEsgves(Integer esgves) {
		this.esgves = esgves;
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

	public Integer getCodnat() {
		return codnat;
	}

	public void setCodnat(Integer codnat) {
		this.codnat = codnat;
	}

//	public NatVO getNatVO() {
//		return natVO;
//	}
//
//	public void setNatVO(NatVO natVO) {
//		if (natVO != null) {
//			this.natVO = natVO;
//			this.codnat = natVO.getCodnat();
//		} else {
//			this.codnat = null;
//			this.natVO = new NatVO();
//		}
//	}

	// transformar campos strings para maiúscula.
	public void toUpperCase() {
		try {
			for (Field f : getClass().getDeclaredFields()) {
				if (f.getType().equals(String.class)) {
					if (f.get(this) != null) {
						f.set(this, f.get(this).toString().toUpperCase());
					}
				}
			}
		} catch (IllegalAccessException exc) {
			exc.printStackTrace();
		}
	}

	public Date getDatultvis() {
		return datultvis;
	}

	public void setDatultvis(Date datultvis) {
		this.datultvis = datultvis;
	}

	public String getDatAltFormatada() {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		if (this.datalt != null)
			return data.format(this.datalt);
		else
			return "";
	}

	public String getSttves() {
		return sttves;
	}

	public void setSttves(String sttves) {
		if (sttves != null) {
			this.sttves = sttves.toUpperCase();
		} else {
			this.sttves = sttves;
		}
	}

	@Override
	public Date getAge() {
		return datalt;
	}

	@Override
	public void setAge(Date age) {
		datalt = age;

	}

	public String getStatus() {
		if (this.sttves.equals("I")) {
			return "INATIVO";
		} else {
			return "ATIVO";
		}
	}

	public Long getCodtiplog() {
		return codtiplog;
	}

	public void setCodtiplog(Long codtiplog) {
		this.codtiplog = codtiplog;
	}

	public Long getCodlog() {
		return codlog;
	}

	public void setCodlog(Long codlog) {
		this.codlog = codlog;
	}

	public Long getCodbai() {
		return codbai;
	}

	public void setCodbai(Long codbai) {
		this.codbai = codbai;
	}

	public Long getCodcid() {
		return codcid;
	}

	public void setCodcid(Long codcid) {
		this.codcid = codcid;
	}

	public Long getCoduf() {
		return coduf;
	}

	public void setCoduf(Long coduf) {
		this.coduf = coduf;
	}

	public String getLetves() {
		return letves;
	}

	public void setLetves(String letves) {
		this.letves = letves;
	}
	
	
	public String getTeaves() {
		return teaves;
	}

	public void setTeaves(String teaves) {
		this.teaves = teaves;
	}
	
	
	public String getSenves() {
		return senves;
	}

	public void setSenves(String senves) {
		this.senves = senves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codves == null) ? 0 : codves.hashCode());
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
		VesVO other = (VesVO) obj;
		if (codves == null) {
			if (other.codves != null)
				return false;
		} else if (!codves.equals(other.codves))
			return false;
		return true;
	}

}