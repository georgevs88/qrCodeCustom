package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Cso", sequence = "seqcso")
@XStreamAlias(value = "coletaSocio")
public class CsoVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcso; //iddcso
	private Long colcso; //coleta
	private String cpfcso; //cpf
	private String nomcso; //nomeSocio
	
	@XStreamAlias("cpf") @XStreamAsAttribute
	private String cpf; //cpf
	@XStreamAlias("nomeSocio") @XStreamAsAttribute
	private String nomeSocio; //nomeSocio
	
	public Long getIddcso() {
		return iddcso;
	}
	public void setIddcso(Long iddcso) {
		this.iddcso = iddcso;
	}
	public Long getColcso() {
		return colcso;
	}
	public void setColcso(Long colcso) {
		this.colcso = colcso;
	}
	public String getCpfcso() {
		return cpfcso;
	}
	public void setCpfcso(String cpfcso) {
		this.cpfcso = cpfcso;
	}
	public String getNomcso() {
		return nomcso;
	}
	public void setNomcso(String nomcso) {
		this.nomcso = nomcso;
	}
		
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeSocio() {
		return nomeSocio;
	}
	public void setNomeSocio(String nomeSocio) {
		this.nomeSocio = nomeSocio;
	}
	
	
}
