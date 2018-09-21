package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class PeptideReader {
	private static Logger logger = LoggerFactory.getLogger(PeptideReader.class);

	public static Peptide read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Peptide peptide = new Peptide();
		IdentifiableReader.read(reader, peptide);

		List<Modification> modifications = new ArrayList<>();
		List<SubstitutionModification> substitutionModifications = new ArrayList<>();
		List<ParamGroup> paramGroups = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "PeptideSequence":
							String peptideSequence = reader.getElementText();
							peptide.setPeptideSequence(peptideSequence);
							break;
						case "Modification":
							Modification modification = ModificationReader.read(reader);
							modifications.add(modification);
							break;
						case "SubstitutionModification":
							SubstitutionModification substitutionModification = SubstitutionModificationReader.read(reader);
							substitutionModifications.add(substitutionModification);
							break;
						case "cvParam":
							ParamGroup cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							ParamGroup userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						default:
							logger.error("Invalid local name in Peptide section: " + localName);
							throw new IllegalArgumentException("Invalid local name in Peptide section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		peptide.setModification(modifications);
		peptide.setSubstitutionModification(substitutionModifications);
		peptide.setParamGroupList(paramGroups);
		return peptide;
	}
}
