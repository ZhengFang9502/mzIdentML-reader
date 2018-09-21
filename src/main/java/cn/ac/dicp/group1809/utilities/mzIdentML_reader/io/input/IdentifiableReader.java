package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Identifiable;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class IdentifiableReader {
	public static void read(XMLStreamReader reader, Identifiable identifiable) {
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "id":
					identifiable.setId(attributeValue);
					break;
				case "name":
					identifiable.setName(attributeValue);
					break;
			}
		}
	}
}
