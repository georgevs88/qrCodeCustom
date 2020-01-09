package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
import pmcg.imti.domain.EstVO; 
import java.util.List; 
import java.sql.SQLException; 
   /** 
    * EstDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class EstDAO extends DAOConcorrencia<EstVO, Integer> { 
 	public EstDAO() { 
 		super("Est","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigSIATCGR.xml"); 
 	} 
 	  
 	@SuppressWarnings("unchecked")
	public List<EstVO> getRegByCriterioComplex(EstVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Est"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public EstVO getRegByCodComplex(Integer cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Est"); 
 		try { 
 			return (EstVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Est"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(EstVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Est");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	@SuppressWarnings("unchecked")
	public List<EstVO> 	getByCriterioLimit(EstVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Est");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public EstVO getEstByUF(String uf) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Est"); 
 		try { 
 			return (EstVO) sqlMap.queryForObject(nameSpace + ".getEstByUF",uf); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 } 
 