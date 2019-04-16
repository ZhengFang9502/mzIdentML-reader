package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The protein list resulting from a protein detection process.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"proteinAmbiguityGroup",
		"paramGroupList",
})
public class ProteinDetectionList extends Identifiable {
	@XmlElement(name = "ProteinAmbiguityGroup")
	private List<ProteinAmbiguityGroup> proteinAmbiguityGroup;
	/**
	 * Scores or output parameters associated with the whole ProteinDetectionList
	 */
	private List<AbstractParam> paramGroupList;

	public List<ProteinAmbiguityGroup> getProteinAmbiguityGroup() {
		return proteinAmbiguityGroup;
	}

	public void setProteinAmbiguityGroup(List<ProteinAmbiguityGroup> proteinAmbiguityGroup) {
		this.proteinAmbiguityGroup = proteinAmbiguityGroup;
	}

	public List<AbstractParam> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<AbstractParam> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}
}
