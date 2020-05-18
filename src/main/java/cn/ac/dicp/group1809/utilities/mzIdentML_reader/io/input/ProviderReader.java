package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ContactRole;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Provider;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ProviderReader {
	public static Provider read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		Provider provider = new Provider();
		IdentifiableReader.read(reader, provider);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "analysisSoftware_ref":
					provider.setAnalysisSoftware_ref(attributeValue);
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in Provider section: " + attributeName);
			}
		}

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("ContactRole".equals(localName)) {
						ContactRole contactRole = ContactRoleReader.read(reader);
						provider.setContactRole(contactRole);
					} else {
						throw new IllegalArgumentException("Invalid local name in Provider section: " + localName);
					}
					break;
				case XMLStreamReader.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
					break;
			}
		}
		return provider;
	}
}
