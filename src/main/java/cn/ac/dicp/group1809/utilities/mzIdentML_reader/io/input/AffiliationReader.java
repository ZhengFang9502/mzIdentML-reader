package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Affiliation;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AffiliationReader {
	public static Affiliation read(XMLStreamReader reader) {
		Affiliation affiliation = new Affiliation();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("organization_ref".equals(attributeName)) {
				affiliation.setOrganization_ref(attributeValue);
			} else {
				throw new IllegalArgumentException("Invalid attribute name in Affiliation section: " + attributeName);
			}
		}
		return affiliation;
	}
}
