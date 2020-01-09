package pmcg.imti.view.ext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.AnxDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.AnxVO;
import pmcg.imti.dao.ibatis.ArqanxDAO;
import pmcg.imti.domain.ArqanxVO;
import pmcg.imti.ui.Upload;
import pmcg.imti.util.FormatUtils;

public class Enviodoc extends Index {

	private static final long serialVersionUID = 1L;
	
	public String protocolo = "";
	public String emailReq = "";
	public String cpfReq = "";
	public HashMap<String, Object> via;
	public List<AnxVO> listAnx; //lista de anexos da viabilidade
	public Upload up; //Arquivo a ser anexado na lista
	public String descricaoArquivo = "";
	
	public void initEnv() throws SQLException{
//		protocolo = "MSP1500037909";
//		cpfReq = "01486177190";
//		emailReq = "georgsilva@gmail.com";
//		pesquisar();
		
		this.vincular();
	}
	
	public void pesquisar() throws InterruptedException{
		if(protocolo == null || protocolo.isEmpty()){
			throw new WrongValueException(getComponente("protocolo"),"Informe o Protocolo de Viabilidade!");
		} 
		if(protocolo.startsWith("CGR")){
			throw new WrongValueException(getComponente("protocolo"),"Essa funcionalidade permite apenas anexar documentos a protocolos da Junta Comercial (que começam com 'MSP'), para anexar documentos ao BAE (que começam com 'CGR') fazer o login e acessar o menu 'Acompanhamento'!");
		}
		if(cpfReq == null || cpfReq.isEmpty()){
			throw new WrongValueException(getComponente("cpfReq"),"Informe o CPF do Requerente!");
		}
		if(FormatUtils.onlyNumbers(cpfReq).length() != 11){
			throw new WrongValueException(getComponente("cnpsad"),"CPF inválido!");
		}
		if(emailReq == null || emailReq.isEmpty()){
			throw new WrongValueException(getComponente("emailReq"),"Informe o E-mail do Requerentee!");
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("provia", protocolo); 
		param.put("logreq", cpfReq);
		param.put("emareq", emailReq);
		via = new ViaDAO().getRegEnvDoc(param);
		if(via == null){
			Messagebox.show("Viabilidade não encontrada!", "Aviso!", Messagebox.OK, Messagebox.INFORMATION);
		} else {
			listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) via.get("iddvia"), "V"));
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
		if(!(Boolean) via.get("permitidoanexar")){
			throw new WrongValueException(getComponente("sitaen"),"Não é possível anexar pois a viabilidade já foi analisada!");
		} 
		if(up != null && up.getAnxVO() != null){
			if(listAnx != null && listAnx.size() >= 10){
				throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar, limite máximo de 10 arquivos!");
			} else {
				if(descricaoArquivo == null || descricaoArquivo.isEmpty()){
					throw new WrongValueException(getComponente("desarq"),"Informe a Descrição do Arquivo!");
				} else {
					AnxVO anxVO = up.getAnxVO();
					anxVO.setDesanx(descricaoArquivo);
					anxVO.setUsualt(cpfReq);
					
					try {
						// inclui o arqanx
						ArqanxVO arqanx = anxVO.getArqanxVO();
						Long seqarq = (Long) new ArqanxDAO().insReg(arqanx);
						arqanx.setSeqarq(seqarq);
						// inclui o anx
						anxVO.setArqanx(seqarq);
						anxVO.setDocanx((Long) via.get("iddvia"));
						anxVO.setTpdanx("V");
						Long codigoanx = (Long) new AnxDAO().insReg(anxVO);
						anxVO.setIddanx(codigoanx);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						throw new WrongValueException(getComponente("desarq"),"Não foi possível adicionar o arquivo!");
					}
					listAnx = new AnxDAO().getRegByDocTpd(new AnxVO((Long) via.get("iddvia"), "V"));
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
	
	public Boolean isViaEncontrada(){
		if(via != null && via.get("iddvia") != null){
			return true;
		} else {
			return false;
		}
			
	}
}
