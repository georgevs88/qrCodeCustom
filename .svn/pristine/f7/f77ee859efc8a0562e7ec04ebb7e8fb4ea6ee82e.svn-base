package pmcg.fcn.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.fcn.domain.EevVO;

import java.util.HashMap;
import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * EevDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class EevDAO extends DAOConcorrencia<EevVO, Long> { 
 	public EevDAO() { 
 		super("Eev","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<EevVO> getRegByCriterioComplex(EevVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Eev"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public EevVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Eev"); 
 		try { 
 			return (EevVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Eev"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(EevVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Eev");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<EevVO> 	getByCriterioLimit(EevVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Eev");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	

	public List<HashMap<String, Object>> getEventosByPro(Long iddpro) {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getEventosByPro", iddpro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public Boolean getTransferenciaByPro(Long proeev) {  
  		try {  
  			return (Boolean) sqlMap.queryForObject(getNameSpaceMap() + ".getTransferenciaByPro", proeev);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
 } 
 