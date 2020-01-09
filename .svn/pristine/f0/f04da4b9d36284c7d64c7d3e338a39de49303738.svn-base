package pmcg.imti.view;

import java.util.HashMap;

import org.zkoss.zk.ui.Executions;

import pmcg.framework.dao.ibatis.WebmnuDAO;
import pmcg.framework.ui.Window;

public class Cuboview extends Window{
	pmcg.framework.domain.WebsisVO sisVO;
	public String urlCubo;
	public String contexto;
	public String url;
	public Cuboview(){
		
	} 
	public void initComponentes(){
		sisVO=new WebmnuDAO().getSistema(getCodSis());
		urlCubo=sisVO.getUcusis();
		contexto=sisVO.getUccsis();
		String q =   this.request.get("query").toString();
		String codusu =getCodUsuario().toString();
		String coduni = getCodUnidade();
		String codprf =   ((HashMap)this.getSession().getAttribute("usumnu")).get("codprf").toString();
		String codsis = getCodSis().toString();
		this.url = urlCubo+ "?query="+q+"&coduni="+coduni+"&codsis="+codsis+"&codusu="+codusu+"&codprf="+codprf+"&contexto="+contexto;
 
		
//		q="Despesa";
//		codsis="13";
//		codprf="158";
//		codsis="1";
//		codusu="1";
//    	contexto="safweb";
		
	
		this.vincular();
	}
}
