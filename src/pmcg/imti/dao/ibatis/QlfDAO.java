package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.imti.domain.QlfVO;

import java.util.HashMap;
import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * QlfDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class QlfDAO extends DAOConcorrencia<QlfVO, Long> { 
 	public QlfDAO() { 
 		super("Qlf","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigSIATCGR.xml"); 
 	} 
 	  
 	public List<QlfVO> getRegByCriterioComplex(QlfVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Qlf"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public QlfVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Qlf"); 
 		try { 
 			return (QlfVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Qlf"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(QlfVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Qlf");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<QlfVO> 	getByCriterioLimit(QlfVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Qlf");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	@SuppressWarnings("unchecked")
	public List<QlfVO> getQlfByNjr(Long codnjr) { 
 		try { 
 			return sqlMap.queryForList(getNameSpaceMap() + ".getQlfByNjr", codnjr); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
  	
  	public List<QlfVO> getQlfRepresentanteByRepresentado(Long qlfreptad) { 
 		try { 
 			return sqlMap.queryForList(getNameSpaceMap() + ".getQlfRepresentanteByRepresentado", qlfreptad); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
 } 
 