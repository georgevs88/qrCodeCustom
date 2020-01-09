package pmcg.imti.view.ext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.fcn.dao.ibatis.CpeDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.LmaDAO;
import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.LmaVO;
import pmcg.fcn.domain.RequerimentoConsultaViabilidadeVO;
import pmcg.fcn.domain.RequerimentoEmpreendimentoPrefeituraVO;
import pmcg.fcn.prefeitura.ClienteEmpreendimento;
import pmcg.fcn.prefeitura.ClienteViabilidade;
import pmcg.fcn.prefeitura.Constantes;
import pmcg.imti.dao.ibatis.ImoDAO;

public class Status extends WindowExt{
private static final long serialVersionUID = 1L;
	public String requisicaoVia;
	public String respostaVia;
	public String requisicaoEpd;
	public String respostaEpd;
	public String senha;
	public Boolean falhaVia = false;
	public Boolean falhaEpd = false;
	
	@SuppressWarnings("static-access")
	public void initComponentes() throws Exception{
		RequerimentoConsultaViabilidadeVO req = new RequerimentoConsultaViabilidadeVO();
		req.setMaximoConsultas(50L);
		requisicaoVia = req.toXml(req);
		
		RequerimentoEmpreendimentoPrefeituraVO reqEpd = new RequerimentoEmpreendimentoPrefeituraVO();
		reqEpd.setMaximoRegistros(50L);
		requisicaoEpd = reqEpd.toXml(reqEpd);
		
		//TESTAR GRAVA��O DA LICENCA
    	// iddepd baixo = 5955
    	//iddepd alto = 5945
    	//iddepd medio = 5940
    	
//    	EpdVO epdp = new EpdDAO().getRegByCod(5948L);
//    	String nprepd = epdp.getNprepd();
//    	HashMap<String, Object> nprepdParam = new HashMap<String, Object>();
//		nprepdParam.put("nprepd", nprepd);
//    	HashMap<String, Object> dados = new EpdDAO().getDadosInsmun(nprepdParam);
//		HashMap<String, Object> matriz = new MatDAO().getMatrizByProcesso(Long.parseLong(dados.get("iddpro").toString())); //ASSUMINDO QUE SEMPRE SER� 1 MATRIZ PARA CADA PROCESSO
//		if(dados.get("ambaen").toString().equalsIgnoreCase("B")){
//			LmaVO lma = new LmaVO();
//			lma.setEsplma("DISPENSA");
//			lma.setProlma(nprepd);
//			lma.setEmilma(new Date());
//			lma.setVallma(null);
//			lma.setReqlma(matriz.get("nommat").toString());
//			lma.setAtvlma(matriz.get("desmat").toString());
//			lma.setEdrlma(matriz.get("endmat").toString());
//			String iptu = new EpdDAO().getInscricaoByProcesso(nprepd);
//			lma.setReglma(new ImoDAO().getRegiaoImovel(iptu));
//			lma.setAnolma(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())));
//			lma.setAsslma("JEANN PIERRE DE FREITAS");
//			String haveramusica = new CpeDAO().getMusicaByIddepd(epdp.getIddepd());
//			lma.setMuslma(haveramusica.equalsIgnoreCase("S")?false:true); //SE HAVER� M�SICA, MUSLMA = FALSE PQ N�O IR� APARECER A MSG "N�O AUTORIZADO M�SICA"...
//			lma.setUsualt("CIMWEB");
//			lma.setSitlma("A");
//			Long iddlma = (Long) new LmaDAO().insReg(lma);
//			if(iddlma != null && iddlma > 0){
//				epdp.setLmaepd(iddlma);
//				new EpdDAO().updLicencaAmb(epdp);
//			}
//		}
		
		this.vincular();
	}
	
	public void analisar() throws Exception{
		if(senha == null || senha.isEmpty()){
			throw new WrongValueException(this.getComponente("senha"), "Informe a Senha!");
		}
		if(senha!= null && senha.equals(Constantes.Certificados.senha_pfx)){
			respostaVia = ClienteViabilidade.recuperaViabilidadesPendentes();
			String tipoRetorno = respostaVia.replaceAll("TipoRetorno", "tipoRetorno").replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
			if(tipoRetorno != null && tipoRetorno.equals("FALHA")){
				falhaVia = true;
			} else {
				falhaVia = false;
			}
			//EPD
			respostaEpd = ClienteEmpreendimento.recuperaEmpreendimentosDeferidosParaPrefeitura();
			tipoRetorno = respostaEpd.replaceAll("TipoRetorno", "tipoRetorno").replaceAll("\n", "").replaceFirst("^.*<tipoRetorno>", "").replaceFirst("</tipoRetorno>.*", "");
			if(tipoRetorno != null && tipoRetorno.equals("FALHA")){
				falhaEpd = true;
			} else {
				falhaEpd = false;
			}
			this.vincular();
		} else {
			throw new WrongValueException(this.getComponente("senha"), "Senha Incorreta!");
		}
	}
}
