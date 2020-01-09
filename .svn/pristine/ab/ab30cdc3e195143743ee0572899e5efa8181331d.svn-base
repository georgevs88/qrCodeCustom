package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.VeaVO;

public class VeaDAO extends DAOConcorrencia<VeaVO, Integer>{

	public VeaDAO() {
		super("Sosvea","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}
	
	public VeaVO getRegByCodComplex(Integer cod) {
		try {
			return (VeaVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer countRegByCriterio(VeaVO vo) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<VeaVO> getRegByCriterioComplex(VeaVO vo, Integer inicial,
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
	public List<VeaVO> getRegByCriterioComplex(VeaVO vo) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<VeaVO> getRegByCriterio(VeaVO vo) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<VeaVO> getByCriteriaLimit(VeaVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return (List<VeaVO>) sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", vo, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<VeaVO> getByCriteriaComplexLimit(VeaVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return (List<VeaVO>) sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
