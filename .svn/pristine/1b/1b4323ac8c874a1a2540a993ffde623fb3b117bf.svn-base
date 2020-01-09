package pmcg.fcn.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.fcn.domain.AnxVO; 
 import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * AnxDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class AnxDAO extends DAOConcorrencia<AnxVO, Long> { 
 	public AnxDAO() { 
 		super("Anx", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<AnxVO> getRegByCriterioComplex(AnxVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Anx"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public AnxVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Anx"); 
 		try { 
 			return (AnxVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Anx"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(AnxVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Anx");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<AnxVO> 	getByCriterioLimit(AnxVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Anx");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<AnxVO> getRegByDocTpd(AnxVO obj) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByDocTpd",obj);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
 } 
 