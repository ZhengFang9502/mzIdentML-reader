package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * The lists of spectrum identifications that are input to the protein detection process.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InputSpectrumIdentifications {
	/**
	 * A reference to the list of spectrum identifications that were input to the process.
	 */
	@XmlAttribute(name = "spectrumIdentificationList_ref", required = true)
	private String spectrumIdentificationList_ref;

	public String getSpectrumIdentificationList_ref() {
		return spectrumIdentificationList_ref;
	}

	public void setSpectrumIdentificationList_ref(String spectrumIdentificationList_ref) {
		this.spectrumIdentificationList_ref = spectrumIdentificationList_ref;
	}
}
