package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * One (poly)peptide (a sequence with modifications).
 * The combination of Peptide sequence and modifications must be unique in the file.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeptideType", propOrder = {
		"peptideSequence",
		"modification",
		"substitutionModification",
		"paramGroup"
})
public class Peptide extends Identifiable {
	private static final long serialVersionUID = 5563066844443344411L;
	/**
	 * The amino acid sequence of the (poly)peptide.
	 * If a substitution modification has been found, the original sequence should be reported.
	 */
	@XmlElement(name = "PeptideSequence")
	private String peptideSequence;
	@XmlElement(name = "Modification")
	private List<Modification> modification;
	@XmlElement(name = "SubstitutionModification")
	private List<SubstitutionModification> substitutionModification;
	/**
	 * Additional descriptors of this peptide sequence
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;

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

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}
}
