package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * The tolerance of the search given as a plus and minus value with units.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ToleranceType", propOrder = {
		"cvParam"
})
public class Tolerance implements Serializable {
	private static final long serialVersionUID = -1828048052632736060L;
	/**
	 * CV terms capturing the tolerance plus and minus values.
	 */
	@XmlElement(name = "cvParam")
	private List<CVParam> cvParam;

	public List<CVParam> getCvParam() {
		return cvParam;
	}

	public void setCvParam(List<CVParam> cvParam) {
		this.cvParam = cvParam;
	}
}
