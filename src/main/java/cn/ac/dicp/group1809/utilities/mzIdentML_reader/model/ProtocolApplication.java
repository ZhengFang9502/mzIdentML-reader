package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * The use of a protocol with the requisite Parameters and ParameterValues.
 * ProtocolApplications can take Material or Data (or both) as input and produce Material or Data (or both) as output.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProtocolApplicationType")
public abstract class ProtocolApplication extends Identifiable {
	private static final long serialVersionUID = 6532511753214538207L;
	/**
	 * When the protocol was applied.
	 */
	@XmlAttribute(name = "activityDate")
	private String activityDate;

	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
}
