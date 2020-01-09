package pmcg.fcn.domain;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class DateXmlConverter extends AbstractSingleValueConverter {

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@Override
	@SuppressWarnings("rawtypes")
	public boolean canConvert(final Class type) {
		return type.equals(Date.class) || type.equals(Timestamp.class);
	}

	@Override
	public Object fromString(String str) {
		try {
			return format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString(Object obj) {
		if (obj == null)
			return null;
		Date data = (Date) obj;
		return format.format(data);
	}

}