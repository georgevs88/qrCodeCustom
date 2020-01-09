package pmcg.fcn.siat.domain.ws;




import pmcg.fcn.siat.domain.TipoEnderecoEntregaMob;

public class EntradaEnderecoEntregaGravaCadastroEconomico extends EntradaEnderecoGravaCadastroEconomico {

	private TipoEnderecoEntregaMob tipoEnderecoEntregaMob; //NotNull Tipo do Endereço de Entrega; obrigatório
	private String cpfCnpjPessoa; //Length(max = 14) CPF/CNPJ da Pessoa; obrigatório
	
	//---------------------------------------------------------------------------------------
	
	public String getCpfCnpjPessoa() {
		return cpfCnpjPessoa;
	}
	
	public void setCpfCnpjPessoa(String cpfCnpjPessoa) {
		this.cpfCnpjPessoa = cpfCnpjPessoa;
	}
	
	public TipoEnderecoEntregaMob getTipoEnderecoEntregaMob() {
		return tipoEnderecoEntregaMob;
	}
	
	public void setTipoEnderecoEntregaMob(TipoEnderecoEntregaMob tipoEnderecoEntregaMob) {
		this.tipoEnderecoEntregaMob = tipoEnderecoEntregaMob;
	}
}