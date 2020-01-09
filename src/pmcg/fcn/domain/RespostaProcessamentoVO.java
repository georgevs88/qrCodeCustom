package pmcg.fcn.domain;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias(value = "respostaProcessamento")
public class RespostaProcessamentoVO {

	private String tipoRetorno;
	private String mensagem;
	@XStreamImplicit(itemFieldName = "viabilidade")
	private List<ViaVO> viabilidade;
	
	@XStreamAlias("empreendimentos") @XStreamAsAttribute
	private EpdsVO empreendimentos;
	
	public static RespostaProcessamentoVO fromXml(String xml) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(RespostaProcessamentoVO.class);
		return (RespostaProcessamentoVO) xstream.fromXML(xml);
	}

	public static String toXml(RespostaProcessamentoVO res) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(RespostaProcessamentoVO.class);
		return xstream.toXML(res);
	}
	
	public String getTipoRetorno() {
		return tipoRetorno;
	}
	public void setTipoRetorno(String tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<ViaVO> getViabilidade() {
		return viabilidade;
	}

	public void setViabilidade(List<ViaVO> viabilidade) {
		this.viabilidade = viabilidade;
	}

	public EpdsVO getEmpreendimentos() {
		return empreendimentos;
	}

	public void setEmpreendimentos(EpdsVO empreendimentos) {
		this.empreendimentos = empreendimentos;
	}

	

	
	
	
	
}
