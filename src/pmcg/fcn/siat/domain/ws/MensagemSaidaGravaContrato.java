package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do servi�o Gravar contrato de parcelamento.
 * Classe n�o persistida.
 * @author Eule Castro
 * @version 1.0
 * @created 24-set-2010 11:06:24
 */
public enum MensagemSaidaGravaContrato {
	
	M1("Arquivo inconsistente. "),
	M2("Contrato de parcelamento j� gravado. "),
	M3("Lan�amento j� gravado. "),
	M4("Mensagem do SIAT. "),
	M5("Grava��o n�o Realizada. "),
	M6("Grava��o Realizada. "),
	M7("Tributo n�o cadastrado. "),
	M8("Quantidade de parcelas do lan�amento n�o confere. "),
	M9("Item de tributo n�o cadastrado. "),
	M10("Item de tributo n�o faz parte da composi��o do tributo. "),
	M11("Somat�rio das colunas dos itens do lan�amento n�o confere com o lan�amento. "),
	M12("Somat�rio das colunas das parcelas do lan�amento n�o confere com o lan�amento. "),
	M13("Somat�rio das colunas dos itens da parcela do lan�amento n�o confere com a parcela. "),
	M14("Cadastro n�o encontrado. "),
	M15("Regra de parcelamento n�o cadastrada. "),
	M16("Tipo de cadastro do contrato difere da regra de parcelamento. "),
	M17("Tipo de d�vida parcelada do contrato difere da regra de parcelamento. "),
	M18("Tributo do lan�amento do parcelamento difere da regra de parcelamento. "),
	M19("Cadastro da parcela origem n�o encontrado. "),
	M20("Parcela origem n�o cadastrada. "),
	M21("Tributo da Parcela origem n�o cadastrado. "),
	M22("Somat�rio das colunas da parcela origem n�o confere com o total. "),
	M23("Item de tributo da parcela origem n�o cadastrado. "),
	M24("Somat�rio das colunas do item da parcela origem n�o confere com o total. "),
	M25("Somat�rio dos itens da parcela origem n�o confere com os totais da parcela origem. "),
	M26("Somat�rio das parcelas origens n�o confere com os totais do contrato de parcelamento. "),
	M27("Valor do lan�amento do parcelamento difere do valor do contrato. "),
	M28("Valor do lan�amento das custas processuais difere do valor do contrato. "),
	M29("Valor recalculado para o contrato n�o conferem com o recebido. "),
	M30("Respons�vel pelo contrato n�o informado. "),
	M31("Tipo de cadastro da parcela origem do contrato parcelamento. "),
	M32("Tipo de d�vida da parcela origem difere do contrato parcelamento. "),
	M33("Tributo da parcela origem n�o pode ser parcelado pela regra de parcelamento. "),
	M34("Tributo das custas processuais inv�lido. "),
	M35("Usu�rio n�o cadastrado. "),
	M36("Parcela origem n�o est� Aberta. "),
	M37("Erro ao alterar situa��o das parcelas origem para Parcelada. "),
	M38("Permitido lote com no m�ximo 50 (ciquenta) registros. "),
	M39("Tipo Bairro inv�lido. "),
	M40("Tipo Logradouro inv�lido. "),
	M41("Estado Civil inv�lido. "),
	M42("Tributo dos honor�rios advocat�cios inv�lido. ");

	private String mensagem;
	
	private MensagemSaidaGravaContrato(String mensagem){
		this.mensagem = mensagem;
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