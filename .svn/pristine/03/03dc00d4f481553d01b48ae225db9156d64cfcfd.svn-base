package pmcg.imti.view;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.exporter.excel.ExcelExporter;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.AatDAO;
import pmcg.fcn.dao.ibatis.AenDAO;
import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CclDAO;
import pmcg.fcn.dao.ibatis.CpeDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.ResDAO;
import pmcg.fcn.dao.ibatis.UsoDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.AenVO;
import pmcg.fcn.domain.CclVO;
import pmcg.fcn.domain.CpeVO;
import pmcg.fcn.domain.ResVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.framework.dao.ibatis.WebmnuDAO;
import pmcg.framework.dao.ibatis.WebusuDAO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.ui.LogicUtils;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class Acopro extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public List<HashMap<String, Object>> listProtocolos;
	public HashMap<String, Object> protAnaliseSel;
	public HashMap<String, Object> dadosEndereco;
	public HashMap<String, Object> dadosZonaUsos;
	public HashMap<String, Object> dadosImovel;
	public List<HashMap<String, Object>> listEventos;
	public List<HashMap<String, Object>> listAtvAnalise;
	public HashMap<String, Object> atvAnaliseSel;
	public List<HashMap<String, Object>> listSocios;
	public List<HashMap<String, Object>> listFormaAt;
	public String paramProt;
	public Date paramData;
	public String paramReq;
	public AenVO aenVO; //Análise de Endereço
	public Integer progresso = 0;
	public Boolean podeAlterarParecer; //variável utilizada para saber se usuario pode mudar uma viabilidade INDEFERIDA para ESTUDO (SÓ ANALISTA SIA)
	public Boolean visibleList = true; //Caso a tela receba um protocolo por parametro nao precisa mostrar a lista
	public ResVO respostas; // Questionário nosso, protocolos "CGR"
	public List<CpeVO> colPerguntas; // Questionário da Junta, protocolos "MSP"	
	
	public Acopro() {
		Map map = Executions.getCurrent().getArg();
		if(map != null && map.get("provia") != null){
			paramProt = (String) map.get("provia");
			visibleList = false;
		}
	}
	
	public void initComponentes(){
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		
		if(getCodSis() != null){
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("codusu", getCodUsuario());
			param.put("coduni", getCodUnidade());
			param.put("codsis", getCodSis());
			param.put("urlfrm", "forms/anapro.zul");
			podeAlterarParecer = new WebmnuDAO().temPermissao(param);
			if(podeAlterarParecer == null){
				podeAlterarParecer = false;
			}
		} else {
			podeAlterarParecer = false;
		}
		filtrar();
	}
	
	@Override
	public void salvar() throws InterruptedException {

	}
	
	public void selecionaProt(){
		retornaViabilidade(protAnaliseSel.get("provia").toString());
	}
	
	public void retornaViabilidade(String prot){
		try {
			dadosEndereco = new ViaDAO().getDadosAnalise(prot);
			
			String inscricaoImobiliaria = Formatacao.zeroEsquerda(FormatUtils.onlyNumbers(dadosEndereco.get("iptcen").toString()),11);
			dadosZonaUsos = new UsoDAO().getZonasUsosByInscricao(inscricaoImobiliaria);
						
			dadosImovel = new ImoDAO().getDadosByInscricao(inscricaoImobiliaria);
			if(dadosImovel != null){
				String endereco = dadosImovel.get("IMO_TIPRUA").toString() + " " + dadosImovel.get("IMO_NOMRUA").toString() + ", " + dadosImovel.get("IMO_NUMERO").toString() + ".";
				dadosImovel.put("endereco", endereco);
				dadosImovel.put("areaterreno", dadosImovel.get("ARETER").toString().replaceAll("Â", ""));
				dadosImovel.put("areaconstruida", dadosImovel.get("IMO_CONSTRUCAO")!=null?dadosImovel.get("IMO_CONSTRUCAO").toString().replaceAll("Â", ""):"");
				dadosImovel.put("areaunitaria", dadosImovel.get("AREUNI")!=null?dadosImovel.get("AREUNI").toString().replaceAll("Â", ""):"");
			} else {
				Messagebox.show("Inscrição Imobiliária Inválida!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
				dadosImovel = null;
			}
			Boolean mei = false;
			if(dadosEndereco.get("tipvia") != null && dadosEndereco.get("tipvia").toString().equals("M")){
				mei = true;
			}
			
			Long iddaen = (Long) dadosEndereco.get("aenvia");
			respostas = new ResDAO().getRespostasByColeta((Long) dadosEndereco.get("colvia"));
			colPerguntas = new CpeDAO().getPerguntasByColeta((Long) dadosEndereco.get("colvia"));
			if(iddaen != null){
				aenVO = new AenDAO().getRegByCodComplex(iddaen);
				listEventos = new ViaDAO().getEventos((Long) dadosEndereco.get("iddvia"));
				listSocios = new ViaDAO().getSocios((Long) dadosEndereco.get("iddvia"));
				listFormaAt = new ViaDAO().getFormaAtuacao(prot);
				listAtvAnalise = new AatDAO().getAtividadesByAen(iddaen);
				for (HashMap<String, Object> atv :listAtvAnalise){
					
					atv.put("dcoatv", new CclDAO().getNomeByCNAE(new CclVO(atv.get("cnae").toString(), mei?"S":null)));
					if((Boolean) atv.get("exeaat")){
						atv.put("exelocal", "SIM");
					} else {
						atv.put("exelocal", "NÃO");
					}
				}
			} else {
				aenVO = null;
			}
			atualizaProgresso(prot);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Messagebox.show("Não foi possível retornar os dados da viabilidade! " + e.getMessage());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void atualizaProgresso(String protocolo) {
		Integer qnt = new ViaDAO().getProgressoViabilidade(protocolo);
		if(qnt == 6){
			progresso = 100;
		} else {
			progresso = (int) (qnt * 16.66);
		}
		vincular();
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
	
	public void filtrar(){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("provia", paramProt!=null&&(!paramProt.isEmpty())?paramProt:null); 
		param.put("datvia", paramData!=null?new SimpleDateFormat("dd/MM/yyyy").format(paramData):null);
		param.put("reqvia", paramReq!=null&&(!paramReq.isEmpty())?paramReq:null); 
		
		Paging pag = (Paging) this.getComponente("pagProt");
		pag.setTotalSize(new ViaDAO().countProtocolos(param));
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
		
		this.listProtocolos = new ViaDAO().getProtocolosLimit(param, inicial, maximoPermitido);
		if(listProtocolos != null && listProtocolos.size() == 1){
			protAnaliseSel = listProtocolos.get(0);
			selecionaProt();
		}
//		for (HashMap<String, Object> pro : listProtocolos){
//			HashMap<String, Object> dadosVia = new ViaDAO().getDadosByProtocolo(pro.get("provia").toString());
//			//SE ->  (MEI E ñ possui est. fixo) OU (AUTONOMO E NAO ESTABELECIDO)) defere direto pois não precisam de guia
//			if(((!dadosVia.get("tipvia").toString().equals("A")) && (!(Boolean) dadosVia.get("possuiestabelecimentofixo"))) || (dadosVia.get("tipvia").toString().equals("A") && dadosVia.get("sauvia").toString().equals("N"))){
//				pro.put("permImpGC", false);
//			} else {
//				if(pro.get("analise")!= null && (pro.get("analise").toString().startsWith("Def") || pro.get("analise").toString().startsWith("Ind"))){
//					pro.put("permImpGC", true);
//				} else {
//					pro.put("permImpGC", false);
//				}
//			}
//		}
	}
	
	public void enviarParaEstudo() throws SQLException{
		if(podeAlterarParecer && aenVO != null && aenVO.getSitaen() != null && 
				(aenVO.getSitaen().equalsIgnoreCase("Indeferida") || (aenVO.getSitaen().equalsIgnoreCase("Deferida")))){
			dadosImovel = new ImoDAO().getDadosByInscricao(Formatacao.zeroEsquerda(dadosEndereco.get("iptcen").toString(),11));
			if(dadosImovel != null){
				try {
					//INSERE UMA "CÓPIA" DA ANALISE DE ENDERECO COM A SITUACAO EM ESTUDO E ATUALIZA A VIABILIDADE
					new ViaDAO().getSqlMap().startTransaction();
					AenVO novaAen = new AenDAO().getRegByCod(aenVO.getIddaen());
					novaAen.setIddaen(null);
					novaAen.setSitaen("Em Estudo");
					novaAen.setUsualt(getLogin());
					Long iddNovaAen = (Long) new AenDAO().insReg(novaAen);
					ViaVO viaupd = new ViaVO();
					viaupd.setAenvia(iddNovaAen);
					viaupd.setIddvia((Long) protAnaliseSel.get("iddvia"));
					new ViaDAO().updAnaliseEnderecoByIdd(viaupd);
					new ViaDAO().getSqlMap().commitTransaction();
					Messagebox.show("Viabilidade Alterada Com Sucesso!", "Viabilidade!", Messagebox.OK, Messagebox.INFORMATION);
				} catch (SQLException e) {
					new ViaDAO().getSqlMap().endTransaction();
					e.printStackTrace();
				} catch (InterruptedException e) {
					new ViaDAO().getSqlMap().endTransaction();
					e.printStackTrace();
				} finally {
					new ViaDAO().getSqlMap().endTransaction();
				}
			} else {
				try {
					Messagebox.show("Não foi possível enviar para estudo! Inscrição Imobiliária não cadastrada!", "Aviso!", Messagebox.OK, Messagebox.ERROR);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				Messagebox.show("Usuário não autorizado a realizar essa operação!", "Aviso!", Messagebox.OK, Messagebox.ERROR);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void imprimirGuiaConsulta(Listitem item){
		@SuppressWarnings("unchecked")
		HashMap<String, Object> via = (HashMap<String, Object>) item.getValue();
		if((Boolean) via.get("permguia")){
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("provia", via.get("provia").toString());
			new WinUtils().abrirBirt("guia_consulta.rptdesign", param);
		}
	}
	
	public Boolean visibleEnviaEstudo(){
		if(podeAlterarParecer && aenVO != null && aenVO.getSitaen() != null && 
				(aenVO.getSitaen().equalsIgnoreCase("Indeferida") || (aenVO.getSitaen().equalsIgnoreCase("Deferida")))){
			return true;
		} else {
			return false;
		}
	}
	
	public String getUsuario(){
		if(aenVO != null){
			if(aenVO.getUsualt() != null && (!aenVO.getUsualt().equals("SISTEMA"))){
				return new WebusuDAO().getNomByLog(aenVO.getUsualt());
			} else {
				return aenVO.getUsualt();
			}
		} else {
			return "";
		}
	}
	
	public Boolean isTemSocios(){
		if(listSocios != null && listSocios.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isTemEventos(){
		if(listEventos != null && listEventos.size() > 0){
			return true;
		} else {
			return false;
		}
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
	
	@Override
	public void incluir() throws InterruptedException {
	}

	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void pesquisar() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
		paramProt = "";
		paramData = null;
		paramReq = "";
		protAnaliseSel = null;
		dadosEndereco = null;
		dadosZonaUsos = null;
		dadosImovel = null;
		listEventos = null;;
		listAtvAnalise = null;
		atvAnaliseSel = null;
		listSocios = null;
		listFormaAt = null;
		aenVO = null;
		filtrar();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
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
