package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Peptide evidence on which this ProteinHypothesis is based by reference to a PeptideEvidence element.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder ={
		"spectrumIdentificationItemRef",
		"peptideEvidence_ref"
})
public class PeptideHypothesis {
	@XmlElement(name = "SpectrumIdentificationItemRef")
	private List<SpectrumIdentificationItemRef> spectrumIdentificationItemRef;
	@XmlAttribute(name = "peptideEvidence_ref", required = true)
	private String peptideEvidence_ref;

	public List<SpectrumIdentificationItemRef> getSpectrumIdentificationItemRef() {
		return spectrumIdentificationItemRef;
	}

	public void setSpectrumIdentificationItemRef(List<SpectrumIdentificationItemRef> spectrumIdentificationItemRef) {
		this.spectrumIdentificationItemRef = spectrumIdentificationItemRef;
	}

	public String getPeptideEvidence_ref() {
		return peptideEvidence_ref;
	}

	public void setPeptideEvidence_ref(String peptideEvidence_ref) {
		this.peptideEvidence_ref = peptideEvidence_ref;
	}
}
