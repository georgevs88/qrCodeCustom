package pmcg.fcn.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class RequerimentoEmpreendimentoPrefeituraVO {

	private Long maximoRegistros;
		
	public static RequerimentoEmpreendimentoPrefeituraVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("requerimentoEmpreendimentoPrefeitura", RequerimentoEmpreendimentoPrefeituraVO.class);
		return (RequerimentoEmpreendimentoPrefeituraVO) xstream.fromXML(xml);
	}

	public static String toXml(RequerimentoEmpreendimentoPrefeituraVO requerimento) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("requerimentoEmpreendimentoPrefeitura", RequerimentoEmpreendimentoPrefeituraVO.class);
		return (String) xstream.toXML(requerimento);
	}

	public Long getMaximoRegistros() {
		return maximoRegistros;
	}

	public void setMaximoRegistros(Long maximoRegistros) {
		this.maximoRegistros = maximoRegistros;
	}

}