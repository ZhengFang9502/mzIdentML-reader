package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AmbiguousResidue;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.UserParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AmbiguousResidueReader {
	private static Logger logger = LoggerFactory.getLogger(AmbiguousResidueReader.class);

	public static AmbiguousResidue read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AmbiguousResidue ambiguousResidue = new AmbiguousResidue();

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("code".equals(attributeName)) {
				ambiguousResidue.setCode(attributeValue);
			} else {
				logger.error("Invalid attribute name in AmbiguousResidue section: " + attributeName);
				throw new IllegalArgumentException("Invalid attribute name in AmbiguousResidue section: " + attributeName);
			}
		}
		List<AbstractParam> paramGroups = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "cvParam":
							AbstractParam cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							AbstractParam userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						default:
							logger.error("Invalid local name in AmbiguousResidue section: " + localName);
							throw new IllegalArgumentException("Invalid local name in AmbiguousResidue section: " + localName);
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
		ambiguousResidue.setParamGroupList(paramGroups);
		return ambiguousResidue;
	}
}
