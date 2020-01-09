package pmcg.imti.domain;

import pmcg.fcn.domain.UfVO;

public class CepVO {
	private String cep_logradouro;
	private String tipo_ofi_logradouro;
	private String nome_ofi_logradouro;
	private String nome_ofi_bai;
	private String nome_ofi_localidade;
	private String nome_completo_ofi;
	private String sigla_uf;
	private UfVO ufVO;
	private Long codtiplog;
	private Long codlog;
	private Long codbai;
	private Long codcid;
	private Long coduf;
	private String numero;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cep_logradouro == null) ? 0 : cep_logradouro.hashCode());
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
		CepVO other = (CepVO) obj;
		if (cep_logradouro == null) {
			if (other.cep_logradouro != null)
				return false;
		} else if (!cep_logradouro.equals(other.cep_logradouro))
			return false;
		return true;
	}

	public String getCep_logradouro() {
		return cep_logradouro;
	}

	public void setCep_logradouro(String cep_logradouro) {
		this.cep_logradouro = cep_logradouro;
	}

	public String getTipo_ofi_logradouro() {
		return tipo_ofi_logradouro;
	}

	public void setTipo_ofi_logradouro(String tipo_ofi_logradouro) {
		if (tipo_ofi_logradouro != null){
			this.tipo_ofi_logradouro = tipo_ofi_logradouro.toUpperCase();
		} else {
		this.tipo_ofi_logradouro = null;
		}
	}

	public String getNome_ofi_logradouro() {
		return nome_ofi_logradouro;
	}

	public void setNome_ofi_logradouro(String nome_ofi_logradouro) {
		if (nome_ofi_logradouro != null){
			this.nome_ofi_logradouro = nome_ofi_logradouro.toUpperCase();
		} else {
		this.nome_ofi_logradouro = null;
		}
	}

	public String getNome_ofi_bai() {
		return nome_ofi_bai;
	}

	public void setNome_ofi_bai(String nome_ofi_bai) {
		if (nome_ofi_bai != null){
			this.nome_ofi_bai = nome_ofi_bai.toUpperCase();
		} else {
		this.nome_ofi_bai = null;
		}
	}

	public String getNome_ofi_localidade() {
		return nome_ofi_localidade;
	}

	public void setNome_ofi_localidade(String nome_ofi_localidade) {
		if (nome_ofi_localidade != null){
			this.nome_ofi_localidade = nome_ofi_localidade.toUpperCase();
		} else {
		this.nome_ofi_localidade = null;
		}
	}

	public String getSigla_uf() {
		return sigla_uf;
	}

	public void setSigla_uf(String sigla_uf) {
		if (sigla_uf != null){
			this.sigla_uf = sigla_uf.toUpperCase();
		} else {
		this.sigla_uf = null;
		}
	}

	public UfVO getUfVO() {
		return ufVO;
	}

	public void setUfVO(UfVO ufVO) {
		this.ufVO = ufVO;
		if (ufVO != null) {
			sigla_uf = ufVO.getSigla();
		} else {
			sigla_uf = null;
		}
	}

	public String getNome_completo_ofi() {
		return nome_completo_ofi;
	}

	public void setNome_completo_ofi(String nome_completo_ofi) {
		if (nome_completo_ofi != null){
			this.nome_completo_ofi = nome_completo_ofi.toUpperCase();
		}else{
			this.nome_completo_ofi = nome_completo_ofi;
		}
	}

	public Long getCodtiplog() {
		return codtiplog;
	}

	public void setCodtiplog(Long codtiplog) {
		this.codtiplog = codtiplog;
	}

	public Long getCodlog() {
		return codlog;
	}

	public void setCodlog(Long codlog) {
		this.codlog = codlog;
	}

	public Long getCodbai() {
		return codbai;
	}

	public void setCodbai(Long codbai) {
		this.codbai = codbai;
	}

	public Long getCodcid() {
		return codcid;
	}

	public void setCodcid(Long codcid) {
		this.codcid = codcid;
	}

	public Long getCoduf() {
		return coduf;
	}

	public void setCoduf(Long coduf) {
		this.coduf = coduf;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
}
