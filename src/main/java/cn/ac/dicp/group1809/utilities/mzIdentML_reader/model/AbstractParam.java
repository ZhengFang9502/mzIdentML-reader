package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Abstract entity allowing either cvParam or userParam to be referenced in other schemas.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractParam", propOrder = {
		"name",
		"value",
		"unitAccession",
		"unitName",
		"unitCvRef"
})
public abstract class AbstractParam {
	/**
	 * The name of the parameter.
	 */
	@XmlAttribute(required = true)
	private String name;
	/**
	 * The user-entered value of the parameter.
	 */
	@XmlAttribute
	private String value;
	/**
	 * An accession number identifying the unit within the OBO foundry Unit CV.
	 */
	@XmlAttribute
	private String unitAccession;
	/**
	 * The name of the unit.
	 */
	@XmlAttribute
	private String unitName;
	/**
	 * If a unit term is referenced, this attribute must refer to the CV 'id' attribute defined in the cvList in this file.
	 */
	@XmlAttribute
	private String unitCvRef;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnitAccession() {
		return unitAccession;
	}

	public void setUnitAccession(String unitAccession) {
		this.unitAccession = unitAccession;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitCvRef() {
		return unitCvRef;
	}

	public void setUnitCvRef(String unitCvRef) {
		this.unitCvRef = unitCvRef;
	}
}
