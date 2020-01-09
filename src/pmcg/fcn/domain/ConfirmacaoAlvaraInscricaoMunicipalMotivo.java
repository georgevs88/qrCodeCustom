package pmcg.fcn.domain;

import pmcg.fcn.prefeitura.EnumStatusFormalizacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConfirmacaoAlvaraInscricaoMunicipalMotivo extends ConfirmacaoAlvaraInscricaoMunicipal {	
    	@XStreamAlias(value="motivoFormalizacao")
	private MotivoFormalizacao motivoFormalizacao;
	
	private boolean possuiMotivo(){
	    if(motivoFormalizacao.getMotivo() ==null || "".equals(motivoFormalizacao.getMotivo()))
		return false;
	    else
		return true;
	}
	
	private boolean temMotivo(){
	    if(EnumStatusFormalizacao.E.equals(motivoFormalizacao.getStatusFormalizacao()) || EnumStatusFormalizacao.I.equals(motivoFormalizacao.getStatusFormalizacao()))
		return true;
	    else
		return false;
	}
	
	public boolean invalido() {
		return !possuiMotivo() && !temMotivo();
	}

	public static ConfirmacaoAlvaraInscricaoMunicipalMotivo fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoAlvaraInscricaoMunicipalMotivo.class);
		return (ConfirmacaoAlvaraInscricaoMunicipalMotivo) xstream.fromXML(xml);
	}

	public static String toXml(ConfirmacaoAlvaraInscricaoMunicipalMotivo confirmacao) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoAlvaraInscricaoMunicipal", ConfirmacaoAlvaraInscricaoMunicipalMotivo.class);
		return (String) xstream.toXML(confirmacao);
	}

	public MotivoFormalizacao getMotivoFormalizacao() {
	    return motivoFormalizacao;
	}

	public void setMotivoFormalizacao(MotivoFormalizacao motivoFormalizacao) {
	    this.motivoFormalizacao = motivoFormalizacao;
	}

	

}