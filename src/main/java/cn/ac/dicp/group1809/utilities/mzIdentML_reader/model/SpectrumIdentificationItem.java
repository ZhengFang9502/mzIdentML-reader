package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * An identification of a single (poly)peptide, resulting from querying an input spectra, along with the set of confidence values for that identification.
 * PeptideEvidence elements should be given for all mappings of the corresponding Peptide sequence within protein sequences.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlType(propOrder = {
		"peptideEvidenceRef",
		"fragmentation",
		"paramGroupList",
		"chargeState",
		"experimentalMassToCharge",
		"calculatedMassToCharge",
		"calculatedPI",
		"peptide_ref",
		"rank",
		"passThreshold",
		"massTable_ref",
		"sample_ref",
})
@XmlAccessorType(XmlAccessType.FIELD)
public class SpectrumIdentificationItem extends Identifiable {
	@XmlElement(name = "PeptideEvidenceRef")
	private List<PeptideEvidenceRef> peptideEvidenceRef;
	@XmlElement(name = "Fragmentation")
	private Fragmentation fragmentation;
	/**
	 * Scores or attributes associated with the SpectrumIdentificationItem e.g. e-value, p-value, score.
	 */
	private List<ParamGroup> paramGroupList;
	/**
	 * The charge state of the identified peptide.
	 */
	@XmlAttribute(name = "chargeState", required = true)
	private int chargeState;
	/**
	 * The mass-to-charge value measured in the experiment in Daltons / charge.
	 */
	@XmlAttribute(name = "experimentalMassToCharge", required = true)
	private double experimentalMassToCharge;
	/**
	 * The theoretical mass-to-charge value calculated for the peptide in Daltons / charge.
	 */
	@XmlAttribute(name = "calculatedMassToCharge")
	private double calculatedMassToCharge;
	/**
	 * The calculated isoelectric point of the (poly)peptide, with relevant modifications included.
	 * Do not supply this value if the PI cannot be calcuated properly.
	 */
	@XmlAttribute(name = "calculatedPI")
	private float calculatedPI;
	/**
	 * A reference to the identified (poly)peptide sequence in the Peptide element.
	 */
	@XmlAttribute(name = "peptide_ref")
	private String peptide_ref;
	/**
	 * For an MS/MS result set, this is the rank of the identification quality as scored by the search engine. 1 is the top rank.
	 * If multiple identifications have the same top score, they should all be assigned rank =1.
	 * For PMF data, the rank attribute may be meaningless and values of rank = 0 should be given.
	 */
	@XmlAttribute(name = "rank", required = true)
	private int rank;
	/**
	 * Set to true if the producers of the file has deemed that the identification has passed a given threshold or been validated as correct.
	 * If no such threshold has been set, value of true should be given for all results.
	 */
	@XmlAttribute(name = "passThreshold", required = true)
	private boolean passThreshold;
	/**
	 * A reference should be given to the MassTable used to calculate the sequenceMass only if more than one MassTable has been given.
	 */
	@XmlAttribute(name = "massTable_ref", required = true)
	private String massTable_ref;
	/**
	 * A reference should be provided to link the SpectrumIdentificationItem to a Sample if more than one sample has been described in the AnalysisSampleCollection.
	 */
	@XmlAttribute(name = "sample_ref", required = true)
	private String sample_ref;

	public List<PeptideEvidenceRef> getPeptideEvidenceRef() {
		return peptideEvidenceRef;
	}

	public void setPeptideEvidenceRef(List<PeptideEvidenceRef> peptideEvidenceRef) {
		this.peptideEvidenceRef = peptideEvidenceRef;
	}

	public Fragmentation getFragmentation() {
		return fragmentation;
	}

	public void setFragmentation(Fragmentation fragmentation) {
		this.fragmentation = fragmentation;
	}

	public List<ParamGroup> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<ParamGroup> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}

	public int getChargeState() {
		return chargeState;
	}

	public void setChargeState(int chargeState) {
		this.chargeState = chargeState;
	}

	public double getExperimentalMassToCharge() {
		return experimentalMassToCharge;
	}

	public void setExperimentalMassToCharge(double experimentalMassToCharge) {
		this.experimentalMassToCharge = experimentalMassToCharge;
	}

	public double getCalculatedMassToCharge() {
		return calculatedMassToCharge;
	}

	public void setCalculatedMassToCharge(double calculatedMassToCharge) {
		this.calculatedMassToCharge = calculatedMassToCharge;
	}

	public float getCalculatedPI() {
		return calculatedPI;
	}

	public void setCalculatedPI(float calculatedPI) {
		this.calculatedPI = calculatedPI;
	}

	public String getPeptide_ref() {
		return peptide_ref;
	}

	public void setPeptide_ref(String peptide_ref) {
		this.peptide_ref = peptide_ref;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public boolean isPassThreshold() {
		return passThreshold;
	}

	public void setPassThreshold(boolean passThreshold) {
		this.passThreshold = passThreshold;
	}

	public String getMassTable_ref() {
		return massTable_ref;
	}

	public void setMassTable_ref(String massTable_ref) {
		this.massTable_ref = massTable_ref;
	}

	public String getSample_ref() {
		return sample_ref;
	}

	public void setSample_ref(String sample_ref) {
		this.sample_ref = sample_ref;
	}
}
