package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.VreVO;

public class VreDAO extends DAOConcorrencia<VreVO, Integer>{

	public VreDAO() {
		super("Sosvre","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}
	
	public VreVO getRegByCodComplex(Integer cod) {
		try {
			return (VreVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer countRegByCriterio(VreVO vo) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<VreVO> getRegByCriterioComplex(VreVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo, inicial,
					maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<VreVO> getRegByCriterioComplex(VreVO vo) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<VreVO> getByCriteriaComplexLimit(VreVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return (List<VreVO>) sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
