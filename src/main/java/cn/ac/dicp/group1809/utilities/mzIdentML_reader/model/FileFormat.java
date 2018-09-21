package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * The format of the ExternalData file, for example "tiff" for image files.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FileFormat {
	/**
	 * cvParam capturing file formats
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
