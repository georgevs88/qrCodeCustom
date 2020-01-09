package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Cpe", sequence = "seqcpe")
@XStreamAlias(value = "coletaPergunta")
public class CpeVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcpe; //iddcpe
	private Long colcpe; //coleta
	private String copcpe; //codigoPergunta
	private String depcpe; //descricaoPergunta
	
	@XStreamAlias("pergunta") @XStreamAsAttribute
	private PerVO pergunta; //pergunta
	@XStreamAlias("descricaoResposta") @XStreamAsAttribute
	private String descpe; //descricaoResposta
	
	public PerVO getPergunta() {
		return pergunta;
	}
	public void setPergunta(PerVO pergunta) {
		this.pergunta = pergunta;
	}
	public Long getIddcpe() {
		return iddcpe;
	}
	public void setIddcpe(Long iddcpe) {
		this.iddcpe = iddcpe;
	}
	public Long getColcpe() {
		return colcpe;
	}
	public void setColcpe(Long colcpe) {
		this.colcpe = colcpe;
	}
	public String getCopcpe() {
		return copcpe;
	}
	public void setCopcpe(String copcpe) {
		this.copcpe = copcpe;
	}
	public String getDescpe() {
		return descpe;
	}
	public void setDescpe(String descpe) {
		this.descpe = descpe;
	}
	public String getDepcpe() {
		return depcpe;
	}
	public void setDepcpe(String depcpe) {
		this.depcpe = depcpe;
	}
	public String getDescricaoResposta(){
		if(descpe != null){
			if(descpe.equalsIgnoreCase("TRUE")){
				return "SIM";
			} else if(descpe.equalsIgnoreCase("FALSE")){
				return "NÃO";
			} else {
				return descpe;
			}
		} else {
			return "";
		}
	}
	

}
