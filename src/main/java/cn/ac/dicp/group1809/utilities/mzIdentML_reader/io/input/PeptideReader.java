package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Modification;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Peptide;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SubstitutionModification;

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

	public static Peptide read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Peptide peptide = new Peptide();
		IdentifiableReader.read(reader, peptide);

		List<Modification> modifications = new ArrayList<>();
		List<SubstitutionModification> substitutionModifications = new ArrayList<>();
		List<AbstractParam> paramGroup = new ArrayList<>();
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
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
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
		peptide.setParamGroup(paramGroup);
		return peptide;
	}
}
