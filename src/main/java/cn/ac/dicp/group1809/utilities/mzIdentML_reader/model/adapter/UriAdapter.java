package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.net.URI;

/**
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
public class UriAdapter extends XmlAdapter<String, URI> {

	@Override
	public URI unmarshal(String v) {
		return URI.create(v);
	}

	@Override
	public String marshal(URI v) {
		if (v == null) {
			return null;
		}
		return v.toString();
	}
}
