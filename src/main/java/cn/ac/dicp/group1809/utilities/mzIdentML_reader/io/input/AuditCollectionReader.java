package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AuditCollectionReader {
	private static Logger logger = LoggerFactory.getLogger(AuditCollectionReader.class);

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
							logger.error("Invalid local name in AuditCollection section: " + localName);
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
		auditCollection.setAuditCollection(audits);
		return auditCollection;
	}
}
