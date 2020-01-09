package pmcg.imti.view.ext;
 

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.http.ExecutionImpl;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.impl.InputElement;

import pmcg.framework.dao.ibatis.WebmnuDAO;
import pmcg.framework.ui.Window;
import pmcg.imti.util.TokenContext;

public class WindowExt extends org.zkoss.zul.Window  {
 
	private static final long serialVersionUID = 1L;

		protected String zulPage;
 
		/**
		 * Requisicoes enviados para o Formulario
		 */
		protected Map request;

		/**
		 * Sessao
		 */
		protected HttpSession session;

		private AnnotateDataBinder binder = new AnnotateDataBinder(this);

		/**
		 * Componentes do Formulario
		 */
		private Map<String, HtmlBasedComponent> componentes = new HashMap<String, HtmlBasedComponent>();

		 
		public WindowExt() {
			super();
			initComponentes();
		}

		 
   

		/**
		 * Retorna um objeto da tela, e' necessario que o elemento tenha o seu ID
		 * setado
		 * 
		 * @param id
		 *            - ID do elemento
		 * @return HtmlBasedComponent - pode ser convertido para qualquer tipo de
		 *         objeto da tela
		 */
		protected HtmlBasedComponent getComponente(String id) {
			if (componentes.size() == 0) {
				for (Object c : getSpaceOwner().getFellows()) {
					HtmlBasedComponent e = (HtmlBasedComponent) c;
					componentes.put(e.getId(), e);
				}
			}
			return componentes.get(id);
		}

	  
		
		/**
		 * Retorna uma variavel configurada no arquivo ZUL pela TAG: <variable>
		 * 
		 * @param name
		 *            - String - nome da variavel
		 * @return Object
		 */
		public Object getVariavel(String name) {
			return getVariable(name, true);
		}

		/**
		 * Seta um valor para uma variavel configurada no arquivo ZUL pela TAG:
		 * <variable>
		 * 
		 * @param name
		 *            - nome da variavel
		 * @param val
		 *            - valor da variavel
		 */
		public void setVariavel(String name, Object val) {
			this.setVariable(name, val, true);
		}

		/**
		 * Inicializa os componentes da classe: request e session
		 */
		private void initComponentes() {
			session = (HttpSession) Executions.getCurrent().getDesktop().getSession().getNativeSession();
			request = ((ExecutionImpl) Executions.getCurrent()).getArg();
			// session = Sessions.getCurrent();
		}

		/**
		 * Retorna verdadeiro quando todos os elementos da tela que possuem o
		 * atributo <b>constraint</b> forem satisfeitos, para a validacao destes
		 * elementos o ID do elemente tambem tem que estar setado
		 * 
		 * @return Boolean
		 */
		protected Boolean validarForm() {
			for (Object c : getSpaceOwner().getFellows()) {
				if (c instanceof InputElement) {
					InputElement e = (InputElement) c;
					Object pai = e.getParent();
					if (!e.isValid()) {
						for (;;) {
							if (pai instanceof Tabpanel) {
								((Tabpanel) pai).getLinkedTab().setSelected(true);
								break;
							} else if (pai instanceof org.zkoss.zul.Window) {
								((org.zkoss.zul.Window) pai).focus();
								break;
							}
							pai = ((HtmlBasedComponent) pai).getParent();
						}
						e.focus();
						e.getConstraint().validate(e, e.getText());
						return false;
					}
				}
			}
			return true;
		}

		/**
		 * Retorna um Map com os valores passados na requisicao
		 * 
		 * @return Map
		 */
		public Map getRequest() {
			initComponentes();
			return request;
		}

		/**
		 * Retorna a Session
		 * 
		 * @return Session
		 */
		public HttpSession getSession() {
			if (session == null) initComponentes();
			return session;
		}
 
        

		/**
		 * Método para Restaurar o vinculo do Bean com os campos da tela
		 */
		public void vincular() {
			// this.binder = new AnnotateDataBinder(this);
			binder.init(this, true);
			binder.loadAll();
		}

		public AnnotateDataBinder getBinder() {
			return binder;
		}
		
		public void setBinder(AnnotateDataBinder binder) {
			this.binder = binder;
		}

		public String getZulPage() {
			return zulPage;
		}
		
		public void abrirBirt(String nomrpt, HashMap<String, String> parametros) throws Exception {
			//TODO buscar codsis
			Integer codsis = 41;
		
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("nomrpt", nomrpt);
			param.put("codsis", codsis);
		
			HashMap rpt = new WebmnuDAO().getRptDesing(param);
		
			if(rpt == null || rpt.get("ctxrpt") == null){
				throw new Exception("Erro ao buscar configurações do relatório.");
			}
			
			// Nome do Contexto
			String nomctx = rpt.get("ctxrpt").toString();
		
			// Host do Birt
			String urlhst = String.valueOf(rpt.get("urlhst")).split("/")[0].trim() + ":" + rpt.get("pjvhst");
		
			// Versao do Birt
			String bvsrpt = rpt.get("bvsrpt").toString();
		
			// Tipo da saida
			String tiprpt = rpt.get("tiprpt").toString().trim();
		
			// Descricao do relatorio
			String desrpt = rpt.get("desrpt").toString().trim();
		
			// Outros parametros
			String npar = "";
			if (parametros != null) {
				Iterator keysIter = parametros.entrySet().iterator();
				while (keysIter.hasNext()) {
					Map.Entry obj = (Map.Entry) keysIter.next();
					npar += "&" + obj.getKey() + "=" + (String) obj.getValue();
				}
			}
		
			Map<String, String> url = new HashMap<String, String>();
		
			/* Token generation. */
			TokenContext ct = new TokenContext("SafeBirt_Reporter");
			String token = "";
			token = "&token=" + ct.getBest("reports" + nomctx.trim() + "/" + nomrpt.trim());
		
			url.put("url", "http://" + urlhst.trim() + "/birt" + bvsrpt.trim()
				+ "/frameset?__report=reports/" + nomctx.trim() + "/" + nomrpt.trim()
				+ "&__showtitle=true" + "&__title=" + desrpt + "&__toolbar=true"
				+ "&__navigationbar=true" + "&__format=" + tiprpt.toLowerCase() + npar + token);
		
			final Window cmp = (Window) Executions.createComponents("/forms/birt.zul", null, url);
		
			// Auditoria de impressão de Relatório
//			WebaufVO auf = cmp.getInfo(WebaufVO.FORMULARIO_IMPRESSAO + ":BIRT", codsis);
//			auf.setFrmauf(nomrpt.trim() + "?" + npar);
//			cmp.setAuditInfo(auf);
		
			cmp.setMaximized(true);
			cmp.setSizable(true);
			cmp.setMaximizable(true);
			cmp.setClosable(true);
			cmp.doOverlapped();
		}
	
}
