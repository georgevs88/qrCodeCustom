package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOGenerico;
import pmcg.imti.domain.LogradouroVO;

public class LogradouroDAO extends DAOGenerico<LogradouroVO, Long> {

	public LogradouroDAO() {
		super("Logradouro", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml");
	}

	public LogradouroVO getCepByChave(LogradouroVO pkey) {
		try {
			return (LogradouroVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCepByChave", pkey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public LogradouroVO getRegByCEP(String cep) {
		try {
			return (LogradouroVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getRegByCep", cep);
		} catch (SQLException e) {
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Integer getCountByRua(HashMap map) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByRua", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<LogradouroVO> getRegByRua(HashMap map, Integer inicial,
			Integer maximoPermitido) {
		try {
			return (List<LogradouroVO>) sqlMap.queryForList(
					this.getNameSpaceMap() + ".getRegByRua", map, inicial,
					maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LogradouroVO getRegByCEPdeCampoGrande(String cep) {
		try {
			return (LogradouroVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getRegByCEPdeCampoGrande", cep);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LogradouroVO getBuscaCep(String cep) {
		try {
			return (LogradouroVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getRegByCep", cep);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LogradouroVO getRegByCEPLoc(String cep) {
		String nameSpace = getNameSpaceMap(); 
 		if (nameSpace == null) 
 			setNameSpaceMap("Logradouro"); 
 		try { 
 			return (LogradouroVO) sqlMap.queryForObject(nameSpace + ".getRegByCEPLoc", 
 					cep); 
 		} catch (SQLException e) { 
 			e.printStackTrace(); 
 		} 
		return null;
	}

}