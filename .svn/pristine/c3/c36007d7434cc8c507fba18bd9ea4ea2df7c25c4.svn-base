package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@ZKEntity(label = "Pro", sequence = "seqpro")
@XStreamAlias(value = "processo")
public class ProVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddpro; //iddpro
	@XStreamAlias("requerente") @XStreamAsAttribute
	private ReqVO requerente; //requerente
	private Long reqpro; //
	@XStreamAlias("ato") @XStreamAsAttribute
	private AtoVO ato; //ato
	private String atopro; //ato
	@XStreamAlias("naturezaJuridica") @XStreamAsAttribute
	private NjrVO naturezaJuridica;
	private String njrpro; //naturezaJuridica
	@XStreamAlias("eventos") @XStreamAsAttribute
	private EvsVO eventos;
	@XStreamAlias("dataAssinatura") @XStreamAsAttribute
	private String dataAssinatura;
	private Date daspro; //dataAssinatura
	@XStreamAlias("matriz") @XStreamAsAttribute
	private MatVO matriz;
	@XStreamAlias("viabilidade") @XStreamOmitField
	private VibVO viabilidade;
	
	private String descricaoAto;
	
	public Long getIddpro() {
		return iddpro;
	}
	public void setIddpro(Long iddpro) {
		this.iddpro = iddpro;
	}
	public Long getReqpro() {
		return reqpro;
	}
	public void setReqpro(Long reqpro) {
		this.reqpro = reqpro;
	}
	public String getAtopro() {
		return atopro;
	}
	public void setAtopro(String atopro) {
		this.atopro = atopro;
	}
	public String getNjrpro() {
		return njrpro;
	}
	public void setNjrpro(String njrpro) {
		this.njrpro = njrpro;
	}
	public Date getDaspro() {
		return daspro;
	}
	public void setDaspro(Date daspro) {
		this.daspro = daspro;
	}
	public String getDasproFormatado(){
		if(daspro!=null){
			return new SimpleDateFormat("dd/MM/yyyy").format(daspro);
		} else {
			return "";
		}
	}
	public ReqVO getRequerente() {
		return requerente;
	}
	public void setRequerente(ReqVO requerente) {
		this.requerente = requerente;
	}
	public EvsVO getEventos() {
		return eventos;
	}
	public void setEventos(EvsVO eventos) {
		this.eventos = eventos;
	}
	public String getDataAssinatura() {
		return dataAssinatura;
	}
	public void setDataAssinatura(String dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}
	public MatVO getMatriz() {
		return matriz;
	}
	public void setMatriz(MatVO matriz) {
		this.matriz = matriz;
	}
	public AtoVO getAto() {
		return ato;
	}
	public void setAto(AtoVO ato) {
		this.ato = ato;
	}
	public NjrVO getNaturezaJuridica() {
		return naturezaJuridica;
	}
	public void setNaturezaJuridica(NjrVO naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}
	public String getDescricaoAto() {
		return descricaoAto;
	}
	public void setDescricaoAto(String descricaoAto) {
		this.descricaoAto = descricaoAto;
	}

	
	
}
