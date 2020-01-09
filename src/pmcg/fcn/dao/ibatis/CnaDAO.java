package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.CnaVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;
   /** 
    * CnaDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class CnaDAO extends DAOConcorrencia<CnaVO, Long> { 
 	public CnaDAO() { 
 		super("Cna","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<CnaVO> getRegByCriterioComplex(CnaVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cna"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public CnaVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cna"); 
 		try { 
 			return (CnaVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cna"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(CnaVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cna");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<CnaVO> 	getByCriterioLimit(CnaVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cna");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<CnaVO> getRegByProtocoloVia(String protocoloVia) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByProtocoloVia",protocoloVia);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<CnaVO> getRegByProcessoMatriz(String processo) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByProcessoMatriz", processo);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<HashMap<String, Object>> getRegByMatriz(Long matcna) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByMatriz", matcna);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<HashMap<String, Object>> getRegByFilial(Long filcna) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByFilial", filcna);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getRegByProvia(String provia) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByProvia", provia);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
 } 
 