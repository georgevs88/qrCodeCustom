package pmcg.imti.view.ext;

import java.sql.SQLException;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CadDAO;
import pmcg.fcn.domain.CadVO;

public class Altsenha extends Index{
private static final long serialVersionUID = 1L;

	public String login;
	public String atual;
	public String nova;
	public String conf;
	
	public void initAlt() throws SQLException{
		if(isNaoAutenticado()){
			desconectarUsuario();
		} else {
			login = getUsuarioLogin();
			vincular();
		}
	}

	public void alterar() throws InterruptedException {
		if(atual == null || atual.isEmpty())
			throw new WrongValueException(this.getComponente("atual"),"Informe a Senha Atual!");
		if(nova == null || nova.isEmpty())
			throw new WrongValueException(this.getComponente("nova"),"Informe a Nova Senha!");
		if(conf == null || conf.isEmpty())
			throw new WrongValueException(this.getComponente("conf"),"Informe a Confirmação de Senha!");
		if(!nova.equals(conf)){
			throw new WrongValueException(this.getComponente("conf"),"Confirmação de Senha não confere!");
		}
		CadVO cad = new CadVO();
		cad.setCpfcad(login);
		cad.setSencad(atual);
		cad = new CadDAO().getCadByLoginSenha(cad);
		if (cad != null && cad.getIddcad() != null && cad.getIddcad() > 0) {
			//Senha atual correta
			try {
				cad.setSencad(nova);
				Integer codupd = new CadDAO().updSenha(cad);
				if(codupd != null && codupd > 0){
					Messagebox.show("Senha Alterada com Sucesso!", "Alterar Senha", Messagebox.OK, Messagebox.EXCLAMATION);
				} else {
					Messagebox.show("Não foi possível atualizar a senha!", "Alterar Senha", Messagebox.OK, Messagebox.ERROR);
				}
			} catch (SQLException e) {
				Messagebox.show("Não foi possível atualizar a senha!", "Alterar Senha", Messagebox.OK, Messagebox.ERROR);
				e.printStackTrace();
			} catch (InterruptedException e) {
				Messagebox.show("Não foi possível atualizar a senha!", "Alterar Senha", Messagebox.OK, Messagebox.ERROR);
				e.printStackTrace();
			}
			redirecionarUsuario();
		} else {
			throw new WrongValueException(this.getComponente("login"),"Login/Senha incorreto!");
		}
		
	}
}
