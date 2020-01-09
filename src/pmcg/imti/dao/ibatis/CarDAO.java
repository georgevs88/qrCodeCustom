package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.CarVO;

public class CarDAO extends DAOConcorrencia<CarVO, Integer>{

	public CarDAO() {
		super("Soscar","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}
	
	
	public Integer countRegByCriterio(CarVO vo) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<CarVO> getRegByCriterio(CarVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", vo, inicial,
					maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<CarVO> getByCriteriaLimit(CarVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return (List<CarVO>) sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Integer getCountByNome(CarVO nome) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByNome", nome);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public List<CarVO> getRegByCriterioPesquisa(CarVO carVO) {
		try {
			return this.getRegByCriterio(carVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
