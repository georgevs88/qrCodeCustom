package pmcg.imti.dao.ibatis;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.ImoVO;

import java.util.HashMap;
import java.util.List;
import java.sql.SQLException;

public class ImoDAO extends DAOConcorrencia<ImoVO, Integer> {
	public ImoDAO() {
		super("Imo", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigTIQU.xml");
	}

	@SuppressWarnings("unchecked")
	public List<ImoVO> getRegByCriterioComplex(ImoVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Imo");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ImoVO getRegByCodComplex(Integer cod) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Imo");
		try {
			return (ImoVO) sqlMap.queryForObject(nameSpace
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer delByCodigos(String codigos) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Imo");
		try {
			return sqlMap.delete(nameSpace + ".delByCodigos", codigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(ImoVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Imo");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace
					+ ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<ImoVO> getByCriterioLimit(ImoVO obj, Integer inicial,Integer maximoPermitido) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Imo");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getDadosByInscricao(String inscricao) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getDadosByInscricao", inscricao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getInscricao(HashMap<String, Object> m, Integer inicial,Integer maximoPermitido) {
		List<HashMap<String, Object>> lis = null;
		try {
			lis = sqlMap.queryForList(this.getNameSpaceMap() + ".getInscricao", m, inicial, maximoPermitido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	public Integer countInscricao(HashMap<String, Object> m) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countInscricao", m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public String getTipoImovel(String inscricao) {
		try {  
  			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getTipoImovel", inscricao);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null; 
	}
	
	public Double getAreaUtilizadaByInscricao(String inscricao) {
		try {  
  			return (Double) sqlMap.queryForObject(this.getNameSpaceMap() + ".getAreaUtilizadaByInscricao", inscricao);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return 0.0; 
	}
	
	public String getRegiaoImovel(String inscricao) {
		try {  
  			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getRegiaoImovel", inscricao);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null; 
	}
}
