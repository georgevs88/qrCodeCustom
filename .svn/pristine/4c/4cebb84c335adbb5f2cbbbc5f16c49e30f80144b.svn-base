package pmcg.fcn.prefeitura;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pmcg.fcn.dao.ibatis.AatDAO;
import pmcg.fcn.dao.ibatis.AenDAO;
import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.AatVO;
import pmcg.fcn.domain.AenVO;
import pmcg.fcn.domain.AnaliseEnderecoVO;
import pmcg.fcn.domain.CnaVO;
import pmcg.fcn.domain.ConfirmacaoRecebimentoViabilidadeVO;
import pmcg.fcn.domain.RequerimentoConsultaViabilidadeVO;
import pmcg.fcn.domain.RespostaAnaliseEnderecoVO;
import pmcg.fcn.domain.SituacaoAnaliseEndereco;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.prefeitura.cliente.viabilidade.ViabilidadePrefeituraWS;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class ClienteViabilidade {
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteViabilidade.class);
    
	public static String recuperaViabilidadesPendentes() throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(ViabilidadePrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_viabilidade);
		ViabilidadePrefeituraWS servico = (ViabilidadePrefeituraWS) proxyFactory.create();

		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
	
	 	ClienteSSL.configurar_Cliente_SSL(servico);
	 	return servico.recuperaViabilidadesPendentes(getXmlRequerimentoConsultaViabilidade());
    }
    
    public static String confirmaRecebimentoConsulta(String protocoloViabilidade) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(ViabilidadePrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_viabilidade);
		ViabilidadePrefeituraWS servico = (ViabilidadePrefeituraWS) proxyFactory.create();
		
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		
		ClienteSSL.configurar_Cliente_SSL(servico);
		return servico.confirmaRecebimentoViabilidade(getXmlConfirmacaoRecebimentoConsulta(protocoloViabilidade));
	}
    
	public static String confirmaRespostaAnaliseEndereco(String protocoloViabilidade, Long iddvia) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(ViabilidadePrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_viabilidade);
		ViabilidadePrefeituraWS servico = (ViabilidadePrefeituraWS) proxyFactory.create();
		
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		
		ClienteSSL.configurar_Cliente_SSL(servico);
		AnaliseEnderecoVO ae = criaAnaliseEndereco(protocoloViabilidade, iddvia);
		//SÓ ENVIA A RESPOSTA PARA A JUNTA SE FOR "DEFERIDO" OU "INDEFERIDO"
		String resposta = null, tipoRetorno = null;
		if(protocoloViabilidade.startsWith("CGR")){ 
			tipoRetorno = "SUCESSO"; //SE FOR PROTOCOLO DA PREFEITURA SIMULA UMA RESPOSTA OK DO WS DA JUNTA
		} else {
			if(ae.getSituacaoAnaliseEndereco().getDescricao().equalsIgnoreCase("DEFERIDA") || ae.getSituacaoAnaliseEndereco().getDescricao().equalsIgnoreCase("INDEFERIDA")){
				resposta = servico.confirmaRespostaAnaliseEndereco(getXmlRespostaAnaliseEndereco(protocoloViabilidade, ae));
				tipoRetorno = resposta.replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
			}
		}
		//System.out.println(tipoRetorno);
		//SALVA A ANÁLISE SE (ANÁLISE) OU (DEFERIDO/INDEFERIDO E "SUCESSO")
		if((tipoRetorno == null) || (tipoRetorno != null && tipoRetorno.equals("SUCESSO"))){
			//SALVA A ANALISE DE ENDERECO 
			AenVO aen = new AenVO();
			aen.setValaen(ae.getDataValidadeAnalise());
			aen.setProaen(protocoloViabilidade);
			aen.setSitaen(ae.getSituacaoAnaliseEndereco().getDescricao());
			aen.setJusaen(ae.getJustificativa());
			aen.setObsaen(ae.getObservacao());
			aen.setDocaen(ae.getDocumentacao());
			aen.setOriaen(ae.getOrientacao());
			aen.setTaxaen(ae.getTaxa());
			aen.setUsualt("SISTEMA");
			aen.setZonaen(ae.getZonaen());
			aen.setUsoaen(ae.getUsoaen());
			aen.setTimaen(ae.getTimaen());
			
			if(ae.getListAtv() != null){
				HashMap<String, String> riscos = getRiscoGeral(ae.getListAtv());
				aen.setRisaen(riscos.get("risger"));
				aen.setAmbaen(riscos.get("risamb"));
				aen.setBomaen(riscos.get("risbom"));
				aen.setVigaen(riscos.get("risvig"));
				aen.setPosaen(riscos.get("rispos"));
				aen.setTraaen(riscos.get("ristra"));
				aen.setSiaaen(riscos.get("rissia"));
			}
			
			Long iddaen = null;
			try {
				iddaen = (Long) new AenDAO().insReg(aen);
			} catch (SQLException e) {
				logger.error("Erro ao inserir Analise Endereço no BD (" + protocoloViabilidade + ").");
				e.printStackTrace();
			}
			if(ae.getListAtv() != null){
				for (CnaVO cna : ae.getListAtv()) { //SALVA A ANALISE DAS ATIVIDADES 
					AatVO aat = new AatVO();
					aat.setAenaat(iddaen);
					aat.setCnaaat(Util.formataCnaeSemMascara(cna.getCodcna() + (cna.getDescna()!=null?cna.getDescna():"")));
					aat.setStaaat(cna.getStatus());
					aat.setUsoaat(cna.getUsoConforme());
					aat.setExeaat(cna.getExecna());
					aat.setAmbaat(cna.getRiscoAmbi());
					aat.setBomaat(cna.getRiscoBomb());
					aat.setVigaat(cna.getRiscoVigi());
					aat.setPosaat(cna.getRiscoPost());
					aat.setTraaat(cna.getRiscoTran());
					aat.setSiaaat(cna.getRiscoSIA());
					new AatDAO().insReg(aat);
				}
			}
			try { // ATUALIZA A VIABILIDADE COM O IDDAEN GERADO
				ViaVO viaupd = new ViaVO();
				viaupd.setIddvia(iddvia);
				viaupd.setProvia(protocoloViabilidade);
				viaupd.setAenvia(iddaen);
				new ViaDAO().updAnaliseEnderecoByIdd(viaupd);
			} catch (SQLException e) {
				logger.error("Erro ao atualizar analise de endereco da tabela de viabilidade");
				e.printStackTrace();
			}
		} 
		return resposta;
	}
	
	public static HashMap<String, String> getRiscoGeral(List<CnaVO> listAtv) {
		HashMap<String, String> result = new HashMap<String ,String>();
		
		String riscoGeral = "B", risamb = "B", risbom = "B", risvig = "B", rispos = "B", ristra = "B", rissia = "B";
		//RISCO GERAL
		for (CnaVO cna : listAtv) {
			if(cna.getRiscoAmbi() != null && cna.getRiscoBomb() != null && cna.getRiscoVigi() != null && cna.getRiscoPost() != null && cna.getRiscoTran() != null && cna.getRiscoSIA() != null){
				if(cna.getRiscoAmbi().equals("A") || cna.getRiscoBomb().equals("A") || cna.getRiscoVigi().equals("A") || cna.getRiscoPost().equals("A")
					|| cna.getRiscoTran().equals("A") || cna.getRiscoSIA().equals("A")){
					riscoGeral = "A";
					break;
				} else if(cna.getRiscoAmbi().equals("M") || cna.getRiscoBomb().equals("M") || cna.getRiscoVigi().equals("M") || cna.getRiscoPost().equals("M")
						|| cna.getRiscoTran().equals("M") || cna.getRiscoSIA().equals("M")){
					riscoGeral = "M";
				} 
			}
		}
		//RISCO GERAL AMB
		for (CnaVO cna : listAtv) {
			if(cna.getRiscoAmbi() != null){
				if(cna.getRiscoAmbi().equals("A")){
					risamb = "A";
					break;
				} else if(cna.getRiscoAmbi().equals("M")){
					risamb = "M";
				} 
			}
		}
		//RISCO GERAL BOM
		for (CnaVO cna : listAtv) {
			if(cna.getRiscoBomb() != null){
				if(cna.getRiscoBomb().equals("A")){
					risbom = "A";
					break;
				} else if(cna.getRiscoBomb().equals("M")){
					risbom = "M";
				} 
			}
		}
		//RISCO GERAL VIG
		for (CnaVO cna : listAtv) {
			if(cna.getRiscoVigi() != null){
				if(cna.getRiscoVigi().equals("A")){
					risvig = "A";
					break;
				} else if(cna.getRiscoVigi().equals("M")){
					risvig = "M";
				} 
			}
		}
		//RISCO GERAL POS
		for (CnaVO cna : listAtv) {
			if(cna.getRiscoPost() != null){
				if(cna.getRiscoPost().equals("A")){
					rispos = "A";
					break;
				} else if(cna.getRiscoPost().equals("M")){
					rispos = "M";
				} 
			}
		}
		//RISCO GERAL TRA
		for (CnaVO cna : listAtv) {
			if(cna.getRiscoTran() != null){
				if(cna.getRiscoTran().equals("A")){
					ristra = "A";
					break;
				} else if(cna.getRiscoTran().equals("M")){
					ristra = "M";
				} 
			}
		}
		//RISCO GERAL SIA
		for (CnaVO cna : listAtv) {
			if(cna.getRiscoSIA() != null){
				if(cna.getRiscoSIA().equals("A")){
					rissia = "A";
					break;
				} else if(cna.getRiscoSIA().equals("M")){
					rissia = "M";
				} 
			}
		}
		
		result.put("risger", riscoGeral);
		result.put("risamb", risamb);
		result.put("risbom", risbom);
		result.put("risvig", risvig);
		result.put("rispos", rispos);
		result.put("ristra", ristra);
		result.put("rissia", rissia);
		return result;
	}

	public static HashMap<String, String> confirmaRespostaAnaliseEndereco(String xmlRespostaAnaliseEndereco) throws Exception {
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass(ViabilidadePrefeituraWS.class);
		proxyFactory.setAddress(Constantes.Servico.url_servico_viabilidade);
		ViabilidadePrefeituraWS servico = (ViabilidadePrefeituraWS) proxyFactory.create();
		
		BindingProvider provider = (BindingProvider) servico;
		provider.getRequestContext().put(BindingProvider.SOAPACTION_USE_PROPERTY, "true");
		provider.getRequestContext().put("javax.xml.ws.client.connectionTimeout", 300000);
		provider.getRequestContext().put("javax.xml.ws.client.receiveTimeout", 300000);
		
		ClienteSSL.configurar_Cliente_SSL(servico);
		String resposta = null, tipoRetorno = null, tipoRetornoVia = null,mensagem = null;
		resposta = servico.confirmaRespostaAnaliseEndereco(xmlRespostaAnaliseEndereco);
		HashMap<String, String> resp = new HashMap<String, String>();
		tipoRetornoVia = resposta.replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
		tipoRetorno = resposta.replaceAll("\n", "").replaceFirst("^.*<TipoRetorno>", "").replaceFirst("</TipoRetorno>.*", "");
		mensagem = resposta.replaceAll("\n", "").replaceFirst("^.*<mensagem>", "").replaceFirst("</mensagem>.*", "");
		resp.put("tipoRetornoVia", tipoRetornoVia);
		resp.put("tipoRetorno", tipoRetorno);
		resp.put("mensagem", mensagem);
		return resp;
	}

    private static String getXmlRequerimentoConsultaViabilidade() {
		RequerimentoConsultaViabilidadeVO req = new RequerimentoConsultaViabilidadeVO();
		Long maxReg = Long.parseLong(new CfgDAO().getValorByParam("MAXIMO_REGISTROS_VIA"));
		req.setMaximoConsultas(maxReg);
		//System.out.println(RequerimentoConsultaViabilidadeVO.toXml(req));
		return RequerimentoConsultaViabilidadeVO.toXml(req);
    }

    private static String getXmlConfirmacaoRecebimentoConsulta(String protocoloViabilidade) {
		ConfirmacaoRecebimentoViabilidadeVO conf = new ConfirmacaoRecebimentoViabilidadeVO();
		List<String> protocolos = new ArrayList<String>();
		protocolos.add(protocoloViabilidade);
		conf.setListaProtocoloViabilidade(protocolos);
		return ConfirmacaoRecebimentoViabilidadeVO.toXML(conf);
    }

    private static String getXmlRespostaAnaliseEndereco(String protocoloViabilidade, AnaliseEnderecoVO analise) {
		RespostaAnaliseEnderecoVO resp = new RespostaAnaliseEnderecoVO();
		resp.setProtocoloViabilidade(protocoloViabilidade);
		resp.setAnaliseEnderecoVO(analise);
		return RespostaAnaliseEnderecoVO.toXML(resp);
    }

    private static AnaliseEnderecoVO criaAnaliseEndereco(String protocoloViabilidade, Long iddvia) throws IOException {
    	try {
			AnaliseEnderecoVO ae = new AnaliseEnderecoVO();
			Calendar validade = Calendar.getInstance();
			validade.add(Calendar.DATE, + Constantes.Servico.validade_analise_endereco);
			ae.setDataValidadeAnalise(validade.getTime());
			
			//################################################################################################################
			List<String> atvIndeferidas = new ArrayList<String>(); 
			List<String> atvDeferidas = new ArrayList<String>();
			
			//pegando a inscricao municipal de viabilidade/coleta/coletaEndereco
			HashMap<String, Object> dadosVia = new ViaDAO().getDadosByProtocolo(protocoloViabilidade);
			//SE ->   protocolo CGR E ((MEI E ñ possui est. fixo) OU (AUTONOMO E NAO ESTABELECIDO)) defere direto pois não precisam de guia
			if(dadosVia.get("provia").toString().startsWith("CGR") && (!(Boolean) dadosVia.get("possuiestabelecimentofixo"))){
				ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.DEFERIDA);
				ae.setJustificativa("Não estabelecido.");
				ae.setObservacao("Parecer Automático.");
			}
			
			String inscricaoImob = dadosVia.get("iptcen").toString();
			//VALIDA INSCRICAO MUNICIPAL
			inscricaoImob = FormatUtils.onlyNumbers(inscricaoImob);
			if(inscricaoImob.length() > 11){
				ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.INDEFERIDA);
				ae.setJustificativa("Inscrição Imobiliária inválida (deve conter 11 dígitos).");
				ae.setObservacao("Parecer Automático.");
				return ae;
			} else {
				inscricaoImob = Formatacao.zeroEsquerda(inscricaoImob, 11);
			}
			
			HashMap<String, Object> dadosImovel = new ImoDAO().getDadosByInscricao(Formatacao.zeroEsquerda(inscricaoImob,11));
			if(dadosImovel == null || dadosImovel.get("IMO_COD") == null){
				ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.INDEFERIDA);
				ae.setJustificativa("Inscrição Imobiliária inválida.");
				ae.setObservacao("Parecer Automático.");
				return ae;
			} else if(dadosImovel != null && dadosImovel.get("IMO_STATUS") != null && (dadosImovel.get("IMO_STATUS").toString().equals("43") || dadosImovel.get("IMO_STATUS").toString().equals("94"))){
				ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.INDEFERIDA);
				ae.setJustificativa("Inscrição Imobiliária Desativada ou 'Inibe Conta'.");
				ae.setObservacao("Parecer Automático.");
				return ae;
			} else if(dadosImovel != null && dadosImovel.get("PROPRIETARIO") != null && new ViaDAO().countProprietario(dadosImovel.get("PROPRIETARIO").toString()) > 0){
				ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.EM_ESTUDO);
				ae.setJustificativa("VERIFICAR PROPRIETÁRIO.");
				ae.setObservacao("Parecer Automático.VERIFICAR PROPRIETÁRIO.");
				return ae;
			} else {
				HashMap<String, Object> analiseImovel = Util.analisaZonaUsoImovel(Formatacao.zeroEsquerda(inscricaoImob, 11));
				if(analiseImovel.get("descZonas") == null){
					ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.EM_ESTUDO);
					ae.setObservacao("Inscrição Imobiliária sem zoneamento.");
					return ae;
				} else {
					ae.setListAtv(new CnaDAO().getRegByProtocoloVia(protocoloViabilidade));
					
					Boolean autonomo = false;
					Boolean mei = false;
					if(dadosVia.get("tipvia") != null && dadosVia.get("tipvia").toString().equals("A")){
						autonomo = true;
					} else if(dadosVia.get("tipvia") != null && dadosVia.get("tipvia").toString().equals("M")){
						mei = true;
					}
					for (CnaVO cna : ae.getListAtv()) {
						cna = Util.analisaAtv(inscricaoImob, cna, ((Boolean) dadosVia.get("escritorio")), autonomo, mei);
					}
					
					ae.setZonaen(analiseImovel.get("descZonas")!=null?analiseImovel.get("descZonas").toString():null);
					ae.setUsoaen(analiseImovel.get("descUsos")!=null?analiseImovel.get("descUsos").toString():null);
					ae.setTimaen(analiseImovel.get("tipoImovel")!=null?analiseImovel.get("tipoImovel").toString():null);
					
					Boolean indeferida = false;
					Boolean analiseTerritorial = false;
					Boolean analisePorte = false;
					
					Boolean todosUsosIguais = true;
					String usocomum = ae.getListAtv().get(0).getUsoConforme()!=null?ae.getListAtv().get(0).getUsoConforme():"-";
					for (CnaVO cna : ae.getListAtv()) {
						if(!usocomum.equalsIgnoreCase(cna.getUsoConforme()!=null?cna.getUsoConforme():"-")){
							todosUsosIguais = false;
							break;
						}
					}
					
					for (CnaVO cna : ae.getListAtv()) { //se possui pelo menos uma atividade não permitida indefere
						String cnae = Util.formataCnaeSemMascara(cna.getCodcna() + (cna.getDescna()!=null?cna.getDescna():""));
						if(cna.getStatus().equals("I")){
							indeferida = true;
							atvIndeferidas.add(cnae);
						} else if(cna.getStatus().equals("E")){ //se possui pelo menos uma em exigencia (TERRITORIAL/RURAL com usos OK)
							analiseTerritorial = true;
						} else if(cna.getStatus().equals("P")){ //se possui pelo menos um parcialmente deferido
							analisePorte = true;
						} else if(cna.getStatus().equals("D")){
							atvDeferidas.add(cnae + (todosUsosIguais?"":"(" + cna.getUsoConforme() + ")"));
						}
					}
					
					HashMap<String, String> riscos = getRiscoGeral(ae.getListAtv());
					
					//SETA SITUAÇÃO
					if(dadosVia.get("provia").toString().startsWith("CGR") && ((dadosVia.get("tipvia").toString().equals("M") && (!(Boolean) dadosVia.get("possuiestabelecimentofixo"))) || (dadosVia.get("tipvia").toString().equals("A") && dadosVia.get("sauvia").toString().equals("N")))){
						ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.DEFERIDA);
					} else {
						if(indeferida){
							ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.INDEFERIDA);
						} else if (analiseTerritorial || analisePorte || (riscos.get("rissia")!= null && (riscos.get("rissia").equalsIgnoreCase("M") || riscos.get("rissia").equalsIgnoreCase("A")))) {
							ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.EM_ESTUDO); //PASSARÁ PELA ANÁLISE DA SEMADUR
						} else {
							ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.DEFERIDA);
						}
					}
					
					//SETA OBSERVACAO/JUSTIFICATIVA/ORIENTACAO
					if(indeferida){
						ae.setJustificativa("Atividade(s) que não se enquadra(m) com os usos permitidos para o local: " + Formatacao.imprimeLista(atvIndeferidas) + ". ");
						if(atvDeferidas.size() > 0) {
							ae.setObservacao("Uso Conforme" + (todosUsosIguais?"(" + usocomum + ")":"") + ": " + Formatacao.imprimeLista(atvDeferidas) + ". Parecer Automático.");
						} else {
							ae.setObservacao("Parecer Automático.");
						}
					} else if (analiseTerritorial || analisePorte || (riscos.get("rissia")!= null && (riscos.get("rissia").equalsIgnoreCase("M") || riscos.get("rissia").equalsIgnoreCase("A")))) {
						ae.setObservacao("");
						if(riscos.get("rissia")!= null && (riscos.get("rissia").equalsIgnoreCase("M") || riscos.get("rissia").equalsIgnoreCase("A"))){
							ae.setObservacao(ae.getObservacao() + "Risco Médio/Alto.");
						}
						ae.setObservacao(ae.getObservacao() + "Parecer Automático.");
					} else {
						ae.setObservacao("Uso Conforme" + (todosUsosIguais?"(" + usocomum + ")":"") + ": " + Formatacao.imprimeLista(atvDeferidas) + ". Parecer Automático.");
						
						//ORIENTACAO
						List<String> orgaos = new ArrayList<String>();
						if(riscos.get("risamb")!= null && (riscos.get("risamb").equalsIgnoreCase("M") || riscos.get("risamb").equalsIgnoreCase("A"))){
							orgaos.add("Meio Ambiente");
						}
						if(riscos.get("risbom")!= null && (riscos.get("risbom").equalsIgnoreCase("M") || riscos.get("risbom").equalsIgnoreCase("A"))){
							orgaos.add("Bombeiro");
						}
						if(riscos.get("risvig")!= null && (riscos.get("risvig").equalsIgnoreCase("M") || riscos.get("risvig").equalsIgnoreCase("A"))){
							orgaos.add("Vigilância Sanitária");
						}
						if(orgaos.size() > 0){
							ae.setOrientacao("Necessário o Licenciamento junto ao(s) Órgão(s): " + Formatacao.imprimeLista(orgaos) + ". ");
						}
					}
					
					if(indeferida){
						if(ae.getJustificativa().length() > 1000){
							ae.setJustificativa("Existe(m) atividade(s) que não se enquadra(m) com os usos permitidos para o local."); 
						}
						if(ae.getObservacao().length() > 1000){
							ae.setObservacao("Parecer Automático."); 
						}
					} else if (analiseTerritorial || analisePorte || (riscos.get("rissia")!= null && (riscos.get("rissia").equalsIgnoreCase("M") || riscos.get("rissia").equalsIgnoreCase("A")))) {
					} else {
						if(ae.getObservacao().length() > 1000){
							ae.setObservacao("Uso Conforme."); 
						}
					}
					
					//GERA O ARQUIVO PDF
					
//					File f = new File("C://Users//George//Desktop//teste.pdf");
//					FileInputStream fis = new FileInputStream(f);
//					byte[] bytes = new byte[(int) f.length()];
//					fis.read(bytes);
//					fis.close();
//			
//					Base64Utility.encode(bytes);
//					System.out.println(bytes);
//					ae.setPdfResultado(bytes);
				
					//ACIMA ESTA CORRETO ------------------------------------------------------------------------------------------------------------------------------------------
					
//					byte[] pdfResultado = null;
//					try {
//						pdfResultado = loadFile("C://Users//George//Desktop//teste.pdf");
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					ae.setPdfResultado(pdfResultado);
					
					//GERA A SAÍDA PARA CONFIRMAR SE CONVERTEU CORRETAMENTE
//					FileOutputStream out = null;
//					try {
//						out = new FileOutputStream("C://Users//George//Desktop//volta.pdf");
//					} catch (FileNotFoundException e1) {
//						e1.printStackTrace();
//					}
//					try {
//						out.write(pdfResultado, 0, pdfResultado.length);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					try {
//						out.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					
					return ae;
				}
				
			}
    	} catch (Exception e) {
			e.printStackTrace();
			logger.error("Não foi possível gerar a análise de endereço: " + protocoloViabilidade + " - " + e.getMessage());
		}
		return null;
    }
    
   
}
