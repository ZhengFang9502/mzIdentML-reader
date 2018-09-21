package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Residue", propOrder = {
		"code",
		"mass"
})
public class Residue {
	/**
	 * The single letter code for the residue.
	 */
	@XmlAttribute(required = true)
	private String code;
	/**
	 * The residue mass in Daltons (not including any fixed modifications).
	 */
	@XmlAttribute(required = true)
	private float mass;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (!code.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
			throw new IllegalArgumentException("Invalid code: " + code);
		}
		this.code = code;
	}

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}
}
