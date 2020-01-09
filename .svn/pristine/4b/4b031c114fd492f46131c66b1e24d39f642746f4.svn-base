package pmcg.fcn.siat.domain.ws;

/**
 * Classe que representa as mensagens do serviço Gravar contrato de parcelamento.
 * Classe não persistida.
 * @author Eule Castro
 * @version 1.0
 * @created 24-set-2010 11:06:24
 */
public enum MensagemSaidaGravaContrato {
	
	M1("Arquivo inconsistente. "),
	M2("Contrato de parcelamento já gravado. "),
	M3("Lançamento já gravado. "),
	M4("Mensagem do SIAT. "),
	M5("Gravação não Realizada. "),
	M6("Gravação Realizada. "),
	M7("Tributo não cadastrado. "),
	M8("Quantidade de parcelas do lançamento não confere. "),
	M9("Item de tributo não cadastrado. "),
	M10("Item de tributo não faz parte da composição do tributo. "),
	M11("Somatório das colunas dos itens do lançamento não confere com o lançamento. "),
	M12("Somatório das colunas das parcelas do lançamento não confere com o lançamento. "),
	M13("Somatório das colunas dos itens da parcela do lançamento não confere com a parcela. "),
	M14("Cadastro não encontrado. "),
	M15("Regra de parcelamento não cadastrada. "),
	M16("Tipo de cadastro do contrato difere da regra de parcelamento. "),
	M17("Tipo de dívida parcelada do contrato difere da regra de parcelamento. "),
	M18("Tributo do lançamento do parcelamento difere da regra de parcelamento. "),
	M19("Cadastro da parcela origem não encontrado. "),
	M20("Parcela origem não cadastrada. "),
	M21("Tributo da Parcela origem não cadastrado. "),
	M22("Somatório das colunas da parcela origem não confere com o total. "),
	M23("Item de tributo da parcela origem não cadastrado. "),
	M24("Somatório das colunas do item da parcela origem não confere com o total. "),
	M25("Somatório dos itens da parcela origem não confere com os totais da parcela origem. "),
	M26("Somatório das parcelas origens não confere com os totais do contrato de parcelamento. "),
	M27("Valor do lançamento do parcelamento difere do valor do contrato. "),
	M28("Valor do lançamento das custas processuais difere do valor do contrato. "),
	M29("Valor recalculado para o contrato não conferem com o recebido. "),
	M30("Responsável pelo contrato não informado. "),
	M31("Tipo de cadastro da parcela origem do contrato parcelamento. "),
	M32("Tipo de dívida da parcela origem difere do contrato parcelamento. "),
	M33("Tributo da parcela origem não pode ser parcelado pela regra de parcelamento. "),
	M34("Tributo das custas processuais inválido. "),
	M35("Usuário não cadastrado. "),
	M36("Parcela origem não está Aberta. "),
	M37("Erro ao alterar situação das parcelas origem para Parcelada. "),
	M38("Permitido lote com no máximo 50 (ciquenta) registros. "),
	M39("Tipo Bairro inválido. "),
	M40("Tipo Logradouro inválido. "),
	M41("Estado Civil inválido. "),
	M42("Tributo dos honorários advocatícios inválido. ");

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