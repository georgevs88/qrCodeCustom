package pmcg.fcn.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "coletaAtividadeEconomica")
public class CaeVO {
	@XStreamAlias("atividadeEconomica") @XStreamAsAttribute
	private AecVO atividadeEconomica; //atividadeEconomica
	@XStreamAlias("desdobramentoAtividadeEconomica") @XStreamAsAttribute
	private DaeVO desdobramentoAtividadeEconomica; //desdobramentoAtividadeEconomica
	@XStreamAlias("tipoAtividadeEconomica") @XStreamAsAttribute
	private String taecae; //tipoAtividadeEconomica
	@XStreamAlias("exercidaNoLocal") @XStreamAsAttribute
	private Boolean execae; //exercidaNoLocal
	
	public String getTaecae() {
		return taecae;
	}
	public void setTaecae(String taecae) {
		this.taecae = taecae;
	}
	public Boolean getExecae() {
		return execae;
	}
	public void setExecae(Boolean execae) {
		this.execae = execae;
	}
	public AecVO getAtividadeEconomica() {
		return atividadeEconomica;
	}
	public void setAtividadeEconomica(AecVO atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}
	public DaeVO getDesdobramentoAtividadeEconomica() {
		return desdobramentoAtividadeEconomica;
	}
	public void setDesdobramentoAtividadeEconomica(
			DaeVO desdobramentoAtividadeEconomica) {
		this.desdobramentoAtividadeEconomica = desdobramentoAtividadeEconomica;
	}
	
}
