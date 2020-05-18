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
@XmlType(name = "AffiliationType", propOrder = {
		"organization_ref"
})
public class Affiliation implements Serializable {
	private static final long serialVersionUID = -5977521307575442926L;
	/**
	 * A reference to the organization this contact belongs to.
	 */
	@XmlAttribute(name = "organization_ref", required = true)
	private String organization_ref;

	public String getOrganization_ref() {
		return organization_ref;
	}

	public void setOrganization_ref(String organization_ref) {
		this.organization_ref = organization_ref;
	}
}
