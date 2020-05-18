package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Abstract entity allowing either cvParam or userParam to be referenced in other schemas.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractParamType", propOrder = {
		"name",
		"value",
		"unitAccession",
		"unitName",
		"unitCvRef"
})
public abstract class AbstractParam implements Serializable {
	private static final long serialVersionUID = 3045468801118972443L;
	/**
	 * The name of the parameter.
	 */
	@XmlAttribute(name = "name", required = true)
	private String name;
	/**
	 * The user-entered value of the parameter.
	 */
	@XmlAttribute(name = "value")
	private String value;
	/**
	 * An accession number identifying the unit within the OBO foundry Unit CV.
	 */
	@XmlAttribute(name = "unitAccession")
	private String unitAccession;
	/**
	 * The name of the unit.
	 */
	@XmlAttribute(name = "unitName")
	private String unitName;
	/**
	 * If a unit term is referenced, this attribute must refer to the CV 'id' attribute defined in the cvList in this file.
	 */
	@XmlAttribute(name = "unitCvRef")
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
