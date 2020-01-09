package pmcg.imti.view.ext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.CclDAO;
import pmcg.fcn.dao.ibatis.CenDAO;
import pmcg.fcn.dao.ibatis.CfaDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.ColDAO;
import pmcg.fcn.dao.ibatis.EdrDAO;
import pmcg.fcn.dao.ibatis.ReqDAO;
import pmcg.fcn.dao.ibatis.ResDAO;
import pmcg.fcn.dao.ibatis.UsoDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.CadVO;
import pmcg.fcn.domain.CclVO;
import pmcg.fcn.domain.CenVO;
import pmcg.fcn.domain.CfaVO;
import pmcg.fcn.domain.CnaVO;
import pmcg.fcn.domain.ColVO;
import pmcg.fcn.domain.EdrVO;
import pmcg.fcn.domain.ReqVO;
import pmcg.fcn.domain.ResVO;
import pmcg.fcn.domain.UsoVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.prefeitura.Util;
import pmcg.framework.util.StringUtils;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.dao.ibatis.NjrDAO;
import pmcg.imti.domain.NjrVO;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class Viabilidade extends Index {

//	private static final Logger logger = LoggerFactory.getLogger(Simulador.class);
	private static final long serialVersionUID = 1L;
//	public CtrVO ctrVO = (CtrVO) getSession().getAttribute("usuarioextcontador"); //Contador logado
	public CadVO usuario;
	public Boolean usuarioRespCont = false;
	public String inscricao;
	public ViaVO viabilidade = new ViaVO();
	public ResVO respostas = new ResVO();
	public String protocolo; 
	public HashMap<String,Object> dadosImovel;
	public HashMap<String, Object> dadosZonaUsos;
	public List<UsoVO> listUsosZona; //lista de usos da zona
	public List<NjrVO> listNat = new ArrayList<NjrVO>(); // Lista de naturezas
	public NjrVO njrVO = new NjrVO(); // Natureza selecionada
	public CclVO atvFiltro = new CclVO(); //filtros de par�metro da atividade
	public List<CclVO> listAtv = new ArrayList<CclVO>(); //lista de Atividades
	public CclVO atvSel = new CclVO(); //atividade selecionada da lista acima
	public List<CnaVO> listAtvSel = new ArrayList<CnaVO>(); //lista de Atividades selecionadas
	public CnaVO cnaSel = new CnaVO(); //atividade selecionada da lista acima
	public Boolean visibleDivCad = true;
	public Boolean visibleDivRel = false;
	public Boolean aceite = false;
	AnnotateDataBinder binderAtv = new AnnotateDataBinder();
	AnnotateDataBinder binderAtvSel = new AnnotateDataBinder();
	
		
	public void initVia(Integer opcao) throws SQLException{
//		if(opcao == 2){
//			//CONTADOR - DEVE ESTAR LOGADO
//			if(ctrVO==null){
//				desconectarUsuario();
//			}
//		}
//		viabilidade.setTipvia("A");
//		atualizaNatureza();
		listNat.addAll(new NjrDAO().getTodos(null));
		njrVO = listNat.get(0);
		viabilidade.setColeta(new ColVO());
		viabilidade.setEvevia("I");
		viabilidade.setTipvia("E");
		
		binderAtv.init(getComponente("listAtv"), true);
		binderAtv.init(getComponente("atvSel"), true);
		binderAtv.init(getComponente("produtiva"), true);
		binderAtv.init(getComponente("auxiliar"), true);
		binderAtvSel.init(getComponente("atvSel"), true);
		
		usuario = getUsuario();
		if(usuario != null && usuario.getCpfcad() != null){
			if(usuario.getCpccad() != null){
				usuarioRespCont = true;
			} else {
				//se n�o � contador seta o pr�prio usu�rio como respons�vel pela guia de consulta
				usuarioRespCont = false;
				viabilidade.setCprvia(usuario.getCpfcad());
				viabilidade.setNorvia(usuario.getNomcad());
				viabilidade.setDdtvia(usuario.getDdtcad());
				viabilidade.setTelvia(usuario.getTelcad());
				viabilidade.setEmavia(usuario.getEmacad());
			}
			
		}
		this.vincular();
		
		//TODO
		//inscricao = "12680430916";
		//pesquisarInscricao();
	}
	
	public void buscaInscricao(){
		//Map<String, String> param = new HashMap<String, String>();
		new WinUtils().abrirLis("/forms/simlis.zul", null, this, "retInscricao");
	}
	
	@SuppressWarnings("unchecked")
	public void retInscricao(Object insc) throws SQLException {
		inscricao = ((HashMap<String,Object>) insc).get("INSCRICAO").toString();
		this.pesquisarInscricao();
		this.atualizaAtividades();
	}

	@SuppressWarnings("unchecked")
	public void pesquisarInscricao(){
		if(inscricao == null || inscricao.isEmpty()){
			throw new WrongValueException(getComponente("inscricao"),"Informe a Inscri��o Imobili�ria ou fa�a a 'Busca por Endere�o'!");
		}
		dadosImovel = new ImoDAO().getDadosByInscricao(Formatacao.zeroEsquerda(inscricao,11));
		String endereco = dadosImovel.get("IMO_TIPRUA").toString() + " " + dadosImovel.get("IMO_NOMRUA").toString() + ", " + dadosImovel.get("IMO_NUMERO").toString() + ".";
		dadosImovel.put("endereco", endereco);
		dadosImovel.put("areaterreno", dadosImovel.get("ARETER").toString().replaceAll("�", ""));
		dadosImovel.put("areaconstruida", dadosImovel.get("IMO_CONSTRUCAO")!=null?dadosImovel.get("IMO_CONSTRUCAO").toString().replaceAll("�", ""):"");
		dadosImovel.put("areaunitaria", dadosImovel.get("AREUNI")!=null?dadosImovel.get("AREUNI").toString().replaceAll("�", ""):"");
		if(dadosImovel.get("IMO_CEP") != null && (!dadosImovel.get("IMO_CEP").toString().isEmpty()) && (!dadosImovel.get("IMO_CEP").toString().equals("0")) && (!(dadosImovel.get("IMO_CEP").toString().replaceAll("-", "").length() == 8))){
			((Textbox) getComponente("cep")).setDisabled(true);
		} else {
			((Textbox) getComponente("cep")).setDisabled(false);
		}
		
		dadosZonaUsos = new UsoDAO().getZonasUsosByInscricao(Formatacao.zeroEsquerda(inscricao,11));
		
		HashMap<String, Object> analiseImovel = null;
		try {
			analiseImovel = Util.analisaZonaUsoImovel(Formatacao.zeroEsquerda(inscricao, 11));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(dadosImovel == null || dadosImovel.get("IMO_COD") == null){
			listAtv = new ArrayList<CclVO>();
			listAtvSel = null;
			listUsosZona = null;
			this.vincular();
			throw new WrongValueException(getComponente("inscricao"),"Inscri��o Imobili�ria n�o encontrada!");
		} else {
			listUsosZona = new ArrayList<UsoVO>();
			listUsosZona.addAll((List<UsoVO>) analiseImovel.get("objUsos"));
			listAtvSel = new ArrayList<CnaVO>();
//			this.pesquisaAtv();
		}
		vincular();
	}
	
	public void pesquisaAtv() {
		if(viabilidade.getTipvia() == null){
			throw new WrongValueException(getComponente("tipo"),"Informe o campo 'Tipo Registro'!");
		}
		if(viabilidade.getTipvia().equals("E") || viabilidade.getTipvia().equals("C")){
			//Empresa
			atvFiltro.setCboccl("N");
			atvFiltro.setMeiccl("N");
		} else if(viabilidade.getTipvia().equals("A")){
			//Aut�nomo
			atvFiltro.setCboccl("S");
			atvFiltro.setMeiccl("N");
		} else {
			//MEI
			atvFiltro.setCboccl("N");
			atvFiltro.setMeiccl("S");
		}
		Paging pag = (Paging) this.getComponente("pagAtv");
		pag.setTotalSize(new CclDAO().getCountByCriterio(atvFiltro));
		final int PAGE_SIZE = pag.getPageSize();
		redraw(atvFiltro, 0, PAGE_SIZE);
		pag.setActivePage(0);
		pag.setDetailed(true);
		pag.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZE;
				redraw(atvFiltro, ofs, PAGE_SIZE);
				vincular();
			}
		});
		binderAtv.loadAll();
	}
	
	
	private void redraw(CclVO atv, Integer inicial, Integer maximoPermitido) {
		this.listAtv = new CclDAO().getByCriterioLimit(atvFiltro, inicial, maximoPermitido);
	}
	
	public void selecionaAtv(Listitem item){
		if(!viabilidade.getTipvia().equals("A")){
			validaTipoUnidade();
		}
		try {
			CclVO ccl = (CclVO) item.getValue();
			CnaVO cnaAnalisada = new CnaVO();
			cnaAnalisada.setCodcna(ccl.getCodccl());
			cnaAnalisada.setExecna(true);
			Boolean jaSelecionada = false;
			for(CnaVO cna : listAtvSel){
				if(cna.getCodcna().equals(cnaAnalisada.getCodcna())){
					Messagebox.show("Atividade j� selecionada!","Viabilidade",Messagebox.OK,Messagebox.INFORMATION);
					jaSelecionada = true;
					break;
				}
			}
			if(!jaSelecionada){
				Boolean escritorio;
				if(viabilidade.getTipvia().equals("A")){
					escritorio = false;
				} else {
					escritorio = viabilidade.getColeta().getCtucol().equals("AUXILIAR") && viabilidade.getColeta().getFormaAtuacaoAuxiliar().equals("02")?true:false;
				}
				Boolean autonomo = false;
				Boolean mei = false;
				if(viabilidade.getTipvia().equals("A")){
					autonomo = true;
				} else if(viabilidade.getTipvia().equals("M")){
					mei = true;
				}
				cnaAnalisada = Util.analisaAtv(inscricao, cnaAnalisada, escritorio, autonomo, mei);
				if(cnaAnalisada.getRiscoSIA() != null && (cnaAnalisada.getRiscoSIA().equals("M") || cnaAnalisada.getRiscoSIA().equals("A"))){
					cnaAnalisada.setStatus("E"); //ESTUDO
				}
				cnaAnalisada.setDcoatv(ccl.getNomccl());
				cnaAnalisada.setPrincipal(false);
				cnaAnalisada.setPricna(0);
				listAtvSel.add(cnaAnalisada);
			}
			vincular();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validaTipoUnidade(){
		if(viabilidade.getColeta().getCtucol() == null || (viabilidade.getColeta().getCtucol() != null && viabilidade.getColeta().getCtucol().trim().isEmpty())){
			throw new WrongValueException(getComponente("tipounidade"),"Informe o campo 'Tipo de Unidade do Empreendimento'!");
		}
		if(viabilidade.getColeta().getCtucol().equals("AUXILIAR")){
			if(viabilidade.getColeta().getFormaAtuacaoAuxiliar() == null || (viabilidade.getColeta().getFormaAtuacaoAuxiliar() != null && viabilidade.getColeta().getFormaAtuacaoAuxiliar().trim().isEmpty())){
				throw new WrongValueException(getComponente("auxiliar"),"Informe o Tipo de Unidade Auxiliar!");
			}
		} else {
			if(!viabilidade.getColeta().getP1() && !viabilidade.getColeta().getP2() && !viabilidade.getColeta().getP3() && !viabilidade.getColeta().getP4() && !viabilidade.getColeta().getP5() && !viabilidade.getColeta().getP6() && !viabilidade.getColeta().getP7()){
				throw new WrongValueException(getComponente("produtiva"),"Informe pelo menos um Tipo de Unidade Produtiva!");
			}
		}
	}
	
	public void reanalizaAtv(Listitem item) throws Exception{
		CnaVO cna = (CnaVO) item.getValue();
		Boolean escritorio;
		if(isAutonomo()){
			escritorio = false;
		} else {
			escritorio = viabilidade.getColeta().getCtucol().equals("AUXILIAR") && viabilidade.getColeta().getFormaAtuacaoAuxiliar().equals("02")?true:false;
		}
		Boolean autonomo = false;
		Boolean mei = false;
		if(viabilidade.getTipvia().equals("A")){
			autonomo = true;
		} else if(viabilidade.getTipvia().equals("M")){
			mei = true;
		}
		cna = Util.analisaAtv(inscricao, cna, escritorio, autonomo, mei);
		item.setValue(cna);
		binderAtvSel.loadAll();
	}
	
	public void selecionaPrincipal(Listitem item){
		for (CnaVO atv : listAtvSel) {
			atv.setPrincipal(false);
		}
		((CnaVO) item.getValue()).setPrincipal(true);
		//"vincular" s� no listbox atvSel
		binderAtvSel.loadAll();
	}
	
	public void removeAtv(Listitem item){
		listAtvSel.remove(item.getValue());
		//"vincular" s� no listbox atvSel
		binderAtvSel.loadAll();
	}
	
	public void salvar() throws NumberFormatException, InterruptedException{
		if(isNaoAutenticado()){
			Messagebox.show("Para Salvar a Vialibidade deve existir um usu�rio logado!", "Viabilidade", Messagebox.OK, Messagebox.INFORMATION);
		} else {
			if(viabilidade.getTipvia().equals("E") && (!viabilidade.getEvevia().equals("R"))){
				//EMPRESA
				viabilidade.setSauvia(null);
				viabilidade.setEinvia(null);
				throw new WrongValueException(getComponente("tipo"),"N�o � poss�vel Salvar! Tipo 'Empresarial' funciona apenas como simulador!");
			} else if(viabilidade.getTipvia().equals("M")){
				//MEI
				if(viabilidade.getEinvia() == null || viabilidade.getEinvia().isEmpty()){
					throw new WrongValueException(getComponente("empind"),"Informe o campo 'Empreendedor Individual'!");
				}
				viabilidade.setSauvia(null);
				if(viabilidade.getColeta().getCtucol().equals("AUXILIAR")){
					throw new WrongValueException(getComponente("auxiliar"),"N�o � poss�vel Salvar! Empresas n�o estabelecidas n�o geram Guia de Consulta!");
				} else if(!viabilidade.getColeta().getP1()){
					throw new WrongValueException(getComponente("produtiva"),"N�o � poss�vel Salvar! Empresas n�o estabelecidas n�o geram Guia de Consulta!");
				}
				if((viabilidade.getColeta().getCtucol().equals("PRODUTIVA") && viabilidade.getColeta().getP1()) ||
				   (viabilidade.getColeta().getCtucol().equals("AUXILIAR") && viabilidade.getColeta().getFormaAtuacaoAuxiliar().equals("11"))){
					viabilidade.setEstvia(true);
				} else {
					viabilidade.setEstvia(false);
				}
			} else if(viabilidade.getTipvia().equals("A")){
				//AUT�NOMO
				if(viabilidade.getSauvia() == null || viabilidade.getSauvia().isEmpty()){
					throw new WrongValueException(getComponente("sitaut"),"Informe o campo 'Situa��o do Aut�nomo'!");
				}
				viabilidade.setEinvia(null);
				if(viabilidade.getSauvia().equals("E")){
					viabilidade.setEstvia(true);
				} else {
					viabilidade.setEstvia(false);
				}
			} else {
				//Cart�rio/OAB
				if((viabilidade.getColeta().getCtucol().equals("PRODUTIVA") && viabilidade.getColeta().getP1()) ||
				   (viabilidade.getColeta().getCtucol().equals("AUXILIAR") && viabilidade.getColeta().getFormaAtuacaoAuxiliar().equals("11"))){
					viabilidade.setEstvia(true);
				} else {
					viabilidade.setEstvia(false);
				}
			}
			if(njrVO == null || njrVO.getCodnjr() == null){
				throw new WrongValueException(getComponente("cbNatu"),"Informe a Natureza Jur�dica!");
			}
			if(njrVO.getCodnjr().equals("4081") && (!viabilidade.getTipvia().equals("A"))){
				throw new WrongValueException(getComponente("cbNatu"),"Natureza Jur�dica inv�lida para o Tipo de Registro!");
			}
			if(njrVO.getCodnjr().equals("2135") && (!viabilidade.getTipvia().equals("M"))){
				throw new WrongValueException(getComponente("cbNatu"),"Natureza Jur�dica inv�lida para o Tipo de Registro!");
			}
			if(!viabilidade.getTipvia().equals("A")){
				if(viabilidade.getTeqvia() == null || viabilidade.getTeqvia().isEmpty()){
					throw new WrongValueException(getComponente("enquadramento"),"Informe o Enquadramento!");
				}
			} else {
				viabilidade.setTeqvia("MICRO_EMPRESA");
			}
			if(dadosImovel == null || dadosImovel.get("IMO_COD") == null){
				throw new WrongValueException(getComponente("inscricao"),"Informe a Inscri��o Imobili�ria ou fa�a a 'Busca por Endere�o'!");
			}
			if(dadosImovel == null || dadosImovel.get("IMO_CEP") == null || (dadosImovel.get("IMO_CEP").toString().replaceAll("-", "").length() != 8)){
				throw new WrongValueException(getComponente("cep"),"Informe os d�gitos num�ricos do CEP!");
			}
			if(listAtvSel == null || listAtvSel.size() <= 0){
				throw new WrongValueException(getComponente("listAtv"),"Informe a(s) atividade(s)!");
			}
			//verifica se existem alguma atividade n�o permitida selecionada
			Boolean permitida = true;
			Boolean temPricipal = false;
			for (CnaVO atv : listAtvSel) {
				if(atv.getStatus().equals("I")){
					permitida = false;
				}
				if (atv.getPrincipal()) {
					temPricipal = true;
				}
			}
			if(!temPricipal){
				throw new WrongValueException(getComponente("atvSel"),"Informe a atividade principal!");
			}
			
//			if(respostas.getR01res() == null || respostas.getR02res() == null || respostas.getR03res() == null || respostas.getR04res() == null || respostas.getR05res() == null || respostas.getR06res() == null || respostas.getR07res() == null || respostas.getR08res() == null || respostas.getR09res() == null || respostas.getR10res() == null || respostas.getR11res() == null || respostas.getR12res() == null || respostas.getR13res() == null || respostas.getR14res() == null || respostas.getR15res() == null || respostas.getR16res() == null || respostas.getR17res() == null || respostas.getR18res() == null || respostas.getR19res() == null || respostas.getR20res() == null || respostas.getR21res() == null || respostas.getR22res() == null || respostas.getR23res() == null || respostas.getR24res() == null || respostas.getR25res() == null || respostas.getR26res() == null || respostas.getR27res() == null){
			//if(visibleQuest() && respostas.getR06res() == null){
			if(respostas.getR06res() == null){
				throw new WrongValueException("Responda as perguntas da �rea 'Informa��es Complementares'!");
			}
			if(usuarioRespCont){
				String cpfcnpj = FormatUtils.onlyNumbers(viabilidade.getCprvia());
				if(cpfcnpj == null || cpfcnpj.isEmpty()){
					throw new WrongValueException(getComponente("cprvia"),"Informe o CPF/CNPJ do Respons�vel!");
				}
				if(cpfcnpj.length() != 11 && cpfcnpj.length() != 14){
					throw new WrongValueException(getComponente("cprvia"),"CPF incorreto!");
				}
				if(!StringUtils.valida_CpfCnpj(cpfcnpj)){
					throw new WrongValueException(getComponente("cprvia"),"CPF inv�lido!");
				}
				if(viabilidade.getNorvia() == null || viabilidade.getNorvia().isEmpty()){
					throw new WrongValueException(getComponente("norvia"),"Informe o Nome/Raz�o Social do Respons�vel!");
				}
				viabilidade.setDdtvia(FormatUtils.onlyNumbers(viabilidade.getDdtvia()));
				if(viabilidade.getDdtvia() == null || viabilidade.getDdtvia().equals("0") || viabilidade.getDdtvia().equals("00") || viabilidade.getDdtvia().length() < 2) {
					throw new WrongValueException(getComponente("ddtvia"), "Informe um DDD v�lido de dois d�gitos!");
				}
				viabilidade.setTelvia(FormatUtils.onlyNumbers(viabilidade.getTelvia()));
				if(viabilidade.getTelvia() == null || viabilidade.getTelvia().equals("") || viabilidade.getTelvia().replaceAll("[-_(). ]","").length() < 8 ) {
					throw new WrongValueException(getComponente("telvia"), "Informe o Telefone do Respons�vel!");
				}
				if(viabilidade.getEmavia() == null || viabilidade.getEmavia().isEmpty()) {
					throw new WrongValueException(getComponente("emavia"), "Informe o E-mail do Respons�vel!");
				}
			}
			if(!aceite){
				throw new WrongValueException(getComponente("chkAceite"),"Confirme a Veracidade dos dados!");
			}
			if(permitida) {
				if (Messagebox.show("As informa��es desta simula��o, como endere�o de localiza��o e atividades pretendidas, podem ser utilizadas durante a efetiva constitui��o de sua empresa.\n\nDeseja salvar esta viabilidade?","Aviso!!!", Messagebox.YES | Messagebox.NO,
						Messagebox.QUESTION) == Messagebox.YES) {
					try{
						new ViaDAO().getSqlMap().startTransaction();
						Long codcen = null, codedr = null, codcol = null, codreq = null;
						//INSERIR ENDERECO
						try {
							EdrVO edr = new EdrVO();
							edr.setTloedr(dadosImovel.get("IMO_TIPRUA")!=null?dadosImovel.get("IMO_TIPRUA").toString():"");
							edr.setNloedr(dadosImovel.get("IMO_NOMRUA")!=null?dadosImovel.get("IMO_NOMRUA").toString():null);
							edr.setComedr(dadosImovel.get("IMO_COMPLE")!=null?dadosImovel.get("IMO_COMPLE").toString():null);
							edr.setNumedr(dadosImovel.get("IMO_NUMERO")!=null?dadosImovel.get("IMO_NUMERO").toString():"");
							String tba = dadosImovel.get("IMO_TIPBAI") != null?dadosImovel.get("IMO_TIPBAI").toString():null;
							if(tba != null && tba.equalsIgnoreCase("RESIDENC")){
								tba = "RESIDENC.";
							} else if(tba != null && tba.equalsIgnoreCase("DESMEMB")){
								tba = "DESMEMBRAMENTO";
							}
							edr.setTbaedr(tba);
							edr.setBaiedr(dadosImovel.get("IMO_NOMBAI")!=null?dadosImovel.get("IMO_NOMBAI").toString():null);
							edr.setCepedr(dadosImovel.get("IMO_CEP")!=null?dadosImovel.get("IMO_CEP").toString():null);
							edr.setUffedr(dadosImovel.get("IMO_UF")!=null?dadosImovel.get("IMO_UF").toString():"");
							edr.setPaiedr(105L);
							edr.setTipedr("C"); //CONTADOR/CONTRIBUINTE
							edr.setMunedr("9051");
							codedr = (Long) new EdrDAO().insReg(edr);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						//INSERIR COLETA ENDERECO
						try {
							CenVO cen = new CenVO();
							Double area = null;
							if(dadosImovel.get("areaterreno") != null && dadosImovel.get("areaterreno").toString().replaceAll(" m�", "") != null){
								area = Double.parseDouble(dadosImovel.get("areaterreno").toString().replaceAll(" m�", ""));
							}
							cen.setAtecen(area); // areaTotalEmpreendimento
							area = null;
							if(dadosImovel.get("areaconstruida") != null && dadosImovel.get("areaconstruida").toString().replaceAll(" m�", "") != null){
								area = Double.parseDouble(dadosImovel.get("areaconstruida").toString().replaceAll(" m�", ""));
							}
							cen.setAutcen(area); // areaUtilizada
							cen.setIptcen(dadosImovel.get("IMO_COD").toString()); //inscricao imobiliaria
							cen.setEdrcen(codedr); // endereco
							codcen = (Long) new CenDAO().insReg(cen);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						//INSERIR COLETA
						viabilidade.getColeta().setCencol(codcen!=null?codcen.longValue():null);
						String objetoSocial = "";
						for (CnaVO atv : listAtvSel) {
							objetoSocial += atv.getDcoatv() + ";";
						}
						viabilidade.getColeta().setCoscol(objetoSocial);
						try {
							codcol = (Long) new ColDAO().insReg(viabilidade.getColeta());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						//INSERIR COLETA ATV ECON.
						for (CnaVO atv : listAtvSel) {
							CnaVO cna = new CnaVO();
							cna.setColcna(codcol);
							cna.setCodcna(Util.formataCnaeSemMascara(atv.getCodcna()));
							cna.setTipcna("C");
							cna.setExecna(atv.getExecna()); //exercida no local
							cna.setPricna(atv.getPrincipal()?1:0); //principal
							try {
								new CnaDAO().insReg(cna);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						//INSERIR COLETA TIPO UNIDADE FORMA ATUACAO
						if(isNaoAutonomo()){
							CfaVO cfa = new CfaVO();
							cfa.setColcfa(codcol);
							if(viabilidade.getColeta().getCtucol().equals("PRODUTIVA")){
								if(viabilidade.getColeta().getP1()){
									cfa.setCodcfa("01");
									new CfaDAO().insReg(cfa);
								}
								if(viabilidade.getColeta().getP2()){
									cfa.setCodcfa("02");
									new CfaDAO().insReg(cfa);
								}
								if(viabilidade.getColeta().getP3()){
									cfa.setCodcfa("03");
									new CfaDAO().insReg(cfa);
								}
								if(viabilidade.getColeta().getP4()){
									cfa.setCodcfa("04");
									new CfaDAO().insReg(cfa);
								}
								if(viabilidade.getColeta().getP5()){
									cfa.setCodcfa("05");
									new CfaDAO().insReg(cfa);
								}
								if(viabilidade.getColeta().getP6()){
									cfa.setCodcfa("06");
									new CfaDAO().insReg(cfa);
								}
								if(viabilidade.getColeta().getP7()){
									cfa.setCodcfa("07");
									new CfaDAO().insReg(cfa);
								}
							} else {
								cfa.setCodcfa(viabilidade.getColeta().getFormaAtuacaoAuxiliar());
								new CfaDAO().insReg(cfa);
							}
						}	
						viabilidade.setProvia(new ViaDAO().getProtocoloViabilidade());
						viabilidade.setMunvia("9051");
						viabilidade.setNjrvia(njrVO.getCodnjr().toString());
						//SALVAR REQUERENTE
						CadVO cad = getUsuario();
						if (cad != null) {
							ReqVO req = new ReqVO();
							req.setTipreq("C");
							req.setCpfreq(cad.getCpfcad());
							req.setLogreq(req.getCpfreq());
							req.setNomreq(cad.getNomcad());
							req.setDddreq(cad.getDdtcad());
							req.setTelreq(cad.getTelcad().replaceAll("[() -]", ""));
							req.setDdcreq(cad.getDdccad());
							req.setCelreq(cad.getCelcad()!=null&&(!cad.getCelcad().isEmpty())?cad.getCelcad().replaceAll("[() -]", ""):null);
							req.setEmareq(cad.getEmacad());
							try {
								codreq = (Long) new ReqDAO().insReg(req);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						} 
						viabilidade.setReqvia(codreq);
						viabilidade.setColvia(codcol);
						viabilidade.setOrevia("5"); //PMCG
						viabilidade.setCrevia("S");
						
						//SALVAR QUESTIONARIO
						respostas.setColres(codcol);
						new ResDAO().insReg(respostas);
						
						try {
							new ViaDAO().insReg(viabilidade);
							new ViaDAO().getSqlMap().commitTransaction();
							protocolo = viabilidade.getProvia();
							visibleDivCad = false;
							visibleDivRel = true;
							this.vincular();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						try {
							new ViaDAO().getSqlMap().endTransaction();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				Messagebox.show("N�o foi poss�vel salvar a simula��o! Uma ou mais atividades n�o permitidas.", "CIM", Messagebox.OK, Messagebox.INFORMATION);
			}
		}
	}
	
	public void atualizaNatureza() throws SQLException {
		if(viabilidade.getTipvia().equals("A")){
			njrVO = new NjrDAO().getRegByCodnjr("4081"); // "Contribuinte Individual"
			((Combobox) getComponente("cbNatu")).setDisabled(true);
		} else if(viabilidade.getTipvia().equals("M")){
			njrVO = new NjrDAO().getRegByCodnjr("2135"); // "Empres�rio (Individual)"
			viabilidade.setTeqvia("MICRO_EMPRESA");
			((Combobox) getComponente("cbNatu")).setDisabled(true);
		} else {
			njrVO = null;
			((Combobox) getComponente("cbNatu")).setDisabled(false);
		}
		vincular();
	}
	
	public void atualizaAtividades() {
//		//Limpa a lista de atividades selecionadas
		listAtvSel = new ArrayList<CnaVO>();
//		//aplica o filtro de acordo com o tipo (empresa/mei/autonomo)
		pesquisaAtv();
	}
	
//	public void imprimeSimulacao() {
//		HashMap<String, String> param = new HashMap<String, String>();
//		param.put("provia", this.viabilidade.getProvia());
//		//tive que preencher todos os parametros abaixo pq com o redirecionamento estava perdendo o cainho do relatorio
//		new WinUtils().abrirBirt("viabilidade.rptdesign", param);
//	}
	
	public Boolean isVisibleAtv(){
		if(dadosImovel != null && dadosImovel.get("IMO_COD") != null){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleAtvSel(){
		if(listAtvSel != null && listAtvSel.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleSalvar(){
		if(viabilidade != null && viabilidade.getTipvia() != null && viabilidade.getTipvia().equals("A")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleSitAut(){ //controla a visibilidade do campo situa��o do aut�nomo
		if(viabilidade != null && viabilidade.getTipvia()!=null && viabilidade.getTipvia().equals("A")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleEmpInd(){ //controla a visibilidade do campo empreendedor individual
		if(viabilidade.getTipvia()!=null && viabilidade.getTipvia().equals("M")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isNaoEmpresa(){ //controla a visibilidade do campo empreendedor individual
		if(!(viabilidade.getTipvia()!= null && viabilidade.getTipvia().equals("E"))){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isAutonomo(){ //controla a visibilidade dos campos enquadramento e tipo de unidade
		if(viabilidade != null && viabilidade.getTipvia()!= null && viabilidade.getTipvia().equals("A")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isNaoAutonomo(){ //controla a visibilidade dos campos enquadramento e tipo de unidade
		return !isAutonomo();
	}
	
	public boolean isAutenticadoContador() {
		if (getSession().getAttribute("usuarioextcontador") != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleProdutiva(){
		if(viabilidade.getColeta() != null && viabilidade.getColeta().getCtucol() != null && viabilidade.getColeta().getCtucol().equals("PRODUTIVA")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleAuxiliar(){
		if(viabilidade.getColeta() != null && viabilidade.getColeta().getCtucol() != null && viabilidade.getColeta().getCtucol().equals("AUXILIAR")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean visibleQuest(){
		if((isAutonomo() && viabilidade.getSauvia() != null && viabilidade.getSauvia().equals("E")) || (isNaoAutonomo() && isVisibleProdutiva() && viabilidade.getColeta().getP1())){
			return true;
		} else {
			return false;
		}
	}
}
