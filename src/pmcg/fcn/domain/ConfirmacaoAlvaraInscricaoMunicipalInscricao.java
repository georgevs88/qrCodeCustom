package pmcg.fcn.domain;

import pmcg.fcn.prefeitura.EnumStatusFormalizacao;

import org.apache.cxf.common.util.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class ConfirmacaoAlvaraInscricaoMunicipalInscricao extends ConfirmacaoAlvaraInscricaoMunicipal{
        @XStreamAlias(value="codStatusDef")
        private EnumStatusFormalizacao statusFormalizacao;
        @XStreamAlias(value="alvara")
	private String alvara;
	@XStreamAlias(value="inscricaoMunicipal")
	private String inscricaoMunicipal;
	
	
	
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
	public String getInscricaoMunicipal() {
	    return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
	    this.inscricaoMunicipal = inscricaoMunicipal;
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
		return StringUtils.isEmpty(inscricaoMunicipal) || StringUtils.isEmpty(alvara) ;
	}
		
	public static ConfirmacaoAlvaraInscricaoMunicipalInscricao fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoAlvaraInscricaoMunicipalInscricao.class);
		return (ConfirmacaoAlvaraInscricaoMunicipalInscricao) xstream.fromXML(xml);
	}

	public static String toXml(ConfirmacaoAlvaraInscricaoMunicipalInscricao confirmacao) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoAlvaraInscricaoMunicipalInscricao.class);
		return (String) xstream.toXML(confirmacao);
	}

}