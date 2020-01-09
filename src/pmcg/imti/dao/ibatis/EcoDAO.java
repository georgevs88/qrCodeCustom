package pmcg.imti.dao.ibatis;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pmcg.framework.dao.ibatis.DAOConcorrencia;
import pmcg.imti.domain.EcoVO;

public class EcoDAO extends DAOConcorrencia<EcoVO, Integer> {
	public EcoDAO() {
		super("Eco","pmcg/imti/dao/ibatis/sqlmap/SqlMapConfigSIATCGR.xml");
	}

	@SuppressWarnings("unchecked")
	public List<EcoVO> getRegByCriterioComplex(EcoVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",
					obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EcoVO getRegByCodComplex(Integer cod) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return (EcoVO) sqlMap.queryForObject(nameSpace
					+ ".getRegByCodComplex", cod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer delByCodigos(String codigos) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return sqlMap.delete(nameSpace + ".delByCodigos", codigos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getCountByCriterio(EcoVO obj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace
					+ ".getCountByCriterio", obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<EcoVO> getByCriterioLimit(EcoVO obj, Integer inicial,
			Integer maximoPermitido) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return sqlMap.queryForList(nameSpace + ".getRegByCriterioComplex",
					obj, inicial, maximoPermitido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> getImByCpfcnpj(String cpfcnpj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return sqlMap.queryForList(nameSpace + ".getImByCpfcnpj",cpfcnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer countImAtivaByCpfcnpj(String cpfcnpj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace + ".countImAtivaByCpfcnpj",cpfcnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer verificaInscCpfcnpj(HashMap<String, Object> inscCpfcnpj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace + ".verificaInscCpfcnpj",inscCpfcnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getProxDiaUtil(Date dia) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return (String) sqlMap.queryForObject(nameSpace + ".getProxDiaUtil",dia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<EcoVO> getEcoByCpfcnpj(String cpfcnptom) {
		try {  
  			return (List<EcoVO>) sqlMap.queryForList(this.getNameSpaceMap() + ".getEcoByCpfcnpj",cpfcnptom);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
	}
	
	public Integer countImNaoAtivaNaoEncerradaByCpfcnpj(String cpfcnpj) {
		String nameSpace = getNameSpaceMap();
		if (nameSpace == null)
			setNameSpaceMap("Eco");
		try {
			return (Integer) sqlMap.queryForObject(nameSpace + ".countImNaoAtivaNaoEncerradaByCpfcnpj",cpfcnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer countImByCpfcnpj(String cpfcnpj) {
		try {
			return (Integer) sqlMap.queryForObject(this.getNameSpaceMap() + ".countImByCpfcnpj",cpfcnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public EcoVO getEcoByIm(String im) {
		try {  
  			return (EcoVO) sqlMap.queryForObject(this.getNameSpaceMap() + ".getEcoByIm",im);  
  		} catch (SQLException e) {  
  			e.printStackTrace();  
  		}  
  		return null;  
	}
	
	public String getImuByCpfcnpj(String cpfcnpj) {
		try {
			return (String) sqlMap.queryForObject("Eco.getImuByCpfcnpj", cpfcnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getInscricoesSiatByCpfcnpj(String cpfcnpj) {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getInscricoesSiatByCpfcnpj",cpfcnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getOcpNivSup(String codocp) {
		try {
			return (Integer) sqlMap.queryForObject("Eco.getOcpNivSup", codocp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer verificaEcolic(HashMap<String, Object> ecolic) {
		try {
			return (Integer) sqlMap.queryForObject("Eco.verificaEcolic", ecolic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer insEcolic(HashMap<String, Object> ecolic) throws SQLException {
		return (Integer) sqlMap.insert(getNameSpaceMap() + ".insEcolic", ecolic);
	}
	
	public Integer insEcolichis(HashMap<String, Object> ecolic) throws SQLException {
		return (Integer) sqlMap.insert(getNameSpaceMap() + ".insEcolichis", ecolic);
	}
	
	public List<HashMap<String, Object>> getEcolic(String insmun) {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getEcolic", insmun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getEcolichis(String insmun) {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getEcolichis", insmun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getSociosQlf(String insmun) {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getSociosQlf", insmun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Double getValorTaxaDiversa(String numeroTaxa) {
		try {
			return (Double) sqlMap.queryForObject("Eco.getValorTaxa", numeroTaxa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HashMap<String, Object>> getAtualizaAlvaras() {
		try {
			return sqlMap.queryForList(getNameSpaceMap() + ".getAtualizaAlvaras");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer updAlvaraVerificado(Long id) throws SQLException {
		return (Integer) sqlMap.update(getNameSpaceMap() + ".updAlvaraVerificado", id);
	}
	
	public HashMap<String, Object> getDadosEco(HashMap<String, Object> eco) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(getNameSpaceMap() + ".getDadosEco", eco);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, Object> getStatusImpressaoAlvara(Integer codeco) {
		try {
			return (HashMap<String, Object>) sqlMap.queryForObject(getNameSpaceMap() + ".getStatusImpressaoAlvara", codeco);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer insStatusImpressaoAlvara(HashMap<String, Object> sta) throws SQLException {
		return (Integer) sqlMap.insert(getNameSpaceMap() + ".insStatusImpressaoAlvara", sta);
	}
}
