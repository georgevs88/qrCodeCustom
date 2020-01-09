package pmcg.fcn.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

@ZKEntity(label = "Lma", sequence = "seqlma")
public class LmaVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddlma; //iddlma
	private Integer numlma; //Número Licença
	private String esplma; //Espécie (LP,LI,LO,LAS,DISPENSA)
	private String prolma; //Nr processo
	private Date emilma; //Emissão
	private Date vallma; //Validade
	private String reqlma; //Requerente
	private String atvlma; //Atividade
	private String edrlma; //Endereço
	private String reglma; //Região Urbana
	private String analma; //Analista
	private String anclma; //Analista Complementar
	private String elalma; //Elaborado por
	private String obslma; //Observacoes
	private Integer anolma; //Ano
	private String asslma; //Assinatura documento (Chefe DFLA)
	private Boolean muslma; //não autorizado a execucao de musica (neste caso irá aparecer a norma especifica na licenca/dispensa)
	private String usualt; //usualt
	private Date datalt; //datalt
	private String sitlma; //sitlma
	private String cpflma; //CPF/CNPJ Requerente
	
	public Long getIddlma() {
		return iddlma;
	}
	public void setIddlma(Long iddlma) {
		this.iddlma = iddlma;
	}
	public Integer getNumlma() {
		return numlma;
	}
	public void setNumlma(Integer numlma) {
		this.numlma = numlma;
	}
	public String getEsplma() {
		return esplma;
	}
	public void setEsplma(String esplma) {
		this.esplma = esplma;
	}
	public String getProlma() {
		return prolma;
	}
	public void setProlma(String prolma) {
		this.prolma = prolma;
	}
	public Date getEmilma() {
		return emilma;
	}
	public void setEmilma(Date emilma) {
		this.emilma = emilma;
	}
	public Date getVallma() {
		return vallma;
	}
	public void setVallma(Date vallma) {
		this.vallma = vallma;
	}
	public String getReqlma() {
		return reqlma;
	}
	public void setReqlma(String reqlma) {
		this.reqlma = reqlma;
	}
	public String getAtvlma() {
		return atvlma;
	}
	public void setAtvlma(String atvlma) {
		this.atvlma = atvlma;
	}
	public String getEdrlma() {
		return edrlma;
	}
	public void setEdrlma(String edrlma) {
		this.edrlma = edrlma;
	}
	public String getReglma() {
		return reglma;
	}
	public void setReglma(String reglma) {
		this.reglma = reglma;
	}
	public String getAnalma() {
		return analma;
	}
	public void setAnalma(String analma) {
		this.analma = analma;
	}
	public String getElalma() {
		return elalma;
	}
	public void setElalma(String elalma) {
		this.elalma = elalma;
	}
	public String getObslma() {
		return obslma;
	}
	public void setObslma(String obslma) {
		this.obslma = obslma;
	}
	public Integer getAnolma() {
		return anolma;
	}
	public void setAnolma(Integer anolma) {
		this.anolma = anolma;
	}
	public String getAsslma() {
		return asslma;
	}
	public void setAsslma(String asslma) {
		this.asslma = asslma;
	}
	public Boolean getMuslma() {
		return muslma;
	}
	public void setMuslma(Boolean muslma) {
		this.muslma = muslma;
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
	public String getEmissao(){
		if(emilma != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(emilma);
		} else {
			return "";
		}
	}
	public String getValidade(){
		if(vallma != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(vallma);
		} else {
			return "";
		}
	}
	public Integer getAnoEmissao(){
		if(emilma != null){
			return Integer.parseInt(new SimpleDateFormat("yyyy").format(emilma));
		} else {
			return null;
		}
	}
	public String getAnclma() {
		return anclma;
	}
	public void setAnclma(String anclma) {
		this.anclma = anclma;
	}
	public String getLicenca(){
		if(esplma != null && numlma != null && emilma != null){
			if(esplma.equals("LP")){
				return esplma + " Nº 01." + numlma + "/" + new SimpleDateFormat("yyyy").format(emilma);
			} else if(esplma.equals("LI")){
				return esplma + " Nº 02." + numlma + "/" + new SimpleDateFormat("yyyy").format(emilma);
			} else if(esplma.equals("LO")){
				return esplma + " Nº 03." + numlma + "/" + new SimpleDateFormat("yyyy").format(emilma);
			} else if(esplma.equals("LAS")){
				return esplma + " Nº 010." + numlma + "/" + new SimpleDateFormat("yyyy").format(emilma);
			} else {
				return esplma + " Nº " + numlma + "/" + new SimpleDateFormat("yyyy").format(emilma);
			}
		} else {
			return "";
		}
	}
	public String getSitlma() {
		return sitlma;
	}
	public void setSitlma(String sitlma) {
		this.sitlma = sitlma;
	}
	public String getCpflma() {
		return cpflma;
	}
	public void setCpflma(String cpflma) {
		this.cpflma = cpflma;
	}
}
