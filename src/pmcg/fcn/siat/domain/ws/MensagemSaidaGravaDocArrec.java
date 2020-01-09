package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do Documento de Arrecada��o. Classe n�o persistida.
 * @author Eule Castro
 * @version 1.0
 * @created 20-set-2010 10:23:28
 */
public enum MensagemSaidaGravaDocArrec {
	
	M1("Arquivo inconsistente") 														/* Arquivo inconsistente */ ,
	M2("Documento arrecada��o j� gravado") 												/* Documento arrecada��o j� gravado */ ,
	M3("Mensagem do SIAT") 																/* Mensagem do SIAT */ ,
	M4("Grava��o n�o Realizada") 														/* Grava��o n�o Realizada */ ,
	M5("Grava��o Realizada") 															/* Grava��o Realizada */ ,
	M6("Cadastro n�o encontrado") 														/* Cadastro n�o encontrado */ ,
	M7("Quantidade de parcelas n�o confere") 											/* Quantidade de parcelas n�o confere */ ,
	M8("Parcela n�o cadastrada") 														/* Parcela n�o cadastrada */ ,
	M9("Tributo n�o cadastrado")	 													/* Tributo n�o cadastrado */ ,
	M10("Tipo de cadastro do Tributo difere do Documento de arrecada��o") 				/* Tipo de cadastro do Tributo difere do Documento de arrecada��o */ ,
	M11("Somat�rio das colunas da parcela n�o confere com o total") 					/* Somat�rio das colunas da parcela n�o confere com o total */ ,
	M12("Somat�rio das colunas do documento de arrecada��o n�o confere com o total") 	/* Somat�rio das colunas do documento de arrecada��o n�o confere com o total */ ,
	M13("Somat�rio das parcelas n�o confere com os totais do documento de arrecada��o") /* Somat�rio das parcelas n�o confere com os totais do documento de arrecada��o */ ,
	M14("Item de tributo n�o cadastrado") 												/* Item de tributo n�o cadastrado */ ,
	M15("Item de tributo n�o faz parte da composi��o do tributo") 						/* Item de tributo n�o faz parte da composi��o do tributo */ ,
	M16("Somat�rio das colunas do item da parcela n�o confere com o total") 			/* Somat�rio das colunas do item da parcela n�o confere com o total */ ,
	M17("Somat�rio dos itens da parcela n�o confere com os totais da parcela") 			/* Somat�rio dos itens da parcela n�o confere com os totais da parcela */ ,
	M18("Valor recalculado n�o conferem com o recebido") 								/* Valor recalculado n�o conferem com o recebido */ ,
	M19("Data de validade recalculada n�o confere") 									/* Data de validade recalculada n�o confere */ ,
	M20("C�digo de barras inv�lido") 													/* C�digo de barras inv�lido */,
	M21("Linha Digit�vel inv�lida") 													/* Linha Digit�vel inv�lida */,
	M22("Permitido lote com no m�ximo 100 (cem) registros ")							/* Permitido lote com no m�ximo 100 (cem) registros) */;

	private String mensagem;
	
	private MensagemSaidaGravaDocArrec (String mensagem){
		this.mensagem 		= mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getCodigo() {
		return super.toString();
	}
	
	@Override
	public String toString() {
		return getMensagem();
	}
}