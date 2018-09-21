package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
public class DateAdapter extends XmlAdapter<String, Date> {
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

	@Override
	public Date unmarshal(String v) throws ParseException {
		return dateFormat.parse(v);
	}

	@Override
	public String marshal(Date v) {
		return dateFormat.format(v);
	}
}
