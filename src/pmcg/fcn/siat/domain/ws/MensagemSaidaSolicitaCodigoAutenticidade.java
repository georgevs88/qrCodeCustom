package pmcg.fcn.siat.domain.ws;
/**
 * Classe que representa as mensagens do Arquivo de Saída do serviço Solicita
 * Código Autenticidade. Classe não persistida.
 * @author George do Valle
 * @version 1.0
 * @created 03-ago-2010 16:54:10
 */
public enum MensagemSaidaSolicitaCodigoAutenticidade {
	
	M1(1, "Inconsistência na entrada XML.") 									/* Inconsistência na entrada XML 			*/ ,
	M2(1, "Inscrição Municipal não informada.") 								/* Inscrição Municipal não informada 		*/ ,
	M3(1, "Inscrição Municipal inexistente.") 									/* Inscrição Municipal inexistente 			*/ ,
	M4(1, "Tipo Documento não informado.") 										/* Tipo Documento não informado 			*/ ,
	M5(1, "Tipo Documento inexistente.") 										/* Tipo Documento inexistente 				*/ ,
	M6(1, "Risco não informado.") 												/* Risco não informado 						*/ ,
	M7(1, "Risco inexistente.") 												/* Risco inexistente 						*/ ,
	M8(1, "Status não informado.") 												/* Status não informado 					*/ ,
	M9(1, "Status inexistente.") 												/* Status inexistente 						*/ ,
	M10(1, "Data Validade não informada.") 										/* Data Validade não informada 				*/ ,
	M11(2, "Documento liberado para impressão.") 								/* Documento liberado para impressão 		*/ ,
	M12(3, "Documento bloqueado para impressão .") 								/* Documento bloqueado para impressão 		*/ ,
	M13(3, "Problemas na geração da autenticidade.") 							/* Problemas na geração da autenticidade	*/ ,
	M14(3, "Risco Alto.") 														/* Risco Alto 								*/ ,
	M15(1, "Inconsistência nos dados da solicitação.") 							/* Inconsistência nos dados da solitação. 	*/ ,
	M16(1, "Alvará bloqueado para impressão") 									/* Alvará bloqueado para impressão 			*/ ;

	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemSaidaSolicitaCodigoAutenticidade (Integer numeroMensagem, String mensagem){
		this.mensagem 		= mensagem;
		this.numeroMensagem = numeroMensagem;
	}

	public Integer getNumeroMensagem() {
		return numeroMensagem;
	}

	public void setNumeroMensagem(Integer numeroMensagem) {
		this.numeroMensagem = numeroMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getCodigo() {
		return this.toString();
	}
}