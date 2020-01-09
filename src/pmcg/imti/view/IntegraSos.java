package pmcg.imti.view;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.EdrDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.LvsDAO;
import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.dao.ibatis.ProDAO;
import pmcg.fcn.dao.ibatis.VatDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.CnaVO;
import pmcg.fcn.domain.EdrVO;
import pmcg.fcn.domain.EndVO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.LvsVO;
import pmcg.fcn.domain.MatVO;
import pmcg.fcn.domain.ProVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.prefeitura.Util;
import pmcg.framework.util.WinUtils;
import pmcg.imti.dao.ibatis.CepDAO;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.dao.ibatis.EndDAO;
import pmcg.imti.dao.ibatis.LicDAO;
import pmcg.imti.dao.ibatis.QfcDAO;
import pmcg.imti.dao.ibatis.VeaDAO;
import pmcg.imti.dao.ibatis.VesDAO;
import pmcg.imti.dao.ibatis.VreDAO;
import pmcg.imti.dao.ibatis.VrlDAO;
import pmcg.imti.domain.CepVO;
import pmcg.imti.domain.LicVO;
import pmcg.imti.domain.VeaVO;
import pmcg.imti.domain.VesVO;
import pmcg.imti.domain.VreVO;
import pmcg.imti.domain.VrlVO;
import pmcg.imti.util.FormatUtils;

public class IntegraSos {

	private HashMap<String, Object> dados;
	private VesVO ves;
	private CepVO cepVO;
	private EdrVO endMatriz;
	// Objetos do BAE:
	private ViaVO via = null; // viabilidade
	private BaeVO bae = null; // Empresa (Prefeitura)
	// Objetos da Junta:
	private EpdVO epd = null; // Empresa (Junta)
	private ProVO processo = null;
	private MatVO matriz = null;
	private List<CnaVO> listCnaMat; // LISTA DE ATIVIDADES
	private VreVO vre;
	private String numeroProcesso;
	private VrlVO vrlVO;
	private List<HashMap<String, Object>> listSocios;

	public IntegraSos(String numeroProcesso, Boolean geraLicenca) throws SQLException {
		this.numeroProcesso = numeroProcesso;
		try {
			new VesDAO().getSqlMap().startTransaction();
			this.insereEstabelecimento();
			EpdVO epd = new EpdVO();
			epd.setIddepd(Long.parseLong(this.dados.get("iddepd").toString()));
			epd.setVesepd(this.ves.getCodves());
			new EpdDAO().updEpdSosweb(epd);
			new VesDAO().getSqlMap().commitTransaction();
			this.insereEndereco();
			new VesDAO().getSqlMap().commitTransaction();
			this.insereAtividades();
			new VesDAO().getSqlMap().commitTransaction();
			this.insereRepresentantes();
			new VesDAO().getSqlMap().commitTransaction();
			if(geraLicenca){
				Integer codlic = insereLicenca();
				new VesDAO().getSqlMap().commitTransaction();
				
				LvsVO lvs = new LvsVO();
				lvs.setEpdlvs(Long.parseLong(this.dados.get("iddepd").toString()));
				lvs.setVeslvs(this.ves.getCodves());
				lvs.setLiclvs(codlic);
				lvs.setUsualt("CIMWEB");
				Long iddlvs = (Long) new LvsDAO().insReg(lvs);
				
				EpdVO epdp = new EpdVO();
				epdp.setIddepd(lvs.getEpdlvs());
				epdp.setLvsepd(iddlvs);
				new EpdDAO().updLicencaVig(epdp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new VesDAO().getSqlMap().endTransaction();
		}
	}

	public void insereEstabelecimento() throws SQLException {
		// BUSCANDO DADOS DA CONFIRMAÇÃO INSCRIÇÃO MUNICIPAL
		HashMap<String, Object> nprepdParam = new HashMap<String, Object>();
		nprepdParam.put("nprepd", numeroProcesso);
		this.dados = new EpdDAO().getDadosInsmun(nprepdParam);

		if (numeroProcesso.startsWith("CGR")) {
			// BAE
			bae = new BaeDAO().getBaeByViabae(numeroProcesso);
			via = new ViaDAO().getRegByProvia(numeroProcesso);
		} else {
			epd = new EpdDAO().getRegByProcesso(numeroProcesso);
			processo = new ProDAO().getRegByCod(epd.getProepd());
			matriz = new MatDAO().getRegByProcesso(processo.getIddpro());

			processo.setMatriz(matriz);
			epd.setProcesso(processo);
		}

		// Esses objetos estou aproveitando para os dois (BAE e Junta) -
		// ENDERECO MATRIZ
		endMatriz = new EdrDAO().getRegByCod(matriz != null ? matriz
				.getEndmat() : bae.getEdlbae());
		if (matriz != null) {
			matriz.setEndereco(endMatriz);
		}

		// GERANDO A LICENCA
		ves = new VesVO();
		// ves.setCodves(codves); //integer NOT NULL, -- Sequencial do
		// Estabelecimento
		if (numeroProcesso.startsWith("CGR") && via.getNjrvia().equals("4081")) {
			ves.setTipves("A"); // character varying(1), -- Tipo de
								// Estabelecimento (Empresa - E, Autonomo - A,
								// Profissional Liberal - P, Informal - I)
		} else {
			ves.setTipves("E"); // character varying(1), -- Tipo de
								// Estabelecimento (Empresa - E, Autonomo - A,
								// Profissional Liberal - P, Informal - I)
		}
		// TODO ves.setSetves(setves); //integer, -- Código do Setor
		ves.setCoddis(6); //integer, -- C�digo do Distrito (geral = 6 passado pela tati)
		// Sanitário
		ves.setRazves(dados.get("nomraz").toString()); // character
														// varying(250), --
														// Razão Social do
														// Estabelecimento
		ves.setNofves(epd != null ? epd.getProcesso().getMatriz().getNfamat()
				: bae.getNfabae()); // character varying(250), -- Nome Fantasia
									// do Estabelecimento
		String cpfCnpj = epd != null ? epd.getCnpepd() : bae.getCpfbae();
		if (cpfCnpj.length() == 14) {
			ves.setCnpves(dados.get("cpfcnpj").toString()); // character
															// varying(18), --
															// CNPJ do
															// Estabelecimento
		} else {
			ves.setCpfves(dados.get("cpfcnpj").toString()); // character
															// varying(14), --
															// CPF do
															// Estabelecimento
		}
		ves.setImuves(dados.get("insmun").toString()); // character varying(15),
														// -- Inscrição
														// Municipal
		ves.setIneves(null); // character varying(18), -- Inscrição Estadual
		ves.setCepves(endMatriz.getCepedr()); // character varying(8), -- CEP do
												// Estabelecimento
		ves.setComves(endMatriz.getComedr()); // character varying(100), --
												// Complemento do CEP do
												// Estabelecimento.
		ves.setNroves(endMatriz.getNumedr()); // character varying(7), -- Número
												// do Estabelecimento
		if (bae != null) {
			ves.setTelves(bae.getTelbae() != null ? bae.getTelbae() : bae
					.getCelbae() != null ? bae.getCelbae() : ""); // character
																	// varying(30),
																	// --
																	// Telefone
																	// do
																	// Estabelecimento
		} else {
			ves.setTelves(matriz.getTelmat() != null ? matriz.getTelmat() : ""); // character
																					// varying(30),
																					// --
																					// Telefone
																					// do
																					// Estabelecimento
		}
		ves.setEmaves(dados.get("emareq").toString()); // character varying(60),
														// -- Email do
														// Estabelecimento
		ves.setEsgves(null); // integer, -- Estado Geral do Estabelecimento. (1
								// - Bom, 2 - regular, 3 - Ruim)
		// ves.setDatalt(datalt); //timestamp without time zone NOT NULL, --
		// Data de Inclusão/Alteração
		ves.setUsualt("CIMWEB"); // character varying(12) NOT NULL, -- Usuário
									// de Inclusão/Alteração
		ves.setDtives(matriz != null && matriz.getDinmat() != null ? matriz
				.getDinmat() : null); // date, -- Data de início de
										// Funcionamento do Estabelecimento.
		ves.setDatultvis(null); // date, -- Data da última visita
		ves.setCodnat(3); // integer, -- Natureza Jurídica do Estabelecimento.
		ves.setSttves("A"); // character varying(1) NOT NULL DEFAULT
							// 'A'::character varying, -- Status do
							// Estabelecimento: A - Ativo; I - Inativo.
		ves.setCodtiplog(null); // numeric(3,0), -- Código Tipo Logradouro
		ves.setCodlog(null); // numeric(8,0), -- Código Logradouro
		ves.setCodbai(null); // numeric(8,0), -- Código Bairro
		ves.setCodcid(null); // numeric(8,0), -- Código da Cidade
		ves.setCoduf(null); // numeric(2,0), -- Código UF
		ves.setLetves(null); // character varying(3), -- Letra do
								// Estabelecimento
		ves.setSenves(null); // character varying(32), -- senha
		ves.setTeaves(null); // character varying(30), -- telefone alternativo
		ves.setLicves("1"); // character varying(1), -- 1 LICENÇA /2 RENOVAÇÃO.

		this.ves.setCodves((Integer) new VesDAO().insReg(ves));

	}

	/**
	 * Objetivo: verificar se existe o cep informado na tabela DNE (Correios),
	 * caso tenha, não realizar nenhum procedimento. Caso NÃO TENHA, cadastrar
	 * na tabela local de endereços.
	 */
	public void insereEndereco() {
		EndVO endVO = new EndVO();
		if (this.ves.getCepves() != null && !this.ves.getCepves().isEmpty()) {
			cepVO = new CepVO();
			this.cepVO.setCep_logradouro(ves.getCepves().replaceAll("_", "")
					.replaceAll("\\.", "").replaceAll("-", "").trim());
			cepVO = new CepDAO().getRegByCepVes(this.cepVO.getCep_logradouro());
			if (cepVO == null) {
				if (endVO == null) {
					endVO = new EndVO();
				}
				endVO.setCepend(ves.getCepves());
				endVO = new EndDAO().getRegByCEP(endVO);
				if (endVO == null) {
					endVO = new EndVO();
					endVO.setCepend(ves.getCepves());
					endVO.setTipend(endMatriz.getTloedr() == null ? ""
							: endMatriz.getTloedr());
					endVO.setLogend(endMatriz.getNloedr());
					endVO.setBaiend(endMatriz.getBaiedr());
					endVO.setCidend(endMatriz.getMunedr());
					endVO.setUfend(endMatriz.getUffedr());
					endVO.setUsualt("CIMWEB");
					endVO.setDatalt(WinUtils.getDataBanco());
					try {
						new EndDAO().insReg(endVO);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void insereAtividades() {
		if (numeroProcesso.startsWith("CGR")) {
			listCnaMat = new CnaDAO().getRegByProtocoloVia(bae.getViabae());
		} else {
			listCnaMat = new CnaDAO().getRegByProcessoMatriz(epd.getNprepd());
		}

		for (CnaVO cna : listCnaMat) {
			VeaVO veaVO = new VeaVO();
			veaVO.setCodves(this.ves.getCodves());
			veaVO.setPrincipal(cna.getPrincipal());
			veaVO.setUsualt("CIMWEB");
			veaVO.setDatalt(WinUtils.getDataBanco());
			veaVO.setVatVO(new VatDAO().getRegByCnae(Util
					.formataCnaeComMascara(cna.getCodcna()
							+ (cna.getDescna() != null ? cna.getDescna() : ""))));
			try {
				new VeaDAO().insReg(veaVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void insereRepresentantes() {
		this.listSocios = new EcoDAO().getSociosQlf(FormatUtils
				.onlyNumbers(dados.get("insmun").toString()));

		for (HashMap<String, Object> socio : listSocios) {
			this.vre = new VreVO();
			this.vre.setCodves(this.ves.getCodves());
			this.vre.setUsualt("CIMWEB");
			this.vre.setDatini(((Date) socio.get("DATINIMDT") != null ? (Date) socio
					.get("DATINIMDT") : new Date()));
			/*
			 * Caso o representante ja tenha sido cadastrado, ele faz a busca,
			 * senao faz o cadastro
			 */
			this.vre.setVrlVO(this.buscaRepresentante(socio));
			this.vre.setCodcar(new QfcDAO().getCargoByQualificacao(Integer
					.parseInt(socio.get("CODQLF").toString())));

			try {
				new VreDAO().insReg(vre);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private VrlVO buscaRepresentante(HashMap<String, Object> socio) {
		String cpfFormatado = FormatUtils.formatValue(socio.get("CPFCNPJ")
				.toString(), "###.###.###-##");
		vrlVO = new VrlDAO().getRegByCpf(cpfFormatado);
		if (vrlVO != null) {
			return vrlVO;
		} else {
			vrlVO = new VrlVO();
			vrlVO.setNomvrl(socio.get("NOMRAZCOM").toString());
			vrlVO.setCpfvrl(cpfFormatado);
			vrlVO.setUsualt("CIMWEB");
			Integer cod = 0;
			try {
				cod = (Integer) new VrlDAO().insReg(vrlVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			vrlVO.setCodvrl(cod);
			return vrlVO;
		}
	}

	private Integer insereLicenca() {
		LicVO licVO = new LicVO();
		licVO.setCodves(this.ves.getCodves());
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, 1);
		licVO.setDatvallic(cal.getTime());
		if (numeroProcesso.startsWith("CGR")) {
			licVO.setProlic(bae.getViabae());
		} else {
			licVO.setProlic(epd.getNprepd());
		}
		licVO.setSttlic("A");
		licVO.setUsualt("CIMWEB");
		licVO.setCodtpd(3);
		licVO.setTiplic("S"); // SIMPLIFICADA

		try {
			return (Integer) new LicDAO().insReg(licVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
