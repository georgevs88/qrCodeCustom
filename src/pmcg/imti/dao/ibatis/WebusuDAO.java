package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.WebusuVO;

public class WebusuDAO extends DAOConcorrencia<WebusuVO, Integer>{

	public WebusuDAO() {
		super("webusu", "pmcg/imti/dao/ibatis/sqlmap/SqlDbAcessosConfig.xml");
	}

	public List<WebusuVO> buscaRegByCriterio(WebusuVO webusuVO, Integer inicio, Integer maxporpag ){
		
		try {
			List<WebusuVO> l= sqlMap.queryForList(getNameSpaceMap()+".buscaRegByCriterio", webusuVO, inicio, maxporpag);
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;		
	}	

	public Integer countRegByCriterio(WebusuVO webusuVO) {
		
		try {
			return (Integer) sqlMap.queryForObject(getNameSpaceMap()+".countRegByCriterio",webusuVO);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public WebusuVO buscarLogin(String login){
		try {
			return (WebusuVO) sqlMap.queryForObject(getNameSpaceMap()+".buscarLogin", login);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	
	public WebusuVO getUsuByLoginSenha(WebusuVO usu){
		try {
			return (WebusuVO) sqlMap.queryForObject(getNameSpaceMap()+".getUsuByLoginSenha", usu);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean verificaAcessoUPS(HashMap<String, Object> ups){
		try {
			return (Boolean) sqlMap.queryForObject(getNameSpaceMap()+".verificaAcessoUPS", ups);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<WebusuVO> getUserSis(WebusuVO webusuVO, Integer inicio, Integer maxporpag ) throws SQLException{
		return	sqlMap.queryForList("webusu.getUserSis", webusuVO, inicio, maxporpag);
	}
	
	public Integer countUserSis(WebusuVO webusuVO) throws SQLException {
		return (Integer) sqlMap.queryForObject("webusu.countUserSis", webusuVO);
	}
}
