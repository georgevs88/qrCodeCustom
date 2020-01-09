package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens de Saída do serviço SolicitaGuiaDam. Classe
 * não persistida.
 * 
 * @author George do Valle
 * 
 * @version 1.0
 * @created 15-fev-2011 14:52:04
 */
public enum MensagemSolicitaGuiaDamTaxaDiversa {
	
	M1(1,"Inconsistência - Dados Arquivo"),
	M2(2,"Campos obrigatórios não informados"),
	M3(3,"Taxa Diversa inexistente"),
	M4(4,"Cadastro inexistente")/*  */ ,
	M5(5,"Inconsistência - Tributo"),
	M6(6,"Gravação não realizada"),
	M7(7,"Gravação realizada"),
	M8(8,"Data Base Lançamento não informada"),
	M9(9,"Quantidade Parcelas não informada"),
	M10(10,"Valor Taxa Diversa inválido"),
	M11(11,"Unidade Organizacional Financeiro não encontrada");
	
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