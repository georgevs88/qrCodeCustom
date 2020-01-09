package pmcg.fcn.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import gerador.annotation.ZKEntity;

@ZKEntity(label = "Vib", sequence = "seqvib")
@XStreamAlias(value = "viabilidade")
public class VibVO {
	@XStreamAlias("protocolo") @XStreamAsAttribute
	private String pvivib; // protocolo
	@XStreamAlias("coleta") @XStreamAsAttribute	
	private CltVO coleta;
	
	public String getPvivib() {
		return pvivib;
	}
	public void setPvivib(String pvivib) {
		this.pvivib = pvivib;
	}
	public CltVO getColeta() {
		return coleta;
	}
	public void setColeta(CltVO coleta) {
		this.coleta = coleta;
	}
		
}
