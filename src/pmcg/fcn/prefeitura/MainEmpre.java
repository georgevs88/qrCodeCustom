package pmcg.fcn.prefeitura;




public class MainEmpre {
    public static void main(String[] args) throws Exception {
	try{
	    System.out.println("starting");
	    System.out.println("1");
	    System.out.println(ClienteEmpreendimento.recuperaEmpreendimentosDeferidosParaPrefeitura());
	    
	    System.out.println("2");
//	    List<String> protocolosFCNRE = new ArrayList<String>();
//	    protocolosFCNRE.add("SE1201400000165");
//	    protocolosFCNRE.add("PR2201400000320");
//	    System.out.println(ClienteEmpreendimento.confirmacaoRecebimentoEmpreendimentoPelaPrefeitura(protocolosFCNRE));	
//	    
//	    System.out.println("3");
//	    System.out.println(ClienteEmpreendimento.confirmaDeferimento("SE1201400002793", "213454", "32148721"));
//	System.out.println(ClienteEmpreendimento.confirmaExigencia("SE1201400002793", "falta documentos X Y e Z"));
//	System.out.println(ClienteEmpreendimento.confirmaIndeferimento("SE1201400002793", "atividade imprópria para o local"));
//	System.out.println(ClienteEmpreendimento.confirmaParcialAlvara("SE1201400002793", "213454"));
//	System.out.println(ClienteEmpreendimento.confirmaParcialInscricao("SE1201400002793", "32148721"));
	    System.out.println("ending");
	    System.exit(0);	    
	}catch(Exception e){
	    e.printStackTrace();
	}
    }
}
