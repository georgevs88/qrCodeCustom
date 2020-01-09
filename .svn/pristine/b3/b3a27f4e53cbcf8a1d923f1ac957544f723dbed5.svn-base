package pmcg.fcn.prefeitura;

import java.util.List;

import javax.xml.ws.BindingProvider;

import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.domain.ConfirmacaoAlvaraInscricaoMunicipal;
import pmcg.fcn.domain.ConfirmacaoAlvaraInscricaoMunicipalInscricao;
import pmcg.fcn.domain.ConfirmacaoAlvaraInscricaoMunicipalMotivo;
import pmcg.fcn.domain.ConfirmacaoParcialAlvara;
import pmcg.fcn.domain.ConfirmacaoParcialInscricao;
import pmcg.fcn.domain.ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO;
import pmcg.fcn.domain.MotivoFormalizacao;
import pmcg.fcn.domain.RequerimentoEmpreendimentoPrefeituraVO;
import pmcg.fcn.prefeitura.cliente.empreendimento.EmpreendimentoPrefeituraWS;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ClienteEmpreendimento {
    
    public static String recuperaEmpreendimentosDeferidosParaPrefeitura() throws Exception {	
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(EmpreendimentoPrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_empreendimento);
		EmpreendimentoPrefeituraWS servico = (EmpreendimentoPrefeituraWS) proxyFactory.create();	
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.recuperaEmpreendimentosDeferidosParaPrefeitura(getXmlRequerimentoEmpreendimentoPrefeitura());
    }
    
    public static String confirmacaoRecebimentoEmpreendimentoPelaPrefeitura(List<String> protocolosFCNRE) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(EmpreendimentoPrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_empreendimento);
		EmpreendimentoPrefeituraWS servico = (EmpreendimentoPrefeituraWS) proxyFactory.create();
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.confirmacaoRecebimentoEmpreendimentoPelaPrefeitura(getXmlConfirmacaoRecebimentoEmpreendimento(protocolosFCNRE));
    }
    
    public static String confirmaDeferimento(String numeroProcesso, String alvara, String inscricaoMunicipal) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(EmpreendimentoPrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_empreendimento);
		EmpreendimentoPrefeituraWS servico = (EmpreendimentoPrefeituraWS) proxyFactory.create();
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.confirmaAlvaraInscricaoMunicipal(getXmlRespostaDeferimento(numeroProcesso, alvara.replaceAll("/", "").replaceAll("-", ""), inscricaoMunicipal));
    }
    
    public static String confirmaParcialAlvara(String numeroProcesso, String alvara) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(EmpreendimentoPrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_empreendimento);
		EmpreendimentoPrefeituraWS servico = (EmpreendimentoPrefeituraWS) proxyFactory.create();
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.confirmaAlvaraInscricaoMunicipal(getXmlRespostaParcialAlvara(numeroProcesso, alvara));
    }
    
    public static String confirmaParcialInscricao(String numeroProcesso,String inscricaoMunicipal) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(EmpreendimentoPrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_empreendimento);
		EmpreendimentoPrefeituraWS servico = (EmpreendimentoPrefeituraWS) proxyFactory.create();
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.confirmaAlvaraInscricaoMunicipal(getXmlRespostaParcialInscricao(numeroProcesso, inscricaoMunicipal));
    }
    
    public static String confirmaExigencia(String numeroProcesso, String motivo) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(EmpreendimentoPrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_empreendimento);
		EmpreendimentoPrefeituraWS servico = (EmpreendimentoPrefeituraWS) proxyFactory.create();
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.confirmaAlvaraInscricaoMunicipal(getXmlRespostaExigencia(numeroProcesso, motivo));
    }
    
    public static String confirmaIndeferimento(String numeroProcesso, String motivo) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(EmpreendimentoPrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_empreendimento);
		EmpreendimentoPrefeituraWS servico = (EmpreendimentoPrefeituraWS) proxyFactory.create();
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.confirmaAlvaraInscricaoMunicipal(getXmlRespostaIndeferimento(numeroProcesso, motivo));
    }

    private static String getXmlRequerimentoEmpreendimentoPrefeitura() {
		
		RequerimentoEmpreendimentoPrefeituraVO req = new RequerimentoEmpreendimentoPrefeituraVO();
		Long maxReg = Long.parseLong(new CfgDAO().getValorByParam("MAXIMO_REGISTROS_EPD"));
		req.setMaximoRegistros(maxReg);
//		System.out.println("IN:");
//		System.out.println(RequerimentoEmpreendimentoPrefeituraVO.toXml(req));
//		System.out.println("OUT:");
		return RequerimentoEmpreendimentoPrefeituraVO.toXml(req);
    }

    private static String getXmlConfirmacaoRecebimentoEmpreendimento(List<String> numerosProcessos) {
		
		ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO conf = new ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO();	
		conf.setListaProtocoloFcnremp(numerosProcessos);
//		System.out.println("IN:");
//		System.out.println(ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO.toXml(conf));
//		System.out.println("OUT:");
		return ConfirmacaoRecebimentoEmpreendimentoPrefeituraVO.toXml(conf);
    }

    private static String getXmlRespostaDeferimento(String numeroProcesso, String alvara, String inscricaoMunicipal) {
		
		ConfirmacaoAlvaraInscricaoMunicipal resp = new ConfirmacaoAlvaraInscricaoMunicipalInscricao();
		resp.setNumeroProcesso(numeroProcesso);
		((ConfirmacaoAlvaraInscricaoMunicipalInscricao)resp).setAlvara(alvara);
		((ConfirmacaoAlvaraInscricaoMunicipalInscricao)resp).setInscricaoMunicipal(inscricaoMunicipal);
		((ConfirmacaoAlvaraInscricaoMunicipalInscricao)resp).setStatusFormalizacao(EnumStatusFormalizacao.D);
//		System.out.println("IN:");
//		System.out.println(ConfirmacaoAlvaraInscricaoMunicipalInscricao.toXml((ConfirmacaoAlvaraInscricaoMunicipalInscricao)resp));
//		System.out.println("OUT:");
		return ConfirmacaoAlvaraInscricaoMunicipalInscricao.toXml((ConfirmacaoAlvaraInscricaoMunicipalInscricao)resp);
    }
	
    private static String getXmlRespostaParcialAlvara(String numeroProcesso, String alvara){
		ConfirmacaoAlvaraInscricaoMunicipal respPA = new ConfirmacaoParcialAlvara();
		respPA.setNumeroProcesso(numeroProcesso);	
		((ConfirmacaoParcialAlvara)respPA).setAlvara(alvara);
		((ConfirmacaoParcialAlvara)respPA).setStatusFormalizacao(EnumStatusFormalizacao.P);	
		return ConfirmacaoParcialAlvara.toXml((ConfirmacaoParcialAlvara)respPA);
    }
    
    private static String getXmlRespostaParcialInscricao(String numeroProcesso,String inscricaoMunicipal){
		ConfirmacaoAlvaraInscricaoMunicipal respPI = new ConfirmacaoParcialInscricao();
		respPI.setNumeroProcesso(numeroProcesso);
		((ConfirmacaoParcialInscricao)respPI).setInscricaoMunicipal(inscricaoMunicipal);
		((ConfirmacaoParcialInscricao)respPI).setStatusFormalizacao(EnumStatusFormalizacao.P);	
		return ConfirmacaoParcialInscricao.toXml((ConfirmacaoParcialInscricao)respPI);	
    }
	
    private static String getXmlRespostaExigencia(String numeroProcesso, String motivo){
		ConfirmacaoAlvaraInscricaoMunicipal respMO = new ConfirmacaoAlvaraInscricaoMunicipalMotivo();
		respMO.setNumeroProcesso(numeroProcesso);
		((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO).setMotivoFormalizacao(new MotivoFormalizacao());
		((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO).getMotivoFormalizacao().setStatusFormalizacao(EnumStatusFormalizacao.E);
		((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO).getMotivoFormalizacao().setMotivo(motivo);	
		return ConfirmacaoAlvaraInscricaoMunicipalMotivo.toXml((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO);    
    }   
    
    private static String getXmlRespostaIndeferimento(String numeroProcesso, String motivo){
		ConfirmacaoAlvaraInscricaoMunicipal respMO = new ConfirmacaoAlvaraInscricaoMunicipalMotivo();
		respMO.setNumeroProcesso(numeroProcesso);
		((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO).setMotivoFormalizacao(new MotivoFormalizacao());
		((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO).getMotivoFormalizacao().setStatusFormalizacao(EnumStatusFormalizacao.I);
		((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO).getMotivoFormalizacao().setMotivo(motivo);	
		return ConfirmacaoAlvaraInscricaoMunicipalMotivo.toXml((ConfirmacaoAlvaraInscricaoMunicipalMotivo)respMO);
    }   
}
