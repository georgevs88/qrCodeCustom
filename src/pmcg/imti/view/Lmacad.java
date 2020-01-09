package pmcg.imti.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.dao.ibatis.LmaDAO;
import pmcg.fcn.domain.LmaVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.UsuDAO;
import pmcg.imti.domain.UsuVO;

public class Lmacad extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public LmaVO lmaVO = new LmaVO();
	public List<UsuVO> listAnalista;
	public UsuVO anaSel;
	public List<UsuVO> listAnalistaC;
	public UsuVO ancSel;
	public List<UsuVO> listElaborado;
	public UsuVO elaSel;
	public Boolean veioDaPmacad = false;
	public UsuVO gestor = new UsuDAO().getRegByCod(Long.parseLong(new CfgDAO().getValorByParam("CODUSU_RESP_LIC_MA")));
	
	public Lmacad() throws NumberFormatException, SQLException {
//		super("lmacad.zul");
		Map map = Executions.getCurrent().getArg();
		if(map != null && map.get("iddpma") != null){
			veioDaPmacad = true;
			lmaVO.setProlma(map.get("prolma").toString());
			lmaVO.setReqlma(map.get("reqlma").toString());
			lmaVO.setEdrlma(map.get("edrlma").toString());
			lmaVO.setAtvlma(map.get("atvlma").toString());
			lmaVO.setEsplma(map.get("esprpm")!=null?map.get("esprpm").toString():null);
			lmaVO.setReglma(map.get("reglma")!=null?map.get("reglma").toString():null);
			lmaVO.setAnolma(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())));
			lmaVO.setEmilma(new Date());
			lmaVO.setSitlma("A");
			lmaVO.setAsslma(gestor.getNomusu());
		}
	}
	
	public void initComponentes() throws InterruptedException, SQLException{
		listAnalista = new UsuDAO().getTodos(null);
		listAnalistaC = new UsuDAO().getTodos(null);
		listElaborado = new UsuDAO().getTodos(null);
		atualizaTela();
		
		//retLma(new LmaDAO().getRegByCod(659L));
	}
	
	public void atualizaTela(){
		if(lmaVO != null && lmaVO.getIddlma() != null){
			getCrdBar().getBotao(0).setVisible(false);
			getCrdBar().getBotao(1).setVisible(true);
			getCrdBar().getBotao(2).setVisible(false);
			getCrdBar().getBotao(3).setVisible(true);
			getCrdBar().getBotao(4).setVisible(true);
			getCrdBar().getBotao(5).setVisible(true);
			((Combobox) getComponente("esplma")).setDisabled(true);
		} else {
			if(veioDaPmacad){
				getCrdBar().getBotao(0).setVisible(true);
			} else {
				getCrdBar().getBotao(0).setVisible(false);
			}
			getCrdBar().getBotao(1).setVisible(false);
			getCrdBar().getBotao(2).setVisible(false);
			getCrdBar().getBotao(3).setVisible(true);
			getCrdBar().getBotao(4).setVisible(true);
			getCrdBar().getBotao(5).setVisible(false);
			((Combobox) getComponente("esplma")).setDisabled(false);
		}
		vincular();
	}
	
	@Override
	public void salvar() throws InterruptedException {
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Salvar a Licença/Dispensa?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				Integer codupd = new LmaDAO().updRegByCod(lmaVO);
				if(codupd != null && codupd > 0){
					Messagebox.show(lmaVO.getEsplma() + " nº " + lmaVO.getNumlma() + " salva com sucesso!");
					atualizaTela();
				} else {
					Messagebox.show("Não foi possível salvar a Licença/Dispensa!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void pesquisar() {
		new WinUtils().abrirLis("/forms/lmalis.zul", null, this, "retLma");
	}
	
	public void retLma(Object lma) throws SQLException {
		lmaVO = (LmaVO) lma;
		anaSel = lmaVO.getAnalma()!=null?new UsuDAO().getUsuByLog(lmaVO.getAnalma()):null;
		ancSel = lmaVO.getAnclma()!=null?new UsuDAO().getUsuByLog(lmaVO.getAnclma()):null;
		elaSel = lmaVO.getElalma()!=null?new UsuDAO().getUsuByLog(lmaVO.getElalma()):null;
		atualizaTela();
	}
	
	public void trataVO(){
//		if(lmaVO.getAnolma() == null){
//			throw new WrongValueException(getComponente("anolma"),"Informe o Ano!");
//		}
		if(lmaVO.getSitlma() == null){
			throw new WrongValueException(getComponente("sitlma"),"Informe a Situação!");
		}
		if(lmaVO.getEsplma() == null){
			throw new WrongValueException(getComponente("esplma"),"Informe a Espécie!");
		}
		if(lmaVO.getProlma() == null){
			throw new WrongValueException(getComponente("prolma"),"Informe o Processo!");
		}
		if(lmaVO.getEmilma() == null){
			throw new WrongValueException(getComponente("emilma"),"Informe a Data de Emissão!");
		}
		if((!lmaVO.getEsplma().equalsIgnoreCase("DISPENSA")) && lmaVO.getVallma() == null){
			throw new WrongValueException(getComponente("vallma"),"Informe a Data de Validade!");
		}
		if(lmaVO.getReqlma() == null){
			throw new WrongValueException(getComponente("reqlma"),"Informe o Requerente!");
		}
		if(lmaVO.getAtvlma() == null){
			throw new WrongValueException(getComponente("atvlma"),"Informe a Atividade!");
		}
		if(lmaVO.getEdrlma() == null){
			throw new WrongValueException(getComponente("edrlma"),"Informe o Endereço!");
		}
		if(lmaVO.getReglma() == null){
			throw new WrongValueException(getComponente("reglma"),"Informe a Região Urbana!");
		}
		if(anaSel == null){
			throw new WrongValueException(getComponente("analma"),"Informe o Analista!");
		}
		if(elaSel == null){
			throw new WrongValueException(getComponente("elalma"),"Informe o campo 'Elaborado por'!");
		}
		if(lmaVO.getAsslma() == null){
			throw new WrongValueException(getComponente("asslma"),"Informe o campo 'Assinatura'!");
		}
		lmaVO.setAnalma(anaSel.getLogusu());
		lmaVO.setElalma(elaSel.getLogusu());
		lmaVO.setUsualt(getLogin());
	}

	@Override
	public void incluir() throws InterruptedException {
		trataVO();
		if (Messagebox.show("Tem certeza que deseja Cadastrar a Licença/Dispensa?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				Long idd = (Long) new LmaDAO().insReg(lmaVO);
				if(idd != null && idd > 0){
					lmaVO = new LmaDAO().getRegByCod(idd);
					Messagebox.show(lmaVO.getEsplma() + " nº " + lmaVO.getNumlma() + " cadastrada com sucesso!");
					atualizaTela();
				} else {
					Messagebox.show("Não foi possível cadastrar a Licença/Dispensa!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
		lmaVO = new LmaVO();
		lmaVO.setAnolma(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())));
		lmaVO.setEmilma(new Date());
		anaSel = null;
		elaSel = null;
		lmaVO.setEmilma(new Date());
		lmaVO.setAsslma(gestor.getNomusu());
		lmaVO.setEsplma("DISPENSA");
		atualizaTela();
	}

	@Override
	public void imprimir() throws InterruptedException {
		if(lmaVO.getEsplma().equals("DISPENSA")){
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("iddlma", lmaVO.getIddlma().toString());
			new WinUtils().abrirBirt("dispensa_amb.rptdesign", param);
		} else {
			Messagebox.show("Impressão disponível apenas para processos de DISPENSA!");
		}
	}

	@Override
	public void sair() throws InterruptedException {
		Events.postEvent("onClose", this, lmaVO);
		detach();
	}
	
}
