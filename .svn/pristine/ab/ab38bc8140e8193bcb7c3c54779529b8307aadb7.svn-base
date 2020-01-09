package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.imti.domain.CclVO;

import java.util.HashMap;
import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * CclDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class CclDAO extends DAOConcorrencia<CclVO, Double> { 
 	public CclDAO() { 
 		super("CclO", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<CclVO> getRegByCriterioComplex(CclVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Ccl"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public CclVO getRegByCodComplex(Double cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Ccl"); 
 		try { 
 			return (CclVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Ccl"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(CclVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Ccl");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<CclVO> 	getByCriterioLimit(CclVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Ccl");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getRegNA(HashMap<String, Object> ccl, Integer inicial, Integer maximoPermitido) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(this.getNameSpaceMap()+".getRegNA", ccl, inicial,
					maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getRegA(HashMap<String, Object> ccl, Integer inicial, Integer maximoPermitido) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(this.getNameSpaceMap()+".getRegA", ccl, inicial,
					maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer countRegNA(HashMap<String, String> ccl) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countRegNA", ccl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Integer countRegA(HashMap<String, String> ccl) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countRegA", ccl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Integer updClasse(HashMap ccl) throws SQLException {
		return (Integer) sqlMap.update(this.getNameSpaceMap() + ".updClasse", ccl);
	}
	
	@SuppressWarnings("unchecked")
	public List<CclVO> getCclByCnae(String cnae) { 
 		try { 
 			return sqlMap.queryForList(this.getNameSpaceMap() + ".getCclByCnae",cnae); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 } 
 