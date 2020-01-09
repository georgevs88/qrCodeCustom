package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;
import pmcg.imti.util.Formatacao;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Req", sequence = "seqreq")
@XStreamAlias(value = "requerente")
public class ReqVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddreq; //iddreq
	private String tipreq; //TIPO REQUERENTE - E=EMPREENDIMENTO, V=VIABILIDADE
	
	//EMPREENDIMENTO
	@XStreamAlias("cpf") @XStreamAsAttribute
	private String cpfreq; //cpf
	
	//VIABILIDADE
	@XStreamAlias("login") @XStreamAsAttribute
	private String logreq; //login
	@XStreamAlias("dddCelular") @XStreamAsAttribute
	private String ddcreq; //dddCelular
	@XStreamAlias("celular") @XStreamAsAttribute
	private String celreq; //celular
	
	//TIPOS COMUNS (EMPREENDIMENTO E VIABILIDADE)
	@XStreamAlias("nome") @XStreamAsAttribute
	private String nomreq; //nome
	@XStreamAlias("email") @XStreamAsAttribute
	private String emareq; //email
	@XStreamAlias("dddTelefone") @XStreamAsAttribute
	private String dddreq; //dddTelefone
	@XStreamAlias("telefone") @XStreamAsAttribute
	private String telreq; //telefone
	
	public Long getIddreq() {
		return iddreq;
	}
	public void setIddreq(Long iddreq) {
		this.iddreq = iddreq;
	}
	public String getNomreq() {
		return nomreq;
	}
	public void setNomreq(String nomreq) {
		this.nomreq = nomreq;
	}
	public String getCpfreq() {
		return cpfreq;
	}
	public void setCpfreq(String cpfreq) {
		this.cpfreq = cpfreq;
	}
	public String getDddreq() {
		return dddreq;
	}
	public void setDddreq(String dddreq) {
		this.dddreq = dddreq;
	}
	public String getTelreq() {
		return telreq;
	}
	public void setTelreq(String telreq) {
		this.telreq = telreq;
	}
	public String getEmareq() {
		return emareq;
	}
	public void setEmareq(String emareq) {
		this.emareq = emareq;
	}
	public String getTipreq() {
		return tipreq;
	}
	public void setTipreq(String tipreq) {
		this.tipreq = tipreq;
	}
	public String getLogreq() {
		return logreq;
	}
	public void setLogreq(String logreq) {
		this.logreq = logreq;
	}
	public String getDdcreq() {
		return ddcreq;
	}
	public void setDdcreq(String ddcreq) {
		this.ddcreq = ddcreq;
	}
	public String getCelreq() {
		return celreq;
	}
	public void setCelreq(String celreq) {
		this.celreq = celreq;
	}
	public String getTelefone(){
		if(dddreq != null && telreq != null){
			return "(" + dddreq + ") " + telreq;
		} else {
			return "";
		}
	}
	public String getCelular(){
		if(ddcreq != null && celreq != null){
			return "(" + ddcreq + ") " + celreq;
		} else {
			return "";
		}
	}
	public String getCpf(){
		if(cpfreq != null && (!cpfreq.isEmpty())){
			return Formatacao.formataCpfCnpj(cpfreq);
		}
		return celreq;
	}
	
}
