package pmcg.imti.dao.ibatis;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.QfcVO;

import java.util.List;
import java.sql.SQLException;

/**
 * QfcDAO Respons�vel pela Manipula��o de registros
 * 
 * @author Gerador ZK
 */
public class QfcDAO extends DAOConcorrencia<QfcVO, Long> {
	public QfcDAO() {
		super("Qfc");
	}

	public List<QfcVO> getRegByCriterioComplex(QfcVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Qfc");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",
					obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public QfcVO getRegByCodComplex(Long cod) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Qfc");
		try {
			return (QfcVO) sqlMap.queryForObject(nameSpace
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer delByCodigos(String codigos) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Qfc");
		try {
			return sqlMap.delete(nameSpace + ".delByCodigos", codigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(QfcVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Qfc");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace
					+ ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<QfcVO> getByCriterioLimit(QfcVO obj, Integer inicial,
			Integer maximoPermitido) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Qfc");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",
					obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCargoByQualificacao(Integer qlfqfc) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Qfc");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace
					+ ".getCargoByQualificacao", qlfqfc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
