package pmcg.imti.manager;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pmcg.imti.view.ws.AppWS;
import pmcg.imti.view.ws.AppWSProxy;

public class GravaCadEconManager {
	
	private static final Logger logger = LoggerFactory.getLogger(GravaCadEconManager.class);

	public HashMap<String, String> chamaWebService(String xml) {
		HashMap<String, String> resposta = new HashMap<String, String>();
		AppWS ws = new AppWSProxy();
		String resp = "";
		try {
			resp = ws.gravaCadastroEconomico(xml);
		} catch (RemoteException e) {
			e.printStackTrace();
			resp = "Exceção lançada: " + e.getMessage();
		}

		// LOG
		logger.error(resp);
		//System.out.println("tbPAR\n" + resp);
		
		// pega a resposta
		String valResp = resp.replaceAll("\n", "").replaceFirst("^.*<resposta>", "").replaceFirst("</resposta>.*", "");
		// pega a mensagem
		String msgResp = resp.replaceAll("\n", "").replaceFirst("^.*<mensagem>", "").replaceFirst("</mensagem>.*", "");
		// pega a Inscricao Municipal
		String valInsc = resp.replaceAll("\n", "").replaceFirst("^.*<inscricaoMunicipal>", "").replaceFirst("</inscricaoMunicipal>.*", "");
		
		resposta.put("resposta", valResp);
		resposta.put("mensagem", msgResp);
		resposta.put("inscricaoMunicipal", valInsc);
		
		return resposta;
	}
}
