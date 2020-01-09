package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Ore", sequence = "seqrcl")
@XStreamAlias(value = "orgaoRegistro")
public class OreVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddore; //iddore
	
	@XStreamAlias("codigo") @XStreamAsAttribute
	private String codore; //codigo
	
	@XStreamAlias("nome") @XStreamAsAttribute
	private String nomore; //nome

	public Long getIddore() {
		return iddore;
	}

	public void setIddore(Long iddore) {
		this.iddore = iddore;
	}

	public String getCodore() {
		return codore;
	}

	public void setCodore(String codore) {
		this.codore = codore;
	}

	public String getNomore() {
		return nomore;
	}

	public void setNomore(String nomore) {
		this.nomore = nomore;
	}
	
	

}
