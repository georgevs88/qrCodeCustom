package pmcg.fcn.domain;

import pmcg.fcn.prefeitura.EnumStatusFormalizacao;

import org.apache.cxf.common.util.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConfirmacaoParcialAlvara extends ConfirmacaoAlvaraInscricaoMunicipal {
        @XStreamAlias(value="codStatusAlv")
        private EnumStatusFormalizacao statusFormalizacao;
    	@XStreamAlias(value="alvara")
	private String alvara;

    	public EnumStatusFormalizacao getStatusFormalizacao() {
	    return statusFormalizacao;
	}

	public void setStatusFormalizacao(EnumStatusFormalizacao statusFormalizacao) {
	    this.statusFormalizacao = statusFormalizacao;
	}
	public String getAlvara() {
	    return alvara;
	}

	public void setAlvara(String alvara) {
	    this.alvara = alvara;
	} 
	
	private boolean possuiMotivo(){
		return false;
	}
	
	private boolean temMotivo(){
	    if(EnumStatusFormalizacao.E.equals(getStatusFormalizacao()) || EnumStatusFormalizacao.I.equals(getStatusFormalizacao()))
		return true;
	    else
		return false;
	}
	
	public boolean invalido() {
		return StringUtils.isEmpty(alvara);
	}

	public static ConfirmacaoParcialAlvara fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoParcialAlvara.class);
		return (ConfirmacaoParcialAlvara) xstream.fromXML(xml);
	}

	public static String toXml(ConfirmacaoParcialAlvara confirmacao) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoParcialAlvara.class);
		return (String) xstream.toXML(confirmacao);
	}
}
