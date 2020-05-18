package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * The containing organization (the university or business which a lab belongs to, etc.)
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParentOrganizationType", propOrder = {
		"organization_ref"
})
public class ParentOrganization implements Serializable {
	private static final long serialVersionUID = -1029417422011090614L;
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
