package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.imti.domain.TipVO; 
 import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * TipDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class TipDAO extends DAOConcorrencia<TipVO, String> { 
 	public TipDAO() { 
 		super("Tip","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigSIATCGR.xml"); 
 	} 
 	  
 	public List<TipVO> getRegByCriterioComplex(TipVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Tip"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public TipVO getRegByCodComplex(String cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Tip"); 
 		try { 
 			return (TipVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Tip"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(TipVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Tip");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<TipVO> 	getByCriterioLimit(TipVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Tip");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<TipVO> getRegByTipo(String tipo) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getRegByTipo", tipo);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public TipVO getTiplogByDesc(String descom) {  
  		try {  
  			return (TipVO) sqlMap.queryForObject(getNameSpaceMap() + ".getTiplogByDesc", descom);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
  	
  	public TipVO getTipbaiByDesc(String descom) {  
  		try {  
  			return (TipVO) sqlMap.queryForObject(getNameSpaceMap() + ".getTipbaiByDesc", descom);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
 } 
 