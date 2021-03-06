package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Specification of a search modification as parameter for a spectra search.
 * Contains the name of the modification, the mass, the specificity and whether it is a static modification.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlType(propOrder = {
		"specificityRules",
		"cvParam",
		"fixedMod",
		"massDelta",
		"residues"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchModification {
	@XmlElement(name = "SpecificityRules")
	private List<SpecificityRules> specificityRules;
	/**
	 * The modification is uniquely identified by references to external CVs such as UNIMOD, see specification document and mapping file for more details.
	 */
	@XmlElement(name = "cvParam")
	private List<CVParam> cvParam;
	/**
	 * True, if the modification is static (i.e. occurs always).
	 */
	@XmlAttribute(name = "fixedMod", required = true)
	private boolean fixedMod;
	/**
	 * The mass delta of the searched modification in Daltons.
	 */
	@XmlAttribute(name = "massDelta", required = true)
	private double massDelta;
	/**
	 * The residue(s) searched with the specified modification.
	 * For N or C terminal modifications that can occur on any residue, the . character should be used to specify any, otherwise the list of amino acids should be provided.
	 */
	@XmlAttribute(name = "residues", required = true)
	private String residues;

	public List<SpecificityRules> getSpecificityRules() {
		return specificityRules;
	}

	public void setSpecificityRules(List<SpecificityRules> specificityRules) {
		this.specificityRules = specificityRules;
	}

	public List<CVParam> getCvParam() {
		return cvParam;
	}

	public void setCvParam(List<CVParam> cvParam) {
		this.cvParam = cvParam;
	}

	public boolean isFixedMod() {
		return fixedMod;
	}

	public void setFixedMod(boolean fixedMod) {
		this.fixedMod = fixedMod;
	}

	public double getMassDelta() {
		return massDelta;
	}

	public void setMassDelta(double massDelta) {
		this.massDelta = massDelta;
	}

	public String getResidues() {
		return residues;
	}

	public void setResidues(String residues) {
		if (!residues.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ.]*")) {
			throw new IllegalArgumentException("Invalid residues: " + residues);
		}
		this.residues = residues;
	}
}
