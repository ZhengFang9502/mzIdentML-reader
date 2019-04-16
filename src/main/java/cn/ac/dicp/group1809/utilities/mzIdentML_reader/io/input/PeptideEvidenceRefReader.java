package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.PeptideEvidenceRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class PeptideEvidenceRefReader {
	private static Logger logger = LoggerFactory.getLogger(PeptideEvidenceRefReader.class);

	public static PeptideEvidenceRef read(XMLStreamReader reader) {
		PeptideEvidenceRef peptideEvidence = new PeptideEvidenceRef();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("peptideEvidence_ref".equals(attributeName)) {
				peptideEvidence.setPeptideEvidence_ref(attributeValue);
			} else {
				logger.error("Invalid attribute name in PeptideEvidenceRef section: " + attributeName);
				throw new IllegalArgumentException("Invalid attribute name in PeptideEvidenceRef section: " + attributeName);
			}
		}
		return peptideEvidence;
	}
}
