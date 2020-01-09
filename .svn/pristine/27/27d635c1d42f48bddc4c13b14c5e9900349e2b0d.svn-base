package pmcg.fcn.dao.ibatis;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.fcn.domain.CsoVO;
import java.util.List;
import java.sql.SQLException;

/**
 * CsoDAO Responsável pela Manipulação de registros
 * 
 * @author Gerador ZK
 */
public class CsoDAO extends DAOConcorrencia<CsoVO, Long> {
	public CsoDAO() {
		super("Cso","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml");
	}

	public List<CsoVO> getRegByCriterioComplex(CsoVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Cso");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CsoVO getRegByCodComplex(Long cod) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Cso");
		try {
			return (CsoVO) sqlMap.queryForObject(nameSpace + ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer delByCodigos(String codigos) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Cso");
		try {
			return sqlMap.delete(nameSpace + ".delByCodigos", codigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(CsoVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Cso");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<CsoVO> getByCriterioLimit(CsoVO obj, Integer inicial, Integer maximoPermitido) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Cso");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CsoVO> getByCol(Long col) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Cso");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCol", col);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
