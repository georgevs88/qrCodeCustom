package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
import pmcg.imti.domain.ViaVO; 

import java.util.HashMap;
import java.util.List; 
import java.sql.SQLException; 
   /** 
    * ViaDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class ViaDAO extends DAOConcorrencia<ViaVO, Long> { 
 	public ViaDAO() { 
 		super("Via", "pmcg/imti/dao/ibatis/sqlmap/SqlMapCfgEF.xml"); 
 	} 
 	  
 	public List<ViaVO> getRegByCriterioComplex(ViaVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Via"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public ViaVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Via"); 
 		try { 
 			return (ViaVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Via"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(ViaVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Via");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<ViaVO> 	getByCriterioLimit(ViaVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Via");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<HashMap<String,Object>>	getParecerByProtocolo(Long con_id) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getParecerByProtocolo", con_id);  
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
  	
  	public HashMap<String,Object> getProtocoloByCnpj(String cnpj) { 
 		try { 
 			return (HashMap<String, Object>) sqlMap.queryForObject(getNameSpaceMap() + ".getProtocoloByCnpj", cnpj); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
 } 
 