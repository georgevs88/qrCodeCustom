package pmcg.imti.view;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.AnxDAO;
import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CaiDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.ConDAO;
import pmcg.fcn.dao.ibatis.RepDAO;
import pmcg.fcn.dao.ibatis.ReqDAO;
import pmcg.fcn.dao.ibatis.SadDAO;
import pmcg.fcn.domain.AnxVO;
import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.CaiVO;
import pmcg.fcn.domain.ConVO;
import pmcg.fcn.domain.ReqVO;
import pmcg.fcn.prefeitura.ImportacaoJunta;
import pmcg.framework.ui.WindowCrud;
import pmcg.imti.dao.ibatis.ArqanxDAO;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.dao.ibatis.WebusuDAO;
import pmcg.imti.domain.ArqanxVO;
import pmcg.imti.ui.Upload;
import pmcg.imti.util.FormatUtils;

public class Anabae extends WindowCrud{
	private static final long serialVersionUID = 1L;

	public List<HashMap<String, Object>> listBae; //lista de BAEs pendentes de análise
	public HashMap<String, Object> baeSel; //BAE selecionado da lista
	public List<HashMap<String, Object>> listInsmun; //lista de Inscriçoes no SIAT do CPF
	public Upload up; //Arquivo a ser anexado na lista abaixo
	public String descricaoArquivo = "";
	public List<AnxVO> listAnx; //lista de anexos do BAE
	public String paramProt; //nr_protocolo(viabilidade) FILTRO
	public String paramCpf; //CPF/CNPJ filtro
	public String paramNomNfa; //Nome/fantasia filtro
	public ReqVO requerente;
	public List<HashMap<String, Object>> listCna; //Lista de Atividades
	public List<HashMap<String, Object>> listSad; //Lista de Socios
	public String dataAnalise = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	public String status = "E";
	public String observacoes;
	public Boolean docsConferidos = false;
	public Boolean defPermitido;
	
	public void initComponentes(){
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		
		//Verifica permissao de deferimento
		HashMap param = new HashMap<String ,Object>();
		param.put("logusu", getLogin());
		param.put("codprf", 606);
		param.put("codsis", 120);
		if(new WebusuDAO().verificaAcessoUPS(param)){
			defPermitido = true;
		} else {
			defPermitido = false;
		}
		//paramProc = "70718";
		filtrar();
	}
	
	@Override
	public void salvar() throws InterruptedException {
		if(observacoes == null || observacoes.isEmpty()){
			throw new WrongValueException(getComponente("observacoes"),"Informe as observações!");
		}
		if(baeSel != null && baeSel.get("iddbae") != null){
			try {
				if (Messagebox.show("Tem certeza que deseja emitir o parecer?", "Parecer", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
					if(status.equals("D")){
						try {
							new BaeDAO().getSqlMap().startTransaction();
							
							CaiVO cai = new CaiVO();
							cai.setNprcai(baeSel.get("viabae").toString());
							cai.setMotcai(observacoes);
							cai.setDcocai(docsConferidos);
							cai.setDatcai(new Date());
							cai.setUsualt(getLogin());
							
							String riscoGeral = baeSel.get("risaen").toString();
							if(riscoGeral.equals("A") || riscoGeral.equals("M")){
								cai.setSitcai("P");
							} else {
								cai.setSitcai("D");
							} 
							Long iddcai = (Long) new CaiDAO().insReg(cai);

							BaeVO caibae = new BaeVO();
							caibae.setIddbae((Long) baeSel.get("iddbae"));
							caibae.setCaibae(iddcai);
							new BaeDAO().updCaiBae(caibae);
							new BaeDAO().getSqlMap().commitTransaction();
							
							//para gerar a inscrição na hora:
							new ImportacaoJunta().importa(false, false, false, true);
//							String inscricaoMunicipal;
							//TODO
//							HashMap<String, String> resp = Util.gravaCadastroEconomico(baeSel.get("viabae").toString());
							//GRAVA A MSG DE RETORNO DO SIAT
//							if(resp.get("mensagem") != null && !resp.get("mensagem").toString().isEmpty()){
//								epdp.setMsgepd(resp.get("mensagem").toString());
//								new EpdDAO().updMensagemSIAT(epdp);
//								new EpdDAO().getSqlMap().commitTransaction();
//							}
							
							//SE O WS DO SIAT RESPONDER QUE JÁ EXISTE O CNPJ BUSCA A INSCRICAO DO SIAT
//							if(resp.get("mensagem").toString().substring(0, 14).equals("CNPJ já existe")){
//								inscricaoMunicipal = new EcoDAO().getImuByCpfcnpj(baeSel.get("cpfbae").toString());
//							} else {
//								inscricaoMunicipal = resp.get("inscricaoMunicipal").toString();
//							}
//							
//							if(inscricaoMunicipal.length() != 11){
//								logger.error("VERIFICAR PROTOCOLO: " + baeSel.get("viabae").toString());
//							} else {
//								
//							}
						} finally {
							new BaeDAO().getSqlMap().endTransaction();
						}
					} else {
						try {
							new BaeDAO().getSqlMap().startTransaction();
							CaiVO cai = new CaiVO();
							cai.setNprcai(baeSel.get("viabae").toString());
							cai.setSitcai(status);
							cai.setMotcai(observacoes);
							cai.setDcocai(docsConferidos);
							cai.setDatcai(new Date());
							cai.setUsualt(getLogin());
							Long iddcai = (Long) new CaiDAO().insReg(cai);
							BaeVO caibae = new BaeVO();
							caibae.setIddbae((Long) baeSel.get("iddbae"));
							caibae.setCaibae(iddcai);
							new BaeDAO().updCaiBae(caibae);
							new BaeDAO().getSqlMap().commitTransaction();
						} finally {
							new BaeDAO().getSqlMap().endTransaction();
						}
					}
					Messagebox.show("Análise concluída com sucesso!");
					paramProt = "";
					baeSel = null;
					limpar();
					filtrar();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selecionaProt(){
		retornaBae();
	}
	
	public void retornaBae(){
		try {
			if(baeSel.get("sitcai") != null){
				status = baeSel.get("sitcai").toString();
			} else {
				status = "E";
			}
			if(baeSel.get("motcai") != null && (!baeSel.get("motcai").toString().isEmpty())){
				observacoes = baeSel.get("motcai").toString();
			} else {
				observacoes = "";
			}
			if(baeSel.get("dcocai") != null && (Boolean) baeSel.get("dcocai")){
				docsConferidos = true;
			} else {
				docsConferidos = false;
			}
			requerente = new ReqDAO().getRegByCod(Long.parseLong(baeSel.get("reqbae").toString()));
			ConVO contador = new ConDAO().getRegByCodComplex((Long) baeSel.get("conbae"));
			baeSel.put("respCont", contador);
			listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) baeSel.get("iddbae"), "B"));
			listCna = new CnaDAO().getRegByProvia(baeSel.get("viabae").toString());
			listSad = new SadDAO().getSadByBae((Long) baeSel.get("iddbae"));
			for(HashMap<String, Object> sad : listSad){
				sad.put("listRep", new RepDAO().getRepBySad((Long) sad.get("iddsad")));
			}
			listInsmun = new EcoDAO().getInscricoesSiatByCpfcnpj(baeSel.get("cpfbae").toString());
			vincular();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void filtrar(){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("viabae", paramProt!=null&&(!paramProt.isEmpty())?paramProt:null); 
		param.put("cpfbae", paramCpf!=null&&(!paramCpf.isEmpty())?paramCpf:null);
		param.put("nomnfabae", paramNomNfa!=null&&(!paramNomNfa.isEmpty())?paramNomNfa:null);
		param.put("pendente", true);
		
		Paging pag = (Paging) this.getComponente("pagProt");
		pag.setTotalSize(new BaeDAO().countBae(param));
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
		param.put("viabae", paramProt!=null&&(!paramProt.isEmpty())?paramProt:null); 
		param.put("cpfbae", paramCpf!=null&&(!paramCpf.isEmpty())?FormatUtils.onlyNumbers(paramCpf):null);
		param.put("nomnfabae", paramNomNfa!=null&&(!paramNomNfa.isEmpty())?paramNomNfa:null);
		param.put("pendente", true);
		
		this.listBae = new BaeDAO().getBaeLimit(param, inicial, maximoPermitido);
		if(listBae != null && listBae.size() == 1){
			baeSel = listBae.get(0);
			selecionaProt();
		}
	}
	
//	public void imprimirConsulta(Listitem item){
//		@SuppressWarnings("unchecked")
//		HashMap<String, Object> epd = (HashMap<String, Object>) item.getValue();
//		HashMap<String, String> param = new HashMap<String, String>();
//		param.put("nprepd", epd.get("nprepd").toString());
//		new WinUtils().abrirBirt("consulta_empreendimento.rptdesign", param);
//	}
	
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
						anxVO.setDocanx((Long) baeSel.get("iddbae"));
						anxVO.setTpdanx("B");
						Long codigoanx = (Long) new AnxDAO().insReg(anxVO);
						anxVO.setIddanx(codigoanx);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar o arquivo!");
					}
					
					if (listAnx == null){
						listAnx = new ArrayList<AnxVO>();
					}
					listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) baeSel.get("iddbae"), "B"));
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
	
//	private void incluirAnexosArquivos(List<AnxVO> anxsIns, Integer codigodoc) throws SQLException {
//		for (AnxVO anx : anxsIns) {
//			// inclui o arqanx
//			ArqanxVO arqanx = anx.getArqanxVO();
//			Long seqarq = (Long) new ArqanxDAO().insReg(arqanx);
//			arqanx.setSeqarq(seqarq);
//			// inclui o anx
//			anx.setArqanx(seqarq);
//			anx.setUsualt(this.getLogin());
//			anx.setDatalt(WinUtils.getDataBanco());
//			anx.setDocanx((Long) baeSel.get("iddbae"));
//			anx.setTpdanx("B");
//			Long codigoanx = (Long) new AnxDAO().insReg(anx);
//			anx.setIddanx(codigoanx);
//		}
//	}
	
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
	
	public Boolean isBaeSelecionado(){
		if(baeSel != null && baeSel.get("iddbae") != null){
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isTemSocios(){
		if(listSad != null && listSad.size() > 0){
			return true;
		} else {
			return false;
		}
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
		baeSel = null;
		paramProt = paramCpf = paramNomNfa = "";
		requerente = null;
		listCna = null;
		listSad = null;
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}
	
	public Boolean visibleDeferido(){
		if(baeSel != null && baeSel.get("tipvia") != null && baeSel.get("tipvia").toString().startsWith("C") && !defPermitido){
			return false;
		} else {
			return true;
		}
	}
	
	public Boolean NaoVisibleDeferido(){
		return !visibleDeferido();
	}
	
	public Boolean visibleDadosSiat(){
		if(listInsmun != null && listInsmun.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
}