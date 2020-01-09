package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.CfgVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia; 
   /** 
    * CfgDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class CfgDAO extends DAOConcorrencia<CfgVO, Long> { 
 	public CfgDAO() { 
 		super("Cfg", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<CfgVO> getRegByCriterioComplex(CfgVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cfg"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public CfgVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cfg"); 
 		try { 
 			return (CfgVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cfg"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(CfgVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cfg");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<CfgVO> 	getByCriterioLimit(CfgVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cfg");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public String getValorByParam(String param) {
		try {
			return (String) sqlMap.queryForObject(getNameSpaceMap() + ".getValorByParam", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
  	
  	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getAcaoImportacao() {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(getNameSpaceMap() + ".getAcaoImportacao");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
  	
  	public Integer updValByPar(HashMap<String, Object> cfg) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updValByPar", cfg);
	}
  	
  	public List<HashMap<String, Object>> getAtualizacoesSistema() {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(getNameSpaceMap() + ".getAtualizacoesSistema");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
 } 
 