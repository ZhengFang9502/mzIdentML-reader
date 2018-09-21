package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * A modification where one residue is substituted by another (amino acid change).
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"originalResidue",
		"replacementResidue",
		"location",
		"avgMassDelta",
		"monoisotopicMassDelta"
})
public class SubstitutionModification {
	/**
	 * The original residue before replacement.
	 */
	@XmlAttribute(required = true)
	private String originalResidue;
	/**
	 * The residue that replaced the originalResidue.
	 */
	@XmlAttribute(required = true)
	private String replacementResidue;

	/**
	 * Location of the modification within the peptide - position in peptide sequence, counted from the N-terminus residue, starting at position 1.
	 * Specific modifications to the N-terminus should be given the location 0.
	 * Modification to the C-terminus should be given as peptide length + 1.
	 */
	@XmlAttribute
	private int location;

	/**
	 * Atomic mass delta considering the natural distribution of isotopes in Daltons.
	 * This should only be reported if the original amino acid is known i.e. it is not "X"
	 */
	@XmlAttribute
	private double avgMassDelta;

	/**
	 * Atomic mass delta when assuming only the most common isotope of elements in Daltons.
	 * This should only be reported if the original amino acid is known i.e. it is not "X"
	 */
	@XmlAttribute
	private double monoisotopicMassDelta;


	public String getOriginalResidue() {
		return originalResidue;
	}

	public void setOriginalResidue(String originalResidue) {
		if (!originalResidue.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ?\\-]")) {
			throw new IllegalArgumentException("Invalid residue: " + originalResidue);
		}
		this.originalResidue = originalResidue;
	}

	public String getReplacementResidue() {
		return replacementResidue;
	}

	public void setReplacementResidue(String replacementResidue) {
		if (!replacementResidue.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ?\\-]")) {
			throw new IllegalArgumentException("Invalid residue: " + replacementResidue);
		}
		this.replacementResidue = replacementResidue;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public double getAvgMassDelta() {
		return avgMassDelta;
	}

	public void setAvgMassDelta(double avgMassDelta) {
		this.avgMassDelta = avgMassDelta;
	}

	public double getMonoisotopicMassDelta() {
		return monoisotopicMassDelta;
	}

	public void setMonoisotopicMassDelta(double monoisotopicMassDelta) {
		this.monoisotopicMassDelta = monoisotopicMassDelta;
	}
}
