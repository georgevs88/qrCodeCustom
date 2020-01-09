package pmcg.fcn.prefeitura;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CaiDAO;
import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.dao.ibatis.XmlDAO;
import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.CaiVO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.RespostaProcessamentoVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.domain.XmlVO;
import pmcg.imti.dao.ibatis.EcoDAO;

public class ImportacaoJunta extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ImportacaoJunta.class);
	private static final long serialVersionUID = 1L;

	public ImportacaoJunta() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		importa();
		PrintWriter saida = response.getWriter();
		saida.println("<HTML><BODY>");
		saida.println("<H1>OK</H1>");
		saida.println("</BODY></HTML>");
		saida.flush();
		saida.close();
	}
	
	public void importa(){
		HashMap<String, Object> acao = new CfgDAO().getAcaoImportacao();
		Boolean grava_via = (Boolean) acao.get("gv");
		Boolean resp_via = (Boolean) acao.get("rv");
		Boolean grava_emp = (Boolean) acao.get("ge");
		Boolean resp_emp = (Boolean) acao.get("re");
		importa(grava_via, resp_via, grava_emp, resp_emp);
	}
	
	public void importa(Boolean grava_via, Boolean resp_via, Boolean grava_emp, Boolean resp_emp){
		logger.error("INICIO - ImportacaoJunta");
		
		//MANDA PRA JUNTA OS NOVOS ALVARÁS GERADOS PELO SIAT
		List<HashMap<String, Object>> alvPendentes = new EcoDAO().getAtualizaAlvaras();
		Integer cnt = 1;
		for(HashMap<String, Object> alv : alvPendentes){
			CaiVO cai = new CaiDAO().getRegByImucai(alv.get("INSCRICAO").toString());
			
			if(cai != null){
//				try {
//				   Thread.sleep(500);
//				} catch (Exception e) {
//				   e.printStackTrace();
//				}
				try {
					//Responde para a Junta
					String resposta = ClienteEmpreendimento.confirmaDeferimento(cai.getNprcai(), alv.get("ALVARA").toString(), cai.getImucai());
					String tipoRetorno = resposta.replaceAll("TipoRetorno", "tipoRetorno").replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
//					System.out.println(tipoRetorno);
					if(tipoRetorno.equals("SUCESSO")){
						//ATUALIZA o CAI COM O ALVARA
						cai.setAlvcai(alv.get("ALVARA").toString());
						new CaiDAO().updRegByCod(cai);
						
						new EcoDAO().updAlvaraVerificado(Long.parseLong(alv.get("ID").toString()));
					} else if(tipoRetorno.equals("FALHA")){
						String tipoFalha = resposta.replaceAll("\n", "").replaceFirst("^.*<mensagem>", "").replaceFirst("</mensagem>.*", "");
//						System.out.println(tipoFalha);
						if(tipoFalha.equals("Alvará e Inscrição Municipal do Empreendimento já foi recebido anteriormente.") ||
								tipoFalha.equals("Empreendimento não exite na base da JUNTA.")){
							new EcoDAO().updAlvaraVerificado(Long.parseLong(alv.get("ID").toString()));
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					new EcoDAO().updAlvaraVerificado(Long.parseLong(alv.get("ID").toString()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Atualiza Alvará: " + cnt + " de " + alvPendentes.size() + " ");
			cnt++;
		}

		// VERIFICAR SE EXISTEM VIABILIDADES PENDENTES
		// --------------------------------------------------------------------------------------------
		Integer count;
		if(grava_via){
			//CONFIRMA RECEBIMENTO 
			List<ViaVO> viaPendenteConfRec = new ViaDAO().getViaByConfRecPendente();
			logger.error("Qnt Viabilidades Confirmação Recebimento Pendentes: " + (viaPendenteConfRec != null ? viaPendenteConfRec.size() : "0"));
			if (viaPendenteConfRec != null && viaPendenteConfRec.size() > 0) {
				count = 0;
				for (ViaVO viacrp : viaPendenteConfRec) {
					Util.confirmaRecebimentoVia(viacrp.getProvia());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
					System.out.println("confirmaRecebimentoVia -> " + count + " de " + viaPendenteConfRec.size());
				}
			}
			try {
				String xml = ClienteViabilidade.recuperaViabilidadesPendentes();
				xml = xml.replaceAll("TipoRetorno", "tipoRetorno");
				RespostaProcessamentoVO resp = RespostaProcessamentoVO.fromXml(xml);
				logger.error("Qnt Viabilidades: " + (resp.getViabilidade() != null ? resp.getViabilidade().size() : "0"));
				if (resp.getViabilidade() != null && resp.getViabilidade().size() > 0) {
					//GRAVA O XML COMPLETO POR SEGURANCA
					XmlVO xmlVO = new XmlVO();
					xmlVO.setTipxml("V");
					String xmlSalvar = xml.replaceAll("\r", "");
					xmlSalvar = xmlSalvar.replaceAll("\t", "");
					xmlSalvar = xmlSalvar.replaceAll("\n", ""); 
					xmlVO.setXmlxml(xmlSalvar);
					xmlVO.setUsualt("ROBO_CIMWEB");
					new XmlDAO().insReg(xmlVO);
					
					count = 0;
					for (ViaVO viab : resp.getViabilidade()) {
						Integer qtdVia = new ViaDAO().countViaByProtocolo(viab.getProvia());
						if (qtdVia != null && qtdVia <= 0) {
							Util.gravaViabilidade(viab);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							count++;
							System.out.println("gravaViabilidade -> " + count + " de " + resp.getViabilidade().size());
						} else {
							logger.error("Viabilidade " + viab.getProvia() + " já gravada. Deve ser feita a Confirmação de Recebimento");
						}
					}
					logger.error("Viabilidades Gravadas com Sucesso!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Erro ao Recuperar Viabilidades Pendentes. " + e.getMessage());
			}
			//CONFIRMA RECEBIMENTO DE NOVO
			viaPendenteConfRec = new ViaDAO().getViaByConfRecPendente();
			logger.error("Qnt Viabilidades Confirmação Recebimento Pendentes: " + (viaPendenteConfRec != null ? viaPendenteConfRec.size() : "0"));
			if (viaPendenteConfRec != null && viaPendenteConfRec.size() > 0) {
				count = 0;
				for (ViaVO viacrp : viaPendenteConfRec) {
					Util.confirmaRecebimentoVia(viacrp.getProvia());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
					System.out.println("confirmaRecebimentoVia -> " + count + " de " + viaPendenteConfRec.size());
				}
			}
		}
		// ----------------------------------------------------------------------------------------------------------------------------------------

		// VERIFICAR SE EXISTEM ANÁLISES DE ENDEREÇO PENDENTES
		// Obs: Só analisa o endereço se confirmou o recebimento
		if(resp_via){
			try {
				List<ViaVO> viaPendenteAnaliseEndereco = new ViaDAO().getViaByAnaliseEnderecoPendente();
				logger.error("Qnt Viabilidades Analise Endereco Pendentes: " + (viaPendenteAnaliseEndereco != null ? viaPendenteAnaliseEndereco.size() : "0"));
				if (viaPendenteAnaliseEndereco != null && viaPendenteAnaliseEndereco.size() > 0) {
					count = 0;
					for (ViaVO viap : viaPendenteAnaliseEndereco) {
						Util.confirmaEndereco(viap.getProvia(), viap.getIddvia());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						count++;
						System.out.println("confirmaEndereco -> " + count + " de " + viaPendenteAnaliseEndereco.size());
					}
				}
			} catch (Exception e) {
				logger.error("Erro ao Verificar Análise de Endereço Pendentes. " + e.getMessage());
			}
		}
		// ----------------------------------------------------------------------------------------------------------------------------------------

		// VERIFICAR SE EXISTEM EMPREENDIMENTOS DEFERIDOS P/ PREFEITURA
		if(grava_emp){
			//CONFIRMA RECEBIMENTO 
			List<EpdVO> epdPendenteConfRec = new EpdDAO().getEpdByConfRecPendente();
			logger.error("Qnt Empreendimentos Confirmação Recebimento Pendentes: " + (epdPendenteConfRec != null ? epdPendenteConfRec.size() : "0"));
			if (epdPendenteConfRec != null && epdPendenteConfRec.size() > 0) {
				count = 0;
				for (EpdVO epdcrp : epdPendenteConfRec) {
					Util.confirmaRecebimentoEpd(epdcrp);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
					System.out.println("confirmaRecebimentoEpd -> " + count + " de " + epdPendenteConfRec.size());
				}
			}
			try {
				String xml = ClienteEmpreendimento.recuperaEmpreendimentosDeferidosParaPrefeitura();
				xml = xml.replaceAll(" class=\"sql-date\"", "").replaceAll(" class=\"sql-timestamp\"", "");
				xml = xml.replaceAll("TipoRetorno", "tipoRetorno");
				RespostaProcessamentoVO respp = RespostaProcessamentoVO.fromXml(xml);
				logger.error("Qnt Empreendimentos: " + (respp.getEmpreendimentos() != null && respp.getEmpreendimentos().getEmpreendimento() != null ? respp.getEmpreendimentos().getEmpreendimento().size() : "0"));
				if (respp.getEmpreendimentos() != null && respp.getEmpreendimentos() != null && respp.getEmpreendimentos().getEmpreendimento() != null && respp.getEmpreendimentos().getEmpreendimento().size() > 0) {
					//GRAVA O XML COMPLETO POR SEGURANCA
					XmlVO xmlVO = new XmlVO();
					xmlVO.setTipxml("E");
					String xmlSalvar = xml.replaceAll("\r", "");
					xmlSalvar = xmlSalvar.replaceAll("\t", "");
					xmlSalvar = xmlSalvar.replaceAll("\n", ""); 
					xmlVO.setXmlxml(xmlSalvar);
					xmlVO.setUsualt("ROBO_CIMWEB");
					new XmlDAO().insReg(xmlVO);
						
					count = 0;
					for (EpdVO empreendimento : respp.getEmpreendimentos().getEmpreendimento()) {
						Integer qtdEpd = new EpdDAO().countEpdByProcesso(empreendimento.getNprepd());
						if (qtdEpd != null && qtdEpd <= 0) {
							Util.gravaEmpreendimento(empreendimento);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							count++;
							System.out.println("gravaEmpreendimento -> " + count + " de " + respp.getEmpreendimentos().getEmpreendimento().size());
						} else {
							logger.error("Empreendimento " + empreendimento.getNprepd() + " já gravado. Deve ser feita a Confirmação de Recebimento");
						}
//						System.out.println("ok - RESP");
					}
					logger.error("Empreendimentos Gravados com Sucesso!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Erro ao Verificar Empreendimentos Deferidos Para Prefeitura. " + e.getMessage());
			}
		}
		// ----------------------------------------------------------------------------------------------------------------------------------------
		if(resp_emp){
			//VERIFICA SE EXISTEM CONFIRMAÇÕES DE INSCRICAO MUNICIPAL PENDENTE
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("confirmacaopendente", true);
			List<EpdVO> epdPendenteConfInscricao = new EpdDAO().getEpdPendente(param);
			if (epdPendenteConfInscricao != null && epdPendenteConfInscricao.size() > 0) {
				for (EpdVO epdpi : epdPendenteConfInscricao) {
					Util.confirmaInscricaoMunicipal(epdpi);
				}
			}
			// VERIFICAR SE EXISTEM EMPREENDIMENTOS PARA ANALISAR (RESPONDER INSCRICAO IMOBILIARIA/ALVARÁ)
			// Obs: Só analisa o endereço se confirmou o recebimento
			try {
				param = new HashMap<String, Object>();
				param.put("respostapendente", true);
				List<EpdVO> epdPendenteResposta = new EpdDAO().getEpdPendente(param);
				if (epdPendenteResposta != null && epdPendenteResposta.size() > 0) {
					logger.error("INICIO - Resposta Empreendimento");
					logger.error("Qnt Empreendimentos a analisar: " + epdPendenteResposta.size());
					for (EpdVO epdp : epdPendenteResposta) {
						Util.responderEmpreendimento(epdp.getNprepd());
					}
				}
				
				//RESPONDE OS BAES
				List<BaeVO> baePendenteResposta = new BaeDAO().getBaePendente(param);
				if (baePendenteResposta != null && baePendenteResposta.size() > 0) {
					logger.error("INICIO - Resposta BAE");
					logger.error("Qnt BAEs a analisar: " + baePendenteResposta.size());
					for (BaeVO baep : baePendenteResposta) {
						Util.responderBae(baep);
					}
				}
			} catch (Exception e) {
				logger.error("Erro ao Verificar Empreendimentos Para Análise. " + e.getMessage());
			}
		}
		logger.error("FIM - ImportacaoJunta");
		
	}
	
}
