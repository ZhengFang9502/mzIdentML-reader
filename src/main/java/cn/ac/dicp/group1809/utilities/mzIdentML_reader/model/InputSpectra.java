package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * The attribute referencing an identifier within the SpectraData section.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputSpectraType", propOrder = {
		"spectraData_ref"
})
public class InputSpectra implements Serializable {
	private static final long serialVersionUID = 6213237859856049805L;
	/**
	 * A reference to the SpectraData element which locates the input spectra to an external file.
	 */
	@XmlAttribute(name = "spectraData_ref")
	private String spectraData_ref;

	public String getSpectraData_ref() {
		return spectraData_ref;
	}

	public void setSpectraData_ref(String spectraData_ref) {
		this.spectraData_ref = spectraData_ref;
	}
}
