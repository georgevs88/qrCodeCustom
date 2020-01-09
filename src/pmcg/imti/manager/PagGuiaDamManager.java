package pmcg.imti.manager;

import java.rmi.RemoteException;
import java.util.HashMap;

import pmcg.imti.view.ws.AppWS;
import pmcg.imti.view.ws.AppWSProxy;

public class PagGuiaDamManager {
	public HashMap<String, String> chamaWebService(String codGuia) {
		HashMap<String, String> resposta = new HashMap<String, String>();
		AppWS ws = new AppWSProxy();
		String resp = "";
		try {
			resp = ws.verificaPagamentoGuia(getXML(codGuia));
		} catch (RemoteException e) {
			e.printStackTrace();
			resp = "Exceção lançada: " + e.getMessage();
		}
		
		// pega o código da guia
		String codGuiaDam = resp.replaceAll("\n", "").replaceFirst("^.*<codigoGuiaDam>", "").replaceFirst("</codigoGuiaDam>.*", "");
		// pega a resposta
		String valResp = resp.replaceAll("\n", "").replaceFirst("^.*<resposta>", "").replaceFirst("</resposta>.*", "");
		// pega a mensagem
		String msgResp = resp.replaceAll("\n", "").replaceFirst("^.*<mensagem>", "").replaceFirst("</mensagem>.*", "");
		
		resposta.put("codigoGuiaDam", codGuiaDam);
		resposta.put("resposta", valResp);
		resposta.put("mensagem", msgResp);
		
		return resposta;
	}

	public String getXML(String codGuia) {
		String xml = "<Entrada>\n\t<EntradaVerificaPagamentoGuia>";
		      xml += "\n\t\t<codigoGuiaDam>" + codGuia + "</codigoGuiaDam>";
		      xml += "\n\t</EntradaVerificaPagamentoGuia>\n</Entrada>";
		return xml;
	}

}
