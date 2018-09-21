package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
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
public class PeptideEvidenceReader {
	private static Logger logger = LoggerFactory.getLogger(PeptideEvidenceReader.class);

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
					peptideEvidence.setDecoy(attributeValue.equals("true"));
					break;
				case "id":
				case "name":
					break;
				default:
					logger.error("Invalid attribute name in PeptideEvidence section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in PeptideEvidence section: " + attributeName);
			}
		}

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
						default:
							logger.error("Invalid local name in PeptideEvidence section: " + localName);
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
		peptideEvidence.setParamGroupList(paramGroups);
		return peptideEvidence;
	}
}
