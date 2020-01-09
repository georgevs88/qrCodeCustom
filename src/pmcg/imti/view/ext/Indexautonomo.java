package pmcg.imti.view.ext;

import org.zkoss.zk.ui.Executions;

public class Indexautonomo extends WindowExt {
	private static final long serialVersionUID = 1L;

	public String login;
	public String loginVer;
	public String senha;
	
	public void initComponentes() {
		this.vincular();
	}

	public String getUsuario() {
		if (getSession().getAttribute("usuarioextautonomo") != null) {
			return "" + (String) getSession().getAttribute("cpfautonomo") + " - " + (String) getSession().getAttribute("nomeautonomo");
		} else {
			return "";
		}
	}

	public String getUsuarioNome() {
		if (getSession().getAttribute("usuarioextautonomo") != null) {
			return "" + (String) getSession().getAttribute("nomeautonomo");
		} else {
			return "";
		}
	}

	public boolean isAutenticado() {
		if (getSession().getAttribute("usuarioextautonomo") != null) {
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
		Executions.sendRedirect("/autonomo.zul");
	}

	public void desconectarUsuario() {
		if (getSession().getAttribute("usuarioextautonomo") != null) {
			getSession().removeAttribute("cpfautonomo");
			getSession().removeAttribute("usuarioextautonomo");
			getSession().removeAttribute("nomeautonomo");
		}
		Executions.sendRedirect("/autonomo.zul");
	}

	public String getMensagemLogin() {
		String mensagem = "<div class=\"message\"><h2>Olá! Seja bem vindo(a) " + getUsuarioNome() + " !</h2>";
		mensagem += "</div>";
		return mensagem;
	}

		
}
