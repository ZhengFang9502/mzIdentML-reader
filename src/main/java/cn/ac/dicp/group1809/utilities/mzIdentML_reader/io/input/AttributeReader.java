package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import javax.xml.stream.XMLStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AttributeReader {
	public static Map<String, String> getAttributes(XMLStreamReader reader) {
		HashMap<String, String> attributes = new HashMap<>();
		int count = reader.getAttributeCount();
		int i = 0;
		while (i < count) {
			String name = reader.getAttributeLocalName(i);
			String value = reader.getAttributeValue(i);
			attributes.put(name, value);
			i++;
		}
		return attributes;
	}
}
