package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do Documento de Arrecadação. Classe não persistida.
 * @author Eule Castro
 * @version 1.0
 * @created 20-set-2010 10:23:28
 */
public enum MensagemSaidaGravaDocArrec {
	
	M1("Arquivo inconsistente") 														/* Arquivo inconsistente */ ,
	M2("Documento arrecadação já gravado") 												/* Documento arrecadação já gravado */ ,
	M3("Mensagem do SIAT") 																/* Mensagem do SIAT */ ,
	M4("Gravação não Realizada") 														/* Gravação não Realizada */ ,
	M5("Gravação Realizada") 															/* Gravação Realizada */ ,
	M6("Cadastro não encontrado") 														/* Cadastro não encontrado */ ,
	M7("Quantidade de parcelas não confere") 											/* Quantidade de parcelas não confere */ ,
	M8("Parcela não cadastrada") 														/* Parcela não cadastrada */ ,
	M9("Tributo não cadastrado")	 													/* Tributo não cadastrado */ ,
	M10("Tipo de cadastro do Tributo difere do Documento de arrecadação") 				/* Tipo de cadastro do Tributo difere do Documento de arrecadação */ ,
	M11("Somatório das colunas da parcela não confere com o total") 					/* Somatório das colunas da parcela não confere com o total */ ,
	M12("Somatório das colunas do documento de arrecadação não confere com o total") 	/* Somatório das colunas do documento de arrecadação não confere com o total */ ,
	M13("Somatório das parcelas não confere com os totais do documento de arrecadação") /* Somatório das parcelas não confere com os totais do documento de arrecadação */ ,
	M14("Item de tributo não cadastrado") 												/* Item de tributo não cadastrado */ ,
	M15("Item de tributo não faz parte da composição do tributo") 						/* Item de tributo não faz parte da composição do tributo */ ,
	M16("Somatório das colunas do item da parcela não confere com o total") 			/* Somatório das colunas do item da parcela não confere com o total */ ,
	M17("Somatório dos itens da parcela não confere com os totais da parcela") 			/* Somatório dos itens da parcela não confere com os totais da parcela */ ,
	M18("Valor recalculado não conferem com o recebido") 								/* Valor recalculado não conferem com o recebido */ ,
	M19("Data de validade recalculada não confere") 									/* Data de validade recalculada não confere */ ,
	M20("Código de barras inválido") 													/* Código de barras inválido */,
	M21("Linha Digitável inválida") 													/* Linha Digitável inválida */,
	M22("Permitido lote com no máximo 100 (cem) registros ")							/* Permitido lote com no máximo 100 (cem) registros) */;

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