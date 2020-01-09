package pmcg.fcn.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias(value = "sociosAdm")
public class SadsVO {
	@XStreamImplicit(itemFieldName = "socioAdministrador")
	private List<SadVO> socioAdministrador;

	public List<SadVO> getSocioAdministrador() {
		return socioAdministrador;
	}

	public void setSocioAdministrador(List<SadVO> socioAdministrador) {
		this.socioAdministrador = socioAdministrador;
	}
	
	
}
