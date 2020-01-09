package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Cfa", sequence = "seqcfa")
@XStreamAlias(value = "coletaTipoUnidadeFormaAtuacao")
public class CfaVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcfa; //iddcfa
	private Long colcfa; //coleta
	private String codcfa; //codigo
	
	@XStreamAlias("codigo") @XStreamAsAttribute
	private String codigo; //codigo
	
	public Long getIddcfa() {
		return iddcfa;
	}
	public void setIddcfa(Long iddcfa) {
		this.iddcfa = iddcfa;
	}
	public Long getColcfa() {
		return colcfa;
	}
	public void setColcfa(Long colcfa) {
		this.colcfa = colcfa;
	}
	public String getCodcfa() {
		return codcfa;
	}
	public void setCodcfa(String codcfa) {
		this.codcfa = codcfa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
