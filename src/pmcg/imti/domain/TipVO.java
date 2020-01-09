package pmcg.imti.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Tip", sequence = "seqtipe")
public class TipVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private String codtip;
	private Long codarq;
	private String sistema;
	private String tipo;
	private String codigo;
	private String estati;
	private String desred;
	private String desres;
	private String descom;
	private Date datalt;
	private String codusualt;
	private Long numver;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codtip == null) ? 0 : codtip.hashCode());
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
		TipVO other = (TipVO) obj;
		if (codtip == null) {
			if (other.codtip != null)
				return false;
		} else if (!codtip.equals(other.codtip))
			return false;
		return true;
	}
	
	private String config;
	
	public String getCodtip() {
		return codtip;
	}
	public void setCodtip(String codtip) {
		this.codtip = codtip;
	}
	public Long getCodarq() {
		return codarq;
	}
	public void setCodarq(Long codarq) {
		this.codarq = codarq;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEstati() {
		return estati;
	}
	public void setEstati(String estati) {
		this.estati = estati;
	}
	public String getDesred() {
		return desred;
	}
	public void setDesred(String desred) {
		this.desred = desred;
	}
	public String getDesres() {
		return desres;
	}
	public void setDesres(String desres) {
		this.desres = desres;
	}
	public String getDescom() {
		return descom;
	}
	public void setDescom(String descom) {
		this.descom = descom;
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
	public Long getNumver() {
		return numver;
	}
	public void setNumver(Long numver) {
		this.numver = numver;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}

}
