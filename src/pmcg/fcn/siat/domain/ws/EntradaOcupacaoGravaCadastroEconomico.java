package pmcg.fcn.siat.domain.ws;

import java.util.Date;

import pmcg.fcn.siat.domain.TipoOcupacao;

/**
 * Classe que representa a Entrada da Ocupação do Cadastro Sincronizado. Classe
 * não persistida.
 * @author George do Valle
 * @version 1.0
 * @created 04-ago-2009 10:50:10
 */
public class EntradaOcupacaoGravaCadastroEconomico {

	/**
	 * Código da Ocupação; obrigatório
	 */
	//NotNull #########################
	//Length(max = 10)
	private String codigoOcupacao;
	
	/**
	 * Data Início; obrigatório
	 */
	//NotNull #########################
	private Date dataInicioOcupacao;
	
	/**
	 * Data Fim; opcional
	 */
	private Date dataFimOcupacao;
	
	private EntradaGravaCadastroEconomico entradaGravaCadastroEconomico;
	
	/**
	 *  Tipo da Ocupação; obrigatório
	 */
	//NotNull #########################
	private TipoOcupacao tipoOcupacao;

	public EntradaGravaCadastroEconomico getEntradaGravaCadastroEconomico() {
		return entradaGravaCadastroEconomico;
	}

	public void setEntradaGravaCadastroEconomico(EntradaGravaCadastroEconomico entradaGravaCadastroEconomico) {
		this.entradaGravaCadastroEconomico = entradaGravaCadastroEconomico;
	}

	public String getCodigoOcupacao() {
		return codigoOcupacao;
	}

	public void setCodigoOcupacao(String codigoOcupacao) {
		this.codigoOcupacao = codigoOcupacao;
	}

	public Date getDataInicioOcupacao() {
		return dataInicioOcupacao;
	}

	public void setDataInicioOcupacao(Date dataInicioOcupacao) {
		this.dataInicioOcupacao = dataInicioOcupacao;
	}

	public Date getDataFimOcupacao() {
		return dataFimOcupacao;
	}	

	public void setDataFimOcupacao(Date dataFimOcupacao) {
		this.dataFimOcupacao = dataFimOcupacao;
	}
	
	public TipoOcupacao getTipoOcupacao() {
		return tipoOcupacao;
	}

	public void setTipoOcupacao(TipoOcupacao tipoOcupacao) {
		this.tipoOcupacao = tipoOcupacao;
	}
}