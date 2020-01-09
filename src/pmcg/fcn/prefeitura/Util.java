package pmcg.fcn.prefeitura;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pmcg.fcn.dao.ibatis.AdmDAO;
import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CaiDAO;
import pmcg.fcn.dao.ibatis.CclDAO;
import pmcg.fcn.dao.ibatis.CenDAO;
import pmcg.fcn.dao.ibatis.CfaDAO;
import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.ColDAO;
import pmcg.fcn.dao.ibatis.CpeDAO;
import pmcg.fcn.dao.ibatis.CsoDAO;
import pmcg.fcn.dao.ibatis.EdrDAO;
import pmcg.fcn.dao.ibatis.EevDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.FilDAO;
import pmcg.fcn.dao.ibatis.LmaDAO;
import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.dao.ibatis.ProDAO;
import pmcg.fcn.dao.ibatis.RclDAO;
import pmcg.fcn.dao.ibatis.RepDAO;
import pmcg.fcn.dao.ibatis.ReqDAO;
import pmcg.fcn.dao.ibatis.SadDAO;
import pmcg.fcn.dao.ibatis.SocDAO;
import pmcg.fcn.dao.ibatis.TabDAO;
import pmcg.fcn.dao.ibatis.UsoDAO;
import pmcg.fcn.dao.ibatis.VevDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.dao.ibatis.ZimDAO;
import pmcg.fcn.domain.AdmVO;
import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.CaeVO;
import pmcg.fcn.domain.CaiVO;
import pmcg.fcn.domain.CclVO;
import pmcg.fcn.domain.CenVO;
import pmcg.fcn.domain.CfaVO;
import pmcg.fcn.domain.CnaVO;
import pmcg.fcn.domain.ColVO;
import pmcg.fcn.domain.CpeVO;
import pmcg.fcn.domain.CsoVO;
import pmcg.fcn.domain.EdrVO;
import pmcg.fcn.domain.EevVO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.EveVO;
import pmcg.fcn.domain.FilVO;
import pmcg.fcn.domain.LmaVO;
import pmcg.fcn.domain.MatVO;
import pmcg.fcn.domain.PevVO;
import pmcg.fcn.domain.ProVO;
import pmcg.fcn.domain.RepVO;
import pmcg.fcn.domain.ReqVO;
import pmcg.fcn.domain.SadVO;
import pmcg.fcn.domain.SocVO;
import pmcg.fcn.domain.UsoVO;
import pmcg.fcn.domain.VevVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.domain.ZimVO;
import pmcg.fcn.siat.domain.Boleano;
import pmcg.fcn.siat.domain.RiscoAlvara;
import pmcg.fcn.siat.domain.Sexo;
import pmcg.fcn.siat.domain.StatusImpressaoAlvara;
import pmcg.fcn.siat.domain.TipoAtividade;
import pmcg.fcn.siat.domain.TipoDocumento;
import pmcg.fcn.siat.domain.TipoEnderecoCobrancaPessoa;
import pmcg.fcn.siat.domain.TipoEnderecoEntregaMob;
import pmcg.fcn.siat.domain.TipoEnderecoEntregaPessoa;
import pmcg.fcn.siat.domain.TipoImovelMob;
import pmcg.fcn.siat.domain.TipoLocalizacao;
import pmcg.fcn.siat.domain.TipoOcupacao;
import pmcg.fcn.siat.domain.TipoPessoa;
import pmcg.fcn.siat.domain.TipoProfissao;
import pmcg.fcn.siat.domain.TipoSocio;
import pmcg.fcn.siat.domain.TipoUnidade;
import pmcg.fcn.siat.domain.UsoImovelMob;
import pmcg.fcn.siat.domain.ws.EntradaAtividadeGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaEnderecoEntregaGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaEnderecoLocalizacaoGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaEnderecoPessoaGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaOcupacaoGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaPessoaGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaProfissaoGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.EntradaSocioAdmGravaCadastroEconomico;
import pmcg.fcn.siat.domain.ws.TipoEntrada;
import pmcg.fcn.siat.domain.ws.TipoEstabelecido;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.dao.ibatis.NjqDAO;
import pmcg.imti.dao.ibatis.UsuDAO;
import pmcg.imti.domain.NjqVO;
import pmcg.imti.domain.UsuVO;
import pmcg.imti.manager.GravaCadEconManager;
import pmcg.imti.ui.LogicUtils;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;
import pmcg.imti.view.IntegraSos;

public class Util {
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteViabilidade.class);
	static SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat formatDataInv = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat formatDataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
	
	/* ########## REGRA DE AN�LISE DE ATIVIDADE/IM�VEL E ENDERE�O ##################################################################################
	
	TERRITORIAL | USO OK -------------------------------------> "E" -> EM EXIG�NCIA (POIS NAO SABEMOS A AREA CONSTRU�DA AINDA, E POSTERIORMENTE N�O PERMITE EMISS�O DO ALVAR� E INSCRI��O MUNICIPAL)
	            | USO NAO ------------------------------------> "I" -> INDEFERIDO (SE ATIVIDADE N�O SE ENQUADRA DE ACORDO COM O USO/ZONA)
	             
                          |  TEM ESCRIT. ---------------------> "E" -> EM EXIG�NCIA (POIS SER� AN�LISADO SE REALMENTE � ESCRIT�RIO ADMINISTRATIVO)        
		        | USO OK  |                   | BAIXO RISCO --> "D" -> DEFERIDO (PERMITE EMITIR INSCRICAO MUNICIPAL E ALVAR�)
	PREDIAL --  |         | � TEM ESCRIT. --->| M�DIO RISCO --> "P" -> PARCIALMENTE DEFERIDO (PERMITE EMITIR INSCRICAO MUNICIPAL E ALVAR� TEMPOR�RIO 90 DIAS PRORROG�VEL + 90 DIAS)
	            |                             | ALTO RISCO  --> "P" -> PARCIALMENTE DEFERIDO (PERMITE EMITIR INSCRICAO MUNICIPAL)
	            | USO NAO ------------------------------------> "I" -> INDEFERIDO (SE ATIVIDADE N�O SE ENQUADRA DE ACORDO COM O USO/ZONA)
	
	################################################################################################################################################*/
	
	public static CnaVO analisaAtv(String inscricaoImobiliaria, CnaVO atividade, Boolean escritorio, Boolean autonomo, Boolean mei) throws Exception{
		//pegando a inscricao municipal de viabilidade/coleta/coletaEndereco
		String cnae = Util.formataCnaeSemMascara(atividade.getCodcna() + (atividade.getDescna()!=null?atividade.getDescna():""));
		if(inscricaoImobiliaria == null || inscricaoImobiliaria.isEmpty()){
			logger.error("Inscri��o Imobili�ria n�o informada!");
			throw new Exception("Inscri��o Imobili�ria n�o informada!");
		} else {
			//SETA OS RISCOS
			CclVO cclParam = new CclVO();
			cclParam.setCodccl(Util.formataCnaeComMascara(atividade.getCodcna() + (atividade.getDescna()!=null?atividade.getDescna():"")));
			cclParam.setMeiccl(mei?"S":"N");
			CclVO confAtividade = new CclDAO().getRegByCNAE(cclParam);
			if(confAtividade != null){
				atividade.setRiscoAmbi(confAtividade.getAmbccl());
				atividade.setRiscoBomb(confAtividade.getBomccl());
				atividade.setRiscoVigi(confAtividade.getVigccl());
				atividade.setRiscoPost("B"); //TODO
				atividade.setRiscoTran(confAtividade.getTraccl());
				atividade.setRiscoSIA(confAtividade.getGurccl());
			} else {
				//GEORGE - 07/04/2017 -- N�O ACHAR CONFIGURA��O TENTA SEM O PARAMETRO DE MEI
				cclParam.setMeiccl(null);
				confAtividade = new CclDAO().getRegByCNAE(cclParam);
				if(confAtividade != null){
					atividade.setRiscoAmbi(confAtividade.getAmbccl());
					atividade.setRiscoBomb(confAtividade.getBomccl());
					atividade.setRiscoVigi(confAtividade.getVigccl());
					atividade.setRiscoPost("B"); //TODO
					atividade.setRiscoTran(confAtividade.getTraccl());
					atividade.setRiscoSIA(confAtividade.getGurccl());
				}
			}
			
			HashMap<String, Object> analiseImovel = analisaZonaUsoImovel(Formatacao.zeroEsquerda(inscricaoImobiliaria, 11));
			List<ZimVO> listZonas = new ArrayList<ZimVO>();
			List<UsoVO> listUsosZona = new ArrayList<UsoVO>();
			if(analiseImovel == null || analiseImovel.get("tipoImovel") == null){
				logger.error("Inscri��o Imobili�ria n�o encontrada! (" + inscricaoImobiliaria + ")");
				atividade.setStatus("I"); //
			} else if(analiseImovel.get("descZonas") == null){
				logger.error("Inscri��o Imobili�ria sem zoneamento! (" + inscricaoImobiliaria + ")");
				atividade.setStatus("E");
			} else {
				listZonas.addAll((List<ZimVO>) analiseImovel.get("objZonas"));
				listUsosZona.addAll((List<UsoVO>) analiseImovel.get("objUsos"));
				
				Boolean ok = true;
				if(analiseImovel.get("tipoImovel").equals("T")){ //TERRITORIAL
					String usosAtv;
					if(autonomo){
						atividade.setUsoConforme("S1");
						atividade.setStatus("D"); //DEFERIDO
					} else {
						if(escritorio && !atividade.getExecna()){
							usosAtv = "'S1','S2'";
						} else {
							usosAtv = new UsoDAO().getUsosByAtv(Util.formataCnaeComMascara(cnae));
						}	
						if(usosAtv == null){
							ok = false;
						} else {
							List<UsoVO> listUsosAtv = new UsoDAO().getUsosIn(usosAtv);
							if(listUsosAtv == null || listUsosAtv.size() <= 0){
								ok = false;
							} else {
								for (UsoVO uso : listUsosAtv) {
									if(!listUsosZona.contains(uso)){
										ok = false;
									}
								}
							}
						}
						if(ok){
							atividade.setStatus("E"); //EM EXIG�NCIA
						} else {
							atividade.setStatus("I"); //INDEFERIDA
						}
					}
				} else {
					//PREDIAL
					//Utiliza a fun��o fcn.retorna_uso_por_atv_porte(CNAE, AREA_CONSTRUIDA)
					//para pegar o USO da atividade de acordo com o porte
					HashMap<String,Object> dadosImovel = new ImoDAO().getDadosByInscricao(Formatacao.zeroEsquerda(inscricaoImobiliaria, 11));
					
					//Double area = new UniDAO().getAreaConstruidaByInscricao(insimo);
					BigDecimal area_construida = dadosImovel!=null&&dadosImovel.get("IMO_CONSTRUCAO")!=null?new BigDecimal(dadosImovel.get("IMO_CONSTRUCAO").toString()):null;
					if(area_construida == null){
						logger.error("Erro ao buscar �rea Constru�da do Im�vel: " + inscricaoImobiliaria + ".");
					}
					HashMap param = new HashMap<String, Object>();
					param.put("cnae", Util.formataCnaeComMascara(atividade.getCodcna() + (atividade.getDescna()!=null?atividade.getDescna():""))); 
					param.put("area", area_construida);
					UsoVO uso_atividade_porte = new UsoDAO().getUsoByAtvPorte(param);
					if(uso_atividade_porte == null){
						logger.error("Erro ao buscar Uso por CNAE/Porte! CNAE:" + param.get("cnae") + ", �rea Constru�da:" + param.get("area"));
					}
					if(autonomo){
						atividade.setUsoConforme("S1");
						atividade.setStatus("D"); //DEFERIDO
					} else if(escritorio && !atividade.getExecna()){
						if(area_construida.doubleValue() <= 720){
							atividade.setUsoConforme("S1");
						} else {
							atividade.setUsoConforme("S2");
						}
						atividade.setStatus("D"); //DEFERIDO
						atividade.setRiscoAmbi("B");
						atividade.setRiscoBomb("B");
						atividade.setRiscoPost("B");
						atividade.setRiscoSIA("B");
						atividade.setRiscoTran("B");
						atividade.setRiscoVigi("B");
					} else {
						atividade.setUsoConforme(uso_atividade_porte!=null?uso_atividade_porte.getCoduso():null);
						if(area_construida == null || uso_atividade_porte == null || uso_atividade_porte.getCoduso() == null){
							atividade.setStatus("P"); //PARCIALMENTE DEFERIDO
						} else {
							if(atividade.getExecna() == null){
								throw new Exception("N�o foi informado se a atividade " + Util.formataCnaeComMascara(atividade.getCodcna() + (atividade.getDescna()!=null?atividade.getDescna():"")) + " � exercida no local.");
							}
							if(!atividade.getExecna()){ //SE ATIVIDADE N�O EXERCIDA NO LOCAL (ESCRIT�RIO ADMINISTRATIVO)
								atividade.setStatus("E"); //EM EXIG�NCIA
							} else {
								if(!listUsosZona.contains(uso_atividade_porte)){
									atividade.setStatus("I"); //INDEFERIDO
								} else {
									atividade.setStatus("D"); //DEFERIDO
								}
							}
						}
					}
				}
			}
			return atividade;
		}
	}
	
	public static HashMap<String, Object> analisaZonaUsoImovel(String inscricaoImobiliaria) throws Exception{
		HashMap<String, Object> analise = new HashMap<String ,Object>();;
		/*
		tipoImovel -> "T" ou "P" (Territorial ou Predial)
		descZonas -> Z1,Z2
		objZonas --> List<ZimVO>
		descUsos -> S1,S2,S3,V1
		objUsos --> List<UsoVO>
		*/
		
		HashMap<String, Object> dadosZonaUso = new UsoDAO().getZonasUsosByInscricao(inscricaoImobiliaria);
		String tipoImovel = new ImoDAO().getTipoImovel(inscricaoImobiliaria);
		List<ZimVO> listZonas;
		List<UsoVO> listUsosZona = null;
		if(dadosZonaUso == null || tipoImovel == null){
			analise.put("tipoImovel", null);
			analise.put("descZonas", null);
			analise.put("objZonas", null);
			analise.put("descUsos", null);
			analise.put("objUsos", null);
		} else {
			listZonas = new ZimDAO().getRegByInsc(Formatacao.zeroEsquerda(inscricaoImobiliaria, 11));
			listUsosZona = new ArrayList<UsoVO>();
			if((Boolean) dadosZonaUso.get("temc3")){
				listUsosZona.addAll(new UsoDAO().getUsosByZonas("'C3'"));
			} else {
				listUsosZona.addAll(new UsoDAO().getUsosByZonas(dadosZonaUso.get("zonasparabusca").toString()));
			}
			analise.put("tipoImovel", tipoImovel);
			analise.put("descZonas",  dadosZonaUso.get("zonas").toString().isEmpty()?null:dadosZonaUso.get("zonas").toString());
			analise.put("objZonas", listZonas);
			analise.put("descUsos", dadosZonaUso.get("usos") == null || dadosZonaUso.get("usos").toString().isEmpty()?null:dadosZonaUso.get("usos").toString());
			analise.put("objUsos", listUsosZona);
		}
		return analise;
	}
	
	public static void confirmaEndereco(String protocolo, Long iddvia){
		logger.error("INICIO - Analise Endereco - Protocolo: " + protocolo);
		String resposta = null;
		try {
			resposta = ClienteViabilidade.confirmaRespostaAnaliseEndereco(protocolo, iddvia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.error("Analise Endereco Protocolo: " + protocolo + "-" + resposta);
	}
	
	public static void responderEmpreendimento(String nprepd) throws Exception{
		EpdVO epdp = new EpdDAO().getRegByProcesso(nprepd);
		if(epdp.getProcesso().getAtopro().equals("002")){ 
			if(new EevDAO().getTransferenciaByPro(epdp.getProcesso().getIddpro())){
				//TRANSFERENCIA
				try {
					new EpdDAO().getSqlMap().startTransaction();
					CaiVO cai = new CaiVO();
					cai.setNprcai(epdp.getNprepd());

					String inscricaoMunicipal;
					HashMap<String, String> resp = Util.gravaCadastroEconomico(epdp.getNprepd());
					//GRAVA A MSG DE RETORNO DO SIAT
					if(resp.get("mensagem") != null && !resp.get("mensagem").toString().isEmpty()){
						epdp.setMsgepd(resp.get("mensagem").toString());
						new EpdDAO().updMensagemSIAT(epdp);
						new EpdDAO().getSqlMap().commitTransaction();
					}
					
					//SE O WS DO SIAT RESPONDER QUE J� EXISTE O CNPJ BUSCA A INSCRICAO DO SIAT
					if(resp.get("mensagem").toString().substring(0, 14).equals("CNPJ j� existe")){
						inscricaoMunicipal = new EcoDAO().getImuByCpfcnpj(epdp.getCnpepd());
					} else {
						inscricaoMunicipal = resp.get("inscricaoMunicipal").toString();
					}
					
					if(inscricaoMunicipal.length() != 11){
						logger.error("VERIFICAR PROTOCOLO: " + epdp.getNprepd() + ", ATO: " + epdp.getProcesso().getAtopro());
					} else {
						cai.setImucai(inscricaoMunicipal);
						String riscoGeral = new EpdDAO().getRiscoByProcesso(epdp.getNprepd());
						if(riscoGeral.equals("A") || riscoGeral.equals("M")){
							cai.setSitcai("P");
						} else {
							cai.setSitcai("D");
						} 
						cai.setMotcai("");
						cai.setAlvcai("Acesse portal PMCG Alvara");
						cai.setDatcai(new Date());
						Long iddcai = (Long) new CaiDAO().insReg(cai);

						EpdVO epdupd = new EpdVO();
						epdupd.setIddepd(epdp.getIddepd());
						epdupd.setCaiepd(iddcai);
						new EpdDAO().updConfirmaInscricaoByIdd(epdupd);
						new EpdDAO().getSqlMap().commitTransaction();
						
						//Responde para a Junta
						String resposta;
						if(cai.getSitcai().equals("P")){
							resposta = ClienteEmpreendimento.confirmaParcialInscricao(epdp.getNprepd(), cai.getImucai());
						} else {
							resposta = ClienteEmpreendimento.confirmaDeferimento(epdp.getNprepd(), "Acesse portal PMCG Alvara", cai.getImucai());
						}
						String tipoRetorno = resposta.replaceAll("TipoRetorno", "tipoRetorno").replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
						if(tipoRetorno.equals("SUCESSO")){
							new EpdDAO().updAtendidoByProcesso(epdp.getNprepd());
							new EpdDAO().getSqlMap().commitTransaction();
						}
					}
				} catch (Exception e) {
					new EpdDAO().getSqlMap().endTransaction();
					logger.error("N�o foi poss�vel inserir Cadastro Econ�mico! PROCESSO: " + epdp.getNprepd() + ", ATO: " + epdp.getProcesso().getAtopro());
				} finally {
					new EpdDAO().getSqlMap().endTransaction();
				}
			} else {
				//ALTERACAO
				logger.error("VERIFICAR PROTOCOLO: " + epdp.getNprepd() + ", ATO: " + epdp.getProcesso().getAtopro());
			}
		} else if(epdp.getProcesso().getAtopro().equals("003")){ 
			//EXTINCAO/DISTRATO
			logger.error("VERIFICAR PROTOCOLO: " + epdp.getNprepd() + ", ATO: " + epdp.getProcesso().getAtopro());
		} else if(epdp.getProcesso().getAtopro().equals("080") || epdp.getProcesso().getAtopro().equals("090") || epdp.getProcesso().getAtopro().equals("091") || epdp.getProcesso().getAtopro().equals("005")){ 
			//INSCRICAO ou CONTRATO
			try {
				new EpdDAO().getSqlMap().startTransaction();
				CaiVO cai = new CaiVO();
				cai.setNprcai(epdp.getNprepd());

				String inscricaoMunicipal;
				HashMap<String, String> resp = Util.gravaCadastroEconomico(epdp.getNprepd());
				//GRAVA A MSG DE RETORNO DO SIAT
				if(resp.get("mensagem") != null && !resp.get("mensagem").toString().isEmpty()){
					epdp.setMsgepd(resp.get("mensagem").toString());
					new EpdDAO().updMensagemSIAT(epdp);
					new EpdDAO().getSqlMap().commitTransaction();
				}
				
				//SE O WS DO SIAT RESPONDER QUE J� EXISTE O CNPJ BUSCA A INSCRICAO DO SIAT
				Boolean novaInscricao = true;
				if(resp.get("mensagem").toString().substring(0, 14).equals("CNPJ j� existe")){
					inscricaoMunicipal = new EcoDAO().getImuByCpfcnpj(epdp.getCnpepd());
					novaInscricao = false;
				} else {
					inscricaoMunicipal = resp.get("inscricaoMunicipal").toString();
				}
				
				if(inscricaoMunicipal.length() != 11){
					logger.error("VERIFICAR PROTOCOLO: " + epdp.getNprepd() + ", ATO: " + epdp.getProcesso().getAtopro());
				} else {
					cai.setImucai(inscricaoMunicipal);
					String riscoGeral = new EpdDAO().getRiscoByProcesso(epdp.getNprepd());
					if(riscoGeral.equals("A") || riscoGeral.equals("M")){
						cai.setSitcai("P");
					} else {
						cai.setSitcai("D");
					} 
					cai.setMotcai("");
					cai.setAlvcai("Acesse portal PMCG Alvara");
					cai.setDatcai(new Date());
					Long iddcai = (Long) new CaiDAO().insReg(cai);

					EpdVO epdupd = new EpdVO();
					epdupd.setIddepd(epdp.getIddepd());
					epdupd.setCaiepd(iddcai);
					new EpdDAO().updConfirmaInscricaoByIdd(epdupd);
					new EpdDAO().getSqlMap().commitTransaction();
					
					//Responde para a Junta
					String resposta;
					if(cai.getSitcai().equals("P")){
						resposta = ClienteEmpreendimento.confirmaParcialInscricao(epdp.getNprepd(), cai.getImucai());
					} else {
						resposta = ClienteEmpreendimento.confirmaDeferimento(epdp.getNprepd(), "Acesse portal PMCG Alvara", cai.getImucai());
					}
					String tipoRetorno = resposta.replaceAll("TipoRetorno", "tipoRetorno").replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
					if(tipoRetorno.equals("SUCESSO")){
						new EpdDAO().updAtendidoByProcesso(epdp.getNprepd());
						new EpdDAO().getSqlMap().commitTransaction();
						//Manda e-mail com a Inscri��o Municipal se nova inscricao
						if(novaInscricao){
							HashMap<String, Object> nprepdParam = new HashMap<String, Object>();
							nprepdParam.put("nprepd", nprepd);
							HashMap<String, Object> dados = new EpdDAO().getDadosInsmun(nprepdParam);
							String email = dados.get("emareq").toString();
							String cpfcnpj = dados.get("cpfcnpj").toString();
							String nomraz = dados.get("nomraz").toString();
							String insmun = dados.get("insmun").toString();
							LogicUtils.sendEmailInsmun(email, nprepd, cpfcnpj, nomraz, insmun);
						
							// $$$$$$$$$$$$$$$$ LICENCIAMENTO $$$$$$$$$$$$$$$$$$
							
							// SE BAIXO RISCO MEIO AMBIENTE GRAVA LICENCA
							HashMap<String, Object> matriz = new MatDAO().getMatrizByProcesso(Long.parseLong(dados.get("iddpro").toString())); //ASSUMINDO QUE SEMPRE SER� 1 MATRIZ PARA CADA PROCESSO
							if(dados.get("ambaen").toString().equalsIgnoreCase("B")){
								LmaVO lma = new LmaVO();
								lma.setEsplma("DISPENSA");
								lma.setProlma(nprepd);
								lma.setEmilma(new Date());
								lma.setVallma(null);
								lma.setReqlma(matriz.get("nommat").toString());
								lma.setCpflma(epdp.getCnpepd());
								lma.setAtvlma(matriz.get("desmat").toString());
								lma.setEdrlma(matriz.get("endmat").toString());
								String iptu = new EpdDAO().getInscricaoByProcesso(nprepd);
								lma.setReglma(new ImoDAO().getRegiaoImovel(iptu));
								lma.setAnolma(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())));
								UsuVO gestor = new UsuDAO().getRegByCod(Long.parseLong(new CfgDAO().getValorByParam("CODUSU_RESP_LIC_MA")));
								lma.setAsslma(gestor.getNomusu());
								String haveramusica = new CpeDAO().getMusicaByIddepd(epdp.getIddepd());
								lma.setMuslma(haveramusica.equalsIgnoreCase("S")?false:true); //SE HAVER� M�SICA, MUSLMA = FALSE PQ N�O IR� APARECER A MSG "N�O AUTORIZADO M�SICA"...
								lma.setUsualt("CIMWEB");
								lma.setSitlma("A");
								Long iddlma = (Long) new LmaDAO().insReg(lma);
								if(iddlma != null && iddlma > 0){
									epdp.setLmaepd(iddlma);
									new EpdDAO().updLicencaAmb(epdp);
									new EpdDAO().getSqlMap().commitTransaction();
									
									//INSERE A LICENCA NO SIAT
									HashMap<String, Object> paramS = new HashMap<String, Object>();
									paramS.put("insmun", FormatUtils.onlyNumbers(dados.get("insmun").toString()));
									paramS.put("codlic", 7);
									Integer qtdlic = new EcoDAO().verificaEcolic(paramS);
									if(qtdlic != null && qtdlic <= 0){
										LmaVO licenca = new LmaDAO().getRegByCod(iddlma);
										paramS.put("numlic", licenca.getNumlma().toString() + "/" + licenca.getAnolma());
										try {
											new EcoDAO().getSqlMap().startTransaction();
											new EcoDAO().insEcolic(paramS);
											new EcoDAO().insEcolichis(paramS);
											new EcoDAO().getSqlMap().commitTransaction();
										} finally {
											new EcoDAO().getSqlMap().endTransaction();
										}
									}
								}
							}
							
							//GRAVA EMPREENDIMENTO NO SISTEMA SOS DA VIGILANCIA, E SE BAIXO RISCO GRAVA TBM A LICENCA
							try {
								//POR ENQUANTO NAO GERA LICENCA AUTOMATICA POIS TEM O PAGAMENTO DA GUIA
								//if(dados.get("vigaen").toString().equalsIgnoreCase("B")){
								//	new IntegraSos(nprepd,true);
								//} else {
									new IntegraSos(nprepd,false);
								//}
								new EpdDAO().getSqlMap().commitTransaction();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			} catch (Exception e) {
				new EpdDAO().getSqlMap().endTransaction();
				logger.error("N�o foi poss�vel inserir Cadastro Econ�mico! PROCESSO: " + epdp.getNprepd() + ", ATO: " + epdp.getProcesso().getAtopro());
			} finally {
				new EpdDAO().getSqlMap().endTransaction();
			}
		} else {
			logger.error("VERIFICAR PROTOCOLO: " + epdp.getNprepd() + ", ATO: " + epdp.getProcesso().getAtopro());
		}
	}
	
	public static void responderBae(BaeVO baep) throws Exception{
		//INSCRICAO
		try {
			new BaeDAO().getSqlMap().startTransaction();
			CaiVO cai = new CaiDAO().getRegByCod(baep.getCaibae());
						
			String inscricaoMunicipal;
			HashMap<String, String> resp = Util.gravaCadastroEconomico(baep.getViabae());
			//GRAVA A MSG DE RETORNO DO SIAT
			if(resp.get("mensagem") != null && !resp.get("mensagem").toString().isEmpty()){
				baep.setMsgbae(resp.get("mensagem").toString());
				new BaeDAO().updMensagemSIAT(baep);
				new BaeDAO().getSqlMap().commitTransaction();
			}
			
			//SE O WS DO SIAT RESPONDER QUE J� EXISTE O CNPJ BUSCA A INSCRICAO DO SIAT
			Boolean novaInscricao = true;
			if(resp.get("mensagem").toString().substring(0, 14).equals("CNPJ j� existe") ||
			   resp.get("mensagem").toString().trim().substring(0, 69).equals("Identifica��o Cadastral: J� existe Cadastro Econ�mico com o mesmo CPF")	){
				inscricaoMunicipal = new EcoDAO().getImuByCpfcnpj(baep.getCpfbae());
				novaInscricao = false;
			} else {
				inscricaoMunicipal = resp.get("inscricaoMunicipal").toString();
			}
			
			if(inscricaoMunicipal.length() != 11){
				logger.error("VERIFICAR PROTOCOLO: " + baep.getViabae() + ".");
			} else {
				cai.setImucai(inscricaoMunicipal);
				new CaiDAO().updImucai(cai);
				new BaeDAO().getSqlMap().commitTransaction();
				
				//Manda e-mail com a Inscri��o Municipal se nova inscricao
				if(novaInscricao){
					HashMap<String, Object> dados = new BaeDAO().getDadosInsmun(baep.getIddbae());
					String email = dados.get("emareq").toString();
					String cpfcnpj = dados.get("cpfcnpj").toString();
					String insmun = dados.get("insmun").toString();
					LogicUtils.sendEmailInsmun(email, baep.getViabae(), cpfcnpj, baep.getNombae(), insmun);
				}
			}
		} catch (Exception e) {
			new BaeDAO().getSqlMap().endTransaction();
			logger.error("N�o foi poss�vel inserir Cadastro Econ�mico! PROCESSO: " + baep.getViabae() + ".");
		} finally {
			new BaeDAO().getSqlMap().endTransaction();
		}
	}
	
	public static void confirmaRecebimentoVia(String protocolo){
		String resposta = null;
		try {
			resposta = ClienteViabilidade.confirmaRecebimentoConsulta(protocolo);
			String tipoRetorno = resposta.replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
			if(tipoRetorno.equals("SUCESSO")){
				new ViaDAO().updConfRecebimentoByProtocolo(protocolo);
			}
			logger.error("confirmaRecebimentoConsulta VIA (" + protocolo + "): " + tipoRetorno);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erro ao Confirmar Recebimento Viabilidade: " + protocolo + "-" + resposta);
		}
	}
	
	public static void confirmaRecebimentoEpd(EpdVO epd){
		String resposta = null;
		try {
			List<String> protocolosFCNRE = new ArrayList<String>();
			protocolosFCNRE.add(epd.getNprepd());
			resposta = ClienteEmpreendimento.confirmacaoRecebimentoEmpreendimentoPelaPrefeitura(protocolosFCNRE);
			resposta = resposta.replaceAll("TipoRetorno", "tipoRetorno");
			String tipoRetorno = resposta.replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
			String mensagem = resposta.replaceAll("\n", "").replaceFirst("^.*<mensagem>", "").replaceFirst("</mensagem>.*", "");
			mensagem = mensagem.replaceAll("[^a-z || A-Z || 0-9]", "");
			if(tipoRetorno.equals("SUCESSO")){
				new EpdDAO().updConfRecebimentoByProcesso(epd.getNprepd());
			}
			epd.setMgcepd((tipoRetorno!=null?tipoRetorno:"") + " - " + (mensagem!=null?mensagem:""));
			new EpdDAO().updMensagemConfRec(epd);
			logger.error("confirmaRecebimentoConsulta EPD (" + epd.getNprepd() + "): " + tipoRetorno);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erro ao Confirmar Recebimento Empreendimento: " + epd.getNprepd() + "-" + resposta);
		}
	}
	
	public static void gravaViabilidade(ViaVO via){
		try{
			new ViaDAO().getSqlMap().startTransaction();
			//INSERIR RESULTADOCLASSIFICACAO
			Long codvia = null, codrcl = null,codreq = null,codcol = null,codcen = null,codedr = null;
			Boolean temFatEstabFixo = false;
			if(via.getResultadoClassificacao() != null){
				if(via.getResultadoClassificacao().getBomrcl() != null || via.getResultadoClassificacao().getSemrcl()!= null || via.getResultadoClassificacao().getVisrcl() != null){
					try {
							codrcl = (Long) new RclDAO().insReg(via.getResultadoClassificacao());
						} catch (SQLException e) {
							logger.error("Erro ao Salvar RCL");
							e.printStackTrace();
						}
				}
			}
				//INSERIR REQUERENTE
				ReqVO requerente = via.getRequerente();
				requerente.setTipreq("V");
			try {
					codreq = (Long) new ReqDAO().insReg(requerente);
				} catch (SQLException e) {
					logger.error("Erro ao Salvar REQ");
					e.printStackTrace();
				}
				//INSERIR ENDERECO
				try {
					EdrVO edr = via.getColeta().getColetaEndereco().getEndereco();
					edr.setNloedr(edr.getLogedr());
					edr.setCepedr(edr.getCpvedr());
//					edr.setMunedr(edr.getMunicipio().getCodigoRFB());
//					edr.setTloedr(edr.getTipoLogradouro().getCodigo());
					edr.setTipedr("V"); //viabilidade
					edr.setTloedr(edr.getTipoLogradouro()!=null?edr.getTipoLogradouro().getCodigo():null);
					codedr = (Long) new EdrDAO().insReg(edr);
				} catch (SQLException e) {
					logger.error("Erro ao Salvar EDR");
					e.printStackTrace();
				}
				//INSERIR COLETA ENDERECO
				try {
					CenVO cen = via.getColeta().getColetaEndereco();
					cen.setIptcen(cen.getIptcen().replaceAll("[-]", "").replaceAll(" ", ""));
					cen.setEdrcen(codedr);
					codcen = (Long) new CenDAO().insReg(via.getColeta().getColetaEndereco());
				} catch (SQLException e) {
					logger.error("Erro ao Salvar CEN");
					e.printStackTrace();
				}
				
				//INSERIR COLETA
				ColVO col = via.getColeta();
				col.setCencol(codcen!=null?codcen.longValue():null); //minOccurs="0" maxOccurs="1" 
				col.setCoscol(col.getColetaObjetoSocial()!=null?col.getColetaObjetoSocial().getObjetoSocial():null); //minOccurs="0" maxOccurs="1"
				try {
					codcol = (Long) new ColDAO().insReg(col);
				} catch (SQLException e1) {
					logger.error("Erro ao Salvar COL");
					e1.printStackTrace();
				}
				//INSERIR COLETA SOCIO
				if(col.getColetaSocio() != null && col.getColetaSocio().size() > 0){
					for (CsoVO cso : col.getColetaSocio()) {
						cso.setColcso(codcol.longValue());
						cso.setCpfcso(cso.getCpf());
						cso.setNomcso(cso.getNomeSocio());
						try {
							new CsoDAO().insReg(cso);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar CSO");
							e.printStackTrace();
						}
					}
				}
				//INSERIR COLETA ATV ECON.
				if(col.getColetaAtividadeEconomica() != null && col.getColetaAtividadeEconomica().size() > 0){
					for (CaeVO cae : col.getColetaAtividadeEconomica()) {
						CnaVO cna = new CnaVO();
						cna.setColcna(codcol);
						cna.setCodcna(cae.getAtividadeEconomica().getCnae());
						cna.setDescna(cae.getDesdobramentoAtividadeEconomica()!=null?cae.getDesdobramentoAtividadeEconomica().getCodigo():null);
						cna.setTipcna("V");
						cna.setTaecna(cae.getTaecae());
						cna.setExecna(cae.getExecae());
						try {
							new CnaDAO().insReg(cna);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar CNA - Viabilidade");
							e.printStackTrace();
						}
					}
				}
				//INSERIR COLETA PERGUNTAS
				if(col.getColetaPergunta() != null && col.getColetaPergunta().size() > 0){
					for (CpeVO cpe : col.getColetaPergunta()) {
						cpe.setColcpe(codcol.longValue());
						cpe.setCopcpe(cpe.getPergunta().getCodigo());
						cpe.setDepcpe(cpe.getPergunta().getDescricao());
						try {
							new CpeDAO().insReg(cpe);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar CPE");
							e.printStackTrace();
						}
					}
				}
				//INSERIR COLETA TIPO UNIDADE FORMA ATUACAO
				if(col.getColetaTipoUnidadeFormaAtuacao() != null && col.getColetaTipoUnidadeFormaAtuacao().size() > 0){
					for (CfaVO cfa : col.getColetaTipoUnidadeFormaAtuacao()) {
						cfa.setColcfa(codcol.longValue());
						cfa.setCodcfa(cfa.getCodigo());
						if((col.getCtucol().equals("PRODUTIVA") && cfa.getCodigo().equals("01")) ||
						   (col.getCtucol().equals("AUXILIAR") && cfa.getCodigo().equals("11"))	){
							temFatEstabFixo = true;
						}
						try {
							new CfaDAO().insReg(cfa);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar CFA");
							e.printStackTrace();
						}
					}
				}	
			via.setMunvia(via.getMunicipio().getCodigoRFB());
			via.setNjrvia(via.getNaturezaJuridica().getCodigo());
			via.setRclvia(codrcl);
			via.setOrevia(via.getOrgaoRegistro()!=null?via.getOrgaoRegistro().getCodore():null);
			via.setReqvia(codreq);
			via.setColvia(codcol);
			via.setCrevia("N");
			via.setAenvia(null);
			via.setEstvia(temFatEstabFixo);
			try {
					codvia = (Long) new ViaDAO().insReg(via);
				} catch (SQLException e) {
					logger.error("Erro ao Salvar VIA");
					e.printStackTrace();
				}
			//INSERIR EVENTOS
			if(via.getEvento() != null && via.getEvento().size() > 0){
				for (EveVO eve : via.getEvento()) {
					VevVO vev = new VevVO();
					vev.setViavev(codvia);
					vev.setEvevev(eve.getCodigo());
					try {
						new VevDAO().insReg(vev);
					} catch (SQLException e) {
						logger.error("Erro ao Salvar VEV");
						e.printStackTrace();
					}
				}
			}
			try {
				new ViaDAO().getSqlMap().commitTransaction();
			} catch (SQLException e) {
				logger.error("Erro ao Concluir VIA/Confirmar Recebimento");
				e.printStackTrace();
			}
			new ViaDAO().getSqlMap().commitTransaction();
			//** CONFIRMA RECEBIMENTO **
			Util.confirmaRecebimentoVia(via.getProvia());
			new ViaDAO().getSqlMap().commitTransaction();
		} catch (SQLException e1) {
				e1.printStackTrace();
				logger.error("N�o foi poss�vel inserir a viabilidade " + via.getProvia() + "!");
			} finally {
				try {
					new ViaDAO().getSqlMap().endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//EMPREENDIMENTO
		public static void gravaEmpreendimento(EpdVO epd){
			try{	
				new EpdDAO().getSqlMap().endTransaction();
				new EpdDAO().getSqlMap().startTransaction();
				Long iddreq = null, iddmat = null, iddpro = null, iddedr = null, iddedrsad = null;
				Long iddsad = null, iddedrrep = null, iddfil = null, iddedrfil = null;
				
				//INSERIR REQUERENTE
				ReqVO req = epd.getProcesso().getRequerente();
				req.setTipreq("E");
				try {
					iddreq = (Long) new ReqDAO().insReg(req);
				} catch (SQLException e) {
					logger.error("Erro ao Salvar REQ");
					e.printStackTrace();
				}
				
				//INSERIR PROCESSO
			    ProVO pro = epd.getProcesso();
			    pro.setReqpro(iddreq);
			    pro.setDaspro(pro.getDataAssinatura()!=null?formatDataInv.parse(pro.getDataAssinatura()):null);
				pro.setNjrpro(pro.getNaturezaJuridica()!=null?pro.getNaturezaJuridica().getCodigo():null);
				pro.setAtopro(pro.getAto()!=null?pro.getAto().getCodigo():null);
				iddpro = (Long) new ProDAO().insReg(pro);
				
				//INSERIR ENDERE�O - MATRIZ
				EdrVO edr = epd.getProcesso().getMatriz().getEndereco();
				edr.setTipedr("E");
				edr.setMunedr(edr.getMunicipio()!=null?edr.getMunicipio().getCodigoRFB():null);
				edr.setUffedr(edr.getUf()!=null?edr.getUf().getSigla():null);
				edr.setPaiedr(edr.getPais()!=null?edr.getPais().getCodigoRFB():null);
				edr.setEexedr(edr.getEexedr()!=null?edr.getEexedr():null);
				edr.setTloedr(edr.getTipoLogradouro()!=null?edr.getTipoLogradouro().getCodigoFRB():null);
				edr.setNloedr(edr.getNleedr()!=null?edr.getNleedr():null);
				edr.setCepedr(edr.getCpeedr()!=null?edr.getCpeedr():null);
				try {
					iddedr = (Long) new EdrDAO().insReg(edr);
				} catch (SQLException e) {
					logger.error("Erro ao Salvar EDR-Matriz");
					e.printStackTrace();
				}
				
				//INSERIR MATRIZ
				MatVO mat = epd.getProcesso().getMatriz();
				mat.setPromat(iddpro);
				mat.setDinmat(mat.getDataInicioAtividade()!=null?formatData.parse(mat.getDataInicioAtividade()):null);
				mat.setEndmat(iddedr);
				try {
					iddmat = (Long) new MatDAO().insReg(mat);
				} catch (SQLException e) {
					logger.error("Erro ao Salvar MAT");
					e.printStackTrace();
				}
				
				//INSERIR EVENTOS
				if(pro.getEventos() != null && pro.getEventos().getProcessoEvento() != null && pro.getEventos().getProcessoEvento().size() > 0){
					for (PevVO pev : pro.getEventos().getProcessoEvento()) {
						EevVO eev = new EevVO();
						eev.setProeev(iddpro);
						eev.setEveeev(pev.getEvento().getCodigo());
						try {
							new EevDAO().insReg(eev);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar EEV");
							e.printStackTrace();
						}
					}
				}
				
				//INSERIR CNAES - MATRIZ
				if(pro.getMatriz().getCnaes() != null && pro.getMatriz().getCnaes().getCnae().size() > 0){
					for (CnaVO cna : pro.getMatriz().getCnaes().getCnae()) {
						cna.setTipcna("E");
						cna.setCodcna(cna.getCodigoCnae().toString());
						cna.setMatcna(iddmat);
						try {
							new CnaDAO().insReg(cna);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar CNA_Matriz");
							e.printStackTrace();
						}
					}
				}
				
				//INSERIR SOCIOS_ADM - MATRIZ
				if(pro.getMatriz().getSociosAdm() != null && pro.getMatriz().getSociosAdm().getSocioAdministrador().size() > 0){
					for (SadVO sad : pro.getMatriz().getSociosAdm().getSocioAdministrador()) {
						
						Long iddsoc = null, iddadm = null;
						//INSERIR ENDERE�O - SAD
						if(sad.getEndereco() == null){
							//altera��o jucemg - nao esta mais vindo endereco em alguns casos (2135 por exemplo), setar end da matriz
							iddedrsad = iddedr;
						} else {
							EdrVO edrsad = sad.getEndereco();
							edrsad.setTipedr("E");
							edrsad.setMunedr(edrsad.getMunicipio()!=null?edrsad.getMunicipio().getCodigoRFB():null);
							edrsad.setUffedr(edrsad.getUf()!=null?edrsad.getUf().getSigla():null);
							edrsad.setPaiedr(edrsad.getPais()!=null?edrsad.getPais().getCodigoRFB():null);
							edrsad.setEexedr(edrsad.getEexedr()!=null?edrsad.getEexedr():null);
							edrsad.setTloedr(edrsad.getTipoLogradouro()!=null?edrsad.getTipoLogradouro().getCodigoFRB():null);
							edrsad.setNloedr(edrsad.getNleedr()!=null?edrsad.getNleedr():null);
							edrsad.setCepedr(edrsad.getCpeedr()!=null?edrsad.getCpeedr():null);
							try {
								iddedrsad = (Long) new EdrDAO().insReg(edrsad);
							} catch (SQLException e) {
								logger.error("Erro ao Salvar EDR-SAD-Matriz");
								e.printStackTrace();
							}
						}
						//INSERIR SOCIO
						SocVO soc = sad.getSocio();
							if(soc!=null){
							soc.setConsoc(soc.getCondicaoSocio().getCodigo());
							soc.setDinsoc(soc.getDataInicio()!=null?formatData.parse(soc.getDataInicio()):null);
							soc.setDfisoc(soc.getDataFim()!=null?formatData.parse(soc.getDataFim()):null);
							try {
								iddsoc = (Long) new SocDAO().insReg(soc);
							} catch (SQLException e) {
								logger.error("Erro ao Salvar SOC-SAD-Matriz");
								e.printStackTrace();
							}
						}
						
						//INSERIR ADMINISTRADOR
						AdmVO adm = sad.getAdministrador();
						if(adm!=null){
							adm.setConadm(adm.getCondicaoAdministrador().getCodigo());
							adm.setDinadm(adm.getDataInicioMandato()!=null?formatData.parse(adm.getDataInicioMandato()):null);
							adm.setDfiadm(adm.getDataFimMandato()!=null?formatData.parse(adm.getDataFimMandato()):null);
							adm.setDsaadm(adm.getDataSaida()!=null?formatData.parse(adm.getDataSaida()):null);
							try {
								iddadm = (Long) new AdmDAO().insReg(adm);
							} catch (SQLException e) {
								logger.error("Erro ao Salvar adm-SAD-Matriz");
								e.printStackTrace();
							}
						}
						
						sad.setEstsad(sad.getEstadoCivil()!=null?sad.getEstadoCivil().getCodigo():null);
						sad.setNacsad(sad.getNacionalidade()!=null?sad.getNacionalidade().getCodigoRFB():null);
						sad.setDnasad(sad.getDataNascimento()!=null?formatData.parse(sad.getDataNascimento()):null);
						sad.setRegsad(sad.getRegimeBens()!=null?sad.getRegimeBens().getCodigo():null);
						sad.setEmcsad(sad.getEmancipacao()!=null?sad.getEmancipacao().getCodigo():null);
						sad.setUfosad(sad.getUfOrgaoEmissor()!=null?sad.getUfOrgaoEmissor().getSigla():null);
						sad.setEndsad(iddedrsad);
						sad.setSocsad(iddsoc);
						sad.setAdmsad(iddadm);
						sad.setMatsad(iddmat);
						try {
							iddsad = (Long) new SadDAO().insReg(sad);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar SAD_Matriz");
							e.printStackTrace();
						}
						
						//INSERIR REPRESENTANTES LEGAIS
						if(sad.getRepsVO() != null && sad.getRepsVO().getRepsLegais().size() > 0){
							
							for (RepVO rep : sad.getRepsVO().getRepsLegais()) {
								
								//INSERIR ENDERECO REP LEGAL
								EdrVO edrrep = rep.getEndereco();
								edrrep.setTipedr("E");
								edrrep.setMunedr(edrrep.getMunicipio()!=null?edrrep.getMunicipio().getCodigoRFB():null);
								edrrep.setUffedr(edrrep.getUf()!=null?edrrep.getUf().getSigla():null);
								edrrep.setPaiedr(edrrep.getPais()!=null?edrrep.getPais().getCodigoRFB():null);
								edrrep.setEexedr(edrrep.getEexedr()!=null?edrrep.getEexedr():null);
								edrrep.setTloedr(edrrep.getTipoLogradouro()!=null?edrrep.getTipoLogradouro().getCodigoFRB():null);
								edrrep.setNloedr(edrrep.getNleedr()!=null?edrrep.getNleedr():null);
								edrrep.setCepedr(edrrep.getCpeedr()!=null?edrrep.getCpeedr():null);
								try {
									iddedrrep = (Long) new EdrDAO().insReg(edrrep);
								} catch (SQLException e) {
									logger.error("Erro ao Salvar EDR-REP-SAD-Matriz");
									e.printStackTrace();
								}
								
								rep.setSadrep(iddsad);
								rep.setUforep(rep.getUfOrgaoEmissor().getSigla());
								rep.setDnarep(rep.getDataNascimento()!=null?formatDataInv.parse(rep.getDataNascimento().substring(0,10)):null);
								rep.setDinrep(rep.getDataInicioMandato()!=null?formatData.parse(rep.getDataInicioMandato()):null);
								rep.setDfirep(rep.getDataFimMandato()!=null?formatData.parse(rep.getDataFimMandato()):null);
								rep.setNacrep(rep.getNacionalidade()!=null?rep.getNacionalidade().getCodigoRFB():null);
								rep.setEstrep(rep.getEstadoCivil()!=null?rep.getEstadoCivil().getCodigo():null);
								rep.setTrlrep(rep.getTipoRepresentanteLegal()!=null?rep.getTipoRepresentanteLegal().getCodigo():null);
								rep.setEndrep(iddedrrep);
								try {
									new RepDAO().insReg(rep);
								} catch (SQLException e) {
									logger.error("Erro ao Salvar CNA_Matriz");
									e.printStackTrace();
								}
							}
						}
					}
				}
				
				//INSERIR FILIAIS - MATRIZ
				if(mat.getFiliais() != null && mat.getFiliais().getFilial() != null && mat.getFiliais().getFilial().size() > 0){
					for (FilVO fil : mat.getFiliais().getFilial()) {
						//INSERIR ENDERECO FILIAL
						EdrVO edrfil = fil.getEndereco();
						edrfil.setTipedr("E");
						edrfil.setMunedr(edrfil.getMunicipio()!=null?edrfil.getMunicipio().getCodigoRFB():null);
						edrfil.setUffedr(edrfil.getUf()!=null?edrfil.getUf().getSigla():null);
						edrfil.setPaiedr(edrfil.getPais()!=null?edrfil.getPais().getCodigoRFB():null);
						edrfil.setEexedr(edrfil.getEexedr()!=null?edrfil.getEexedr():null);
						edrfil.setTloedr(edrfil.getTipoLogradouro()!=null?edrfil.getTipoLogradouro().getCodigoFRB():null);
						edrfil.setNloedr(edrfil.getNleedr()!=null?edrfil.getNleedr():null);
						edrfil.setCepedr(edrfil.getCpeedr()!=null?edrfil.getCpeedr():null);
						try {
							iddedrfil = (Long) new EdrDAO().insReg(edrfil);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar EDR-REP-SAD-Matriz");
							e.printStackTrace();
						}
						
						fil.setMatfil(iddmat);
						fil.setEndfil(iddedrfil);
						fil.setEvefil(fil.getEvento()!=null?fil.getEvento().getCodigo():null);
						fil.setDinfil(fil.getDataInicioAtividade()!=null?formatData.parse(fil.getDataInicioAtividade()):null);
						try {
							iddfil = (Long) new FilDAO().insReg(fil);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar Filial_Matriz");
							e.printStackTrace();
						}
						
						//INSERIR CNAES - FILIAL
						if(fil.getCnaes() != null && fil.getCnaes().getCnae() != null && fil.getCnaes().getCnae().size() > 0){
							for (CnaVO cna : fil.getCnaes().getCnae()) {
								cna.setTipcna("E");
								cna.setCodcna(cna.getCodigoCnae().toString());
								cna.setFilcna(iddfil);
								try {
									new CnaDAO().insReg(cna);
								} catch (SQLException e) {
									logger.error("Erro ao Salvar CNA_Filial");
									e.printStackTrace();
								}
							}
						}
					}
				}
				
				//INSERIR EMPREENDIMENTO
				epd.setDgnepd(epd.getDataGravacaoNire()!=null?formatDataHora.parse(epd.getDataGravacaoNire()):null); //dataGravacaoNire
				epd.setDgcepd(epd.getDataGravacaoCnpj()!=null?formatDataHora.parse(epd.getDataGravacaoCnpj()):null); //dataGravacaoCnpj
				epd.setCreepd("N");
				epd.setProepd(iddpro);
				epd.setAteepd(false);
				try {
					new EpdDAO().insReg(epd);
				} catch (SQLException e) {
					logger.error("Erro ao Salvar REQ");
					e.printStackTrace();
				}
				new EpdDAO().getSqlMap().commitTransaction();
				Util.confirmaRecebimentoEpd(epd);
				new EpdDAO().getSqlMap().commitTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
				logger.error("N�o foi poss�vel inserir o empreendimento! N� Processo: " + epd.getNprepd() + ".");
			} catch (ParseException e1) {
				e1.printStackTrace();
			} finally {
				try {
					new EpdDAO().getSqlMap().endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	
	 //ESTE M�TODO VISA ADEQUAR OS CNAES RECEBIDOS DA JUNTA AO NOSSO FORMATO DE 10 DIGITOS
	//INICIALMENTE UTILIZAVAM APENAS 7 D�GITOS
	//PEDIMOS PARA FAZER O DESDOBRAMENTO E ELES COLOCARAM 9, CONFORME A LISTA DO CONCLA
	public static String formataCnaeSemMascara(String cnae){
		cnae = cnae.trim().replaceAll("[-/]", "");
		StringBuilder sb = new StringBuilder(cnae);
        if(cnae.length() == 7){
			sb.insert(7, "000");
		} else if(cnae.length() == 9){
			sb.insert(7, "0");
		} 
		return sb.toString();
	}
	
	public static String formataCnaeComMascara(String cnae){
		cnae = cnae.trim();
		StringBuilder sb = new StringBuilder(cnae);
        
		if(cnae.length() == 7){
			sb.insert(4, "-").insert(6, "/").insert(9, "-000");
		} else if(cnae.length() == 9){
			sb.insert(4, "-").insert(6, "/").insert(9, "-0");
		} else if(cnae.length() == 10){
			sb.insert(4, "-").insert(6, "/").insert(9, "-");
		}
		return sb.toString();
	}
	
	public static HashMap<String, String> gravaCadastroEconomico(String numeroProcesso) throws Exception {
		// M�TODO PARA INSERIR O CADASTRO ECONOMICO NO SIAT ATRAV�S DO WEBSERVICE - METODO GRAVACADASTROECONOMICO
		//Objetos do BAE:
		BaeVO bae = null;
		ViaVO via = null;
		//Objetos da Junta:
		EpdVO epd = null;
		ProVO processo = null;
		MatVO matriz = null;
		
		if(numeroProcesso.startsWith("CGR")){
			//BAE
			bae = new BaeDAO().getBaeByViabae(numeroProcesso);
			via = new ViaDAO().getRegByProvia(numeroProcesso);
		} else {
			epd = new EpdDAO().getRegByProcesso(numeroProcesso);
			processo = new ProDAO().getRegByCod(epd.getProepd());
			matriz = new MatDAO().getRegByProcesso(processo.getIddpro());
			
			processo.setMatriz(matriz);
			epd.setProcesso(processo);
		}
		//Esses objetos estou aproveitando para os dois (BAE e Junta)
		EdrVO endMatriz = new EdrDAO().getRegByCod(matriz!=null?matriz.getEndmat():bae.getEdlbae());
		if(matriz != null){
			matriz.setEndereco(endMatriz);
		}
		List<CnaVO> listCnaMat;
		List<SadVO> listSad;
		if(numeroProcesso.startsWith("CGR")){
			listCnaMat = new CnaDAO().getRegByProtocoloVia(bae.getViabae());
			listSad = new SadDAO().getRegByBae(bae.getIddbae());
		} else {
			listCnaMat = new CnaDAO().getRegByProcessoMatriz(epd.getNprepd());
			listSad = new SadDAO().getByMatriz(matriz.getIddmat());
		}
		 
		String inscricaoImo = new ViaDAO().getInscricaoByProtocolo(matriz!=null?matriz.getPvimat():bae.getViabae());
		String tipoUnidade = new ViaDAO().getTipoUnidadeByProtocolo(matriz!=null?matriz.getPvimat():bae.getViabae());
		String riscoGeral = new ViaDAO().getRiscoByProtocolo(matriz!=null?matriz.getPvimat():bae.getViabae());
		
		HashMap<String, String> resp = new HashMap<String, String>();;
		String tipo_imo = new ImoDAO().getTipoImovel(inscricaoImo);
		
		HashMap<String, Object> dadosVia = new ViaDAO().getDadosByProtocolo(numeroProcesso);
		if(((!numeroProcesso.startsWith("CGR")) || (numeroProcesso.startsWith("CGR") && ((dadosVia.get("tipvia").toString().equals("M") && ((Boolean) dadosVia.get("possuiestabelecimentofixo"))) || (dadosVia.get("tipvia").toString().equals("A") && dadosVia.get("sauvia").toString().equals("E")))))
				&& tipo_imo != null && tipo_imo.equals("T")){
			//SE FOR TERRITORIAL N�O GERA INSCRI��O (PARA N�O GERAR ALVAR�) ENQUANTO O CARA N�O REGULARIZAR A CONSTRU��O COMO PREDIAL
			resp.put("resposta", "0");
			resp.put("mensagem", "Inscri��o Imobili�ria de uso TERRITORIAL!");
			resp.put("inscricaoMunicipal", null);
		} else {
			EntradaGravaCadastroEconomico ce = new EntradaGravaCadastroEconomico();
			ce.setTipoEntrada(TipoEntrada.I); // Inclus�o
			ce.setInscricaoMunicipal(""); 
			ce.setDataAbertura(epd!=null?epd.getDgnepd()!=null?epd.getDgnepd():epd.getDatepd():bae!=null&&bae.getDtrbae()!=null?bae.getDtrbae():new Date()); //dataGravacaoNIRE
			if(riscoGeral.equals("A")){
				ce.setRisco(RiscoAlvara.A);
			} else if(riscoGeral.equals("M")){
				ce.setRisco(RiscoAlvara.M);
			} else {
				ce.setRisco(RiscoAlvara.B); 
			}
			if(ce.getRisco() == RiscoAlvara.B){
				ce.setStatus(StatusImpressaoAlvara.L); //LIBERADO
			} else if(ce.getRisco() == RiscoAlvara.M){
				ce.setStatus(StatusImpressaoAlvara.C); //CONDICIONADO (pode emitir alvar� provis�rio)
			} else {
				ce.setStatus(StatusImpressaoAlvara.B); //BLOQUEADO
			}
			if(numeroProcesso.startsWith("CGR") && via.getNjrvia().equals("4081")){
				ce.setDataColacaoGrau(bae.getDtcbae());
			}
			if(numeroProcesso.startsWith("CGR") && dadosVia.get("tipvia").toString().equals("A") && dadosVia.get("sauvia").toString().equals("N")){
				ce.setEstabelecido(Boleano.N);
			} else {
				ce.setEstabelecido(Boleano.S);
			}
			ce.setNaturezaJuridica(epd!=null?epd.getProcesso().getNjrpro():via.getNjrvia());
			String cpfCnpj = epd!=null?epd.getCnpepd():bae.getCpfbae();
			if(cpfCnpj.length() == 14){
				ce.setTipoPessoa(TipoPessoa.PJ);
			} else {
				ce.setTipoPessoa(TipoPessoa.PF);
			}
			ce.setProtocoloCpe(numeroProcesso);
			if(numeroProcesso.startsWith("CGR") && via.getNjrvia().equals("4081")){
				ce.setDescricaoOcupacao(Formatacao.montaDescricaoAtividade(bae.getViabae()));
			} else {
				if(numeroProcesso.startsWith("CGR")){
					ce.setDescricaoAtividade(Formatacao.montaDescricaoAtividade(bae.getViabae()));
				}else {
					ce.setDescricaoAtividade(epd.getProcesso().getMatriz().getDesmat());
				}
			}
			
			ce.setNomeFantasia(epd!=null?epd.getProcesso().getMatriz().getNfamat():bae.getNfabae());
			ce.setTipoEstabelecimento(TipoEstabelecido.M); //MATRIZ
			ce.setCnpjMatriz("");
			ce.setOrgaoRegistro(epd!=null?"1":bae!=null&&bae.getOrebae()!=null?bae.getOrebae():"5");
			ce.setUfOrgaoRegistro("MS");
			String nrReg = null;
			Date dataReg = null;
			if(epd != null){
				nrReg = epd.getNirepd()!=null?epd.getNirepd():matriz.getNirmat()!=null?matriz.getNirmat():matriz.getNiamat();
				dataReg = epd.getDgnepd()!=null?epd.getDgnepd():ce.getDataAbertura();
			} else {
				nrReg = bae.getNrrbae();
				dataReg = bae.getDtrbae()!=null?bae.getDtrbae():new Date();
			}
			ce.setNumeroRegistro(nrReg);
			ce.setDataRegistro(dataReg);
			ce.setDocumentoConstituicao("1");
			ce.setDataConstituicao(ce.getDataAbertura());
			ce.setLivro(bae!=null&&bae.getLivbae()!=null?bae.getLivbae():"");
			ce.setFolha(bae!=null&&bae.getFolbae()!=null?bae.getFolbae():"");
			ce.setInscricaoEstadual(bae!=null&&bae.getIesbae()!=null?bae.getIesbae():"");
			
			String tipoEnquadramento = epd!=null?epd.getProcesso().getMatriz().getPormat():via.getTeqvia();
			if(tipoEnquadramento.equals("MICRO_EMPRESA")){
				ce.setPorteEmpresa("ME");
			} else if(tipoEnquadramento.equals("EMPRESA_PEQUENO_PORTE")){
				ce.setPorteEmpresa("EPP");
			} else if(tipoEnquadramento.equals("MEDIO")){  //VIABILIDADE PMCG
				ce.setPorteEmpresa("M");
			} else if(tipoEnquadramento.equals("GRANDE")){ //VIABILIDADE PMCG
				ce.setPorteEmpresa("G");
			} else if(tipoEnquadramento.equals("OUTROS")){
				ce.setPorteEmpresa("M"); //EST� M�DIO - tem tbm o G - GRANDE
			}
			
			BigDecimal capitalSocial = epd!=null?new BigDecimal(epd.getProcesso().getMatriz().getCapmat()).divide(new BigDecimal(100)):ce.getNaturezaJuridica().equals("4081")?new BigDecimal("0.0"):new BigDecimal(bae.getCapbae());
			ce.setCapitalSocial(capitalSocial);
			ce.setDataUltimaAtualizacaoCapitalSocial(ce.getDataRegistro());
			ce.setRegimeFederal("");
			ce.setDataInicioRegimeFederal(null);
			if(tipoUnidade != null && tipoUnidade.equals("PRODUTIVA")){
				ce.setTipoUnidade(TipoUnidade.P);
			} else {
				ce.setTipoUnidade(TipoUnidade.A);
				//ce.setTipoUnidadeAuxiliar("");
			}
			
				EntradaPessoaGravaCadastroEconomico entradaPessoa = new EntradaPessoaGravaCadastroEconomico();
				entradaPessoa.setCpfCnpj(cpfCnpj);
				String razaoSocial = epd!=null?epd.getProcesso().getMatriz().getNommat():bae.getNombae();
				entradaPessoa.setNomeRazaoSocial(razaoSocial);
				entradaPessoa.setNomeRazaoSocialResumido(razaoSocial.length()>150?razaoSocial.substring(0,150):razaoSocial);
				entradaPessoa.setTipoEnderecoEntregaPessoa(TipoEnderecoEntregaPessoa.C);
				TipoDocumento td = null;
				if(bae!=null && bae.getDtpbae()!=null){
					if(bae.getDtpbae().equals("RG")){
						td = TipoDocumento.RG;
					} else if(bae.getDtpbae().equals("RM")){
						td = TipoDocumento.RM;
					} else if(bae.getDtpbae().equals("RNE")){
						td = TipoDocumento.RNE;
					}
				}
				entradaPessoa.setTipoDocumento(td);
				entradaPessoa.setNumeroDocumento(bae!=null&&bae.getDnrbae()!=null?bae.getDnrbae():"");
				entradaPessoa.setOrgaoExpedidor(bae!=null&&bae.getDoebae()!=null?bae.getDoebae():"");
				entradaPessoa.setUfOrgaoExpedidor(bae!=null&&bae.getDuobae()!=null?bae.getDuobae():"");
				entradaPessoa.setDataExpedicao(bae!=null&&bae.getDexbae()!=null?bae.getDexbae():null);
				entradaPessoa.setDataNascimento(bae!=null&&bae.getDnabae()!=null?bae.getDnabae():null);
				entradaPessoa.setPaisNaturalidade("");
				entradaPessoa.setEstadoCivil("");
				Sexo sex = null;
				if(bae!=null&&bae.getSexbae()!=null && bae.getSexbae().equals("M")){
					sex = Sexo.M;
				} else if(bae!=null&&bae.getSexbae()!=null && bae.getSexbae().equals("F")){
					sex = Sexo.F;
				}
				entradaPessoa.setSexo(sex);
				
					EntradaEnderecoPessoaGravaCadastroEconomico end = new EntradaEnderecoPessoaGravaCadastroEconomico();
					end.setTipoEndereco(TipoEnderecoCobrancaPessoa.R);
					if(endMatriz.getPaiedr() == 105L){
						end.setTipoLocalizacao(TipoLocalizacao.NAC);
						end.setPais("Brasil");
					} else {
						end.setTipoLocalizacao(TipoLocalizacao.INT);
						end.setPais(new TabDAO().getPaisByCodigo(endMatriz.getPaiedr().toString()));
						end.setEnderecoReferencia(endMatriz.getEexedr()!=null?endMatriz.getEexedr():null);
					}
					end.setTipoLogradouro(endMatriz.getTloedr());
					end.setLogradouro(endMatriz.getNloedr());
					end.setNumero(FormatUtils.getNumeroLogradouro(endMatriz.getNumedr()));
					if(end.getNumero()== 0 && (endMatriz.getComedr() == null || (endMatriz.getComedr() != null && endMatriz.getComedr().isEmpty()))){
						end.setComplemento(endMatriz.getNumedr());
					} else {
						end.setComplemento(endMatriz.getComedr());
					}
					end.setTipoBairro(endMatriz.getTbaedr()!=null?endMatriz.getTbaedr():"BAIRRO");
					end.setBairro(endMatriz.getBaiedr());
					end.setDistrito("");
					end.setCidade("CAMPO GRANDE"); //esta vindo o codigo
					end.setUf(endMatriz.getUffedr());
					end.setCep(endMatriz.getCepedr());
					end.setEnderecoReferencia("");
					end.setZipCode(endMatriz.getCepedr());
					end.setInscricaoImobiliaria(inscricaoImo);
					end.setPovoado("");
					end.setZonaRural("");
					end.setCcir("0");
					end.setNirf("0");
					end.setDatum(null);
					end.setLatitude("");
					end.setLongitude("");
					if(bae!=null){
						end.setDddTelefone(bae.getDdtbae()!=null?bae.getDdtbae():bae.getDdcbae()!=null?bae.getDdcbae():"");
						end.setTelefone(bae.getTelbae()!=null?bae.getTelbae():bae.getCelbae()!=null?bae.getCelbae():"");
					}	else {
						end.setDddTelefone(matriz.getDddmat()!=null?matriz.getDddmat():"");
						end.setTelefone(matriz.getTelmat()!=null?matriz.getTelmat():"");
					}
					end.setDddFax("");
					end.setFax("");
					end.setEmail(bae!=null&&bae.getEmabae()!=null?bae.getEmabae():"");
					List<EntradaEnderecoPessoaGravaCadastroEconomico> listEnd = new ArrayList<EntradaEnderecoPessoaGravaCadastroEconomico>();
					listEnd.add(end);
					entradaPessoa.setEntradaEnderecosPessoa(listEnd);
				ce.setEntradaPessoa(entradaPessoa);
				
				EntradaEnderecoLocalizacaoGravaCadastroEconomico endLoc = new EntradaEnderecoLocalizacaoGravaCadastroEconomico();
				endLoc.setTipoImovel(TipoImovelMob.C);
				endLoc.setUsoImovel(UsoImovelMob.AL);
				Double areaUtilizada = new ImoDAO().getAreaUtilizadaByInscricao(inscricaoImo);
				endLoc.setAreaTerrenoUtilizada(new BigDecimal(areaUtilizada!=null?areaUtilizada.toString():"0.00"));
				endLoc.setEnderecoComercialOficial(Boleano.S);
				if(endMatriz.getPaiedr() == 105L){
					endLoc.setTipoLocalizacao(TipoLocalizacao.MUNURB);
					endLoc.setPais("Brasil");
				} else {
					endLoc.setTipoLocalizacao(TipoLocalizacao.INT);
					endLoc.setPais(new TabDAO().getPaisByCodigo(endMatriz.getPaiedr().toString()));
					endLoc.setEnderecoReferencia(endMatriz.getEexedr()!=null?endMatriz.getEexedr():null);
				}
				endLoc.setTipoLogradouro(endMatriz.getTloedr());
				endLoc.setLogradouro(endMatriz.getNloedr());
				endLoc.setNumero(FormatUtils.getNumeroLogradouro(endMatriz.getNumedr()));
				if(endLoc.getNumero()==0 && (endMatriz.getComedr() == null || (endMatriz.getComedr() != null && endMatriz.getComedr().isEmpty()))){
					endLoc.setComplemento(endMatriz.getNumedr());
				} else {
					endLoc.setComplemento(endMatriz.getComedr());
				}
				endLoc.setTipoBairro("BAIRRO");
				endLoc.setBairro(endMatriz.getBaiedr());
				endLoc.setDistrito("");
				endLoc.setCidade("Campo Grande");
				endLoc.setUf("MS");
				endLoc.setCep(endMatriz.getCepedr());
				endLoc.setEnderecoReferencia("");
				endLoc.setZipCode(endMatriz.getCepedr());
				endLoc.setInscricaoImobiliaria(inscricaoImo);
				endLoc.setPovoado("");
				endLoc.setZonaRural("");
				endLoc.setCcir("0");
				endLoc.setNirf("0");
				endLoc.setDatum(null);
				endLoc.setLatitude("");
				endLoc.setLongitude("");
				endLoc.setDddTelefone(end.getDddTelefone());
				endLoc.setTelefone(end.getTelefone());
				endLoc.setDddFax("");
				endLoc.setFax("");
				endLoc.setEmail(end.getEmail());
				ce.setEntradaEnderecoLocalizacao(endLoc);
				
				EntradaEnderecoEntregaGravaCadastroEconomico endEnt = new EntradaEnderecoEntregaGravaCadastroEconomico();
				endEnt.setTipoEnderecoEntregaMob(TipoEnderecoEntregaMob.E);
				endEnt.setCpfCnpjPessoa("");
				if(endMatriz.getPaiedr() == 105L){
					endEnt.setTipoLocalizacao(TipoLocalizacao.MUNURB);
					endEnt.setPais("Brasil");
				} else {
					endEnt.setTipoLocalizacao(TipoLocalizacao.INT);
					endEnt.setPais(new TabDAO().getPaisByCodigo(endMatriz.getPaiedr().toString()));
					endEnt.setEnderecoReferencia(endMatriz.getEexedr()!=null?endMatriz.getEexedr():null);
				}
				endEnt.setTipoLogradouro(endMatriz.getTloedr());
				endEnt.setLogradouro(endMatriz.getNloedr());
				endEnt.setNumero(FormatUtils.getNumeroLogradouro(endMatriz.getNumedr()));
				if(endEnt.getNumero()==0 && (endMatriz.getComedr() == null || (endMatriz.getComedr() != null && endMatriz.getComedr().isEmpty()))){
					endEnt.setComplemento(endMatriz.getNumedr());
				} else {
					endEnt.setComplemento(endMatriz.getComedr());
				}
				endEnt.setTipoBairro("BAIRRO");
				endEnt.setBairro(endMatriz.getBaiedr());
				endEnt.setDistrito("");
				endEnt.setCidade("Campo Grande");
				endEnt.setUf("MS");
				endEnt.setCep(endMatriz.getCepedr());
				endEnt.setEnderecoReferencia("");
				endEnt.setZipCode(endMatriz.getCepedr());
				endEnt.setInscricaoImobiliaria(inscricaoImo);
				endEnt.setPovoado("");
				endEnt.setZonaRural("");
				endEnt.setCcir("0");
				endEnt.setNirf("0");
				endEnt.setDatum(null);
				endEnt.setLatitude("");
				endEnt.setLongitude("");
				endEnt.setDddTelefone(end.getDddTelefone());
				endEnt.setTelefone(end.getTelefone());
				endEnt.setDddFax("");
				endEnt.setFax("");
				endEnt.setEmail(end.getEmail());
				ce.setEntradaEnderecoEntrega(endEnt);
				
				if(ce.getNaturezaJuridica().equals("4081")){
					//OCUPACOES (AUTONOMO)
					List<EntradaOcupacaoGravaCadastroEconomico> entOcp = new ArrayList<EntradaOcupacaoGravaCadastroEconomico>(); //Lista de atividades
					for(CnaVO cna : listCnaMat) {
						EntradaOcupacaoGravaCadastroEconomico ocp = new EntradaOcupacaoGravaCadastroEconomico();
						String codatv = cna.getCodcna().length() == 10?cna.getCodcna():cna.getCodcna() + (cna.getDescna()!=null&&(!cna.getDescna().isEmpty())?cna.getDescna():"00");
						ocp.setCodigoOcupacao(codatv);
						if(cna.getPricna() != null && cna.getPricna() == 1){
							ocp.setTipoOcupacao(TipoOcupacao.P);
						} else {
							ocp.setTipoOcupacao(TipoOcupacao.S);
						}
						ocp.setDataInicioOcupacao(ce.getDataAbertura());
						ocp.setDataFimOcupacao(null);
						entOcp.add(ocp);
					}
					ce.setEntradasOcupacoes(entOcp);
				} else {
					//ATIVIDADES
					List<EntradaAtividadeGravaCadastroEconomico> entAtv = new ArrayList<EntradaAtividadeGravaCadastroEconomico>(); //Lista de atividades
					for(CnaVO cna : listCnaMat) {
						EntradaAtividadeGravaCadastroEconomico atv = new EntradaAtividadeGravaCadastroEconomico();
						String codatv = cna.getCodcna().length() == 10?cna.getCodcna():cna.getCodcna() + (cna.getDescna()!=null&&(!cna.getDescna().isEmpty())?cna.getDescna():"00");
						atv.setCodigoAtividade(codatv);
						if(cna.getPricna() != null && cna.getPricna() == 1){
							atv.setTipoAtividade(TipoAtividade.P);
						} else {
							atv.setTipoAtividade(TipoAtividade.S);
						}
						atv.setDataInicioAtividade(ce.getDataAbertura());
						atv.setDataFimAtividade(null);
						entAtv.add(atv);
					}
					ce.setEntradasAtividades(entAtv);
				}
				
				//PROFISSOES
				if(bae != null && bae.getPsibae() != null){
					List<EntradaProfissaoGravaCadastroEconomico> entProf = new ArrayList<EntradaProfissaoGravaCadastroEconomico>();
					EntradaProfissaoGravaCadastroEconomico prof = new EntradaProfissaoGravaCadastroEconomico();
					prof.setDataInicioProfissao(ce.getDataColacaoGrau());
					prof.setDataRegistro(bae.getPdtbae());
					prof.setNumeroRegistro(bae.getPnrbae());
					prof.setSindicatoConselho(bae.getPsibae());
					prof.setTipoProfissao(TipoProfissao.P);
					prof.setUfRegistro(bae.getPufbae());
					ce.setEntradasProfissoes(entProf);	
				}
				
				//SOCIOS
				List<EntradaSocioAdmGravaCadastroEconomico> entSoc = new ArrayList<EntradaSocioAdmGravaCadastroEconomico>();
				Boolean jaTemResp = false;
				BigDecimal somaPercentual = new BigDecimal("0.0");
				BigDecimal maiorPercentual = new BigDecimal("0.0");
				for(SadVO sad : listSad){
					SocVO socio = new SocDAO().getRegByCod(sad.getSocsad());
					AdmVO administrador = new AdmDAO().getRegByCod(sad.getAdmsad());
					EdrVO endSocio = new EdrDAO().getRegByCod(sad.getEndsad());
					List<RepVO> representantes = new RepDAO().getRegBySad(sad.getIddsad());
					EntradaSocioAdmGravaCadastroEconomico soc = new EntradaSocioAdmGravaCadastroEconomico();
					if(sad.getCpfsad() != null && sad.getCpfsad().length() == 11){
						soc.setTipoSocio(TipoSocio.PF);
					} else {
						soc.setTipoSocio(TipoSocio.PJ);
					}
					
					if(sad.getQsisad() != null && (!sad.getQsisad().isEmpty())){
						//PQ nesse caso do bae a qualificacao j� vem pronta com o codigo do siat (nao precisa de -> para)
						soc.setQualificacaoSocio(Long.parseLong(sad.getQsisad()));
					}
					
					if(ce.getNaturezaJuridica().equals("2135")){ //Altera��o George 19/01/2017 socio == null &&  -> era um 2135 e veio socio adm
						//S� TEM 1 (EMPRES�RIO)
						soc.setQualificacaoSocio(50L); //EMPRESARIO
						soc.setDataEntradaSocio(ce.getDataAbertura());
						soc.setDataSaidaSocio(null);
						soc.setPercentualParticipacao(new BigDecimal("100.00"));
						somaPercentual = new BigDecimal("100.0");
						soc.setValorParticipacao(ce.getCapitalSocial()); //TOTAL
					} else if(ce.getNaturezaJuridica().equals("2305")){
						//EIRELI
						if(sad.getQsisad() != null && (!sad.getQsisad().isEmpty())){
							//j� veio do bae
							soc.setQualificacaoSocio(Long.parseLong(sad.getQsisad())); //SOCIO-ADMINISTRADOR
							soc.setDataEntradaSocio(ce.getDataAbertura());
							soc.setDataSaidaSocio(null);
							if(soc.getQualificacaoSocio() == 5L){
								//se administrador
								soc.setPercentualParticipacao(new BigDecimal("0.00"));
								somaPercentual = new BigDecimal("0.00");
								soc.setValorParticipacao(new BigDecimal("0.00")); //TOTAL
							} else {
								soc.setPercentualParticipacao(new BigDecimal("100.00"));
								somaPercentual = new BigDecimal("100.0");
								soc.setValorParticipacao(ce.getCapitalSocial()); //TOTAL
							}
						} else {
							if(socio != null && socio.getConsoc() != null && administrador != null && administrador.getConadm() == 205L && listSad.size() == 1){
								//S� TEM 1 (EIRELI)
								soc.setQualificacaoSocio(49L); //SOCIO-ADMINISTRADOR
								soc.setDataEntradaSocio(ce.getDataAbertura());
								soc.setDataSaidaSocio(null);
								soc.setPercentualParticipacao(new BigDecimal("100.00"));
								somaPercentual = new BigDecimal("100.0");
								soc.setValorParticipacao(ce.getCapitalSocial()); //TOTAL
							} else if((socio != null && administrador == null) || (socio != null && administrador != null && listSad.size() > 1)){
								//Para esses dois outros IFs � qnd � separado o Empres�rio do administrador, esse � o empresario
								soc.setQualificacaoSocio(50L); //EMPRESARIO
								soc.setDataEntradaSocio(ce.getDataAbertura());
								soc.setDataSaidaSocio(null);
								soc.setPercentualParticipacao(new BigDecimal("100.00"));
								somaPercentual = new BigDecimal("100.0");
								soc.setValorParticipacao(ce.getCapitalSocial()); //TOTAL
							} else if(socio == null && administrador != null){
								//esse � o administrador
								soc.setQualificacaoSocio(5L); //ADMINISTRADOR
								soc.setDataEntradaSocio(ce.getDataAbertura());
								soc.setDataSaidaSocio(null);
								soc.setPercentualParticipacao(new BigDecimal("0.00"));
								somaPercentual = new BigDecimal("0.00");
								soc.setValorParticipacao(new BigDecimal("0.00")); //TOTAL
							}
						}
					} else {
						String qlf;
						if(sad.getQsisad() != null && (!sad.getQsisad().isEmpty())){
							//j� veio no bae
							qlf = sad.getQsisad();
						} else {
							if(socio == null && administrador != null && administrador.getConadm() == 205L){
								qlf = "5"; //Administrador
							} else if(socio == null && administrador != null && administrador.getConadm() == 204L){
								qlf = "8"; //CONSELHEIRO DE ADMINISTRACAO
							} else if (socio == null && (ce.getNaturezaJuridica().equals("2054") || ce.getNaturezaJuridica().equals("2143")) && administrador != null && (administrador.getConadm() == 203L || (administrador.getCaradm() != null && administrador.getCaradm().equals("DIRETOR")))){
								//SOCIEDADE Anonima OU COOPERATIVA e CONADM = 203 
								qlf = "10"; //Diretor
							} else if (socio == null && (ce.getNaturezaJuridica().equals("2143")) && administrador != null && administrador.getCaradm()!=null){
								if (administrador.getCaradm().equals("PRESIDENTE")) {
									qlf = "16"; //Presidente
								} else {
									qlf = "10"; //Diretor
								}
							} else {
								HashMap<String, Object> param = new HashMap<String ,Object>();
								param.put("njr", ce.getNaturezaJuridica());
								param.put("condi", Integer.parseInt(socio.getConsoc().toString()));
								qlf = new EpdDAO().getQlfByNjrCondi(param);
								if(qlf.equals("22") && representantes != null && representantes.size() > 0){
									//SE "S�cio" verifica se � menor, se sim seta "30 - S�cio ou Acionista Menor (Assistido/Representado)"
									if(sad.getDnasad() != null && FormatUtils.getIdade(sad.getDnasad()) < 18){
										qlf = "30";
									}
									//SE "S�cio" e profiss�o = "ABSOLUTAMENTE INCAPAZ" 
									if(sad.getDnasad() != null && sad.getProsad().equals("ABSOLUTAMENTE INCAPAZ")){
										qlf = "29"; //"S�CIO OU ACIONISTA INCAPAZ OU RELATIVAMENTE INCAPAZ"
									}
								} 
							}
						}
						soc.setQualificacaoSocio(Long.parseLong(qlf));
						soc.setDataEntradaSocio(ce.getDataAbertura());
						soc.setDataSaidaSocio(socio!=null&&socio.getDfisoc()!=null?socio.getDfisoc():null);
						//CALCULAR
						if(socio != null){
							BigDecimal valorParticipacao;
							valorParticipacao = socio.getParsoc()!=null?new BigDecimal(socio.getParsoc()).divide(new BigDecimal(100)):null;
														
							BigDecimal percentual = socio.getParsoc()!=null?valorParticipacao.multiply(new BigDecimal("100")).divide(capitalSocial,MathContext.DECIMAL128).setScale(5, RoundingMode.DOWN):null;
							if(percentual.compareTo(maiorPercentual) > 0){
								maiorPercentual = percentual;
							}
							if(valorParticipacao.compareTo(new BigDecimal("0")) > 0 && percentual.compareTo(new BigDecimal("0")) == 0){
								percentual = percentual.add(new BigDecimal("0.00001"));
							}
							soc.setPercentualParticipacao(percentual);
							somaPercentual = somaPercentual.add(percentual);
							soc.setValorParticipacao(valorParticipacao);
						} 
					}
					NjqVO njq = new NjqVO();
					njq.setNjrnjq(ce.getNaturezaJuridica());
					njq.setQlfnjq(soc.getQualificacaoSocio().toString());
					njq = new NjqDAO().getRegByNjrQlf(njq);
					
					if(sad.getSocsad()!= null && sad.getAdmsad()!= null && (!jaTemResp)){
						//Socio-adm
						if(epd!=null && !ce.getNaturezaJuridica().equals("2305") && !ce.getNaturezaJuridica().equals("2135")){
							soc.setQualificacaoSocio(49L);
						}
						soc.setResponsavelLegal(Boleano.S);
						soc.setDataInicioResponsavelLegal(ce.getDataAbertura());
						jaTemResp = true;
					} else if(njq != null && njq.getRlenjq() != null && njq.getRlenjq().equals("S") && (!jaTemResp)){
						soc.setResponsavelLegal(Boleano.S);
						soc.setDataInicioResponsavelLegal(ce.getDataAbertura());
						jaTemResp = true;
					} else {
						soc.setResponsavelLegal(Boleano.N);
						soc.setDataInicioResponsavelLegal(null);
					}
					
					soc.setDataFimResponsavelLegal(null);
					RepVO representante = null;
					if(representantes != null && representantes.size() > 0){
						representante = representantes.get(0); //S� EST� COLOCANDO 1 rep (SIAT NAO PERMITE MAIS DE 1)
					}
					
					//Se 2062 e S�cio administrador (49) nao permite representante - alguns vem com "Procurador"
					if(representante != null && representante.getIddrep() != null && !((ce.getNaturezaJuridica().equals("2062") && soc.getQualificacaoSocio() == 49L) || (ce.getNaturezaJuridica().equals("2305") && soc.getQualificacaoSocio() == 49L))){
						soc.setPossuiRepresentanteLegal(Boleano.S);
						String qlf;
						if(representante.getQsirep() != null){
							qlf = representante.getQsirep();
						} else {
							qlf = new NjqDAO().getQlfByCon(representante.getTrlrep().toString());
							if(soc.getQualificacaoSocio() == 22L && qlf.equals("43")){
								//S�cio PJ e representante "Respons�vel", representante deve ser "Administrador"
								qlf = "5";
							} else if (ce.getNaturezaJuridica().equals("2062") && soc.getQualificacaoSocio() == 22L && qlf.equals("17")){
								//Se 2062 e sad = s�cio e representante "Procurador", representante deve ser "Administrador"
								qlf = "5";
							} 
						}
						soc.setQualificacaoRepresentanteLegal(Long.parseLong(qlf)); //PROVAVELMENTE TER� DE FAZER O DE/PARA SIAT
						soc.setDataInicioRepresentanteLegal(ce.getDataAbertura());
						soc.setDataFimRepresentanteLegal(representante.getDfirep()!=null?representante.getDfirep().compareTo(new Date())<0?null:representante.getDfirep():null);
						
						EntradaPessoaGravaCadastroEconomico pesRep = new EntradaPessoaGravaCadastroEconomico();
						pesRep.setCpfCnpj(representante.getCpfrep());
						pesRep.setNomeRazaoSocial(representante.getNomrep());
						pesRep.setNomeRazaoSocialResumido(representante.getCpfrep().length() > 150? representante.getCpfrep().substring(0,150):representante.getCpfrep());
						pesRep.setTipoEnderecoEntregaPessoa(TipoEnderecoEntregaPessoa.R);
						pesRep.setTipoDocumento(TipoDocumento.RG);
						pesRep.setNumeroDocumento(representante.getIderep());
						pesRep.setOrgaoExpedidor(representante.getOemrep());
						pesRep.setUfOrgaoExpedidor(representante.getUforep());
						pesRep.setDataExpedicao(null);
						pesRep.setDataNascimento(representante.getDnarep());
						
						if(representante.getNacrep() == 105L){
							pesRep.setPaisNaturalidade("Brasil");
						} else {
							pesRep.setPaisNaturalidade(new TabDAO().getPaisByCodigo(representante.getNacrep().toString())); 
						}
						
						if(representante.getEstrep() == 1){
							pesRep.setEstadoCivil("1"); 
						} else if(representante.getEstrep() == 2){
							pesRep.setEstadoCivil("2"); 
						} else if(representante.getEstrep() == 3){
							pesRep.setEstadoCivil("5"); 
						} else if(representante.getEstrep() == 4){
							pesRep.setEstadoCivil("3"); 
						} else if(representante.getEstrep() == 5){
							pesRep.setEstadoCivil("4"); 
						}
						if(representante.getSexrep() != null && representante.getSexrep().equals("M")){
							pesRep.setSexo(Sexo.M);
						} else if(representante.getSexrep() != null && representante.getSexrep().equals("F")){
							pesRep.setSexo(Sexo.F);
						}
						
						//ENDERECO REPRESENTANTE
						EdrVO endRep = new EdrDAO().getRegByCod(representante.getEndrep());
						end = new EntradaEnderecoPessoaGravaCadastroEconomico();
						end.setTipoEndereco(TipoEnderecoCobrancaPessoa.C);
						if(endRep.getEexedr() != null){
							end.setTipoLocalizacao(TipoLocalizacao.INT);
						} else {
							end.setTipoLocalizacao(TipoLocalizacao.MUNURB);
						}
						if(endRep.getPaiedr() == 105L){
							end.setPais("Brasil");
						} else {
							end.setPais(new TabDAO().getPaisByCodigo(endRep.getPaiedr().toString()));
							end.setEnderecoReferencia(endRep.getEexedr()!=null?endRep.getEexedr():null);
						}
						end.setTipoLogradouro(endRep.getTloedr());
						end.setLogradouro((endRep.getNloedr()!= null?endRep.getNloedr():"") + (endRep.getEexedr() != null?" / " + endRep.getEexedr():""));
						end.setNumero(FormatUtils.getNumeroLogradouro(endRep.getNumedr()));
						if(end.getNumero()==0 && (endRep.getComedr() == null || (endRep.getComedr() != null && endRep.getComedr().isEmpty()))){
							end.setComplemento(endRep.getNumedr());
						} else {
							end.setComplemento(endRep.getComedr());
						}
						end.setTipoBairro("BAIRRO");
						end.setBairro(endRep.getBaiedr());
						end.setDistrito("");
						end.setCidade(endRep.getMunedr());
						end.setUf(endRep.getUffedr());
						end.setCep(endRep.getCepedr());
						end.setEnderecoReferencia("");
						end.setZipCode(endRep.getCepedr());
						end.setInscricaoImobiliaria("");
						end.setPovoado("");
						end.setZonaRural("");
						end.setCcir("");
						end.setNirf("");
						end.setDatum(null);
						end.setLatitude("");
						end.setLongitude("");
						end.setDddTelefone("");
						end.setTelefone("");
						end.setDddFax("");
						end.setFax("");
						end.setEmail("");
						
						listEnd = new ArrayList<EntradaEnderecoPessoaGravaCadastroEconomico>();
						listEnd.add(end);
						pesRep.setEntradaEnderecosPessoa(listEnd);
						
						soc.setEntradaPessoaRepresentante(pesRep);
					} else {
						soc.setPossuiRepresentanteLegal(Boleano.N);
						soc.setQualificacaoRepresentanteLegal(null);
						soc.setDataInicioRepresentanteLegal(null);
						soc.setDataFimRepresentanteLegal(null);
					}
					
					EntradaPessoaGravaCadastroEconomico pesSoc = new EntradaPessoaGravaCadastroEconomico();
					if(soc.getTipoSocio() == TipoSocio.PF){
						pesSoc.setCpfCnpj(sad.getCpfsad());
					} else {
						pesSoc.setCpfCnpj(sad.getCnpsad());
					}
					pesSoc.setNomeRazaoSocial(sad.getNomsad());
					pesSoc.setNomeRazaoSocialResumido(sad.getNomsad().length() > 150? sad.getNomsad().substring(0,150):sad.getNomsad());
					pesSoc.setTipoEnderecoEntregaPessoa(TipoEnderecoEntregaPessoa.R);
					pesSoc.setTipoDocumento(TipoDocumento.RG);
					pesSoc.setNumeroDocumento(sad.getIdesad()!=null?sad.getIdesad().length()>15?sad.getIdesad().replaceAll(" ", ""):sad.getIdesad():null);
					pesSoc.setOrgaoExpedidor(sad.getOemsad());
					pesSoc.setUfOrgaoExpedidor(sad.getUfosad());
					pesSoc.setDataExpedicao(null);
					pesSoc.setDataNascimento(sad.getDnasad());
					
					if(sad.getNacsad() == 105L){
						pesSoc.setPaisNaturalidade("Brasil");
					} else {
						pesSoc.setPaisNaturalidade(new TabDAO().getPaisByCodigo(sad.getNacsad().toString()));
					}
					
					if(sad.getEstsad() != null){
						if(sad.getEstsad() == 1){
							pesSoc.setEstadoCivil("1"); 
						} else if(sad.getEstsad() == 2){
							pesSoc.setEstadoCivil("2"); 
						} else if(sad.getEstsad() == 3){
							pesSoc.setEstadoCivil("5"); 
						} else if(sad.getEstsad() == 4){
							pesSoc.setEstadoCivil("3"); 
						} else if(sad.getEstsad() == 5){
							pesSoc.setEstadoCivil("4"); 
						}
					}
					if(sad.getSexsad() != null && sad.getSexsad().equals("M")){
						pesSoc.setSexo(Sexo.M);
					} else if(sad.getSexsad() != null && sad.getSexsad().equals("F")){
						pesSoc.setSexo(Sexo.F);
					}
					end = new EntradaEnderecoPessoaGravaCadastroEconomico();
					end.setTipoEndereco(TipoEnderecoCobrancaPessoa.C);
					if(endSocio.getEexedr() != null){
						end.setTipoLocalizacao(TipoLocalizacao.INT);
					} else {
						end.setTipoLocalizacao(TipoLocalizacao.MUNURB);
					}
					if((endSocio.getPaiedr() != null && endSocio.getPaiedr() == 105L) || sad.getNacsad() == 105L){
						end.setPais("Brasil");
					} else {
						end.setPais(new TabDAO().getPaisByCodigo(endSocio.getPaiedr().toString()));
						end.setEnderecoReferencia(endSocio.getEexedr()!=null?endSocio.getEexedr():null);
					}
					
					end.setTipoLogradouro(endSocio.getTloedr());
					end.setLogradouro((endSocio.getNloedr()!= null?endSocio.getNloedr():"") + (endSocio.getEexedr() != null?" / " + endSocio.getEexedr():""));
					end.setNumero(FormatUtils.getNumeroLogradouro(endSocio.getNumedr()));
					if(end.getNumero()==0 && (endSocio.getComedr() == null || (endSocio.getComedr() != null && endSocio.getComedr().isEmpty()))){
						end.setComplemento(endSocio.getNumedr());
					} else {
						end.setComplemento(endSocio.getComedr());
					}
					end.setTipoBairro("BAIRRO");
					end.setBairro(endSocio.getBaiedr());
					end.setDistrito("");
					end.setCidade(endSocio.getMunedr());
					end.setUf(endSocio.getUffedr());
					end.setCep(endSocio.getCepedr());
					end.setEnderecoReferencia("");
					end.setZipCode(endSocio.getCepedr());
					end.setInscricaoImobiliaria("");
					end.setPovoado("");
					end.setZonaRural("");
					end.setCcir("");
					end.setNirf("");
					end.setDatum(null);
					end.setLatitude("");
					end.setLongitude("");
					end.setDddTelefone("");
					end.setTelefone("");
					end.setDddFax("");
					end.setFax("");
					end.setEmail("");
					
					listEnd = new ArrayList<EntradaEnderecoPessoaGravaCadastroEconomico>();
					listEnd.add(end);
					pesSoc.setEntradaEnderecosPessoa(listEnd);
					soc.setEntradaPessoaSocio(pesSoc);
					entSoc.add(soc);
				}
				if(somaPercentual.doubleValue() > 0){ //caso de soc. anonima por exemplo nao tem participacao
					BigDecimal diferencaPercentual = new BigDecimal("100.00").subtract(somaPercentual);
					if(diferencaPercentual.doubleValue() > 0){
						//Somar a diferenca no s�cio de maior participacao
						for(EntradaSocioAdmGravaCadastroEconomico socMaior : entSoc){
							if(socMaior.getPercentualParticipacao().equals(maiorPercentual)){
								socMaior.setPercentualParticipacao(socMaior.getPercentualParticipacao().add(diferencaPercentual));
								break;
							}
						}
					}
				}
			ce.setEntradasSocios(entSoc);
					
			String xml = new EntradaGravaCadastroEconomico().toXml(ce);
			xml = xml.replaceAll("<EntradaGravaCadastroEconomico>", "<Entrada><EntradaGravaCadastroEconomico>");
			xml = xml.replaceAll("</EntradaGravaCadastroEconomico>", "</EntradaGravaCadastroEconomico></Entrada>");
			System.out.println(xml);
			
			GravaCadEconManager gravaManager = new GravaCadEconManager();
			resp = gravaManager.chamaWebService(xml);
		}
		
		System.out.println("resposta: " + resp.get("resposta").toString());
		System.out.println("mensagem: " + resp.get("mensagem").toString());
		System.out.println("inscricaoMunicipal: " + resp.get("inscricaoMunicipal").toString());
		return resp;
	}

	public static void confirmaInscricaoMunicipal(EpdVO epd) {
		try {
			CaiVO cai = new CaiDAO().getRegByCod(epd.getCaiepd());
			String resposta;
			if(cai.getSitcai().equals("P")){
				resposta = ClienteEmpreendimento.confirmaParcialInscricao(epd.getNprepd(), cai.getImucai());
			} else {
				resposta = ClienteEmpreendimento.confirmaDeferimento(epd.getNprepd(), "Acesse portal PMCG Alvara", cai.getImucai());
			}
			String tipoRetorno = resposta.replaceAll("TipoRetorno", "tipoRetorno").replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
			if(tipoRetorno.equals("SUCESSO")){
				new EpdDAO().updAtendidoByProcesso(epd.getNprepd());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
