package pmcg.fcn.domain;

import org.apache.cxf.common.util.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public abstract class ConfirmacaoAlvaraInscricaoMunicipal {

	private String numeroProcesso;
	@XStreamAlias(value="pdfDocAlvaEInsMunicipal")
	private byte[] arquivoPDF;
	
	public boolean possuiNumeroProcesso() {
		return !StringUtils.isEmpty(numeroProcesso);
	}

	public String getNumeroProcesso() {
	    return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
	    this.numeroProcesso = numeroProcesso;
	}

	public byte[] getArquivoPDF() {
	    return arquivoPDF;
	}

	public void setArquivoPDF(byte[] arquivoPDF) {
	    this.arquivoPDF = arquivoPDF;
	}

}