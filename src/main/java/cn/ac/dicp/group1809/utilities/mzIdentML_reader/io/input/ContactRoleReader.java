package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ContactRole;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ContactRoleReader {
	private static Logger logger = LoggerFactory.getLogger(ContactRoleReader.class);

	public static ContactRole read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ContactRole contactRole = new ContactRole();

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "contact_ref":
					contactRole.setContact_ref(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in ContactRole section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in ContactRole section: " + attributeName);
			}
		}

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "Role":
							Role role = RoleReader.read(reader);
							contactRole.setRole(role);
							break;
						default:
							logger.error("Invalid local name in ContactRole section: " + localName);
							throw new IllegalArgumentException("Invalid local name in ContactRole section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		return contactRole;
	}
}
