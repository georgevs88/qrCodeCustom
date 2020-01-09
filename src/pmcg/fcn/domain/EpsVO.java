package pmcg.fcn.domain;

import java.util.Date;






public class EpsVO {
	
	
	private Long iddeps; //iddeps
	private String pvieps; //protocoloViabilidade
	private String deseps; //descricaoObjeto
	private Double capeps; //capitalSocial
	private Date dineps; //dataInicioAtividade
	private String emaeps; //email
	private String nomeps; //nome
	public Long getIddeps() {
		return iddeps;
	}
	public void setIddeps(Long iddeps) {
		this.iddeps = iddeps;
	}
	public String getPvieps() {
		return pvieps;
	}
	public void setPvieps(String pvieps) {
		this.pvieps = pvieps;
	}
	public String getDeseps() {
		return deseps;
	}
	public void setDeseps(String deseps) {
		this.deseps = deseps;
	}
	public Double getCapeps() {
		return capeps;
	}
	public void setCapeps(Double capeps) {
		this.capeps = capeps;
	}
	public Date getDineps() {
		return dineps;
	}
	public void setDineps(Date dineps) {
		this.dineps = dineps;
	}
	public String getEmaeps() {
		return emaeps;
	}
	public void setEmaeps(String emaeps) {
		this.emaeps = emaeps;
	}
	public String getNomeps() {
		return nomeps;
	}
	public void setNomeps(String nomeps) {
		this.nomeps = nomeps;
	}

	
	
}
