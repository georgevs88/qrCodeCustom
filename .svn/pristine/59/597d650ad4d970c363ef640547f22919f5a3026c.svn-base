package pmcg.imti.view;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.RespostaProcessamentoVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.prefeitura.ClienteEmpreendimento;
import pmcg.fcn.prefeitura.ClienteViabilidade;
import pmcg.fcn.prefeitura.ImportacaoJunta;
import pmcg.fcn.prefeitura.Util;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Gerfcn extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public Date datmva = new Date();
	public String tiplta;
	public List<ViaVO> listViaPendente;
	public ViaVO viaPendenteSel;
	public List<HashMap<String,Object>> listViaGravado;
	public HashMap<String,Object> viaGravadoSel;
	public String provia = "";
	public List<EpdVO> listEpdPendente;
	public EpdVO epdPendenteSel;
	public List<HashMap<String,Object>> listEpdGravado;
	public HashMap<String,Object> epdGravadoSel;
	public String nprepd = ""; //nr processo epd - filtro
	public List<HashMap<String,Object>> listBaes;
	public HashMap<String,Object> baeSel;
	public Boolean analisespendentes = false;
	public Boolean alteracoespendentes = false;
	public Boolean inscricoespendentes = false;
	public Boolean inscricoesbaependentes = false;
	public String qtdViaPend;
	public String qtdEpdPend;
	public String qtdViaGrav;
	public String qtdEpdGrav;
	public String qtdBae;
	public Boolean grava_via = false;
	public Boolean resp_via = false;
	public Boolean grava_emp = false;
	public Boolean resp_emp = false;
		
	public void initComponentes(){
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(5).setVisible(false);
		buscarViaEpdGravado();
	}
	
	public void buscarViaEpdPendentes(){
		String xml = null;
		try {
			xml = ClienteViabilidade.recuperaViabilidadesPendentes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		xml = xml.replaceAll("TipoRetorno", "tipoRetorno");
		RespostaProcessamentoVO resp = RespostaProcessamentoVO.fromXml(xml);
		listViaPendente = resp.getViabilidade();
		if(listViaPendente!= null && listViaPendente.size() > 0){
			qtdViaPend = "(" + listViaPendente.size() + ")";
		} else {
			qtdViaPend = "";
		}
		try {
			xml = ClienteEmpreendimento.recuperaEmpreendimentosDeferidosParaPrefeitura();
		} catch (Exception e) {
			e.printStackTrace();
		}
		xml = xml.replaceAll(" class=\"sql-date\"", "").replaceAll(" class=\"sql-timestamp\"", "");
		xml = xml.replaceAll("TipoRetorno", "tipoRetorno");
		resp = RespostaProcessamentoVO.fromXml(xml);
		listEpdPendente = resp.getEmpreendimentos()!=null?resp.getEmpreendimentos().getEmpreendimento():null;
		if(listEpdPendente!= null && listEpdPendente.size() > 0){
			qtdEpdPend = "(" + listEpdPendente.size() + ")";
		} else {
			qtdEpdPend = "";
		}
		this.vincular();
	}
	
	public void buscarViaEpdGravado(){
		buscaViaGravadas();
		buscaEpdGravados(0);
		buscaBaes();
	}
	
	public void buscaViaGravadas(){
		//VIABILIDADES GRAVADAS
		Paging pagV = (Paging) this.getComponente("pagViaG");
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("provia", provia!=null&&(!provia.isEmpty())?provia:null); 
		param.put("analisespendentes", analisespendentes!=null&&analisespendentes?true:false);
		pagV.setTotalSize(new ViaDAO().countViaGravadas(param));
		if(pagV.getTotalSize() > 0){
			qtdViaGrav = "(" + pagV.getTotalSize() + ")";
		} else {
			qtdViaGrav = "";
		}
		final int PAGE_SIZEV = pagV.getPageSize();
		redrawViaG(0, PAGE_SIZEV);
		pagV.setActivePage(0);
		pagV.setDetailed(true);
		pagV.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZEV;
				redrawViaG(ofs, PAGE_SIZEV);
				vincular();
			}
		});
		vincular();
	}
	
	public void buscaEpdGravados(Integer opcao){
		if(opcao == 1){
			inscricoespendentes = true;
			alteracoespendentes = false;
		} else if(opcao == 2){
			inscricoespendentes = false;
			alteracoespendentes = true;
		}
		//EMPREENDIMENTOS GRAVADOS
		Paging pag = (Paging) this.getComponente("pagEpdG");
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("nprepd", nprepd!=null&&(!nprepd.isEmpty())?nprepd:null); 
		param.put("alteracoespendentes", alteracoespendentes!=null&&alteracoespendentes?true:false);
		param.put("inscricoespendentes", inscricoespendentes!=null&&inscricoespendentes?true:false);
		pag.setTotalSize(new EpdDAO().countEpdGravados(param));
		if(pag.getTotalSize() > 0){
			qtdEpdGrav = "(" + pag.getTotalSize() + ")";
		} else {
			qtdEpdGrav = "";
		}
		final int PAGE_SIZE = pag.getPageSize();
		redrawEpdG(0, PAGE_SIZE);
		pag.setActivePage(0);
		pag.setDetailed(true);
		pag.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZE;
				redrawEpdG(ofs, PAGE_SIZE);
				vincular();
			}
		});
		vincular();
	}
	
	public void buscaBaes(){
		//VIABILIDADES GRAVADAS
		Paging pagB = (Paging) this.getComponente("pagBae");
		HashMap<String, Object> param = new HashMap<String, Object>();
		if(inscricoesbaependentes != null && inscricoesbaependentes){
			param.put("respostapendente", true); 
			param.put("pendenteouconcluido", null); 
		} else {
			param.put("respostapendente", null); 
			param.put("pendenteouconcluido", true); 
		}
		pagB.setTotalSize(new BaeDAO().countBae(param));
		if(pagB.getTotalSize() > 0){
			qtdBae = "(" + pagB.getTotalSize() + ")";
		} else {
			qtdBae = "";
		}
		final int PAGE_SIZEV = pagB.getPageSize();
		redrawBaes(0, PAGE_SIZEV);
		pagB.setActivePage(0);
		pagB.setDetailed(true);
		pagB.addEventListener("onPaging", new EventListener() {
			public void onEvent(Event event) {
				PagingEvent pe = (PagingEvent) event;
				int pgno = pe.getActivePage();
				int ofs = pgno * PAGE_SIZEV;
				redrawViaG(ofs, PAGE_SIZEV);
				vincular();
			}
		});
		vincular();
	}
	
	private void redrawViaG(Integer inicial, Integer maximoPermitido) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("provia", provia!=null&&(!provia.isEmpty())?provia:null); 
		param.put("analisespendentes", analisespendentes!=null&&analisespendentes?true:false);
		listViaGravado = new ViaDAO().getViaGravadasLimit(param, inicial, maximoPermitido);
	}
	
	private void redrawEpdG(Integer inicial, Integer maximoPermitido) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("nprepd", nprepd!=null&&(!nprepd.isEmpty())?nprepd:null); 
		param.put("alteracoespendentes", alteracoespendentes!=null&&alteracoespendentes?true:false);
		param.put("inscricoespendentes", inscricoespendentes!=null&&inscricoespendentes?true:false);
		listEpdGravado = new EpdDAO().getEpdGravadosLimit(param, inicial, maximoPermitido);
	}
	
	private void redrawBaes(Integer inicial, Integer maximoPermitido) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		if(inscricoesbaependentes != null && inscricoesbaependentes){
			param.put("respostapendente", true); 
			param.put("pendenteouconcluido", null); 
		} else {
			param.put("respostapendente", null); 
			param.put("pendenteouconcluido", true); 
		}
		listBaes = new BaeDAO().getBaeLimit(param, inicial, maximoPermitido);
	}
	
	public void gravaVia() throws InterruptedException{
		if(viaPendenteSel != null){
			if (Messagebox.show("Fazendo a gravação manualmente o xml não será gravado no histórico. \nTem certeza que deseja Gravar?", "Gravar Viabilidade", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
				Integer qtdVia = new ViaDAO().countViaByProtocolo(viaPendenteSel.getProvia());
				if(qtdVia != null && qtdVia <= 0){
					Util.gravaViabilidade(viaPendenteSel);
					buscarViaEpdPendentes();
					buscarViaEpdGravado();
				} else {
					try {
						Messagebox.show("Viabilidade " + viaPendenteSel.getProvia() + "já gravada. Deve ser feita a Confirmação de Recebimento.", "Grava Viabilidade", Messagebox.OK, Messagebox.INFORMATION);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void gravaEpd() throws InterruptedException{
		if(epdPendenteSel != null){
			if (Messagebox.show("Fazendo a gravação manualmente o xml não será gravado no histórico. \nTem certeza que deseja Gravar?", "Gravar Empreendimento", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
				Integer qtdEpd = new EpdDAO().countEpdByProcesso(epdPendenteSel.getNprepd());
				if(qtdEpd != null && qtdEpd <= 0){
					Util.gravaEmpreendimento(epdPendenteSel);
					buscarViaEpdPendentes();
					buscarViaEpdGravado();
				} else {
					try {
						Messagebox.show("Processo " + epdPendenteSel.getNprepd() + " já gravado. Deve ser feita a Confirmação de Recebimento.", "Grava Empreendimento", Messagebox.OK, Messagebox.INFORMATION);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public void confirmaRecVia(){
		Util.confirmaRecebimentoVia(viaGravadoSel.get("provia").toString());
		buscarViaEpdGravado();
	}
	
	public void confirmaRecEpd(){
		EpdVO epd = new EpdDAO().getRegByProcesso(epdGravadoSel.get("nprepd").toString());
		Util.confirmaRecebimentoEpd(epd);
		buscarViaEpdGravado();
	}
	
	public void analisaEnderecoVia() throws IOException{
		Long iddvia = Long.parseLong(viaGravadoSel.get("iddvia").toString());
		Util.confirmaEndereco(viaGravadoSel.get("provia").toString(),iddvia);
		buscarViaEpdGravado();
	}
	
	public void processarImportacao(Integer opcao){
		try {
			if (Messagebox.show("Esta processo pode demorar vários minutos. \nTem certeza que deseja continuar?", "Importação JUNTA", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
				if(opcao == 1){
					new ImportacaoJunta().importa();
				} else {
					new ImportacaoJunta().importa(grava_via,resp_via,grava_emp,resp_emp);
				}
				buscarViaEpdGravado();
				Messagebox.show("Processo Concluído.", "Importação JUNTA", Messagebox.OK, Messagebox.INFORMATION);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void confAlvInscMun(){
		try {
			Util.responderEmpreendimento(epdGravadoSel.get("nprepd").toString());
			buscarViaEpdGravado();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Messagebox.show("Não foi possível Responder o Empreendimento: " + e.getMessage(), "Importação JUNTA", Messagebox.OK, Messagebox.INFORMATION);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void confAlvInscMunBae(){
		try {
			BaeVO baeResp = new BaeDAO().getBaeByViabae(baeSel.get("viabae").toString());
			Util.responderBae(baeResp);
			buscaBaes();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				Messagebox.show("Não foi possível Responder o Bae: " + e.getMessage(), "Importação JUNTA", Messagebox.OK, Messagebox.INFORMATION);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void consultarEpd(Listitem item){
		HashMap<String,Object> epd = (HashMap<String, Object>) item.getValue();
		if(epd != null && epd.get("nprepd") != null){
			Map<String, String> param = new HashMap<String, String>();
			param.put("nprepd", epd.get("nprepd").toString());
			new WinUtils().abrirLis("/forms/conepd.zul", param, this, null);
		}
	}
	
	public void consultarBae(Listitem item){
		HashMap<String,Object> bae = (HashMap<String, Object>) item.getValue();
		if(bae != null && bae.get("viabae") != null){
			Map<String, String> param = new HashMap<String, String>();
			param.put("viabae", bae.get("viabae").toString());
			new WinUtils().abrirLis("/forms/conbae.zul", param, this, null);
		}
	}
	
	@Override
	public void pesquisar() throws InterruptedException {
		
		vincular();
	}
	
	@Override
	public void incluir() throws InterruptedException {
	}

	@Override
	public void salvar() throws InterruptedException {
	}

	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
		analisespendentes = false;
		alteracoespendentes = false;
		inscricoespendentes = false;
		provia = "";
		nprepd = "";
		buscarViaEpdGravado();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		this.detach();	
	}

}
