package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.EpdVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;
   /** 
    * EpdDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class EpdDAO extends DAOConcorrencia<EpdVO, Long> { 
 	public EpdDAO() { 
 		super("Epd","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<EpdVO> getRegByCriterioComplex(EpdVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Epd"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public EpdVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Epd"); 
 		try { 
 			return (EpdVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Epd"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(EpdVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Epd");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<EpdVO> 	getByCriterioLimit(EpdVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Epd");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public EpdVO getRegByProcesso(String nprepd) { 
 		try { 
 			return (EpdVO) sqlMap.queryForObject(getNameSpaceMap() + ".getRegByProcesso", nprepd); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
  	
  	public Integer updConfRecebimentoByProcesso(String numeroProcesso) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updConfRecebimentoByProcesso", numeroProcesso);
	}
  	
  	public List<HashMap<String, Object>> getEpdGravados() {
		List<HashMap<String, Object>> lis = null;
		try {
			lis = sqlMap.queryForList(this.getNameSpaceMap() + ".getEpdGravados");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
  	
  	public List<HashMap<String, Object>> getEpdGravadosLimit(HashMap<String,Object> param, Integer inicial, Integer maximoPermitido) {
		List<HashMap<String, Object>> lis = null;
		try {
			lis = sqlMap.queryForList(this.getNameSpaceMap() + ".getEpdGravados", param, inicial, maximoPermitido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
  	
  	public Integer countEpdGravados(HashMap<String,Object> param) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countEpdGravados", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  	
  	public List<EpdVO> getEpdPendente(HashMap<String,Object> map) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getEpdPendente", map);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
  	
  	public String getInscricaoByProcesso(String processo) { 
 		try { 
 			return (String) sqlMap.queryForObject(getNameSpaceMap() + ".getInscricaoByProcesso", processo); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
  	
  	public Integer countEpdByProcesso(String processo) { 
 		try { 
 			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countEpdByProcesso", processo); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}

	public Integer updConfirmaInscricaoByIdd(EpdVO epdupd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updConfirmaInscricaoByIdd", epdupd);
	}
	
	public String getRiscoByProcesso(String nprepd) {
		try {
			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getRiscoByProcesso", nprepd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getQlfByNjrCondi(HashMap<String,Object> map) {  
  		try {  
  			return (String) sqlMap.queryForObject(getNameSpaceMap() + ".getQlfByNjrCondi", map);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
	
	public Integer updAtendidoByProcesso(String nprepd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updAtendidoByProcesso", nprepd);
	}
	
	public List<HashMap<String, Object>> getEpdLimit(HashMap<String, Object> param, Integer inicial, Integer maximoPermitido) {
		List<HashMap<String, Object>> lis = null;
		try {
			lis = sqlMap.queryForList(this.getNameSpaceMap() + ".getEpdLimit", param, inicial,maximoPermitido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	public Integer countEpd(HashMap<String, Object> param) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countEpd", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer updAtendimento(EpdVO epd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updAtendimento", epd);
	}
	
	public Integer updMensagemSIAT(EpdVO epd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updMensagemSIAT", epd);
	}
	
	public Integer updMensagemConfRec(EpdVO epd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updMensagemConfRec", epd);
	}

	public List<EpdVO> getEpdByConfRecPendente() {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getEpdByConfRecPendente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getQtdViaEpd(String ano) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getQtdViaEpd", ano);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getQtdViaEpdMes(String mesano) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getQtdViaEpdMes", mesano);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getGraficoAteEpd(String ano) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getGraficoAteEpd", ano);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getGraficoAteEpdMes(String mesano) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getGraficoAteEpdMes", mesano);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, Object> getDadosInsmun(HashMap<String, Object> dados) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getDadosInsmun", dados);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer updLicencaAmb(EpdVO epd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updLicencaAmb", epd);
	}
	
	public Integer updLicencaVig(EpdVO epd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updLicencaVig", epd);
	}
	
	public Integer updEpdSosweb(EpdVO epd) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updEpdSosweb", epd);
	}
 } 
 