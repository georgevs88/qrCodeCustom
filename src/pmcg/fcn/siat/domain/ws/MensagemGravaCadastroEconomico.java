package pmcg.fcn.siat.domain.ws;

/**
 * 
 * Enum que informa as mensagens que devem ser enviadas pelo serviço: Grava Cadastro Economico
 * 
 * @author André V. M. D. Bandera
 */
public enum MensagemGravaCadastroEconomico {
	
	M1(1, "Inconsistência na entrada XML."),
	M2(1, "Inconsistência nos dados da entrada XML."),
	M3(1, "Natureza jurídica inválida."),
	M4(1, "Erro nos dados do endereço."),
	M5(1, "Orgão de registro inválido."),
	M6(1, "Documento de constituição inválido."),
	M7(1, "Qualificação inválida - número qualificação: "),
	M8(2, "Inclusão realizada com sucesso."),
	M9(1, "Atividade inválida - número atividade:"),
	M10(1, "Ocupação inválida - número ocupação:"),
	M11(1, "Sindicado/Conselho inválido - sigla:"),
	M12(1, "CNPJ já existe cadastrado."),
	M13(1, "Restrição:"),
	M14(3, "Ocorreu um erro na inclusão do cadastro econômico."),
	M15(1, "Estado cívil inválido."),
	M16(1, " Atributos obrigatórios:"),
	M17(1, " Atributos tamanho máximo ultrapassados:"),
	M18(1, "CNPJ Matriz inválido."),
	M19(1, "Forma Atuação Unidade Produtiva inválida."),
	M20(1, "Tipo Bairro inválido."),
	M21(1, "Tipo Logradouro inválido."),
	M22(3, "Ocorreu um erro na execução do cadastro econômico."),
	M23(1, "Qualificação Sócio não permite participação no QSA."),
	M24(1, "Qualificação Sócio não permite ser responsável legal no QSA."),
	M25(1, "Erro ao efetuar lançamento no financeiro."),
	M26(1, "[EntradaEnderecoEntrega] é obrigatório."),
	M27(1, "[EntradaEnderecoLocalizacao] é obrigatório."),
	M28(1, "[EntradaAtividade] é obrigatório."),
	M29(1, "[EntradaSocioAdministrador] é obrigatório."),
	M30(1, "[EntradaOcupacao] é obrigatório."),
	M31(1, "[EntradaAtividade] Não existe Atividade desdobrada Ativa."),
	M32(1, "Tipo Pessoa inválido."),
	M33(1, "Já existe Cadastro Econômico do MEI para este CNPJ com situação diferente de Encerrada"),
	M34(1, "Já existe Cadastro Econômico para este CNPJ com situação diferente de Encerrada"),
	M35(1, "Inscrição Municipal já existe gravada no SIAT");

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