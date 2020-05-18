package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.DBSequence;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Peptide;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.PeptideEvidence;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SequenceCollection;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SequenceCollectionReader {
	public static SequenceCollection read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		SequenceCollection sequenceCollection = new SequenceCollection();
		List<DBSequence> dbSequences = new ArrayList<>();
		List<Peptide> peptides = new ArrayList<>();
		List<PeptideEvidence> peptideEvidences = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "DBSequence":
							DBSequence dbSequence = DBSequenceReader.read(reader);
							dbSequences.add(dbSequence);
							break;
						case "Peptide":
							Peptide peptide = PeptideReader.read(reader);
							peptides.add(peptide);
							break;
						case "PeptideEvidence":
							PeptideEvidence peptideEvidence = PeptideEvidenceReader.read(reader);
							peptideEvidences.add(peptideEvidence);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in SequenceCollection section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		sequenceCollection.setDbSequence(dbSequences);
		sequenceCollection.setPeptide(peptides);
		sequenceCollection.setPeptideEvidence(peptideEvidences);
		return sequenceCollection;
	}
}
