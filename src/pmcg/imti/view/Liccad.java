package pmcg.imti.view;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.ViaVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.util.FormatUtils;

public class Liccad extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public HashMap<String, Object> dadosEco;
	public List<HashMap<String, Object>> listEcolic;
	public List<HashMap<String, Object>> listEcolichis;
	public String insmun;
	public String risco, status;
	public Date datval;
	
	public void initComponentes() throws SQLException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(true);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
//		insmun = "21480600-2";
//		pesquisar();
		vincular();
	}
	
	
	@Override
	public void salvar() throws InterruptedException {
		
	}
	
	public void pesquisar() {
		if(insmun == null || insmun.trim().isEmpty()){
			throw new WrongValueException(getComponente("insmun"),"Informe a Inscri��o Municipal!");
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("insmun", insmun);
		dadosEco = new EcoDAO().getDadosEco(param);
		if(dadosEco != null){
			HashMap<String, Object> res = new EcoDAO().getStatusImpressaoAlvara(Integer.parseInt(dadosEco.get("CODECO").toString()));
			if(res == null){
				dadosEco.put("RISCO", "-");
				dadosEco.put("STYLE_RISCO", "text-align:center;");
				dadosEco.put("STATUS", "-");
				dadosEco.put("STYLE_STATUS", "text-align:center;");
				dadosEco.put("DATVAL", null);
			} else {
				dadosEco.put("RISCO", res.get("RISCO"));
				if(dadosEco.get("RISCO").toString().startsWith("A")){
					dadosEco.put("STYLE_RISCO", "text-align:center;font-weight:bold;color:red;");
				} else if(dadosEco.get("RISCO").toString().startsWith("M")){
					dadosEco.put("STYLE_RISCO", "text-align:center;font-weight:bold;color:yelow;");
				} else {
					dadosEco.put("STYLE_RISCO", "text-align:center;font-weight:bold;color:green;");
				}
				dadosEco.put("STATUS", res.get("STATUS"));
				if(dadosEco.get("STATUS").toString().startsWith("L")){
					dadosEco.put("DESC_STATUS", "Indica que o Alvar� est� liberado para impress�o.");
					dadosEco.put("STYLE_STATUS", "text-align:center;font-weight:bold;color:green;");
				} else if(dadosEco.get("STATUS").toString().startsWith("B")){
					dadosEco.put("DESC_STATUS", "Indica que o Alvar� est� bloqueado para impress�o, ou seja, depende do deferimento das licen�as.");
					dadosEco.put("STYLE_STATUS", "text-align:center;font-weight:bold;color:red;");
				} else {
					dadosEco.put("DESC_STATUS", "Indica que o Alvar� est� condicionado para impress�o, ou seja, depende do deferimento das licen�as. Pode ser impresso o Alvar� Provis�rio.");
					dadosEco.put("STYLE_STATUS", "text-align:center;font-weight:bold;color:yellow;");
				}
				dadosEco.put("DATVAL", res.get("DATVAL"));
				
				if(dadosEco.get("PROTOCPE") != null){
					ViaVO via = new ViaDAO().getRegByProvia(dadosEco.get("PROTOCPE").toString());
					if(via != null && via.getIddvia() != null){
						dadosEco.put("VISIBLE_VIAB", true);
					} else {
						dadosEco.put("VISIBLE_VIAB", false);
					}
				} else {
					dadosEco.put("VISIBLE_VIAB", false);
				}
			}
		}
		listEcolic = new EcoDAO().getEcolic(FormatUtils.onlyNumbers(insmun));
		listEcolichis = new EcoDAO().getEcolichis(FormatUtils.onlyNumbers(insmun));
		vincular();
	}
	
	public void consultaViabilidade(){
		if(dadosEco != null && dadosEco.get("PROTOCPE") != null){
			Map<String, String> param = new HashMap<String, String>();
			param.put("provia", dadosEco.get("PROTOCPE").toString());
			new WinUtils().abrirLis("/forms/acopro.zul", param, this, null);
		}
	}
	
	public void atualizaStatus() throws InterruptedException{
		if(dadosEco != null){
			if(risco == null || risco.trim().isEmpty()){
				throw new WrongValueException(getComponente("risco"),"Informe o Risco!");
			}
			if(status == null || status.trim().isEmpty()){
				throw new WrongValueException(getComponente("status"),"Informe o Status!");
			}
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("risco", risco);
			param.put("status", status);
			param.put("datval", datval);
			param.put("usualt", getLogin());
			param.put("codeco", dadosEco.get("CODECO"));
			try {
				new EcoDAO().insStatusImpressaoAlvara(param);
				Messagebox.show("Status salvo com sucesso!","Atualizar Status Impress�o Alvar�",Messagebox.OK, Messagebox.INFORMATION);
				status = "";
				risco = "";
				datval = null;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new WrongValueException(getComponente("risco"),"Erro ao atualizar o Risco!");
			}
			pesquisar();
		} else {
			if(risco == null || risco.trim().isEmpty()){
				throw new WrongValueException(getComponente("insmun"),"Selecione uma inscri��o!");
			}
		}
	}
		
	@Override
	public void incluir() throws InterruptedException {
	
	}
	
	@Override
	public void apagar() throws InterruptedException {
	
	}

	@Override
	public void limpar() throws InterruptedException {
		insmun = "";
		dadosEco = null;
		listEcolic = null;
		listEcolichis = null;
		status = "";
		risco = "";
		datval = null;
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}
	
}
