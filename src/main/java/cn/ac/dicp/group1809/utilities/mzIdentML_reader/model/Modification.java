package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * A molecule modification specification.
 * If n modifications have been found on a peptide, there should be n instances of Modification.
 * If multiple modifications are provided as cvParams, it is assumed that the modification is ambiguous i.e. one modification or another.
 * A cvParam must be provided with the identification of the modification sourced from a suitable CV e.g. UNIMOD.
 * If the modification is not present in the CV (and this will be checked by the semantic validator within a given tolerance window), there is a â€œunknown modificationâ€ CV term that must be used instead.
 * A neutral loss should be defined as an additional CVParam within Modification.
 * If more complex information should be given about neutral losses (such as presence/absence on particular product ions), this can additionally be encoded within the FragmentationArray.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModificationType", propOrder = {
		"cvParam",
		"location",
		"residues",
		"avgMassDelta",
		"monoisotopicMassDelta"
})
public class Modification implements Serializable {
	private static final long serialVersionUID = 3728862379768008150L;
	/**
	 * CV terms capturing the modification, sourced from an appropriate controlled vocabulary.
	 */
	@XmlElement(name = "cvParam")
	private List<CVParam> cvParam;
	/**
	 * Location of the modification within the peptide - position in peptide sequence, counted from the N-terminus residue, starting at position 1.
	 * Specific modifications to the N-terminus should be given the location 0.
	 * Modification to the C-terminus should be given as peptide length + 1.
	 * If the modification location is unknown e.g. for PMF data, this attribute should be omitted.
	 */
	@XmlAttribute(name = "location")
	private Integer location;
	/**
	 * Specification of the residue (amino acid) on which the modification occurs.
	 * If multiple values are given, it is assumed that the exact residue modified is unknown i.e. the modification is to ONE of the residues listed.
	 * Multiple residues would usually only be specified for PMF data.
	 */
	@XmlAttribute(name = "residues")
	private String residues;
	/**
	 * Atomic mass delta considering the natural distribution of isotopes in Daltons.
	 */
	@XmlAttribute(name = "avgMassDelta")
	private Double avgMassDelta;
	/**
	 * Atomic mass delta when assuming only the most common isotope of elements in Daltons.
	 */
	@XmlAttribute(name = "monoisotopicMassDelta")
	private Double monoisotopicMassDelta;

	public List<CVParam> getCvParam() {
		return cvParam;
	}

	public void setCvParam(List<CVParam> cvParam) {
		this.cvParam = cvParam;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public String getResidues() {
		return residues;
	}

	public void setResidues(String residues) {
		if (!residues.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]*")) {
			throw new IllegalArgumentException("Invalid residues: " + residues);
		}
		this.residues = residues;
	}

	public Double getAvgMassDelta() {
		return avgMassDelta;
	}

	public void setAvgMassDelta(Double avgMassDelta) {
		this.avgMassDelta = avgMassDelta;
	}

	public Double getMonoisotopicMassDelta() {
		return monoisotopicMassDelta;
	}

	public void setMonoisotopicMassDelta(Double monoisotopicMassDelta) {
		this.monoisotopicMassDelta = monoisotopicMassDelta;
	}
}
