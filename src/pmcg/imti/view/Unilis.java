package pmcg.imti.view;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

import pmcg.framework.dao.ibatis.WebmnuDAO;
import pmcg.framework.dao.ibatis.WebuniDAO;
import pmcg.framework.domain.WebuniVO;
import pmcg.framework.ui.WindowList;

@SuppressWarnings({ "serial", "unchecked" })
public class Unilis extends WindowList<HashMap> {

	/**
	 * List de Retorno do DAO
	 */
	private List<HashMap<String,Object>> hmSis;

	/**
	 * Vinculado a caixa de pesquisa no forumlario
	 */
	public String nome = new String();

	/**
	 * DAO
	 */
	private WebmnuDAO DAO = new WebmnuDAO();
	HashMap vo;
	public Unilis() {
		super();
		  vo=(HashMap) this.getSession().getAttribute("usumnu");
	}

	@SuppressWarnings("static-access")
	public void check(String cod) {
		WebuniDAO uDAO = new WebuniDAO();
		WebuniVO vo = new WebuniVO();
		try {
			vo.setCoduni(cod);
			vo.setCodsis(Integer.parseInt(((java.util.HashMap) this.getSession().getAttribute("usumnu")).get("codsis")
					.toString()));
			WebuniVO m = uDAO.getRegByCod(vo);
			BeanUtils.copyProperties(item, m);
			this.getSession().setAttribute("usumnu", vo);
			this.selecionar();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public void pesquisar() {
		if (vo == null) return;
		//HashMap vo = (HashMap) this.getSession().getAttribute("usumnu");
		HashMap  pesvo=new HashMap<String ,Object>();
		pesvo.put("codusu",vo.get("codusu"));
		pesvo.put("codsis", vo.get("codsis"));
		pesvo.put("desuni", nome == null ? "" : nome);
		
		hmSis = DAO.getUnidades(pesvo);
		setListmodel(new ListModelList(hmSis));
		this.atualizar();
		((Textbox) this.getComponente("nome")).select();
	}
}