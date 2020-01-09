package pmcg.fcn.domain;

public enum SituacaoAnaliseEndereco {
	PROTOCOLADA("Protocolada", "1"),
	EM_ESTUDO("Em Estudo", "2"),
	DEFERIDA("Deferida", "4"),
	INDEFERIDA("Indeferida", "5"),
	CANCELADA_PELA_PREFEITURA("Cancelada Pela Prefeitura", "6"),
	EM_REESTUDO("Em Reestudo", "8"),
	SUJEITA_ANALISE_ESPECIFICA("Sujeita a Análise Específica", "9");
	
	
	private String descricao;
	private String codigo;

	private SituacaoAnaliseEndereco(String descricao, String codigo) {
		this.setDescricao(descricao);
		this.codigo = codigo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public boolean estaConcluida(){
		return (equals(DEFERIDA) || equals(INDEFERIDA));
	}
	
	public boolean estaDeferida(){
		return equals(DEFERIDA);
	}
	
	public boolean estaCanceladaPelaPrefeitura(){
		return equals(CANCELADA_PELA_PREFEITURA);
	}
	
	public boolean estaIndeferida(){
		return equals(INDEFERIDA);
	}
	
	public boolean estaProtocolada(){
		return equals(PROTOCOLADA);
	}

	public boolean isEmEstudo() {
		return EM_ESTUDO.equals(this);
	}

	public boolean isEmReestudo() {
		return EM_REESTUDO.equals(this);
	}

	public boolean estaEmAnaliseEspecifica(){
		return equals(SUJEITA_ANALISE_ESPECIFICA);
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public static SituacaoAnaliseEndereco obtemPorCodigo(String codigo) {
		for (SituacaoAnaliseEndereco situacaoAnaliseNome : values()) {
			if (situacaoAnaliseNome.getCodigo().equals(codigo)) {
				return situacaoAnaliseNome;
			}
		}

		return null;
	}
}
