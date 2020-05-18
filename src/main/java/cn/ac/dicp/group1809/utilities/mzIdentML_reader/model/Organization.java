package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Organizations are entities like companies, universities, government agencies.
 * Any additional information such as the address, email etc. should be supplied either as CV parameters or as user parameters.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationType",propOrder = {
		"parent"
})
public class Organization extends AbstractContact {
	private static final long serialVersionUID = 8687418058522570037L;
	@XmlElement(name = "Parent")
	private ParentOrganization parent;

	public ParentOrganization getParent() {
		return parent;
	}

	public void setParent(ParentOrganization parent) {
		this.parent = parent;
	}
}
