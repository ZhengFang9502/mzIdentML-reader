package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * The list of controlled vocabularies used in the file.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlType(name = "cvList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CVList {
	@XmlElement(name = "cv")
	private List<CV> cvList;

	public List<CV> getCvList() {
		return cvList;
	}

	public void setCvList(List<CV> cvList) {
		this.cvList = cvList;
	}
}
