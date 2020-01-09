package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ZKEntity(label = "Cna", sequence = "seqcna")
@XStreamAlias(value = "cnae")
public class CnaVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcna; //iddcna
	private String tipcna; //E=EMPREENDIMENTO, V=VIABILIDADE
	private String codcna; //codigoCnae - empreendimento/viabilidade
	
	//EMPREENDIMENTO
	private Long filcna; //filial - empreendimento (FK TABELA FIL)
	private Long matcna; //matriz - empreendimento (FK TABELA MAT)
	@XStreamAlias("codigoCnae") @XStreamAsAttribute
	private String codigoCnae; //cnae 
	@XStreamAlias("principal") @XStreamAsAttribute
	private Integer pricna; //principal (empreendimento)
	@XStreamAlias("ordem")
	private Long ordcna; //ordem - empreendimento
	
	//VIABILIDADE
	private Long colcna; //coleta - viabilidade (FK TABELA CAE)
	@XStreamAlias("cnae") @XStreamAsAttribute
	private Long cnae; //codigoCnae
	private String taecna; //tipoAtividadeEconomica
	private String descna; //desdobramentoAtividadeEconomica
	private Boolean execna; //exercidaNoLocal
	
	//### CAMPOS UTILIZADOS PARA ANALISE DE ENDERECO ######################
	private String status; //campo utilizado na analise de endereco
	// AT = ANÁLISE TERRITORIAL
	// AP = ANÁLISE PORTE
	// D = DEFERIDA
	// I = INDEFERIDA
	private String usoConforme; //CASO PERMITIDA
	//RISCOS
	private String riscoAmbi;
	private String riscoBomb;
	private String riscoVigi;
	private String riscoPost;
	private String riscoTran;
	private String riscoSIA;
	//#####################################################################
	
	//### CAMPOS UTILIZADOS NO EMPRESA FACIL ######################
	private String dcoatv; //descricao do cnae
	private Boolean principal;
	
	public Long getIddcna() {
		return iddcna;
	}
	public void setIddcna(Long iddcna) {
		this.iddcna = iddcna;
	}
	public String getTipcna() {
		return tipcna;
	}
	public void setTipcna(String tipcna) {
		this.tipcna = tipcna;
	}
	public Long getFilcna() {
		return filcna;
	}
	public void setFilcna(Long filcna) {
		this.filcna = filcna;
	}
	public Long getMatcna() {
		return matcna;
	}
	public void setMatcna(Long matcna) {
		this.matcna = matcna;
	}
	
	public String getCodcna() {
		return codcna;
	}
	public void setCodcna(String codcna) {
		this.codcna = codcna;
	}
	public Integer getPricna() {
		return pricna;
	}
	public void setPricna(Integer pricna) {
		this.pricna = pricna;
	}
	public Long getOrdcna() {
		return ordcna;
	}
	public void setOrdcna(Long ordcna) {
		this.ordcna = ordcna;
	}
	public String getCodigoCnae() {
		return codigoCnae;
	}
	public void setCodigoCnae(String codigoCnae) {
		this.codigoCnae = codigoCnae;
	}
	public Long getCnae() {
		return cnae;
	}
	public void setCnae(Long cnae) {
		this.cnae = cnae;
	}
	public Long getColcna() {
		return colcna;
	}
	public void setColcna(Long colcna) {
		this.colcna = colcna;
	}
	public String getTaecna() {
		return taecna;
	}
	public void setTaecna(String taecna) {
		this.taecna = taecna;
	}
	public String getDescna() {
		return descna;
	}
	public void setDescna(String descna) {
		this.descna = descna;
	}
	public Boolean getExecna() {
		return execna;
	}
	public void setExecna(Boolean execna) {
		this.execna = execna;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsoConforme() {
		return usoConforme;
	}
	public void setUsoConforme(String usoConforme) {
		this.usoConforme = usoConforme;
	}
	public String getRiscoAmbi() {
		return riscoAmbi;
	}
	public void setRiscoAmbi(String riscoAmbi) {
		this.riscoAmbi = riscoAmbi;
	}
	public String getRiscoBomb() {
		return riscoBomb;
	}
	public void setRiscoBomb(String riscoBomb) {
		this.riscoBomb = riscoBomb;
	}
	public String getRiscoVigi() {
		return riscoVigi;
	}
	public void setRiscoVigi(String riscoVigi) {
		this.riscoVigi = riscoVigi;
	}
	public String getRiscoPost() {
		return riscoPost;
	}
	public void setRiscoPost(String riscoPost) {
		this.riscoPost = riscoPost;
	}
	public String getRiscoTran() {
		return riscoTran;
	}
	public void setRiscoTran(String riscoTran) {
		this.riscoTran = riscoTran;
	}
	public String getRiscoSIA() {
		return riscoSIA;
	}
	public void setRiscoSIA(String riscoSIA) {
		this.riscoSIA = riscoSIA;
	}
	public String getDcoatv() {
		return dcoatv;
	}
	public void setDcoatv(String dcoatv) {
		this.dcoatv = dcoatv;
	}
	public String getImgRiscoAmbi(){
		return getImgRisco(riscoAmbi);
	}
	public String getImgRiscoBomb(){
		return getImgRisco(riscoBomb);
	}
	public String getImgRiscoVigi(){
		return getImgRisco(riscoVigi);
	}
	public String getImgRiscoPost(){
		return getImgRisco(riscoPost);
	}
	public String getImgRiscoTran(){
		return getImgRisco(riscoTran);
	}
	public String getImgRiscoSIA(){
		return getImgRisco(riscoSIA);
	}
	public String getImgStatus(){
		if(status!= null){
			if(status.equalsIgnoreCase("D")){
				return "/images/externo/deferido.png";
			} else if(status.equalsIgnoreCase("I")){
				return "/images/externo/indeferido.png";
			} else {
				return "/images/externo/analise.png";
			}
		} else {
			return "";
		}
	}
	public String getDescStatus(){
		String resposta = null;
		if(status!= null){
			if(status.equalsIgnoreCase("D")){
				resposta = "DEFERIDO";
			} else if(status.equalsIgnoreCase("I")){
				resposta = "INDEFERIDO";
			} else {
				resposta = "ANÁLISE";
			}
			if(usoConforme!=null){
				resposta += " (" + usoConforme + ")";
			}
			return resposta;
		} else {
			return "";
		}
	}
	public String getImgRisco(String risco){
		if(risco!= null){
			if(risco.equalsIgnoreCase("A")){
				return "/images/externo/red.png";
			} else if(risco.equalsIgnoreCase("M")){
				return "/images/externo/yellow.png";
			} else if(risco.equalsIgnoreCase("B")){
				return "/images/externo/green.png";
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	public String getDescRiscoAmbi(){
		return getDescRisco(riscoAmbi);
	}
	public String getDescRiscoBomb(){
		return getDescRisco(riscoBomb);
	}
	public String getDescRiscoVigi(){
		return getDescRisco(riscoVigi);
	}
	public String getDescRiscoPost(){
		return getDescRisco(riscoPost);
	}
	public String getDescRiscoTran(){
		return getDescRisco(riscoTran);
	}
	public String getDescRiscoSIA(){
		return getDescRisco(riscoSIA);
	}
	public String getDescRisco(String risco){
		if(risco!= null){
			if(risco.equalsIgnoreCase("A")){
				return "ALTO RISCO";
			} else if(risco.equalsIgnoreCase("M")){
				return "MÉDIO RISCO";
			} else if(risco.equalsIgnoreCase("B")){
				return "BAIXO RISCO";
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
	public String getCnaeFormatado(){
		if(codcna!=null){
			if(codcna.length() == 10){
				String cnae = codcna.substring(0,4).concat("-");
				cnae += codcna.substring(4,5).concat("/");
				cnae += codcna.substring(5,7).concat("-");
				cnae += codcna.substring(7,10);
				return cnae;
			} else {
				return codcna;
			}
		} else {
			return "";
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codcna == null) ? 0 : codcna.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CnaVO other = (CnaVO) obj;
		if (codcna == null) {
			if (other.codcna != null)
				return false;
		} else if (!codcna.equals(other.codcna))
			return false;
		return true;
	}
	public Boolean getPrincipal() {
		return principal;
	}
	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}
	
	
}
