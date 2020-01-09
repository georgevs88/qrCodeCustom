package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;
import pmcg.imti.util.Formatacao;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@ZKEntity(label = "Mat", sequence = "seqmat")
@XStreamAlias(value = "matriz")
public class MatVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddmat; // iddmat
	private Long promat;
	@XStreamAlias("protocoloViabilidade") @XStreamAsAttribute
	private String pvimat; // protocoloViabilidade
	@XStreamAlias("nire") @XStreamAsAttribute
	private String nirmat; // nire
	@XStreamAlias("nireAnterior") @XStreamAsAttribute
	private String niamat; // nireAnterior
	@XStreamAlias("cnpj") @XStreamAsAttribute
	private String cnpmat; // cnpj
	@XStreamAlias("descricaoObjeto") @XStreamAsAttribute
	private String desmat; // descricaoObjeto
	@XStreamAlias("capitalSocial") @XStreamAsAttribute
	private String capmat; // capitalSocial
	@XStreamAlias("dataInicioAtividade") @XStreamAsAttribute
	private String dataInicioAtividade;
	private Date dinmat; // dataInicioAtividade
	@XStreamAlias("email") @XStreamAsAttribute
	private String emamat; // email
	@XStreamAlias("nome") @XStreamAsAttribute
	private String nommat; // nome
	@XStreamAlias("nomeFantasia") @XStreamAsAttribute
	private String nfamat; // nomeFantasia
	@XStreamAlias("capitalIntegralizado") @XStreamAsAttribute
	private String caimat; // capitalIntegralizado
	@XStreamAlias("valorQuota") @XStreamAsAttribute
	private String vrqmat; // valorQuota
	@XStreamAlias("cnaes") @XStreamAsAttribute
	private CnasVO cnaes;
	@XStreamAlias("porte") @XStreamAsAttribute
	private String pormat; // porte
	@XStreamAlias("ddd") @XStreamAsAttribute
	private String dddmat; // ddd
	@XStreamAlias("telefone") @XStreamAsAttribute
	private String telmat; // telefone
	@XStreamAlias("endereco") @XStreamAsAttribute
	private EdrVO endereco; // endereco
	private Long endmat; // idd endereco
	@XStreamAlias("homePage") @XStreamAsAttribute
	private String hommat; // homePage
	@XStreamAlias("sociosAdm") @XStreamAsAttribute
	private SadsVO sociosAdm;
	@XStreamAlias("filiais") @XStreamAsAttribute
	private FilsVO filiais;
//	@XStreamImplicit(itemFieldName = "filial")
//	private List<FilVO> filial;
	@XStreamAlias("terminoSociedade") @XStreamAsAttribute
	private Date tsomat; // terminoSociedade

	public MatVO() {
		super();
	}
	
	public MatVO(Long promat) {
		super();
		this.promat = promat;
	}
	
	public Long getIddmat() {
		return iddmat;
	}

	public void setIddmat(Long iddmat) {
		this.iddmat = iddmat;
	}

	public String getPvimat() {
		return pvimat;
	}

	public void setPvimat(String pvimat) {
		this.pvimat = pvimat;
	}

	public String getNirmat() {
		return nirmat;
	}

	public void setNirmat(String nirmat) {
		this.nirmat = nirmat;
	}

	public String getNiamat() {
		return niamat;
	}

	public void setNiamat(String niamat) {
		this.niamat = niamat;
	}

	public String getCnpmat() {
		return cnpmat;
	}

	public void setCnpmat(String cnpmat) {
		this.cnpmat = cnpmat;
	}

	public String getDesmat() {
		return desmat;
	}

	public void setDesmat(String desmat) {
		this.desmat = desmat;
	}

	public String getCapmat() {
		return capmat;
	}

	public void setCapmat(String capmat) {
		this.capmat = capmat;
	}

	public Date getDinmat() {
		return dinmat;
	}

	public void setDinmat(Date dinmat) {
		this.dinmat = dinmat;
	}

	public String getEmamat() {
		return emamat;
	}

	public void setEmamat(String emamat) {
		this.emamat = emamat;
	}

	public String getNommat() {
		return nommat;
	}

	public void setNommat(String nommat) {
		this.nommat = nommat;
	}

	public String getNfamat() {
		return nfamat;
	}

	public void setNfamat(String nfamat) {
		this.nfamat = nfamat;
	}

	public String getCaimat() {
		return caimat;
	}

	public void setCaimat(String caimat) {
		this.caimat = caimat;
	}

	public String getVrqmat() {
		return vrqmat;
	}

	public void setVrqmat(String vrqmat) {
		this.vrqmat = vrqmat;
	}

	public String getPormat() {
		return pormat;
	}

	public void setPormat(String pormat) {
		this.pormat = pormat;
	}

	public String getDddmat() {
		return dddmat;
	}

	public void setDddmat(String dddmat) {
		this.dddmat = dddmat;
	}

	public String getTelmat() {
		return telmat;
	}

	public void setTelmat(String telmat) {
		this.telmat = telmat;
	}

	public Long getEndmat() {
		return endmat;
	}

	public void setEndmat(Long endmat) {
		this.endmat = endmat;
	}

	public String getHommat() {
		return hommat;
	}

	public void setHommat(String hommat) {
		this.hommat = hommat;
	}

	public Date getTsomat() {
		return tsomat;
	}

	public void setTsomat(Date tsomat) {
		this.tsomat = tsomat;
	}

	public EdrVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EdrVO endereco) {
		this.endereco = endereco;
	}

	public CnasVO getCnaes() {
		return cnaes;
	}

	public void setCnaes(CnasVO cnaes) {
		this.cnaes = cnaes;
	}

	public SadsVO getSociosAdm() {
		return sociosAdm;
	}

	public void setSociosAdm(SadsVO sociosAdm) {
		this.sociosAdm = sociosAdm;
	}

//	public List<FilVO> getFilial() {
//		return filial;
//	}
//
//	public void setFilial(List<FilVO> filial) {
//		this.filial = filial;
//	}

	public String getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public FilsVO getFiliais() {
		return filiais;
	}

	public void setFiliais(FilsVO filiais) {
		this.filiais = filiais;
	}

	public void setDataInicioAtividade(String dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public Long getPromat() {
		return promat;
	}

	public void setPromat(Long promat) {
		this.promat = promat;
	}
	public String getCnpj(){
		if(cnpmat != null && (!cnpmat.isEmpty())){
			return Formatacao.formataCpfCnpj(cnpmat);
		}
		return cnpmat;
	}
	public String getTelefone(){
		if(dddmat != null && telmat != null){
			return "(" + dddmat + ") " + telmat;
		} else {
			return "";
		}
	}
	public String getCapital(){
		if(capmat != null){
			return capmat.substring(0, capmat.length() - 2) + "," + capmat.substring(capmat.length() - 2, capmat.length());
		} else {
			return "";
		}
	}
}
