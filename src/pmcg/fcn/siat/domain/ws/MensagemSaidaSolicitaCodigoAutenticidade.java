package pmcg.fcn.siat.domain.ws;
/**
 * Classe que representa as mensagens do Arquivo de Sa�da do servi�o Solicita
 * C�digo Autenticidade. Classe n�o persistida.
 * @author George do Valle
 * @version 1.0
 * @created 03-ago-2010 16:54:10
 */
public enum MensagemSaidaSolicitaCodigoAutenticidade {
	
	M1(1, "Inconsist�ncia na entrada XML.") 									/* Inconsist�ncia na entrada XML 			*/ ,
	M2(1, "Inscri��o Municipal n�o informada.") 								/* Inscri��o Municipal n�o informada 		*/ ,
	M3(1, "Inscri��o Municipal inexistente.") 									/* Inscri��o Municipal inexistente 			*/ ,
	M4(1, "Tipo Documento n�o informado.") 										/* Tipo Documento n�o informado 			*/ ,
	M5(1, "Tipo Documento inexistente.") 										/* Tipo Documento inexistente 				*/ ,
	M6(1, "Risco n�o informado.") 												/* Risco n�o informado 						*/ ,
	M7(1, "Risco inexistente.") 												/* Risco inexistente 						*/ ,
	M8(1, "Status n�o informado.") 												/* Status n�o informado 					*/ ,
	M9(1, "Status inexistente.") 												/* Status inexistente 						*/ ,
	M10(1, "Data Validade n�o informada.") 										/* Data Validade n�o informada 				*/ ,
	M11(2, "Documento liberado para impress�o.") 								/* Documento liberado para impress�o 		*/ ,
	M12(3, "Documento bloqueado para impress�o .") 								/* Documento bloqueado para impress�o 		*/ ,
	M13(3, "Problemas na gera��o da autenticidade.") 							/* Problemas na gera��o da autenticidade	*/ ,
	M14(3, "Risco Alto.") 														/* Risco Alto 								*/ ,
	M15(1, "Inconsist�ncia nos dados da solicita��o.") 							/* Inconsist�ncia nos dados da solita��o. 	*/ ,
	M16(1, "Alvar� bloqueado para impress�o") 									/* Alvar� bloqueado para impress�o 			*/ ;

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