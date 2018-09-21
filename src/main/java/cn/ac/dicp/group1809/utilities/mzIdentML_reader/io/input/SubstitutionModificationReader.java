package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SubstitutionModification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SubstitutionModificationReader {
	private static Logger logger = LoggerFactory.getLogger(SubstitutionModificationReader.class);

	public static SubstitutionModification read(XMLStreamReader reader) {
		SubstitutionModification substitutionModification = new SubstitutionModification();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "originalResidue":
					substitutionModification.setOriginalResidue(attributeValue);
					break;
				case "replacementResidue":
					substitutionModification.setReplacementResidue(attributeValue);
					break;
				case "location":
					substitutionModification.setLocation(Integer.valueOf(attributeValue));
					break;
				case "avgMassDelta":
					substitutionModification.setAvgMassDelta(Double.valueOf(attributeValue));
					break;
				case "monoisotopicMassDelta":
					substitutionModification.setMonoisotopicMassDelta(Double.valueOf(attributeValue));
					break;
				default:
					logger.error("Invalid attribute name in SubstitutionModification section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in SubstitutionModification section: " + attributeName);
			}
		}
		return substitutionModification;
	}
}
