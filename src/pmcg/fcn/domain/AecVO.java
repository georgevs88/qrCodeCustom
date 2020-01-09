package pmcg.fcn.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "atividadeEconomica")
public class AecVO {
	@XStreamAlias("cnae") @XStreamAsAttribute
	private String cnae; //codigoCnae

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}
	
	

}
