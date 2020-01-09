package pmcg.imti.view.ext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.AnxDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.AnxVO;
import pmcg.fcn.domain.CadVO;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.ArqanxDAO;
import pmcg.imti.domain.ArqanxVO;
import pmcg.imti.ui.Upload;

public class Acompanhamento extends Index {
	private static final long serialVersionUID = 1L;
	
	public List<HashMap<String, Object>> listProtocolos;
	public HashMap<String, Object> protAnaliseSel; //item selecionado da lista
	public List<AnxVO> listAnx; //lista de anexos do BAE
	public Upload up; //Arquivo a ser anexado na lista abaixo
	public String descricaoArquivo = "";
	public String cpfReq;
	
	public void initAcomp() throws SQLException, InterruptedException{
		if(isNaoAutenticado()){
			desconectarUsuario();
		} else {
			if (getSession().getAttribute("viabae") != null) {
				getSession().removeAttribute("viabae"); //se tem alguma viabilidade para fazer bae na sessao limpa
			}
			cpfReq = ((CadVO) getSession().getAttribute("usuarioExtCim")).getCpfcad();
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("cpfreq", cpfReq); 
			this.listProtocolos = new ViaDAO().getProtocolos(param);
			this.vincular();
			
			//case when aen.sitaen = 'Deferida' OR aen.sitaen = 'Indeferida' then true else false end as permguia,
			
//			for (HashMap<String, Object> pro : listProtocolos){
//				HashMap<String, Object> dadosVia = new ViaDAO().getDadosByProtocolo(pro.get("provia").toString());
//				//SE ->  (MEI E ñ possui est. fixo) OU (AUTONOMO E NAO ESTABELECIDO)) defere direto pois não precisam de guia
//				if(((!dadosVia.get("tipvia").toString().equals("A")) && (!(Boolean) dadosVia.get("possuiestabelecimentofixo"))) || (dadosVia.get("tipvia").toString().equals("A") && dadosVia.get("sauvia").toString().equals("N"))){
//					pro.put("permImpGC", false);
//				} else {
//					if(pro.get("analise")!= null && (pro.get("analise").toString().startsWith("Def") || pro.get("analise").toString().startsWith("Ind"))){
//						pro.put("permImpGC", true);
//					} else {
//						pro.put("permImpGC", false);
//					}
//				}
//			}
		}
	}
	
	public void completarBae(Listitem item){
		@SuppressWarnings("unchecked")
		HashMap<String, Object> via = (HashMap<String, Object>) item.getValue();
		if((boolean) via.get("permbae")){
			session.setAttribute("viabae", via.get("iddvia"));
			redirecionarTela("/bae.zul");
		}
	}
	
	public void retornaReg(){
		if(protAnaliseSel != null){
			listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) protAnaliseSel.get("baevia"), "B"));
		} else {
			listAnx = null;
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
	
	public void anexar() throws InterruptedException{
		if(protAnaliseSel == null || protAnaliseSel.get("iddvia") == null){
			throw new WrongValueException(getComponente("listProt"),"Selecione um protocolo para anexar!");
		} else if(!(Boolean) protAnaliseSel.get("permeditarbae")){
			throw new WrongValueException(getComponente("listProt"),"Só é permitido anexar arquivos após o preenchimento do BAE!");
		} else if((Boolean) protAnaliseSel.get("analisebaecompleta") && (!protAnaliseSel.get("analisebae").toString().startsWith("E"))){
			throw new WrongValueException(getComponente("listAnx"),"Não é possível anexar arquivos: BAE já analisado!");
		} else {
			if(up != null && up.getAnxVO() != null){
				if(listAnx != null && listAnx.size() >= 10){
					throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar, limite máximo de 10 arquivos!");
				} else {
					if(descricaoArquivo == null || descricaoArquivo.isEmpty()){
						throw new WrongValueException(getComponente("desarq"),"Informe a Descrição do Arquivo!");
					} else {
						AnxVO anxVO = up.getAnxVO();
						anxVO.setDesanx(descricaoArquivo);
						anxVO.setUsualt(getUsuario().getCpfcad());
						
						try {
							// inclui o arqanx
							ArqanxVO arqanx = anxVO.getArqanxVO();
							Long seqarq = (Long) new ArqanxDAO().insReg(arqanx);
							arqanx.setSeqarq(seqarq);
							// inclui o anx
							anxVO.setArqanx(seqarq);
							anxVO.setDocanx((Long) protAnaliseSel.get("baevia"));
							anxVO.setTpdanx("B");
							Long codigoanx = (Long) new AnxDAO().insReg(anxVO);
							anxVO.setIddanx(codigoanx);
						} catch (Exception e) {
							System.out.println(e.getMessage());
							throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar o arquivo!");
						}
						listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) protAnaliseSel.get("baevia"), "B"));
						up = null;
						descricaoArquivo = "";
						this.vincular();
					}
				}
			} else {
				throw new WrongValueException(getComponente("selArq"),"Carregue um Arquivo!");
			}
		}
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
	
	public void deletarArquivo(AnxVO anxVO) throws InterruptedException, SQLException {
		int resp = Messagebox.show("Deseja realmente excluir este arquivo?", "Confirmação", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION);
		if (resp == Messagebox.YES) {
			if((Boolean) protAnaliseSel.get("analisebaecompleta")){
				throw new WrongValueException(getComponente("listAnx"),"Não é possível excluir arquivos: BAE já analisado!");
			} 
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
	
	public void imprimirTermo(){
		if(protAnaliseSel == null || protAnaliseSel.get("iddvia") == null){
			throw new WrongValueException(getComponente("listProt"),"Selecione um protocolo!");
		}
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("provia", protAnaliseSel.get("provia").toString());
		//tive que preencher todos os parametros abaixo pq com o redirecionamento estava perdendo o cainho do relatorio
		new WinUtils().abrirBirt(120, "/cimweb", "3.7", "apl04.pmcg.ms.gov.br:8080", "PDF", "TERMO DE RESPONSABILIDADE", "termo_responsabilidade.rptdesign", param);
	}
	
	public void imprimirGuiaConsulta(Listitem item){
		@SuppressWarnings("unchecked")
		HashMap<String, Object> via = (HashMap<String, Object>) item.getValue();
		if((Boolean) via.get("permguia")){
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("provia", via.get("provia").toString());
			new WinUtils().abrirBirt(120, "/cimweb", "3.7", "apl04.pmcg.ms.gov.br:8080", "PDF", "GUIA DE CONSULTA", "guia_consulta.rptdesign", param);
		}
	}
	
	public void editarBae(Listitem item){
		@SuppressWarnings("unchecked")
		HashMap<String, Object> via = (HashMap<String, Object>) item.getValue();
		if((boolean) via.get("permeditarbae") && via.get("analisebae").toString().startsWith("E")){
			session.setAttribute("viabae", via.get("iddvia"));
			redirecionarTela("/bae.zul");
		}
	}
	
	public void imprimirBae(Listitem item){
		@SuppressWarnings("unchecked")
		HashMap<String, Object> via = (HashMap<String, Object>) item.getValue();
		if((Boolean) via.get("tembae")){
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("provia", via.get("provia").toString());
			new WinUtils().abrirBirt(120, "/cimweb", "3.7", "apl04.pmcg.ms.gov.br:8080", "PDF", "Consulta BAE", "consulta_bae.rptdesign", param);
		}
	}

}
