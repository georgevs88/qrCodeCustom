package pmcg.fcn.domain; 

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;

@ZKEntity(table="sosser", sequence="sosser_codser_seq")
public class SerVO implements ConcorrenciaVO{
	@ZKId
	@ZKField(label="C�digo", maxsize=10, width=50, tooltip="C�digo do Servi�o")
	private Integer codser;

 	@ZKField(label="Descri��o", maxsize=15, width=75, tooltip="Descri��o do Servi�o")
	private String desser;

 	@ZKField(label="Data de Altera��o/Inclus�o", maxsize=13, width=65, tooltip="Data de Altera��o/Inclus�o")
	private java.util.Date datalt;

 	@ZKField(label="Usu�rio de Altera��o/Inclus�o", maxsize=12, width=60, tooltip="Data de Altera��o/Inclus�o")
	private String usualt;

	public Integer getCodser(){
		return this.codser; 
	}
 
	public String getDesser(){
		return this.desser; 
	}
 
	public Date getDatalt(){
		return this.datalt; 
	}
 
	public String getUsualt(){
		return this.usualt; 
	}


	public void setCodser(Integer codser){
		this.codser = codser; 
	}
 
	public void setDesser(String desser){
		if (desser != null){
			this.desser = desser.toUpperCase();
		}else{
			this.desser = desser; 
		}
	}
 
	public void setDatalt(java.util.Date datalt){
		this.datalt = datalt; 
	}
 
	public void setUsualt(String usualt){
		this.usualt = usualt; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codser == null) ? 0 : codser.hashCode());
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
		SerVO other = (SerVO) obj;
		if (codser == null) {
			if (other.codser != null)
				return false;
		} else if (!codser.equals(other.codser))
			return false;
		return true;
	}

	@Override
	public Date getAge() {
		return datalt;
	}

	@Override
	public void setAge(Date age) {
		datalt = age;
		
	}
}