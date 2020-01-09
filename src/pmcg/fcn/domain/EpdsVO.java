package pmcg.fcn.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias(value = "empreendimentos")
public class EpdsVO {

	@XStreamImplicit(itemFieldName = "empreendimento")
	private List<EpdVO> empreendimento;

	public List<EpdVO> getEmpreendimento() {
		return empreendimento;
	}

	public void setEmpreendimento(List<EpdVO> empreendimento) {
		this.empreendimento = empreendimento;
	}
	
	
}
