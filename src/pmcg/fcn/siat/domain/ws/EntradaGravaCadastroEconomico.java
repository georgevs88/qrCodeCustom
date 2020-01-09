package pmcg.fcn.siat.domain.ws;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.dom4j.io.OutputFormat;

import pmcg.fcn.siat.domain.Boleano;
import pmcg.fcn.siat.domain.RiscoAlvara;
import pmcg.fcn.siat.domain.StatusImpressaoAlvara;
import pmcg.fcn.siat.domain.TipoPessoa;
import pmcg.fcn.siat.domain.TipoUnidade;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

@XStreamAlias(value = "EntradaGravaCadastroEconomico")
public class EntradaGravaCadastroEconomico {
	
	@XStreamAlias("tipoEntrada")
	private TipoEntrada tipoEntrada; //NotNull ######################### Tipo do Arquivo; obrigatório

	@XStreamAlias("inscricaoMunicipal")
	private String inscricaoMunicipal; //Incrição Municipal; opcional
	
	@XStreamAlias("dataAbertura")
	private Date dataAbertura; //NotNull #########################
	
	@XStreamAlias("risco")
	private RiscoAlvara risco; //NotNull #########################
	
	@XStreamAlias("status")
	private StatusImpressaoAlvara status; //NotNull #########################
	
	@XStreamAlias("estabelecido")
	private Boleano estabelecido; //NotNull ######################### Indica se o Cadastro Econômico é estabelecido; obrigatório
	
	@XStreamAlias("naturezaJuridica")
	private String naturezaJuridica; //NotNull ######################### Natureza Jurídica; obrigatório
	
	@XStreamAlias("tipoPessoa")
	private TipoPessoa tipoPessoa; //NotNull ######################### Tipo Pessoa; obrigatório
	
	@XStreamAlias("protocoloCpe")
	private String protocoloCpe; //Length(max = 20) Número Protocolo CPE; opcional
	
	@XStreamAlias("descricaoAtividade")
	private String descricaoAtividade; //Length(max = 4000) - Descrição da Atividade; opcional
	
	@XStreamAlias("nomeFantasia")
	private String nomeFantasia; //Length(max = 55) Nome Fantansia; opcional
	
	@XStreamAlias("tipoEstabelecimento")
	private TipoEstabelecido tipoEstabelecimento; //NotNull ######################### Tipo Estabelecido ; obrigatório
	
	@XStreamAlias("cnpjMatriz")
	private String cnpjMatriz; //Length(max = 14) CNPJ da Matriz; opcional
	
	@XStreamAlias("orgaoRegistro")
	private String orgaoRegistro; //Órgão de Registro; opcional
	
	@XStreamAlias("ufOrgaoRegistro")
	private String ufOrgaoRegistro; //Length(max = 2) UF do Órgão de Registro; opcional
	
	@XStreamAlias("numeroRegistro")
	private String numeroRegistro; //Length(max = 25) Número do Registro; opcional
	
	@XStreamAlias("dataRegistro")
	private Date dataRegistro; //Data Registro; opcional
	
	@XStreamAlias("documentoConstituicao")
	private String documentoConstituicao; //Documento de Constituição; opcional
	
	@XStreamAlias("dataConstituicao")
	private Date dataConstituicao; //Data da Constituição; opcional
	
	@XStreamAlias("livro")
	private String livro; //Length(max = 10) Número do livro; opcional
	
	@XStreamAlias("folha")
	private String folha; //Length(max = 10) Número da folha do livro; opcional
	
	@XStreamAlias("inscricaoEstadual")
	private String inscricaoEstadual; //Length(max = 15) Inscrição Estadual; opcional
	
	@XStreamAlias("porteEmpresa")
	private String porteEmpresa; //Porte da Empresa; opcional
	
	@XStreamAlias("capitalSocial")
	private BigDecimal capitalSocial; //Valor do capital social; opcional
	
	@XStreamAlias("dataUltimaAtualizacaoCapitalSocial")
	private Date dataUltimaAtualizacaoCapitalSocial; //Data Última Atualização Capital Social; opcional
	
	@XStreamAlias("regimeFederal")
	private String regimeFederal; //Regime Federal; opcional
	
	@XStreamAlias("dataInicioRegimeFederal")
	private Date dataInicioRegimeFederal; //Data Início Regime Federal; opcional
	
	@XStreamAlias("tipoUnidade")
	private TipoUnidade tipoUnidade;
	
	@XStreamAlias("tipoUnidadeAuxiliar")
	private String tipoUnidadeAuxiliar;
	
	//-------------------------------------------------------------------
	
	@XStreamAlias("dataColacaoGrau")
	private Date dataColacaoGrau; //Data Colação de Grau; opcional
	
	@XStreamAlias("descricaoOcupacao")
	private String descricaoOcupacao; //Length(max = 4000) Descrição da Ocupação; opcional
	
	@XStreamAlias("estadoTransferencia")
	private String estadoTransferencia; //Estado Transferencia; opcional
	
	@XStreamImplicit(itemFieldName = "formaAtuacaoUnidadeProdutiva")
	private List<String> formaAtuacaoUnidadeProdutiva;
	
	@XStreamAlias("quantidadeEmpregado")
	private Integer quantidadeEmpregado;
	
	//-------------------------------------------------------------------

	@XStreamAlias("EntradaPessoaCadastroEconomico")
	private EntradaPessoaGravaCadastroEconomico entradaPessoa;
	
	@XStreamAlias("EntradaEnderecoLocalizacao")
	private EntradaEnderecoLocalizacaoGravaCadastroEconomico entradaEnderecoLocalizacao;
	
	@XStreamAlias("EntradaEnderecoEntrega")
	private EntradaEnderecoEntregaGravaCadastroEconomico entradaEnderecoEntrega;
	
	@XStreamImplicit(itemFieldName = "EntradaOcupacao")
	private List<EntradaOcupacaoGravaCadastroEconomico> entradasOcupacoes;

	@XStreamImplicit(itemFieldName = "EntradaAtividade")
	private List<EntradaAtividadeGravaCadastroEconomico> entradasAtividades;
	
	@XStreamImplicit(itemFieldName = "EntradaProfissao")
	private List<EntradaProfissaoGravaCadastroEconomico> entradasProfissoes;
	
	@XStreamImplicit(itemFieldName = "EntradaResponsavelContabil")
	private List<EntradaResponsavelContabilGravaCadastroEconomico> entradasResponsaveisContabeis;
	
	@XStreamImplicit(itemFieldName = "EntradaSocioAdministrador")
	private List<EntradaSocioAdmGravaCadastroEconomico> entradasSocios;
	
	@XStreamAlias("entradaDebitos")
	private EntradaDebitosCadastro entradaDebitos;
	
	@XStreamAlias("dataValidadeAlvara")
	private Date dataValidadeAlvara;
	
	@XStreamAlias("resposta")
	private Integer resposta;
	
	@XStreamAlias("mensagem")
	private String mensagem;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------
//	public static EntradaGravaCadastroEconomico fromXml(String xml) {
//		XStream xstream = new XStream(new DomDriver());
//		xstream.autodetectAnnotations(true);
//		xstream.processAnnotations(EntradaGravaCadastroEconomico.class);
//		return (EntradaGravaCadastroEconomico) xstream.fromXML(xml);
//	}
//
	public String toXml(EntradaGravaCadastroEconomico req) {
		
		OutputFormat outPutFormat = new OutputFormat();
		outPutFormat.setExpandEmptyElements(false);
		outPutFormat.setOmitEncoding(true);
		outPutFormat.setSuppressDeclaration(true);
		outPutFormat.setNewLineAfterDeclaration(false);
		outPutFormat.setIndent(true);
		outPutFormat.setNewlines(true);
		outPutFormat.setEncoding("ISO-8859-1");

		Dom4JDriver d4j = new Dom4JDriver(new XmlFriendlyNameCoder("_", "_"));
		d4j.setOutputFormat(outPutFormat);
		XStream xstream = new XStream(d4j);
		xstream.autodetectAnnotations(true);
		xstream.setMode(XStream.NO_REFERENCES); //tira as referencias de objetos
		
		String dateFormat = "ddMMyyyy";
		String timeFormat = "HHmmss";
		String[] acceptableFormats = {timeFormat};
		xstream.registerConverter(new DateConverter(dateFormat, acceptableFormats));
		
		xstream.processAnnotations(EntradaGravaCadastroEconomico.class);
		return xstream.toXML(req);
				
		
//		XStream xstream = new XStream(new DomDriver());
//		xstream.autodetectAnnotations(true);
//		xstream.alias("EntradaGravaCadastroEconomico", EntradaGravaCadastroEconomico.class);
//		return (String) xstream.toXML(req);
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	public BigDecimal getCapitalSocial() {
		return capitalSocial;
	}
	
	public void setCapitalSocial(BigDecimal capitalSocial) {
		this.capitalSocial = capitalSocial;
	}
	
	public String getCnpjMatriz() {
		return cnpjMatriz;
	}
	
	public void setCnpjMatriz(String cnpjMatriz) {
		this.cnpjMatriz = cnpjMatriz;
	}
	
	public Date getDataConstituicao() {
		return dataConstituicao;
	}
	
	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}
	
	public Date getDataInicioRegimeFederal() {
		return dataInicioRegimeFederal;
	}
	
	public void setDataInicioRegimeFederal(Date dataInicioRegimeFederal) {
		this.dataInicioRegimeFederal = dataInicioRegimeFederal;
	}
	
	public Date getDataRegistro() {
		return dataRegistro;
	}
	
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public Date getDataUltimaAtualizacaoCapitalSocial() {
		return dataUltimaAtualizacaoCapitalSocial;
	}
	
	public void setDataUltimaAtualizacaoCapitalSocial(
			Date dataUltimaAtualizacaoCapitalSocial) {
		this.dataUltimaAtualizacaoCapitalSocial = dataUltimaAtualizacaoCapitalSocial;
	}
	
	public Date getDataColacaoGrau() {
		return dataColacaoGrau;
	}

	public void setDataColacaoGrau(Date dataColacaoGrau) {
		this.dataColacaoGrau = dataColacaoGrau;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}
	
	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}
	
	public String getDescricaoOcupacao() {
		return descricaoOcupacao;
	}
	
	public void setDescricaoOcupacao(String descricaoOcupacao) {
		this.descricaoOcupacao = descricaoOcupacao;
	}
	
	public String getDocumentoConstituicao() {
		return documentoConstituicao;
	}
	
	public void setDocumentoConstituicao(String documentoConstituicao) {
		this.documentoConstituicao = documentoConstituicao;
	}
	
	public Boleano getEstabelecido() {
		return estabelecido;
	}
	
	public void setEstabelecido(Boleano estabelecido) {
		this.estabelecido = estabelecido;
	}
	
	public String getEstadoTransferencia() {
		return estadoTransferencia;
	}
	
	public void setEstadoTransferencia(String estadoTransferencia) {
		this.estadoTransferencia = estadoTransferencia;
	}
	
	public String getFolha() {
		return folha;
	}
	
	public void setFolha(String folha) {
		this.folha = folha;
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	public String getLivro() {
		return livro;
	}
	
	public void setLivro(String livro) {
		this.livro = livro;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getNumeroRegistro() {
		return numeroRegistro;
	}
	
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
	public String getOrgaoRegistro() {
		return orgaoRegistro;
	}
	
	public void setOrgaoRegistro(String orgaoRegistro) {
		this.orgaoRegistro = orgaoRegistro;
	}
	
	public String getPorteEmpresa() {
		return porteEmpresa;
	}
	
	public void setPorteEmpresa(String porteEmpresa) {
		this.porteEmpresa = porteEmpresa;
	}
	
	public String getRegimeFederal() {
		return regimeFederal;
	}
	
	public void setRegimeFederal(String regimeFederal) {
		this.regimeFederal = regimeFederal;
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public String getUfOrgaoRegistro() {
		return ufOrgaoRegistro;
	}
	
	public void setUfOrgaoRegistro(String ufOrgaoRegistro) {
		this.ufOrgaoRegistro = ufOrgaoRegistro;
	}
	
	public TipoEntrada getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(TipoEntrada tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(String naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public String getProtocoloCpe() {
		return protocoloCpe;
	}

	public void setProtocoloCpe(String protocoloCpe) {
		this.protocoloCpe = protocoloCpe;
	}

	public Integer getQuantidadeEmpregado() {
		return quantidadeEmpregado;
	}

	public void setQuantidadeEmpregado(Integer quantidadeEmpregado) {
		this.quantidadeEmpregado = quantidadeEmpregado;
	}

	public EntradaPessoaGravaCadastroEconomico getEntradaPessoa() {
		return entradaPessoa;
	}

	public void setEntradaPessoa(EntradaPessoaGravaCadastroEconomico entradaPessoa) {
		this.entradaPessoa = entradaPessoa;
	}

	public List<EntradaOcupacaoGravaCadastroEconomico> getEntradasOcupacoes() {
		return entradasOcupacoes;
	}

	public void setEntradasOcupacoes(List<EntradaOcupacaoGravaCadastroEconomico> entradasOcupacoes) {
		this.entradasOcupacoes = entradasOcupacoes;
	}

	public List<EntradaAtividadeGravaCadastroEconomico> getEntradasAtividades() {
		return entradasAtividades;
	}

	public void setEntradasAtividades(List<EntradaAtividadeGravaCadastroEconomico> entradasAtividades) {
		this.entradasAtividades = entradasAtividades;
	}

	public List<EntradaProfissaoGravaCadastroEconomico> getEntradasProfissoes() {
		return entradasProfissoes;
	}

	public void setEntradasProfissoes(List<EntradaProfissaoGravaCadastroEconomico> entradasProfissoes) {
		this.entradasProfissoes = entradasProfissoes;
	}

	public List<EntradaResponsavelContabilGravaCadastroEconomico> getEntradasResponsaveisContabeis() {
		return entradasResponsaveisContabeis;
	}

	public void setEntradasResponsaveisContabeis(List<EntradaResponsavelContabilGravaCadastroEconomico> entradasResponsaveisContabeis) {
		this.entradasResponsaveisContabeis = entradasResponsaveisContabeis;
	}

	public List<EntradaSocioAdmGravaCadastroEconomico> getEntradasSocios() {
		return entradasSocios;
	}

	public void setEntradasSocios(List<EntradaSocioAdmGravaCadastroEconomico> entradasSocios) {
		this.entradasSocios = entradasSocios;
	}

	public EntradaDebitosCadastro getEntradaDebitos() {
		return entradaDebitos;
	}

	public void setEntradaDebitos(EntradaDebitosCadastro entradaDebitos) {
		this.entradaDebitos = entradaDebitos;
	}

	public TipoEstabelecido getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(TipoEstabelecido tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public EntradaEnderecoLocalizacaoGravaCadastroEconomico getEntradaEnderecoLocalizacao() {
		return entradaEnderecoLocalizacao;
	}

	public void setEntradaEnderecoLocalizacao(EntradaEnderecoLocalizacaoGravaCadastroEconomico entradaEnderecoLocalizacao) {
		this.entradaEnderecoLocalizacao = entradaEnderecoLocalizacao;
	}

	public EntradaEnderecoEntregaGravaCadastroEconomico getEntradaEnderecoEntrega() {
		return entradaEnderecoEntrega;
	}

	public void setEntradaEnderecoEntrega(EntradaEnderecoEntregaGravaCadastroEconomico entradaEnderecoEntrega) {
		this.entradaEnderecoEntrega = entradaEnderecoEntrega;
	}

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(TipoUnidade tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getTipoUnidadeAuxiliar() {
		return tipoUnidadeAuxiliar;
	}
	
	public void setTipoUnidadeAuxiliar(String tipoUnidadeAuxiliar) {
		this.tipoUnidadeAuxiliar = tipoUnidadeAuxiliar;
	}

	public List<String> getFormaAtuacaoUnidadeProdutiva() {
		return formaAtuacaoUnidadeProdutiva;
	}

	public void setFormaAtuacaoUnidadeProdutiva(List<String> formaAtuacaoUnidadeProdutiva) {
		this.formaAtuacaoUnidadeProdutiva = formaAtuacaoUnidadeProdutiva;
	}

	public RiscoAlvara getRisco() {
		return risco;
	}

	public void setRisco(RiscoAlvara risco) {
		this.risco = risco;
	}

	public StatusImpressaoAlvara getStatus() {
		return status;
	}

	public void setStatus(StatusImpressaoAlvara status) {
		this.status = status;
	}

	public Date getDataValidadeAlvara() {
		return dataValidadeAlvara;
	}

	public void setDataValidadeAlvara(Date dataValidadeAlvara) {
		this.dataValidadeAlvara = dataValidadeAlvara;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getResposta() {
		return resposta;
	}

	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}
	
	
}