package pmcg.fcn.siat.domain;

/**
 * Representa os Tipos de Uso do Imóvel.
 * 
 * Alteração da versão 1.1 - Criado NI para ser utilizado na migração.
 * @author George do Valle
 */
public enum UsoImovelMob {
	PR /* Próprio */ ,
	AL /* Alugado */ ,
	CE /* Cedido */ ,
	CO /* Comodato */ ,
	AP /* Área Pública */ ,
	NI /* Não Identificado */ ;

	public String getCodigo() {
		return this.toString();
	}
}