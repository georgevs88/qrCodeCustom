package pmcg.fcn.prefeitura;

import java.util.HashMap;
import java.util.List;

import pmcg.fcn.dao.ibatis.BaeDAO;
import pmcg.fcn.dao.ibatis.CnaDAO;
import pmcg.fcn.dao.ibatis.EdrDAO;
import pmcg.fcn.dao.ibatis.EpdDAO;
import pmcg.fcn.dao.ibatis.MatDAO;
import pmcg.fcn.dao.ibatis.ProDAO;
import pmcg.fcn.dao.ibatis.SadDAO;
import pmcg.fcn.dao.ibatis.ViaDAO;
import pmcg.fcn.domain.BaeVO;
import pmcg.fcn.domain.CnaVO;
import pmcg.fcn.domain.EdrVO;
import pmcg.fcn.domain.EpdVO;
import pmcg.fcn.domain.MatVO;
import pmcg.fcn.domain.ProVO;
import pmcg.fcn.domain.SadVO;
import pmcg.fcn.domain.ViaVO;
import pmcg.fcn.siat.domain.TipoPessoa;
import pmcg.imti.dao.ibatis.EcoDAO;
import pmcg.imti.dao.ibatis.LicDAO;
import pmcg.imti.dao.ibatis.VeaDAO;
import pmcg.imti.dao.ibatis.VesDAO;
import pmcg.imti.dao.ibatis.VreDAO;
import pmcg.imti.domain.LicVO;
import pmcg.imti.domain.VeaVO;
import pmcg.imti.domain.VesVO;
import pmcg.imti.domain.VreVO;
import pmcg.imti.util.FormatUtils;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.out.println(ClienteViabilidade.recuperaViabilidadesPendentes());
		// System.out.println(ClienteViabilidade.confirmaRecebimentoConsulta("SEP1400001625"));
		// System.out.println(ClienteViabilidade.confirmaRespostaAnaliseEndereco("SEP1400001625"));
		// System.exit(0);

		// new ImportacaoJunta().importa(false, false, false, true);

		// ############### CONFORMAR INSCRICAO MANUALMENTE
		// ################################################
		/*
		 * String processo = "MS2201500072983"; String resposta =
		 * ClienteEmpreendimento.confirmaParcialInscricao(processo,
		 * "00208709003"); resposta = resposta.replaceAll("TipoRetorno",
		 * "tipoRetorno"); String tipoRetorno = resposta.replaceAll("\n",
		 * "").replaceFirst("^.*<tipoRetorno>",
		 * "").replaceFirst("</tipoRetorno>.*", "");
		 * if(tipoRetorno.equals("SUCESSO")){ new
		 * EpdDAO().updAtendidoByProcesso(processo); }
		 */
		// ############### ATUALIZAR REGISTROS FEITOS PELO EF
		// ################################################

		// TESTAR E-MAIL
		// String nprepd = "MS1201600108257";
		// HashMap<String, Object> dados = new EpdDAO().getDadosInsmun(nprepd);
		// String email = dados.get("emareq").toString();
		// String cpfcnpj = dados.get("cpfcnpj").toString();
		// String nomraz = dados.get("nomraz").toString();
		// String inscricaoMunicipal = dados.get("insmun").toString();
		// LogicUtils.sendEmailInsmun(email, nprepd, cpfcnpj, nomraz,
		// inscricaoMunicipal);

		// TESTAR GRAVAÇÃO DA LICENCA
		// iddepd baixo = 5955
		// iddepd alto = 5945
		// iddepd medio = 5940

		// EpdVO epdp = new EpdDAO().getRegByCod(5945L);
		// String nprepd = epdp.getNprepd();
		// HashMap<String, Object> nprepdParam = new HashMap<String, Object>();
		// nprepdParam.put("nprepd", nprepd);
		// HashMap<String, Object> dados = new
		// EpdDAO().getDadosInsmun(nprepdParam);
		// HashMap<String, Object> matriz = new
		// MatDAO().getMatrizByProcesso(Long.parseLong(dados.get("iddpro").toString()));
		// //ASSUMINDO QUE SEMPRE SERÁ 1 MATRIZ PARA CADA PROCESSO
		// if(matriz.get("ambaen").toString().equalsIgnoreCase("B")){
		// LmaVO lma = new LmaVO();
		// lma.setEsplma("DISPENSA");
		// lma.setProlma(nprepd);
		// lma.setEmilma(new Date());
		// lma.setVallma(null);
		// lma.setReqlma(matriz.get("nommat").toString());
		// lma.setAtvlma(matriz.get("desmat").toString());
		// lma.setEdrlma(matriz.get("endmat").toString());
		// //TODO lma.setReglma(reglma); buscar regiao do imobiliario
		// lma.setAnolma(Integer.parseInt(new
		// SimpleDateFormat("yyyy").format(new Date())));
		// lma.setAsslma("JEANN PIERRE DE FREITAS");
		// //TODO puxar a resposta do questionario
		// lma.setMuslma(true);
		// lma.setUsualt("CIMWEB");
		// lma.setSitlma("A");
		// Long iddlma = (Long) new LmaDAO().insReg(lma);
		// if(iddlma != null && iddlma > 0){
		// epdp.setLmaepd(iddlma);
		// new EpdDAO().updLicencaAmb(epdp);
		// }
		// }

		// ############### GERAR LICENCA SANITARIA
		// ################################################
		String numeroProcesso = "MS2201600123297";

		// BUSCANDO DADOS DA CONFIRMAÇÃO INSCRIÇÃO MUNICIPAL
		HashMap<String, Object> nprepdParam = new HashMap<String, Object>();
		nprepdParam.put("nprepd", numeroProcesso);
		HashMap<String, Object> dados = new EpdDAO()
				.getDadosInsmun(nprepdParam);
		/*
		 * e.iddepd, p.iddpro, r.emareq, e.nprepd, fcn.formatacpfcnpj(case when
		 * e.cnpepd is not null then e.cnpepd else m.cnpmat end) as cpfcnpj,
		 * m.nommat as nomraz, substr(c.imucai,1,10) || '-' ||
		 * substr(c.imucai,11,1) as insmun, v.provia, aen.ambaen, aen.vigaen,
		 * case when aen.ambaen = 'B' then 'BAIXO' when aen.ambaen = 'M' then
		 * 'MÉDIO' else 'ALTO' END AS risamb, case when aen.ambaen = 'B' then
		 * '/images/externo/green.png' when aen.ambaen = 'M' then
		 * '/images/externo/yellow.png' else '/images/externo/red.png' END AS
		 * imgamb, case when aen.vigaen = 'B' then 'BAIXO' when aen.vigaen = 'M'
		 * then 'MÉDIO' else 'ALTO' END AS risvig, case when aen.vigaen = 'B'
		 * then '/images/externo/green.png' when aen.vigaen = 'M' then
		 * '/images/externo/yellow.png' else '/images/externo/red.png' END AS
		 * imgvig, lmaepd, lvsepd
		 */

		// BUSCANDO DADOS DA GERACAO DO CADASTRO ECONOMICO
		// Objetos do BAE:
		ViaVO via = null; // viabilidade
		BaeVO bae = null; // Empresa (Prefeitura)
		// Objetos da Junta:
		EpdVO epd = null; // Empresa (Junta)
		ProVO processo = null;
		MatVO matriz = null;

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
		EdrVO endMatriz = new EdrDAO().getRegByCod(matriz != null ? matriz
				.getEndmat() : bae.getEdlbae());
		if (matriz != null) {
			matriz.setEndereco(endMatriz);
		}
		List<CnaVO> listCnaMat; // LISTA DE ATIVIDADES
		if (numeroProcesso.startsWith("CGR")) {
			listCnaMat = new CnaDAO().getRegByProtocoloVia(bae.getViabae());
		} else {
			listCnaMat = new CnaDAO().getRegByProcessoMatriz(epd.getNprepd());
		}

		// GERANDO A LICENCA
		VesVO ves = new VesVO();
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
		// TODO ves.setCoddis(coddis); //TODO integer, -- Código do Distrito
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

		new VesDAO().insReg(ves);

		// INSERE AS ATIVIDADES
		for (CnaVO cna : listCnaMat) {
			VeaVO atv = new VeaVO();

			new VeaDAO().insReg(atv);
		}

		// INSERE OS REPRESENTANTES
		List<HashMap<String, Object>> listSocios = new EcoDAO().getSociosQlf(FormatUtils.onlyNumbers(dados.get("insmun").toString()));
		for (HashMap<String, Object> sad : listSocios) {
			VreVO vre = new VreVO();

			new VreDAO().insReg(vre);
		}

		// INSERE A LICENCA
		LicVO licenca = new LicVO();
		new LicDAO().insReg(licenca);
	}

}
