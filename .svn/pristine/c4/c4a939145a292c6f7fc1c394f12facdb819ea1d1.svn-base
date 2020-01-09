package pmcg.fcn.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias(value = "naturezaJuridica")
public class NjuVO {
	@XStreamAlias("codigo") @XStreamAsAttribute
	private String codigo;
	
	public static NjuVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(NjuVO.class);
		return (NjuVO) xstream.fromXML(xml);
	}

	public static String toXml(NjuVO res) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(NjuVO.class);
		return xstream.toXML(res);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
