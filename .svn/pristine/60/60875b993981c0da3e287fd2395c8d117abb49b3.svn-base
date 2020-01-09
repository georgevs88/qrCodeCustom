package pmcg.imti.view.ext;

import org.zkoss.zk.ui.WrongValueException;

import pmcg.fcn.dao.ibatis.CadDAO;
import pmcg.fcn.domain.CadVO;

public class Acesso extends Index{
private static final long serialVersionUID = 1L;

	public void autenticar() {
		this.trataVO();
		String cpfcnpj = login.replaceAll("[/._-]", "");
		if(login == null || (cpfcnpj.length() != 11 && cpfcnpj.length() != 14))
			throw new WrongValueException(this.getComponente("login"),"CPF/CNPJ incompleto!");
		if(senha == null || senha.isEmpty())
			throw new WrongValueException(this.getComponente("senha"),"Informe a Senha!");
		CadVO cad = new CadVO();
		cad.setCpfcad(login.replaceAll("[/._-]", ""));
		cad.setSencad(senha);
		cad = new CadDAO().getCadByLoginSenha(cad);
		if (cad != null && cad.getIddcad() != null && cad.getIddcad() > 0) {
			session.setAttribute("usuarioExtCim", cad);
			if(cad.getAdmcad() != null && cad.getAdmcad()){
				session.setAttribute("admin", true);
			}
			redirecionarUsuario();
		} else {
			throw new WrongValueException(this.getComponente("login"),"Login/Senha incorreto!");
		}
		
	}
}
