package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.List;

import pmcg.fcn.domain.ZimVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia; 
   /** 
    * ZimDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class ZimDAO extends DAOConcorrencia<ZimVO, Long> { 
 	public ZimDAO() { 
 		super("Zim","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<ZimVO> getRegByCriterioComplex(ZimVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Zim"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public ZimVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Zim"); 
 		try { 
 			return (ZimVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Zim"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(ZimVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Zim");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<ZimVO> 	getByCriterioLimit(ZimVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Zim");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	@SuppressWarnings("unchecked")
	public List<ZimVO> getRegByInsc(String inscricao) { 
 		try { 
 			return sqlMap.queryForList(this.getNameSpaceMap() + ".getRegByInsc", inscricao); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}

	public Integer delZona(ZimVO zim) {
		try {
			return (Integer) sqlMap.delete(this.getNameSpaceMap() + ".delZona", zim);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
 } 
 