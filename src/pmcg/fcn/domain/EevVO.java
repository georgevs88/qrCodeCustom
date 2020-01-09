package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Eev", sequence = "seqeev")
public class EevVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddeev; //iddvev
	private Long proeev; //processo
	private String eveeev; //codigo evento
	
	public Long getIddeev() {
		return iddeev;
	}
	public void setIddeev(Long iddeev) {
		this.iddeev = iddeev;
	}
	public Long getProeev() {
		return proeev;
	}
	public void setProeev(Long proeev) {
		this.proeev = proeev;
	}
	public String getEveeev() {
		return eveeev;
	}
	public void setEveeev(String eveeev) {
		this.eveeev = eveeev;
	}
	
	
}
