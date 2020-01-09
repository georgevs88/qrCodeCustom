package pmcg.fcn.siat.domain.ws;

import java.util.Date;

import pmcg.fcn.siat.domain.Sexo;
import pmcg.fcn.siat.domain.TipoEnderecoEntregaPessoa;


/**
 * Classe que representa a Entrada do Grava Pessoa. 
 * Classe não persistida.
 * 
 * @author Eule Castro
 * 
 * @version 1.0
 * @created 15-fev-2011 14:06:27
 */
public class EntradaGravaPessoa {

	/**
	 * CPF ou CNPJ da Pessoa; 
	 * Obrigatório
	 */
	//NotNull #########################
	//Length(max=14)
	private String cpfCnpj;
	
	/**
	 * Data de Expedição; 
	 * Opcional
	 */
	private Date dataExpedicao;
	
	/**
	 * Data de Nascimento; 
	 * Opcional
	 */
	private Date dataNascimento;
	
	/**
	 * Estado Civil; 
	 * Opcional
	 */
	//Length(max=30)
	private String estadoCivil;
	
	/**
	 * Nome ou Razão Social; 
	 * Obrigatório
	 */
	//NotNull #########################
	//Length(max=250)
	private String nomeRazaoSocial;
	
	/**
	 * Nome ou Razão Social Resumido; 
	 * Obrigatório
	 */
	//NotNull #########################
	//Length(max=50)
	private String nomeRazaoSocialResumido;
	
	/**
	 * Número do Documento; 
	 * Opcional
	 */
	//Length(max=15)
	private String numeroDocumento;
	
	/**
	 * Órgão Expedidor; 
	 * Opcional
	 */
	//Length(max=20)
	private String orgaoExpedidor;
	
	/**
	 * País de Naturalidade; 
	 * Opcional
	 */
	//Length(max=50)
	private String paisNaturalidade;
	
	/**
	 * Sexo; 
	 * Opcional
	 */
	//Length(max=1)
	private Sexo sexo;
	
	/**
	 * Tipo de documento; 
	 * Opcional
	 */
	private TipoDocumento tipoDocumento;
	
	/**
	 * Tipo do Endereço de Entrega; 
	 * Obrigatório
	 */
	//NotNull #########################
	private TipoEnderecoEntregaPessoa tipoEnderecoEntregaPessoa;
	
	/**
	 * UF do Órgão Expedidor; 
	 * Opcional
	 */
	//Length(max=2)
	private String ufOrgaoExpedidor;
	
	/**
	 * endereço da pessoa de entrada;
	 */
	private EntradaGravaEnderecoPessoa entradaEnderecoPessoa;

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
		this.nomeRazaoSocialResumido = nomeRazaoSocialResumido;
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

	public TipoEnderecoEntregaPessoa getTipoEnderecoEntregaPessoa() {
		return tipoEnderecoEntregaPessoa;
	}

	public void setTipoEnderecoEntregaPessoa(
			TipoEnderecoEntregaPessoa tipoEnderecoEntregaPessoa) {
		this.tipoEnderecoEntregaPessoa = tipoEnderecoEntregaPessoa;
	}

	public String getUfOrgaoExpedidor() {
		return ufOrgaoExpedidor;
	}

	public void setUfOrgaoExpedidor(String ufOrgaoExpedidor) {
		this.ufOrgaoExpedidor = ufOrgaoExpedidor;
	}

	public EntradaGravaEnderecoPessoa getEntradaEnderecoPessoa() {
		return entradaEnderecoPessoa;
	}

	public void setEntradaEnderecoPessoa(EntradaGravaEnderecoPessoa entradaEnderecoPessoa) {
		this.entradaEnderecoPessoa = entradaEnderecoPessoa;
	}
}