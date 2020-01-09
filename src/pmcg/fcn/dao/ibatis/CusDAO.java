package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.List;

import pmcg.fcn.domain.CusVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia; 
   /** 
    * CusDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class CusDAO extends DAOConcorrencia<CusVO, Integer> { 
 	public CusDAO() { 
 		super("Cus","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<CusVO> getRegByCriterioComplex(CusVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cus"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public CusVO getRegByCodComplex(Integer cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cus"); 
 		try { 
 			return (CusVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cus"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(CusVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cus");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<CusVO> 	getByCriterioLimit(CusVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cus");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public CusVO getRegByCnae(String cnae) { 
 		try { 
 			return (CusVO) sqlMap.queryForObject(getNameSpaceMap() + ".getRegByCnae", cnae); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
  	
  	public Integer updUsosByCod(CusVO cusp) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updUsosByCod", cusp);
	}
 } 
 