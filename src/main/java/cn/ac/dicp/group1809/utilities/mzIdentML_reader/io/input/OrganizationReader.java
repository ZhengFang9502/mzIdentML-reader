package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Organization;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParentOrganization;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class OrganizationReader {

	public static Organization read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Organization organization = new Organization();
		IdentifiableReader.read(reader, organization);
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
						case "Parent":
							ParentOrganization parentOrganization = ParentOrganizationReader.read(reader);
							organization.setParent(parentOrganization);
							break;
						default:
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
		organization.setParamGroup(paramGroup);
		return organization;
	}
}
