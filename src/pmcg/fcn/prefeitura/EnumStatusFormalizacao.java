package pmcg.fcn.prefeitura;

import java.util.Arrays;
import java.util.List;

public enum EnumStatusFormalizacao {
    	D("Formalizada"), E("Em Exigência"),I("Indeferida"),P("Parcialmente Formalizada");
	  
	private String codigo;

	private EnumStatusFormalizacao(String codigo) {
		this.codigo = codigo;
	}

	public EnumStatusFormalizacao getEnum(String cod) {
		for (EnumStatusFormalizacao tEnum : EnumStatusFormalizacao.values()) {
			if (tEnum.getCodigo().equals(cod))
				return tEnum;
		}
		return null;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static List<EnumStatusFormalizacao> obtemListaStatusFormalizacaoSefaz() {
		return Arrays.asList(EnumStatusFormalizacao.D, EnumStatusFormalizacao.E, EnumStatusFormalizacao.I);
	}
	
	public static List<EnumStatusFormalizacao> obtemListaStatusFormalizacaoPrefeitura() {
		return Arrays.asList(EnumStatusFormalizacao.D, EnumStatusFormalizacao.E, EnumStatusFormalizacao.I, EnumStatusFormalizacao.P);
	}
	
}