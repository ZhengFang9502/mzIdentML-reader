package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractContact;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AuditCollection;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Organization;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Person;

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AuditCollectionReader {
	public static AuditCollection read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AuditCollection auditCollection = new AuditCollection();
		List<AbstractContact> audits = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "Person":
							Person person = PersonReader.read(reader);
							audits.add(person);
							break;
						case "Organization":
							Organization organization = OrganizationReader.read(reader);
							audits.add(organization);
							break;
						default:
							Location location = reader.getLocation();
							out.println(location.getLineNumber());
							throw new IllegalArgumentException("Invalid local name in AuditCollection section: " + localName);
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
		auditCollection.setContactList(audits);
		return auditCollection;
	}
}
