package pmcg.imti.view.ext;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.dao.ibatis.CpeDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.LmaDAO;
import pmcg.fcn.dao.ibatis.LvsDAO;
import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.domain.AnxVO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.LmaVO;
import pmcg.fcn.domain.LvsVO;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.ArqanxDAO;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.dao.ibatis.GlvDAO;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.dao.ibatis.LicDAO;
import pmcg.imti.dao.ibatis.UsuDAO;
import pmcg.imti.domain.ArqanxVO;
import pmcg.imti.domain.GlvVO;
import pmcg.imti.domain.LicVO;
import pmcg.imti.domain.UsuVO;
import pmcg.imti.manager.GuiaDamTDManager;
import pmcg.imti.manager.PagGuiaDamManager;
import pmcg.imti.ui.Upload;
import pmcg.imti.util.FormatUtils;

public class Licenciamento extends Index {

	private static final long serialVersionUID = 1L;
	
	public String processo = "";
	public String insmun = "";
	public HashMap<String, Object> dados;
	public List<AnxVO> listAnx; //lista de anexos da viabilidade
	public Upload up; //Arquivo a ser anexado na lista
	public String descricaoArquivo = "";
	public List<GlvVO> listGlv; //lista de guias emitidas
	public Boolean guiaVSPaga = false;
	
	public void initLic() throws SQLException, InterruptedException{
//		processo = "MS2201600125408";
//		insmun = "0022499000-6";
//		pesquisar();
		
		this.vincular();
	}
	
	public void pesquisar() throws InterruptedException{
		if(processo == null || processo.isEmpty()){
			throw new WrongValueException(getComponente("processo"),"Informe o Número do Processo!");
		} 
		if(insmun == null || insmun.isEmpty()){
			throw new WrongValueException(getComponente("insmun"),"Informe a Inscrição Municipal!");
		} 
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("nprepd", processo); 
		param.put("imucai", FormatUtils.onlyNumbers(insmun));
		dados = new EpdDAO().getDadosInsmun(param);
		if(dados == null){
			Messagebox.show("Processo não encontrado!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
		} else {
			//listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) dados.get("iddvia"), "V"));
			listGlv = new GlvDAO().getGuiasByEpd(Long.parseLong(dados.get("iddepd").toString()));
			//VERIFICANDO PAGAMENTO DE GUIAS
			Boolean wsfora = false;
			PagGuiaDamManager pagGuiaManager = new PagGuiaDamManager();
			for(GlvVO guia : listGlv){
				HashMap<String, String> resp = pagGuiaManager.chamaWebService(guia.getGuiglv().toString());
				if (resp == null || (resp.get("resposta") != null && resp.get("resposta").length() >= 3 && resp.get("resposta").substring(0, 3).equalsIgnoreCase("Exc"))) {
					//Exceção lançada
					wsfora = true;
				} else if(resp != null && resp.get("resposta") != null && resp.get("resposta").equals("0")){
					guiaVSPaga = true;
					break;
				} 
				guiaVSPaga = false;
				if(wsfora){
					try {
						Messagebox.show("WebService ocupado! Tente novamente mais tarde.","Nota Fiscal Avulsa",Messagebox.OK,Messagebox.ERROR);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		vincular();
	}
	
	public void upload(Event evt) throws IOException, InterruptedException, SQLException {
		// cria uma lista de tipos de extensões aceitas
		List<String> tiposValidos = new ArrayList<String>();
		tiposValidos.add(".jpg");
		tiposValidos.add(".jpeg");
		tiposValidos.add(".png");
		tiposValidos.add(".bmp");
		tiposValidos.add(".doc");
		tiposValidos.add(".docx");
		tiposValidos.add(".xls");
		tiposValidos.add(".xlsx");
		tiposValidos.add(".pps");
		tiposValidos.add(".odt");
		tiposValidos.add(".ods");
		tiposValidos.add(".pdf");
		tiposValidos.add(".zip");
		tiposValidos.add(".rar");
		tiposValidos.add(".txt");
		tiposValidos.add(".TXT");
		tiposValidos.add(".xps");
		up = new Upload(evt, tiposValidos);
		up.getMsgErro(this.getComponente("upload"));
		this.vincular();
	}
	
	public Boolean isRiscoBaixoMA(){
		if(dados != null && dados.get("risamb") != null && dados.get("risamb").toString().equalsIgnoreCase("BAIXO")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isNaoRiscoBaixoMA(){
		return !isRiscoBaixoMA();
	}
	
	public Boolean isRiscoBaixoVS(){
		if(dados != null && dados.get("risvig") != null && dados.get("risvig").toString().equalsIgnoreCase("BAIXO")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isNaoRiscoBaixoVS(){
		return !isRiscoBaixoVS();
	}
	
	public void anexar() throws InterruptedException{
//		if(!(Boolean) via.get("permitidoanexar")){
//			throw new WrongValueException(getComponente("sitaen"),"Não é possível anexar pois a viabilidade já foi analisada!");
//		} 
//		if(up != null && up.getAnxVO() != null){
//			if(listAnx != null && listAnx.size() >= 10){
//				throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar, limite máximo de 10 arquivos!");
//			} else {
//				if(descricaoArquivo == null || descricaoArquivo.isEmpty()){
//					throw new WrongValueException(getComponente("desarq"),"Informe a Descrição do Arquivo!");
//				} else {
//					AnxVO anxVO = up.getAnxVO();
//					anxVO.setDesanx(descricaoArquivo);
////					anxVO.setUsualt(cpfReq);
//					
//					try {
//						// inclui o arqanx
//						ArqanxVO arqanx = anxVO.getArqanxVO();
//						Long seqarq = (Long) new ArqanxDAO().insReg(arqanx);
//						arqanx.setSeqarq(seqarq);
//						// inclui o anx
//						anxVO.setArqanx(seqarq);
//						anxVO.setDocanx((Long) via.get("iddvia"));
//						anxVO.setTpdanx("V");
//						Long codigoanx = (Long) new AnxDAO().insReg(anxVO);
//						anxVO.setIddanx(codigoanx);
//					} catch (Exception e) {
//						System.out.println(e.getMessage());
//						throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar o arquivo!");
//					}
//					listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) via.get("iddvia"), "V"));
//					up = null;
//					descricaoArquivo = "";
//					this.vincular();
//				}
//			}
//		} else {
//			throw new WrongValueException(getComponente("selArq"),"Carregue um Arquivo!");
//		}
	}
	
	public void cancelarAnexo(){
		up = null;
		descricaoArquivo = "";
		this.vincular();
	}
	
	public void download(AnxVO anexo) throws InterruptedException {
		ArqanxVO arqanxVO = null;
		if (anexo.getArqanx() != null) {
			Long seqarq = anexo.getArqanx();
			arqanxVO = new ArqanxDAO().getRegByCodComplex(seqarq);
			anexo.setArqanxVO(arqanxVO);
		} else {
			arqanxVO = anexo.getArqanxVO();
		}
		// Busca arquivo no DBIMGFCN
		if (arqanxVO == null) {
			Messagebox.show("Arquivo não encontrado.");
		} else {
			Filedownload.save((byte[]) arqanxVO.getAnxarq(), anexo.getArqanxVO().getTiparq(), anexo.getNomanx());
		}
	}
	
	public Boolean isDadosEncontrados(){
		if(dados != null && dados.get("insmun") != null){
			return true;
		} else {
			return false;
		}
	}
	
	public void imprimirLicenca(Integer opcao) throws InterruptedException, NumberFormatException, SQLException{
		if(opcao == 1){
			//Meio Ambiente
			if(isRiscoBaixoMA()){
				if(dados.get("lmaepd") != null){
					//LICENÇA JÁ EXISTE, EXTÃO SÓ IMPRIME
					HashMap<String, String> param = new HashMap<String, String>();
					param.put("iddlma", dados.get("lmaepd").toString());
					new WinUtils().abrirBirt(120, "/cimweb", "3.7", "apl04.pmcg.ms.gov.br:8080", "PDF", "LICENCA", "dispensa_amb.rptdesign", param);
				} else {
					//GERA LICENÇA E IMPRIME
					try {
						HashMap<String, Object> matriz = new MatDAO().getMatrizByProcesso(Long.parseLong(dados.get("iddpro").toString()));
						if(dados.get("ambaen").toString().equalsIgnoreCase("B")){
							LmaVO lma = new LmaVO();
							lma.setEsplma("DISPENSA");
							lma.setProlma(dados.get("nprepd").toString());
							lma.setEmilma(new Date());
							lma.setVallma(null);
							lma.setReqlma(matriz.get("nommat").toString());
							lma.setCpflma(dados.get("cpfcnpj").toString());
							lma.setAtvlma(matriz.get("desmat").toString());
							lma.setEdrlma(matriz.get("endmat").toString());
							String iptu = new EpdDAO().getInscricaoByProcesso(dados.get("nprepd").toString());
							lma.setReglma(new ImoDAO().getRegiaoImovel(iptu));
							lma.setAnolma(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())));
							UsuVO gestor = new UsuDAO().getRegByCod(Long.parseLong(new CfgDAO().getValorByParam("CODUSU_RESP_LIC_MA")));
							lma.setAsslma(gestor.getNomusu());
							String haveramusica = new CpeDAO().getMusicaByIddepd(Long.parseLong(dados.get("iddepd").toString()));
							lma.setMuslma(haveramusica.equalsIgnoreCase("S")?false:true); //SE HAVERÁ MÚSICA, MUSLMA = FALSE PQ NÃO IRÁ APARECER A MSG "NÃO AUTORIZADO MÚSICA"...
							lma.setUsualt("CIMWEB");
							lma.setSitlma("A");
							Long iddlma = (Long) new LmaDAO().insReg(lma);
							if(iddlma != null && iddlma > 0){
								EpdVO epd = new EpdVO();
								epd.setLmaepd(iddlma);
								epd.setIddepd(Long.parseLong(dados.get("iddepd").toString()));
								new EpdDAO().updLicencaAmb(epd);
								
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
							dados.put("lmaepd", iddlma);
							vincular();
							
							//imprime
							HashMap<String, String> param = new HashMap<String, String>();
							param.put("iddlma", dados.get("lmaepd").toString());
							new WinUtils().abrirBirt(120, "/cimweb", "3.7", "apl04.pmcg.ms.gov.br:8080", "PDF", "LICENCA", "dispensa_amb.rptdesign", param);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						Messagebox.show("Não foi possível gerar a Licença.");
					}
				}
			}
		} else {
			if(guiaVSPaga){
				if(dados.get("lmaepd") != null){
					//LICENÇA JÁ EXISTE, EXTÃO SÓ IMPRIME
					LvsVO lvs = new LvsDAO().getRegByCod(Long.parseLong(dados.get("lvsepd").toString()));
					HashMap<String, String> param = new HashMap<String, String>();
					param.put("codlic", lvs.getLiclvs().toString());
					param.put("codves", lvs.getVeslvs().toString());
					new WinUtils().abrirBirt(77, "/sosweb", "3.7", "aplbirt.pmcg.ms.gov.br:8080", "PDF", "LICENCA", "soslicsimplificadarel.rptdesign", param);
				} else {
					//GERA LICENÇA E IMPRIME
					LicVO licVO = new LicVO();
					licVO.setCodves(Integer.parseInt(dados.get("vesepd").toString()));
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.YEAR, 1);
					licVO.setDatvallic(cal.getTime());
					//if (numeroProcesso.startsWith("CGR")) {
					//	licVO.setProlic(bae.getViabae());
					//} else {
						licVO.setProlic(dados.get("nprepd").toString());
					//}
					licVO.setSttlic("A");
					licVO.setUsualt("CIMWEB");
					licVO.setCodtpd(3);
					licVO.setTiplic("S"); // SIMPLIFICADA

					Integer codlic = (Integer) new LicDAO().insReg(licVO);
					
					LvsVO lvs = new LvsVO();
					lvs.setEpdlvs(Long.parseLong(this.dados.get("iddepd").toString()));
					lvs.setVeslvs(Integer.parseInt(dados.get("vesepd").toString()));
					lvs.setLiclvs(codlic);
					lvs.setUsualt("CIMWEB");
					Long iddlvs = (Long) new LvsDAO().insReg(lvs);
					
					EpdVO epdp = new EpdVO();
					epdp.setIddepd(lvs.getEpdlvs());
					epdp.setLvsepd(iddlvs);
					new EpdDAO().updLicencaVig(epdp);
					
					//INSERE A LICENCA NO SIAT
					HashMap<String, Object> paramS = new HashMap<String, Object>();
					paramS.put("insmun", FormatUtils.onlyNumbers(dados.get("insmun").toString()));
					paramS.put("codlic", 6);
					Integer qtdlic = new EcoDAO().verificaEcolic(paramS);
					if(qtdlic != null && qtdlic <= 0){
						LvsVO licenca = new LvsDAO().getRegByCod(iddlvs);
						paramS.put("numlic", licenca.getLiclvs().toString() + "/" + new SimpleDateFormat("yyyy").format(licenca.getDatalt()));
						try {
							new EcoDAO().getSqlMap().startTransaction();
							new EcoDAO().insEcolic(paramS);
							new EcoDAO().insEcolichis(paramS);
							new EcoDAO().getSqlMap().commitTransaction();
						} finally {
							new EcoDAO().getSqlMap().endTransaction();
						}
					}
					//imprime
					HashMap<String, String> param = new HashMap<String, String>();
					param.put("codlic", codlic.toString());
					param.put("codves", dados.get("vesepd").toString());
					new WinUtils().abrirBirt(77, "/sosweb", "3.7", "aplbirt.pmcg.ms.gov.br:8080", "PDF", "LICENCA", "soslicsimplificadarel.rptdesign", param);
				}
				
			}
		}
	}
	
	public void emitirGuia(){
		if(isPermEmitirGuia()){
			try {
				new GlvDAO().getSqlMap().startTransaction();
				GuiaDamTDManager guiaManager = new GuiaDamTDManager();
				//RESPOSTA:
				// "codigoGuia" -> código da guia gerada
				// "enderecoArquivo" -> endereço do arquivo .pdf gerado
				// "resposta" -> 0 = sucesso / 1 = falha
				// "mensagem" -> mensagem de sucesso ou falha
				HashMap<String, Object> dadosGuia = new HashMap<String, Object>();
				dadosGuia.put("insmun", FormatUtils.onlyNumbers(dados.get("insmun").toString()));
				Double valorGuia = new EcoDAO().getValorTaxaDiversa("0776"); //É 0776 mesmo (e não 0796), pq é a original, a 0796 foi criada somente para gerar a guia através do WS
				dadosGuia.put("valor", valorGuia);
				dadosGuia.put("observacao", "Referente à Taxa de Vistoria Urbana (Vigilância Sanitária) conforme a Lei n. 1466 de 26/10/73.");
				
				HashMap<String, String> resp = guiaManager.chamaWebService(dadosGuia);
				if (resp == null || (resp.get("resposta") != null && resp.get("resposta").length() >= 3 && resp.get("resposta").substring(0, 3).equalsIgnoreCase("Exc"))) {
					//Exceção lançada
					if(resp.get("mensagem") != null){
						System.out.println("ERRO - WS - mens: " + resp.get("mensagem") + " / resp: " + resp.get("resposta"));
					}
					//grava XML no arquivo de log
					//logger.error(guiaManager.getXML(nft));
					try {
						Messagebox.show("WebService ocupado! Tente novamente mais tarde.","Nota Fiscal Temporária",Messagebox.OK,Messagebox.ERROR);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if(resp.get("resposta") != null && resp.get("resposta").equals("0")){
					GlvVO guia = new GlvVO();
					guia.setGuiglv(Long.parseLong(resp.get("codigoGuia")));
					guia.setProglv(Long.parseLong(dados.get("iddepd").toString()));
					guia.setTipglv("E");
					guia.setUsualt("WEB-CIMWEB");
					Long codInsGuia = (Long) new GlvDAO().insReg(guia);
					if(codInsGuia>0){
						new GlvDAO().getSqlMap().commitTransaction();
						((Button) getComponente("btImpGuia")).setHref(resp.get("enderecoArquivo"));
						((Div) getComponente("divImpressao")).setVisible(true);
						((Label) getComponente("nrguia")).setValue("Guia nº " + guia.getGuiglv().toString() + " gerada com sucesso!");
						((Button) getComponente("btImpGuia")).setFocus(true);
					} else {
						new GlvDAO().getSqlMap().endTransaction();
						((Div) getComponente("divImpressao")).setVisible(false);
						try {
							Messagebox.show("Problema na inserção da Guia! Erro 003");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else if (resp.get("resposta") != null && resp.get("resposta").equals("1")){
					new GlvDAO().getSqlMap().endTransaction();
					if(resp.get("mensagem") != null){
						System.out.println("ERRO - geração guia(INSMUN: " + dados.get("insmun") +"): " + resp.get("mensagem"));
						//Logger.INFO("teste log webservice");
					}
					//grava XML no arquivo de log
					//logger.error(guiaManager.getXML(nft));
					try {
						Messagebox.show("Problema na emissão da Guia! Erro 001");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					new GlvDAO().getSqlMap().endTransaction();
					//grava XML no arquivo de log
					//logger.error(guiaManager.getXML(nft));
					try {
						Messagebox.show("Problema na emissão da Guia! Erro 002");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				try {
					Messagebox.show("Não foi possível inserir o registro!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} finally {
				try {
					new GlvDAO().getSqlMap().endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.vincular();
		}
	}
	
	public Boolean isPermEmitirGuia(){
		return isRiscoBaixoVS() && (!guiaVSPaga);
	}
	
	public Boolean isPermEmitirLicencaVS(){
		return isRiscoBaixoVS() && guiaVSPaga;
	}
}
