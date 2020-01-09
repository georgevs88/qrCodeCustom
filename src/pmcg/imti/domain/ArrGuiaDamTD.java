package pmcg.imti.domain;

import java.util.ArrayList;
import java.util.List;


public class ArrGuiaDamTD {
//<EntradaSolicitaGuiaDamTaxaDiversa>
	private String codigoTaxaDiversa;
	private String codigoCadastro;
	private String numeroCadastro;
	private Integer quantidadeParcelas;
	private String dataBaseLancamento;
	private String observacao;
	private String valorTaxaDiversa;
	private String dataVencimento;
	private String implantaTaxaDiversa;
	private String codigoUnidadeOrganizacional;
	
	private List<PesGuiaDamTD> EntradaGravaPessoa; //Pessoa da Guia (está em maiusculo por causa do xml)
//</EntradaSolicitaGuiaDamTaxaDiversa>
			
			
	public String getCodigoTaxaDiversa() {
		return codigoTaxaDiversa;
	}
	public void setCodigoTaxaDiversa(String codigoTaxaDiversa) {
		this.codigoTaxaDiversa = codigoTaxaDiversa;
	}
	public String getCodigoCadastro() {
		return codigoCadastro;
	}
	public void setCodigoCadastro(String codigoCadastro) {
		this.codigoCadastro = codigoCadastro;
	}
	public String getNumeroCadastro() {
		return numeroCadastro;
	}
	public void setNumeroCadastro(String numeroCadastro) {
		this.numeroCadastro = numeroCadastro;
	}
	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public String getDataBaseLancamento() {
		return dataBaseLancamento;
	}
	public void setDataBaseLancamento(String dataBaseLancamento) {
		this.dataBaseLancamento = dataBaseLancamento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getValorTaxaDiversa() {
		return valorTaxaDiversa;
	}
	public void setValorTaxaDiversa(String valorTaxaDiversa) {
		this.valorTaxaDiversa = valorTaxaDiversa;
	}
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getImplantaTaxaDiversa() {
		return implantaTaxaDiversa;
	}
	public void setImplantaTaxaDiversa(String implantaTaxaDiversa) {
		this.implantaTaxaDiversa = implantaTaxaDiversa;
	}
	public String getCodigoUnidadeOrganizacional() {
		return codigoUnidadeOrganizacional;
	}
	public void setCodigoUnidadeOrganizacional(String codigoUnidadeOrganizacional) {
		this.codigoUnidadeOrganizacional = codigoUnidadeOrganizacional;
	}
	public List<PesGuiaDamTD> getEntradaGravaPessoa() {
		return EntradaGravaPessoa;
	}
	public void setEntradaGravaPessoa(PesGuiaDamTD pessoa) {
		this.EntradaGravaPessoa = new ArrayList<PesGuiaDamTD>();
		this.EntradaGravaPessoa.add(pessoa);
	}


	

}
