package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * An Analysis which assembles a set of peptides (e.g. from a spectra search analysis) to proteins.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinDetectionType", propOrder = {
		"inputSpectrumIdentifications",
		"proteinDetectionList_ref",
		"proteinDetectionProtocol_ref"
})
public class ProteinDetection extends ProtocolApplication {
	private static final long serialVersionUID = -8544530356275201559L;
	@XmlElement(name = "InputSpectrumIdentifications")
	private List<InputSpectrumIdentifications> inputSpectrumIdentifications;
	/**
	 * A reference to the ProteinDetectionList in the DataCollection section.
	 */
	@XmlAttribute(name = "proteinDetectionList_ref", required = true)
	private String proteinDetectionList_ref;
	/**
	 * A reference to the detection protocol used for this ProteinDetection.
	 */
	@XmlAttribute(name = "proteinDetectionProtocol_ref", required = true)
	private String proteinDetectionProtocol_ref;

	public List<InputSpectrumIdentifications> getInputSpectrumIdentifications() {
		return inputSpectrumIdentifications;
	}

	public void setInputSpectrumIdentifications(List<InputSpectrumIdentifications> inputSpectrumIdentifications) {
		this.inputSpectrumIdentifications = inputSpectrumIdentifications;
	}

	public String getProteinDetectionList_ref() {
		return proteinDetectionList_ref;
	}

	public void setProteinDetectionList_ref(String proteinDetectionList_ref) {
		this.proteinDetectionList_ref = proteinDetectionList_ref;
	}

	public String getProteinDetectionProtocol_ref() {
		return proteinDetectionProtocol_ref;
	}

	public void setProteinDetectionProtocol_ref(String proteinDetectionProtocol_ref) {
		this.proteinDetectionProtocol_ref = proteinDetectionProtocol_ref;
	}
}
