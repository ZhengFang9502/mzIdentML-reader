package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The collection of sequences (DBSequence or Peptide) identified and their relationship between each other (PeptideEvidence) to be referenced elsewhere in the results.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"dbSequence",
		"peptide",
		"peptideEvidence",
})
public class SequenceCollection {
	@XmlElement(name = "DBSequence")
	private List<DBSequence> dbSequence;
	@XmlElement(name = "Peptide")
	private List<Peptide> peptide;
	@XmlElement(name = "PeptideEvidence")
	private List<PeptideEvidence> peptideEvidence;

	public List<DBSequence> getDbSequence() {
		return dbSequence;
	}

	public void setDbSequence(List<DBSequence> dbSequence) {
		this.dbSequence = dbSequence;
	}

	public List<Peptide> getPeptide() {
		return peptide;
	}

	public void setPeptide(List<Peptide> peptide) {
		this.peptide = peptide;
	}

	public List<PeptideEvidence> getPeptideEvidence() {
		return peptideEvidence;
	}

	public void setPeptideEvidence(List<PeptideEvidence> peptideEvidence) {
		this.peptideEvidence = peptideEvidence;
	}
}
