package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.SadVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;
   /** 
    * SadDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class SadDAO extends DAOConcorrencia<SadVO, Long> { 
 	public SadDAO() { 
 		super("Sad","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	@SuppressWarnings("unchecked")
	public List<SadVO> getRegByCriterioComplex(SadVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Sad"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public SadVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Sad"); 
 		try { 
 			return (SadVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Sad"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(SadVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Sad");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	@SuppressWarnings("unchecked")
	public List<SadVO> 	getByCriterioLimit(SadVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Sad");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}

	@SuppressWarnings("unchecked")
	public List<SadVO> getByMatriz(Long iddmat) {
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Sad");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByMatriz",iddmat);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
		return null;
	} 
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getSadByMatriz(Long matsad) {
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getSadByMatriz", matsad);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
		return null;
	} 
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getSadByBae(Long baesad) {
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getSadByBae", baesad);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
		return null;
	} 
	
	public List<SadVO> getRegByBae(Long baesad) {
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByBae", baesad);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
		return null;
	}
 } 
 