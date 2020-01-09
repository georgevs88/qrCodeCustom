package pmcg.imti.view.ext;

import java.sql.SQLException;

public class Constituicao extends Indexautonomo {

	private static final long serialVersionUID = 1L;
	
//	public ConVO conVO = new ConVO();
	public Integer progresso = 20; // Controle da barra de progresso
	public boolean p1 = true; // PASSO 1 - ENTRADA PROTOCOLO EFACIL
	public boolean p2 = false; // PASSO 2 - PROTOCOLO JUCEMS
	public boolean p3 = false; // PASSO 3 - SIMULAÇÃO
	public boolean p4 = false; // PASSO 4 - ATIVIDADES
	public boolean p5 = false; // PASSO 5 - QUESTIONÁRIO
	public boolean p6 = false; // PASSO 6 - RESUMO
	public boolean p7 = false; // PASSO 7 - PROTOCOLO
	// ---------- PASSO 1 --------------------
	public String nomeReq; 
	public String cpfReq;
	public String protSim; //ultimo protocolo simulacao
	// ---------- PASSO 2 --------------------
//	public String protJucems; //protocolo jucems
//	public String nomeEmp; //Nome empresarial pretendido
//	public String nomTit; //nome do titular
//	public String cpfTit; //cpf do titular
//	public String maeTit; //nome mae titular
//	public Boolean visibleTitular = false;
	// ---------- PASSO 3 --------------------
//	public SimVO simVO; //simulacao
//	public List<UsoVO> listUsosZona; //lista de usos da zona
//	// ---------- PASSO 4 --------------------
//	public String objetoSocial;
//	public List<AtsVO> listAtvSim; //lista de Atividades selecionadas
//	public AtsVO atvSel = new AtsVO(); //atividade selecionada da lista acima
//	public AtsVO atvPrincipal; //atividade principal
//	// ---------- PASSO 5 --------------------
//	public String listClasses; //lista de classes de cnae (9 primeiros digitos do codigo cnae) - irá ser utilizado como filtro para fazer a lista abaixo
//	public List<PerVO> listPerguntas; //lista de perguntas do questionário
//	// ---------- CONCLUIR --------------------
//	public Boolean aceite = false;	
//	public String situacaoGeral;
//	public String imgSituacaoGeral;
//	public String riscoGeral;
//	public String imgRiscoGeral;
//	public String protocolo;
	
	public void initConst() throws SQLException {
//		if(isNaoAutenticado()) {
//			desconectarUsuario();
//		} else {
//			nomeReq = (String) getSession().getAttribute("nomecontador");
//			cpfReq = Formatacao.formataCpfCnpj((String) getSession().getAttribute("cpfcontador"));
//			this.vincular();
//		}
	}
	/*
	public void avancar() throws InterruptedException, SQLException {
		if (p1) {
			validaP1();
			p1 = false;
			p2 = true;
			progresso = 40;
		} else if (p2) {
			validaP2();
			p2 = false;
			p3 = true;
			progresso = 60;
		} else if (p3) {
			validaP3();
			p3 = false;
			p4 = true;
			progresso = 80;
		} else if (p4) {
			validaP4();
			p4 = false;
			p5 = true;
			(getComponente("divProgress")).setVisible(false);
			((Button) getComponente("btAvancar")).setLabel("CONCLUIR");
		} else if (p5) {
			if(concluir()){
				p5 = false;
				p6 = true;
				((Button) getComponente("btAvancar")).setVisible(false);
			}
		}
		this.vincular();
//		AnnotateDataBinder binder = new AnnotateDataBinder();
//		binder.init(getComponente("gridUso"), true);
//		binder.init(getComponente("listAtv"), true);
//		binder.loadAll();
	}
	
	public void validaP1() {
		if(protSim == null || protSim.replaceAll("[-_/ ]", "").length() != 11) {
			throw new WrongValueException(getComponente("protSim"),"Protocolo incompleto!");
		}
		simVO = new SimDAO().getSimByProtocolo(protSim);
		if(simVO == null || simVO.getIdsim() == null){
			throw new WrongValueException(getComponente("protSim"),"Protocolo inexistente!");
		}
		HashMap<String, Object> param = new HashMap<String ,Object>();
		param.put("protocolo",protSim);
		param.put("cpfreq", cpfReq.replaceAll("[._-]", ""));
		Integer qntConst = new ConDAO().countQntConst(param);
		if(qntConst != null && qntConst > 0){
			throw new WrongValueException(getComponente("protSim"),"Já existe uma constituição para a inscrição imobiliária desta simulação!");
		}
//		if(simVO.getIdnat() == 2135){   
//			visibleTitular = true;
//		}
		//PREENCHE A LISTA DE USOS
		listUsosZona = new ArrayList<UsoVO>();
		listUsosZona.addAll(new UsoDAO().getUsos("'" + simVO.getUsosim().replaceAll("-","','") + "'"));
	}
	
//	public void validaP2() {
//		if(nomeEmp == null || nomeEmp.isEmpty()) {
//			throw new WrongValueException(getComponente("protJucems"),"Informe o Protocolo JUCEMS e faça a validação!");
//		}
//		
//	}
	
	public void validaP2() {
		//PREENCHE A LISTA DE ATIVIDADES
		listAtvSim = new ArrayList<AtsVO>();
		listAtvSim.addAll(new AtsDAO().getAtvBySim(simVO.getIdsim()));
		boolean primeiro = true;
		listClasses = "'";
		objetoSocial = "";
		for (AtsVO ats : listAtvSim) {
			if(primeiro){
				listClasses += ats.getCnaecdats().substring(0,9);
				objetoSocial += ats.getCnaenmats();
				primeiro = false;
			} else {
				listClasses += "','" +ats.getCnaecdats().substring(0,9);
				objetoSocial += ",\n" + ats.getCnaenmats();
			}
		}
		listClasses += "'";
	}
	
	public void validaP3(){
		Boolean temPrincipal = false;
		for (AtsVO ats : listAtvSim) {
			if(ats.getPrincipal()){
				temPrincipal = true;
				atvPrincipal = ats;
			} 
		}
		if(!temPrincipal){
			throw new WrongValueException(getComponente("listAtv"),"Informe a Atividade Principal!");
		}
		//PREENCHE A LISTA DE PERGUNTAS
		listPerguntas = new ArrayList<PerVO>();
		listPerguntas.addAll(new PerDAO().getPerByClassesCnae(listClasses));	
	}
	
	public void validaP4(){
		for (PerVO per : listPerguntas) {
			if((!per.getDisable()) && per.getResposta() == null || (per.getResposta() != null && per.getResposta().isEmpty())){
				throw new WrongValueException(getComponente("listPer"),"Favor informar todas as respostas!");
			}
		}
		Integer sit = new AtsDAO().countEmAnalise(simVO.getIdsim());
		if(sit>0) {
			situacaoGeral = "Análise Manual";
			imgSituacaoGeral = "/images/externo/analise.png";
		} else {
			situacaoGeral = "Permitida";
			imgSituacaoGeral = "/images/externo/deferido.png";
		}
		riscoGeral = new AtsDAO().getRiscoGeral(simVO.getIdsim());
		if(riscoGeral.substring(0, 1).equals("A")){
			imgRiscoGeral = "/images/externo/red.png";
		} else if(riscoGeral.substring(0, 1).equals("M")){
			imgRiscoGeral = "/images/externo/yellow.png";
		}else {
			imgRiscoGeral = "/images/externo/green.png";
		}
	}
	
	public Boolean concluir() throws SQLException {
		if(!aceite){
			throw new WrongValueException(getComponente("checkAceite"),"Confirme a veracidade dos dados informados!");
		}
		//SALVA A CONSTITUIÇÃO...
		conVO.setIdsim(simVO.getIdsim());
		//conVO.setNomempcon(nomeEmp); //seta o nome empresarial
		conVO.setSitgercon(situacaoGeral.substring(0, 1)); //seta a situacao geral
		conVO.setRisgercon(riscoGeral.substring(0, 1)); //seta o risco geral
		//protocolo gera no xml...
		conVO.setNomreqcon(nomeReq);
		conVO.setCpfreqcon(cpfReq.replaceAll("[._-]", ""));
		//data protocolo no xml
//		if(simVO.getIdnat() == 2135){
//			conVO.setNomtitcon(nomTit!=null?nomTit:null);
//			conVO.setCpftitcon(cpfTit!=null?cpfTit:null);
//			conVO.setMaetitcon(maeTit!=null?maeTit:null);
//		}
		conVO.setUsualt(cpfReq);
		try {
			new ConDAO().getSqlMap().startTransaction();
			Integer codInsCon = null;
			try {
				codInsCon = (Integer) new ConDAO().insReg(conVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(codInsCon!= null && codInsCon > 0){
				//SALVA A ATIVIDADE PRINCIPAL (PRINCIATS = 1)
				Integer codUpdAtv = null;
				try {
					codUpdAtv = new AtsDAO().updRegByCod(atvPrincipal);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(codUpdAtv!= null && codUpdAtv > 0){
					//SALVA AS RESPOSTAS DAS PERGUNTAS (TABELA RESPOSRES)
					for (PerVO per : listPerguntas) {
						ResVO resposta = new ResVO();
						resposta.setIdcon(codInsCon);
						resposta.setIdper(per.getIdper());
						resposta.setResposres(per.getResposta());
						resposta.setUsualt("WEB");
						try {
							new ResDAO().insReg(resposta);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					protocolo = new ConDAO().getProtProcesso(codInsCon);
					//seta o código de Autenticação
					String expressao = conVO.getCpfreqcon() + protocolo.replaceAll("[/-]", "") + conVO.getIdsim(); // = cpfreq + prot + idsim
					String codver = Formatacao.gerarHash(expressao);
					conVO.setIdcon(codInsCon);
					conVO.setCodautcon(codver.substring(0, 5) + codver.substring(27, 32)); //5 primeiros e 5 ultimos digitos do hash acima
					new ConDAO().updCodigoAutenticacao(conVO);
					new ConDAO().getSqlMap().commitTransaction();
					return true;
				}
			} else {
				try {
					Messagebox.show("Erro ao salvar a Constituição!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			try {
				Messagebox.show("Erro ao realizar a Constituição!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				new ConDAO().getSqlMap().endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Boolean isVisibleSitAut(){ //controla a visibilidade do campo situação do autônomo
		if(simVO != null && simVO.getTipendsim() != null && simVO.getTipendsim().equals("A")){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isVisibleEmpInd(){ //controla a visibilidade do campo empreendedor individual
		if(simVO != null && simVO.getTipendsim() != null && simVO.getTipendsim().equals("M")){
			return true;
		} else {
			return false;
		}
	}
	
	public void selecionaPrincipal(Object obj){
		AtsVO atsSel = (AtsVO) obj;
		for (AtsVO ats : listAtvSim) {
			if(ats == atsSel){
				ats.setPrincipal(true);
			} else {
				ats.setPrincipal(false);
			}
		}
		AnnotateDataBinder binder = new AnnotateDataBinder();
		binder.init(getComponente("listAtv"), true);
		binder.loadAll();
	}
	
//	public void validaProtocoloJUCEMS() throws IOException{
//		if(protJucems == null || protJucems.isEmpty()) {
//			throw new WrongValueException(getComponente("protJucems"),"Informe o Protocolo!");
//		}
//		String urlString = "http://empresafacil.pmcg.ms.gov.br/empresafacil/conteudo/telas/ajaxProtocoloJUCEMS.php";  
//		Properties parameters = new Properties(); 
//		parameters.setProperty("id",protJucems);  
//		  
//		@SuppressWarnings("rawtypes")
//		Iterator i = parameters.keySet().iterator();  
//		int counter = 0;  
//		while (i.hasNext()) {  
//		    String name = (String) i.next();  
//		    String value = parameters.getProperty(name);  
//		    urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;  
//		}  
//		URL url = new URL(urlString);
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
//		connection.setRequestMethod("POST");  
//		connection.setDoInput(true);  
//		connection.setDoOutput(true);  
//		connection.connect();  
//		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
//		StringBuffer newData = new StringBuffer(10000);  
//		String s = "";  
//		while (null != ((s = br.readLine()))) {  
//		    newData.append(s);
//		}  
//		br.close();  
//
//		nomeEmp = new String(newData);
//		this.vincular();
//	}
	
	public void imprimeProtocolo() {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("idcon", (conVO.getIdcon()).toString());
		//tive que preencher todos os parametros abaixo pq com o redirecionamento estava perdendo o cainho do relatorio
		new WinUtils().abrirBirt(95, "/efacilzk", "3.7", "apl04.pmcg.ms.gov.br:8080", "PDF", "PROTOCOLO DE PROCESSO", "prot_processo.rptdesign", param);
	}
	
	public void atualizaObrig(Object obj){
		PerVO perg = (PerVO) obj;
		if(perg.getIdper() == 10){
			if(perg.getResposta() != null && perg.getResposta().equals("NÃO")){
				for (PerVO pe : listPerguntas) {
					if(pe.getIdper() == 24 || pe.getIdper() == 25 || pe.getIdper() == 26){
						pe.setDisable(true);
						pe.setResposta(null);
					}
				}
			} else {
				for (PerVO pe : listPerguntas) {
					if(pe.getIdper() == 24 || pe.getIdper() == 25 || pe.getIdper() == 26){
						pe.setDisable(false);
					}
				}
			}
			this.vincular();
		}
	}
	*/
}
