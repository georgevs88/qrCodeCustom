package pmcg.fcn.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
import pmcg.fcn.domain.TabVO; 

import java.util.List; 
import java.sql.SQLException; 
   /** 
    * TabDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class TabDAO extends DAOConcorrencia<TabVO, Long> { 
 	public TabDAO() { 
 		super("Tab","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<TabVO> getRegByCriterioComplex(TabVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Tab"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public TabVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Tab"); 
 		try { 
 			return (TabVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Tab"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(TabVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Tab");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<TabVO> 	getByCriterioLimit(TabVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Tab");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public String getPaisByCodigo(String codigoRFB) {  
  		try {
			return (String) sqlMap.queryForObject("Tab.getPaisByCodigo", codigoRFB);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigoRFB; 
  	}
  	
  	@SuppressWarnings("unchecked")
	public List<TabVO> getRegByTipo(String tabtab) {  
  		try {
			return (List<TabVO>) sqlMap.queryForList("Tab.getRegByTipo", tabtab);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
  	}

	public Integer getLastCodController() {
		try {
			return (Integer) sqlMap.queryForObject("Tab.getLastCodController");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
  	
 } 
 