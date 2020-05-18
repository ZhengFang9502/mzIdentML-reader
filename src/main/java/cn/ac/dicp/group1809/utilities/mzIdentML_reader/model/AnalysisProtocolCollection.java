package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * The collection of protocols which include the parameters and settings of the performed analyses.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalysisProtocolCollectionType")
public class AnalysisProtocolCollection implements Serializable {
	private static final long serialVersionUID = -8562458998357800795L;
	@XmlElement(name = "SpectrumIdentificationProtocol")
	private List<SpectrumIdentificationProtocol> spectrumIdentificationProtocol;
	@XmlElement(name = "ProteinDetectionProtocol")
	private ProteinDetectionProtocol proteinDetectionProtocol;

	public List<SpectrumIdentificationProtocol> getSpectrumIdentificationProtocol() {
		return spectrumIdentificationProtocol;
	}

	public void setSpectrumIdentificationProtocol(List<SpectrumIdentificationProtocol> spectrumIdentificationProtocol) {
		this.spectrumIdentificationProtocol = spectrumIdentificationProtocol;
	}

	public ProteinDetectionProtocol getProteinDetectionProtocol() {
		return proteinDetectionProtocol;
	}

	public void setProteinDetectionProtocol(ProteinDetectionProtocol proteinDetectionProtocol) {
		this.proteinDetectionProtocol = proteinDetectionProtocol;
	}
}
