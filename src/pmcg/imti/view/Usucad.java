package pmcg.imti.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CadDAO;
import pmcg.fcn.dao.ibatis.EdrDAO;
import pmcg.fcn.domain.CadVO;
import pmcg.fcn.domain.EdrVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.StringUtils;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.CidDAO;
import pmcg.imti.dao.ibatis.EstDAO;
import pmcg.imti.dao.ibatis.TipDAO;
import pmcg.imti.domain.CidVO;
import pmcg.imti.domain.EstVO;
import pmcg.imti.domain.TipVO;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class Usucad extends WindowCrud{

	private static final long serialVersionUID = 1L;
	public CadVO cadVO = new CadVO();
	public List<TipVO> listTipLog = new ArrayList<TipVO>(); //Lista de tipos de logradouro
	public List<TipVO> listTipBai = new ArrayList<TipVO>(); //Lista de tipos de bairro
	public List<EstVO> listUf;
	public List<CidVO> listCid;
	public CidVO cidSel;
	public EdrVO endereco = new EdrVO();
	public Boolean respCont = false;
	
	public void initComponentes() throws SQLException {
		listTipLog = new TipDAO().getRegByTipo("TLOG");
		listTipBai = new TipDAO().getRegByTipo("TBAIR");
		listUf = new EstDAO().getTodos(null);
		this.getCrdBar().getBotao(0).setVisible(false);
		this.getCrdBar().getBotao(1).setVisible(true);
		this.getCrdBar().getBotao(2).setVisible(false);
		this.getCrdBar().getBotao(3).setVisible(false);
		this.getCrdBar().getBotao(4).setVisible(true);
		this.getCrdBar().getBotao(5).setVisible(false);
		this.getCrdBar().getBotao(6).setVisible(true);
		this.vincular();
	}
	
	@Override
	public void salvar() throws InterruptedException {
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Salvar as alterações?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				new CadDAO().getSqlMap().startTransaction();
				Integer updcad, updedr = null;
				//INSERIR ENDEREÇO
				updedr = new EdrDAO().updRegByCod(endereco);
				updcad = new CadDAO().updRegByCod(cadVO);
				
				if (updcad != null && updcad > 0 && updedr != null && updedr > 0) {
					new CadDAO().getSqlMap().commitTransaction();
					Messagebox.show("Registro Salvo com Sucesso!", "Cadastro de Usuário", Messagebox.OK, Messagebox.EXCLAMATION);
				} else {
					try {
						Messagebox.show("Não foi possível salvar o registro!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				try {
					Messagebox.show("Não foi possível inserir o registro!");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					new CadDAO().getSqlMap().endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void trataVO() throws InterruptedException {
		if(cadVO == null || cadVO.getIddcad() == null){
			throw new WrongValueException(getComponente("cpfcad"),"Selecione um usuário!");
		}
		if(cadVO.getCpfcad() == null || FormatUtils.onlyNumbers(cadVO.getCpfcad()).isEmpty()){
			throw new WrongValueException(getComponente("cpfcad"),"Informe o CPF!");
		}
		String cpfcnpj = FormatUtils.onlyNumbers(cadVO.getCpfcad());
		if(cpfcnpj.length() != 11 || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
			throw new WrongValueException(getComponente("cpfcad"),"CPF inválido!");
		}
		if(cadVO.getDnacad() == null){
			throw new WrongValueException(getComponente("dnacad"),"Informe a Data de Nascimento!");
		}
		if(cadVO.getSexcad() == null){
			throw new WrongValueException(getComponente("sexcad"),"Informe o Sexo!");
		}
		if(cadVO.getNomcad() == null || cadVO.getNomcad().equals("")) {
			throw new WrongValueException(getComponente("nome"), "Informe o Nome!");
		}
		cadVO.setNomcad(cadVO.getNomcad().toUpperCase());
		if(cadVO.getDtpcad() == null){
			throw new WrongValueException(getComponente("dtpcad"),"Informe o Tipo de Documento de Identificação!");
		}
		if(cadVO.getDnrcad() == null){
			throw new WrongValueException(getComponente("dnrcad"),"Informe o Número do Documento de Identificação!");
		}
		if(cadVO.getDoecad() == null){
			throw new WrongValueException(getComponente("doecad"),"Informe o Órgão Expedidor do Documento de Identificação!");
		}
		if(((Combobox) getComponente("duocad")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("duocad"),"Informe a UF do Órgão Expedidor!");
		}
		cadVO.setDuocad(((EstVO) ((Comboitem)((Combobox) getComponente("duocad")).getSelectedItem()).getValue()).getUnifed());
		if(cadVO.getDexcad()== null){
			throw new WrongValueException(getComponente("dexcad"),"Informe a Data de Expedição!");
		}
		if(endereco == null || (!Formatacao.isCEPValido(endereco.getCepedr()))){
			throw new WrongValueException(getComponente("cepcor"),"Informe o CEP!");
		}
		if(((Combobox) getComponente("uffedr")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("uffedr"),"Informe a UF!");
		}
		endereco.setUffedr(((EstVO) ((Comboitem)((Combobox) getComponente("uffedr")).getSelectedItem()).getValue()).getUnifed());
		if(cidSel == null || cidSel.getCodsiafi() == null){
			throw new WrongValueException(getComponente("munedr"),"Informe o Município!");
		}
		endereco.setMunedr(cidSel.getCodsiafi().toString());
		if(((Combobox) getComponente("tloedr")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("tloedr"),"Informe Tipo de Logradouro!");
		}
		endereco.setTloedr(((TipVO) ((Comboitem)((Combobox) getComponente("tloedr")).getSelectedItem()).getValue()).getDescom());
		if(endereco.getNloedr() == null || endereco.getNloedr().isEmpty()){
			throw new WrongValueException(getComponente("nloedr"),"Informe o Logradouro!");
		}
		if(Formatacao.isNullOrEmpty(endereco.getNumedr())){
			throw new WrongValueException(getComponente("numedr"),"Informe o Número!");
		}
		if(((Combobox) getComponente("tbaedr")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("tbaedr"),"Informe Tipo de Bairro!");
		}
		endereco.setTbaedr(((TipVO) ((Comboitem)((Combobox) getComponente("tbaedr")).getSelectedItem()).getValue()).getDescom());
		if(Formatacao.isNullOrEmpty(endereco.getBaiedr())){
			throw new WrongValueException(getComponente("baiedr"),"Informe o Bairro!");
		}
		cadVO.setDdtcad(FormatUtils.onlyNumbers(cadVO.getDdtcad()));
		if(cadVO.getDdtcad() == null || cadVO.getDdtcad().equals("0") || cadVO.getDdtcad().equals("00") || cadVO.getDdtcad().length() < 2) {
			throw new WrongValueException(getComponente("dddtel"), "Informe um DDD válido de dois dígitos!");
		}
		cadVO.setTelcad(FormatUtils.onlyNumbers(cadVO.getTelcad()));
		if(cadVO.getTelcad() == null || cadVO.getTelcad().equals("") || cadVO.getTelcad().replaceAll("[-_(). ]","").length() < 8 ) {
			throw new WrongValueException(getComponente("telcad"), "Informe o Telefone!");
		}
		cadVO.setDdfcad(FormatUtils.onlyNumbers(cadVO.getDdfcad()));
		cadVO.setFaxcad(FormatUtils.onlyNumbers(cadVO.getFaxcad()));
		cadVO.setDdccad(FormatUtils.onlyNumbers(cadVO.getDdccad()));
		cadVO.setCelcad(FormatUtils.onlyNumbers(cadVO.getCelcad()));
		if(cadVO.getEmacad() == null || cadVO.getEmacad().isEmpty()) {
			throw new WrongValueException(getComponente("email"), "Informe o E-mail!");
		}
		if(respCont){
			if(cadVO.getCpccad() == null || cadVO.getCpccad().isEmpty() || FormatUtils.onlyNumbers(cadVO.getCpccad()).isEmpty()){
				throw new WrongValueException(getComponente("cpccad"),"Informe o CPF/CNPJ!");
			}
			cpfcnpj = FormatUtils.onlyNumbers(cadVO.getCpccad());
			if((cpfcnpj.length() != 11 && cpfcnpj.length() != 14) || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
				throw new WrongValueException(getComponente("cpccad"),"CPF/CNPJ inválido!");
			}
			if(cadVO.getNrscad() == null || cadVO.getNrscad().equals("")) {
				throw new WrongValueException(getComponente("nrscad"), "Informe o Nome/Razão Social!");
			}
			cadVO.setNrscad(cadVO.getNrscad().toUpperCase());
			if(cadVO.getTpccad() == null || cadVO.getTpccad().isEmpty()) {
				throw new WrongValueException(getComponente("tpccad"), "Informe o Tipo CRC!");
			}
			if(cadVO.getCrccad() == null || cadVO.getCrccad().isEmpty()) {
				throw new WrongValueException(getComponente("crccad"), "Informe o Número CRC!");
			}
			if(cadVO.getScrcad() == null || cadVO.getScrcad().isEmpty()) {
				throw new WrongValueException(getComponente("scrcad"), "Informe a Sigla do CRC!");
			}
			if(cadVO.getDtrcad() == null) {
				throw new WrongValueException(getComponente("dtrcad"), "Informe a Data de Registro do CRC!");
			}
			if(cadVO.getUfccad() == null || cadVO.getUfccad().isEmpty()) {
				throw new WrongValueException(getComponente("ufccad"), "Informe a UF de Registro do CRC!");
			}
		} 		
		cadVO.setCpfcad(FormatUtils.onlyNumbers(cadVO.getCpfcad()));
		cadVO.setCpccad(FormatUtils.onlyNumbers(cadVO.getCpccad()));
		cadVO.setDatalt(new Date());
		cadVO.setUsualt(getLogin());
	}
	
	@SuppressWarnings("unchecked")
	public void retCad(Object cad) throws SQLException {
		cadVO = (CadVO) cad;
		if(cadVO.getCpccad() != null && !cadVO.getCpccad().isEmpty()){
			respCont = true;
		}
		endereco = new EdrDAO().getRegByCod(cadVO.getEdrcad());
		//setando uf documento
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("duocad")).getItems())){
			EstVO est = (EstVO) item.getValue();
			if(est.getUnifed().equals(cadVO.getDuocad())){
				((Combobox) getComponente("duocad")).setSelectedItem(item);
				break;
			}
		}
		//setando uf endereco
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("uffedr")).getItems())){
			EstVO est = (EstVO) item.getValue();
			if(est.getUnifed().equals(endereco.getUffedr())){
				((Combobox) getComponente("uffedr")).setSelectedItem(item);
				listCid = new CidDAO().getCidByEstado(est.getUnifed());
				cidSel = new CidDAO().getRegByCodSiafi(Integer.parseInt(endereco.getMunedr()));
				break;
			}
		}
		//setando o tipo lograndouro
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("tloedr")).getItems())){
			TipVO tip = (TipVO) item.getValue();
			if(tip.getDescom().equals(endereco.getTloedr())){
				((Combobox) getComponente("tloedr")).setSelectedItem(item);
				break;
			}
		}
		//setando o tipo lograndouro
		for (Comboitem item : ((List<Comboitem>) ((Combobox) getComponente("tbaedr")).getItems())){
			TipVO tip = (TipVO) item.getValue();
			if(tip.getDescom().equals(endereco.getTbaedr())){
				((Combobox) getComponente("tbaedr")).setSelectedItem(item);
				break;
			}
		}
		vincular();
	}
	
	public void listarCidades() {
		listCid.clear();
		listCid.addAll(new CidDAO().getCidByEstado(((EstVO) ((Combobox) getComponente("uffedr")).getSelectedItem().getValue()).getUnifed()));
		this.vincular();
	}

	@Override
	public void incluir() throws InterruptedException {
		
	}

	@Override
	public void apagar() throws InterruptedException {
		
	}

	@Override
	public void pesquisar() throws InterruptedException {
		new WinUtils().abrirLis("/forms/cadlis.zul", null, this, "retCad");
	}

	@Override
	public void limpar() throws InterruptedException {
		
	}

	@Override
	public void imprimir() throws InterruptedException {
		
	}

	@Override
	public void sair() throws InterruptedException {
		this.detach();
	}

}
