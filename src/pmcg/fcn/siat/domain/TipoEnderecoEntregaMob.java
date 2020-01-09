package pmcg.fcn.siat.domain;

/**
 * Representa o Tipo do Endere�o de Entrega. Caso seja o mesmo Endere�o de
 * Localiza��o, o sistema faz uma c�pia dos dados. Caso seja o Endere�o da Pessoa,
 * o usu�rio informa o cpf/cnpj da pessoa e o sistema faz uma pesquisa no Cadastro
 * de Pessoa. Caso o usu�rio escolha a op��o Entrega, ser� informado um endere�o
 * espec�fico.
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