package pmcg.fcn.domain;

import pmcg.fcn.prefeitura.EnumStatusFormalizacao;

import org.apache.cxf.common.util.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConfirmacaoParcialInscricao extends ConfirmacaoAlvaraInscricaoMunicipal {
    @XStreamAlias(value="codStatusIns")
    private EnumStatusFormalizacao statusFormalizacao;
    @XStreamAlias(value="inscricaoMunicipal")
	private String inscricaoMunicipal;

    public EnumStatusFormalizacao getStatusFormalizacao() {
	    return statusFormalizacao;
	}

	public void setStatusFormalizacao(EnumStatusFormalizacao statusFormalizacao) {
	    this.statusFormalizacao = statusFormalizacao;
	}
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }
	
    public boolean invalido() {
	return StringUtils.isEmpty(inscricaoMunicipal);
    }

    public static ConfirmacaoParcialInscricao fromXml(String xml) {
	XStream xstream = new XStream(new DomDriver());
	xstream.autodetectAnnotations(true);
	xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoParcialInscricao.class);
	return (ConfirmacaoParcialInscricao) xstream.fromXML(xml);
    }

    public static String toXml(ConfirmacaoParcialInscricao confirmacao) {
	XStream xstream = new XStream(new DomDriver());
	xstream.autodetectAnnotations(true);
	xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoParcialInscricao.class);
	return (String) xstream.toXML(confirmacao);
    }
}
