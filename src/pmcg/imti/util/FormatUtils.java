/**
 * 
 */
package pmcg.imti.util;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import org.zkoss.zk.ui.WrongValueException;
/**
 * @author Leonides Fernando
 *
 * @since 19/12/2006
 */
public class FormatUtils {

	private static Map<Integer, String> months = new Hashtable<Integer, String>();
	
	static{
		months.put(new Integer(1), "Janeiro");
		months.put(new Integer(2), "Fevereiro");
		months.put(new Integer(3), "Março");
		months.put(new Integer(4), "Abril");
		months.put(new Integer(5), "Maio");
		months.put(new Integer(6), "Junho");
		months.put(new Integer(7), "Julho");
		months.put(new Integer(8), "Agosto");
		months.put(new Integer(9), "Setembro");
		months.put(new Integer(10), "Outubro");
		months.put(new Integer(11), "Novembro");
		months.put(new Integer(12), "Dezembro");
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	/*public static NumberFormat getDoubleFormat(HttpServletRequest request){
		
		NumberFormat nf = NumberFormat.getInstance(new Locale(Locale.ENGLISH.getLanguage(), Locale.ENGLISH.getCountry()));
    	nf.setMinimumFractionDigits(2);
    	nf.setGroupingUsed(false);
    	return nf;
	}*/
	
	
	/**
	 * 
	 * @param date - data a partir da qual sera extarido o nome do mes
	 * @return - nome do mes em que a data passada como parametro foi criada
	 */
	public static String getMonthName(java.util.Date date){
		
		return (String) months.get(Integer.valueOf(getMonth(date)));
	}
	
	public static Integer getIdade(Date data) {
		Calendar cData = Calendar.getInstance();
		Calendar cHoje = Calendar.getInstance();
		cData.setTime(data);
		cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));
		Integer idade = cData.after(cHoje) ? -1 : 0;
		cData.setTime(data);
		idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
		return idade;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	/*public static DateFormat getHourFormat(HttpServletRequest request) {
        return new SimpleDateFormat("HH:mm");
    }*/
	
	/**
	 * retorna o dia da data passada como parametro para o método
	 * @param value o dia extraido do Timestamp passado como parametro
	 * @return String que representa o dia passado como parametro.
	 */
	public static String getDay(java.util.Date value){
				
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(value);
	    
	    int day = calendar.get(Calendar.DAY_OF_MONTH);
	    return fillLeft(String.valueOf(day), '0', 2);
	}
	
	/**
	  * metodo que extrai o mes de uma data Timestamp passada como parametro
	  * @param value a data no formato Timestamp de onde se pretende extrair o mes
	  * @return String que representa o mes extraido da data passada como parametro.
	  */
	public static String getMonth(java.util.Date value){
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(value);
	    int month = calendar.get(Calendar.MONTH);
	    return fillLeft(String.valueOf(month + 1), '0', 2);
	}

	/**
	  * metodo que extrai o ano de uma data Timestamp passada como parâmetro.
	  * @param value a data no formato Timestamp de onde se pretende extrair o ano
	  * @return String que representa o ano extraido da data Timestamp passada como parametro.
	  */
	public static String getYear(java.util.Date value){
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(value);
	    int year = calendar.get(Calendar.YEAR);
	    return fillLeft(String.valueOf(year), '0', 2);
	}
	
	/**
	  * Método para retornar uma String formada pela String fornecida e preenchida
	  * à esquerda pelo char até completar a quantidade posições fornecida. <br>
	  * Ex. fillLeft("casa",'0',10) = "000000casa"
	  * @param string String a ser preenchida
	  * @param chr a ser utilizado no preenchimento
	  * @param length comprimento final da string preenchida
	  * @return Str
	  */
	public static String fillLeft(String string, char chr, int length){
		
	    StringBuffer sb = new StringBuffer(string);
	    if (string.length() < length){
	      while (sb.length() < length){
	        sb.insert(0, chr);
	      }
	    }
	    return sb.toString();
	}
	/**
	 * 
	 * @param double - numero a ser convertido para string
	 * @return - um número
	 */
	public static String numberToString(double numero, int casas, int decimal) {
	  String nr = " ";
	  Formatter fmt = new Formatter();
	  try {
		  nr = fmt.format("%"+casas+"."+decimal+"f", numero).toString();  
		} catch(Exception ex) {	}
		return nr; 
	}
	/**
	 * 
	 * @param date - data a ser convertida para string
	 * @return - uma string com formato de data
	 */
	public static String dateToString(java.util.Date date) {
	  String dt = " ";
	  try {
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  dt = simpleDateFormat.format(date);
		} catch(Exception ex) {	}
		return dt; 
	}
	public static String dateToString(java.util.Date date,String fotmat) {
		  String dt = " ";
		  try {
			  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fotmat);
			  dt = simpleDateFormat.format(date);
			} catch(Exception ex) {	}
			return dt; 
		}
	/**
	 * 
	 * @param time - hora a ser convertida para string
	 * @return - uma string com formato de hora
	 */
	public static String timeToString(java.sql.Time time) {
	  String hr = " ";
	  try {
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		  hr = simpleDateFormat.format(time);
		} catch(Exception ex) {	}
		return hr; 
	}
	/**
	 * 
	 * @param string - a ser convertida para numero
	 * @return - objeto Double com a numero presente na String 
	 * @throws ParseException
	 */
	public static double stringToNumber(String string) {
		try {
			string = string.replace(',','.');
			return Double.parseDouble(string);
		} catch (Exception e) {
//			numero invalido
			return 0;
		}
	}

	/**
	 * 
	 * @param string - a ser convertida para data
	 * @return - objeto Date com a data presente na String ou null caso a data nao seja valida 
	 * @throws ParseException
	 */
	public static java.util.Date stringToDate(String string) {
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		try {
			string = string.replace('/', '-');
			return s.parse(string);
		} catch (ParseException e) {
//			data invalida
			return null;
		}
	}
	/**
	 * 
	 * @param string - a ser convertida para data
	 * @return - objeto Time com a hora presente na String ou null caso a hora nao seja valida 
	 * @throws ParseException
	 */
	public static java.sql.Time stringToTime(String string) {
		SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
		try {
			if(string.length()==5){
				string = string + ":00";
			}
			return new Time(s.parse(string).getTime());
		} catch (ParseException e) {
//			hora invalida
			return null;
		}
	}
	
	/**
	 * 
	 * @param string - a ser convertida para numero
	 * @return - objeto Long com numero presente na String 
	 * @throws ParseException
	 */
	public static Long stringToLong(String string) {
		try {
			return Long.parseLong(string);
		} catch (Exception e) {
//			numero invalido
			return Long.parseLong("0");
		}
	}
	/**
	 * Calcula os digitos verificadores do Numero do processo
	 * @param numpro
	 */
	public static boolean calcDigitos(String numeroProcesso){
		
		if(numeroProcesso.length()!=12){
			Formatter fmt = new Formatter();
			numeroProcesso = fmt.format("%012d",Long.parseLong(numeroProcesso)).toString();
			;
		}
		Integer dg1, dg2, soma1, soma2, result1, mod11_1, mod11_2, sub11_1, sub11_2; 		
		
		String strCod = numeroProcesso.substring(0, 6);
		String strAno = numeroProcesso.substring(8, 10);
		Integer intDig1 = Integer.parseInt(numeroProcesso.substring(10, 11));
		Integer intDig2 = Integer.parseInt(numeroProcesso.substring(11, 12));
		
		Integer ano0 = Integer.parseInt(strAno.substring(0, 1));
		Integer ano1 = Integer.parseInt(strAno.substring(1, 2));

		Integer num0 = Integer.parseInt(strCod.substring(0, 1));
		Integer num1 = Integer.parseInt(strCod.substring(1, 2));
		Integer num2 = Integer.parseInt(strCod.substring(2, 3));
		Integer num3 = Integer.parseInt(strCod.substring(3, 4));
		Integer num4 = Integer.parseInt(strCod.substring(4, 5));
		Integer num5 = Integer.parseInt(strCod.substring(5, 6));
//		Integer num6 = Integer.parseInt(strCod.substring(6, 7));
//		Integer num7 = Integer.parseInt(strCod.substring(7, 8));
		
		soma1 = (ano0 * 3) + (ano1 * 2) + (num0 * 9) + 
		        (num1 * 8) + (num2 * 7) + (num3 * 6) +
		        (num4 * 5) + (num5 * 4);
		
		mod11_1 = mod11(soma1);
		sub11_1 = 11 - mod11_1;
		dg1 = mod10(sub11_1);
		
		result1 = sub11_1 * 2;
		
		soma2 = result1 + (ano0 * 4) + (ano1 * 3) + (num0 * 10) + 
        				  (num1 * 9) + (num2 * 8) + (num3 * 7) +
        				  (num4 * 6) + (num5 * 5);
		
		mod11_2 = mod11(soma2);
		sub11_2 = 11 - mod11_2;
		dg2 = mod10(sub11_2);
		
		Integer[] dig = {dg1, dg2};
		
		if(intDig1.intValue()==dg1.intValue() && intDig2.intValue()==dg2.intValue()){
		
			return true;
		}
		
		return false;
		
	}

	/**
	 * Modulo 11
	 * @param x
	 * @return
	 */
	public static int mod11(int x){  
		return x % 11 ;  
	} 
	/**
	 * Modulo 10
	 * @param x
	 * @return
	 */
	public static int mod10(int x){  
		return x % 10 ;  
	} 
	/**
	 * 
	 * @param BigDecimal - numero a ser convertido para string
	 * @return - um número
	 */
	public static String numberToString(BigDecimal numero, int casas, int decimal) {
	  String nr = " ";
	  Formatter fmt = new Formatter();
	  try {
		  nr = fmt.format("%"+casas+"."+decimal+"f", numero).toString();  
		} catch(Exception ex) {	}
		return nr; 
	}
	
	public static String formatValue(String value,String format){
		MaskFormatter f = null;
		JFormattedTextField jt = null;
		try {
			if (format != null) {
				f = new MaskFormatter(format);
				//f.setPlaceholderCharacter(getPlaceholder());
				jt = new JFormattedTextField(f);				
				jt.setText(value == null ? "" : value.trim());
			} else{
				return value != null ? value : "";
			}

		} catch (ParseException e) {
			e.printStackTrace();
			throw new WrongValueException("Caracteres inválidos.");
		}
		return jt != null ? jt.getText() : "";
		 
	}

	public static String formataValorMonetario(BigDecimal valor){
		NumberFormat currency = NumberFormat.getInstance(new Locale("pt","BR"));
		currency.setMinimumFractionDigits(2);
		currency.setMaximumFractionDigits(2);
		return valor!=null?currency.format(valor):null;
	}	

	public static String formataValorNaoMonetario(Long valor){
		NumberFormat currency = NumberFormat.getInstance(new Locale("pt","BR"));
		currency.setMinimumFractionDigits(0);
		currency.setMaximumFractionDigits(0);
		return valor!=null?currency.format(valor):null;
	}	

	public static String strZero(Long numero, int casas) {
		String strFmt = "%0" + casas + "d";
		Formatter fmt = new Formatter();
		return fmt.format(strFmt, numero).toString();
	}	
	
	public static String onlyNumbers(String str) {
		if (str != null && str.length() > 0) {
		   return str.replaceAll("[^0123456789]", "");
		} else {
		   return null;
		}
	}
	
	public static Integer getNumeroLogradouro(String str) {
		if(str != null){
			str = onlyNumbers(str);
			if(!str.isEmpty()){
				return Integer.parseInt(str);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
}
