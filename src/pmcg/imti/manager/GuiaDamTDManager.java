package pmcg.imti.manager;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.imti.domain.ArrGuiaDamTD;
import pmcg.imti.domain.EndPesGuiaDamTD;
import pmcg.imti.domain.PesGuiaDamTD;
import pmcg.imti.util.Formatacao;
import pmcg.imti.util.XMLCreateUtil;
import pmcg.imti.view.ws.AppWS;
import pmcg.imti.view.ws.AppWSProxy;

public class GuiaDamTDManager {

	private SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

	public HashMap<String, String> chamaWebService(HashMap<String, Object> dados) {
		HashMap<String, String> resposta = new HashMap<String, String>();
		AppWS ws = new AppWSProxy();
		String resp = "";
		try {
			resp = ws.solicitaGuiaDamTaxaDiversa(getXML(dados));
		} catch (RemoteException e) {
			e.printStackTrace();
			resp = "Exceção lançada: " + e.getMessage();
		}

		// LOG
		//System.out.println("tbPAR\n" + resp);
		
		// pega o código da guia
		String codGuia = resp.replaceAll("\n", "").replaceFirst("^.*<codigoGuia>", "").replaceFirst("</codigoGuia>.*", "");
		// pega o enderecoArquivo
		String endArq = resp.replaceAll("\n", "").replaceFirst("^.*<enderecoArquivo>", "").replaceFirst("</enderecoArquivo>.*", "");
		// pega a resposta
		String valResp = resp.replaceAll("\n", "").replaceFirst("^.*<resposta>", "").replaceFirst("</resposta>.*", "");
		// pega a mensagem
		String msgResp = resp.replaceAll("\n", "").replaceFirst("^.*<mensagem>", "").replaceFirst("</mensagem>.*", "");
		
		resposta.put("codigoGuia", codGuia);
		resposta.put("enderecoArquivo", endArq);
		resposta.put("resposta", valResp);
		resposta.put("mensagem", msgResp);
		
		return resposta;
	}

	public String getXML(HashMap<String, Object> dados) {
		String xml = "<Entrada>\n\t<EntradaSolicitaGuiaDamTaxaDiversa>";
		try {
			ArrGuiaDamTD guia = new ArrGuiaDamTD();
			guia.setCodigoTaxaDiversa(new CfgDAO().getValorByParam("GUIA_CODTAXA_VISA_URB")); //04 - GRUPO ISS 0401 - ISS PRÓPRIO
			guia.setCodigoCadastro("1"); // 1=Inscrição Municipal / 3=CPF/CNPJ
			guia.setNumeroCadastro(Formatacao.zeroEsquerda(dados.get("insmun").toString(),11)); // 11 digitos com zeros a esquerda
			
			guia.setQuantidadeParcelas(1);
			guia.setDataBaseLancamento("");
			guia.setObservacao(dados.get("observacao").toString());
			guia.setValorTaxaDiversa(String.format("%1$,.2f",dados.get("valor")).replace(".", "").replace(",", "."));
			//data de vencimento para o próximo dia (sem se preocupar com domingos/feriados pois o webservice já trata)
			Calendar proxDia = Calendar.getInstance();
			proxDia.setTime(new Date());
			proxDia.add(Calendar.DAY_OF_MONTH, 1);
			guia.setDataVencimento(df.format(proxDia.getTime()));
			guia.setImplantaTaxaDiversa("S");
			guia.setCodigoUnidadeOrganizacional(new CfgDAO().getValorByParam("GUIA_CODUNORG_VISA_URB"));
					
			PesGuiaDamTD pesg = new PesGuiaDamTD();
			EndPesGuiaDamTD endp = new EndPesGuiaDamTD();
			pesg.setEntradaGravaEnderecoPessoa(endp);
			guia.setEntradaGravaPessoa(new PesGuiaDamTD());
			
			xml += XMLCreateUtil.getElementName(guia, "\t\t"); //DADOS DA GUIA
		} catch (Exception e) {
			e.printStackTrace();
		}
		xml += "\n\t</EntradaSolicitaGuiaDamTaxaDiversa>\n</Entrada>";
		return xml;
	}

}
