package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@ZKEntity(label = "Epd", sequence = "seqepd")
@XStreamAlias(value = "empreendimento")
public class EpdVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddepd; //iddepd
	@XStreamAlias("numeroProcesso") @XStreamAsAttribute
	private String nprepd; //numeroProcesso
	@XStreamAlias("nire") @XStreamAsAttribute
	private String nirepd; //nire
	@XStreamAlias("dataGravacaoNire") @XStreamAsAttribute
	private String dataGravacaoNire;
	private Date dgnepd; //dataGravacaoNire
	@XStreamAlias("cnpj") @XStreamAsAttribute
	private String cnpepd; //cnpj
	@XStreamAlias("dataGravacaoCnpj") @XStreamAsAttribute
	private String dataGravacaoCnpj;
	private Date dgcepd; //dataGravacaoCnpj
	@XStreamAlias("tipoEmpreendimento") @XStreamAsAttribute
	private String tpeepd; //tipoEmpreendimento
	@XStreamAlias("processo") @XStreamAsAttribute
	private ProVO processo;
	private Long proepd; //codigo processo - iddpro
	private Date datepd; //data importacao
	private String creepd; //Confirmacao Recebimento, S=SIM, N=NAO
	private Long caiepd; //confirmacaoAlvaraInscricaomunicipal
	@XStreamOmitField
	private Boolean ateepd; // ATENDIDO - indica se o processo já foi finalizado
	@XStreamOmitField
	private String usuepd; // Usuário atendimento (alteracao)
	@XStreamOmitField
	private Date daeepd; // Data atendimento (alteracao)
	@XStreamOmitField
	private String msgepd; // Mensagem de Erro no Retorno do SIAT (ao tentar inserir no cadastro economico)
	@XStreamOmitField
	private String mgcepd; // Mensagem de Retorno "Confirma recebimento"
	@XStreamOmitField
	private Long lmaepd; //Licença Meio Ambiente - lic.licamb
	@XStreamOmitField
	private Long lvsepd; //Licença Vigilancia - lic.licamb
	@XStreamOmitField
	private Integer vesepd; //codves (SOSWEB - Tabela sos.sosves - Estabelecimento)
	
	public String getTpeepd() {
		return tpeepd;
	}
	public void setTpeepd(String tpeepd) {
		this.tpeepd = tpeepd;
	}
	public Integer getVesepd() {
		return vesepd;
	}
	public void setVesepd(Integer vesepd) {
		this.vesepd = vesepd;
	}
	public Long getIddepd() {
		return iddepd;
	}
	public void setIddepd(Long iddepd) {
		this.iddepd = iddepd;
	}
	public String getNprepd() {
		return nprepd;
	}
	public void setNprepd(String nprepd) {
		this.nprepd = nprepd;
	}
	public String getNirepd() {
		return nirepd;
	}
	public void setNirepd(String nirepd) {
		this.nirepd = nirepd;
	}
	public Date getDgnepd() {
		return dgnepd;
	}
	public void setDgnepd(Date dgnepd) {
		this.dgnepd = dgnepd;
	}
	public String getCnpepd() {
		return cnpepd;
	}
	public void setCnpepd(String cnpepd) {
		this.cnpepd = cnpepd;
	}
	public Date getDgcepd() {
		return dgcepd;
	}
	public void setDgcepd(Date dgcepd) {
		this.dgcepd = dgcepd;
	}
	
	public ProVO getProcesso() {
		return processo;
	}
	public void setProcesso(ProVO processo) {
		this.processo = processo;
	}
	public Long getProepd() {
		return proepd;
	}
	public void setProepd(Long proepd) {
		this.proepd = proepd;
	}
	public String getDataGravacaoNire() {
		return dataGravacaoNire;
	}
	public void setDataGravacaoNire(String dataGravacaoNire) {
		this.dataGravacaoNire = dataGravacaoNire;
	}
	public String getDataGravacaoCnpj() {
		return dataGravacaoCnpj;
	}
	public void setDataGravacaoCnpj(String dataGravacaoCnpj) {
		this.dataGravacaoCnpj = dataGravacaoCnpj;
	}
	public Date getDatepd() {
		return datepd;
	}
	public void setDatepd(Date datepd) {
		this.datepd = datepd;
	}
	public String getCreepd() {
		return creepd;
	}
	public void setCreepd(String creepd) {
		this.creepd = creepd;
	}
	public Long getCaiepd() {
		return caiepd;
	}
	public void setCaiepd(Long caiepd) {
		this.caiepd = caiepd;
	}
	public Boolean getAteepd() {
		return ateepd;
	}
	public void setAteepd(Boolean ateepd) {
		this.ateepd = ateepd;
	}
	public String getUsuepd() {
		return usuepd;
	}
	public void setUsuepd(String usuepd) {
		this.usuepd = usuepd;
	}
	public Date getDaeepd() {
		return daeepd;
	}
	public void setDaeepd(Date daeepd) {
		this.daeepd = daeepd;
	}
	public String getMsgepd() {
		return msgepd;
	}
	public void setMsgepd(String msgepd) {
		this.msgepd = msgepd;
	}
	public String getMgcepd() {
		return mgcepd;
	}
	public void setMgcepd(String mgcepd) {
		this.mgcepd = mgcepd;
	}
	public Long getLmaepd() {
		return lmaepd;
	}
	public void setLmaepd(Long lmaepd) {
		this.lmaepd = lmaepd;
	}
	public Long getLvsepd() {
		return lvsepd;
	}
	public void setLvsepd(Long lvsepd) {
		this.lvsepd = lvsepd;
	}
	

	
	
}
