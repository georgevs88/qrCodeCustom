package pmcg.imti.view.ext;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;

import pmcg.fcn.domain.CadVO;
import pmcg.framework.util.StringUtils;
import pmcg.framework.util.WinUtils;

public class Index extends WindowExt {
	private static final long serialVersionUID = 1L;

	public String login;
	public String loginVer;
	public String senha;
	//public String ip;

	public String displayHome, classHome;
	public String displayAcesso, classAcesso;
	public String displayViabilidade, classViabilidade;
	public String displayAcompanhamento, classAcompanhamento;
	public String displayAlterar, classAlterar;
	public String displayEntrar;
	
	public void initComponentes(int nav) {
		if(isNaoAutenticado()){
			displayAcompanhamento = displayAlterar = "display: none;";
			displayHome = displayAcesso = displayViabilidade = "display: block;";
		} else {
			displayAcesso = "display: none;";
			displayHome = displayViabilidade = displayAcompanhamento = displayAlterar = "display: block;";
		}
		if(isAutenticado() && (getSession().getAttribute("admin") != null && ((Boolean) getSession().getAttribute("admin"))) && (getSession().getAttribute("usuarioExtVer") == null)){
			displayEntrar = "display: block;";
		} else {
			displayEntrar = "display: none;";
		}
		switch (nav) {
		case 1:
			classHome = "active";
			classAcesso = classViabilidade = classAlterar = "";
			break;
		case 2:
			classAcesso = "active";
			classHome = classViabilidade = classAlterar = "";
			break;
		case 3:
			classViabilidade = "active";
			classHome = classAcesso = classAlterar = "";
			break;
		case 4:
			classAcompanhamento = "active";
			classHome = classAcesso = classViabilidade = classAlterar = "";
			break;
		case 5:
			classAlterar = "active";
			classHome = classAcesso = classViabilidade = classAcompanhamento = "";
			break;
		}
		this.vincular();
	}
	
	public CadVO getUsuario() {
		if (getSession().getAttribute("usuarioExtCim") != null) {
			return (CadVO) getSession().getAttribute("usuarioExtCim");
		} else {
			return null;
		}
	}

	public String getUsuarioNome() {
		if(isAutenticado()){
			return getUsuario().getNomcad();
		} else {
			return "";
		}
	}
	
	public String getUsuarioLogin() {
		if(isAutenticado()){
			return getUsuario().getCpfcad();
		} else {
			return "";
		}
	}

	public boolean isAutenticado() {
		if (getSession().getAttribute("usuarioExtCim") != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNaoAutenticado() {
		return !isAutenticado();
	}

	public void trataVO() {
		if(login == null || login.replaceAll("[/._-]", "").isEmpty()){
			throw new WrongValueException(this.getComponente("login"),"Informe o CPF/CNPJ!");
		} else if(login.length() != 11 && login.length() != 14){
			throw new WrongValueException(this.getComponente("login"),"CPF/CNPJ incompleto!");
		}
		if(login.replaceAll("[/._-]", "").length() == 11){
			validaCPF();
		}
		if (senha == null || senha.trim().isEmpty()) {
			throw new WrongValueException(this.getComponente("senha"), "Informe a Senha!");
		}
	}

	public void validaCPF() {
		if (login != null) {
			String cpf = login.replaceAll("[/._-]", "").trim();
			boolean valido = StringUtils.valida_CpfCnpj(cpf);
			if (!valido) {
				throw new WrongValueException(getComponente("login"),"Informe um CPF válido!");
			}
		} else {
			throw new WrongValueException(getComponente("login"), "Informe o CPF!");
		}
	}

	public void redirecionarTela(String link) {
		Executions.sendRedirect(link);
	}

	public void redirecionarUsuario() {
		Executions.sendRedirect("/index.zul");
	}

	public void desconectarUsuario() {
		if(getSession().getAttribute("usuarioExtCim") != null && getSession().getAttribute("usuarioExtVer") != null){
			//está logado como usuarioVer,então destroca os usuarios e remove usuario ver da sessao
			CadVO cadOri = (CadVO) getSession().getAttribute("usuarioExtVer");
			getSession().removeAttribute("usuarioExtCim");
			getSession().removeAttribute("usuarioExtVer");
			
			session.setAttribute("usuarioExtCim", cadOri);
		} else {
			getSession().removeAttribute("usuarioExtCim");
		}
		if (getSession().getAttribute("viabae") != null) {
			getSession().removeAttribute("viabae"); //se tem alguma viabilidade para fazer bae na sessao limpa
		}
		Executions.sendRedirect("/acesso.zul");
	}
	
	public void entrarComo() {
		new WinUtils().abrirLis("/forms/entcom.zul", null, this, null);
	}
	
	public void retEntrar() {
		CadVO cadOri = (CadVO) getSession().getAttribute("usuarioExtCim");
		CadVO cadVer = (CadVO) getSession().getAttribute("usuarioExtVer");
		
		//troca os objetos
		getSession().removeAttribute("usuarioExtCim");
		getSession().removeAttribute("usuarioExtVer");
		session.setAttribute("usuarioExtCim", cadVer);
		session.setAttribute("usuarioExtVer", cadOri);
		
		Executions.sendRedirect("/index.zul");
	}
	
}
