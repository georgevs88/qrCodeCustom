package pmcg.imti.domain;

import java.util.ArrayList;
import java.util.List;

public class PesGuiaDamTD {

	private String cpfCnpj;
	private String dataExpedicao;
	private String dataNascimento;
	private String estadoCivil;
	private String nomeRazaoSocial;
	private String nomeRazaoSocialResumido;
	private String numeroDocumento;
	private String orgaoExpedidor;
	private String paisNaturalidade;
	private String sexo;
	private String tipoDocumento;
	private String tipoEnderecoEntregaPessoa;
	private String ufOrgaoExpedidor;

	private List<EndPesGuiaDamTD> EntradaGravaEnderecoPessoa; //endereço da pessoa da guia (está em maiusculo por causa do xml)

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoEnderecoEntregaPessoa() {
		return tipoEnderecoEntregaPessoa;
	}

	public void setTipoEnderecoEntregaPessoa(String tipoEnderecoEntregaPessoa) {
		this.tipoEnderecoEntregaPessoa = tipoEnderecoEntregaPessoa;
	}

	public String getUfOrgaoExpedidor() {
		return ufOrgaoExpedidor;
	}

	public void setUfOrgaoExpedidor(String ufOrgaoExpedidor) {
		this.ufOrgaoExpedidor = ufOrgaoExpedidor;
	}

	public List<EndPesGuiaDamTD> getEntradaGravaEnderecoPessoa() {
		return EntradaGravaEnderecoPessoa;
	}

	public void setEntradaGravaEnderecoPessoa(EndPesGuiaDamTD enderecoPessoa) {
		this.EntradaGravaEnderecoPessoa = new ArrayList<EndPesGuiaDamTD>();
		this.EntradaGravaEnderecoPessoa.add(enderecoPessoa);
	}

}
