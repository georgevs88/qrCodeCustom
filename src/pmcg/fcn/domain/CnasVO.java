package pmcg.fcn.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias(value = "cnaes")
public class CnasVO {
	@XStreamImplicit(itemFieldName = "cnae")
	private List<CnaVO> cnae;

	public List<CnaVO> getCnae() {
		return cnae;
	}

	public void setCnae(List<CnaVO> cnae) {
		this.cnae = cnae;
	}
	
	
}
