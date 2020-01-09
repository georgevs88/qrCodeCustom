package pmcg.fcn.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias(value = "evento")
public class EveVO {
	@XStreamAlias("codigo") @XStreamAsAttribute
	private String codigo;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static EveVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(EveVO.class);
		return (EveVO) xstream.fromXML(xml);
	}

	public static String toXml(EveVO res) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(EveVO.class);
		return xstream.toXML(res);
	}
}
