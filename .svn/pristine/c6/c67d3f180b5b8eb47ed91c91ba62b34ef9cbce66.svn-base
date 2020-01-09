package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@ZKEntity(label = "Fil", sequence = "seqfil")
@XStreamAlias(value = "filiais")
public class FilVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddfil; // iddfil
	private Long matfil;
	@XStreamAlias("evento") @XStreamAsAttribute
	private EveVO evento;
	private String evefil; // evento
	@XStreamAlias("protocoloViabilidade") @XStreamAsAttribute
	private String pvifil; // protocoloViabilidade
	@XStreamAlias("nire") @XStreamAsAttribute
	private String nirfil; // nire
	@XStreamAlias("cnpj") @XStreamAsAttribute
	private String cnpfil; // cnpj
	@XStreamAlias("descricaoObjeto") @XStreamAsAttribute
	private String desfil; // descricaoObjeto
	@XStreamAlias("capitalSocial") @XStreamAsAttribute
	private String capfil; // capitalSocial
	@XStreamAlias("dataInicioAtividade") @XStreamAsAttribute
	private String dataInicioAtividade;
	private Date dinfil; // dataInicioAtividade
	@XStreamAlias("email") @XStreamAsAttribute
	private String emafil; // email
	@XStreamAlias("nome") @XStreamAsAttribute
	private String nomfil; // nome
	@XStreamAlias("cnaes") @XStreamAsAttribute
	private CnasVO cnaes;
//	@XStreamImplicit(itemFieldName = "cnae")
//	private List<CnaVO> cnaes; //cnaes
	@XStreamAlias("endereco") @XStreamAsAttribute
	private EdrVO endereco;
	private Long endfil; // endereco

	public Long getIddfil() {
		return iddfil;
	}

	public void setIddfil(Long iddfil) {
		this.iddfil = iddfil;
	}

	public String getEvefil() {
		return evefil;
	}

	public void setEvefil(String evefil) {
		this.evefil = evefil;
	}

	public String getPvifil() {
		return pvifil;
	}

	public void setPvifil(String pvifil) {
		this.pvifil = pvifil;
	}

	public String getNirfil() {
		return nirfil;
	}

	public void setNirfil(String nirfil) {
		this.nirfil = nirfil;
	}

	public String getCnpfil() {
		return cnpfil;
	}

	public void setCnpfil(String cnpfil) {
		this.cnpfil = cnpfil;
	}

	public String getDesfil() {
		return desfil;
	}

	public void setDesfil(String desfil) {
		this.desfil = desfil;
	}

	public String getCapfil() {
		return capfil;
	}

	public void setCapfil(String capfil) {
		this.capfil = capfil;
	}

	public Date getDinfil() {
		return dinfil;
	}

	public void setDinfil(Date dinfil) {
		this.dinfil = dinfil;
	}

	public String getEmafil() {
		return emafil;
	}

	public void setEmafil(String emafil) {
		this.emafil = emafil;
	}

	public String getNomfil() {
		return nomfil;
	}

	public void setNomfil(String nomfil) {
		this.nomfil = nomfil;
	}

	public Long getEndfil() {
		return endfil;
	}

	public void setEndfil(Long endfil) {
		this.endfil = endfil;
	}

	public EveVO getEvento() {
		return evento;
	}

	public void setEvento(EveVO evento) {
		this.evento = evento;
	}

//	public List<CnaVO> getCnaes() {
//		return cnaes;
//	}
//
//	public void setCnaes(List<CnaVO> cnaes) {
//		this.cnaes = cnaes;
//	}

	public EdrVO getEndereco() {
		return endereco;
	}

	public CnasVO getCnaes() {
		return cnaes;
	}

	public void setCnaes(CnasVO cnaes) {
		this.cnaes = cnaes;
	}

	public void setEndereco(EdrVO endereco) {
		this.endereco = endereco;
	}

	public Long getMatfil() {
		return matfil;
	}

	public void setMatfil(Long matfil) {
		this.matfil = matfil;
	}

	public String getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(String dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

}
