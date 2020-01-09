package pmcg.imti.view.ext;

import java.sql.SQLException;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.domain.EpdVO;

public class IndexSos extends WindowExt {
	private static final long serialVersionUID = 1L;

	public String login;
	public String loginVer;
	public String senha;
	
	public void initComponentes() {
		this.vincular();
	}

	public EpdVO getUsuario() {
		if (getSession().getAttribute("usuarioSos") != null) {
			return (EpdVO) getSession().getAttribute("usuarioSos");
		} else {
			return null;
		}
	}

	public String getUsuarioNome() {
		if (getSession().getAttribute("usuarioSos") != null) {
			return "" + (String) getSession().getAttribute("nomeUsuarioSos");
		} else {
			return "";
		}
	}
	
	public void trataVO() {
		if(login == null || login.replaceAll("[/._-]", "").isEmpty()){
			throw new WrongValueException(this.getComponente("login"),"Informe o Login!");
		} 
		if (senha == null || senha.trim().isEmpty()) {
			throw new WrongValueException(this.getComponente("senha"), "Informe a Senha!");
		}
	}
	
	public void autenticar() {
		this.trataVO();
		//TODO
		if (login.equals("usuario") && senha.equals("1")) {
			//AUTENTICADO
			try {
				EpdVO epd = new EpdDAO().getRegByCod(108L);
				session.setAttribute("usuarioSos", epd);
				session.setAttribute("nomeUsuarioSos", epd.getNprepd());
				redirecionarUsuario();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					Messagebox.show("Não foi possível autenticar o usuário!");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
		} else {
			throw new WrongValueException(this.getComponente("login"),"Login/Senha incorreto!");
		}
		vincular();
	}

	public boolean isAutenticado() {
		if (getSession().getAttribute("usuarioSos") != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNaoAutenticado() {
		return !isAutenticado();
	}

	public void redirecionarTela(String link) {
		Executions.sendRedirect(link);
	}

	public void redirecionarUsuario() {
		Executions.sendRedirect("/ext/sosweb/envdoc.zul");
	}

	public void desconectarUsuario() {
		if (getSession().getAttribute("usuarioSos") != null) {
			getSession().removeAttribute("usuarioSos");
			getSession().removeAttribute("nomeUsuarioSos");
		}
		Executions.sendRedirect("/ext/sosweb/index.zul");
	}

	public String getMensagemLogin() {
		String mensagem = "<div class=\"message\"><h2>Olá! Seja bem vindo(a) " + getUsuarioNome() + " !</h2>";
		mensagem += "</div>";
		return mensagem;
	}

		
}
