package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Cfg", sequence = "seqcfg")
public class CfgVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcfg; //iddcfg
	private String parcfg; //NOME DO PARAMETRO
	private String valcfg; //VALOR DO PARAMETRO
	private String descfg; //DESCRICAO DO PARAMETRO
	
	public Long getIddcfg() {
		return iddcfg;
	}
	public void setIddcfg(Long iddcfg) {
		this.iddcfg = iddcfg;
	}
	public String getParcfg() {
		return parcfg;
	}
	public void setParcfg(String parcfg) {
		this.parcfg = parcfg;
	}
	public String getValcfg() {
		return valcfg;
	}
	public void setValcfg(String valcfg) {
		this.valcfg = valcfg;
	}
	public String getDescfg() {
		return descfg;
	}
	public void setDescfg(String descfg) {
		this.descfg = descfg;
	}

}
