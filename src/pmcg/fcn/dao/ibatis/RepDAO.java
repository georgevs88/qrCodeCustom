package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.RepVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;
   /** 
    * RepDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class RepDAO extends DAOConcorrencia<RepVO, Long> { 
 	public RepDAO() { 
 		super("Rep","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<RepVO> getRegByCriterioComplex(RepVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Rep"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public RepVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Rep"); 
 		try { 
 			return (RepVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Rep"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(RepVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Rep");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<RepVO> 	getByCriterioLimit(RepVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Rep");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}

	public List<RepVO> getRegBySad(Long iddsad) {
		try {
			return (List<RepVO>) sqlMap.queryForList(getNameSpaceMap() + ".getRegBySad",iddsad);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;  
	} 
	
	public List<HashMap<String, Object>> getRepBySad(Long iddsad) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(getNameSpaceMap() + ".getRepBySad",iddsad);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;  
	}
 } 
 