package pmcg.imti.view.ext;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import pmcg.fcn.dao.ibatis.AatDAO;
import pmcg.fcn.dao.ibatis.AnxDAO;
import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CclDAO;
import pmcg.fcn.dao.ibatis.ConDAO;
import pmcg.fcn.dao.ibatis.EdrDAO;
import pmcg.fcn.dao.ibatis.RepDAO;
import pmcg.fcn.dao.ibatis.ReqDAO;
import pmcg.fcn.dao.ibatis.SadDAO;
import pmcg.fcn.dao.ibatis.SocDAO;
import pmcg.fcn.dao.ibatis.TabDAO;
import pmcg.fcn.dao.ibatis.UsoDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.AnxVO;
import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.CadVO;
import pmcg.fcn.domain.CclVO;
import pmcg.fcn.domain.ConVO;
import pmcg.fcn.domain.EdrVO;
import pmcg.fcn.domain.RepVO;
import pmcg.fcn.domain.ReqVO;
import pmcg.fcn.domain.SadVO;
import pmcg.fcn.domain.SocVO;
import pmcg.fcn.domain.TabVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.prefeitura.ClienteViabilidade;
import pmcg.framework.util.StringUtils;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.dao.ibatis.EstDAO;
import pmcg.imti.dao.ibatis.ImoDAO;
import pmcg.imti.dao.ibatis.NjrDAO;
import pmcg.imti.dao.ibatis.QlfDAO;
import pmcg.imti.dao.ibatis.SinDAO;
import pmcg.imti.dao.ibatis.TipDAO;
import pmcg.imti.domain.EstVO;
import pmcg.imti.domain.QlfVO;
import pmcg.imti.domain.SinVO;
import pmcg.imti.domain.TipVO;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;


public class Baecad extends Index{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ClienteViabilidade.class);
	public CadVO cadVO; //usuário logado - contador ou contribuinte
	public Boolean possuiRespCont = false;
	public ConVO respCont = new ConVO();
	public Boolean disableContador = false;
	public ViaVO via;
	public List<HashMap<String, Object>> listAtvAnalise;
	public BaeVO bae = new BaeVO();
	public HashMap<String, Object> dadosEndereco;
	public HashMap<String, Object> dadosZonaUsos;
	public HashMap<String, Object> dadosImovel;
	public String cep;
	public List<TabVO> listOrgReg; //Lista de orgaos de registro
	public List<TipVO> listTipLog = new ArrayList<TipVO>(); //Lista de tipos de logradouro
	public List<TipVO> listTipBai = new ArrayList<TipVO>(); //Lista de tipos de bairro
	public List<SinVO> listSindicato; //lista de sindicatos (CREA, CREF..)
	public SinVO sinSel; //Sindicato selecionado
	public List<EstVO> listUf; //lista de sindicatos (CREA, CREF..)
	public List<SadVO> listSad = new ArrayList<SadVO>(); //lista de Sócios
	public List<AnxVO> listAnx; //lista de anexos do BAE
	public SadVO sad = new SadVO(); //sócio/administrador
	public String capitalSocial = "R$ 0,00";
	public String participacao = "R$ 0,00";
	public List<QlfVO> listQlf; //lista de qualificacao de Sócio
	public QlfVO qlfSel; //qualificacao de Sócio selecionada
	public RepVO rep = new RepVO(); //Representante Legal do sócio/administrador
	public List<QlfVO> listQlfRep; //lista de qualificacao do representante
	public QlfVO qlfRep; //qualificacao do representante
	public List<TabVO> listEstCiv = new ArrayList<TabVO>(); //Lista de estado civil
	public List<TabVO> listNac = new ArrayList<TabVO>(); //Lista de nacionalidade
	public String confEmabae= ""; //Confirmacao email
	public Boolean edicao = false;
	
	public void initBae() throws SQLException, InterruptedException{
		Clients.evalJavaScript("formMoeda()");
		if(isNaoAutenticado()){
			desconectarUsuario();
		} else {
			if (getSession().getAttribute("viabae") != null) {
				Long iddvia = (Long) getSession().getAttribute("viabae");
				via = new ViaDAO().getRegByCod(iddvia);
				getSession().removeAttribute("viabae");
				if(via != null && via.getBaevia() != null){
					edicao = true;
					listAnx = new AnxDAO().getRegByDocTpd(new AnxVO(via.getBaevia(), "B"));
				} else {
					bae = new BaeVO();
				}
				
				sad.setSocio(new SocVO());
				sad.setEndereco(new EdrVO());
				rep.setEndereco(new EdrVO());
				listTipLog = new TipDAO().getRegByTipo("TLOG");
				listTipBai = new TipDAO().getRegByTipo("TBAIR");
				listSindicato = new SinDAO().getTodos(null);
				listUf = new EstDAO().getTodos(null);
				listOrgReg = new TabDAO().getRegByTipo("ORGRGSIAT");
				listEstCiv = new TabDAO().getRegByTipo("ESTCIV");
				listNac = new TabDAO().getRegByTipo("PAIS");
				retornaViabilidade(via.getProvia());
				
				cadVO = getUsuario();
				if(cadVO != null && cadVO.getCrccad() != null){
					//usuário logado é contador
					respCont.setCrccon(cadVO.getCrccad());
					respCont.setSnccon(cadVO.getScrcad());
					respCont.setTcrcon(cadVO.getTpccad());
					respCont.setDcrcon(cadVO.getDtrcad());
					respCont.setUfrcon(cadVO.getUfccad());
					respCont.setCpfcon(cadVO.getCpfcad());
					respCont.setNomcon(cadVO.getNomcad());
					EdrVO endCont = new EdrDAO().getRegByCod(cadVO.getEdrcad());
					respCont.setEndereco(endCont);
					disableContador = true;
					vincular();
				} else {
					respCont.setEndereco(new EdrVO());
				}
			} else {
				Messagebox.show("Selecione um protocolo na tela de Acompanhamento!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
			}
		}
	}
	
	public void retornaBae() throws SQLException {
		bae = new BaeDAO().getBaeByViabae(via.getProvia());
		//INSERIR REQUERENTE (NAO ATUALIZA)
		//INSERIR ENDEREÇO LOCALIZACAO
		//INSERIR ENDEREÇO CORRESPONDENCIA
		//INSERIR ENDEREÇO RESP. CONTABIL
		  //INSERIR RESP. CONTABIL
		//INSERIR BAE
		//INSERIR SOCIOS_ADM - MATRIZ
		  //INSERIR ENDEREÇO - SAD
		  //INSERIR SOCIO (só para gravar a participacao)
		  //INSERIR REPRESENTANTE LEGAL
		  //INSERIR ENDERECO REP LEGAL
		//ATUALIZAR VIABILIDADE
		
		//CONFERIR se realmente traz todas as informacoes do socio
//		listSad = new SadDAO().getRegByBae(bae.getIddbae());
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("duobae")).getItems())){
			EstVO est = (EstVO) item.getValue();
			if(est.getUnifed().equals(bae.getDuobae())){
				((Combobox) getComponente("duobae")).setSelectedItem(item);
				break;
			}
		}
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("pufbae")).getItems())){
			EstVO est = (EstVO) item.getValue();
			if(est.getUnifed().equals(bae.getPufbae())){
				((Combobox) getComponente("pufbae")).setSelectedItem(item);
				break;
			}
		}
		sinSel = new SinDAO().getSinBySigla(bae.getPsibae());
		if(bae.getConbae() != null){
			possuiRespCont = true;
			respCont = new ConDAO().getRegByCodComplex(bae.getConbae());
			respCont.setEndereco(new EdrDAO().getRegByCod(respCont.getEdrcon()));
		}
		bae.setEndCor(new EdrDAO().getRegByCod(bae.getEdcbae()));
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("uffedr")).getItems())){
			EstVO est = (EstVO) item.getValue();
			if(est.getUnifed().equals(bae.getEndCor().getUffedr())){
				((Combobox) getComponente("uffedr")).setSelectedItem(item);
				break;
			}
		}
		confEmabae = bae.getEmabae();
		vincular();
		
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("tloedrcor")).getItems())){
			TipVO tip = (TipVO) item.getValue();
			if(tip.getDescom().equals(bae.getEndCor().getTloedr())){
				((Combobox) getComponente("tloedrcor")).setSelectedItem(item);
				break;
			}
		}
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("tbaedrcor")).getItems())){
			TipVO tip = (TipVO) item.getValue();
			if(tip.getDescom().equals(bae.getEndCor().getTbaedr())){
				((Combobox) getComponente("tbaedrcor")).setSelectedItem(item);
				break;
			}
		}
		if(bae.getOrebae() != null){
			for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("orebae")).getItems())){
				TabVO tab = (TabVO) item.getValue();
				if(tab.getCodtab().equals(bae.getOrebae())){
					((Combobox) getComponente("orebae")).setSelectedItem(item);
					break;
				}
			}
		}
		
//		ConVO contador = new ConDAO().getRegByCodComplex((Long) baeSel.get("conbae"));
//		baeSel.put("respCont", contador);
//		listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) baeSel.get("iddbae"), "B"));
//		listCna = new CnaDAO().getRegByProvia(baeSel.get("viabae").toString());
//		listSad = new SadDAO().getSadByBae((Long) baeSel.get("iddbae"));
//		for(HashMap<String, Object> sad : listSad){
//			sad.put("listRep", new RepDAO().getRepBySad((Long) sad.get("iddsad")));
//		}
	}

	public void retornaViabilidade(String prot){
		try {
			if(via.getNjrvia().equals("4081")){
				bae.setTpebae("PF");
			} else {
				bae.setTpebae("PJ");
			}
			((Textbox) getComponente("njrvia")).setValue(new NjrDAO().getRegByCodnjr(via.getNjrvia()).getCodDescNjr());
			listQlf = new QlfDAO().getQlfByNjr(Long.parseLong(via.getNjrvia()));
			dadosEndereco = new ViaDAO().getDadosAnalise(prot);
			
			String inscricaoImobiliaria = Formatacao.zeroEsquerda(FormatUtils.onlyNumbers(dadosEndereco.get("iptcen").toString()),11);
			dadosZonaUsos = new UsoDAO().getZonasUsosByInscricao(inscricaoImobiliaria);
						
			dadosImovel = new ImoDAO().getDadosByInscricao(inscricaoImobiliaria);
			if(dadosImovel != null){
				String endereco = dadosImovel.get("IMO_TIPRUA").toString() + " " + dadosImovel.get("IMO_NOMRUA").toString() + ", " + dadosImovel.get("IMO_NUMERO").toString() + ".";
				String tba = dadosImovel.get("IMO_TIPBAI") != null?dadosImovel.get("IMO_TIPBAI").toString():null;
				if(tba != null && tba.equalsIgnoreCase("RESIDENC")){
					tba = "RESIDENC.";
				} else if(tba != null && tba.equalsIgnoreCase("DESMEMB")){
					tba = "DESMEMBRAMENTO";
				}
				dadosImovel.put("IMO_TIPBAI",tba);
				dadosImovel.put("endereco", endereco);
				dadosImovel.put("areaterreno", dadosImovel.get("ARETER").toString().replaceAll("Â", ""));
				dadosImovel.put("areaconstruida", dadosImovel.get("IMO_CONSTRUCAO")!=null?dadosImovel.get("IMO_CONSTRUCAO").toString().replaceAll("Â", ""):"");
				dadosImovel.put("areaunitaria", dadosImovel.get("AREUNI")!=null?dadosImovel.get("AREUNI").toString().replaceAll("Â", ""):"");
				if(dadosImovel.get("IMO_CEP") != null && (!dadosImovel.get("IMO_CEP").toString().isEmpty())){
					cep = dadosImovel.get("IMO_CEP").toString();
				} else {
					cep = dadosEndereco.get("cep").toString();
				}
			} else {
				Messagebox.show("Inscrição Imobiliária Inválida!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
				dadosImovel = null;
				cep = null;
			}
			
			Boolean mei = false;
			if(dadosEndereco.get("tipvia") != null && dadosEndereco.get("tipvia").toString().equals("M")){
				mei = true;
			}
			Long iddaen = (Long) dadosEndereco.get("aenvia");
			if(iddaen != null){
				listAtvAnalise = new AatDAO().getAtividadesByAen(iddaen);
				for (HashMap<String, Object> atv :listAtvAnalise){
					atv.put("dcoatv", new CclDAO().getNomeByCNAE(new CclVO(atv.get("cnae").toString(), mei?"S":null)));
					if((Boolean) atv.get("exeaat")){
						atv.put("exelocal", "SIM");
					} else {
						atv.put("exelocal", "NÃO");
					}
					atv.put("stylerisco", atv.get("stylerisco").toString().replaceAll("font-size:11px;", ""));
				}
			} 
			vincular();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Messagebox.show("Não foi possível retornar os dados da viabilidade! " + e.getMessage());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void copiarEndLoc(){
		EdrVO edr = new EdrVO();
		edr.setCepedr(cep);
		if(dadosImovel!=null){
			if(dadosImovel.get("IMO_UF") != null){
				for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("uffedr")).getItems())){
					EstVO est = (EstVO) item.getValue();
					if(est.getUnifed().equals(dadosImovel.get("IMO_UF").toString())){
						((Combobox) getComponente("uffedr")).setSelectedItem(item);
						break;
					}
				}
			}
			if(dadosImovel.get("IMO_TIPRUA") != null){
				for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("tloedrcor")).getItems())){
					TipVO tip = (TipVO) item.getValue();
					if(tip.getDescom().equals(dadosImovel.get("IMO_TIPRUA").toString())){
						((Combobox) getComponente("tloedrcor")).setSelectedItem(item);
						break;
					}
				}
			}
			if(dadosImovel.get("IMO_TIPBAI") != null){
				for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("tbaedrcor")).getItems())){
					TipVO tip = (TipVO) item.getValue();
					if(tip.getDescom().equals(dadosImovel.get("IMO_TIPBAI").toString())){
						((Combobox) getComponente("tbaedrcor")).setSelectedItem(item);
						break;
					}
				}
			}
			edr.setMunedr(dadosImovel.get("IMO_CIDADE")!=null?dadosImovel.get("IMO_CIDADE").toString():null);
			edr.setNloedr(dadosImovel.get("IMO_NOMRUA")!=null?dadosImovel.get("IMO_NOMRUA").toString():null);
			edr.setNumedr(dadosImovel.get("IMO_NUMERO")!=null?dadosImovel.get("IMO_NUMERO").toString():null);
			edr.setComedr(dadosImovel.get("IMO_COMPLE")!=null?dadosImovel.get("IMO_COMPLE").toString():null);
			edr.setBaiedr(dadosImovel.get("IMO_NOMBAI")!=null?dadosImovel.get("IMO_NOMBAI").toString():null);
		}
		bae.setEndCor(edr);
		vincular();
	}
	
	public void trataVO(){
		if(bae.getCpfbae() == null || FormatUtils.onlyNumbers(bae.getCpfbae()).isEmpty()){
			throw new WrongValueException(getComponente("cpfbae"),"Informe o CPF/CNPJ!");
		}
		String cpfcnpj = FormatUtils.onlyNumbers(bae.getCpfbae());
		if(isPF()){
			if(cpfcnpj.length() != 11 || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
				throw new WrongValueException(getComponente("cpfbae"),"CPF inválido!");
			}
		} else {
			if(cpfcnpj.length() != 14 || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
				throw new WrongValueException(getComponente("cpfbae"),"CNPJ inválido!");
			}
		}
		if(bae.getNombae() == null || bae.getNombae().isEmpty()){
			throw new WrongValueException(getComponente("nombae"),"Informe o Nome/Razão Social!");
		}
		if(isPJ()){
			if(bae.getNfabae() == null || bae.getNfabae().isEmpty()){
				throw new WrongValueException(getComponente("nfabae"),"Informe o Nome Fantasia!");
			}
			if(((Combobox) getComponente("orebae")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("orebae"),"Informe o Órgão de Registro!");
			}
			bae.setOrebae(((TabVO) ((Combobox) getComponente("orebae")).getSelectedItem().getValue()).getCodtab());
			if(((TabVO)((Combobox) getComponente("orebae")).getSelectedItem().getValue()).getDestab().equals("CARTÓRIO")){
				if(bae.getLivbae() == null || bae.getLivbae().isEmpty()){
					throw new WrongValueException(getComponente("livbae"),"Informe o Livro!");
				}
				if(bae.getFolbae() == null || bae.getFolbae().isEmpty()){
					throw new WrongValueException(getComponente("folbae"),"Informe a Folha!");
				}
			} else if(((TabVO)((Combobox) getComponente("orebae")).getSelectedItem().getValue()).getDestab().equals("JUNTA COMERCIAL")){
				if(bae.getNirbae() == null || bae.getNirbae().isEmpty()){
					throw new WrongValueException(getComponente("nirbae"),"Informe o NIRE!");
				}
			} else {
				if((bae.getNrrbae() == null || bae.getNrrbae().isEmpty()) && (bae.getNirbae() == null || bae.getNirbae().isEmpty())){
					throw new WrongValueException(getComponente("nrrbae"),"Informe o Número de Registro e/ou NIRE!");
				}
			}
			if(bae.getDtrbae() == null){
				throw new WrongValueException(getComponente("dtrbae"),"Informe a Data de Registro!");
			}
			if(capitalSocial == null || capitalSocial.replaceAll("[R$ ]", "").isEmpty() || capitalSocial.replaceAll("[R$ ]", "").equals("0,00")){
				throw new WrongValueException(getComponente("capbae"),"Informe o Capital Social!");
			}
			bae.setCapbae(Double.parseDouble(capitalSocial.replaceAll("[R$ .]", "").replace(",", ".")));
		} else {
			//PESSOA FISICA
			if(bae.getDnabae() == null){
				throw new WrongValueException(getComponente("dnabae"),"Informe a Data de Nascimento!");
			}
			if(bae.getSexbae() == null){
				throw new WrongValueException(getComponente("sexbae"),"Informe o Sexo!");
			}
			if(bae.getNivbae() == null){
				throw new WrongValueException(getComponente("nivbae"),"Informe o Nível Escolar!");
			}
			if(bae.getNivbae() != null && bae.getNivbae().equals("S") && bae.getDtcbae() == null){
				throw new WrongValueException(getComponente("dtcbae"),"Informe a Data de Colação de Grau!");
			}
			if(bae.getDtpbae() == null){
				throw new WrongValueException(getComponente("dtpbae"),"Informe o Tipo de Documento de Identificação!");
			}
			if(bae.getDnrbae() == null){
				throw new WrongValueException(getComponente("dnrbae"),"Informe o Número do Documento de Identificação!");
			}
			if(bae.getDoebae() == null){
				throw new WrongValueException(getComponente("doebae"),"Informe o Órgão Expedidor do Documento de Identificação!");
			}
			if(((Combobox) getComponente("duobae")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("duobae"),"Informe a UF do Órgão Expedidor!");
			}
			bae.setDuobae(((EstVO) ((Comboitem)((Combobox) getComponente("duobae")).getSelectedItem()).getValue()).getUnifed());
			if(bae.getDexbae()== null){
				throw new WrongValueException(getComponente("dexbae"),"Informe a Data de Expedição!");
			}
			if(bae.getNivbae() != null && bae.getNivbae().equals("S")){
				if(sinSel == null){
					throw new WrongValueException(getComponente("psibae"),"Informe o Registro Profissional/Conselho!");
				}
				bae.setPsibae(sinSel.getSigla());
				if(bae.getPnrbae() == null || bae.getPnrbae().isEmpty()){
					throw new WrongValueException(getComponente("pnrbae"),"Informe o Número do Registro Profissional/Conselho!");
				}
				if(((Combobox) getComponente("pufbae")).getSelectedItem() == null){
					throw new WrongValueException(getComponente("pufbae"),"Informe a UF do Registro Profissional/Conselho!");
				}
				bae.setPufbae(((EstVO) ((Comboitem)((Combobox) getComponente("pufbae")).getSelectedItem()).getValue()).getUnifed());
				if(bae.getPdtbae()== null){
					throw new WrongValueException(getComponente("pdtbae"),"Informe a Data de Registro!");
				}
			}
		}
		if(bae.getEndCor() == null || (!Formatacao.isCEPValido(bae.getEndCor().getCepedr()))){
			throw new WrongValueException(getComponente("cepcor"),"Informe o CEP (Endereço de Correspondência - Empresa)!");
		}
		if(((Combobox) getComponente("uffedr")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("uffedr"),"Informe a UF (Endereço de Correspondência - Empresa)!");
		}
		bae.getEndCor().setUffedr(((EstVO) ((Comboitem)((Combobox) getComponente("uffedr")).getSelectedItem()).getValue()).getUnifed());
		if(bae.getEndCor().getMunedr() == null || bae.getEndCor().getMunedr().isEmpty()){
			throw new WrongValueException(getComponente("munedr"),"Informe o Município (Endereço de Correspondência - Empresa)!");
		}
		if(((Combobox) getComponente("tloedrcor")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("tloedrcor"),"Informe Tipo de Logradouro (Endereço de Correspondência - Empresa)!");
		}
		bae.getEndCor().setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tloedrcor")).getSelectedItem()).getValue()).getDescom());
		if(bae.getEndCor().getNloedr() == null || bae.getEndCor().getNloedr().isEmpty()){
			throw new WrongValueException(getComponente("nloedrcor"),"Informe o Logradouro (Endereço de Correspondência - Empresa)!");
		}
		if(Formatacao.isNullOrEmpty(bae.getEndCor().getNumedr())){
			throw new WrongValueException(getComponente("numedrcor"),"Informe o Número (Endereço de Correspondência - Empresa)!");
		}
		if(((Combobox) getComponente("tbaedrcor")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("tbaedrcor"),"Informe Tipo de Bairro (Endereço de Correspondência - Empresa)!");
		}
		bae.getEndCor().setTbaedr(((TipVO) ((Comboitem)((Combobox) getComponente("tbaedrcor")).getSelectedItem()).getValue()).getDescom());
		if(Formatacao.isNullOrEmpty(bae.getEndCor().getBaiedr())){
			throw new WrongValueException(getComponente("baiedrcor"),"Informe o Bairro (Endereço de Correspondência - Empresa)!");
		}
		if((Formatacao.isNullOrEmpty(bae.getDdtbae()) || Formatacao.isNullOrEmpty(bae.getTelbae())) &&
				(Formatacao.isNullOrEmpty(bae.getDdfbae()) || Formatacao.isNullOrEmpty(bae.getFaxbae())) &&
				(Formatacao.isNullOrEmpty(bae.getDdcbae()) || Formatacao.isNullOrEmpty(bae.getCelbae()))){
			throw new WrongValueException(getComponente("ddtbae"),"Informe pelo menos um telefone (Endereço de Correspondência - Empresa)!");
		}
		if(Formatacao.isNullOrEmpty(bae.getEmabae())){
			throw new WrongValueException(getComponente("emabae"),"Informe o E-mail (Endereço de Correspondência - Empresa)!");
		}
		if(Formatacao.isNullOrEmpty(confEmabae)){
			throw new WrongValueException(getComponente("confemabae"),"Informe a Confirmação do E-mail (Endereço de Correspondência - Empresa)!");
		}
		if(!bae.getEmabae().equals(confEmabae)){
			throw new WrongValueException(getComponente("emabae"),"E-mail não confere com a (Endereço de Correspondência - Empresa)!");
		}
		if(possuiRespCont){
			if(((Combobox) getComponente("tiporespcont")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("tiporespcont"),"Informe Tipo de Responsável Contábil!");
			}
			if(isEnableContador()){
				if(Formatacao.isNullOrEmpty(respCont.getCrccon())){
					throw new WrongValueException(getComponente("numcrc"),"Informe a Número CRC (Responsável Contábil)!");
				}
				if(Formatacao.isNullOrEmpty(respCont.getSnccon())){
					throw new WrongValueException(getComponente("signumcrc"),"Informe a Sigla do Número CRC (Responsável Contábil)!");
				}
				if(Formatacao.isNullOrEmpty(respCont.getTcrcon())){
					throw new WrongValueException(getComponente("tipocrc"),"Informe o Tipo CRC (Responsável Contábil)!");
				}
				if(respCont.getDcrcon() == null){
					throw new WrongValueException(getComponente("datcrc"),"Informe a Data de Registro (Responsável Contábil)!");
				}
				if(Formatacao.isNullOrEmpty(respCont.getUfrcon())){
					throw new WrongValueException(getComponente("ufrcon"),"Informe a UF de Registro (Responsável Contábil)!");
				}
				if(Formatacao.isNullOrEmpty(respCont.getCpfcon())){
					throw new WrongValueException(getComponente("cpfcont"),"Informe o CPF/CNPJ (Responsável Contábil)!");
				}
				if(Formatacao.isNullOrEmpty(respCont.getNomcon())){
					throw new WrongValueException(getComponente("nomcont"),"Informe o NOme / Razão Social (Responsável Contábil)!");
				}
				if(respCont.getEndereco() == null || (!Formatacao.isCEPValido(respCont.getEndereco().getCepedr()))){
					throw new WrongValueException(getComponente("cepcont"),"Informe o CEP (Endereço do Responsável Contábil)!");
				}
				if(((Combobox) getComponente("uffedrcont")).getSelectedItem() == null){
					throw new WrongValueException(getComponente("uffedrcont"),"Informe a UF (Endereço do Responsável Contábil)!");
				}
				respCont.getEndereco().setUffedr(((EstVO) ((Comboitem)((Combobox) getComponente("uffedrcont")).getSelectedItem()).getValue()).getUnifed());
				if(Formatacao.isNullOrEmpty(respCont.getEndereco().getMunedr())){
					throw new WrongValueException(getComponente("muncont"),"Informe o Município (Endereço do Responsável Contábil)!");
				}
				if(((Combobox) getComponente("tloedrcont")).getSelectedItem() == null){
					throw new WrongValueException(getComponente("tloedrcont"),"Informe Tipo de Logradouro (Endereço do Responsável Contábil)!");
				}
				respCont.getEndereco().setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tloedrcont")).getSelectedItem()).getValue()).getDescom());
				if(respCont.getEndereco().getNloedr() == null || respCont.getEndereco().getNloedr().isEmpty()){
					throw new WrongValueException(getComponente("nlocont"),"Informe o Logradouro (Endereço do Responsável Contábil)!");
				}
				if(Formatacao.isNullOrEmpty(respCont.getEndereco().getNumedr())){
					throw new WrongValueException(getComponente("numcont"),"Informe o Número (Endereço do Responsável Contábil)!");
				}
				if(((Combobox) getComponente("tbaedrcont")).getSelectedItem() == null){
					throw new WrongValueException(getComponente("tbaedrcont"),"Informe Tipo de Bairro (Endereço do Responsável Contábil)!");
				}
				respCont.getEndereco().setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tbaedrcont")).getSelectedItem()).getValue()).getDescom());
				if(Formatacao.isNullOrEmpty(respCont.getEndereco().getBaiedr())){
					throw new WrongValueException(getComponente("baicont"),"Informe o Bairro (Endereço do Responsável Contábil)!");
				}
			}
		}
		if(isPJ() && (listSad == null || listSad.size() <= 0)){
			throw new WrongValueException(getComponente("tipsad"),"Informe o(s) Sócio(s)/Administrador(es)!");
		}
		if(isPJ() && listSad != null && listSad.size() > 0 && (!via.getNjrvia().equals("3220")) && (!via.getNjrvia().equals("3131"))){
			BigDecimal somaParticipacao = new BigDecimal("0.0");
			for(SadVO sd : listSad){
				if(sd.getSocio() != null && sd.getSocio().getParsoc() != null){
					BigDecimal participacao = new BigDecimal(sd.getSocio().getParsoc().replaceAll("[R$ .]", "").replace(",", "."));
					somaParticipacao = somaParticipacao.add(participacao);
				}
			}
			if(somaParticipacao.compareTo(new BigDecimal(capitalSocial.replaceAll("[R$ .]", "").replace(",", "."))) != 0){
				throw new WrongValueException(getComponente("capbae"),"O somatório do Valor de Participação dos sócios não confere com o Capital Social!");
			}
		}
		EstVO uffedr = (EstVO) ((Combobox) getComponente("uffedr")).getSelectedItem().getValue();
		bae.getEndCor().setUffedr(uffedr.getUnifed());
		
		Boolean nivelSuperior = false;
		if(via.getNjrvia().equals("4081")){
			for (HashMap<String, Object> atv : listAtvAnalise) {
				Integer qtdNivSup = new EcoDAO().getOcpNivSup(atv.get("cnae").toString());
				if(qtdNivSup > 0){
					nivelSuperior = true;
				}
			}
		}
		if(nivelSuperior && !bae.getNivbae().equals("S")){
			throw new WrongValueException(getComponente("nivbae"),"Existe uma ou mais atividades que exigem Grau de Escolaridade 'Nível Superior'!");
		}
		
		bae.setCpfbae(FormatUtils.onlyNumbers(bae.getCpfbae()));
		bae.setDdtbae(FormatUtils.onlyNumbers(bae.getDdtbae()));
		bae.setTelbae(FormatUtils.onlyNumbers(bae.getTelbae()));
		bae.setDdfbae(FormatUtils.onlyNumbers(bae.getDdfbae()));
		bae.setFaxbae(FormatUtils.onlyNumbers(bae.getFaxbae()));
		bae.setDdcbae(FormatUtils.onlyNumbers(bae.getDdcbae()));
		bae.setCelbae(FormatUtils.onlyNumbers(bae.getCelbae()));
	}
	
	public void salvar() throws SQLException, InterruptedException{
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Salvar as alterações?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				// A FAZER - ATUALZIAR OS REGISTROS EM VEZ DE SALVAR TUDO NOVAMENTE
//				if(bae.getIddbae() != null){
					//UPDATE
					//ENDEREÇO CORRESPONDENCIA
					//ENDEREÇO RESP. CONTABIL
					  //RESP. CONTABIL
					//BAE
					//SOCIOS_ADM - MATRIZ
					  //ENDEREÇO - SAD
					  //SOCIO (só para gravar a participacao)
					  //REPRESENTANTE LEGAL
					  //ENDERECO REP LEGAL
					
//				} else {
					//INSERT
					new BaeDAO().getSqlMap().startTransaction();
					Long iddreq = null, iddedrloc = null, iddedrcor = null, iddedrsad = null, iddcon = null, iddedrcon = null;
					Long iddsad = null, iddedrrep = null;
					
					//INSERIR REQUERENTE
					ReqVO req = new ReqVO();
					req.setTipreq("B");
					req.setLogreq(cadVO.getCpfcad());
					req.setNomreq(cadVO.getNomcad());
					req.setCpfreq(cadVO.getCpfcad());
					req.setDddreq(cadVO.getDdtcad());
					req.setTelreq(cadVO.getTelcad());
					req.setDdcreq(cadVO.getDdccad());
					req.setCelreq(cadVO.getCelcad());
					req.setEmareq(cadVO.getEmacad());
					try {
						iddreq = (Long) new ReqDAO().insReg(req);
					} catch (SQLException e) {
						logger.error("Erro ao Salvar REQ");
						e.printStackTrace();
					}
					
					//INSERIR ENDEREÇO LOCALIZACAO
					bae.setIptbae(dadosEndereco.get("iptcen").toString());
					EdrVO edr = new EdrVO();
					edr.setTipedr("B");
					edr.setTloedr(dadosImovel.get("IMO_TIPRUA")!=null?dadosImovel.get("IMO_TIPRUA").toString():null);
					edr.setNloedr(dadosImovel.get("IMO_NOMRUA")!=null?dadosImovel.get("IMO_NOMRUA").toString():null);
					edr.setComedr(dadosImovel.get("IMO_COMPLE")!=null?dadosImovel.get("IMO_COMPLE").toString():null);
					edr.setNumedr(dadosImovel.get("IMO_NUMERO")!=null?dadosImovel.get("IMO_NUMERO").toString():null);
					edr.setTbaedr(dadosImovel.get("IMO_TIPBAI")!=null?dadosImovel.get("IMO_TIPBAI").toString():null);
					edr.setBaiedr(dadosImovel.get("IMO_NOMBAI")!=null?dadosImovel.get("IMO_NOMBAI").toString():null);
					edr.setCepedr(cep);
					edr.setUffedr(dadosImovel.get("IMO_NOMBAI")!=null?dadosImovel.get("IMO_UF").toString():null);
					edr.setPaiedr(105L);
					edr.setMunedr(dadosImovel.get("MUN_ID")!=null?dadosImovel.get("MUN_ID").toString():null);
					try {
						iddedrloc = (Long) new EdrDAO().insReg(edr);
					} catch (SQLException e) {
						logger.error("Erro ao Salvar ENDEREÇO LOCALIZACAO");
						e.printStackTrace();
					}
					
					//INSERIR ENDEREÇO CORRESPONDENCIA
					edr = bae.getEndCor();
					edr.setTipedr("B");
					try {
						iddedrcor = (Long) new EdrDAO().insReg(edr);
					} catch (SQLException e) {
						logger.error("Erro ao Salvar ENDEREÇO CORRESPONDENCIA");
						e.printStackTrace();
					}
					
					//INSERIR ENDEREÇO RESP. CONTABIL
					if(possuiRespCont){
						edr = respCont.getEndereco();
						edr.setTipedr("B");
						try {
							iddedrcon = (Long) new EdrDAO().insReg(edr);
						} catch (SQLException e) {
							logger.error("Erro ao Salvar ENDEREÇO RESP. CONTABIL");
							e.printStackTrace();
						}
						
						//INSERIR RESP. CONTABIL
						respCont.setEdrcon(iddedrcon);
						iddcon = (Long) new ConDAO().insReg(respCont);
						bae.setConbae(iddcon);
					}
					
					//INSERIR BAE
					bae.setReqbae(iddreq);
					bae.setEdlbae(iddedrloc);
					bae.setEdcbae(iddedrcor);
					bae.setViabae(via.getProvia());
					bae.setUsualt(req.getCpfreq());
					Long iddbae = (Long) new BaeDAO().insReg(bae);
					
					//INSERIR SOCIOS_ADM - MATRIZ
					if(listSad != null && listSad.size() > 0){
						for(SadVO socio : listSad){
							Long iddsoc = null;
							//INSERIR ENDEREÇO - SAD
							EdrVO edrsad = socio.getEndereco();
							edrsad.setTipedr("B");
							try {
								iddedrsad = (Long) new EdrDAO().insReg(edrsad);
							} catch (SQLException e) {
								logger.error("Erro ao Salvar ENDEREÇO SAD");
								e.printStackTrace();
							}
							
							//INSERIR SOCIO (só para gravar a participacao)
							SocVO soc = socio.getSocio();
							soc.setParsoc(soc.getParsoc()!=null?soc.getParsoc().replaceAll("[R$ .,]", ""):null);
							if(soc != null && soc.getParsoc() != null){
								try {
									iddsoc = (Long) new SocDAO().insReg(soc);
								} catch (SQLException e) {
									logger.error("Erro ao Salvar SOC-SAD-Matriz");
									e.printStackTrace();
								}
							}
							
							socio.setEndsad(iddedrsad);
							socio.setSocsad(iddsoc != null?iddsoc:null);
							socio.setBaesad(iddbae);
							try {
								iddsad = (Long) new SadDAO().insReg(socio);
							} catch (SQLException e) {
								logger.error("Erro ao Salvar SAD");
								e.printStackTrace();
							}
							
							//INSERIR REPRESENTANTE LEGAL
							if(socio.getPossuiRep() && socio.getRepsVO().getRepsLegais() != null && socio.getRepsVO().getRepsLegais().size() > 0){
								RepVO repsad = socio.getRepsVO().getRepsLegais().get(0); //POIS SÒ PERMITE 1
								//INSERIR ENDERECO REP LEGAL
								EdrVO edrrep = repsad.getEndereco();
								edrrep.setTipedr("B");
								try {
									iddedrrep = (Long) new EdrDAO().insReg(edrrep);
								} catch (SQLException e) {
									logger.error("Erro ao Salvar EDR-REP-SAD");
									e.printStackTrace();
								}
								repsad.setSadrep(iddsad);
								repsad.setEndrep(iddedrrep);
								try {
									new RepDAO().insReg(repsad);
								} catch (SQLException e) {
									logger.error("Erro ao Salvar CNA_Matriz");
									e.printStackTrace();
								}
							}
						}
					}
					
					//INSERIR ANEXOS DO BAE ANTIGO
					if(listAnx != null && listAnx.size() > 0){
						for(AnxVO anx : listAnx){
							AnxVO anexo = new AnxVO();
							anexo.setDocanx(iddbae);
							anexo.setTpdanx("B");
							anexo.setArqanx(anx.getArqanx());
							anexo.setDesanx(anx.getDesanx());
							anexo.setNomanx(anx.getNomanx());
							anexo.setUsualt(anx.getUsualt());
							new AnxDAO().insReg(anexo);
						}
					}
					
					//ATUALIZAR VIABILIDADE
					via.setBaevia(iddbae);
					new ViaDAO().updBaeByIdd(via);
					new BaeDAO().getSqlMap().commitTransaction();
//				}
				Messagebox.show("Registro Salvo com sucesso! ATENÇÃO!!! TODOS OS DOCUMENTOS QUE COMPROVEM OS DADOS INFORMADOS NO BAE DEVEM SER DIGITALIZADOS E ANEXADOS AO PROCOLO NA TELA 'ACOMPANHAMENTO'!");
				redirecionarTela("/acompanhamento.zul");
			} catch (SQLException e) {
				e.printStackTrace();
				Messagebox.show("Não foi possível salvar os dados do BAE! " + e.getMessage());
			} finally {
				new BaeDAO().getSqlMap().endTransaction();
			}
		}
	}
	
	public void addSad(){
		if(sad.getTipsad() == null){
			throw new WrongValueException(getComponente("tipsad"),"Informe o Tipo de Pessoa do Sócio/Administrador!");
		}
		if(sad.getCpfsad() == null || FormatUtils.onlyNumbers(sad.getCpfsad()).isEmpty()){
			throw new WrongValueException(getComponente("cnpsad"),"Informe o CPF/CNPJ do Sócio/Administrador!");
		}
		String cpfcnpj = FormatUtils.onlyNumbers(sad.getCpfsad());
		if(isSadPF()){
			if(cpfcnpj.length() != 11 || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
				throw new WrongValueException(getComponente("cnpsad"),"CPF do Sócio/Administrador inválido!");
			}
		} else {
			if(cpfcnpj.length() != 14 || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
				throw new WrongValueException(getComponente("cnpsad"),"CNPJ do Sócio/Administrador inválido!");
			}
		}
		if(sad.getNomsad() == null || sad.getNomsad().isEmpty()){
			throw new WrongValueException(getComponente("nomsad"),"Informe o Nome/Razão Social do Sócio/Administrador!");
		}
		sad.setNomsad(sad.getNomsad().toUpperCase());
		if(isSadPF()){
			if(((Combobox) getComponente("estsad")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("estsad"),"Informe o Estado Civil do Sócio/Administrador!");
			}
			sad.setEstsad(Long.parseLong(((TabVO) ((Combobox) getComponente("estsad")).getSelectedItem().getValue()).getCodtab()));
			if(((Combobox) getComponente("nacsad")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("nacsad"),"Informe a Nacionalidade do Sócio/Administrador!");
			}
			sad.setNacsad(Long.parseLong(((TabVO) ((Combobox) getComponente("nacsad")).getSelectedItem().getValue()).getCodtab()));
			if(sad.getNpasad() == null || sad.getNpasad().isEmpty()){
				throw new WrongValueException(getComponente("npasad"),"Informe o Nome do Pai do Sócio/Administrador!");
			}
			sad.setNpasad(sad.getNpasad().toUpperCase());
			if(sad.getNmasad() == null || sad.getNmasad().isEmpty()){
				throw new WrongValueException(getComponente("nmasad"),"Informe o Nome da Mãe do Sócio/Administrador!");
			}
			sad.setNmasad(sad.getNmasad().toUpperCase());
			if(sad.getDnasad() == null){
				throw new WrongValueException(getComponente("dnasad"),"Informe a Data de Nascimento do Sócio/Administrador!");
			}
			if(sad.getSexsad() == null || sad.getSexsad().isEmpty()){
				throw new WrongValueException(getComponente("sexsad"),"Informe o Sexo do Sócio/Administrador!");
			}
			//documento
			if(sad.getTdcsad() == null || sad.getTdcsad().isEmpty()){
				throw new WrongValueException(getComponente("tdcsad"),"Informe o Tipo de Documento do Sócio/Administrador!");
			}
			if(sad.getIdesad() == null || sad.getIdesad().isEmpty()){
				throw new WrongValueException(getComponente("idesad"),"Informe o Número do Documento do Sócio/Administrador!");
			}
			if(sad.getOemsad() == null || sad.getOemsad().isEmpty()){
				throw new WrongValueException(getComponente("oemsad"),"Informe o Órgão Expedidor do Documento do Sócio/Administrador!");
			}
			if(((Combobox) getComponente("ufosad")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("ufosad"),"Informe a UF do Órgão Expedidor do Sócio/Administrador!");
			}
			sad.setUfosad(((EstVO) ((Combobox) getComponente("ufosad")).getSelectedItem().getValue()).getUnifed());
		} 
		if(qlfSel == null || qlfSel.getCodqlf() == null){
			throw new WrongValueException(getComponente("qualif"),"Informe a Qualificação do Sócio/Administrador!");
		}
		sad.setQsisad(qlfSel.getCodqlf().toString());
		if(qlfSel.getTempar().equals("S") && (participacao == null || participacao.replaceAll("[R$ ]", "").isEmpty() || participacao.replaceAll("[R$ ]", "").equals("0,00"))){
			throw new WrongValueException(getComponente("parsoc"),"Informe a Participação do Sócio/Administrador!");
		}
		if(qlfSel.getTempar().equals("S")){
			sad.getSocio().setParsoc(participacao.toString());
		}
		if(sad.getEndereco() == null || (!Formatacao.isCEPValido(sad.getEndereco().getCepedr()))){
			throw new WrongValueException(getComponente("cepsad"),"Informe o CEP (Endereço do Sócio / Administrador)!");
		}
		if(((Combobox) getComponente("uffedrsad")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("uffedrsad"),"Informe a UF (Endereço do Sócio / Administrador)!");
		}
		sad.getEndereco().setUffedr(((EstVO) ((Comboitem)((Combobox) getComponente("uffedrsad")).getSelectedItem()).getValue()).getUnifed());
		if(sad.getEndereco().getMunedr() == null || sad.getEndereco().getMunedr().isEmpty()){
			throw new WrongValueException(getComponente("munsad"),"Informe o Município (Endereço do Sócio / Administrador)!");
		}
		if(((Combobox) getComponente("tloedrsad")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("tloedrsad"),"Informe Tipo de Logradouro (Endereço do Sócio / Administrador)!");
		}
		sad.getEndereco().setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tloedrsad")).getSelectedItem()).getValue()).getDescom());
		if(sad.getEndereco().getNloedr() == null || sad.getEndereco().getNloedr().isEmpty()){
			throw new WrongValueException(getComponente("nlosad"),"Informe o Logradouro (Endereço do Sócio / Administrador)!");
		}
		if(Formatacao.isNullOrEmpty(sad.getEndereco().getNumedr())){
			throw new WrongValueException(getComponente("numsad"),"Informe o Número (Endereço do Sócio / Administrador)!");
		}
		if(((Combobox) getComponente("tbaedrsad")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("tbaedrsad"),"Informe Tipo de Bairro (Endereço do Sócio / Administrador)!");
		}
		sad.getEndereco().setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tbaedrsad")).getSelectedItem()).getValue()).getDescom());
		if(Formatacao.isNullOrEmpty(sad.getEndereco().getBaiedr())){
			throw new WrongValueException(getComponente("baisad"),"Informe o Bairro (Endereço do Sócio / Administrador)!");
		}
		if(sad.getPossuiRep()){
			if(rep.getCpfrep() == null || FormatUtils.onlyNumbers(rep.getCpfrep()).isEmpty()){
				throw new WrongValueException(getComponente("cpfrep"),"Informe o CPF do Representante do Sócio/Administrador!");
			}
			String cpfcnpjrep = FormatUtils.onlyNumbers(rep.getCpfrep());
			if((cpfcnpjrep.length() != 11) || (!StringUtils.valida_CpfCnpj(cpfcnpjrep))){
				throw new WrongValueException(getComponente("cpfrep"),"CPF do Representante do Sócio/Administrador inválido!");
			}
			if(cpfcnpjrep.equals(cpfcnpj)){
				throw new WrongValueException(getComponente("cpfrep"),"CPF do Representante igual ao CPF do Sócio/Administrador!");
			}
			if(rep.getNomrep() == null || rep.getNomrep().isEmpty()){
				throw new WrongValueException(getComponente("nomrep"),"Informe o Nome/Razão Social do Representante do Sócio/Administrador!");
			}
			if(qlfRep == null || qlfRep.getCodqlf() == null){
				throw new WrongValueException(getComponente("qualifRep"),"Informe a Qualificação do Representante do Sócio/Administrador!");
			}
			rep.setQsirep(qlfRep.getCodqlf().toString());
			if(rep.getEndereco() == null || (!Formatacao.isCEPValido(rep.getEndereco().getCepedr()))){
				throw new WrongValueException(getComponente("ceprep"),"Informe o CEP (Endereço do Representante)!");
			}
			if(((Combobox) getComponente("uffedrrep")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("uffedrrep"),"Informe a UF (Endereço do Representante)!");
			}
			rep.getEndereco().setUffedr(((EstVO) ((Comboitem)((Combobox) getComponente("uffedrrep")).getSelectedItem()).getValue()).getUnifed());
			if(rep.getEndereco().getMunedr() == null || rep.getEndereco().getMunedr().isEmpty()){
				throw new WrongValueException(getComponente("munrep"),"Informe o Município (Endereço do Representante)!");
			}
			if(((Combobox) getComponente("tloedrrep")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("tloedrrep"),"Informe Tipo de Logradouro (Endereço do Representante)!");
			}
			rep.getEndereco().setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tloedrrep")).getSelectedItem()).getValue()).getDescom());
			if(rep.getEndereco().getNloedr() == null || rep.getEndereco().getNloedr().isEmpty()){
				throw new WrongValueException(getComponente("nlorep"),"Informe o Logradouro (Endereço do Representante)!");
			}
			if(Formatacao.isNullOrEmpty(rep.getEndereco().getNumedr())){
				throw new WrongValueException(getComponente("numrep"),"Informe o Número (Endereço do Representante)!");
			}
			if(((Combobox) getComponente("tbaedrrep")).getSelectedItem() == null){
				throw new WrongValueException(getComponente("tbaedrrep"),"Informe Tipo de Bairro (Endereço do Representante)!");
			}
			rep.getEndereco().setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tbaedrrep")).getSelectedItem()).getValue()).getDescom());
			if(Formatacao.isNullOrEmpty(rep.getEndereco().getBaiedr())){
				throw new WrongValueException(getComponente("bairep"),"Informe o Bairro (Endereço do Representante)!");
			}
			rep.getEndereco().setCepedr(FormatUtils.onlyNumbers(rep.getEndereco().getCepedr()));
			rep.setCpfrep(cpfcnpjrep);
			List<RepVO> reps = new ArrayList<RepVO>();
			reps.add(rep);
			sad.setRepresentantesLegais(reps);
		}
		sad.setDesqlf(qlfSel.getDesqlf().toUpperCase());
		sad.setCpfsad(cpfcnpj); //para remover a mascara
		sad.getEndereco().setCepedr(FormatUtils.onlyNumbers(sad.getEndereco().getCepedr()));
		if(isSadPJ()){
			sad.setCpfsad(null);
			sad.setCnpsad(cpfcnpj);
		}
		listSad.add(sad);
		sad = new SadVO();
		sad.setEndereco(new EdrVO());
		rep = new RepVO();
		rep.setEndereco(new EdrVO());
		((Combobox) getComponente("estsad")).setSelectedItem(null);
		((Combobox) getComponente("nacsad")).setSelectedItem(null);
		((Combobox) getComponente("sexsad")).setSelectedItem(null);
		qlfSel = null;
		participacao = "R$ 0,00";
		sad.setSocio(new SocVO());
		vincular();
	}
	
	public void atualizaQlfRep(){
		if(qlfSel != null){
			listQlfRep = new QlfDAO().getQlfRepresentanteByRepresentado(qlfSel.getCodqlf());
			if(listQlfRep != null && listQlfRep.size() > 0){
				((Checkbox) getComponente("checkRep")).setDisabled(false);
				qlfRep = listQlfRep.get(0);
			} else {
				sad.setPossuiRep(false);
				((Checkbox) getComponente("checkRep")).setDisabled(true);
			}
			vincular();
		}
	}
	
	public void removeSad(Listitem item){
		listSad.remove(item.getValue());
		vincular();
	}
	
	public Boolean isPF(){
		if(bae.getTpebae() != null && bae.getTpebae().equals("PF")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isPJ(){
		if(bae.getTpebae() != null && bae.getTpebae().equals("PJ")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isSadPF(){
		if(sad.getTipsad() != null && sad.getTipsad().equals("F")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isSadPJ(){
		if(sad.getTipsad() != null && sad.getTipsad().equals("J")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isNivelSuperior(){
		if(bae.getNivbae() != null && (bae.getNivbae().equals("S") || bae.getNivbae().equals("M"))){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleParsoc(){
		if(qlfSel != null){
			if(qlfSel.getTempar().equals("S")){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Boolean isEnableContador(){
		return !disableContador;
	}

}
