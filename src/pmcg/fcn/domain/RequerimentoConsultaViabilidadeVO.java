package pmcg.fcn.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias(value = "requerimentoConsultaViabilidade")
public class RequerimentoConsultaViabilidadeVO {

	private Long maximoConsultas;
	
	public static RequerimentoConsultaViabilidadeVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(RequerimentoConsultaViabilidadeVO.class);
		return (RequerimentoConsultaViabilidadeVO) xstream.fromXML(xml);
	}

	public static String toXml(RequerimentoConsultaViabilidadeVO req) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(RequerimentoConsultaViabilidadeVO.class);
		return xstream.toXML(req);
	}

	public Long getMaximoConsultas() {
		return maximoConsultas;
	}

	public void setMaximoConsultas(Long maximoConsultas) {
		this.maximoConsultas = maximoConsultas;
	}

}