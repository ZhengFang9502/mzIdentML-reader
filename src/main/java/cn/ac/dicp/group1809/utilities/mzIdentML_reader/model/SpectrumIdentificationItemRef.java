package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Reference(s) to the SpectrumIdentificationItem element(s) that support the given PeptideEvidence element.
 * Using these references it is possible to indicate which spectra were actually accepted as evidence for this peptide identification in the given protein.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectrumIdentificationItemRefType", propOrder = {
		"spectrumIdentificationItem_ref"
})
public class SpectrumIdentificationItemRef implements Serializable {
	private static final long serialVersionUID = -5046829663191916141L;
	/**
	 * A reference to the SpectrumIdentificationItem element(s).
	 */
	@XmlAttribute(name = "spectrumIdentificationItem_ref", required = true)
	private String spectrumIdentificationItem_ref;

	public String getSpectrumIdentificationItem_ref() {
		return spectrumIdentificationItem_ref;
	}

	public void setSpectrumIdentificationItem_ref(String spectrumIdentificationItem_ref) {
		this.spectrumIdentificationItem_ref = spectrumIdentificationItem_ref;
	}
}
