package pmcg.imti.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LogicUtils {

	public static void sendEmailCad(String cpfusu, String email, String senha, String nomeusu) {
		String host = "smtp.issdigital.capital.ms.gov.br";
		String port = "25";
		String to = email;
		String from = "'Prefeitura Municipal de Campo Grande-MS (Não-Responda)'<contador@issdigital.capital.ms.gov.br>";
		String subject = "Senha de acesso ao Sistema CIM";

		Properties props = System.getProperties();
		props.put("mail.host", host);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.debug", "false");
		
		javax.mail.Session session = javax.mail.Session.getInstance(props, new Autenticacao());
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to),
					new InternetAddress(from) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date(System.currentTimeMillis()));
			String body =   "<div>" + 
							"	<div style=\"background:#ECF6FF;width:650px;margin:5px;border:1px solid #e5e5e5;padding-left:20px;padding:5px 20px 0 20px\">" + 
							"		<table style=\"margin:15px 0\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">" + 
							"			<tbody>" + 
							"				<tr>" + 
							"					<td align=\"center\">" + 
							"						<a href=\"http://www.capital.ms.gov.br\" style=\"text-decoration:none\" target=\"_blank\">" + 
							"							<img src=\"http://cim.campogrande.ms.gov.br/cimweb/images/sefin_pmcg.jpg\" alt=\"Prefeitura municipal de campo grande-ms\" border=\"0\">" + 
							"						</a>" + 
							"					</td>" + 
							"				</tr>" + 
							"			</tbody>" + 
							"		</table>" + 
							"		<table style=\"color:#fff;margin-bottom:20px\" border=\"0\" cellpadding=\"0\" width=\"650\">" + 
							"			<tbody>" + 
							"				<tr>" + 
							"					<td>" + 
							"						<div style=\"border-color:#3079ed;background-color:#005A89;border:1px solid #2f5bb7;white-space:nowrap;min-height:29px;line-height:29px;text-align:left;padding:0;font-weight:bold; text-align:center; font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">Registro PMCG - Cadastro Integrado Municipal</div>" + 
							"					</td>" + 
							"				</tr>" + 
							"			</tbody>" + 
							"		</table>" + 
							"		<table style=\"min-height:120px;border:1px solid #bbb;padding:0;background:#fff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">" + 
							"			<tbody>" + 
							"				<tr>" + 
							"					<td style=\"padding:0 20px;margin:0\" height=\"100\" width=\"332\">" + 
							"						<div style=\"margin-top:13px;color:#999;font-weight:bold;font-size:120%;line-height:20px\">Senhor (a) NOMEUSU, </div>" + 
							"						<div style=\"padding:4px 0;color:#333;font-size:80%;line-height:20px;font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">" + 
							"							<p>Conforme sua solicitação, estamos lhe enviando sua senha de Acesso ao Sistema PMCG - CIM.</p>" + 
							"						</div>" + 
							"					</td>" + 
							"					<td style=\"padding:0;margin:0; text-align:center; vertical-align:top\" align=\"center\" height=\"100\" width=\"278\">" + 
							"						<p style=\"margin:0px 0\">" + 
							"							<a href=\"http://cim.campogrande.ms.gov.br/\" style=\"text-decoration:none;display:block;text-align:center;color:white;font-size:100%;font-weight:bold;padding:0 15px;white-space:nowrap;text-transform:uppercase;letter-spacing:1;background-color:#005A89;min-height:29px;line-height:29px;margin:35 0 0 0;border:1px solid #2572AB;font-family: 'Open Sans',Arial,Helvetica,sans-serif;\" target=\"_blank\">Acesse agora</a>" + 
							"						</p>" + 
							"					</td>" + 
							"				</tr>" + 
							"			</tbody>" + 
							"		</table>" + 
							"		<table style=\"margin:0 0 10px 0;background:#fff;border:1px solid #e5e5e5\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">" + 
							"			<tbody>" + 
							"				<tr>" + 
							"					<td style=\"padding:20px 10px 10px 20px\" valign=\"top\" width=\"420\">" + 
							"						<div style=\"color:#333;font-weight:bold;line-height:21px;margin:0px\"> Login: CPFUSU </div>" + 
							"					</td>" + 
							"					<br />" + 
							"				</tr>" + 
							"				<tr>" + 
							"					<td style=\"padding:10px 10px 20px 20px\" valign=\"top\" width=\"420\">" + 
							"						<div style=\"color:#333;font-weight:bold;line-height:21px;margin:0px\"> Senha: PASSWD </div>" + 
							"					</td>" + 
							"				</tr>" + 
							"			</tbody>" + 
							"		</table>" + 
							"		<div style=\"padding:4px 0;color:#333;font-size:75%;line-height:20px;font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">" + 
							"			<p>MAIORES INFORMAÇÕES:<br />" + 
							"				Plantão Fiscal: Rua Candido Mariano, 2655 - Centro<br />" + 
							"				Campo Grande - MS<br />" + 
							"				http://cim.campogrande.ms.gov.br/" + 
							"			</p>" + 
							"		</div>" + 
							"		<table style=\"padding:0;margin:0 0 20px 0px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"652\">" + 
							"			<tbody>" + 
							"				<tr>" + 
							"					<td style=\"text-align:left;vertical-align:middle; padding-left:20px;\" width=\"652\">" + 
							"						<img alt=\"\" src=\"http://cim.campogrande.ms.gov.br/cimweb/images/agetec2.png\" style=\"padding:0 10px 0 0\" border=\"0\" height=\"46\" />" + 
							"					</td>" + 
							"				</tr>" + 
							"			</tbody>" + 
							"		</table>" + 
							"	</div>" + 
							"	<table width=\"700\">" + 
							"		<tbody>" + 
							"			<tr>" + 
							"				<td colspan=\"2\" style=\"font-size:11px;color:#999;text-align:center;padding:10px 0; font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">&copy;ANOATUAL SEFIN - Secretaria Municipal de Finanças e Planejamento <br />" + 
							"					Avenida Afonso Pena, 3297 - Centro, Campo Grande - MS, Brasil - 1º Andar<br />" + 
							"					Telefone(s): (67) 3314-9829 - (67) 3314-9830" + 
							"				</td>" + 
							"			</tr>" + 
							"		</tbody>" + 
							"	</table>" + 
							"	<img src=\"https://www.google.com/offers/ga/db0a8a36771f7cd9/4UPO132AYO54BRVW/unpersonalized?r=-2073480139\" style=\"border:none\" alt=\"\" height=\"1\" width=\"1\">" + 
							"	<img src=\"https://googleads.g.doubleclick.net/pagead/viewthroughconversion/967763451/?label=hVjWCIWXnwMQ-8u7zQM&amp;guid=ON&amp;script=0&amp;data=s%3Dep%3Bid%3D4UPO132AYO54BRVW%3Boffcat%3DOTHER_RETAIL\" alt=\"\" height=\"1\" width=\"1\">" + 
							"</div>";

			body = body.replaceAll("\n", "<br />");
			body = body.replaceAll("NOMEUSU", nomeusu);
			body = body.replaceAll("CPFUSU", cpfusu);
			body = body.replaceAll("PASSWD", senha);
			body = body.replaceAll("ANOATUAL", new SimpleDateFormat("yyyy").format(new Date()));

			msg.setContent(body, "text/html;charset=Cp1252;");
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void sendEmailInsmun(String email, String protocolo, String cpfcnpj, String nomraz, String insmun) {
		String host = "smtp.issdigital.capital.ms.gov.br";
		String port = "25";
		String to = email;
		String from = "'Prefeitura Municipal de Campo Grande-MS (Não-Responda)'<contador@issdigital.capital.ms.gov.br>";
		String subject = "Sistema CIM - Registro de Inscrição Municipal";

		Properties props = System.getProperties();
		props.put("mail.host", host);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.debug", "false");
		
		javax.mail.Session session = javax.mail.Session.getInstance(props, new Autenticacao());
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to),
					new InternetAddress(from) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date(System.currentTimeMillis()));
			String body = "<div>" +
							"	<div style=\"background:#ECF6FF;width:650px;margin:5px;border:1px solid #e5e5e5;padding-left:20px;padding:5px 20px 0 20px\">" +
							"		<table style=\"margin:15px 0\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">" +
							"			<tbody>" +
							"				<tr>" +
							"					<td align=\"center\">" +
							"						<a href=\"http://www.capital.ms.gov.br\" style=\"text-decoration:none\" target=\"_blank\">" +
							"							<img src=\"http://cim.campogrande.ms.gov.br/cimweb/images/sefin_pmcg.jpg\" alt=\"Prefeitura municipal de campo grande-ms\" border=\"0\">" +
							"						</a>" +
							"					</td>" +
							"				</tr>" +
							"			</tbody>" +
							"		</table>" +
							"		<table style=\"color:#fff;margin-bottom:20px\" border=\"0\" cellpadding=\"0\" width=\"650\">" +
							"			<tbody>" +
							"				<tr>" +
							"					<td>" +
							"						<div style=\"border-color:#3079ed;background-color:#005A89;border:1px solid #2f5bb7;white-space:nowrap;min-height:29px;line-height:29px;text-align:left;padding:0;font-weight:bold; text-align:center; font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">Registro PMCG - Cadastro Integrado Municipal</div>" +
							"					</td>" +
							"				</tr>" +
							"			</tbody>" +
							"		</table>" +
							"		<table style=\"min-height:120px;border:1px solid #bbb;padding:0;background:#fff\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"650\">" +
							"			<tbody>" +
							"				<tr>" +
							"					<td style=\"padding:0 20px;margin:0\" height=\"100\" width=\"332\">" +
							"						<div style=\"margin-top:13px;font-weight:bold;font-size:120%;line-height:20px\">Informamos que foi gerada a seguinte Inscrição Municipal:</div>" +
							"						<div style=\"padding:4px 0;color:#333;font-size:80%;line-height:20px;font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">" +
							"							<p>Protocolo: NPREPD</p>" +
							"							<p>CPF/CNPJ: CPFCNPJ</p>" +
							"							<p>Nome/Razão Social: NOMRAZ</p>" +
							"							<p style=\"color:#BC0000;font-weight:bold;font-size:16px;\">INSCRIÇÃO MUNICIPAL: INSMUN</p>" +
							"						</div>" +
							"					</td>" +
							"				</tr>" +
							"			</tbody>" +
							"		</table>" +
							"		<div style=\"padding:4px 0;color:#333;font-size:75%;line-height:20px;font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">" +
							"			<p>MAIORES INFORMAÇÕES:<br />" +
							"				Plantão Fiscal: Rua Candido Mariano, 2655 - Centro<br />" +
							"				Campo Grande - MS<br />" +
							"				http://cim.campogrande.ms.gov.br/" +
							"			</p>" +
							"		</div>" +
							"		<table style=\"padding:0;margin:0 0 20px 0px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"652\">" +
							"			<tbody>" +
							"				<tr>" +
							"					<td style=\"text-align:left;vertical-align:middle; padding-left:20px;\" width=\"652\">" +
							"						<img alt=\"\" src=\"http://cim.campogrande.ms.gov.br/cimweb/images/agetec2.png\" style=\"padding:0 10px 0 0\" border=\"0\" height=\"46\" />" +
							"					</td>" +
							"				</tr>" +
							"			</tbody>" +
							"		</table>" +
							"	</div>" +
							"	<table width=\"700\">" +
							"		<tbody>" +
							"			<tr>" +
							"				<td colspan=\"2\" style=\"font-size:11px;color:#999;text-align:center;padding:10px 0; font-family: 'Open Sans',Arial,Helvetica,sans-serif;\">&copy;ANOATUAL SEFIN - Secretaria Municipal de Finanças e Planejamento <br />" +
							"					Avenida Afonso Pena, 3297 - Centro, Campo Grande - MS, Brasil - 1º Andar<br />" +
							"					Telefone(s): (67) 3314-9829 - (67) 3314-9830" +
							"				</td>" +
							"			</tr>" +
							"		</tbody>" +
							"	</table>" +
							"	<img src=\"https://www.google.com/offers/ga/db0a8a36771f7cd9/4UPO132AYO54BRVW/unpersonalized?r=-2073480139\" style=\"border:none\" alt=\"\" height=\"1\" width=\"1\">" +
							"	<img src=\"https://googleads.g.doubleclick.net/pagead/viewthroughconversion/967763451/?label=hVjWCIWXnwMQ-8u7zQM&amp;guid=ON&amp;script=0&amp;data=s%3Dep%3Bid%3D4UPO132AYO54BRVW%3Boffcat%3DOTHER_RETAIL\" alt=\"\" height=\"1\" width=\"1\">" +
							"</div>";

			body = body.replaceAll("\n", "<br />");
			body = body.replaceAll("NPREPD", protocolo);
			body = body.replaceAll("CPFCNPJ", cpfcnpj);
			body = body.replaceAll("NOMRAZ", nomraz);
			body = body.replaceAll("INSMUN", insmun);
			body = body.replaceAll("ANOATUAL", new SimpleDateFormat("yyyy").format(new Date()));

			msg.setContent(body, "text/html;charset=Cp1252;");
			Transport.send(msg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
