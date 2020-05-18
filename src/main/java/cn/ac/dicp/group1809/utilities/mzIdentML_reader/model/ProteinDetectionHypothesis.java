package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A single result of the ProteinDetection analysis (i.e. a protein).
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinDetectionHypothesisType", propOrder = {
		"peptideHypothesis",
		"paramGroup",
		"dBSequence_ref",
		"passThreshold"
})
public class ProteinDetectionHypothesis extends Identifiable {
	private static final long serialVersionUID = -5847225670406824077L;
	@XmlElement(name = "PeptideHypothesis")
	private List<PeptideHypothesis> peptideHypothesis;
	/**
	 * Scores or parameters associated with this ProteinDetectionHypothesis e.g. p-value
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;
	/**
	 * A reference to the corresponding DBSequence entry.
	 * This optional and redundant, because the PeptideEvidence elements referenced from here also map to the DBSequence.
	 */
	@XmlAttribute(name = "dBSequence_ref")
	private String dBSequence_ref;
	/**
	 * Set to true if the producers of the file has deemed that the ProteinDetectionHypothesis has passed a given threshold or been validated as correct.
	 * If no such threshold has been set, value of true should be given for all results.
	 */
	@XmlAttribute(name = "passThreshold", required = true)
	private boolean passThreshold;

	public List<PeptideHypothesis> getPeptideHypothesis() {
		return peptideHypothesis;
	}

	public void setPeptideHypothesis(List<PeptideHypothesis> peptideHypothesis) {
		this.peptideHypothesis = peptideHypothesis;
	}

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}

	public String getdBSequence_ref() {
		return dBSequence_ref;
	}

	public void setdBSequence_ref(String dBSequence_ref) {
		this.dBSequence_ref = dBSequence_ref;
	}

	public boolean isPassThreshold() {
		return passThreshold;
	}

	public void setPassThreshold(boolean passThreshold) {
		this.passThreshold = passThreshold;
	}
}
