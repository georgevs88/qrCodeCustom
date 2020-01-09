package pmcg.fcn.domain;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class AnaliseEnderecoVO {

	private SituacaoAnaliseEndereco situacaoAnaliseEndereco;


	@XStreamConverter(value = DateXmlConverter.class)
	private Date dataValidadeAnalise;

	private String documentacao;

	private String orientacao;

	private String justificativa;

	private String observacao;

	private String taxa;
	
	private byte[] pdfResultado;
	
	@XStreamOmitField
	private List<CnaVO> listAtv;	
	@XStreamOmitField
	private String zonaen;
	@XStreamOmitField
	private String usoaen;
	@XStreamOmitField
	private String timaen;
	
	public List<CnaVO> getListAtv() {
		return listAtv;
	}

	public void setListAtv(List<CnaVO> listAtv) {
		this.listAtv = listAtv;
	}

	public SituacaoAnaliseEndereco getSituacaoAnaliseEndereco() {
		return situacaoAnaliseEndereco;
	}

	public void setSituacaoAnaliseEndereco(
			SituacaoAnaliseEndereco situacaoAnaliseEndereco) {
		this.situacaoAnaliseEndereco = situacaoAnaliseEndereco;
	}

	public byte[] getPdfResultado() {
		return pdfResultado;
	}

	public void setPdfResultado(byte[] pdfResultado) {
		this.pdfResultado = pdfResultado;
	}

	public Date getDataValidadeAnalise() {
		return dataValidadeAnalise;
	}

	public void setDataValidadeAnalise(Date dataValidadeAnalise) {
		this.dataValidadeAnalise = dataValidadeAnalise;
	}

	public String getDocumentacao() {
		return documentacao;
	}

	public void setDocumentacao(String documentacao) {
		this.documentacao = documentacao;
	}

	public String getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

	public String getZonaen() {
		return zonaen;
	}

	public void setZonaen(String zonaen) {
		this.zonaen = zonaen;
	}

	public String getUsoaen() {
		return usoaen;
	}

	public void setUsoaen(String usoaen) {
		this.usoaen = usoaen;
	}

	public String getTimaen() {
		return timaen;
	}

	public void setTimaen(String timaen) {
		this.timaen = timaen;
	}

}