package pmcg.fcn.dao.ibatis;

import java.sql.SQLException;
import java.util.List;
import pmcg.fcn.domain.SerVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;

public class SerDAO extends DAOConcorrencia<SerVO, Integer> {
	public SerDAO() {
		super("Ser","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}

	@SuppressWarnings("unchecked")
	public List<SerVO> getRegByCriterioComplex(SerVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Ser");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",
					obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public SerVO getRegByCodComplex(Integer cod) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Ser");
		try {
			return (SerVO) sqlMap.queryForObject(nameSpace
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer delByCodigos(String codigos) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Ser");
		try {
			return sqlMap.delete(nameSpace + ".delByCodigos", codigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(SerVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Ser");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace
					+ ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<SerVO> getByCriterioLimit(SerVO obj, Integer inicial,
			Integer maximoPermitido) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Ser");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",
					obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getCountByNome(SerVO nome) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByNome", nome);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}		
	public List<SerVO> getRegByCriterioPesquisa(SerVO serVO) {
		try {
			return this.getRegByCriterio(serVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
