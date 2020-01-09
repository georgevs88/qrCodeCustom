package pmcg.fcn.domain;

import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Bae", sequence = "seqbae")
public class BaeVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddbae; //iddbae
	private String viabae; //Protocolo Viabilidade 
	private String tpebae; //Tipo Pessoa
	private String cpfbae; //CPF/CNPJ
	private String nombae; //Nome/Razão Social
	private String nfabae; //Nome Fantasia
	private Date dnabae; //Data Nascimento
	private String sexbae; //Sexo
	private String nivbae; //Nivel escolar
	private Date dtcbae; //data colacao de grau
	private String dtpbae; //Documento - tipo
	private String dnrbae; //Documento - número
	private String doebae; //Documento - orgao expedidor
	private String duobae; //Documento - uf orgao expedidor
	private Date dexbae; //Documento - data expedicao
	private String psibae; //Profissao - Sindicato/Conselho
	private String pnrbae; //Profissao - numero registro
	private String pufbae; //Profissao - uf registro
	private Date pdtbae; //Profissao - data registro
	private Long edlbae; //Endereço de localização
	private String iptbae; //Inscrição imobiliária do endereço de localização
	private Long edcbae; //Endereço de correspondencia
	private String ddtbae; //ddd telefone
	private String telbae; //telefone
	private String ddfbae; //ddd fax
	private String faxbae; //fax
	private String ddcbae; //ddd celular
	private String celbae; //celular
	private String emabae; //Email
	private String orebae; //Empresa - orgao registro
	private String nrrbae; //Empresa - número registro
	private String nirbae; //Empresa - NIRE
	private String livbae; //Empresa - Livro
	private String folbae; //Folha
	private Date dtrbae; //Empresa - data registro
	private Date uatbae; //Empresa - ultima atualização
	private String iesbae; //Empresa - inscricao estadual
	private Double capbae; //Empresa - capital social
	private Long reqbae; // Requerente
	private Long caibae; // Confirma Inscricao Municipal (Análise do BAE)
	private Long conbae; //Responsável Contábil
	private String msgbae; //Mensagem de retorno do SIAT
	private String usualt; //usualt
	private Date datalt; //datalt
	
	private EdrVO endCor = new EdrVO(); //Objeto Endereço de correspondencia
	
	public Long getIddbae() {
		return iddbae;
	}
	public void setIddbae(Long iddbae) {
		this.iddbae = iddbae;
	}
	public String getTpebae() {
		return tpebae;
	}
	public void setTpebae(String tpebae) {
		this.tpebae = tpebae;
	}
	public String getCpfbae() {
		return cpfbae;
	}
	public void setCpfbae(String cpfbae) {
		this.cpfbae = cpfbae;
	}
	public String getNombae() {
		return nombae;
	}
	public void setNombae(String nombae) {
		this.nombae = nombae;
	}
	public String getNfabae() {
		return nfabae;
	}
	public void setNfabae(String nfabae) {
		this.nfabae = nfabae;
	}
	public Date getDnabae() {
		return dnabae;
	}
	public void setDnabae(Date dnabae) {
		this.dnabae = dnabae;
	}
	public String getSexbae() {
		return sexbae;
	}
	public void setSexbae(String sexbae) {
		this.sexbae = sexbae;
	}
	public String getNivbae() {
		return nivbae;
	}
	public void setNivbae(String nivbae) {
		this.nivbae = nivbae;
	}
	public Date getDtcbae() {
		return dtcbae;
	}
	public void setDtcbae(Date dtcbae) {
		this.dtcbae = dtcbae;
	}
	public String getDtpbae() {
		return dtpbae;
	}
	public void setDtpbae(String dtpbae) {
		this.dtpbae = dtpbae;
	}
	public String getDnrbae() {
		return dnrbae;
	}
	public void setDnrbae(String dnrbae) {
		this.dnrbae = dnrbae;
	}
	public String getDoebae() {
		return doebae;
	}
	public void setDoebae(String doebae) {
		this.doebae = doebae;
	}
	public String getDuobae() {
		return duobae;
	}
	public void setDuobae(String duobae) {
		this.duobae = duobae;
	}
	public Date getDexbae() {
		return dexbae;
	}
	public void setDexbae(Date dexbae) {
		this.dexbae = dexbae;
	}
	public String getPsibae() {
		return psibae;
	}
	public void setPsibae(String psibae) {
		this.psibae = psibae;
	}
	public String getPnrbae() {
		return pnrbae;
	}
	public void setPnrbae(String pnrbae) {
		this.pnrbae = pnrbae;
	}
	public String getPufbae() {
		return pufbae;
	}
	public void setPufbae(String pufbae) {
		this.pufbae = pufbae;
	}
	public Date getPdtbae() {
		return pdtbae;
	}
	public void setPdtbae(Date pdtbae) {
		this.pdtbae = pdtbae;
	}
	public Long getEdlbae() {
		return edlbae;
	}
	public void setEdlbae(Long edlbae) {
		this.edlbae = edlbae;
	}
	public Long getEdcbae() {
		return edcbae;
	}
	public void setEdcbae(Long edcbae) {
		this.edcbae = edcbae;
	}
	public String getOrebae() {
		return orebae;
	}
	public void setOrebae(String orebae) {
		this.orebae = orebae;
	}
	public String getNrrbae() {
		return nrrbae;
	}
	public void setNrrbae(String nrrbae) {
		this.nrrbae = nrrbae;
	}
	public String getNirbae() {
		return nirbae;
	}
	public void setNirbae(String nirbae) {
		this.nirbae = nirbae;
	}
	public String getLivbae() {
		return livbae;
	}
	public void setLivbae(String livbae) {
		this.livbae = livbae;
	}
	public String getFolbae() {
		return folbae;
	}
	public void setFolbae(String folbae) {
		this.folbae = folbae;
	}
	public Date getDtrbae() {
		return dtrbae;
	}
	public void setDtrbae(Date dtrbae) {
		this.dtrbae = dtrbae;
	}
	public Date getUatbae() {
		return uatbae;
	}
	public void setUatbae(Date uatbae) {
		this.uatbae = uatbae;
	}
	public String getIesbae() {
		return iesbae;
	}
	public void setIesbae(String iesbae) {
		this.iesbae = iesbae;
	}
	public Double getCapbae() {
		return capbae;
	}
	public void setCapbae(Double capbae) {
		this.capbae = capbae;
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
	public String getDdtbae() {
		return ddtbae;
	}
	public void setDdtbae(String ddtbae) {
		this.ddtbae = ddtbae;
	}
	public String getTelbae() {
		return telbae;
	}
	public void setTelbae(String telbae) {
		this.telbae = telbae;
	}
	public String getDdfbae() {
		return ddfbae;
	}
	public void setDdfbae(String ddfbae) {
		this.ddfbae = ddfbae;
	}
	public String getFaxbae() {
		return faxbae;
	}
	public void setFaxbae(String faxbae) {
		this.faxbae = faxbae;
	}
	public String getDdcbae() {
		return ddcbae;
	}
	public void setDdcbae(String ddcbae) {
		this.ddcbae = ddcbae;
	}
	public String getCelbae() {
		return celbae;
	}
	public void setCelbae(String celbae) {
		this.celbae = celbae;
	}
	public String getEmabae() {
		return emabae;
	}
	public void setEmabae(String emabae) {
		this.emabae = emabae;
	}
	public EdrVO getEndCor() {
		return endCor;
	}
	public void setEndCor(EdrVO endCor) {
		this.endCor = endCor;
	}
	public String getIptbae() {
		return iptbae;
	}
	public void setIptbae(String iptbae) {
		this.iptbae = iptbae;
	}
	public String getViabae() {
		return viabae;
	}
	public void setViabae(String viabae) {
		this.viabae = viabae;
	}
	public Long getReqbae() {
		return reqbae;
	}
	public void setReqbae(Long reqbae) {
		this.reqbae = reqbae;
	}
	public Long getCaibae() {
		return caibae;
	}
	public void setCaibae(Long caibae) {
		this.caibae = caibae;
	}
	public Long getConbae() {
		return conbae;
	}
	public void setConbae(Long conbae) {
		this.conbae = conbae;
	}
	public String getMsgbae() {
		return msgbae;
	}
	public void setMsgbae(String msgbae) {
		this.msgbae = msgbae;
	}

}
