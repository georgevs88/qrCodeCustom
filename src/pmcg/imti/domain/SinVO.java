package pmcg.imti.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Sin", sequence = "seqsin")
public class SinVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Integer codsin; //COD. SINDICATO/CONSELHO
	private String sigla; //SIGLA
	private String nomcom; //NOME COMPLETO
	private Date datfim;
	private Date datalt;
	private String codusualt;
	private Long numver;
	
	public String getSiglaNome(){
		return sigla + " - " + nomcom;
	}
	public Integer getCodsin() {
		return codsin;
	}
	public void setCodsin(Integer codsin) {
		this.codsin = codsin;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNomcom() {
		return nomcom;
	}
	public void setNomcom(String nomcom) {
		this.nomcom = nomcom;
	}
	public Date getDatfim() {
		return datfim;
	}
	public void setDatfim(Date datfim) {
		this.datfim = datfim;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codsin == null) ? 0 : codsin.hashCode());
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
		SinVO other = (SinVO) obj;
		if (codsin == null) {
			if (other.codsin != null)
				return false;
		} else if (!codsin.equals(other.codsin))
			return false;
		return true;
	}
	
	

}
