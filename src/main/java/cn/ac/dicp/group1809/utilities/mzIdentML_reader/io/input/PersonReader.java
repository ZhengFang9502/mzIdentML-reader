package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Affiliation;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Person;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class PersonReader {
	public static Person read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		Person person = new Person();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);

		IdentifiableReader.read(reader, person);

		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "lastName":
					person.setLastName(attributeValue);
					break;
				case "firstName":
					person.setFirstName(attributeValue);
					break;
				case "midInitials":
					person.setMidInitials(attributeValue);
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in Person section: " + attributeName);
			}
		}

		List<Affiliation> affiliations = new ArrayList<>();
		List<AbstractParam> paramGroup = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "cvParam":
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						case "Affiliation":
							Affiliation affiliation = AffiliationReader.read(reader);
							affiliations.add(affiliation);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in Person section: " + localName);
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
		person.setAffiliation(affiliations);
		person.setParamGroup(paramGroup);
		return person;
	}
}
