package pmcg.imti.ui;

import java.io.IOException;
import java.util.List;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;

import pmcg.fcn.domain.AnxVO;
import pmcg.framework.util.UploadUtils;
import pmcg.imti.domain.ArqanxVO;

public class Upload {
	
	private	byte[] b;
	private String msgErro;
	private Media arquivo;
	private String nomeArquivo;
	

	public Upload(Event evt,List <String> tiposValidos) {

		// Recebe o evento de upload
		UploadEvent e = (UploadEvent) evt;
		arquivo = e.getMedia();
		
		///////////////////
		
		///////////////////
		
		if (arquivo == null) {
			msgErro="Selecione o arquivo!";
			return;
		}
		// Valida o tipo de arquivo
	     nomeArquivo = arquivo.getName();
		if (nomeArquivo.length() > 100) {
			msgErro="Nome do Arquivo muito grande (maior que 100 caracteres). Favor renomeá-lo!";
			return;
		}

		String[] nomeArquivoSplit = nomeArquivo.split("[.]");
		String ext = "." + nomeArquivoSplit[nomeArquivoSplit.length - 1];
		//verifica o tipo de extensao passada e da msg de tipo válido
		if(!tiposValidos.contains(ext.toLowerCase())){
			msgErro="Tipo de arquivo inválido. Arquivos Válidos: ";
					for (String ex : tiposValidos) {
						msgErro+=ex+", ";
					}
			return;
		}
		if (ext.compareToIgnoreCase(".txt") != 0) {
			// valida o tamanho do arquivo se exceder os 100mb permitido  manda a  msg
			try {
				int a = arquivo.getStreamData().available();
				if (a > 104857600)// 100mb=104857600 
				{
					msgErro="Arquivo excedeu o tamanho (100Mb), Verifique!";
					return;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
				msgErro="Erro ao ler o arquivo!";
				return;
			}

		}
		try {
			b= UploadUtils.getBinaryData(arquivo);
			
		} catch (IOException e1) {
			e1.printStackTrace();
			msgErro="Erro ao ler o arquivo!";
			return;
		}
	}
	

	public void getMsgErro(HtmlBasedComponent comp){
		if(msgErro!=null){
			throw new WrongValueException(comp,msgErro);
		}
	}
	
	public byte[] getByteArray(){
		return b;
	}
	
	public String getNomeArquivo(){
		return nomeArquivo;
	}
	
	public AnxVO getAnxVO(){
		AnxVO anxVO = new AnxVO();
		anxVO.setArqanxVO(new ArqanxVO());
		anxVO.getArqanxVO().setAnxarq(b);
		anxVO.getArqanxVO().setTiparq(arquivo.getContentType());
		anxVO.getArqanxVO().setCodsis(120);
		anxVO.getArqanxVO().setNomarq(nomeArquivo);
		anxVO.setNomanx(nomeArquivo);
		return anxVO;
	}
	
	public ArqanxVO getArqanxVO(){
		ArqanxVO arqGED = new ArqanxVO();
		arqGED.setAnxarq(b);
		arqGED.setTiparq(arquivo.getContentType());
		arqGED.setCodsis(120);
		arqGED.setNomarq(nomeArquivo);
		return arqGED;
	}
	


}
