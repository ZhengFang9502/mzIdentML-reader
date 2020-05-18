package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.PeptideHypothesis;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationItemRef;

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
public class PeptideHypothesisReader {
	public static PeptideHypothesis read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		PeptideHypothesis peptideHypothesis = new PeptideHypothesis();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("peptideEvidence_ref".equals(attributeName)) {
				peptideHypothesis.setPeptideEvidence_ref(attributeValue);
			} else {
				throw new IllegalArgumentException("Invalid attribute name in PeptideHypothesis section: " + attributeName);
			}
		}

		List<SpectrumIdentificationItemRef> spectrumIdentificationItemRefs = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("SpectrumIdentificationItemRef".equals(localName)) {
						SpectrumIdentificationItemRef spectrumIdentificationItemRef = SpectrumIdentificationItemRefReader.read(reader);
						spectrumIdentificationItemRefs.add(spectrumIdentificationItemRef);
					} else {
						throw new IllegalArgumentException("Invalid local name in PeptideHypothesis section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		peptideHypothesis.setSpectrumIdentificationItemRef(spectrumIdentificationItemRefs);
		return peptideHypothesis;
	}
}
