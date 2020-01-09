package pmcg.imti.dao.ibatis;

import java.sql.SQLException;

import pmcg.imti.domain.ArqanxVO;
import pmcg.framework.dao.ibatis.DAOGenerico;

public class ArqanxDAO extends DAOGenerico<ArqanxVO, Long> {

	public ArqanxDAO() {
		super("Arqanx", "pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigDBIMGFCN.xml");
	}

	public ArqanxVO getRegByCodComplex(Long seqarq) {
		try {
			return (ArqanxVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getRegByCodComplex", seqarq);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArqanxVO getAssinatura(Integer idassinausu){
		try {
			return (ArqanxVO) sqlMap.queryForObject(this.getNameSpaceMap()
					+ ".getAssinatura", idassinausu);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
