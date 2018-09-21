package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The roles (lab equipment sales, contractor, etc.) the Contact fills.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "role")
public class Role {
	/**
	 * CV term for contact roles, such as software provider.
	 */
	@XmlElement
	private CVParam cvParam;

	public CVParam getCvParam() {
		return cvParam;
	}

	public void setCvParam(CVParam cvParam) {
		this.cvParam = cvParam;
	}
}
