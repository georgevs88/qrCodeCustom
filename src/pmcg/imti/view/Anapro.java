package pmcg.imti.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.exporter.excel.ExcelExporter;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.AatDAO;
import pmcg.fcn.dao.ibatis.AenDAO;
import pmcg.fcn.dao.ibatis.AnxDAO;
import pmcg.fcn.dao.ibatis.CclDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.CpeDAO;
import pmcg.fcn.dao.ibatis.ResDAO;
import pmcg.fcn.dao.ibatis.TabDAO;
import pmcg.fcn.dao.ibatis.UsoDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.AatVO;
import pmcg.fcn.domain.AenVO;
import pmcg.fcn.domain.AnaliseEnderecoVO;
import pmcg.fcn.domain.AnxVO;
import pmcg.fcn.domain.CclVO;
import pmcg.fcn.domain.CnaVO;
import pmcg.fcn.domain.CpeVO;
import pmcg.fcn.domain.ResVO;
import pmcg.fcn.domain.RespostaAnaliseEnderecoVO;
import pmcg.fcn.domain.SituacaoAnaliseEndereco;
import pmcg.fcn.domain.TabVO;
import pmcg.fcn.domain.UsoVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.prefeitura.ClienteViabilidade;
import pmcg.fcn.prefeitura.Constantes;
import pmcg.fcn.prefeitura.Util;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.ArqanxDAO;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.domain.ArqanxVO;
import pmcg.imti.ui.Upload;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class Anapro extends WindowCrud{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ClienteViabilidade.class);
	public List<HashMap<String, Object>> listProtAnalise;
	public HashMap<String, Object> protAnaliseSel;
	public HashMap<String, Object> dadosEndereco;
	public HashMap<String, Object> dadosZonaUsos;
	public HashMap<String, Object> dadosImovel;
	public String tipo_imovel;
	public List<TabVO> listMsgJust;
	public TabVO msgJust;
	public List<HashMap<String, Object>> listAtvAnalise;
	public HashMap<String, Object> atvAnaliseSel;
	public List<HashMap<String, Object>> listFormaAt;
	public ResVO respostas; // Questionário nosso, protocolos "CGR"
	public List<CpeVO> colPerguntas; // Questionário da Junta, protocolos "MSP"
	public String paramProt;
	public Date paramData;
	public String paramReq;
	public AenVO aenVO; //Análise de Endereço
	public List<UsoVO> listUsos;
	public String observacoes;
	public String justificativa;
	public String orientacao;
	public Boolean checkEmbasamento = true;
	public String dataAnalise;
	private AnnotateDataBinder binder = new AnnotateDataBinder(this);
	//anexos
	public Upload up; //Arquivo a ser anexado na lista abaixo
	public String descricaoArquivo = "";
	public List<AnxVO> listAnx; //lista de anexos do BAE

	public void initComponentes() throws SQLException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		dataAnalise = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		listMsgJust = new TabDAO().getRegByCriterio(new TabVO("MSG_JUST"));
		try {
			listUsos = new UsoDAO().getTodos(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pesquisar();
	}
	
	@Override
	public void salvar() throws InterruptedException {
		if(protAnaliseSel == null || protAnaliseSel.get("provia") == null){
			throw new WrongValueException(getComponente("listProtAnalise"), "Selecione um protocolo!");
		}
		if(!checkEmbasamento){
			throw new WrongValueException(getComponente("checkEmb"), "Ciência do Embasamento Legal!");
		}
		if(observacoes == null || observacoes.isEmpty()){
			throw new WrongValueException(getComponente("observacoes"), "Informar as observações!");
		}
		if (Messagebox.show("Ao Salvar a Análise de Endereço as informações serão enviadas à JUCEMS e não podererão sofrer alterações. \nTem certeza que deseja Salvar?", "Salvar Análise de Endereço", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			AnaliseEnderecoVO ae = new AnaliseEnderecoVO(); //esta será enviada ao webservice
			Calendar validade = Calendar.getInstance();
			validade.add(Calendar.DATE, + Constantes.Servico.validade_analise_endereco);
			ae.setDataValidadeAnalise(validade.getTime());
			if(aenVO.getSitaen().equalsIgnoreCase("D")){
				ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.DEFERIDA);
			} else {
				ae.setSituacaoAnaliseEndereco(SituacaoAnaliseEndereco.INDEFERIDA);
			}
			observacoes = removeCaracterEspecial(observacoes);
			ae.setObservacao((!observacoes.isEmpty())?observacoes:null);
			justificativa = removeCaracterEspecial(justificativa);
			ae.setJustificativa((!justificativa.isEmpty())?justificativa:null);
			ae.setOrientacao((!orientacao.isEmpty())?orientacao:null);
			//SETA O ARQUIVO PDF
	//		File f = new File("C://Users//George//Desktop//teste.pdf");
	//		FileInputStream fis = null;
	//		try {
	//			fis = new FileInputStream(f);
	//		} catch (FileNotFoundException e2) {
	//			e2.printStackTrace();
	//		}
	//		byte[] bytes = new byte[(int) f.length()];
	//		try {
	//			fis.read(bytes);
	//			fis.close();
	//		} catch (IOException e2) {
	//			e2.printStackTrace();
	//		}
	//		Base64Utility.encode(bytes);
	//		System.out.println(pdfResultado);
	//		ae.setPdfResultado(bytes);
			
			//volta para confirmar
	//		byte[] bytevolta = null;
	//		try {
	//			bytevolta = Base64Utility.decode(pdfResultado);
	//		} catch (Base64Exception e2) {
	//			e2.printStackTrace();
	//		}
	//		FileOutputStream out = null;
	//		try {
	//			out = new FileOutputStream("C://Users//George//Desktop//volta64.pdf");
	//		} catch (FileNotFoundException e1) {
	//			e1.printStackTrace();
	//		}
	//		try {
	//			out.write(bytevolta, 0, bytevolta.length);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		try {
	//			out.close();
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
			HashMap<String, String> resposta = null;
			if(protAnaliseSel.get("provia").toString().startsWith("CGR")){
				resposta = new HashMap<String, String>();
				resposta.put("tipoRetorno", "SUCESSO"); //SIMULA UMA RESPOSTA OK DA JUNTA PARA OS CASOS DE PROTOCOLOS NOSSOS
			} else {
				RespostaAnaliseEnderecoVO resp = new RespostaAnaliseEnderecoVO();
				resp.setProtocoloViabilidade(protAnaliseSel.get("provia").toString());
				resp.setAnaliseEnderecoVO(ae);
				String xmlResposta = RespostaAnaliseEnderecoVO.toXML(resp);
				//System.out.println(xmlResposta);
				try {
					resposta = ClienteViabilidade.confirmaRespostaAnaliseEndereco(xmlResposta);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
			if(resposta != null && ((resposta.get("tipoRetornoVia") != null && resposta.get("tipoRetornoVia").equalsIgnoreCase("SUCESSO")) || 
					(resposta.get("tipoRetorno") != null && resposta.get("tipoRetorno").equalsIgnoreCase("SUCESSO")))){
				try {
					new ViaDAO().getSqlMap().startTransaction();
					//GRAVAR ANALISE NO BANCO
					AenVO aen = new AenVO();                        // esta será gravada no banco
					aen.setValaen(ae.getDataValidadeAnalise());
					aen.setProaen(protAnaliseSel.get("provia").toString());
					aen.setSitaen(ae.getSituacaoAnaliseEndereco().getDescricao());
					aen.setObsaen(ae.getObservacao());
					aen.setJusaen(ae.getJustificativa());
					aen.setOriaen(ae.getOrientacao());
					aen.setUsualt(getLogin());
					aen.setTaxaen(ae.getTaxa());
					aen.setTimaen(aenVO.getTimaen());
					aen.setZonaen(aenVO.getZonaen());
					aen.setUsoaen(aenVO.getUsoaen());
					aen.setRisaen(aenVO.getRisaen());
					aen.setAmbaen(aenVO.getAmbaen());
					aen.setBomaen(aenVO.getBomaen());
					aen.setVigaen(aenVO.getVigaen());
					aen.setPosaen(aenVO.getPosaen());
					aen.setTraaen(aenVO.getTraaen());
					aen.setSiaaen(aenVO.getSiaaen());
					Long iddaen = (Long) new AenDAO().insReg(aen);
					
					//GRAVAR ATIVIDADES DA ANALISE NO BANCO
					for (HashMap<String, Object> atv :listAtvAnalise){
						AatVO aat = new AatVO();
						aat.setAenaat(iddaen);
						aat.setCnaaat(Util.formataCnaeSemMascara(atv.get("cnae").toString()));
						aat.setStaaat(atv.get("staaat")!=null?atv.get("staaat").toString():null);
						aat.setUsoaat(atv.get("novouso")!=null?atv.get("novouso").toString():"");
						aat.setExeaat(atv.get("exeaat") != null?(Boolean) atv.get("exeaat"):null);
						aat.setAmbaat(atv.get("ambaat")!=null?atv.get("ambaat").toString():"");
						aat.setBomaat(atv.get("bomaat")!=null?atv.get("bomaat").toString():"");
						aat.setVigaat(atv.get("vigaat")!=null?atv.get("vigaat").toString():"");
						aat.setPosaat(atv.get("posaat")!=null?atv.get("posaat").toString():"");
						aat.setTraaat(atv.get("traaat")!=null?atv.get("traaat").toString():"");
						aat.setSiaaat(atv.get("siaaat")!=null?atv.get("siaaat").toString():"");
						new AatDAO().insReg(aat);
					}
					// ATUALIZA A VIABILIDADE COM O IDDAEN GERADO
					ViaVO viaupd = new ViaVO();
					viaupd.setIddvia((Long) protAnaliseSel.get("iddvia"));
					viaupd.setProvia(protAnaliseSel.get("provia").toString());
					viaupd.setAenvia(iddaen);
					new ViaDAO().updAnaliseEnderecoByIdd(viaupd);
					
					new ViaDAO().getSqlMap().commitTransaction();
					Messagebox.show("Análise concluída com Sucesso!","Análise de Endereço",Messagebox.OK, Messagebox.EXCLAMATION);
					limpar();
				} catch (SQLException e) {
					logger.error("Erro ao inserir Analise Endereço no BD (" + protAnaliseSel.get("provia").toString() + ").");
					e.printStackTrace();
				} finally {
					try {
						new ViaDAO().getSqlMap().endTransaction();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if(resposta != null && ((resposta.get("tipoRetornoVia") != null && resposta.get("tipoRetornoVia").equalsIgnoreCase("FALHA")) || 
					(resposta.get("tipoRetorno") != null && resposta.get("tipoRetorno").equalsIgnoreCase("FALHA")))){
				if(resposta.get("mensagem").equalsIgnoreCase("viabilidade.exception.ViabilidadeNaoEncontradaException")){
					Messagebox.show("Falha ao Responder Análise de Endereço! Análise não encontrada na base da JUCEMS!","Análise de Endereço",Messagebox.OK, Messagebox.ERROR);
				} else {
					Messagebox.show("Falha ao Responder Análise de Endereço: " + resposta.get("mensagem"),"Análise de Endereço",Messagebox.OK, Messagebox.ERROR);
				}
				logger.error("Falha ao Responder Análise de Endereço (" + protAnaliseSel.get("provia").toString() + "): " + resposta.get("mensagem"));
			}
		}
		vincular();
	}
	
	public void todosS(Integer opcao){
		for (HashMap<String, Object> atv :listAtvAnalise){
			if(atv.get("exelocal").equals("NÃO")){
				if(opcao == 1){
					atv.put("novouso", "S1");
				} else {
					atv.put("novouso", "S2");
				}
				atv.put("staaat", "D");
			} 
		}
		vincular();
		verificaStatusGeral();
	}
	
	public void todosNaoConforme(){
		for (HashMap<String, Object> atv :listAtvAnalise){
			atv.put("staaat", "I");
		}
		vincular();
		verificaStatusGeral();
	}
	
	public void verificaStatusGeral(){
		List<String> atvIndeferidas = new ArrayList<String>(); 
		List<String> atvDeferidas = new ArrayList<String>();
		
		Boolean indeferido = false;
		for (HashMap<String, Object> atv :listAtvAnalise){
			String cnae = Util.formataCnaeSemMascara(atv.get("cnae").toString());
			if(atv.get("staaat").toString().equalsIgnoreCase("I")){
				indeferido = true;
				atvIndeferidas.add(cnae);
			} else {
				atvDeferidas.add(cnae + "(" + (atv.get("novouso")!=null?atv.get("novouso").toString():"") + ")");
			}
		}
		
		//SETA A SITUAÇÃO
		if(indeferido){
			aenVO.setSitaen("I");
		} else {
			aenVO.setSitaen("D");
		}
		
		//SETA OBSERVACAO
		if(atvDeferidas.size() > 0) {
			observacoes = "Uso Conforme: " + Formatacao.imprimeListaSemEspaco(atvDeferidas) + ".";
			if(observacoes.length() > 1000){
				try {
					Messagebox.show("O parecer automático da observação ultrapassou 1000 caracteres e foi cortado: " + observacoes);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				observacoes = observacoes.substring(0, 999);
			}
		} else {
			observacoes = "";
		}
		observacoes = removeCaracterEspecial(observacoes);
		
		//SETA JUSTIFICATIVA
		if(atvIndeferidas.size() > 0) {
			justificativa = "Atividade(s) que não se enquadra(m) com os usos permitidos para o local: " + Formatacao.imprimeLista(atvIndeferidas) + ". ";
			justificativa = justificativa.length() > 1000?justificativa.substring(0, 999):justificativa;
		} else {
			justificativa = "";
		}
		justificativa = removeCaracterEspecial(justificativa);
		justificativa = justificativa + (justificativa.length()>0?"\n":"") + getUsuario();
		
		//SETA ORIENTACAO
		String ori = "";
		if(tipo_imovel != null && tipo_imovel == "T"){
			ori += "MONTAR PROCESSO COM LEVANTAMENTO, CASO EXISTA EDIFICAÇÃO NO LOTE. APOS ENCAMINAR AO SF / DFUR. ";
		}
		if(aenVO.getSitaen().equals("D")){
			List<String> orgaos = new ArrayList<String>();
			if(aenVO.getAmbaen()!= null && (aenVO.getAmbaen().equalsIgnoreCase("M") || aenVO.getAmbaen().equalsIgnoreCase("A"))){
				orgaos.add("Meio Ambiente");
			}
			if(aenVO.getBomaen()!= null && (aenVO.getBomaen().equalsIgnoreCase("M") || aenVO.getBomaen().equalsIgnoreCase("A"))){
				orgaos.add("Bombeiro");
			}
			if(aenVO.getVigaen()!= null && (aenVO.getVigaen().equalsIgnoreCase("M") || aenVO.getVigaen().equalsIgnoreCase("A"))){
				orgaos.add("Vigilância Sanitária");
			}
			if(orgaos.size() > 0){
				ori += "Necessário o Licenciamento junto ao(s) Órgão(s): " + Formatacao.imprimeLista(orgaos) + ". ";
			}
		} else {
			ori = "";
		}
		orientacao = ori;
		orientacao = orientacao.length() > 1000?orientacao.substring(0, 999):orientacao;

		binder.init(this.getComponente("comboStatus"), true);
		binder.init(this.getComponente("observacoes"), false);
		binder.init(this.getComponente("justificativa"), false);
		binder.loadAll();
	}
	
	public void selecionaProt(){
		retornaViabilidade(protAnaliseSel.get("provia").toString());
	}
	
	public void retornaViabilidade(String prot){
		try {
			listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) protAnaliseSel.get("iddvia"), "V"));
			dadosEndereco = new ViaDAO().getDadosAnalise(prot);
			listFormaAt = new ViaDAO().getFormaAtuacao(prot);
			String inscricaoImob = FormatUtils.onlyNumbers(dadosEndereco.get("iptcen").toString());
			inscricaoImob = Formatacao.zeroEsquerda(inscricaoImob,11);
			dadosZonaUsos = new UsoDAO().getZonasUsosByInscricao(inscricaoImob);
			HashMap<String, Object> dadosVia = new ViaDAO().getDadosByProtocolo(prot);
			dadosImovel = new ImoDAO().getDadosByInscricao(inscricaoImob);
			if(dadosImovel == null){
				throw new Exception("Erro ao buscar dados do imóvel.");
			}
			Boolean autonomo = false;
			Boolean mei = false;
			if(dadosVia.get("tipvia") != null && dadosVia.get("tipvia").toString().equals("A")){
				autonomo = true;
			} else if(dadosVia.get("tipvia") != null && dadosVia.get("tipvia").toString().equals("M")){
				mei = true;
			}
			String endereco = dadosImovel.get("IMO_TIPRUA").toString() + " " + dadosImovel.get("IMO_NOMRUA").toString() + ", " + dadosImovel.get("IMO_NUMERO").toString() + ".";
			dadosImovel.put("endereco", endereco);
			dadosImovel.put("areaterreno", dadosImovel.get("ARETER").toString().replaceAll("Â", ""));
			dadosImovel.put("areaconstruida", dadosImovel.get("IMO_CONSTRUCAO")!=null?dadosImovel.get("IMO_CONSTRUCAO").toString().replaceAll("Â", ""):"");
			dadosImovel.put("areaunitaria", dadosImovel.get("AREUNI")!=null?dadosImovel.get("AREUNI").toString().replaceAll("Â", ""):"");
			//Busca Analise de endereco já gravada e refaz uma nova análise atualizada
			Long iddaen = (Long) dadosEndereco.get("aenvia");
			if(iddaen != null){
				aenVO = new AenDAO().getRegByCodComplex(iddaen);
				listAtvAnalise = new AatDAO().getAtividadesByAen(iddaen);
				
				if(listAtvAnalise == null || listAtvAnalise.size() == 0){
					//nao têm atividades analisadas, então busca da viabilidade
					List<CnaVO> atividades = new CnaDAO().getRegByProtocoloVia(prot);
					for (CnaVO cna : atividades) {
						HashMap<String, Object> aat = new HashMap<String, Object>();
						aat.put("cnae", Util.formataCnaeComMascara(cna.getCodcna() + (cna.getDescna()!=null?cna.getDescna():"")));
						aat.put("exeaat", cna.getExecna());
						listAtvAnalise.add(aat);
					}
				}
				
				for (HashMap<String, Object> atv :listAtvAnalise){
					CnaVO cnaAnalisada = new CnaVO();
					cnaAnalisada.setCodcna(atv.get("cnae").toString());
					cnaAnalisada.setExecna(atv.get("exeaat")!=null?(Boolean) atv.get("exeaat"):null);
					
					cnaAnalisada = Util.analisaAtv(inscricaoImob, cnaAnalisada, ((Boolean) dadosVia.get("escritorio")),autonomo, mei);
					String descricaoCnae = new CclDAO().getNomeByCNAE(new CclVO(atv.get("cnae").toString(), mei?"S":null));
					atv.put("dcoatv", descricaoCnae!=null?descricaoCnae:"CNAE NÃO ENCONTRADO");
					atv.put("novouso", cnaAnalisada.getUsoConforme());
					if(descricaoCnae == null || cnaAnalisada.getStatus().equals("I")){
						atv.put("staaat", "I");
					} else {
						atv.put("staaat", "D");
					}
					if(cnaAnalisada.getExecna()){
						atv.put("exelocal", "SIM");
					} else {
						atv.put("exelocal", "NÃO");
					}
					atv.put("ambaat", cnaAnalisada.getRiscoAmbi());
					atv.put("bomaat", cnaAnalisada.getRiscoBomb());
					atv.put("vigaat", cnaAnalisada.getRiscoVigi());
					atv.put("posaat", cnaAnalisada.getRiscoPost());
					atv.put("traaat", cnaAnalisada.getRiscoTran());
					atv.put("siaaat", cnaAnalisada.getRiscoSIA());
				}
				if(listAtvAnalise != null && listAtvAnalise.size() > 0){
					HashMap<String, String> riscos = getRiscoGeral(listAtvAnalise);
					aenVO.setRisaen(riscos.get("risger"));
					aenVO.setAmbaen(riscos.get("risamb"));
					aenVO.setBomaen(riscos.get("risbom"));
					aenVO.setVigaen(riscos.get("risvig"));
					aenVO.setPosaen(riscos.get("rispos"));
					aenVO.setTraaen(riscos.get("ristra"));
					aenVO.setSiaaen(riscos.get("rissia"));
				}
			} else {
				aenVO = null;
			}
			tipo_imovel = dadosImovel.get("IMO_TIPO") != null && dadosImovel.get("IMO_TIPO").equals("PREDIAL")?"P":"T";
			
			respostas = new ResDAO().getRespostasByColeta((Long) dadosVia.get("colvia"));
			colPerguntas = new CpeDAO().getPerguntasByColeta((Long) dadosVia.get("colvia"));
			vincular();
			verificaStatusGeral();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Messagebox.show("Não foi possível retornar os dados da viabilidade! " + e.getMessage());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void exportListboxToExcel() throws Exception {
		Listbox listAtv = ((Listbox) getComponente("listAtv"));
		ExcelExporter exporter = new ExcelExporter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		exporter.export(listAtv, out);
		AMedia amedia = new AMedia("cnaes_" + protAnaliseSel.get("provia").toString() + ".xlsx", "xls", "application/file", out.toByteArray());
		Filedownload.save(amedia);
		out.close();
	}
	
	public void pesquisar() {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("provia", paramProt!=null&&(!paramProt.isEmpty())?paramProt:null); 
		param.put("datvia", paramData!=null?new SimpleDateFormat("dd/MM/yyyy").format(paramData):null);
		param.put("reqvia", paramReq!=null&&(!paramReq.isEmpty())?paramReq:null); 
		
		Paging pag = (Paging) this.getComponente("pagProt");
		pag.setTotalSize(new ViaDAO().countProtocolosAnalise(param));
		Integer qtd = pag.getTotalSize();
		if (qtd == 0) {
			try {
				Messagebox.show("Nenhum resultado encontrado!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		final int PAGE_SIZE = pag.getPageSize();
		redraw(0, PAGE_SIZE);
		pag.setActivePage(0);
		pag.setDetailed(true);
		pag.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZE;
				redraw(ofs, PAGE_SIZE);
				vincular();
			}
		});
		vincular();
	}

	private void redraw(Integer inicial, Integer maximoPermitido) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("provia", paramProt!=null&&(!paramProt.isEmpty())?paramProt:null); 
		param.put("datvia", paramData!=null?new SimpleDateFormat("dd/MM/yyyy").format(paramData):null);
		param.put("reqvia", paramReq!=null&&(!paramReq.isEmpty())?paramReq:null); 
		
		listProtAnalise = new ViaDAO().getProtocolosAnaliseLimit(param, inicial, maximoPermitido);
	}
	
	@Override
	public void incluir() throws InterruptedException {
	}

	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
		listProtAnalise = new ViaDAO().getProtocolosAnalise(null);
		paramProt = "";
		paramData = null;
		paramReq = "";
		protAnaliseSel = null;
		dadosEndereco = null;
		dadosZonaUsos = null;
		dadosImovel = null;
		listAtvAnalise = null;
		atvAnaliseSel = null;
		aenVO = new AenVO();
		observacoes = "";
		justificativa = "";
		orientacao = "";
		checkEmbasamento = true;
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}
	
	public static HashMap<String, String> getRiscoGeral(List<HashMap<String, Object>> listAtv) {
		HashMap<String, String> result = new HashMap<String ,String>();
		
		String riscoGeral = "B", risamb = "B", risbom = "B", risvig = "B", rispos = "B", ristra = "B", rissia = "B";
		//RISCO GERAL
		for (HashMap<String, Object> cna : listAtv) {
			if(cna.get("ambaat") != null && cna.get("bomaat") != null && cna.get("vigaat") != null && cna.get("posaat") != null && cna.get("traaat") != null && cna.get("siaaat") != null){
				if(cna.get("ambaat").equals("A") || cna.get("bomaat").equals("A") || cna.get("vigaat").equals("A") || cna.get("posaat").equals("A")
					|| cna.get("traaat").equals("A") || cna.get("siaaat").equals("A")){
					riscoGeral = "A";
					break;
				} else if(cna.get("ambaat").equals("M") || cna.get("bomaat").equals("M") || cna.get("vigaat").equals("M") || cna.get("posaat").equals("M")
						|| cna.get("traaat").equals("M") || cna.get("siaaat").equals("M")){
					riscoGeral = "M";
				} 
			} else {
				riscoGeral = "";
			}
		}
		//RISCO GERAL AMB
		for (HashMap<String, Object> cna : listAtv) {
			if(cna.get("ambaat") != null){
				if(cna.get("ambaat").equals("A")){
					risamb = "A";
					break;
				} else if(cna.get("ambaat").equals("M")){
					risamb = "M";
				} 
			} else {
				risamb = "";
			}
		}
		//RISCO GERAL BOM
		for (HashMap<String, Object> cna : listAtv) {
			if(cna.get("ambaat") != null){
				if(cna.get("bomaat").equals("A")){
					risbom = "A";
					break;
				} else if(cna.get("bomaat").equals("M")){
					risbom = "M";
				}  
			} else {
				risbom = "";
			}
		}
		//RISCO GERAL VIG
		for (HashMap<String, Object> cna : listAtv) {
			if(cna.get("ambaat") != null){
				if(cna.get("vigaat").equals("A")){
					risvig = "A";
					break;
				} else if(cna.get("vigaat").equals("M")){
					risvig = "M";
				}  
			} else {
				risvig = "";
			}
		}
		//RISCO GERAL POS
		for (HashMap<String, Object> cna : listAtv) {
			if(cna.get("ambaat") != null){
				if(cna.get("posaat").equals("A")){
					rispos = "A";
					break;
				} else if(cna.get("posaat").equals("M")){
					rispos = "M";
				}  
			} else {
				rispos = "";
			}
		}
		//RISCO GERAL TRA
		for (HashMap<String, Object> cna : listAtv) {
			if(cna.get("ambaat") != null){
					if(cna.get("traaat").equals("A")){
					ristra = "A";
					break;
				} else if(cna.get("traaat").equals("M")){
					ristra = "M";
				}  
			} else {
				ristra = "";
			}
		}
		//RISCO GERAL SIA
		for (HashMap<String, Object> cna : listAtv) {
			if(cna.get("ambaat") != null){
				if(cna.get("siaaat").equals("A")){
					rissia = "A";
					break;
				} else if(cna.get("siaaat").equals("M")){
					rissia = "M";
				}  
			} else {
				rissia = "";
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
	
	public void addMsgObs(){
		observacoes = msgJust.getDestab() + (observacoes.length()>0?"\n" + observacoes:"");
		binder.init(this.getComponente("observacoes"), false);
		binder.loadAll();
	}
	
	public String removeCaracterEspecial(String texto){
		texto = texto.replaceAll("[#$%&'()*\\+\\<=>@\\[\\^_`{\\|}\"~-]", "");
		return texto;
	}

	public Boolean isBae(){
		if(protAnaliseSel != null && protAnaliseSel.get("provia") != null && protAnaliseSel.get("provia").toString().startsWith("CGR")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isNaoBae(){
		return !isBae();
	}
	
	public void upload(Event evt) throws IOException, InterruptedException {
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
	
	public void anexar() throws InterruptedException{
		if(up != null && up.getAnxVO() != null){
			if(listAnx != null && listAnx.size() >= 10){
				throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar, limite máximo de 10 arquivos!");
			} else {
				if(descricaoArquivo == null || descricaoArquivo.isEmpty()){
					throw new WrongValueException(getComponente("desarq"),"Informe a Descrição do Arquivo!");
				} else {
					AnxVO anxVO = up.getAnxVO();
					anxVO.setDesanx(descricaoArquivo);
					anxVO.setDesanx(descricaoArquivo);
					anxVO.setUsualt(getLogin());
					
					try {
						// inclui o arqanx
						ArqanxVO arqanx = anxVO.getArqanxVO();
						Long seqarq = (Long) new ArqanxDAO().insReg(arqanx);
						arqanx.setSeqarq(seqarq);
						// inclui o anx
						anxVO.setArqanx(seqarq);
						anxVO.setDocanx((Long) protAnaliseSel.get("iddvia"));
						anxVO.setTpdanx("V");
						Long codigoanx = (Long) new AnxDAO().insReg(anxVO);
						anxVO.setIddanx(codigoanx);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar o arquivo!");
					}
					
					if (listAnx == null){
						listAnx = new ArrayList<AnxVO>();
					}
					listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) protAnaliseSel.get("iddvia"), "V"));
					up = null;
					descricaoArquivo = "";
					this.vincular();
				}
			}
		} else {
			throw new WrongValueException(getComponente("selArq"),"Carregue um Arquivo!");
		}
	}
	
	public void cancelarAnexo(){
		up = null;
		descricaoArquivo = "";
		this.vincular();
	}
	
	public void download(AnxVO anexo) throws InterruptedException {
		ArqanxVO arqanxVO = null;
		if (anexo.getIddanx() != null) {
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
			Filedownload.save((byte[]) anexo.getArqanxVO().getAnxarq(), anexo.getArqanxVO().getTiparq(), anexo.getNomanx());
		}
	}
	
	public void deletarArquivo(AnxVO anxVO) throws InterruptedException, SQLException {
		int resp = Messagebox.show("Deseja realmente excluir este arquivo?", "Confirmação", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION);
		if (resp == Messagebox.YES) {
			if (anxVO.getIddanx() == null) {
				// ainda nao foi inserido. apenas tirar da lista
				listAnx.remove(anxVO);
				Messagebox.show("Arquivo excluído com sucesso!");
			} else {
				// arquivo ja inserido. apagar do banco
				Integer qtdDel = new AnxDAO().delReg(anxVO.getIddanx());
				if (anxVO.getArqanx() != null) {
					new ArqanxDAO().delReg(anxVO.getArqanx());
				}
				if (qtdDel > 0) {
					Messagebox.show("Arquivo excluído com sucesso!");
					listAnx.remove(anxVO);
				} else {
					Messagebox.show("Arquivo não pode ser excluído!");
				}
			}
		}
		this.vincular();
	}
	
	public Boolean isTemRespostas(){
		if(respostas != null){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isTemPerguntas(){
		if(colPerguntas != null && colPerguntas.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isTemQuestionario(){
		if(isTemPerguntas() || isTemRespostas()){
			return true;
		} else {
			return false;
		}
	}
}
