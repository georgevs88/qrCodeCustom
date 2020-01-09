package pmcg.fcn.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias(value = "municipio")
public class MunVO {
	@XStreamAlias("codigoRFB") @XStreamAsAttribute
	private String codigoRFB;
	
	public String getCodigoRFB() {
		return codigoRFB;
	}

	public void setCodigoRFB(String codigoRFB) {
		this.codigoRFB = codigoRFB;
	}

	public static MunVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(MunVO.class);
		return (MunVO) xstream.fromXML(xml);
	}

	public static String toXml(MunVO res) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(MunVO.class);
		return xstream.toXML(res);
	}
}
