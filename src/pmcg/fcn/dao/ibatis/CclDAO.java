package pmcg.fcn.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.fcn.domain.CclVO;
import pmcg.fcn.domain.CusVO;

import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * CclDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class CclDAO extends DAOConcorrencia<CclVO, Integer> { 
 	public CclDAO() { 
 		super("Ccl","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
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
   
 	public CclVO getRegByCodComplex(Integer cod) { 
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
  	
  	public CclVO getRegByCNAE(CclVO ccl) {
		try {
			return (CclVO) sqlMap.queryForObject(getNameSpaceMap() + ".getRegByCNAE", ccl);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	} 
  	
  	public CclVO getRegByCnae(String cnae) {
		try {
			return (CclVO) sqlMap.queryForObject(getNameSpaceMap() + ".getRegByCnae", cnae);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	} 
	
	public String getNomeByCNAE(CclVO ccl) {
		try {
			return (String) sqlMap.queryForObject(getNameSpaceMap() + ".getNomeByCNAE", ccl);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	} 
	
	public Integer updRiscosByCod(CclVO ccl) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updRiscosByCod", ccl);
	}
 } 
 