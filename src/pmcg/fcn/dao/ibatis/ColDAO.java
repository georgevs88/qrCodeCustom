package pmcg.fcn.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import pmcg.fcn.domain.ColVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;

/**
 * ColDAO Responsável pela Manipulação de registros
 * 
 * @author Gerador ZK
 */
public class ColDAO extends DAOConcorrencia<ColVO, Long> {
	public ColDAO() {
		super("Col","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml");
	}

	public List<ColVO> getRegByCriterioComplex(ColVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Col");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ColVO getRegByCodComplex(Long cod) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Col");
		try {
			return (ColVO) sqlMap.queryForObject(nameSpace + ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer delByCodigos(String codigos) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Col");
		try {
			return sqlMap.delete(nameSpace + ".delByCodigos", codigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(ColVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Col");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<ColVO> getByCriterioLimit(ColVO obj, Integer inicial, Integer maximoPermitido) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Col");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ColVO getRegByPro(String protocolo) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Col");
		try {
			return (ColVO) sqlMap.queryForObject(nameSpace + ".getRegByPro", protocolo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
