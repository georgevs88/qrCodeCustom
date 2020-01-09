package pmcg.fcn.domain;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO {
    	
    	@XStreamImplicit(itemFieldName="numeroProcesso")
    	private List<String> listaProtocoloFcnremp;	
	
	public static ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoRecebimentoEmpreendimento", ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO.class);
		return (ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO) xstream.fromXML(xml);
	}

	public static String toXml(ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO confirmacao) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("confirmacaoRecebimentoEmpreendimento", ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO.class);
		return (String) xstream.toXML(confirmacao);
	}

	public List<String> getListaProtocoloFcnremp() {
	    return listaProtocoloFcnremp;
	}

	public void setListaProtocoloFcnremp(List<String> listaProtocoloFcnremp) {
	    this.listaProtocoloFcnremp = listaProtocoloFcnremp;
	}

}