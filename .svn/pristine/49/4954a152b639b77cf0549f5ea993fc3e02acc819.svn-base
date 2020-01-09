package pmcg.imti.view;

import java.text.ParseException;
import java.util.HashMap;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.framework.ui.WindowCrud;
import pmcg.imti.dao.ibatis.ViaDAO;
import pmcg.imti.util.FormatUtils;

public class Cefcon extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public String cnpj = "";
	public HashMap<String,Object> dados;
	
	public void initComponentes() throws ParseException{
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(false);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		cnpj = "";
		vincular();
	}
	
	public void consultar(){
		String param = FormatUtils.onlyNumbers(cnpj);
		if(param == null || param.isEmpty()){
			throw new WrongValueException(this.getComponente("cnpj"), "Informe o CNPJ!");
		} else {
			if(param.length() != 14){
				throw new WrongValueException(this.getComponente("cnpj"), "CNPJ inválido!");
			} else {
				dados = new ViaDAO().getProtocoloByCnpj(param);
				vincular();
			}
		}
	}
	
	public Boolean isVisibleDados(){
		if(dados!= null && dados.size() > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void imprimir() throws InterruptedException {
	}
	
	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void incluir() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
	}

	@Override
	public void pesquisar() throws InterruptedException {
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}

	@Override
	public void salvar() throws InterruptedException {
	}
}
