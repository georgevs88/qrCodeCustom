package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Evt", sequence = "seqevt")
public class EvtVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddevt; //iddevt
	private String codevt; //Código evento
	private String desevt; //Descrição evento
	
	public Long getIddevt() {
		return iddevt;
	}
	public void setIddevt(Long iddevt) {
		this.iddevt = iddevt;
	}
	public String getCodevt() {
		return codevt;
	}
	public void setCodevt(String codevt) {
		this.codevt = codevt;
	}
	public String getDesevt() {
		return desevt;
	}
	public void setDesevt(String desevt) {
		this.desevt = desevt;
	}


}
