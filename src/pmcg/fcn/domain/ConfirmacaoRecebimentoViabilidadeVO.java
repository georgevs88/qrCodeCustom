package pmcg.fcn.domain;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias(value = "confirmacaoRecebimentoViabilidade")
public class ConfirmacaoRecebimentoViabilidadeVO {
	
	@XStreamImplicit(itemFieldName = "protocoloViabilidade")
	private List<String> listaProtocoloViabilidade;

	public static ConfirmacaoRecebimentoViabilidadeVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.addImmutableType(String.class);
		xstream.processAnnotations(ConfirmacaoRecebimentoViabilidadeVO.class);
		return (ConfirmacaoRecebimentoViabilidadeVO) xstream.fromXML(xml);
	}
	
	public static String toXML(ConfirmacaoRecebimentoViabilidadeVO conf) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(ConfirmacaoRecebimentoViabilidadeVO.class);
		return xstream.toXML(conf);
	}

	public List<String> getListaProtocoloViabilidade() {
		return listaProtocoloViabilidade;
	}

	public void setListaProtocoloViabilidade(List<String> listaProtocoloViabilidade) {
		this.listaProtocoloViabilidade = listaProtocoloViabilidade;
	}

}