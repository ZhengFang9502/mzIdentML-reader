package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AllowedFrame;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.PeptideEvidence;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class PeptideEvidenceReader {
	public static PeptideEvidence read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		PeptideEvidence peptideEvidence = new PeptideEvidence();
		IdentifiableReader.read(reader, peptideEvidence);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "dBSequence_ref":
					peptideEvidence.setdBSequence_ref(attributeValue);
					break;
				case "peptide_ref":
					peptideEvidence.setPeptide_ref(attributeValue);
					break;
				case "start":
					peptideEvidence.setStart(Integer.valueOf(attributeValue));
					break;
				case "end":
					peptideEvidence.setEnd(Integer.valueOf(attributeValue));
					break;
				case "pre":
					peptideEvidence.setPre(attributeValue);
					break;
				case "post":
					peptideEvidence.setPost(attributeValue);
					break;
				case "translationTable_ref":
					peptideEvidence.setTranslationTable_ref(attributeValue);
					break;
				case "frame":
					peptideEvidence.setFrame(AllowedFrame.forAllowedFrame(Integer.valueOf(attributeValue)));
					break;
				case "isDecoy":
					peptideEvidence.setDecoy(Boolean.valueOf(attributeValue));
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in PeptideEvidence section: " + attributeName);
			}
		}

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
						default:
							throw new IllegalArgumentException("Invalid local name in PeptideEvidence section: " + localName);
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
		peptideEvidence.setParamGroup(paramGroup);
		return peptideEvidence;
	}
}
