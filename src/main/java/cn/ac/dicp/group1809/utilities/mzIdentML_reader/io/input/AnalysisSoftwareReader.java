package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisSoftware;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ContactRole;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Param;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.net.URI;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AnalysisSoftwareReader {
	private static Logger logger = LoggerFactory.getLogger(AnalysisSoftwareReader.class);

	public static AnalysisSoftware read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AnalysisSoftware analysisSoftware = new AnalysisSoftware();
		IdentifiableReader.read(reader, analysisSoftware);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "version":
					analysisSoftware.setVersion(attributeValue);
					break;
				case "uri":
					URI uri = new UriAdapter().unmarshal(attributeValue);
					analysisSoftware.setUri(uri);
					break;
				case "id":
				case "name":
					break;
				default:
					logger.error("Invalid attribute name in AnalysisSoftware section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in AnalysisSoftware section: " + attributeName);
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
						case "ContactRole":
							ContactRole contactRole = ContactRoleReader.read(reader);
							analysisSoftware.setContactRole(contactRole);
							break;
						case "SoftwareName":
							Param softwareName = ParamReader.read(reader);
							analysisSoftware.setSoftwareName(softwareName);
							break;
						case "Customizations":
							String customizations = reader.getElementText();
							analysisSoftware.setCustomizations(customizations);
							break;
						default:
							logger.error("Invalid local name in AnalysisSoftware section: " + localName);
							throw new IllegalArgumentException("Invalid local name in AnalysisSoftware section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		return analysisSoftware;
	}
}
