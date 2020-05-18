package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResidueType", propOrder = {
		"code",
		"mass"
})
public class Residue implements Serializable {
	private static final long serialVersionUID = 457525617008813242L;
	/**
	 * The single letter code for the residue.
	 */
	@XmlAttribute(name = "code", required = true)
	private String code;
	/**
	 * The residue mass in Daltons (not including any fixed modifications).
	 */
	@XmlAttribute(name = "mass", required = true)
	private Float mass;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (!code.matches("[A-Z]")) {
			throw new IllegalArgumentException("Invalid code: " + code);
		}
		this.code = code;
	}

	public Float getMass() {
		return mass;
	}

	public void setMass(Float mass) {
		this.mass = mass;
	}
}
