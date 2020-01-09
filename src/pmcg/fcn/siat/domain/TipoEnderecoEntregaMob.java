package pmcg.fcn.siat.domain;

/**
 * Representa o Tipo do Endereço de Entrega. Caso seja o mesmo Endereço de
 * Localização, o sistema faz uma cópia dos dados. Caso seja o Endereço da Pessoa,
 * o usuário informa o cpf/cnpj da pessoa e o sistema faz uma pesquisa no Cadastro
 * de Pessoa. Caso o usuário escolha a opção Entrega, será informado um endereço
 * específico.
 * @author George do Valle
 * @version 1.0
 * @created 31-out-2007 08:37:23
 */
public enum TipoEnderecoEntregaMob {
	L, 
	P, 
	E;
	
	public String getCodigo() {
		return this.toString();
	}
}