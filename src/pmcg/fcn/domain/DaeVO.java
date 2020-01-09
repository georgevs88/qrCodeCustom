package pmcg.fcn.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "desdobramentoAtividadeEconomica")
public class DaeVO {
	@XStreamAlias("codigo") @XStreamAsAttribute
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
