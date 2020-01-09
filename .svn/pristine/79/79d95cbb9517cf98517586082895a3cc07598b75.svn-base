package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.imti.domain.SinVO; 
 import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * SinDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class SinDAO extends DAOConcorrencia<SinVO, Integer> { 
 	public SinDAO() { 
 		super("Sin","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigSIATCGR.xml"); 
 	} 
 	  
 	public List<SinVO> getRegByCriterioComplex(SinVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Sin"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public SinVO getRegByCodComplex(Integer cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Sin"); 
 		try { 
 			return (SinVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Sin"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(SinVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Sin");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<SinVO> 	getByCriterioLimit(SinVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Sin");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public SinVO getSinBySigla(String sigla) { 
 		try { 
 			return (SinVO) sqlMap.queryForObject(getNameSpaceMap() + ".getSinBySigla", sigla); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 } 
 