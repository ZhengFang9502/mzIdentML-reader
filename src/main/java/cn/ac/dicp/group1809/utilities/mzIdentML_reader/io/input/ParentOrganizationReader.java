package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParentOrganization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ParentOrganizationReader {
	private static Logger logger = LoggerFactory.getLogger(ParentOrganizationReader.class);

	public static ParentOrganization read(XMLStreamReader reader) {
		ParentOrganization parentOrganization = new ParentOrganization();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "organization_ref":
					parentOrganization.setOrganization_ref(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in ParentOrganization section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in ParentOrganization section: " + attributeName);
			}
		}
		return parentOrganization;
	}
}
