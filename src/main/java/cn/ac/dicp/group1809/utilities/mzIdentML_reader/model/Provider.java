package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * The provider of the document in terms of the Contact and the software the produced the document instance.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Provider extends Identifiable {
	/**
	 * The Contact that provided the document instance.
	 */
	@XmlElement(name = "ContactRole")
	private ContactRole contactRole;

	/**
	 * The Software that produced the document instance.
	 */
	@XmlAttribute
	private String analysisSoftware_ref;

	public ContactRole getContactRole() {
		return contactRole;
	}

	public void setContactRole(ContactRole contactRole) {
		this.contactRole = contactRole;
	}

	public String getAnalysisSoftware_ref() {
		return analysisSoftware_ref;
	}

	public void setAnalysisSoftware_ref(String analysisSoftware_ref) {
		this.analysisSoftware_ref = analysisSoftware_ref;
	}
}
