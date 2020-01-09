package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.MatVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;
   /** 
    * MatDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class MatDAO extends DAOConcorrencia<MatVO, Long> { 
 	public MatDAO() { 
 		super("Mat","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<MatVO> getRegByCriterioComplex(MatVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Mat"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public MatVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Mat"); 
 		try { 
 			return (MatVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Mat"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(MatVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Mat");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<MatVO> 	getByCriterioLimit(MatVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Mat");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}

	public MatVO getRegByProcesso(Long iddpro) {
		try {  
  			return (MatVO) sqlMap.queryForObject(getNameSpaceMap() + ".getRegByProcesso",iddpro);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		} 
		return null;
	} 
	
	public HashMap<String, Object> getMatrizByProcesso(Long promat) {
		try {  
  			return (HashMap<String, Object>) sqlMap.queryForObject(getNameSpaceMap() + ".getMatrizByProcesso", promat);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		} 
		return null;
	}
 } 
 