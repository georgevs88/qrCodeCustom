package pmcg.fcn.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "processoEvento")
public class PevVO {
	@XStreamAlias("evento") @XStreamAsAttribute
	private EveVO evento;

	public EveVO getEvento() {
		return evento;
	}

	public void setEvento(EveVO evento) {
		this.evento = evento;
	}

	
}
