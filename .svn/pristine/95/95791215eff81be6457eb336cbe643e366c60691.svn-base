package pmcg.imti.dao.ibatis; 
  
 import pmcg.framework.dao.ibatis.DAOConcorrencia; 
 import pmcg.imti.domain.UsuVO; 
 import java.util.List; 
 import java.sql.SQLException; 
   /** 
    * UsuDAO  
    * Responsável pela Manipulação de registros 
    * @author Gerador ZK 
    */ 
 public class UsuDAO extends DAOConcorrencia<UsuVO, Long> { 
 	public UsuDAO() { 
 		super("Usu"); 
 	} 
 	  
 	public List<UsuVO> getRegByCriterioComplex(UsuVO obj) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Usu"); 
 		try { 
 			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", 
 					obj); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
   
 	public UsuVO getRegByCodComplex(Long cod) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Usu"); 
 		try { 
 			return (UsuVO) sqlMap.queryForObject(nameSpace 
 					+ ".getRegByCodComplex", cod); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
  	  
 	public Integer delByCodigos(String codigos) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Usu"); 
 		try { 
 			return sqlMap.delete(nameSpace + ".delByCodigos", codigos); 
 		} catch (Exception e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	} 
 	  
 	public Integer 	getCountByCriterio(UsuVO  obj) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Usu");  
  		try {  
  			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);  
  		} catch (Exception e) {  
  			e.printStackTrace();  
  		}  
  		return 0;  
  	}  
  	  
  	public List<UsuVO> 	getByCriterioLimit(UsuVO obj,Integer inicial, Integer maximoPermitido) {  
  		String nameSpace = getNameSpaceMap();  
  		if (nameSpace == null)  
  			setNameSpaceMap("Usu");  
  		try {  
  			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj,inicial,maximoPermitido);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	} 
  	
  	public UsuVO getUsuByLog(String logusu) {  
  		try {  
  			return (UsuVO) sqlMap.queryForObject(getNameSpaceMap() + ".getUsuByLog",logusu);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
  	}

	public Integer getDuplicidade(UsuVO usuVO){
		Integer validador;
		try {
			validador = (Integer) sqlMap.queryForObject("Usu.getDuplicidade",usuVO);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		if(validador == null)
			return 0;
		else if(validador == 0)
			return 0;
		else
			return validador;
	}
 } 
 