package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.VesVO;

public class VesDAO extends DAOConcorrencia<VesVO, Integer> {

	public VesDAO() {
		super("Ves","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}

	public Integer countRegByCriterio(VesVO vesVO) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".countRegByCriterio", vesVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	@SuppressWarnings("unchecked")
	public List<VesVO> getRegByCriterio(VesVO vesVO, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", vesVO, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getCountByCriterio(VesVO obj) {
		try {
			return (Integer) sqlMap.queryForObject(getNameSpaceMap()
					+ ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<VesVO> getByCriterioLimit(VesVO obj, Integer inicial,
			Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getRegByCriterioL", obj,
					inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<VesVO> getRegByCriterio(VesVO vesVO) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap()
					+ ".getRegByCriterio", vesVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByDesc(VesVO desc) {

		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByDesc", desc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCPF(VesVO vo) {

		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByCPF", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCNPJ(VesVO vo) {

		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getCountByCNPJ", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<VesVO> getRegByCriterioPesquisa(VesVO vesVO) {
		return this.getRegByCriterio(vesVO);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<VesVO> getEstabbyRT(HashMap map) {
		try {
			return sqlMap.queryForList(
					this.getNameSpaceMap() + ".getEstabbyRT", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getBuscaUltimaLetra() {

		try {
			return (String) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getBuscaUltimaLetra");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public VesVO getRegByLoginSenha(HashMap map){
		try {
			return (VesVO) sqlMap.queryForObject(getNameSpaceMap()+".getRegByLoginSenha", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("rawtypes")
	public Integer updateSenves(HashMap map){
		try {
			return sqlMap.update(getNameSpaceMap()+".updateSenves",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public VesVO getRegByLogin(String login){
		try {
			return (VesVO) sqlMap.queryForObject(getNameSpaceMap()+".getRegByLogin",login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer countRegByLogin(String login){
		try {
			return (Integer) sqlMap.queryForObject(getNameSpaceMap()+".countRegByLogin",login);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Integer countRegByLoginSenha(HashMap map){
		try {
			return (Integer) sqlMap.queryForObject(getNameSpaceMap()+".countRegByLoginSenha",map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<VesVO> getRegByCriterioVex(VesVO tpr, Integer inicial,
			Integer maximoPermitido) {
		// TODO Auto-generated method stub
		try {
			return (List<VesVO>) sqlMap.queryForList(getNameSpaceMap()+".getRegByCriterioVex", tpr, inicial, maximoPermitido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
