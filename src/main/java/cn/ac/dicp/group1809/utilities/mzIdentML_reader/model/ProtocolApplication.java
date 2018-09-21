package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * The use of a protocol with the requisite Parameters and ParameterValues.
 * ProtocolApplications can take Material or Data (or both) as input and produce Material or Data (or both) as output.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class ProtocolApplication extends Identifiable {
	/**
	 * When the protocol was applied.
	 */
	@XmlAttribute(name = "activityDate")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date activityDate;

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
}
