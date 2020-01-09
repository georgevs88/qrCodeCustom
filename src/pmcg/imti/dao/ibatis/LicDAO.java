package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOGenerico;
import pmcg.imti.domain.LicVO;

public class LicDAO extends DAOGenerico<LicVO, Integer> {

	public LicDAO() {
		super("Soslic", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}

	public LicVO getRegByCodComplex(Integer cod) {
		try {
			return (LicVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer countRegByCriterio(LicVO vo) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<LicVO> getRegByCriterioComplex(LicVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vo, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<LicVO> getByCriteriaLimit(LicVO vo, Integer inicial,
			Integer maximoPermitido) {
		try {
			return (List<LicVO>) sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", vo, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getVerificaDuplicidade(LicVO obj) {
		try {
			return (Integer) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getVerificaDuplicidade", obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getVerificaDuplicidadeEst(LicVO obj) {
		try {
			return (Integer) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getVerificaDuplicidadeEst", obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LicVO getLicencaSanitariaAtual(LicVO vo) {
		try {
			return (LicVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getLicencaSanitariaAtual", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getAnoAtual() {
		try {
			return (Integer) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getAnoAtual");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Integer getCountByCriterioLis(HashMap map) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByCriterioLis", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<LicVO> getRegByCriterioLis(HashMap map, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioLis", map, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Date getRegByEst(Integer cod) {
		try {
			return (Date) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getRegByEst", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LicVO getLicencaSanitariaAtualSemDatvallic(LicVO vo) {
		try {
			return (LicVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getLicencaSanitariaAtualSemDatvallic", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LicVO getBuscaVeiculo(Integer cod) {
		try {
			return (LicVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getBuscaVeiculo", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LicVO getBuscaLincenca(Integer cod) {
		try {
			return (LicVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getBuscaLincenca", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public LicVO getLincencaGeral(Integer cod) {
		try {
			return (LicVO) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getLincencaGeral", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getTemLincencaAtiva(Integer lic) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getTemLincencaAtiva", lic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public LicVO getBuscarPorVes(Integer codves) {
		try {
			return (LicVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getBuscarPorVes", codves);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro no m�todo getBuscarPorVes");
			e.printStackTrace();
		}
		return null;
	}

}
