package pmcg.fcn.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.fcn.domain.CadVO; 
 import java.util.List; 
 import java.sql.SQLException; 
 
 public class CadDAO extends DAOConcorrencia<CadVO, Long> { 
 	public CadDAO() { 
 		super("Cad","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml"); 
 	} 
 	  
 	public List<CadVO> getRegByCriterioComplex(CadVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cad"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public CadVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cad"); 
 		try { 
 			return (CadVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Cad"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(CadVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cad");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<CadVO> 	getByCriterioLimit(CadVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Cad");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public CadVO getCadByCPF(String cpf) {
		try {
			return (CadVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getCadByCPF", cpf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  	
  	public CadVO getCadByLoginSenha(CadVO cad) {
		try {
			return (CadVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getCadByLoginSenha", cad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  	
  	public Integer updSenha(CadVO cad) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updSenha", cad);
	}
  	
  	public CadVO getCadByCpfEmaDna(CadVO cad) {
		try {
			return (CadVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getCadByCpfEmaDna", cad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 } 
 