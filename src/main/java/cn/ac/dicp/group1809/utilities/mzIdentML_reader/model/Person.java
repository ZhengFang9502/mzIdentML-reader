package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A person's name and contact details.
 * Any additional information such as the address, contact email etc. should be supplied using CV parameters or user parameters.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"affiliation",
		"lastName",
		"firstName",
		"midInitials"
})
public class Person extends AbstractContact implements Audit {
	/**
	 * The organization a person belongs to.
	 */
	@XmlElement
	private List<Affiliation> affiliation;
	/**
	 * The Person's last/family name.
	 */
	@XmlAttribute
	private String lastName;
	/**
	 * The Person's first name.
	 */
	@XmlAttribute
	private String firstName;
	/**
	 * The Person's middle initial.
	 */
	@XmlAttribute
	private String midInitials;

	public List<Affiliation> getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(List<Affiliation> affiliation) {
		this.affiliation = affiliation;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidInitials() {
		return midInitials;
	}

	public void setMidInitials(String midInitials) {
		this.midInitials = midInitials;
	}
}
