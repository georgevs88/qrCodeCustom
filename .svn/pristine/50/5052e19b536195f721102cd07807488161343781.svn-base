package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Rcl", sequence = "seqrcl")
@XStreamAlias(value = "resultadoClassificacao")
public class RclVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddrcl; //iddrcl
	
	@XStreamAlias("avaliacaoBombeiro") @XStreamAsAttribute
	private String bomrcl; //avaliacaoBombeiro
	
	@XStreamAlias("avaliacaoSemad") @XStreamAsAttribute
	private String semrcl; //avaliacaoSemad
	
	@XStreamAlias("avaliacaoVisa") @XStreamAsAttribute
	private String visrcl; //avaliacaoVisa
	
	public Long getIddrcl() {
		return iddrcl;
	}
	public void setIddrcl(Long iddrcl) {
		this.iddrcl = iddrcl;
	}
	public String getBomrcl() {
		return bomrcl;
	}
	public void setBomrcl(String bomrcl) {
		this.bomrcl = bomrcl;
	}
	public String getSemrcl() {
		return semrcl;
	}
	public void setSemrcl(String semrcl) {
		this.semrcl = semrcl;
	}
	public String getVisrcl() {
		return visrcl;
	}
	public void setVisrcl(String visrcl) {
		this.visrcl = visrcl;
	}

}
