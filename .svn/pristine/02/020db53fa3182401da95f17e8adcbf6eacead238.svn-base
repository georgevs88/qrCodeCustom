package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import pmcg.fcn.domain.EndVO;
import pmcg.framework.dao.ibatis.DAOGenerico;

@SuppressWarnings("unchecked")
public class EndDAO extends DAOGenerico<EndVO, Long> {

	public EndDAO() {
		super("End","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBSAU.xml");
	}

	public EndVO getRegByCEP(EndVO cep) {
		try {
			return (EndVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getRegByCriterio", cep);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(EndVO obj) { 
		String nameSpace = getNameSpaceMap(); 
		if (nameSpace == null) 
			setNameSpaceMap("End"); 
		try { 
			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return 0; 
	} 

	public List<EndVO> getByCriterioLimit(EndVO obj,Integer inicial, Integer maximoPermitido) { 
		String nameSpace = getNameSpaceMap(); 
		if (nameSpace == null) 
			setNameSpaceMap("End"); 
		try { 
			return sqlMap.queryForList(nameSpace + ".getRegByCriterio",obj,inicial,maximoPermitido); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return null; 
	} 

	public EndVO getRegByCriterio2(EndVO obj) { 
		String nameSpace = getNameSpaceMap(); 
		if (nameSpace == null) 
			setNameSpaceMap("End"); 
		try { 
			return (EndVO) sqlMap.queryForObject(nameSpace + ".getRegByCriterio", obj); 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return null; 
	} 
}