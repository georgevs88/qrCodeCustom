package pmcg.imti.dao.ibatis;


import java.sql.SQLException;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOGenerico;
import pmcg.imti.domain.CepVO;

public class CepDAO extends DAOGenerico<CepVO, String> {
	String nameSpace="Cep";

	public CepDAO() {
		super("Cep", "pmcg/imti/dao/ibatis/sqlmap/SqlDbAcessosConfig.xml");
	}

	public CepVO getRegbyCep(String ceppro) {
		try {
			return (CepVO) sqlMap.queryForObject(nameSpace+".getRegByCep", ceppro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(CepVO cepVO) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", cepVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<CepVO> getRegByCriterio(CepVO cepVO, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", cepVO, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public CepVO getRegByCepVes(String cep) { 
 		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("CepMAP"); 
 		try { 
 			return (CepVO) sqlMap.queryForObject(nameSpace + ".getRegByCepVes", 
 					cep); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
 		return null; 
 	}
	
	public CepVO getRegByCEPLoc(String cep) {
		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("CepMAP"); 
 		try { 
 			return (CepVO) sqlMap.queryForObject(nameSpace + ".getRegByCEPLoc", 
 					cep); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
		return null;
	}
}
