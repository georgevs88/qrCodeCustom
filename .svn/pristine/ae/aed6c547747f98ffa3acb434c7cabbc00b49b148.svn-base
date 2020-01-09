package pmcg.fcn.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.VatVO;

public class VatDAO extends DAOConcorrencia<VatVO, Integer>{

	public VatDAO(){
		super("Vat","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}
	
	public Integer countRegByCriterio(VatVO vatVO) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", vatVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<VatVO> getRegByCriterio(VatVO vat, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", vat, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<VatVO> getRegByCriterioComplex(VatVO vat, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterioComplex", vat, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getCountByNome(VatVO nome) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByNome", nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<VatVO> getRegByCriterioPesquisa(VatVO vatVO) {
		try {
			return this.getRegByCriterio(vatVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public VatVO getRegByCnae(String cnae){
		try {
			return (VatVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getRegByCnae", cnae);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
