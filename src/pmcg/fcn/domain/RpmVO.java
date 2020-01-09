package pmcg.fcn.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Rpm", sequence = "seqrpm")
public class RpmVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddrpm; //iddrpm
	private Long pmarpm; //Processo
	private String esprpm; //Espécie
	private String tesrpm; //Tipo Espécie
	private Date datrpm; //Data requerimento
	private Integer numrpm; //Número requerimento
	private String usualt; //usualt
	private Date datalt; //datalt
	private Long lmarpm; //licenca gerada	
	private Double arerpm; //Área
	private String caprpm; //Capacidade
	private String latrpm; //Latitude
	private String lonrpm; //Longitude
	
	private String arerpmStr; //Área string
	
	public String getArerpmStr() {
		return arerpmStr;
	}
	public void setArerpmStr(String arerpmStr) {
		this.arerpmStr = arerpmStr;
	}
	public Double getArerpm() {
		return arerpm;
	}
	public void setArerpm(Double arerpm) {
		this.arerpm = arerpm;
	}
	public String getCaprpm() {
		return caprpm;
	}
	public void setCaprpm(String caprpm) {
		this.caprpm = caprpm;
	}
	public String getLatrpm() {
		return latrpm;
	}
	public void setLatrpm(String latrpm) {
		this.latrpm = latrpm;
	}
	public String getLonrpm() {
		return lonrpm;
	}
	public void setLonrpm(String lonrpm) {
		this.lonrpm = lonrpm;
	}

	private LmaVO lmaVO;
	
	public LmaVO getLmaVO() {
		return lmaVO;
	}
	public void setLmaVO(LmaVO lmaVO) {
		this.lmaVO = lmaVO;
	}
	public Long getLmarpm() {
		return lmarpm;
	}
	public void setLmarpm(Long lmarpm) {
		this.lmarpm = lmarpm;
	}
	public Long getIddrpm() {
		return iddrpm;
	}
	public void setIddrpm(Long iddrpm) {
		this.iddrpm = iddrpm;
	}
	public Long getPmarpm() {
		return pmarpm;
	}
	public void setPmarpm(Long pmarpm) {
		this.pmarpm = pmarpm;
	}
	public String getEsprpm() {
		return esprpm;
	}
	public void setEsprpm(String esprpm) {
		this.esprpm = esprpm;
	}
	public String getTesrpm() {
		return tesrpm;
	}
	public void setTesrpm(String tesrpm) {
		this.tesrpm = tesrpm;
	}
	public Date getDatrpm() {
		return datrpm;
	}
	public void setDatrpm(Date datrpm) {
		this.datrpm = datrpm;
	}
	public Integer getNumrpm() {
		return numrpm;
	}
	public void setNumrpm(Integer numrpm) {
		this.numrpm = numrpm;
	}
	public String getUsualt() {
		return usualt;
	}
	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}
	public Date getDatalt() {
		return datalt;
	}
	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}

	public String getData(){
		if(datrpm != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(datrpm);
		} else {
			return "";
		}
	}
}
