package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * The complete set of Contacts (people and organisations) for this file.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditCollectionType", propOrder = {
		"contactList"
})
public class AuditCollection implements Serializable {
	private static final long serialVersionUID = -3590685132094946520L;
	@XmlElements(value = {
			@XmlElement(name = "Person", type = Person.class),
			@XmlElement(name = "Organization", type = Organization.class)
	})
	private List<AbstractContact> contactList;

	public List<AbstractContact> getContactList() {
		return contactList;
	}

	public void setContactList(List<AbstractContact> contactList) {
		this.contactList = contactList;
	}
}
