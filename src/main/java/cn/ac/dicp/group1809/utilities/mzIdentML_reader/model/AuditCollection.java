package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * The complete set of Contacts (people and organisations) for this file.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AuditCollection {
	@XmlElement
	private List<Audit> auditCollection;

	public List<Audit> getAuditCollection() {
		return auditCollection;
	}

	public void setAuditCollection(List<Audit> auditCollection) {
		this.auditCollection = auditCollection;
	}
}
