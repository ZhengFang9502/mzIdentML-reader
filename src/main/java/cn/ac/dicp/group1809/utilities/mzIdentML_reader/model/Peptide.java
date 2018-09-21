package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * One (poly)peptide (a sequence with modifications).
 * The combination of Peptide sequence and modifications must be unique in the file.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"peptideSequence",
		"modification",
		"substitutionModification",
		"paramGroupList"
})
public class Peptide extends Identifiable {
	/**
	 * The amino acid sequence of the (poly)peptide.
	 * If a substitution modification has been found, the original sequence should be reported.
	 */
	@XmlElement
	private String peptideSequence;
	@XmlElement(name = "Modification")
	private List<Modification> modification;
	@XmlElement(name = "SubstitutionModification")
	private List<SubstitutionModification> substitutionModification;
	/**
	 * Additional descriptors of this peptide sequence
	 */
	private List<ParamGroup> paramGroupList;

	public String getPeptideSequence() {
		return peptideSequence;
	}

	public void setPeptideSequence(String peptideSequence) {
		if (!peptideSequence.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]*")) {
			throw new IllegalArgumentException("Invalid peptide sequence: " + peptideSequence);
		}
		this.peptideSequence = peptideSequence;
	}

	public List<Modification> getModification() {
		return modification;
	}

	public void setModification(List<Modification> modification) {
		this.modification = modification;
	}

	public List<SubstitutionModification> getSubstitutionModification() {
		return substitutionModification;
	}

	public void setSubstitutionModification(List<SubstitutionModification> substitutionModification) {
		this.substitutionModification = substitutionModification;
	}

	public List<ParamGroup> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<ParamGroup> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}
}
