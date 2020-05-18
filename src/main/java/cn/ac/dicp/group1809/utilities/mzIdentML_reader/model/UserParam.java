package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * A single user-defined parameter.
 *
 * @author ZhengFang 2018/8/20
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserParam", propOrder = {
		"type"
})
public class UserParam extends AbstractParam {
	private static final long serialVersionUID = -4771808376678313247L;
	/**
	 * The datatype of the parameter, where appropriate (e.g.: xsd:float).
	 */
	@XmlAttribute(name = "type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
