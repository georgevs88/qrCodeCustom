package pmcg.imti.view;

import org.zkoss.zk.ui.Executions;

import pmcg.imti.view.ext.Index;

public class Autrel extends Index {

	private static final long serialVersionUID = 1L;
	
	public String qrtext; //número da nota
	
	public void initAut() throws InterruptedException{
		qrtext = Executions.getCurrent().getParameter("v");
		if(qrtext != null && qrtext.length() == 16){
			String iddalv = qrtext.substring(0,8);
			String autenticidade = qrtext.substring(8);
//			CdgVO c = new CdgVO();
//			c.setIDDCDG(Long.parseLong(iddcfg));
//			c.setAUTENTICIDADE(autenticidade);
//			cdg = new CdgDAO().getRegAutenticidade(c);
		} else {
//			cdg = null;
		}
		vincular();
	}
	
//	public Boolean isVisibleValido(){
//		if(cdg != null && cdg.getValidacaoData()){
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public Boolean isVisibleVencido(){
//		if(cdg != null && (!cdg.getValidacaoData())){
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public Boolean isVisibleNaoValido(){
//		if(cdg == null){
//			return true;
//		} else {
//			return false;
//		}
//	}
		
	public void verificar() {
//		trataDados();
//		nftTeste.setNrnotanft(Integer.parseInt(nrnota.trim()));
//		nftTeste.setCodvernft(codver);
//		nftVO = new NftDAO().getVerAut(nftTeste);
//		if (nftVO != null && nftVO.getNrnotanft() != null) {
//			//nota válida
//			visDivResumo = true;
//			lblResult = "Nota Fiscal Válida!";
//			(getComponente("divResult")).setStyle("background-color:#5CB85C;margin-top: 15px;border-radius: 5px;"); //verde
//		} else {
//			visDivResumo = false;
//			lblResult = "Nota Fiscal não Localizada!";
//			(getComponente("divResult")).setStyle("background-color:#D9534F;margin-top: 15px;border-radius: 5px;"); //vermelho
//		}
//		this.vincular();
	}
	
	public void trataDados() {
//		if(nrnota == null || nrnota.trim().isEmpty()){
//			throw new WrongValueException(getComponente("nrnota"), "Informe o Número da Nota Fiscal!");
//		}
//		if (!Formatacao.isNumeric(nrnota.trim())) {
//			throw new WrongValueException(getComponente("nrnota"), "Informe um valor numérico!");
//		}
//		if(codver == null || codver.trim().isEmpty()){
//			throw new WrongValueException(getComponente("codver"), "Informe o Código de Verificação!");
//		}
	}
}
