package pmcg.fcn.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "pais")
public class PaiVO {
	
	@XStreamAlias("codigoRFB") @XStreamAsAttribute
	private Long codigoRFB;

	public Long getCodigoRFB() {
		return codigoRFB;
	}

	public void setCodigoRFB(Long codigoRFB) {
		this.codigoRFB = codigoRFB;
	}
	
	
}
