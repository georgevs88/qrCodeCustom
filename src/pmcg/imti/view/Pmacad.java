package pmcg.imti.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.api.Button;

import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.dao.ibatis.PmaDAO;
import pmcg.fcn.dao.ibatis.RpmDAO;
import pmcg.fcn.domain.LmaVO;
import pmcg.fcn.domain.PmaVO;
import pmcg.fcn.domain.RpmVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;

public class Pmacad extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public PmaVO pmaVO = new PmaVO();
	public RpmVO rpmVO = new RpmVO();
	public LmaVO lmaVO = new LmaVO();
	public boolean btnLicensa = true;
	
	public void initComponentes() throws SQLException{
		//pmaVO = new PmaDAO().getRegByCod(2753L);
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		//retPma(new PmaDAO().getRegByCod(5687L));
		atualizaTela();
	}
	
	public void atualizaTela(){
		
		if(pmaVO != null && pmaVO.getIddpma() != null){
			getCrdBar().getBotao(0).setVisible(false);
			getCrdBar().getBotao(1).setVisible(true);
			getCrdBar().getBotao(2).setVisible(true);
			getCrdBar().getBotao(3).setVisible(true);
			getCrdBar().getBotao(4).setVisible(true);
			getCrdBar().getBotao(5).setVisible(false);
		} else {
			getCrdBar().getBotao(0).setVisible(true);
			getCrdBar().getBotao(1).setVisible(false);
			getCrdBar().getBotao(2).setVisible(false);
			getCrdBar().getBotao(3).setVisible(true);
			getCrdBar().getBotao(4).setVisible(true);
			getCrdBar().getBotao(5).setVisible(false);
		}
		validaPerfil676();
		vincular();
	}
	
	public void verificaProcesso() throws InterruptedException{
		if(pmaVO.getIddpma() == null){
			PmaVO pma = new PmaDAO().getRegByPrapma(pmaVO.getPrapma());
			if(pma != null && pma.getIddpma() != null){
				if (Messagebox.show("Processo j� cadastrado! Deseja recuperar o registro?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
					try {
						retPma(pma);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
	public void salvar() throws InterruptedException {
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Salvar o Processo?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				Integer codupd = new PmaDAO().updRegByCod(pmaVO);
				if(codupd != null && codupd > 0){
					Messagebox.show("Processo salvo com sucesso!");
					atualizaTela();
				} else {
					Messagebox.show("N�o foi poss�vel salvar o Processo!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void trataVO() {
		if(pmaVO.getPrapma() == null){
			throw new WrongValueException(getComponente("prapma"),"Informe o Nr do Processo Administrativo!");
		}
		if(pmaVO.getDatpma() == null){
			throw new WrongValueException(getComponente("datpma"),"Informe a Data do Processo!");
		}
		if(pmaVO.getReqpma() == null){
			throw new WrongValueException(getComponente("reqpma"),"Informe o Requerente!");
		}
		if(pmaVO.getAtvpma() == null){
			throw new WrongValueException(getComponente("atvpma"),"Informe a Atividade!");
		}
		if(pmaVO.getEdrpma() == null){
			throw new WrongValueException(getComponente("edrpma"),"Informe o Endere�o!");
		}
		pmaVO.setAnopma(Integer.parseInt(new SimpleDateFormat("yyyy").format(pmaVO.getDatpma())));
		pmaVO.setUsualt(getLogin());
	}
	
	public void pesquisar() {
		new WinUtils().abrirLis("/forms/pmalis.zul", null, this, "retPma");
	}
	
	public void retPma(Object pma) throws SQLException {
		pmaVO = (PmaVO) pma;
		pmaVO.setListRpm(new RpmDAO().getRegByProcesso(pmaVO.getIddpma()));
		atualizaTela();
	}
	
	public void buscarProtJucems() {
		new WinUtils().abrirLis("/forms/epdlis.zul", null, this, "retEpd");
	}
	
	public void retEpd(Object epd) throws SQLException, NumberFormatException, InterruptedException {
		HashMap<String, Object> e = (HashMap<String, Object>) epd;
		pmaVO.setPrjpma(e.get("nprepd").toString());
		pmaVO.setEpdpma(Long.parseLong(e.get("iddepd").toString()));
		if (Messagebox.show("Deseja Recuperar as informa��es de Requerente, Atividade e Endere�o do Processo JUCEMS?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			HashMap<String, Object> matriz = new MatDAO().getMatrizByProcesso(Long.parseLong(e.get("iddpro").toString())); //ASSUMINDO QUE SEMPRE SER� 1 MATRIZ PARA CADA PROCESSO
			pmaVO.setReqpma(matriz.get("nommat").toString());
			pmaVO.setAtvpma(matriz.get("desmat").toString());
			pmaVO.setEdrpma(matriz.get("endmat").toString());
		}
		atualizaTela();
	}
	
	public void cadastrarLicenca() {
		HashMap<String, String> infos = new HashMap<String, String>();
		infos.put("iddpma", pmaVO.getIddpma().toString());
		infos.put("prolma", pmaVO.getPrapma());
		infos.put("reqlma", pmaVO.getReqpma());
		infos.put("atvlma", pmaVO.getAtvpma());
		infos.put("edrlma", pmaVO.getEdrpma());
		infos.put("esprpm", rpmVO!=null&&rpmVO.getEsprpm()!=null?rpmVO.getEsprpm():null);
		infos.put("reglma", pmaVO!=null&&pmaVO.getRegpma()!=null?pmaVO.getRegpma():null);
		new WinUtils().abrirLis("/forms/lmacad.zul", infos, this, "retLma");
	}
	
	public void buscarLicenca() {
		new WinUtils().abrirLis("/forms/lmalis.zul", null, this, "retLma");
	}
	
	public void retLma(Object lma) throws SQLException {
		lmaVO = (LmaVO) lma;
		atualizaTela();
	}
	
	public void apagarRpm(Listitem item) throws InterruptedException {
		if (Messagebox.show("Tem certeza que deseja Excluir o Requerimento?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			RpmVO rpm = (RpmVO) item.getValue();
			try {
				Integer cod = new RpmDAO().delReg(rpm.getIddrpm());
				if(cod != null && cod > 0){
					pmaVO.setListRpm(new RpmDAO().getRegByProcesso(pmaVO.getIddpma()));
					rpmVO = new RpmVO();
					Messagebox.show("Requerimento exclu�do com sucesso!");
					atualizaTela();
				} else {
					Messagebox.show("N�o foi poss�vel excluir o Requerimento!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void incluir() throws InterruptedException {
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Cadastrar o Processo?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				PmaVO pma = new PmaDAO().getRegByPrapma(pmaVO.getPrapma());
				if(pma != null && pma.getIddpma() != null){
					Messagebox.show("N�o foi poss�vel cadastrar! N�mero de Processo j� cadastrado!");
				} else {
					Long idd = (Long) new PmaDAO().insReg(pmaVO);
					if(idd != null && idd > 0){
						pmaVO = new PmaDAO().getRegByCod(idd);
						Messagebox.show("Processo cadastrado com sucesso!");
						atualizaTela();
					} else {
						Messagebox.show("N�o foi poss�vel cadastrar o Processo!");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void salvarRpm() throws InterruptedException {
		trataRpmVO();
		if(rpmVO.getIddrpm() != null){
			//SALVA
			if (Messagebox.show("Tem certeza que deseja salvar o registro?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
				try {
					Integer cod = new RpmDAO().updRegByCod(rpmVO);
					if(cod != null && cod > 0){
						pmaVO.setListRpm(new RpmDAO().getRegByProcesso(pmaVO.getIddpma()));
						rpmVO = null;
						lmaVO = new LmaVO();
						Messagebox.show("Requerimento salvo com sucesso!");
						atualizaTela();
					} else {
						Messagebox.show("N�o foi poss�vel salvar o Requerimento!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			//INCLUI
			if (Messagebox.show("Tem certeza que deseja incluir o registro?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
				try {
					Long idd = (Long) new RpmDAO().insReg(rpmVO);
					if(idd != null && idd > 0){
						pmaVO.setListRpm(new RpmDAO().getRegByProcesso(pmaVO.getIddpma()));
						rpmVO = null;
						lmaVO = new LmaVO();
						Messagebox.show("Requerimento inclu�do com sucesso!");
						atualizaTela();
					} else {
						Messagebox.show("N�o foi poss�vel incluir o Requerimento!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void trataRpmVO(){
		if(rpmVO.getDatrpm() == null){
			throw new WrongValueException(getComponente("datrpm"),"Informe a Data do Requerimento!");
		}
		if(rpmVO.getEsprpm() == null){
			throw new WrongValueException(getComponente("esprpm"),"Informe a Esp�cie!");
		}
		if(rpmVO.getTesrpm() == null){
			throw new WrongValueException(getComponente("tesrpm"),"Informe o Tipo da Esp�cie!");
		}
		if(rpmVO.getArerpmStr() != null && (!rpmVO.getArerpmStr().isEmpty())){
			String area = rpmVO.getArerpmStr().replaceAll("[.]", "").replaceAll("[,]", ".");
			rpmVO.setArerpm(Double.parseDouble(area));
		} else {
			rpmVO.setArerpm(null);
		}
		rpmVO.setPmarpm(pmaVO.getIddpma());
		rpmVO.setUsualt(getLogin());
		if(lmaVO!=null && lmaVO.getIddlma() != null){
			rpmVO.setLmaVO(lmaVO);
			rpmVO.setLmarpm(lmaVO.getIddlma());
		}
	}

	@Override
	public void apagar() throws InterruptedException {
		if(pmaVO.getListRpm() != null && pmaVO.getListRpm().size() > 0){
			Messagebox.show("N�o foi poss�vel excluir o processo pois existem requerimentos cadastrados!","Aviso!!!", Messagebox.OK, Messagebox.ERROR);
		} else {
			if (Messagebox.show("Tem certeza que deseja excluir o processo?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
				try {
					Integer cod = new PmaDAO().delReg(pmaVO.getIddpma());
					if(cod != null && cod > 0){
						Messagebox.show("Processo exclu�do com sucesso!");
						limpar();
					} else {
						Messagebox.show("N�o foi poss�vel excluir o Processo!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void limpar() throws InterruptedException {
		pmaVO = new PmaVO();
		rpmVO = new RpmVO();
		atualizaTela();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}
	
	public String getLblBtnRpm(){
		if(rpmVO != null && rpmVO.getIddrpm() != null){
			return "Salvar";
		} else {
			return "Incluir";
		}
	}
	
	public Boolean isVisibleRequerimentos(){
		if(pmaVO != null && pmaVO.getIddpma() != null){
			return true;
		} else {
			return false;
		}
	}
	
	public void validaPerfil676(){
		Map mapa = (Map) this.getSession().getAttribute("usumnu");
		boolean perfil676 = false;
		Integer[] perfis = (Integer[]) mapa.get("perfis");
			for(int i = 0; i < perfis.length; i++){
				if(perfis[i] == 676)
					perfil676 = true;
			}
			if(perfil676){
			getCrdBar().getBotao(0).setVisible(false);
			getCrdBar().getBotao(1).setVisible(false);
			getCrdBar().getBotao(2).setVisible(false);
			((Button)this.getComponente("btnRpm")).setVisible(false);
			btnLicensa = false;
		}
			this.vincular();
	}
}
