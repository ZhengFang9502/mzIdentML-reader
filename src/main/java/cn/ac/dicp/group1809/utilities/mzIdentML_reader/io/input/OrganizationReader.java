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
public class OrganizationReader {
	private static Logger logger = LoggerFactory.getLogger(OrganizationReader.class);

	public static Organization read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Organization organization = new Organization();
		IdentifiableReader.read(reader,organization);
		List<ParamGroup> paramGroups = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "cvParam":
							ParamGroup cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							ParamGroup userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						case "Parent":
							ParentOrganization parentOrganization = ParentOrganizationReader.read(reader);
							organization.setParent(parentOrganization);
							break;
						default:
							logger.error("Invalid local name in Organization section: " + localName);
							throw new IllegalArgumentException("Invalid local name in Organization section: " + localName);
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
		organization.setParamGroupList(paramGroups);
		return organization;
	}
}
