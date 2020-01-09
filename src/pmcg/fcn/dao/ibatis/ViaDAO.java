package pmcg.fcn.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.domain.ViaVO;
import pmcg.framework.dao.ibatis.DAOConcorrencia;

/**
 * ViaDAO Responsável pela Manipulação de registros
 * 
 * @author Gerador ZK
 */
public class ViaDAO extends DAOConcorrencia<ViaVO, Long> {
	public ViaDAO() {
		super("Via","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfig.xml");
	}

	public List<ViaVO> getRegByCriterioComplex(ViaVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Via");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ViaVO getRegByCodComplex(Long cod) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Via");
		try {
			return (ViaVO) sqlMap.queryForObject(nameSpace + ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer delByCodigos(String codigos) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Via");
		try {
			return sqlMap.delete(nameSpace + ".delByCodigos", codigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(ViaVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Via");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace + ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<ViaVO> getByCriterioLimit(ViaVO obj, Integer inicial, Integer maximoPermitido) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Via");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex", obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getInscricaoByProtocolo(String protocolo) {
		try {
			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getInscricaoByProtocolo", protocolo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getTipoUnidadeByProtocolo(String protocolo) {
		try {
			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getTipoUnidadeByProtocolo", protocolo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getRiscoByProtocolo(String protocolo) {
		try {
			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getRiscoByProtocolo", protocolo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer countViaByProtocolo(String protocolo) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countViaByProtocolo", protocolo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<ViaVO> getViaByAnaliseEnderecoPendente() {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getViaByAnaliseEnderecoPendente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer updConfRecebimentoByProtocolo(String provia) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updConfRecebimentoByProtocolo", provia);
	}

	public Integer updAnaliseEnderecoByIdd(ViaVO viab) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updAnaliseEnderecoByIdd", viab);
	}
	
	public Integer updBaeByIdd(ViaVO viab) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updBaeByIdd", viab);
	}
	
	public List<HashMap<String, Object>> getViaGravadas() {
		List<HashMap<String, Object>> lis = null;
		try {
			lis = sqlMap.queryForList(this.getNameSpaceMap() + ".getViaGravadas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	public List<HashMap<String, Object>> getViaGravadasLimit(HashMap<String, Object> param, Integer inicial, Integer maximoPermitido) {
		List<HashMap<String, Object>> lis = null;
		try {
			lis = sqlMap.queryForList(this.getNameSpaceMap() + ".getViaGravadas", param, inicial, maximoPermitido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	
	public Integer countViaGravadas(HashMap<String, Object> param) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countViaGravadas", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public HashMap<String, Object> getDadosAnalise(String protocolo) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getDadosAnalise",
					protocolo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<HashMap<String, Object>> getProtocolosAnalise(HashMap<String, Object> param) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(
					this.getNameSpaceMap() + ".getProtocolosAnalise", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public List<HashMap<String, Object>> getProtocolosAnaliseLimit(HashMap<String, Object> param, Integer inicial, Integer maximoPermitido) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList( this.getNameSpaceMap() + ".getProtocolosAnalise", param, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public Integer countProtocolosAnalise(HashMap<String, Object> param) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countProtocolosAnalise", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public String getProtocoloViabilidade() {
		try {
			return (String) sqlMap.queryForObject(this.getNameSpaceMap() + ".getProtocoloViabilidade");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getProgressoViabilidade(String provia){
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".getProgressoViabilidade", provia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getProtocolos(HashMap<String, Object> param) throws InterruptedException {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getProtocolos", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getProtocolosLimit(HashMap<String, Object> param, Integer inicial, Integer maximoPermitido) {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getProtocolos", param, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer countProtocolos(HashMap<String, Object> param) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countProtocolos", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getEventos(Long iddvia) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(this.getNameSpaceMap() + ".getEventos", iddvia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> getSocios(Long iddvia) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(this.getNameSpaceMap() + ".getSocios", iddvia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getDadosByProtocolo(String provia) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getDadosByProtocolo", provia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HashMap<String, Object>> getFormaAtuacao(String provia) {
		try {
			return (List<HashMap<String, Object>>) sqlMap.queryForList(this.getNameSpaceMap() + ".getFormaAtuacao", provia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ViaVO> getViaByConfRecPendente() {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getViaByConfRecPendente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ViaVO> getRegByCpfReq(String cpfReq) {
		try {
			return sqlMap.queryForList(this.getNameSpaceMap() + ".getRegByCpfReq", cpfReq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ViaVO getRegByProvia(String provia) {
		try {
			return (ViaVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getRegByProvia", provia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, Object> getRegEnvDoc(HashMap<String, Object> via) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getRegEnvDoc", via);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer countProprietario(String nomeProp) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countProprietario", nomeProp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, Object> getEstatisticas() {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(this.getNameSpaceMap() + ".getEstatisticas");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
