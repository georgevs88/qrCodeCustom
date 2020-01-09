package pmcg.imti.view;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CfgDAO;
import pmcg.fcn.dao.ibatis.TabDAO;
import pmcg.fcn.domain.CfgVO;
import pmcg.fcn.domain.TabVO;
import pmcg.framework.ui.WindowCrud;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.UsuDAO;
import pmcg.imti.domain.UsuVO;
import pmcg.imti.domain.WebusuVO;

public class Cmacad extends WindowCrud{
	private static final long serialVersionUID = 1L;
	public String nomeOrgao;
	public String siglaOrgao;
	public String nomeDivisao;
	public String siglaDivisao;
	public String siglasDivisao;
	public List<UsuVO> listUsu;
	public UsuVO usuSelRel;
	public UsuVO usuSelLic;
	public TabVO cargoRel;
	public TabVO cargoLic;
	public CfgVO cfgVO = new CfgVO();
	public List<TabVO> listCargo = new ArrayList<TabVO>(); //Lista de cargos
	
	public WebusuVO webusu = new WebusuVO();
	public List<WebusuVO> listWebusu = new ArrayList<WebusuVO>();
	public Boolean incluirUsuario = false;
	public String descricaoCargo;
	
	public void initComponentes() throws InterruptedException, SQLException{
		listUsu = new UsuDAO().getTodos(null);
		getCrdBar().getBotao(0).setVisible(false);
		getCrdBar().getBotao(1).setVisible(true);
		getCrdBar().getBotao(2).setVisible(false);
		getCrdBar().getBotao(3).setVisible(false);
		getCrdBar().getBotao(4).setVisible(false);
		getCrdBar().getBotao(5).setVisible(false);
		getCrdBar().getBotao(6).setVisible(true);
		listCargo = new TabDAO().getRegByTipo("CARGO_MA");
		nomeOrgao = new CfgDAO().getValorByParam("NOME_ORGAO_MA");
		siglaOrgao = new CfgDAO().getValorByParam("SIGLA_ORGAO_MA");
		nomeDivisao = new CfgDAO().getValorByParam("NOME_DIVISAO_MA");
		siglaDivisao = new CfgDAO().getValorByParam("SIGLA_DIVISAO_MA");
		siglasDivisao = new CfgDAO().getValorByParam("SIGLAS_DIVISAO_MA");
		String codusurel = new CfgDAO().getValorByParam("CODUSU_RESP_REL_MA");
		usuSelRel = new UsuDAO().getRegByCod(Long.parseLong(codusurel));
		String CARGO_RESP_REL_MA = new CfgDAO().getValorByParam("CARGO_RESP_REL_MA");
		TabVO tab = new TabVO();
		tab.setDestab(CARGO_RESP_REL_MA);
		cargoRel = (new TabDAO().getRegByCriterio(tab)).get(0);
		String codusulic = new CfgDAO().getValorByParam("CODUSU_RESP_LIC_MA");
		usuSelLic = new UsuDAO().getRegByCod(Long.parseLong(codusulic));
		String CARGO_RESP_LIC_MA = new CfgDAO().getValorByParam("CARGO_RESP_LIC_MA");
		tab.setDestab(CARGO_RESP_LIC_MA);
		cargoLic = (new TabDAO().getRegByCriterio(tab)).get(0);
		vincular();
	}
	
	@Override
	public void salvar() throws InterruptedException {
		if (Messagebox.show("Tem certeza que deseja Salvar as Comnfigurações?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
			try {
				HashMap<String, Object> param = new HashMap<String, Object>();
				param.put("parcfg", "NOME_ORGAO_MA");
				param.put("valcfg", nomeOrgao);
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "SIGLA_ORGAO_MA");
				param.put("valcfg", siglaOrgao);
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "NOME_DIVISAO_MA");
				param.put("valcfg", nomeDivisao);
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "SIGLA_DIVISAO_MA");
				param.put("valcfg", siglaDivisao);
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "SIGLAS_DIVISAO_MA");
				param.put("valcfg", siglasDivisao);
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "CODUSU_RESP_REL_MA");
				param.put("valcfg", usuSelRel.getCodusu().toString());
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "CARGO_RESP_REL_MA");
				param.put("valcfg", cargoRel.getDestab());
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "CODUSU_RESP_LIC_MA");
				param.put("valcfg", usuSelLic.getCodusu().toString());
				new CfgDAO().updValByPar(param);
				
				param.put("parcfg", "CARGO_RESP_LIC_MA");
				param.put("valcfg", cargoLic.getDestab());
				new CfgDAO().updValByPar(param);
				Messagebox.show("Configuração salva com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void buscarUsuariosSistema(){
		HashMap<String, String> param = new HashMap<String, String>();
		new WinUtils().abrirLis("/forms/usersystemlis.zul", param, this, "retornoUsers");	
	}
	
	public void retornoUsers(Object obj){
		try {
			if(obj != null){
				webusu = (WebusuVO) BeanUtils.cloneBean((WebusuVO) obj);
				incluirUsuario = true;
			}
			else
				incluirUsuario = false;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}		
		this.vincular();
	}
	
	public void pesquisar() {
	}
	
	@Override
	public void incluir() throws InterruptedException {
		
	}

	@Override
	public void apagar() throws InterruptedException {
	}

	@Override
	public void limpar() throws InterruptedException {
		vincular();
	}

	@Override
	public void imprimir() throws InterruptedException {
		
	}

	@Override
	public void sair() throws InterruptedException {
		detach();
	}
	
	public void incluirUsuarios(){
		if(webusu != null && webusu.getLogusu() != null && webusu.getNomusu() != null){
			UsuVO usuVO = new UsuVO();
			usuVO.setLogusu(webusu.getLogusu());
			usuVO.setNomusu(webusu.getNomusu());
			usuVO.setAtvusu(true);
			try {
				Integer validador = new UsuDAO().getDuplicidade(usuVO); 
				if(validador > 0){
					Messagebox.show("Usuário existente");
				}
				else{
					new UsuDAO().insReg(usuVO);
					Messagebox.show("Inserido!");
					listUsu = new UsuDAO().getTodos(null);
					webusu = new WebusuVO();
					incluirUsuario = false;
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.vincular();
	}
	
	public void incluirCargos(){
		if(descricaoCargo != null && !descricaoCargo.trim().equals("")){
			TabVO cargo = new TabVO();
			Integer lastCod = new TabDAO().getLastCodController();
			if(lastCod != null && lastCod > 0){
				cargo.setTabtab("CARGO_MA");
				cargo.setInftab(descricaoCargo);
				cargo.setCodtab(lastCod.toString());
				cargo.setDestab(descricaoCargo);
				try {
					new TabDAO().insReg(cargo);
					Messagebox.show("Cargo Inserido!");
					listCargo = new TabDAO().getRegByTipo("CARGO_MA");
					descricaoCargo = null;
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else{
				try {
					Messagebox.show("Não foi possível Inserir, contate o administrador");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			try {
				Messagebox.show("Informe o que inserir!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.vincular();
	}
	
	public void removerUsuario(Object usuVO) throws SQLException, InterruptedException{
		UsuVO usuarioRemover = (UsuVO) usuVO;
		new UsuDAO().delReg(usuarioRemover.getCodusu());
		Messagebox.show("Usuário Removido!");
		listUsu = new UsuDAO().getTodos(null);
		this.vincular();
	}
	
	public void removerCargo(Object tabVO) throws SQLException, InterruptedException{
		TabVO cargoRemover = (TabVO) tabVO;
		new TabDAO().delReg(cargoRemover.getIddtab());
		Messagebox.show("Cargo Removido!");
		listCargo = new TabDAO().getRegByTipo("CARGO_MA");
		this.vincular();
	}
}
