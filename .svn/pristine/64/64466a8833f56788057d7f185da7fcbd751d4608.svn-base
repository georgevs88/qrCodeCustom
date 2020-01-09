package pmcg.fcn.siat.domain.ws;

import java.util.Date;

import pmcg.fcn.siat.domain.TipoProfissao;

/**
 * Classe que representa a Entrada da Profissão do Cadastro Sincronizado. Classe
 * não persistida.
 * @author George do Valle
 * @version 1.0
 * @created 04-ago-2009 10:32:30
 */
public class EntradaProfissaoGravaCadastroEconomico {

	/**
	 * Data Início; obrigatório
	 */
	//NotNull #########################
	private Date dataInicioProfissao;
	
	/**
	 * Data Fim; opcional
	 */
	private Date dataFimProfissao;
	
	
	/**
	 * Data Registro; obrigatório
	 */
	//NotNull #########################
	private Date dataRegistro;
	
	/**
	 * Número Registro; obrigatório
	 */
	//NotNull #########################
	//Length(max = 15)
	private String numeroRegistro;
	
	/**
	 * Sindicato/Conselho; obrigatório
	 */
	//NotNull #########################
	//Length(max = 15)
	private String sindicatoConselho;
	
	/**
	 * Tipo Profissão; obrigatório
	 */
	//NotNull #########################
	private TipoProfissao tipoProfissao;
	
	/**
	 * UF do Registro; obrigatório
	 */
	//NotNull #########################
	//Length(max = 2)
	private String ufRegistro;
	
	private EntradaGravaCadastroEconomico entradaGravaCadastroEconomico;

	public EntradaGravaCadastroEconomico getEntradaGravaCadastroEconomico() {
		return entradaGravaCadastroEconomico;
	}

	public void setEntradaGravaCadastroEconomico(EntradaGravaCadastroEconomico entradaGravaCadastroEconomico) {
		this.entradaGravaCadastroEconomico = entradaGravaCadastroEconomico;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getSindicatoConselho() {
		return sindicatoConselho;
	}

	public void setSindicatoConselho(String sindicatoConselho) {
		this.sindicatoConselho = sindicatoConselho;
	}

	public TipoProfissao getTipoProfissao() {
		return tipoProfissao;
	}

	public void setTipoProfissao(TipoProfissao tipoProfissao) {
		this.tipoProfissao = tipoProfissao;
	}

	public String getUfRegistro() {
		return ufRegistro;
	}

	public void setUfRegistro(String ufRegistro) {
		this.ufRegistro = ufRegistro;
	}

	public Date getDataInicioProfissao() {
		return dataInicioProfissao;
	}

	public void setDataInicioProfissao(Date dataInicioProfissao) {
		this.dataInicioProfissao = dataInicioProfissao;
	}

	public Date getDataFimProfissao() {
		return dataFimProfissao;
	}

	public void setDataFimProfissao(Date dataFimProfissao) {
		this.dataFimProfissao = dataFimProfissao;
	}
}