package pmcg.fcn.domain;


import java.util.Date;
import java.util.List;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@ZKEntity(label = "Via", sequence = "seqvia")
@XStreamAlias(value = "viabilidade")
public class ViaVO {
	@ZKId
	@ZKField(label = "C�digo", artigo = "o", readonly = true, maxsize = 80, tooltip = "C�digo incremental!")
	private Long iddvia; //iddvia
	@XStreamAlias("numeroProtocolo") @XStreamAsAttribute	
	private String provia; //numeroProtocolo
	
	@XStreamAlias("municipio") @XStreamAsAttribute	
	private MunVO municipio; //municipio
	private String munvia; //municipio
	
	@XStreamAlias("naturezaJuridica") @XStreamAsAttribute
	private NjuVO naturezaJuridica;
	private String njrvia; //naturezaJuridica
	
	@XStreamAlias("tipoEnquadramento") @XStreamAsAttribute	
	private String teqvia; //tipoEnquadramento
	
	@XStreamAlias("cnpj") @XStreamAsAttribute	
	private String cnpvia; //cnpj
	
	@XStreamImplicit(itemFieldName = "evento")
	private List<EveVO> evento;	
	
	@XStreamAlias("resultadoClassificacao") @XStreamAsAttribute	
	private RclVO resultadoClassificacao;
	private Long rclvia; //resultadoClassificacao
	
	@XStreamAlias("orgaoRegistro") @XStreamAsAttribute	
	private OreVO orgaoRegistro;
	private String orevia; //orgaoRegistro
	
	@XStreamAlias("requerente") @XStreamAsAttribute	
	private ReqVO requerente;
	private Long reqvia; //requerente
	
	@XStreamAlias("coleta") @XStreamAsAttribute	
	private ColVO coleta;
	private Long colvia; //coleta
	
	private Long baevia; //Ficha BAE
	
	private Long aenvia; //ANALISE DE ENDERECO
	private Date datvia; //data importacao viabilidade
	private String crevia; //Confirma��o Recebimento, S=SIM, N=NAO
	private Boolean estvia; //ESTABELECIDO NO LOCAL (Autonomo Estabelecido OU MEI Estabelecimento Fixo OU EMPRESA Estabelecimento Fixo)
	
	//campos utilizados para simulacao de autonomo
	private String tipvia; //tipo viabilidade, E=Empresa, A=Autonomo, M=MEI
	private String sauvia; //situacao autonomo
	private String einvia; //empreendedor individual DO=Domic�lio,SP=Sede Permanente,CL=No Cliente,CP=Vias P�blicas,SP=Vias P�blicas, sem ponto fixo
	private String evevia; //evento
	private String cprvia; //CPF/CNPJ Respons�vel
	private String norvia; //Nome/Raz�o Social Respons�vel
	private String ddtvia; //DDD Tel Respons�vel
	private String telvia; //Telefone Respons�vel
	private String emavia; //email Respons�vel
	
	public Date getDatvia() {
		return datvia;
	}
	public void setDatvia(Date datvia) {
		this.datvia = datvia;
	}
	
	public Long getAenvia() {
		return aenvia;
	}
	public void setAenvia(Long aenvia) {
		this.aenvia = aenvia;
	}
	public ColVO getColeta() {
		return coleta;
	}
	public void setColeta(ColVO coleta) {
		this.coleta = coleta;
	}
	public NjuVO getNaturezaJuridica() {
		return naturezaJuridica;
	}
	public void setNaturezaJuridica(NjuVO naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}
	public RclVO getResultadoClassificacao() {
		return resultadoClassificacao;
	}
	public void setResultadoClassificacao(RclVO resultadoClassificacao) {
		this.resultadoClassificacao = resultadoClassificacao;
	}
	public OreVO getOrgaoRegistro() {
		return orgaoRegistro;
	}
	public void setOrgaoRegistro(OreVO orgaoRegistro) {
		this.orgaoRegistro = orgaoRegistro;
	}
	public ReqVO getRequerente() {
		return requerente;
	}
	public void setRequerente(ReqVO requerente) {
		this.requerente = requerente;
	}
	public Long getIddvia() {
		return iddvia;
	}
	public MunVO getMunicipio() {
		return municipio;
	}
	public void setMunicipio(MunVO municipio) {
		this.municipio = municipio;
	}
	public void setIddvia(Long iddvia) {
		this.iddvia = iddvia;
	}
	public String getProvia() {
		return provia;
	}
	public void setProvia(String provia) {
		this.provia = provia;
	}
	public String getMunvia() {
		return munvia;
	}
	public void setMunvia(String munvia) {
		this.munvia = munvia;
	}
	public String getNjrvia() {
		return njrvia;
	}
	public void setNjrvia(String njrvia) {
		this.njrvia = njrvia;
	}
	public String getTeqvia() {
		return teqvia;
	}
	public void setTeqvia(String teqvia) {
		this.teqvia = teqvia;
	}
	public List<EveVO> getEvento() {
		return evento;
	}
	public void setEvento(List<EveVO> evento) {
		this.evento = evento;
	}
	public Long getRclvia() {
		return rclvia;
	}
	public void setRclvia(Long rclvia) {
		this.rclvia = rclvia;
	}
	public Long getReqvia() {
		return reqvia;
	}
	public void setReqvia(Long reqvia) {
		this.reqvia = reqvia;
	}
	public Long getColvia() {
		return colvia;
	}
	public void setColvia(Long colvia) {
		this.colvia = colvia;
	}
	public String getOrevia() {
		return orevia;
	}
	public void setOrevia(String orevia) {
		this.orevia = orevia;
	}
	public String getCrevia() {
		return crevia;
	}
	public void setCrevia(String crevia) {
		this.crevia = crevia;
	}
	public String getTipvia() {
		return tipvia;
	}
	public void setTipvia(String tipvia) {
		this.tipvia = tipvia;
	}
	public String getSauvia() {
		return sauvia;
	}
	public void setSauvia(String sauvia) {
		this.sauvia = sauvia;
	}
	public String getEinvia() {
		return einvia;
	}
	public void setEinvia(String einvia) {
		this.einvia = einvia;
	}
	public Long getBaevia() {
		return baevia;
	}
	public void setBaevia(Long baevia) {
		this.baevia = baevia;
	}
	public String getEvevia() {
		return evevia;
	}
	public void setEvevia(String evevia) {
		this.evevia = evevia;
	}
	public String getCprvia() {
		return cprvia;
	}
	public void setCprvia(String cprvia) {
		this.cprvia = cprvia;
	}
	public String getNorvia() {
		return norvia;
	}
	public void setNorvia(String norvia) {
		this.norvia = norvia;
	}
	public String getDdtvia() {
		return ddtvia;
	}
	public void setDdtvia(String ddtvia) {
		this.ddtvia = ddtvia;
	}
	public String getTelvia() {
		return telvia;
	}
	public void setTelvia(String telvia) {
		this.telvia = telvia;
	}
	public String getEmavia() {
		return emavia;
	}
	public void setEmavia(String emavia) {
		this.emavia = emavia;
	}
	public Boolean getEstvia() {
		return estvia;
	}
	public void setEstvia(Boolean estvia) {
		this.estvia = estvia;
	}
	public String getCnpvia() {
		return cnpvia;
	}
	public void setCnpvia(String cnpvia) {
		this.cnpvia = cnpvia;
	}
	
	
}
