package pmcg.fcn.siat.domain.ws;

import java.math.BigDecimal;

import pmcg.fcn.siat.domain.Boleano;
import pmcg.fcn.siat.domain.TipoImovelMob;
import pmcg.fcn.siat.domain.UsoImovelMob;


/**
 * Classe que representa a Entrada do Endereço de Localização do Cadastro
 * Sincronizado. Classe não persistida.
 * @author George do Valle
 * @version 1.0
 * @updated 04-ago-2009 10:53:39
 */
public class EntradaEnderecoLocalizacaoGravaCadastroEconomico extends EntradaEnderecoGravaCadastroEconomico {

	private BigDecimal areaTerrenoUtilizada; //Área do Terreno Utilizada; opcional
	
	private Boleano enderecoComercialOficial; ////NotNull  Indica se o Endereço de Localização é o oficial; obrigatório
	
	private String referencia; ////Length(max = 250) Referência; opcional
	
	private TipoImovelMob tipoImovel; //NotNull Tipo do Imóvel; obrigatório
	
	private UsoImovelMob usoImovel; //NotNull Uso do Imóvel; obrigatório
	
	//-----------------------------------------------------------------------------------------
	
	public BigDecimal getAreaTerrenoUtilizada() {
		return areaTerrenoUtilizada;
	}
	
	public void setAreaTerrenoUtilizada(BigDecimal areaTerrenoUtilizada) {
		this.areaTerrenoUtilizada = areaTerrenoUtilizada;
	}
	
	public Boleano getEnderecoComercialOficial() {
		return enderecoComercialOficial;
	}
	
	public void setEnderecoComercialOficial(Boleano enderecoComercialOficial) {
		this.enderecoComercialOficial = enderecoComercialOficial;
	}
	
	public String getReferencia() {
		return referencia;
	}
	
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public TipoImovelMob getTipoImovel() {
		return tipoImovel;
	}
	
	public void setTipoImovel(TipoImovelMob tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public UsoImovelMob getUsoImovel() {
		return usoImovel;
	}

	public void setUsoImovel(UsoImovelMob usoImovel) {
		this.usoImovel = usoImovel;
	}
}