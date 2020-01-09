package pmcg.fcn.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Pma", sequence = "seqpma")
public class PmaVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddpma; //iddpma
	private String prapma; //Nr processo administrativo - SEMADUR
	private String prjpma; //Nr processo constituição- JUCEMS
	private Long epdpma; //iddepd
	private Date datpma; //Data requerimento
	private String reqpma; //Requerente
	private String atvpma; //Atividade
	private String edrpma; //Endereço
	private String usualt; //usualt
	private Date datalt; //datalt
	private String obspma; //Observacoes
	private Integer anopma; //Ano
	private String regpma; //Região
	private Long viapma; //Viabilidade
	
	private List<RpmVO> listRpm;

	public Long getIddpma() {
		return iddpma;
	}

	public void setIddpma(Long iddpma) {
		this.iddpma = iddpma;
	}

	public String getPrapma() {
		return prapma;
	}


	public void setPrapma(String prapma) {
		this.prapma = prapma;
	}


	public String getPrjpma() {
		return prjpma;
	}


	public void setPrjpma(String prjpma) {
		this.prjpma = prjpma;
	}


	public Date getDatpma() {
		return datpma;
	}


	public void setDatpma(Date datpma) {
		this.datpma = datpma;
	}


	public String getReqpma() {
		return reqpma;
	}


	public void setReqpma(String reqpma) {
		this.reqpma = reqpma;
	}


	public String getAtvpma() {
		return atvpma;
	}


	public void setAtvpma(String atvpma) {
		this.atvpma = atvpma;
	}


	public String getEdrpma() {
		return edrpma;
	}


	public void setEdrpma(String edrpma) {
		this.edrpma = edrpma;
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


	public String getObspma() {
		return obspma;
	}


	public void setObspma(String obspma) {
		this.obspma = obspma;
	}


	public Integer getAnopma() {
		return anopma;
	}


	public void setAnopma(Integer anopma) {
		this.anopma = anopma;
	}


	public String getData(){
		if(datpma != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(datpma);
		} else {
			return "";
		}
	}

	public Long getEpdpma() {
		return epdpma;
	}

	public void setEpdpma(Long epdpma) {
		this.epdpma = epdpma;
	}

	public List<RpmVO> getListRpm() {
		return listRpm;
	}

	public void setListRpm(List<RpmVO> listRpm) {
		this.listRpm = listRpm;
	}

	public String getRegpma() {
		return regpma;
	}

	public void setRegpma(String regpma) {
		this.regpma = regpma;
	}

	public Long getViapma() {
		return viapma;
	}

	public void setViapma(Long viapma) {
		this.viapma = viapma;
	}
	
}
