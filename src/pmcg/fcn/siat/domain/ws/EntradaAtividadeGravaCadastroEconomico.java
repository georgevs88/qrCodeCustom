package pmcg.fcn.siat.domain.ws;

import java.util.Date;

import pmcg.fcn.siat.domain.TipoAtividade;


/**
 * Classe que representa a Entrada da Atividade do Cadastro Sincronizado. Classe
 * não persistida.
 * @author George do Valle
 * @version 1.0
 * @created 04-ago-2009 10:50:18
 */
public class EntradaAtividadeGravaCadastroEconomico {

	/**
	 * Código da Atividade; obrigatório
	 */
	//NotNull
	//Length(max = 15)
	private String codigoAtividade;
	
	/**
	 * Data Início; obrigatório
	 */
	//NotNull
	private Date dataInicioAtividade;
	
	/**
	 * Data Fim; opcional
	 */
	private Date dataFimAtividade;
	
	/**
	 * Tipo da Atividade; obrigatório
	 */
	//NotNull
	private TipoAtividade tipoAtividade;
	
	private EntradaGravaCadastroEconomico entradaGravaCadastroEconomico;

	public EntradaGravaCadastroEconomico getEntradaGravaCadastroEconomico() {
		return entradaGravaCadastroEconomico;
	}

	public void setEntradaGravaCadastroEconomico(EntradaGravaCadastroEconomico entradaGravaCadastroEconomico) {
		this.entradaGravaCadastroEconomico = entradaGravaCadastroEconomico;
	}

	public String getCodigoAtividade() {
		return codigoAtividade;
	}

	public void setCodigoAtividade(String codigoAtividade) {
		this.codigoAtividade = codigoAtividade;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Date getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(Date dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public Date getDataFimAtividade() {
		return dataFimAtividade;
	}

	public void setDataFimAtividade(Date dataFimAtividade) {
		this.dataFimAtividade = dataFimAtividade;
	}

}