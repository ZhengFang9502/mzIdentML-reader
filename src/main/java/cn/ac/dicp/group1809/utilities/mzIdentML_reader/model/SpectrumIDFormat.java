package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * The format of the spectrum identifier within the source file
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SpectrumIDFormat {
	/**
	 * CV term capturing the type of identifier used.
	 */
	@XmlElement(name = "cvParam")
	private CVParam cvParam;

	public CVParam getCvParam() {
		return cvParam;
	}

	public void setCvParam(CVParam cvParam) {
		this.cvParam = cvParam;
	}
}
