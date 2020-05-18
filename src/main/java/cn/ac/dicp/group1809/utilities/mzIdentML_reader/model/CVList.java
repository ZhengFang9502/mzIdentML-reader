package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * The list of controlled vocabularies used in the file.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVListType",propOrder = {
		"cv"
})
public class CVList implements Serializable {
	private static final long serialVersionUID = -7645781994217482901L;
	@XmlElement(name = "cv")
	private List<CV> cv;

	public List<CV> getCv() {
		return cv;
	}

	public void setCv(List<CV> cv) {
		this.cv = cv;
	}
}
