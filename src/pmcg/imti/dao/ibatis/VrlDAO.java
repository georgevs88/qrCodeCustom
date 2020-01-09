package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.VrlVO;

public class VrlDAO extends DAOConcorrencia<VrlVO, Integer> {

	public VrlDAO() {
		super("Sosvrl", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}

	public VrlVO getRegByCodComplex(Integer cod) {
		try {
			return (VrlVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer countRegByCriterio(VrlVO vo) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<VrlVO> getRegByCriterioComplex(VrlVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<VrlVO> getRegByCriterioPesquisa(VrlVO vrlVO) {
		try {
			return this.getRegByCriterio(vrlVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer countCPF(VrlVO vo) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countCPF", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public VrlVO getRegByCpf(String cpf) {
		try {
			return (VrlVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getRegByCpf", cpf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
