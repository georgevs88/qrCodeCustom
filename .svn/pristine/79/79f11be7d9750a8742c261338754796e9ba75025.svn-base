package pmcg.fcn.siat.domain.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import pmcg.fcn.siat.domain.TipoEnderecoCobrancaPessoa;

public class EntradaEnderecoPessoaGravaCadastroEconomico extends EntradaEnderecoGravaCadastroEconomico {

	@XStreamAlias("tipoEndereco")
	private TipoEnderecoCobrancaPessoa tipoEndereco; //NotNull ######################### Tipo do Endereço; obrigatório
	
	@XStreamAlias("dddCelular")
	private Integer dddCelular; //Length(max = 3) DDD do Celular; opcional
	
	@XStreamAlias("celular")
	private Integer celular; //Length(max = 9) Celular; opcional
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	public TipoEnderecoCobrancaPessoa getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEnderecoCobrancaPessoa tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public Integer getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}
}