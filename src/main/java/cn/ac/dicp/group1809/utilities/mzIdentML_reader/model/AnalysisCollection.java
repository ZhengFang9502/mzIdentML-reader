package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * The analyses performed to get the results, which map the input and output data sets. Analyses are for example:
 * SpectrumIdentification (resulting in peptides) or ProteinDetection (assemble proteins from peptides).
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalysisCollectionType", propOrder = {
		"spectrumIdentification",
		"proteinDetection"
})
public class AnalysisCollection implements Serializable {
	private static final long serialVersionUID = 7241068863163027000L;
	@XmlElement(name = "SpectrumIdentification")
	private List<SpectrumIdentification> spectrumIdentification;
	@XmlElement(name = "ProteinDetection")
	private ProteinDetection proteinDetection;

	public List<SpectrumIdentification> getSpectrumIdentification() {
		return spectrumIdentification;
	}

	public void setSpectrumIdentification(List<SpectrumIdentification> spectrumIdentification) {
		this.spectrumIdentification = spectrumIdentification;
	}

	public ProteinDetection getProteinDetection() {
		return proteinDetection;
	}

	public void setProteinDetection(ProteinDetection proteinDetection) {
		this.proteinDetection = proteinDetection;
	}
}
