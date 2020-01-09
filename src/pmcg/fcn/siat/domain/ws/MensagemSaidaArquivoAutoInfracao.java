package pmcg.fcn.siat.domain.ws;


/**
 * Enum responsavel por disponibilizar as mensagens de saida para o web service processaArquivoAutoInfracao. 
 * 
 * @author Andr� Bandera 02/04/2009
 */
public enum MensagemSaidaArquivoAutoInfracao {
	
	/**
	 *  
	 * 	1 � (Dados Inconsistentes)
	 *  2 � (Lan�amento efetuado)
	 *  3 � (Lan�amento n�o efetuado)
	 *  4 � (Solicita��o efetuada)
	 *  5 � (Solicita��o n�o efetuada)
	 * 
	 */
	
	/*
	 * formato: 
	 * - parametro : descricao da mensagem, conforme o numero da mensagem
	 */
	
	M1(1, "Inconsist�ncia - Dados Arquivo. "),
	M2(1, "Inconsist�ncia - Dados Auto. "),
	M3(1, "Inconsist�ncia - Valores Totais. "),
	M4(1, "Inconsist�ncia - Dados Parcela. "),
	M5(1, "Inconsist�ncia - M�s/Ano Refer�ncia. "),
	M6(1, "Inconsist�ncia - Tributo. "),
	M7(1, "Inconsist�ncia - Inscri��o Municipal. "),
	M8(1, "Inconsist�ncia - Dados para Altera��o da Situa��o da parcela. "),
	M9(1, "Auto Infra��o j� existe. "),
	M10(1, "M�s/Ano Refer�ncia inv�lido ou N�mero Parcela j� existente. "),
	M11(2, "Lan�amento efetuado. "),
	M12(1, "Auto Infra��o inexistente. "),
	M13(3, "Lan�amento n�o efetuado. "),
	M14(4, "Cancelamento efetuado. "),
	M15(5, "Solicita��o n�o efetuada. "),
	M16(1, "Parcela do Auto inexistente. "),
	M17(1, "Parcela com situa��o inv�lida. "),
	M18(4, "Suspens�o efetuada. "),
	M19(4, "Reativa��o efetuada. "),
	M20(4, "Estorno efetuado. "),
	M21(1, "Inconsist�ncia - Tipo Auto Infra��o. ");

	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemSaidaArquivoAutoInfracao (Integer numeroMensagem, String mensagem){
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
