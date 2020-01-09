package pmcg.fcn.siat.domain.ws;

/**
 * 
 * Enum que informa as mensagens que devem ser enviadas pelo servi�o: Grava Cadastro Economico
 * 
 * @author Andr� V. M. D. Bandera
 */
public enum MensagemGravaCadastroEconomico {
	
	M1(1, "Inconsist�ncia na entrada XML."),
	M2(1, "Inconsist�ncia nos dados da entrada XML."),
	M3(1, "Natureza jur�dica inv�lida."),
	M4(1, "Erro nos dados do endere�o."),
	M5(1, "Org�o de registro inv�lido."),
	M6(1, "Documento de constitui��o inv�lido."),
	M7(1, "Qualifica��o inv�lida - n�mero qualifica��o: "),
	M8(2, "Inclus�o realizada com sucesso."),
	M9(1, "Atividade inv�lida - n�mero atividade:"),
	M10(1, "Ocupa��o inv�lida - n�mero ocupa��o:"),
	M11(1, "Sindicado/Conselho inv�lido - sigla:"),
	M12(1, "CNPJ j� existe cadastrado."),
	M13(1, "Restri��o:"),
	M14(3, "Ocorreu um erro na inclus�o do cadastro econ�mico."),
	M15(1, "Estado c�vil inv�lido."),
	M16(1, " Atributos obrigat�rios:"),
	M17(1, " Atributos tamanho m�ximo ultrapassados:"),
	M18(1, "CNPJ Matriz inv�lido."),
	M19(1, "Forma Atua��o Unidade Produtiva inv�lida."),
	M20(1, "Tipo Bairro inv�lido."),
	M21(1, "Tipo Logradouro inv�lido."),
	M22(3, "Ocorreu um erro na execu��o do cadastro econ�mico."),
	M23(1, "Qualifica��o S�cio n�o permite participa��o no QSA."),
	M24(1, "Qualifica��o S�cio n�o permite ser respons�vel legal no QSA."),
	M25(1, "Erro ao efetuar lan�amento no financeiro."),
	M26(1, "[EntradaEnderecoEntrega] � obrigat�rio."),
	M27(1, "[EntradaEnderecoLocalizacao] � obrigat�rio."),
	M28(1, "[EntradaAtividade] � obrigat�rio."),
	M29(1, "[EntradaSocioAdministrador] � obrigat�rio."),
	M30(1, "[EntradaOcupacao] � obrigat�rio."),
	M31(1, "[EntradaAtividade] N�o existe Atividade desdobrada Ativa."),
	M32(1, "Tipo Pessoa inv�lido."),
	M33(1, "J� existe Cadastro Econ�mico do MEI para este CNPJ com situa��o diferente de Encerrada"),
	M34(1, "J� existe Cadastro Econ�mico para este CNPJ com situa��o diferente de Encerrada"),
	M35(1, "Inscri��o Municipal j� existe gravada no SIAT");

	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemGravaCadastroEconomico (Integer numeroMensagem, String mensagem){
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