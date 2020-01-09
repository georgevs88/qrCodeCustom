package pmcg.fcn.siat.domain.ws;


/**
 * Enum responsavel por disponibilizar as mensagens de saida para o web service processaArquivoAutoInfracao. 
 * 
 * @author André Bandera 02/04/2009
 */
public enum MensagemSaidaArquivoAutoInfracao {
	
	/**
	 *  
	 * 	1 – (Dados Inconsistentes)
	 *  2 – (Lançamento efetuado)
	 *  3 – (Lançamento não efetuado)
	 *  4 – (Solicitação efetuada)
	 *  5 – (Solicitação não efetuada)
	 * 
	 */
	
	/*
	 * formato: 
	 * - parametro : descricao da mensagem, conforme o numero da mensagem
	 */
	
	M1(1, "Inconsistência - Dados Arquivo. "),
	M2(1, "Inconsistência - Dados Auto. "),
	M3(1, "Inconsistência - Valores Totais. "),
	M4(1, "Inconsistência - Dados Parcela. "),
	M5(1, "Inconsistência - Mês/Ano Referência. "),
	M6(1, "Inconsistência - Tributo. "),
	M7(1, "Inconsistência - Inscrição Municipal. "),
	M8(1, "Inconsistência - Dados para Alteração da Situação da parcela. "),
	M9(1, "Auto Infração já existe. "),
	M10(1, "Mês/Ano Referência inválido ou Número Parcela já existente. "),
	M11(2, "Lançamento efetuado. "),
	M12(1, "Auto Infração inexistente. "),
	M13(3, "Lançamento não efetuado. "),
	M14(4, "Cancelamento efetuado. "),
	M15(5, "Solicitação não efetuada. "),
	M16(1, "Parcela do Auto inexistente. "),
	M17(1, "Parcela com situação inválida. "),
	M18(4, "Suspensão efetuada. "),
	M19(4, "Reativação efetuada. "),
	M20(4, "Estorno efetuado. "),
	M21(1, "Inconsistência - Tipo Auto Infração. ");

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
