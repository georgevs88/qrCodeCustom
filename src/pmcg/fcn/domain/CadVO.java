package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Cad", sequence = "seqcad")
public class CadVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcad; //iddcad
	private String cpfcad; //CPF/CNPJ
	private String nomcad; //NOME/RAZAO_SOCIAL
	private String ddtcad; //DDD_TELEFONE
	private String telcad; //TELEFONE
	private String ramcad; //RAMAL
	private String ddccad; //DDD_CELULAR
	private String celcad; //CELULAR
	private String ddfcad; //DDD_FAX
	private String faxcad; //FAX
	private String emacad; //EMAIL
	private String tpccad; //TIPO_CRC ( CO=Contabilista, EC=Escritório de Contabilidade, EI=Escritório Individual, NC=Contador Não Contabilista)
	private String crccad; //NUMERO_CRC
	private String scrcad; //SIGLA_CRC ( O, S, F, P, T)
	private Date dtrcad; //DATA_REGISTRO_CRC
	private Date dtccad; //DATA_DE_CADASTRO
	private String ufccad; //UF_CRC
	private String sencad; //SENHA
	private String dtpcad; //Documento - tipo
	private String dnrcad; //Documento - número
	private String doecad; //Documento - orgao expedidor
	private String duocad; //Documento - uf orgao expedidor
	private Date dexcad; //Documento - data expedicao
	private Long edrcad; //endereco
	private String cpccad; //CPF/CNPJ CONTADOR
	private String nrscad; //NOME/RAZAO SOCIAL CONTADOR
	private Date dnacad; //data de nascimento
	private String sexcad; //sexo
	private String usualt; //usualt
	private Date datalt; //datalt
	private Boolean admcad; //ADMINISTRADOR (entrar como...)
	
	public Long getIddcad() {
		return iddcad;
	}
	public void setIddcad(Long iddcad) {
		this.iddcad = iddcad;
	}
	public String getCpfcad() {
		return cpfcad;
	}
	public void setCpfcad(String cpfcad) {
		this.cpfcad = cpfcad;
	}
	public String getNomcad() {
		return nomcad;
	}
	public void setNomcad(String nomcad) {
		this.nomcad = nomcad;
	}
	public String getDdtcad() {
		return ddtcad;
	}
	public void setDdtcad(String ddtcad) {
		this.ddtcad = ddtcad;
	}
	public String getTelcad() {
		return telcad;
	}
	public void setTelcad(String telcad) {
		this.telcad = telcad;
	}
	public String getRamcad() {
		return ramcad;
	}
	public void setRamcad(String ramcad) {
		this.ramcad = ramcad;
	}
	public String getDdccad() {
		return ddccad;
	}
	public void setDdccad(String ddccad) {
		this.ddccad = ddccad;
	}
	public String getCelcad() {
		return celcad;
	}
	public void setCelcad(String celcad) {
		this.celcad = celcad;
	}
	public String getDdfcad() {
		return ddfcad;
	}
	public void setDdfcad(String ddfcad) {
		this.ddfcad = ddfcad;
	}
	public String getFaxcad() {
		return faxcad;
	}
	public void setFaxcad(String faxcad) {
		this.faxcad = faxcad;
	}
	public String getEmacad() {
		return emacad;
	}
	public void setEmacad(String emacad) {
		this.emacad = emacad;
	}
	public String getTpccad() {
		return tpccad;
	}
	public void setTpccad(String tpccad) {
		this.tpccad = tpccad;
	}
	public String getCrccad() {
		return crccad;
	}
	public void setCrccad(String crccad) {
		this.crccad = crccad;
	}
	public String getScrcad() {
		return scrcad;
	}
	public void setScrcad(String scrcad) {
		this.scrcad = scrcad;
	}
	public Date getDtrcad() {
		return dtrcad;
	}
	public void setDtrcad(Date dtrcad) {
		this.dtrcad = dtrcad;
	}
	public Date getDtccad() {
		return dtccad;
	}
	public void setDtccad(Date dtccad) {
		this.dtccad = dtccad;
	}
	public String getUfccad() {
		return ufccad;
	}
	public void setUfccad(String ufccad) {
		this.ufccad = ufccad;
	}
	public String getSencad() {
		return sencad;
	}
	public void setSencad(String sencad) {
		this.sencad = sencad;
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
	public String getDtpcad() {
		return dtpcad;
	}
	public void setDtpcad(String dtpcad) {
		this.dtpcad = dtpcad;
	}
	public String getDnrcad() {
		return dnrcad;
	}
	public void setDnrcad(String dnrcad) {
		this.dnrcad = dnrcad;
	}
	public String getDoecad() {
		return doecad;
	}
	public void setDoecad(String doecad) {
		this.doecad = doecad;
	}
	public String getDuocad() {
		return duocad;
	}
	public void setDuocad(String duocad) {
		this.duocad = duocad;
	}
	public Date getDexcad() {
		return dexcad;
	}
	public Long getEdrcad() {
		return edrcad;
	}
	public void setEdrcad(Long edrcad) {
		this.edrcad = edrcad;
	}
	public void setDexcad(Date dexcad) {
		this.dexcad = dexcad;
	}
	public String getCpccad() {
		return cpccad;
	}
	public void setCpccad(String cpccad) {
		this.cpccad = cpccad;
	}
	public String getNrscad() {
		return nrscad;
	}
	public void setNrscad(String nrscad) {
		this.nrscad = nrscad;
	}
	public Date getDnacad() {
		return dnacad;
	}
	public void setDnacad(Date dnacad) {
		this.dnacad = dnacad;
	}
	public String getSexcad() {
		return sexcad;
	}
	public void setSexcad(String sexcad) {
		this.sexcad = sexcad;
	}
	public String getCpfFormatado() {
		if (cpfcad != null){
			return cpfcad.substring(0, 3) + "." + cpfcad.substring(3, 6) + "." + cpfcad.substring(6, 9) + "-" + cpfcad.substring(9, 11);
		} else {
			return "";
		}
	}
	public Boolean getAdmcad() {
		return admcad;
	}
	public void setAdmcad(Boolean admcad) {
		this.admcad = admcad;
	}
	
}
