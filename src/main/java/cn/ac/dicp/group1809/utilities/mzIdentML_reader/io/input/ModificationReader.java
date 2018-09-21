package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Modification;
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
public class ModificationReader {
	private static Logger logger = LoggerFactory.getLogger(ModificationReader.class);

	public static Modification read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Modification modification = new Modification();
		List<CVParam> cvParamList = new ArrayList<>();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "location":
					modification.setLocation(Integer.valueOf(attributeValue));
					break;
				case "residues":
					modification.setResidues(attributeValue);
					break;
				case "avgMassDelta":
					modification.setAvgMassDelta(Double.valueOf(attributeValue));
					break;
				case "monoisotopicMassDelta":
					modification.setMonoisotopicMassDelta(Double.valueOf(attributeValue));
					break;
				default:
					logger.error("Invalid attribute name in Modification section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in Modification section: " + attributeName);
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
						case "cvParam":
							CVParam cvParam = CVParamReader.read(reader);
							cvParamList.add(cvParam);
							break;
						default:
							logger.error("Invalid local name in Modification section: " + localName);
							throw new IllegalArgumentException("Invalid local name in Modification section: " + localName);
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
		modification.setCvParam(cvParamList);
		return modification;
	}
}
