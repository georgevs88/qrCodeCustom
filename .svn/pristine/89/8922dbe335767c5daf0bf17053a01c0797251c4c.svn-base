package pmcg.fcn.siat.domain.ws;

import java.math.BigDecimal;
import java.util.Date;

import pmcg.fcn.siat.domain.Boleano;
import pmcg.fcn.siat.domain.TipoSocio;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EntradaSocioAdmGravaCadastroEconomico {
	
	private TipoSocio tipoSocio; //NotNull #########################  Tipo de Sócio; obrigatório
	private Long qualificacaoSocio; //NotNull ######################### Número da Qualificação; obrigatório
	private Date dataEntradaSocio; //NotNull ######################### Data de Entrada Sócio; obrigatório
	private Date dataSaidaSocio; // Data de Saída Sócio; obrigatório
	private BigDecimal percentualParticipacao; //Percentual Participação; opcional
	private BigDecimal valorParticipacao; //Valor da participação; opcional
	private Boleano responsavelLegal; //NotNull ######################### Indica se o sócio é responsável legal; obrigatório
	private Date dataInicioResponsavelLegal; //Data Início Mandato Responsável Legal; opcional
	private Date dataFimResponsavelLegal; //Data Fim Mandato Responsável Legal; opcional
	private Boleano possuiRepresentanteLegal; ////NotNull ######################### Indica se o sócio possue Representante Legal; obrigatório
	private Long qualificacaoRepresentanteLegal; //Número da Qualificação do Representante Legal; opcional
	private Date dataInicioRepresentanteLegal; //Data Início Mandato Representante Legal; opcional
	private Date dataFimRepresentanteLegal; //Data Fim Mandato Representante Legal; opcional
	@XStreamAlias("EntradaPessoaSocio")
	private EntradaPessoaGravaCadastroEconomico entradaPessoaSocio;
	@XStreamAlias("EntradaPessoaRepresentante")
	private EntradaPessoaGravaCadastroEconomico entradaPessoaRepresentante;

	private EntradaGravaCadastroEconomico entradaGravaCadastroEconomico;
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------

	public EntradaGravaCadastroEconomico getEntradaGravaCadastroEconomico() {
		return entradaGravaCadastroEconomico;
	}

	public void setEntradaGravaCadastroEconomico(EntradaGravaCadastroEconomico entradaGravaCadastroEconomico) {
		this.entradaGravaCadastroEconomico = entradaGravaCadastroEconomico;
	}

	public Date getDataEntradaSocio() {
		return dataEntradaSocio;
	}

	public void setDataEntradaSocio(Date dataEntradaSocio) {
		this.dataEntradaSocio = dataEntradaSocio;
	}

	public Date getDataSaidaSocio() {
		return dataSaidaSocio;
	}

	public void setDataSaidaSocio(Date dataSaidaSocio) {
		this.dataSaidaSocio = dataSaidaSocio;
	}

	public BigDecimal getPercentualParticipacao() {
		return percentualParticipacao;
	}

	public void setPercentualParticipacao(BigDecimal percentualParticipacao) {
		this.percentualParticipacao = percentualParticipacao;
	}

	public Boleano getPossuiRepresentanteLegal() {
		return possuiRepresentanteLegal;
	}

	public void setPossuiRepresentanteLegal(Boleano possuiRepresentanteLegal) {
		this.possuiRepresentanteLegal = possuiRepresentanteLegal;
	}

	public Long getQualificacaoRepresentanteLegal() {
		return qualificacaoRepresentanteLegal;
	}

	public void setQualificacaoRepresentanteLegal(
			Long qualificacaoRepresentanteLegal) {
		this.qualificacaoRepresentanteLegal = qualificacaoRepresentanteLegal;
	}

	public Long getQualificacaoSocio() {
		return qualificacaoSocio;
	}

	public void setQualificacaoSocio(Long qualificacaoSocio) {
		this.qualificacaoSocio = qualificacaoSocio;
	}

	public Boleano getResponsavelLegal() {
		return responsavelLegal;
	}

	public void setResponsavelLegal(Boleano responsavelLegal) {
		this.responsavelLegal = responsavelLegal;
	}

	public TipoSocio getTipoSocio() {
		return tipoSocio;
	}

	public void setTipoSocio(TipoSocio tipoSocio) {
		this.tipoSocio = tipoSocio;
	}

	public BigDecimal getValorParticipacao() {
		return valorParticipacao;
	}

	public void setValorParticipacao(BigDecimal valorParticipacao) {
		this.valorParticipacao = valorParticipacao;
	}

	public Date getDataFimRepresentanteLegal() {
		return dataFimRepresentanteLegal;
	}

	public void setDataFimRepresentanteLegal(Date dataFimRepresentanteLegal) {
		this.dataFimRepresentanteLegal = dataFimRepresentanteLegal;
	}

	public Date getDataFimResponsavelLegal() {
		return dataFimResponsavelLegal;
	}

	public void setDataFimResponsavelLegal(Date dataFimResponsavelLegal) {
		this.dataFimResponsavelLegal = dataFimResponsavelLegal;
	}

	public Date getDataInicioRepresentanteLegal() {
		return dataInicioRepresentanteLegal;
	}

	public void setDataInicioRepresentanteLegal(Date dataInicioRepresentanteLegal) {
		this.dataInicioRepresentanteLegal = dataInicioRepresentanteLegal;
	}

	public Date getDataInicioResponsavelLegal() {
		return dataInicioResponsavelLegal;
	}

	public void setDataInicioResponsavelLegal(Date dataInicioResponsavelLegal) {
		this.dataInicioResponsavelLegal = dataInicioResponsavelLegal;
	}

	public EntradaPessoaGravaCadastroEconomico getEntradaPessoaSocio() {
		return entradaPessoaSocio;
	}

	public void setEntradaPessoaSocio(EntradaPessoaGravaCadastroEconomico entradaPessoaSocio) {
		this.entradaPessoaSocio = entradaPessoaSocio;
	}

	public EntradaPessoaGravaCadastroEconomico getEntradaPessoaRepresentante() {
		return entradaPessoaRepresentante;
	}

	public void setEntradaPessoaRepresentante(EntradaPessoaGravaCadastroEconomico entradaPessoaRepresentante) {
		this.entradaPessoaRepresentante = entradaPessoaRepresentante;
	}
	
}