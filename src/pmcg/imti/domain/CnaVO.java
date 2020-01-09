package pmcg.imti.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;

@ZKEntity(label = "CNAE Classe", sequence = "cnae_classe_cnae_id_seq")
public class CnaVO implements ConcorrenciaVO{
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Integer cnaeidcna; //ID
	private String cnaecdcna; //CNAE_CÓDIGO
	private String cnaenmcna; //CNAE_DESCRIÇÃO
	private String urlnotcna; //URL_NOTAS
	private String cnacbocna; //CNAE_CBO
	private String cnameicna; //CNAE_MEI
	public String usualt;
	public Date datalt;
	public String status; //Campo utilizado no simulador
	public String usoConforme; //Campo utilizado no simulador
	public String imgUsoConforme; //Campo utilizado no simulador
	public String riscoAmb; //Campo utilizado no simulador
	public String imgRiscoAmb; //Campo utilizado no simulador
	public String riscoBomb;
	public String imgRiscoBomb; //Campo utilizado no simulador
	public String riscoVig;
	public String imgRiscoVig; //Campo utilizado no simulador
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCnaeidcna() {
		return cnaeidcna;
	}
	public void setCnaeidcna(Integer cnaeidcna) {
		this.cnaeidcna = cnaeidcna;
	}
	public String getCnaecdcna() {
		return cnaecdcna;
	}
	public void setCnaecdcna(String cnaecdcna) {
		this.cnaecdcna = cnaecdcna;
	}

	public String getCnaenmcna() {
		return cnaenmcna;
	}

	public void setCnaenmcna(String cnaenmcna) {
		this.cnaenmcna = cnaenmcna;
	}

	public String getUrlnotcna() {
		return urlnotcna;
	}

	public void setUrlnotcna(String urlnotcna) {
		this.urlnotcna = urlnotcna;
	}

	public String getCnacbocna() {
		return cnacbocna;
	}

	public void setCnacbocna(String cnacbocna) {
		this.cnacbocna = cnacbocna;
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

	public String getUsoConforme() {
		return usoConforme;
	}

	public void setUsoConforme(String usoConforme) {
		this.usoConforme = usoConforme;
	}

	public String getImgUsoConforme() {
		return imgUsoConforme;
	}

	public void setImgUsoConforme(String imgUsoConforme) {
		this.imgUsoConforme = imgUsoConforme;
	}

	public String getRiscoAmb() {
		return riscoAmb;
	}

	public void setRiscoAmb(String riscoAmb) {
		this.riscoAmb = riscoAmb;
	}

	public String getImgRiscoAmb() {
		return imgRiscoAmb;
	}

	public void setImgRiscoAmb(String imgRiscoAmb) {
		this.imgRiscoAmb = imgRiscoAmb;
	}

	public String getRiscoBomb() {
		return riscoBomb;
	}

	public void setRiscoBomb(String riscoBomb) {
		this.riscoBomb = riscoBomb;
	}

	public String getImgRiscoBomb() {
		return imgRiscoBomb;
	}

	public void setImgRiscoBomb(String imgRiscoBomb) {
		this.imgRiscoBomb = imgRiscoBomb;
	}

	public String getRiscoVig() {
		return riscoVig;
	}

	public void setRiscoVig(String riscoVig) {
		this.riscoVig = riscoVig;
	}

	public String getImgRiscoVig() {
		return imgRiscoVig;
	}

	public void setImgRiscoVig(String imgRiscoVig) {
		this.imgRiscoVig = imgRiscoVig;
	}

	public String getDescRes() {
		if(cnaenmcna != null){
			if(cnaenmcna.length() == 65){
				return cnaenmcna;
			} else if(cnaenmcna.length() > 65){
				return cnaenmcna.substring(0,65) + "...";
			} else {
				return cnaenmcna.substring(0,cnaenmcna.length());
			}
		} else {
			return null;
		}
	}
	
	@Override
	public Date getAge() {
		return datalt;
	}
	@Override
	public void setAge(Date age) {
		datalt = age;
	}

	public String getCnameicna() {
		return cnameicna;
	}

	public void setCnameicna(String cnameicna) {
		this.cnameicna = cnameicna;
	}
	
}
