package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Con", sequence = "seqcon")
public class ConVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcon; //iddcon
	private String trccon; //Tipo Resp. Contábil - A,E,F
	private String crccon; //Número CRC
	private String snccon; //Sigla número CRC - O,T,S,P,F
	private String tcrcon; //Tipo CRC - C,EC,EI
	private Date dcrcon; //Data Registro
	private String ufrcon; //UF Registro
	private String cpfcon; //CPF/CNPJ Contador
	private String nomcon; //Nome/Razão Social
	private String dtpcon; //Documento - tipo
	private String dnrcon; //Documento - número
	private String doecon; //Documento - orgao expedidor
	private String duocon; //Documento - uf orgao expedidor
	private String dexcon; //Documento - data expedicao
	private Long edrcon; //Endereço
	private String usualt; //usualt
	private Date datalt; //datalt
	
	private EdrVO endereco;
	private String endContador;
	
	public Long getIddcon() {
		return iddcon;
	}
	public void setIddcon(Long iddcon) {
		this.iddcon = iddcon;
	}
	public String getTrccon() {
		return trccon;
	}
	public void setTrccon(String trccon) {
		this.trccon = trccon;
	}
	public String getCrccon() {
		return crccon;
	}
	public void setCrccon(String crccon) {
		this.crccon = crccon;
	}
	public String getSnccon() {
		return snccon;
	}
	public void setSnccon(String snccon) {
		this.snccon = snccon;
	}
	public String getTcrcon() {
		return tcrcon;
	}
	public void setTcrcon(String tcrcon) {
		this.tcrcon = tcrcon;
	}
	public Date getDcrcon() {
		return dcrcon;
	}
	public void setDcrcon(Date dcrcon) {
		this.dcrcon = dcrcon;
	}
	public String getUfrcon() {
		return ufrcon;
	}
	public void setUfrcon(String ufrcon) {
		this.ufrcon = ufrcon;
	}
	public String getCpfcon() {
		return cpfcon;
	}
	public void setCpfcon(String cpfcon) {
		this.cpfcon = cpfcon;
	}
	public String getNomcon() {
		return nomcon;
	}
	public void setNomcon(String nomcon) {
		this.nomcon = nomcon;
	}
	public String getDtpcon() {
		return dtpcon;
	}
	public void setDtpcon(String dtpcon) {
		this.dtpcon = dtpcon;
	}
	public String getDnrcon() {
		return dnrcon;
	}
	public void setDnrcon(String dnrcon) {
		this.dnrcon = dnrcon;
	}
	public String getDoecon() {
		return doecon;
	}
	public void setDoecon(String doecon) {
		this.doecon = doecon;
	}
	public String getDuocon() {
		return duocon;
	}
	public void setDuocon(String duocon) {
		this.duocon = duocon;
	}
	public String getDexcon() {
		return dexcon;
	}
	public void setDexcon(String dexcon) {
		this.dexcon = dexcon;
	}
	public Long getEdrcon() {
		return edrcon;
	}
	public void setEdrcon(Long edrcon) {
		this.edrcon = edrcon;
	}
	public String getUsualt() {
		return usualt;
	}
	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}
	public Date getDatalt() {
		return datalt;
	}
	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}
	public EdrVO getEndereco() {
		return endereco;
	}
	public void setEndereco(EdrVO endereco) {
		this.endereco = endereco;
	}
	public String getEndContador() {
		return endContador;
	}
	public void setEndContador(String endContador) {
		this.endContador = endContador;
	}

}
