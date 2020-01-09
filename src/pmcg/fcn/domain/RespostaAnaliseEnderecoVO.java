package pmcg.fcn.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias(value = "respostaAnaliseEndereco")
public class RespostaAnaliseEnderecoVO {

	private String protocoloViabilidade;
	@XStreamAlias(value = "analiseEndereco")
	private AnaliseEnderecoVO analiseEnderecoVO;

	public static RespostaAnaliseEnderecoVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(RespostaAnaliseEnderecoVO.class);
		return (RespostaAnaliseEnderecoVO) xstream.fromXML(xml);
	}

	public static String toXML(RespostaAnaliseEnderecoVO resp) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(RespostaAnaliseEnderecoVO.class);
		return xstream.toXML(resp);
	}

	public String getProtocoloViabilidade() {
		return protocoloViabilidade;
	}

	public void setProtocoloViabilidade(String protocoloViabilidade) {
		this.protocoloViabilidade = protocoloViabilidade;
	}

	public AnaliseEnderecoVO getAnaliseEnderecoVO() {
		return analiseEnderecoVO;
	}

	public void setAnaliseEnderecoVO(AnaliseEnderecoVO analiseEnderecoVO) {
		this.analiseEnderecoVO = analiseEnderecoVO;
	}

}