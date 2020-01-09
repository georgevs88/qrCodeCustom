package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.List;

import pmcg.fcn.domain.SocVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;
   /** 
    * SocDAO  
    * Respons�vel pela Manipula��o de registros 
    * @author Gerador ZK 
    */ 
 public class SocDAO extends DAOConcorrencia<SocVO, Long> { 
 	public SocDAO() { 
 		super("Soc","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<SocVO> getRegByCriterioComplex(SocVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Soc"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public SocVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Soc"); 
 		try { 
 			return (SocVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Soc"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(SocVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Soc");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<SocVO> 	getByCriterioLimit(SocVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Soc");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
 } 
 