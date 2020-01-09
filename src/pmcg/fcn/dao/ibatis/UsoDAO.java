package pmcg.fcn.dao.ibatis; 
  
 import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.UsoVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia; 
   /** 
    * UsoDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class UsoDAO extends DAOConcorrencia<UsoVO, Long> { 
 	public UsoDAO() { 
 		super("Uso","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<UsoVO> getRegByCriterioComplex(UsoVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Uso"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public UsoVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Uso"); 
 		try { 
 			return (UsoVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Uso"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(UsoVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Uso");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<UsoVO> 	getByCriterioLimit(UsoVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Uso");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	@SuppressWarnings("unchecked")
	public List<UsoVO> getUsosByZonas(String zonas) {
		try {  
  			return sqlMap.queryForList(this.getNameSpaceMap() + ".getUsosByZonas",zonas);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
	} 
	
	public String getUsosByAtv(String cnae) {
		try {  
  			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getUsosByAtv",cnae);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
	} 
	
	@SuppressWarnings("unchecked")
	public List<UsoVO> getUsosIn(String usos) {
		try {  
  			return (List<UsoVO>) sqlMap.queryForList(this.getNameSpaceMap() + ".getUsosIn", usos);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
	} 
	
	public UsoVO getUsoByAtvPorte(HashMap<String, Object> m) {
		try {
			return (UsoVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getUsoByAtvPorte", m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, Object> getZonasUsosByInscricao(String inscricao) {
		try {  
  			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getZonasUsosByInscricao", inscricao);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null; 
	}
 } 
 