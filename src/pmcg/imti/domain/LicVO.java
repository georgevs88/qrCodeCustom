package pmcg.imti.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pmcg.imti.util.FormatUtils;

public class LicVO {

	private Integer codlic;
	private Integer codves;
	private Date datvallic;
	private String usualt;
	private Date datalt;
	private String obslic;
	private String prolic;
	private String arqlic;
	private Boolean datvisible;
	private Boolean datauxvisible;
	private Integer codvlv;
	private String sttlic;
	private Integer codtpd;
	private Integer codvtd;
	private Integer liclic;
	private String tiplic;
	private boolean habilitaOpc = false;

	private VesVO vesVO = new VesVO();
	//private VlvVO vlvVO = new VlvVO(); //VEICULOS
	//private TpdVO tpdVO = new TpdVO(); //Tipo de Documento
	//private VtdVO vtdVO = new VtdVO(); //Tipo de Documento

	public Integer getCodlic() {
		return this.codlic;
	}

	public Integer getCodves() {
		return this.codves;
	}

	public Date getDatvallic() {
		return this.datvallic;
	}

	public String getUsualt() {
		return this.usualt;
	}

	public Date getDatalt() {
		return this.datalt;
	}

	public String getObslic() {
		return this.obslic;
	}

	public void setCodlic(Integer codlic) {
		this.codlic = codlic;
	}

	public void setCodves(Integer codves) {
		this.codves = codves;
	}

	public void setDatvallic(Date datvallic) {
		this.datvallic = datvallic;
	}

	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}

	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}

	public void setObslic(String obslic) {
		if (obslic != null) {
			this.obslic = obslic.toUpperCase();
		} else {
			this.obslic = obslic;
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

	public String getProlic() {
		return prolic;
	}

	public void setProlic(String prolic) {
		if (prolic != null) {
			this.prolic = prolic.toUpperCase();
		} else {
			this.prolic = prolic;
		}
	}

	public String getArqlic() {
		return arqlic;
	}

	public void setArqlic(String arqlic) {
		if (arqlic != null) {
			this.arqlic = arqlic.toUpperCase();
		} else {
			this.arqlic = arqlic;
		}
	}

	public String getDataFormatada() {
		return FormatUtils.dateToString(this.datvallic);
	}

	public Integer getLiclic() {
		return liclic;
	}

	public void setLiclic(Integer liclic) {
		this.liclic = liclic;
	}

	public String getTiplic() {
		return tiplic;
	}

	public void setTiplic(String tiplic) {
		this.tiplic = tiplic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codlic == null) ? 0 : codlic.hashCode());
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
		LicVO other = (LicVO) obj;
		if (codlic == null) {
			if (other.codlic != null)
				return false;
		} else if (!codlic.equals(other.codlic))
			return false;
		return true;
	}

	public Boolean getDatvisible() {
		return datvisible;
	}

	public void setDatvisible(Boolean datvisible) {
		this.datvisible = datvisible;
	}

	public Boolean getDatauxvisible() {
		return datauxvisible;
	}

	public void setDatauxvisible(Boolean datauxvisible) {
		this.datauxvisible = datauxvisible;
	}

	public Integer getCodvlv() {
		return codvlv;
	}

	public void setCodvlv(Integer codvlv) {
		this.codvlv = codvlv;
	}

//	public VlvVO getVlvVO() {
//		return vlvVO;
//	}
//
//	public void setVlvVO(VlvVO vlvVO) {
//		if (vlvVO != null) {
//			this.vlvVO = vlvVO;
//			this.codvlv = vlvVO.getCodvlv();
//		} else {
//			this.vlvVO = new VlvVO();
//			this.codvlv = null;
//		}
//	}

	public String getSttlic() {
		return sttlic;
	}

	public void setSttlic(String sttlic) {
		if (sttlic != null) {
			this.sttlic = sttlic.toUpperCase();
		} else {
			this.sttlic = sttlic;
		}
	}

	public String getStatus() {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(), dataaux = null;

		try {
			dataaux = (Date) formatter.parse(formatter.format(data));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		if (this.sttlic.equals("A")) {
			if (this.datvallic != null) {
				if (this.datvallic.compareTo(dataaux) < 0) {
					return "VENCIDA";
				}
			}
			return "ATIVA";
		} else if (this.sttlic.equals("V")) {
			return "VENCIDA";
		} else {
			return "CANCELADA";

		}
	}

	public Integer getCodtpd() {
		return codtpd;
	}

	public void setCodtpd(Integer codtpd) {
		this.codtpd = codtpd;
	}

//	public TpdVO getTpdVO() {
//		return tpdVO;
//	}
//
//	public void setTpdVO(TpdVO tpdVO) {
//		if (tpdVO != null) {
//			this.tpdVO = tpdVO;
//			this.codtpd = tpdVO.getCodtpd();
//		} else {
//			this.codtpd = null;
//			this.tpdVO = new TpdVO();
//		}
//	}
//
//	public VtdVO getVtdVO() {
//		return vtdVO;
//	}
//
//	public void setVtdVO(VtdVO vtdVO) {
//		if (vtdVO != null) {
//			this.vtdVO = vtdVO;
//			this.codvtd = vtdVO.getCodvtd();
//		} else {
//			this.codvtd = null;
//			this.vtdVO = new VtdVO();
//		}
//	}

	public Integer getCodvtd() {
		return codvtd;
	}

	public void setCodvtd(Integer codvtd) {
		this.codvtd = codvtd;
	}

	public boolean isHabilitaOpc() {
		if (codvtd != null) {
			habilitaOpc = true;
		} else {
			habilitaOpc = false;
		}
		return habilitaOpc;
	}

	public void setHabilitaOpc(boolean habilitaOpc) {
		this.habilitaOpc = habilitaOpc;
	}

}