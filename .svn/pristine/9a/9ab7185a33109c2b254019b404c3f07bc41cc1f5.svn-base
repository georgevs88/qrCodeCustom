package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Cen", sequence = "seqcen")
@XStreamAlias(value = "coletaEndereco")
public class CenVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcen; //iddcen
	
	@XStreamAlias("areaTotalEmpreendimento") @XStreamAsAttribute
	private Double atecen; //areaTotalEmpreendimento
	@XStreamAlias("areaUtilizada") @XStreamAsAttribute
	private Double autcen; //areaUtilizada
	@XStreamAlias("numeroIPTU") @XStreamAsAttribute
	private String iptcen; //numeroIPTU
	@XStreamAlias("endereco") @XStreamAsAttribute
	private EdrVO endereco;
	private Long edrcen; //endereco
	@XStreamAlias("referenciaLogradouro") @XStreamAsAttribute
	private String refcen; //referenciaLogradouro
	
	
	public Long getIddcen() {
		return iddcen;
	}
	public void setIddcen(Long iddcen) {
		this.iddcen = iddcen;
	}
	public Double getAtecen() {
		return atecen;
	}
	public void setAtecen(Double atecen) {
		this.atecen = atecen;
	}
	public Double getAutcen() {
		return autcen;
	}
	public void setAutcen(Double autcen) {
		this.autcen = autcen;
	}
	public String getIptcen() {
		return iptcen;
	}
	public void setIptcen(String iptcen) {
		this.iptcen = iptcen;
	}
	public EdrVO getEndereco() {
		return endereco;
	}
	public void setEndereco(EdrVO endereco) {
		this.endereco = endereco;
	}
	
	public Long getEdrcen() {
		return edrcen;
	}
	public void setEdrcen(Long edrcen) {
		this.edrcen = edrcen;
	}
	public String getRefcen() {
		return refcen;
	}
	public void setRefcen(String refcen) {
		this.refcen = refcen;
	}

	
}
