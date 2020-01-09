package pmcg.imti.view.ext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

import pmcg.fcn.dao.ibatis.CadDAO;
import pmcg.fcn.dao.ibatis.EdrDAO;
import pmcg.imti.dao.ibatis.CidDAO;
import pmcg.imti.dao.ibatis.EstDAO;
import pmcg.imti.dao.ibatis.LogradouroDAO;
import pmcg.imti.dao.ibatis.TipDAO;
import pmcg.fcn.domain.CadVO;
import pmcg.fcn.domain.EdrVO;
import pmcg.framework.util.StringUtils;
import pmcg.imti.domain.CidVO;
import pmcg.imti.domain.EstVO;
import pmcg.imti.domain.LogradouroVO;
import pmcg.imti.domain.TipVO;
import pmcg.imti.ui.LogicUtils;
import pmcg.imti.util.FormatUtils;
import pmcg.imti.util.Formatacao;

public class Registrar extends Index{

	private static final long serialVersionUID = 1L;
	public Boolean opcaoContabil;
	public Boolean divForm; //Controle de visibilidade do formulário de cadastro
	public Boolean divRel; //Controle de visibilidade da tela de impressão de relatório
	public String cepMask = "";
	public String telMask = "";
	public String celMask = "";
	public String faxMask = "";
	public List<TipVO> listTipLog = new ArrayList<TipVO>(); //Lista de tipos de logradouro
	public TipVO tipLogSel; //tipo de logradouro selecionado
	public List<TipVO> listTipBai = new ArrayList<TipVO>(); //Lista de tipos de bairro
	public TipVO tipBaiSel;
	public String confEmail = new String();
	public List<EstVO> listUf;
	public EstVO ufSel;
	public List<CidVO> listCidVO = new ArrayList<CidVO>(); // Lista de cidades do banco SIAT
	public CidVO cidSel; // Cidade selecionada
	public CadVO cadVO = new CadVO();
	public String confsenha = "";
	public EdrVO endereco = new EdrVO();
	public Boolean respCont = false;
	
	public void initReg() throws SQLException{
		divForm = true;
		divRel = false;
		listTipLog = new TipDAO().getRegByTipo("TLOG");
		listTipBai = new TipDAO().getRegByTipo("TBAIR");
		listUf = new EstDAO().getTodos(null);
		vincular();
	}
	
	public void gravar() throws InterruptedException {
		trataVO();
		CadVO cad = new CadDAO().getCadByCPF(cadVO.getCpfcad().toString());
		if(cad != null && cad.getIddcad() != null) {
			//já existe o CPF cadastrado
			try {
					Messagebox.show("Não foi possível gravar o registro! CPF já cadastrado!","Empresa Fácil",Messagebox.OK,Messagebox.INFORMATION);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		} else {
			if (Messagebox.show("Tem certeza que deseja Salvar as alterações?","Aviso!!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION) == Messagebox.YES) {
				try {
					new CadDAO().getSqlMap().startTransaction();
					Long codins, iddedr = null;
					//INSERIR ENDEREÇO
					endereco.setTipedr("C");
					iddedr = (Long) new EdrDAO().insReg(endereco);
					cadVO.setEdrcad(iddedr);
					codins = (Long) new CadDAO().insReg(cadVO);
					
					if (codins != null && codins > 0) {
						new CadDAO().getSqlMap().commitTransaction();
						divForm = false;
						divRel = true;
						//Manda e-mail com a senha
						LogicUtils.sendEmailCad(cadVO.getCpfcad(), cadVO.getEmacad(), cadVO.getSencad(),cadVO.getNomcad());
					} else {
						try {
							Messagebox.show("Não foi possível inserir o registro!");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					try {
						Messagebox.show("Não foi possível inserir o registro!");
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} finally {
					try {
						new CadDAO().getSqlMap().endTransaction();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}	
		vincular();
	}
	
	public void trataVO() {
		if(cadVO.getCpfcad() == null || FormatUtils.onlyNumbers(cadVO.getCpfcad()).isEmpty()){
			throw new WrongValueException(getComponente("cpfcad"),"Informe o CPF!");
		}
		String cpfcnpj = FormatUtils.onlyNumbers(cadVO.getCpfcad());
		if(cpfcnpj.length() != 11 || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
			throw new WrongValueException(getComponente("cpfcad"),"CPF inválido!");
		}
		if(cadVO.getDnacad() == null){
			throw new WrongValueException(getComponente("dnacad"),"Informe a Data de Nascimento!");
		}
		if(cadVO.getSexcad() == null){
			throw new WrongValueException(getComponente("sexcad"),"Informe o Sexo!");
		}
		if(cadVO.getNomcad() == null || cadVO.getNomcad().equals("")) {
			throw new WrongValueException(getComponente("nome"), "Informe o Nome!");
		}
		cadVO.setNomcad(cadVO.getNomcad().toUpperCase());
		if(cadVO.getDtpcad() == null){
			throw new WrongValueException(getComponente("dtpcad"),"Informe o Tipo de Documento de Identificação!");
		}
		if(cadVO.getDnrcad() == null){
			throw new WrongValueException(getComponente("dnrcad"),"Informe o Número do Documento de Identificação!");
		}
		if(cadVO.getDoecad() == null){
			throw new WrongValueException(getComponente("doecad"),"Informe o Órgão Expedidor do Documento de Identificação!");
		}
		if(((Combobox) getComponente("duocad")).getSelectedItem() == null){
			throw new WrongValueException(getComponente("duocad"),"Informe a UF do Órgão Expedidor!");
		}
		cadVO.setDuocad(((EstVO) ((Comboitem)((Combobox) getComponente("duocad")).getSelectedItem()).getValue()).getUnifed());
		if(cadVO.getDexcad()== null){
			throw new WrongValueException(getComponente("dexcad"),"Informe a Data de Expedição!");
		}
		if(endereco == null || (!Formatacao.isCEPValido(endereco.getCepedr()))){
			throw new WrongValueException(getComponente("cepcor"),"Informe o CEP!");
		}
		endereco.setCepedr(FormatUtils.onlyNumbers(endereco.getCepedr()));
		if(ufSel == null){
			throw new WrongValueException(getComponente("uffedr"),"Informe a UF!");
		}
		endereco.setUffedr(ufSel.getUnifed());
		if(cidSel == null){
			throw new WrongValueException(getComponente("uffedr"),"Informe o Município!");
		}
		endereco.setMunedr(cidSel.getCodsiafi().toString());
		if(tipLogSel == null){
			throw new WrongValueException(getComponente("tloedrcor"),"Informe Tipo de Logradouro!");
		}
		endereco.setTloedr(tipLogSel.getDescom());
		if(endereco.getNloedr() == null || endereco.getNloedr().isEmpty()){
			throw new WrongValueException(getComponente("nloedrcor"),"Informe o Logradouro!");
		}
		if(Formatacao.isNullOrEmpty(endereco.getNumedr())){
			throw new WrongValueException(getComponente("numedrcor"),"Informe o Número!");
		}
		if(tipBaiSel == null){
			throw new WrongValueException(getComponente("tbaedrcor"),"Informe Tipo de Bairro!");
		}
		endereco.setTbaedr(tipBaiSel.getDescom());
		if(Formatacao.isNullOrEmpty(endereco.getBaiedr())){
			throw new WrongValueException(getComponente("baiedrcor"),"Informe o Bairro!");
		}
		
		cadVO.setDdtcad(FormatUtils.onlyNumbers(cadVO.getDdtcad()));
		if(cadVO.getDdtcad() == null || cadVO.getDdtcad().equals("0") || cadVO.getDdtcad().equals("00") || cadVO.getDdtcad().length() < 2) {
			throw new WrongValueException(getComponente("dddtel"), "Informe um DDD válido de dois dígitos!");
		}
		cadVO.setTelcad(FormatUtils.onlyNumbers(telMask));
		if(cadVO.getTelcad() == null || cadVO.getTelcad().equals("") || cadVO.getTelcad().replaceAll("[-_(). ]","").length() < 8 ) {
			throw new WrongValueException(getComponente("telMask"), "Informe o Telefone!");
		}
		cadVO.setDdfcad(FormatUtils.onlyNumbers(cadVO.getDdfcad()));
		cadVO.setFaxcad(FormatUtils.onlyNumbers(faxMask));
		cadVO.setDdccad(FormatUtils.onlyNumbers(cadVO.getDdccad()));
		cadVO.setCelcad(FormatUtils.onlyNumbers(celMask));
		if(cadVO.getEmacad() == null || cadVO.getEmacad().isEmpty()) {
			throw new WrongValueException(getComponente("email"), "Informe o E-mail!");
		}
		if(confEmail == null || confEmail.isEmpty()) {
			throw new WrongValueException(getComponente("confemail"), "Verifique a Confirmação de e-mail!");
		}
		if(!cadVO.getEmacad().equals(confEmail)){
			throw new WrongValueException(getComponente("confemail"), "E-mail não confere com a confirmação!");
		}
		if(respCont){
			if(cadVO.getCpccad() == null || FormatUtils.onlyNumbers(cadVO.getCpccad()).isEmpty()){
				throw new WrongValueException(getComponente("cpccad"),"Informe o CPF/CNPJ!");
			}
			cpfcnpj = FormatUtils.onlyNumbers(cadVO.getCpccad());
			if((cpfcnpj.length() != 11 && cpfcnpj.length() != 14) || (!StringUtils.valida_CpfCnpj(cpfcnpj))){
				throw new WrongValueException(getComponente("cpccad"),"CPF/CNPJ inválido!");
			}
			if(cadVO.getNrscad() == null || cadVO.getNrscad().equals("")) {
				throw new WrongValueException(getComponente("nrscad"), "Informe o Nome/Razão Social!");
			}
			cadVO.setNrscad(cadVO.getNrscad().toUpperCase());
			if(cadVO.getTpccad() == null || cadVO.getTpccad().isEmpty()) {
				throw new WrongValueException(getComponente("tpccad"), "Informe o Tipo CRC!");
			}
			if(cadVO.getCrccad() == null || cadVO.getCrccad().isEmpty()) {
				throw new WrongValueException(getComponente("crccad"), "Informe o Número CRC!");
			}
			if(cadVO.getScrcad() == null || cadVO.getScrcad().isEmpty()) {
				throw new WrongValueException(getComponente("scrcad"), "Informe a Sigla do CRC!");
			}
			if(cadVO.getDtrcad() == null) {
				throw new WrongValueException(getComponente("dtrcad"), "Informe a Data de Registro do CRC!");
			}
			if(cadVO.getUfccad() == null || cadVO.getUfccad().isEmpty()) {
				throw new WrongValueException(getComponente("ufccad"), "Informe a UF de Registro do CRC!");
			}
		}
		
		cadVO.setCpfcad(FormatUtils.onlyNumbers(cadVO.getCpfcad()));
		cadVO.setCpccad(FormatUtils.onlyNumbers(cadVO.getCpccad()));
		cadVO.setDatalt(new Date());
		cadVO.setDtccad(new Date()); //data de cadastro
		cadVO.setUsualt("WEB");
		cadVO.setSencad(Formatacao.geraSenha());
	}
	
	public boolean trataCPF(String cpf) {
       String strCpf = cpf.replaceAll("-","").replaceAll("\\.", "");;
        if (strCpf.equals("")) {
            return false;
        } 
        
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
            d1 = d1 + (11 - nCount) * digitoCPF;

            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
            d2 = d2 + (12 - nCount) * digitoCPF;
        }

        //Primeiro resto da divisão por 11.  
        resto = (d1 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;

        //Segundo resto da divisão por 11.  
        resto = (d2 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        //Digito verificador do CPF que está sendo validado.  
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

        //Concatenando o primeiro resto com o segundo.  
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
        return nDigVerific.equals(nDigResult);
    }
	
	public void redirecionarTela(String link) {
		Executions.sendRedirect(link);
	}
	
	public boolean isAutenticado() {
		if (getSession().getAttribute("usuarioext") != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void selecionaOpcao(Boolean opcao){
		opcaoContabil = opcao;
		divForm = true;
		divRel = false;
		vincular();
	}
	
	public void pesquisaCEP(){
		if(endereco.getCepedr() != null && !endereco.getCepedr().isEmpty()){
			LogradouroVO lod = new LogradouroDAO().getBuscaCep(FormatUtils.onlyNumbers(endereco.getCepedr()));
			if(lod != null){
				ufSel = new EstDAO().getEstByUF(lod.getUf());
				listarCidades();
				CidVO cidParam = new CidVO();
				cidParam.setCodest(ufSel.getCodest());
				cidParam.setNomcom(lod.getCidade());
				cidSel = new CidDAO().getRegByNomUf(cidParam);
				tipLogSel = new TipDAO().getTiplogByDesc(lod.getTipo_logradouro());
				endereco.setNloedr(lod.getLogradouro());
				String[] parts = lod.getBairro().split(" ");
				tipBaiSel = new TipDAO().getTipbaiByDesc(parts[0]);
				if(tipBaiSel != null){
					endereco.setBaiedr(lod.getBairro().substring(lod.getBairro().indexOf(" ") + 1));
				} else {
					tipBaiSel = new TipDAO().getTipbaiByDesc("BAIRRO");
					endereco.setBaiedr(lod.getBairro());
				}
				vincular();
			} else {
				throw new WrongValueException(getComponente("cepcor"),"CEP não localizado!");
			}
		} else {
			throw new WrongValueException(getComponente("cepcor"),"Informe o CEP!");
		}
	}
	
	public void listarCidades() {
		listCidVO.clear();
		listCidVO.addAll(new CidDAO().getCidByEstado(ufSel.getUnifed()));
		this.vincular();
	}
	
}
