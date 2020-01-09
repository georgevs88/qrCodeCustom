package pmcg.fcn.siat.domain.ws;

import java.math.BigDecimal;

public class EntradaParcelaCalculada {
	private String identificacao;
	private String situacao;
	private BigDecimal valorAtualizacaoMonetaria;
	private BigDecimal valorJurosFinanciamento;
	private BigDecimal valorLancado;
	private BigDecimal valorLancadoMoeda;
	private BigDecimal valorPagamento;
	private BigDecimal valorTotal;
	
	public String getIdentificacao() {
		return identificacao;
	}
	
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValorAtualizacaoMonetaria() {
		return valorAtualizacaoMonetaria;
	}
	
	public void setValorAtualizacaoMonetaria(BigDecimal valorAtualizacaoMonetaria) {
		this.valorAtualizacaoMonetaria = valorAtualizacaoMonetaria;
	}
	
	public BigDecimal getValorJurosFinanciamento() {
		return valorJurosFinanciamento;
	}
	
	public void setValorJurosFinanciamento(BigDecimal valorJurosFinanciamento) {
		this.valorJurosFinanciamento = valorJurosFinanciamento;
	}
	
	public BigDecimal getValorLancado() {
		return valorLancado;
	}
	
	public void setValorLancado(BigDecimal valorLancado) {
		this.valorLancado = valorLancado;
	}
	
	public BigDecimal getValorLancadoMoeda() {
		return valorLancadoMoeda;
	}
	
	public void setValorLancadoMoeda(BigDecimal valorLancadoMoeda) {
		this.valorLancadoMoeda = valorLancadoMoeda;
	}
	
	public BigDecimal getValorPagamento() {
		return valorPagamento;
	}
	
	public void setValorPagamento(BigDecimal valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}
