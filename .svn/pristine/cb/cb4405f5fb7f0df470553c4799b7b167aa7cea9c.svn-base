package pmcg.fcn.siat.domain.ws;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import pmcg.fcn.siat.domain.Sexo;
import pmcg.fcn.siat.domain.TipoEnderecoEntregaPessoa;
import pmcg.fcn.siat.domain.TipoDocumento;

@XStreamAlias(value = "EntradaPessoaCadastroEconomico")
public class EntradaPessoaGravaCadastroEconomico {
	
	public EntradaPessoaGravaCadastroEconomico() {
		
	}
	
	public EntradaPessoaGravaCadastroEconomico(String cpfCnpj) {
		setCpfCnpj(cpfCnpj);
	}

	@XStreamAlias("cpfCnpj")
	private String cpfCnpj; //Length(max = 14) NotNull ######################### CPF ou CNPJ da Pessoa; obrigatório
	
	@XStreamAlias("nomeRazaoSocial")
	private String nomeRazaoSocial; //Length(max = 250) NotNull #########################  Nome ou Razão Social; obrigatório
	 
	@XStreamAlias("nomeRazaoSocialResumido")
	private String nomeRazaoSocialResumido; //NotNull #########################  Nome ou Razão Social Resumido; obrigatório
	
	@XStreamAlias("tipoEnderecoEntregaPessoa")
	private TipoEnderecoEntregaPessoa tipoEnderecoEntregaPessoa; ////NotNull ######################### Tipo do Endereço de Entrega; obrigatório
	
	@XStreamAlias("tipoDocumento")
	private TipoDocumento tipoDocumento; //Tipo de documento; opcional
	
	@XStreamAlias("numeroDocumento")
	private String numeroDocumento; //Length(max = 15)  Número do Documento; opcional
	
	@XStreamAlias("orgaoExpedidor")
	private String orgaoExpedidor; //Length(max = 20) Órgão Expedidor; opcional
	
	@XStreamAlias("ufOrgaoExpedidor")
	private String ufOrgaoExpedidor; //Length(max = 2) UF do Órgão Expedidor; opcional
	
	@XStreamAlias("dataExpedicao")
	private Date dataExpedicao; //Data de Expedição; opcional
	
	@XStreamAlias("dataNascimento")
	private Date dataNascimento; //Data de Nascimento; opcional
	
	@XStreamAlias("paisNaturalidade")
	private String paisNaturalidade; //Length(max = 50) País de Naturalidade; opcional
	
	@XStreamAlias("estadoCivil")
	private String estadoCivil; //Estado Civil; opcional
	
	@XStreamAlias("sexo")
	private Sexo sexo; //Sexo; opcional
	
	@XStreamImplicit(itemFieldName = "EntradaEndereco")
	private List<EntradaEnderecoPessoaGravaCadastroEconomico> entradaEnderecosPessoa; //NotNull #########################
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getNomeRazaoSocialResumido() {
		return nomeRazaoSocialResumido;
	}

	public void setNomeRazaoSocialResumido(String nomeRazaoSocialResumido) {
		if (nomeRazaoSocialResumido != null && (!nomeRazaoSocialResumido.isEmpty()) && nomeRazaoSocialResumido.length() > 50) {
			this.nomeRazaoSocialResumido = nomeRazaoSocialResumido.substring(0, 49);
		} else {		
			this.nomeRazaoSocialResumido = nomeRazaoSocialResumido;
		}
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getPaisNaturalidade() {
		return paisNaturalidade;
	}

	public void setPaisNaturalidade(String paisNaturalidade) {
		this.paisNaturalidade = paisNaturalidade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getUfOrgaoExpedidor() {
		return ufOrgaoExpedidor;
	}

	public void setUfOrgaoExpedidor(String ufOrgaoExpedidor) {
		this.ufOrgaoExpedidor = ufOrgaoExpedidor;
	}

	public List<EntradaEnderecoPessoaGravaCadastroEconomico> getEntradaEnderecosPessoa() {
		return entradaEnderecosPessoa;
	}

	public void setEntradaEnderecosPessoa(List<EntradaEnderecoPessoaGravaCadastroEconomico> entradaEnderecosPessoa) {
		this.entradaEnderecosPessoa = entradaEnderecosPessoa;
	}

	public TipoEnderecoEntregaPessoa getTipoEnderecoEntregaPessoa() {
		return tipoEnderecoEntregaPessoa;
	}

	public void setTipoEnderecoEntregaPessoa(TipoEnderecoEntregaPessoa tipoEnderecoEntregaPessoa) {
		this.tipoEnderecoEntregaPessoa = tipoEnderecoEntregaPessoa;
	}
	
}