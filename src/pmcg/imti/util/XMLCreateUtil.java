package pmcg.imti.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class XMLCreateUtil {

	/**
	 * Recebe um objeto e retorna um xml com base nos atributos
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String getElementName(Object obj, String nivel){
		String xml = "";
		Field[] fld = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fld.length; i++) {
			String name = fld[i].getName();
			String getObj = "get" + name.substring(0, 1).toUpperCase()
					+ name.substring(1);
			Method m = null;
			try {
				m = obj.getClass().getMethod(getObj, new Class[] {});
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			Object val = null;
			try {
				val = m.invoke(obj, new Object[] {});
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			if (fld[i].getType().isInstance(new ArrayList())) {
				if (val != null)
					for (Object o : (List) val) {
						xml += "\n" + nivel + "<" + fld[i].getName() + ">";
						xml += nivel + getElementName(o, nivel + "\t");
						xml += "\n" + nivel + "</" + fld[i].getName() + ">";
					}
			} else {
				String ele ="";
				if (val == null) {
					ele = "<#></#>";
					ele = ele.replaceAll("#", name);
				} else {
					ele = "<#>%</#>";
					ele = ele.replaceAll("#", name);
					if (val instanceof BigDecimal) {
						DecimalFormat nf = new DecimalFormat("###0.00");
						String nval = nf.format(((BigDecimal) val)
								.doubleValue());
						nval = nval.replaceAll(",", ".");
						ele = ele.replaceAll("%", nval.toString());
					} else
						ele = ele.replaceAll("%", val.toString());
				}
				xml += "\n" + nivel + ele;
			}
		}
		return xml;
	}

}
