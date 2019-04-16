package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ProteinDetectionHypothesisReader {
	private static Logger logger = LoggerFactory.getLogger(ProteinDetectionHypothesisReader.class);

	public static ProteinDetectionHypothesis read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ProteinDetectionHypothesis proteinDetectionHypothesis = new ProteinDetectionHypothesis();
		IdentifiableReader.read(reader, proteinDetectionHypothesis);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "dBSequence_ref":
					proteinDetectionHypothesis.setdBSequence_ref(attributeValue);
					break;
				case "passThreshold":
					proteinDetectionHypothesis.setPassThreshold(attributeValue.equals("true"));
					break;
				case "id":
				case "name":
					break;
				default:
					logger.error("Invalid attribute name in ProteinDetectionHypothesis section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in ProteinDetectionHypothesis section: " + attributeName);
			}
		}

		List<PeptideHypothesis> peptideHypotheses = new ArrayList<>();
		List<AbstractParam> paramGroups = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "PeptideHypothesis":
							PeptideHypothesis peptideHypothesis = PeptideHypothesisReader.read(reader);
							peptideHypotheses.add(peptideHypothesis);
							break;
						case "cvParam":
							AbstractParam cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							AbstractParam userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						default:
							logger.error("Invalid local name in ProteinDetectionHypothesis section: " + localName);
							throw new IllegalArgumentException("Invalid local name in ProteinDetectionHypothesis section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		proteinDetectionHypothesis.setPeptideHypothesis(peptideHypotheses);
		proteinDetectionHypothesis.setParamGroupList(paramGroups);
		return proteinDetectionHypothesis;
	}
}
