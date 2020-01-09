package pmcg.fcn.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias(value = "representantesLegais")
public class RepsVO {
	@XStreamImplicit(itemFieldName = "representanteLegal")
	private List<RepVO> repsLegais;

	public List<RepVO> getRepsLegais() {
		return repsLegais;
	}

	public void setRepsLegais(List<RepVO> repsLegais) {
		this.repsLegais = repsLegais;
	}

	
	
}
