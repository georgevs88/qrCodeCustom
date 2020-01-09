package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;

import pmcg.imti.domain.ArqanxVO;

@ZKEntity(label = "Anx", sequence = "seqanx")
public class AnxVO {
	
	public AnxVO() {
		super();
	}
		
	public AnxVO(Long docanx, String tpdanx) {
		super();
		this.docanx = docanx;
		this.tpdanx = tpdanx;
	}

	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddanx; //iddanx
	private Long docanx; //Documento vinculado (BAE, viabilidade, empreendimento...)
	private String tpdanx; //Tipo Documento vinculado (B = BAE, E=Empreendimento,...)
	private Long arqanx; //ID do arquivo na tabela arqanx (arquivo físico do outro banco)
	private String desanx; //Descrição do arquivo
	private String nomanx; //Nome do arquivo com extensao
	private String usualt; //usualt
	private Date datalt; //datalt
	
	private ArqanxVO arqanxVO;
	
	public Long getIddanx() {
		return iddanx;
	}
	public void setIddanx(Long iddanx) {
		this.iddanx = iddanx;
	}
	public Long getDocanx() {
		return docanx;
	}
	public void setDocanx(Long docanx) {
		this.docanx = docanx;
	}
	public Long getArqanx() {
		return arqanx;
	}
	public void setArqanx(Long arqanx) {
		this.arqanx = arqanx;
	}
	public String getDesanx() {
		return desanx;
	}
	public void setDesanx(String desanx) {
		this.desanx = desanx;
	}
	public String getNomanx() {
		return nomanx;
	}
	public void setNomanx(String nomanx) {
		this.nomanx = nomanx;
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
	public ArqanxVO getArqanxVO() {
		return arqanxVO;
	}
	public void setArqanxVO(ArqanxVO arqanxVO) {
		this.arqanxVO = arqanxVO;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iddanx == null) ? 0 : iddanx.hashCode());
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
		AnxVO other = (AnxVO) obj;
		if (iddanx == null) {
			if (other.iddanx != null)
				return false;
		} else if (!iddanx.equals(other.iddanx))
			return false;
		return true;
	}
	public String getTpdanx() {
		return tpdanx;
	}
	public void setTpdanx(String tpdanx) {
		this.tpdanx = tpdanx;
	}
	
	public Boolean salvo(){
		if(iddanx != null && iddanx > 0){
			return true;
		} else {
			return false;
		}
	}

}
