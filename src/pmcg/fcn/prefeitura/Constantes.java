package pmcg.fcn.prefeitura;

public class Constantes {
    public static class Certificados {
//		public static String arquivo_pfx = new Constantes().getClass().getResource("").getPath() + "prefeitura_campo_grande.pfx";
//	    public static String arquivo_jks = new Constantes().getClass().getResource("").getPath() + "prefeitura_campo_grande.jks";
    	//PRODUCAO
	    public static String arquivo_pfx = new Constantes().getClass().getResource("").getPath() + "prefeitura.pfx";
	    public static String arquivo_jks = new Constantes().getClass().getResource("").getPath() + "prefeitura.jks";
	    
	    //PRODUCAO
		public static String senha_pfx = "HJajsjdmmI89O3";
		public static String senha_jks = "HJajsjdmmI89O3";
    }

    public static class Servico {
		//Deve ser alterado para o ENDERECO fornecido pela JUNTA.	
//		private static String url_base = "https://homportalservicos.jucems.ms.gov.br:443/empreendimento/service/";
    	//PRODUCAO
    	private static String url_base = "https://portalservicos.jucems.ms.gov.br/empreendimento/service/";
		
		public static String url_servico_viabilidade = url_base + "ViabilidadePrefeituraWS";
		public static String url_servico_empreendimento = url_base + "EmpreendimentoPrefeituraWS";
		public static String url_servico_empreendimento_visa = url_base + "EmpreendimentoVisaWS";
		public static String url_servico_empreendimento_bombeiro = url_base + "EmpreendimentoBombeiroWS";
		public static String url_servico_empreendimento_semad = url_base + "EmpreendimentosSemadWS";
		public static Integer validade_analise_endereco = 90;
    }
}
