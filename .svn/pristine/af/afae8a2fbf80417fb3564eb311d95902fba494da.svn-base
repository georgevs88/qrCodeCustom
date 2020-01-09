package pmcg.imti.view.ext;

import java.sql.SQLException;
import java.util.Date;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CadDAO;
import pmcg.fcn.domain.CadVO;
import pmcg.imti.ui.LogicUtils;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class Esqueci extends Index{
private static final long serialVersionUID = 1L;

	public String cpf;
	public String email;
	public Date data;
	
	public void initEsq() throws SQLException{
		vincular();
	}

	public void alterar() throws InterruptedException {
		if(cpf == null || cpf.isEmpty())
			throw new WrongValueException(this.getComponente("cpf"),"Informe o CPF (Login)!");
		if(email == null || email.isEmpty())
			throw new WrongValueException(this.getComponente("email"),"Informe o E-mail!");
		if(data == null)
			throw new WrongValueException(this.getComponente("data"),"Informe a Data de Nascimento!");
		CadVO cad = new CadVO();
		cad.setCpfcad(FormatUtils.onlyNumbers(cpf));
		cad.setEmacad(email);
		cad.setDnacad(data);
		cad = new CadDAO().getCadByCpfEmaDna(cad);
		if (cad != null && cad.getIddcad() != null && cad.getIddcad() > 0) {
			//Senha atual correta
			try {
				cad.setSencad(Formatacao.geraSenha());
				new CadDAO().updSenha(cad);
				Integer codupd = new CadDAO().updSenha(cad);
				if(codupd != null && codupd > 0){
					//Manda e-mail com a senha
					LogicUtils.sendEmailCad(cad.getCpfcad(), cad.getEmacad(), cad.getSencad(),cad.getNomcad());
					Messagebox.show("Senha Enviada ao E-mail!", "Alterar Senha", Messagebox.OK, Messagebox.EXCLAMATION);
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
			Messagebox.show("Usuário não Encontrado!", "Esqueci a Senha", Messagebox.OK, Messagebox.EXCLAMATION);
		}
		
	}

}
