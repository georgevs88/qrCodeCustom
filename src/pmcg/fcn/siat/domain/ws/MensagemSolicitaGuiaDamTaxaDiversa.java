package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens de Sa�da do servi�o SolicitaGuiaDam. Classe
 * n�o persistida.
 * 
 * @author George do Valle
 * 
 * @version 1.0
 * @created 15-fev-2011 14:52:04
 */
public enum MensagemSolicitaGuiaDamTaxaDiversa {
	
	M1(1,"Inconsist�ncia - Dados Arquivo"),
	M2(2,"Campos obrigat�rios n�o informados"),
	M3(3,"Taxa Diversa inexistente"),
	M4(4,"Cadastro inexistente")/*  */ ,
	M5(5,"Inconsist�ncia - Tributo"),
	M6(6,"Grava��o n�o realizada"),
	M7(7,"Grava��o realizada"),
	M8(8,"Data Base Lan�amento n�o informada"),
	M9(9,"Quantidade Parcelas n�o informada"),
	M10(10,"Valor Taxa Diversa inv�lido"),
	M11(11,"Unidade Organizacional Financeiro n�o encontrada");
	
	private Integer numeroMensagem;
	private String mensagem;
	
	private MensagemSolicitaGuiaDamTaxaDiversa (Integer numeroMensagem, String mensagem){
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