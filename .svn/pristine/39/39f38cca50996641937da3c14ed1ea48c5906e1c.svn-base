<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"                  %>
<%@ page import="javax.sql.DataSource"        %>
<%@ page import="java.util.List"              %>
<%@ page import="java.util.Map"               %>
<%@ page import="java.util.ArrayList"         %>
<%@ page import="java.util.Iterator"          %>
<%@ page import="javax.naming.Context"        %> 
<%@ page import="javax.naming.InitialContext" %>

<%
	List<String> erros = new ArrayList<String>();

	if (request.getParameter("nomrpt") != null) {
		Context ctx     = new InitialContext();
		DataSource ds   = null;
		Connection con  = null;
		Statement  stmt = null;
		ResultSet  rst  = null;
		Integer codsis  = null;
		String  bvsrpt  = null;
		String  urlhst  = null;
		String  tiprpt  = null;
		String  desrpt  = null;
		String  nomrpt  = request.getParameter("nomrpt").toString();
		String  nomctx  = request.getParameter("nomctx") != null ? 
				          request.getParameter("nomctx").toString() :
				          request.getContextPath();
		
		String vars = "codsis bvsrpt urlhst tiprpt desrpt nomrpt nomctx";
				          
        try {				          
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jndiacessos");
			con = ds.getConnection();
	
			stmt = con.createStatement();
			rst  = stmt.executeQuery("SELECT * FROM websis WHERE urlsis ILIKE '%" + nomctx + "%'");
			
			
			if (rst.next())
				codsis = rst.getInt("codsis");
			else
				erros.add("Sistema não encontrado");
			
			rst  = stmt.executeQuery("SELECT * FROM webrpt r " + 
					                 "  JOIN webhst h ON r.codhst = h.codhst " + 
					                 " WHERE nomrpt = '" + nomrpt + "' " +
					                 "   AND codsis = " + codsis);
			
			if (rst.next()) {
				//Host do Birt
				urlhst = request.getParameter("urlhst") != null ?
						 request.getParameter("urlhst").toString() :
						 rst.getString("urlhst") == null ? rst.getString("niphst").split("/")[0] + ":" + rst.getString("pjvhst") : 
							                               rst.getString("urlhst");

				// Versao do Birt
				if (request.getParameter("bvsrpt") == null){
					String[] vb = rst.getString("bvshst").toString().split(",");
					Float maiorBirt = new Float(0);
					for(String v : vb){
						Float ver = new Float(v);
						if (maiorBirt < ver) maiorBirt = ver;
					}
					bvsrpt = maiorBirt.toString();
				} else
					bvsrpt = request.getParameter("bvsrpt").toString();
				
				// Tipo da saida
				tiprpt = request.getParameter("tiprpt") != null ?
						 request.getParameter("tiprpt").toString() :
						 rst.getString("tiprpt").trim();
				
				// Descrição do relatorio						 
				desrpt = request.getParameter("desrpt") != null ?
						 request.getParameter("desrpt").toString() :
						 rst.getString("desrpt").trim();

				// Outros parametros
	            Map parametros = request.getParameterMap();
	            String npar = "";
	            Iterator keysIter = parametros.entrySet().iterator();
            	while (keysIter.hasNext()) {
            		Map.Entry obj = (Map.Entry) keysIter.next();
            	    if (vars.indexOf(obj.getKey().toString()) < 0)
            	    	npar += "&" + obj.getKey() + "=" + ((String[])obj.getValue())[0]; 
            	}	            
						 
	            String redirect = "http://" + urlhst + "/birt" + bvsrpt + "/frameset?__report=reports" + nomctx + "/" + nomrpt + 
	            		          "&__showtitle=true" +
	            		          "&__title=" + desrpt + 
	            		          "&__toolbar=true" +
	            		          "&__navigationbar=true" +
	            		          "&__format=" + tiprpt.toLowerCase() + npar;
	            
	            
            	if (erros.size() == 0)	            
					response.sendRedirect(redirect);
	            
			} else erros.add("Relatório não cadastrado");
        } catch (Exception e) {
        	erros.add(e.getMessage());
        } finally {
        	stmt.close();
        	con.close();
        }
	} else erros.add("Faltam parâmetros: <br>" +
			         "<pre>nomrpt: nome do arquivo do relatorio (OBRIGATORIO)</pre>" +
			         "<pre>bvsrpt: versao do birt. Ex.: 2.2. (OPCIONAL)</pre>" + 
			         "<pre>urlhst: URL do servidor do birt. (OPCIONAL)</pre>" + 
			         "<pre>tiprpt: Tipo da saida pdf, html (OPCIONAL)</pre>" +
			         "<pre>desrpt: Descrição do relatorio (OPCIONAL)</pre>" + 
			         "<pre>nomctx: Nome do contexto ou aplicação da qual o relatorio faz parte (OPCIONAL)</pre><br>" +
			         "<b><em>Os parâmetros opcionais tem que ter a informação gravada no banco de dados</em></b>");

	if (erros.size() > 0)
		out.println(erros.toString());

%>    