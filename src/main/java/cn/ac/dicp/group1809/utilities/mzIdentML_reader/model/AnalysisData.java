package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Data sets generated by the analyses, including peptide and protein lists.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AnalysisData {
	@XmlElement(name = "SpectrumIdentificationList")
	private List<SpectrumIdentificationList> spectrumIdentificationList;
	@XmlElement(name = "ProteinDetectionList")
	private ProteinDetectionList proteinDetectionList;

	public List<SpectrumIdentificationList> getSpectrumIdentificationList() {
		return spectrumIdentificationList;
	}

	public void setSpectrumIdentificationList(List<SpectrumIdentificationList> spectrumIdentificationList) {
		this.spectrumIdentificationList = spectrumIdentificationList;
	}

	public ProteinDetectionList getProteinDetectionList() {
		return proteinDetectionList;
	}

	public void setProteinDetectionList(ProteinDetectionList proteinDetectionList) {
		this.proteinDetectionList = proteinDetectionList;
	}
}
