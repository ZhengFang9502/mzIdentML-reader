package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ExternalData;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ExternalDataReader {
	public static void read(XMLStreamReader reader, ExternalData externalData) {
		IdentifiableReader.read(reader, externalData);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("location".equals(attributeName)) {
				externalData.setLocation(attributeValue);
			}
		}
	}
}
