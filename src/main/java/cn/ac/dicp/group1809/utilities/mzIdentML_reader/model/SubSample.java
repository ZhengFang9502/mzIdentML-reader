package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * References to the individual component samples within a mixed parent sample.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlType(name = "SubSample")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubSample {
	/**
	 * A reference to the child sample.
	 */
	@XmlAttribute(required = true)
	private String sample_ref;

	public String getSample_ref() {
		return sample_ref;
	}

	public void setSample_ref(String sample_ref) {
		this.sample_ref = sample_ref;
	}
}
