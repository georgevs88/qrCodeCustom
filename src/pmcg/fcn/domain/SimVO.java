package pmcg.fcn.domain;

import gerador.annotation.ZKEntity;
import gerador.annotation.ZKField;
import gerador.annotation.ZKId;

import java.util.Date;

import pmcg.framework.domain.ConcorrenciaVO;

@ZKEntity(label = "Simulação", sequence = "SE_SIMULASIM")
public class SimVO implements ConcorrenciaVO{
	@ZKId
	@ZKField(label = "Código", artigo = "o", readonly = true, maxsize = 80, tooltip = "Código incremental!")
	private Integer idsim; //ID
	private String inscrisim; //INSCRICAO_IMOBILIARIA
	private String tipendsim; //TIPO_LOCALIZAÇÃO - E=EMPRESA / M=MEI
	private String tipimosim; //TIPO_DO_IMÓVEL - T=TERRITORIAL / P=PREDIAL
	private String tiplgrsim; //TIPO_LOGRADOURO
	private String logradsim; //LOGRADOURO
	private Integer numerosim; //NUMERO
	private Double aretersim; //AREA_TERRENO
	private Double areconsim; //AREA_CONSTRUÍDA
	private Double areampsim; //AREA_A_AMPLIAR
	private Double areunisim; //AREA_A_AMPLIAR
	private Double fraidesim; //AREA_A_AMPLIAR
	private String complesim; //COMPLEMENTO
	private String tipbaisim; //TIPO_BAIRRO
	private String bairrosim; //BAIRRO
	private String cidadesim; //CIDADE
	private String ufsim; //UF
	private Double testadsim; //TESTADA
	private String zonasim; //ZONAS
	private String usosim; //USOS
	private String protocsim; //PROTOCOLO
	private String lotesim; //LOTE
	private String quadrasim; //QUADRA
	private String usoimosim; //USO_DO_IMOVEL ( M=MISTO, N=NÃO RESIDENCIAL, R = RESIDENCIAL )
	private String sitimosim; //SITUACAO_DO_IMOVEL ( A=ALUGADO, C=CEDIDO, P=PRÓPRIO )
	private String atvlocsim; //ATIVIDADE_EXERCIDA_NO_LOCAL ( S=SIM, N=NAO )
	private String cepsim; //CEP
	private String sitautsim; //SITUACAO_AUTONOMO ( E=ESTABELECIDO, N=NAO ESTABELECIDO )
	private String empindsim; //EMREENDEDOR_INDIVIDUAL ( DO="Domicílio",SP="Sede Permanente",CL="No Cliente",CP="Vias Públicas, com ponto fixo",SP="Vias Públicas, sem ponto fixo" )
	private Integer idnat; //NATUREZA
//	private Integer constisim; //NATUREZA
//	private String nomempsim; //NOME_EMPRESARIAL_PRETENDIDO
//	private String sitgersim; //SITUACAO_GERAL_VIABILIDADE (CONSTITUICAO) - P=PERMITIDA, A=EM ANALISE, N=NAO PERMITIDA
//	private String risgersim; //RISCO_GERAL_VIABILIDADE (CONSTITUICAO) - B=BAIXO, M=MEDIO, A=ALTO
//	private String proconsim; //PROTOCOLO DO PROCESSO (CONSTITUICAO)

	
	private String usualt; //
	private Date datalt; //
	
	private NjrVO njrVO; //NATUREZA
	
	public String getInscrisim() {
		return inscrisim;
	}
	public void setInscrisim(String inscrisim) {
		this.inscrisim = inscrisim;
	}
	public Integer getIdsim() {
		return idsim;
	}
	public void setIdsim(Integer idsim) {
		this.idsim = idsim;
	}
	public String getTipendsim() {
		return tipendsim;
	}
	public void setTipendsim(String tipendsim) {
		this.tipendsim = tipendsim;
	}
	public String getTipimosim() {
		return tipimosim;
	}
	public void setTipimosim(String tipimosim) {
		this.tipimosim = tipimosim;
	}
	public String getTiplgrsim() {
		return tiplgrsim;
	}
	public void setTiplgrsim(String tiplgrsim) {
		this.tiplgrsim = tiplgrsim;
	}
	public String getLogradsim() {
		return logradsim;
	}
	public void setLogradsim(String logradsim) {
		this.logradsim = logradsim;
	}
	public Integer getNumerosim() {
		return numerosim;
	}
	public void setNumerosim(Integer numerosim) {
		this.numerosim = numerosim;
	}
	public Double getAretersim() {
		return aretersim;
	}
	public void setAretersim(Double aretersim) {
		this.aretersim = aretersim;
	}
	public Double getAreconsim() {
		return areconsim;
	}
	public void setAreconsim(Double areconsim) {
		this.areconsim = areconsim;
	}
	public Double getAreampsim() {
		return areampsim;
	}
	public void setAreampsim(Double areampsim) {
		this.areampsim = areampsim;
	}
	public String getComplesim() {
		return complesim;
	}
	public void setComplesim(String complesim) {
		this.complesim = complesim;
	}
	public String getTipbaisim() {
		return tipbaisim;
	}
	public void setTipbaisim(String tipbaisim) {
		this.tipbaisim = tipbaisim;
	}
	public String getBairrosim() {
		return bairrosim;
	}
	public void setBairrosim(String bairrosim) {
		this.bairrosim = bairrosim;
	}
	public String getCidadesim() {
		return cidadesim;
	}
	public void setCidadesim(String cidadesim) {
		this.cidadesim = cidadesim;
	}
	public String getUfsim() {
		return ufsim;
	}
	public void setUfsim(String ufsim) {
		this.ufsim = ufsim;
	}
	public Double getTestadsim() {
		return testadsim;
	}
	public void setTestadsim(Double testadsim) {
		this.testadsim = testadsim;
	}
	public String getZonasim() {
		return zonasim;
	}
	public void setZonasim(String zonasim) {
		this.zonasim = zonasim;
	}
	public String getUsosim() {
		return usosim;
	}
	public void setUsosim(String usosim) {
		this.usosim = usosim;
	}
	public String getProtocsim() {
		return protocsim;
	}
	public void setProtocsim(String protocsim) {
		this.protocsim = protocsim;
	}
	public String getUsualt() {
		return usualt;
	}
	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}
	public Date getDatalt() {
		return datalt;
	}
	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}
	@Override
	public Date getAge() {
		return datalt;
	}
	@Override
	public void setAge(Date age) {
		this.datalt = age;
	}
	public Double getAreunisim() {
		return areunisim;
	}
	public void setAreunisim(Double areunisim) {
		this.areunisim = areunisim;
	}
	public Double getFraidesim() {
		return fraidesim;
	}
	public void setFraidesim(Double fraidesim) {
		this.fraidesim = fraidesim;
	}
	public String getLotesim() {
		return lotesim;
	}
	public void setLotesim(String lotesim) {
		this.lotesim = lotesim;
	}
	public String getQuadrasim() {
		return quadrasim;
	}
	public void setQuadrasim(String quadrasim) {
		this.quadrasim = quadrasim;
	}
	public String getUsoimosim() {
		return usoimosim;
	}
	public void setUsoimosim(String usoimosim) {
		this.usoimosim = usoimosim;
	}
	public String getSitimosim() {
		return sitimosim;
	}
	public void setSitimosim(String sitimosim) {
		this.sitimosim = sitimosim;
	}
	public String getAtvlocsim() {
		return atvlocsim;
	}
	public void setAtvlocsim(String atvlocsim) {
		this.atvlocsim = atvlocsim;
	}
	public String getCepsim() {
		return cepsim;
	}
	public void setCepsim(String cepsim) {
		this.cepsim = cepsim;
	}
	public String getSitautsim() {
		return sitautsim;
	}
	public void setSitautsim(String sitautsim) {
		this.sitautsim = sitautsim;
	}
	public String getEmpindsim() {
		return empindsim;
	}
	public void setEmpindsim(String empindsim) {
		this.empindsim = empindsim;
	}
	public Integer getIdnat() {
		return idnat;
	}
	public void setIdnat(Integer idnat) {
		this.idnat = idnat;
	}
	
	public NjrVO getNjrVO() {
		return njrVO;
	}
	public void setNjrVO(NjrVO njrVO) {
		this.njrVO = njrVO;
	}
	public String getTipoImovel() {
		if(tipimosim!=null) {
			if(tipimosim.equals("P")){
				return "PREDIAL";
			} else if(tipimosim.equals("T")){
				return "TERRITORIAL";
			}
		}
		return null;
	}
	public String getUsoImovel() {
		if(usoimosim!=null) {
			if(usoimosim.equals("M")){
				return "MISTO";
			} else if(usoimosim.equals("R")){
				return "RESIDENCIAL";
			} else if(usoimosim.equals("N")){
				return "NÃO RESIDENCIAL";
			}
		}
		return null;
	}
	public String getSituacaoImovel() {
		if(sitimosim!=null) {
			if(sitimosim.equals("A")){
				return "ALUGADO";
			} else if(sitimosim.equals("C")){
				return "CEDIDO";
			} else if(sitimosim.equals("P")){
				return "PRÓPRIO";
			}
		}
		return null;
	}
	public String getExercidaNoLocal() {
		if(atvlocsim!=null) {
			if(atvlocsim.equals("S")){
				return "SIM";
			} else if(atvlocsim.equals("N")){
				return "NÃO";
			} 
		}
		return null;
	}
	public String getAreaConstrucao(){
		if(areconsim!= null)
			return String.format("%.2f", areconsim); //%1$,.2f
		else
			return null;
	}
	public String getAreaTerreno(){
		if(aretersim!= null)
			return String.format("%.2f", aretersim); 
		else
			return null;
	}
	public String getAreaAmpliar(){
		if(areampsim!= null)
			return String.format("%.2f", areampsim); 
		else
			return null;
	}
	public String getAreaUnitaria(){
		if(areunisim!= null)
			return String.format("%.2f", areunisim); 
		else
			return null;
	}
	public String getTestada(){
		if(testadsim!= null)
			return String.format("%.2f", testadsim); 
		else
			return null;
	}
	public String getFracaoIdeal(){
		if(fraidesim!= null)
			return String.format("%.2f", fraidesim); 
		else
			return null;
	}
	public String getCepFormatado() {
		if (cepsim != null){
			if (cepsim.length()==8){
				return cepsim.substring(0, 5) + "-" + cepsim.substring(5, 8);
			} else{
				return cepsim;
			}
		} else {
			return "";
		}
	}
	public String getBairroFormatado() {
		if (bairrosim != null && tipbaisim != null){
			return tipbaisim + " " + bairrosim;
		} else {
			return "";
		}
	}
	public String getEnderecoFormatado() {
		return tiplgrsim + " " + logradsim + ", nº " + numerosim+ "."; 
	}
	public String getCidadeUf() {
		return cidadesim + " / " + ufsim;
	}


}
