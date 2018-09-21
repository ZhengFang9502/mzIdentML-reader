package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;

/**
 * The parameters and settings of a ProteinDetection process.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"analysisParams",
		"threshold",
		"analysisSoftware_ref",
})
public class ProteinDetectionProtocol extends Identifiable {
	/**
	 * The parameters and settings for the protein detection given as CV terms.
	 */
	@XmlElement(name = "AnalysisParams")
	private ParamList analysisParams;
	/**
	 * The threshold(s) applied to determine that a result is significant.
	 * If multiple terms are used it is assumed that all conditions are satisfied by the passing results.
	 */
	@XmlElement(name = "Threshold")
	private ParamList threshold;
	/**
	 * The protein detection software used, given as a reference to the SoftwareCollection section.
	 */
	@XmlAttribute(name = "analysisSoftware_ref", required = true)
	private String analysisSoftware_ref;

	public ParamList getAnalysisParams() {
		return analysisParams;
	}

	public void setAnalysisParams(ParamList analysisParams) {
		this.analysisParams = analysisParams;
	}

	public ParamList getThreshold() {
		return threshold;
	}

	public void setThreshold(ParamList threshold) {
		this.threshold = threshold;
	}

	public String getAnalysisSoftware_ref() {
		return analysisSoftware_ref;
	}

	public void setAnalysisSoftware_ref(String analysisSoftware_ref) {
		this.analysisSoftware_ref = analysisSoftware_ref;
	}
}
