package pmcg.imti.view.ext;

import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;

import pmcg.fcn.dao.ibatis.CadDAO;
import pmcg.fcn.domain.CadVO;
import pmcg.framework.ui.WindowList;

public class EntCom extends WindowList<CadVO>{

	private static final long serialVersionUID = 1L;
	public String cpfcnpjEntrar = "";
	public String cpfcnpjLogado = ((CadVO) getSession().getAttribute("usuarioExtCim")).getCpfcad();
	
	public void initComponentes() {
		item = new CadVO();
		this.getCrdBar().setVisible(false);
		this.vincular();
	}
	
	public void verificaUsuario() {
		if(cpfcnpjEntrar != null && (!cpfcnpjEntrar.isEmpty())){
			String cpfcnpj = cpfcnpjEntrar.replaceAll("[/._-]", "");
			if(cpfcnpj.length() != 11){
				throw new WrongValueException(this.getComponente("cpfcnpj"),"CPF/CNPJ incompleto!");
			} 
		}
	}
	
	public void entrar(){
		if(cpfcnpjEntrar==null || cpfcnpjEntrar.isEmpty()){
			throw new WrongValueException(this.getComponente("cpfcnpj"),"Informe o CPF/CNPJ do usu�rio que deseja entrar!");
		}
		if(cpfcnpjEntrar.replaceAll("[/._-]", "").equals(cpfcnpjLogado)){
			throw new WrongValueException(this.getComponente("cpfcnpj"),"Mesmo usu�rio logado!");
		}
		String cpfcnpj = cpfcnpjEntrar.replaceAll("[/._-]", "");
		CadVO cadEntrar = new CadDAO().getCadByCPF(cpfcnpj);
		if(cadEntrar != null && cadEntrar.getIddcad() != null) {
			session.setAttribute("usuarioExtVer", cadEntrar);
			item = cadEntrar;
		} else {
			throw new WrongValueException(this.getComponente("cpfcnpj"),"Usu�rio n�o cadastrado!");
		}
		this.atualizaListagem();
		this.detach();
	}

	@Override
	public void pesquisar() {
	}
	
	@SuppressWarnings("rawtypes")
	private void atualizaListagem() {
		Collection c = getDesktop().getComponents();
		Object[] co = c.toArray();
		for (Object o : co) {
			if (((Component) o).getId().equalsIgnoreCase("mainPage")) {
				((Index) o).retEntrar();
				break;
			}
		}
	}
	
	public void sair(){
		this.detach();
	}

}
