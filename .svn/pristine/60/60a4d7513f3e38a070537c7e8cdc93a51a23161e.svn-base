package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@ZKEntity(label = "Col", sequence = "seqcol")
@XStreamAlias(value = "coleta")
public class ColVO {
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Long iddcol; //iddcol
	private Long cencol; //coletaEndereco
	private String coscol; //objetoSocial
		
	@XStreamAlias("coletaEndereco") @XStreamAsAttribute
	private CenVO coletaEndereco;
	@XStreamAlias("coletaObjetoSocial") @XStreamAsAttribute
	private CosVO coletaObjetoSocial;
	@XStreamImplicit(itemFieldName = "coletaSocio")
	private List<CsoVO> coletaSocio;
	@XStreamImplicit(itemFieldName = "coletaAtividadeEconomica")
	private List<CaeVO> coletaAtividadeEconomica;
	@XStreamImplicit(itemFieldName = "coletaPergunta")
	private List<CpeVO> coletaPergunta;
	@XStreamImplicit(itemFieldName = "coletaTipoUnidadeFormaAtuacao")
	private List<CfaVO> coletaTipoUnidadeFormaAtuacao;
	@XStreamAlias("codigoTipoUnidade") @XStreamAsAttribute
	private String ctucol; //codigoTipoUnidade
	
	
	//--------------------------------------------------------------------
	@XStreamOmitField
	private String formaAtuacaoAuxiliar; //forma de atuacao caso tipo unidade seja auxiliar(pq só pode 1)
	private Boolean p1 = false; // produtiva - 01 Sede
	private Boolean p2 = false; // produtiva - 02 Escritório...
	private Boolean p3 = false; // produtiva - 03
	private Boolean p4 = false; // produtiva - 04
	private Boolean p5 = false; // produtiva - 05
	private Boolean p6 = false; // produtiva - 06
	private Boolean p7 = false; // produtiva - 07

	
	public CenVO getColetaEndereco() {
		return coletaEndereco;
	}

	public List<CfaVO> getColetaTipoUnidadeFormaAtuacao() {
		return coletaTipoUnidadeFormaAtuacao;
	}

	public void setColetaTipoUnidadeFormaAtuacao(List<CfaVO> coletaTipoUnidadeFormaAtuacao) {
		this.coletaTipoUnidadeFormaAtuacao = coletaTipoUnidadeFormaAtuacao;
	}

	public void setColetaEndereco(CenVO coletaEndereco) {
		this.coletaEndereco = coletaEndereco;
	}

	public CosVO getColetaObjetoSocial() {
		return coletaObjetoSocial;
	}

	public void setColetaObjetoSocial(CosVO coletaObjetoSocial) {
		this.coletaObjetoSocial = coletaObjetoSocial;
	}

	public List<CsoVO> getColetaSocio() {
		return coletaSocio;
	}

	public void setColetaSocio(List<CsoVO> coletaSocio) {
		this.coletaSocio = coletaSocio;
	}

	public List<CaeVO> getColetaAtividadeEconomica() {
		return coletaAtividadeEconomica;
	}

	public void setColetaAtividadeEconomica(List<CaeVO> coletaAtividadeEconomica) {
		this.coletaAtividadeEconomica = coletaAtividadeEconomica;
	}

	public List<CpeVO> getColetaPergunta() {
		return coletaPergunta;
	}

	public void setColetaPergunta(List<CpeVO> coletaPergunta) {
		this.coletaPergunta = coletaPergunta;
	}
	
	public Long getIddcol() {
		return iddcol;
	}
	public void setIddcol(Long iddcol) {
		this.iddcol = iddcol;
	}
	public Long getCencol() {
		return cencol;
	}
	public void setCencol(Long cencol) {
		this.cencol = cencol;
	}
	public String getCoscol() {
		return coscol;
	}
	public void setCoscol(String coscol) {
		this.coscol = coscol;
	}
	public String getCtucol() {
		return ctucol;
	}
	public void setCtucol(String ctucol) {
		this.ctucol = ctucol;
	}

	public String getFormaAtuacaoAuxiliar() {
		return formaAtuacaoAuxiliar;
	}

	public void setFormaAtuacaoAuxiliar(String formaAtuacaoAuxiliar) {
		this.formaAtuacaoAuxiliar = formaAtuacaoAuxiliar;
	}

	public Boolean getP1() {
		return p1;
	}

	public void setP1(Boolean p1) {
		this.p1 = p1;
	}

	public Boolean getP2() {
		return p2;
	}

	public void setP2(Boolean p2) {
		this.p2 = p2;
	}

	public Boolean getP3() {
		return p3;
	}

	public void setP3(Boolean p3) {
		this.p3 = p3;
	}

	public Boolean getP4() {
		return p4;
	}

	public void setP4(Boolean p4) {
		this.p4 = p4;
	}

	public Boolean getP5() {
		return p5;
	}

	public void setP5(Boolean p5) {
		this.p5 = p5;
	}

	public Boolean getP6() {
		return p6;
	}

	public void setP6(Boolean p6) {
		this.p6 = p6;
	}

	public Boolean getP7() {
		return p7;
	}

	public void setP7(Boolean p7) {
		this.p7 = p7;
	}

	
	

}
