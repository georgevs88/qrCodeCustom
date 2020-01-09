package pmcg.fcn.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.fcn.domain.RpmVO; 
 import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * RpmDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class RpmDAO extends DAOConcorrencia<RpmVO, Long> { 
 	public RpmDAO() { 
 		super("Rpm"); 
 	} 
 	  
 	public List<RpmVO> getRegByCriterioComplex(RpmVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Rpm"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public RpmVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Rpm"); 
 		try { 
 			return (RpmVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Rpm"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(RpmVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Rpm");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<RpmVO> 	getByCriterioLimit(RpmVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Rpm");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
  	
  	public List<RpmVO> getRegByProcesso(Long iddpma) { 
 		try { 
 			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByProcesso", iddpma); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
 } 
 