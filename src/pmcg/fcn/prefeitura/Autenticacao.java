package pmcg.fcn.prefeitura;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Autenticacao extends Authenticator {
	  protected PasswordAuthentication
	  			getPasswordAuthentication() {

	  //System.out.println("Autenticando...");
	  //return new PasswordAuthentication("portalcidadao@capital.ms.gov.br","p0rt@l2010");
	  //return new PasswordAuthentication("nao-responda@capital.ms.gov.br","pmcg2010");
	  return new PasswordAuthentication("contador","!mt!12");
	  //return new PasswordAuthentication("nao-responda","fabricaimti");
	  }
	}

