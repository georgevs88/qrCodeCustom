package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.EpdVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia; 
   /** 
    * BaeDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class BaeDAO extends DAOConcorrencia<BaeVO, Long> { 
 	public BaeDAO() { 
 		super("Bae","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<BaeVO> getRegByCriterioComplex(BaeVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Bae"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public BaeVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Bae"); 
 		try { 
 			return (BaeVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Bae"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(BaeVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Bae");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<BaeVO> 	getByCriterioLimit(BaeVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Bae");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public List<HashMap<String, Object>> getBaeLimit(HashMap<String, Object> param, Integer inicial, Integer maximoPermitido) {
		List<HashMap<String, Object>> lis = null;
		try {
			lis = sqlMap.queryForList(this.getNameSpaceMap() + ".getBaeLimit", param, inicial,maximoPermitido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	public Integer countBae(HashMap<String, Object> param) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countBae", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer updCaiBae(BaeVO caibae) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updCaiBae", caibae);
	}
	
	public BaeVO getBaeByViabae(String viabae) {  
  		try {  
  			return (BaeVO) sqlMap.queryForObject(getNameSpaceMap() + ".getBaeByViabae", viabae);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
	
	public List<BaeVO> getBaePendente(HashMap<String,Object> map) {  
  		try {  
  			return sqlMap.queryForList(getNameSpaceMap() + ".getBaePendente", map);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}
	
	public Integer countBaePendente(HashMap<String, Object> param) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countBaePendente", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Integer updMensagemSIAT(BaeVO bae) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updMensagemSIAT", bae);
	}
	
	public HashMap<String, Object> getDadosInsmun(Long iddbae) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getDadosInsmun", iddbae);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 } 
 