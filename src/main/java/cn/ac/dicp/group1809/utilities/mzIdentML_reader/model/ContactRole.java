package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * The role that a Contact plays in an organization or with respect to the associating class.
 * A Contact may have several Roles within scope, and as such, associations to ContactRole allow the use of a Contact in a certain manner.
 * Examples might include a provider, or a data analyst.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactRoleType",propOrder = {
		"role"
})
public class ContactRole implements Serializable {
	private static final long serialVersionUID = 550471250460402289L;
	@XmlElement(name = "Role")
	private Role role;
	/**
	 * When a ContactRole is used, it specifies which Contact the role is associated with.
	 */
	@XmlAttribute(name = "contact_ref", required = true)
	private String contact_ref;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getContact_ref() {
		return contact_ref;
	}

	public void setContact_ref(String contact_ref) {
		this.contact_ref = contact_ref;
	}
}
