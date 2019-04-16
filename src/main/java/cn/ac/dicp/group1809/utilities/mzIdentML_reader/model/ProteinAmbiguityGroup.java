package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A set of logically related results from a protein detection, for example to represent conflicting assignments of peptides to proteins.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"proteinDetectionHypothesis",
		"paramGroupList"
})
public class ProteinAmbiguityGroup extends Identifiable {
	@XmlElement(name = "ProteinDetectionHypothesis")
	private List<ProteinDetectionHypothesis> proteinDetectionHypothesis;
	/**
	 * Scores or parameters associated with the ProteinAmbiguityGroup.
	 */
	private List<AbstractParam> paramGroupList;

	public List<ProteinDetectionHypothesis> getProteinDetectionHypothesis() {
		return proteinDetectionHypothesis;
	}

	public void setProteinDetectionHypothesis(List<ProteinDetectionHypothesis> proteinDetectionHypothesis) {
		this.proteinDetectionHypothesis = proteinDetectionHypothesis;
	}

	public List<AbstractParam> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<AbstractParam> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}
}
