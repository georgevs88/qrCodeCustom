package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.imti.domain.CidVO; 
 import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * CidDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class CidDAO extends DAOConcorrencia<CidVO, Long> { 
 	public CidDAO() { 
 		super("Cid","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigSIATCGR.xml"); 
 	} 
 	  
 	public List<CidVO> getRegByCriterioComplex(CidVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cid"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public CidVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cid"); 
 		try { 
 			return (CidVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cid"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(CidVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cid");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<CidVO> 	getByCriterioLimit(CidVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cid");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	@SuppressWarnings("unchecked")
	public List<CidVO> getCidByEst(Long codest) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getCidByEst", codest);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
  	
  	@SuppressWarnings("unchecked")
	public List<CidVO> getCidByEstado(String uf) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cid");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getCidByEstado",uf);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public CidVO getRegByCodSiafi(Integer codsiafi) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cid");  
  		try {  
  			return (CidVO) sqlMap.queryForObject(nameSpace + ".getRegByCodSiafi",codsiafi);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public CidVO getRegByNomUf(CidVO obj) {  
  		try {  
  			return (CidVO) sqlMap.queryForObject(getNameSpaceMap() + ".getRegByNomUf",obj);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
 } 
 