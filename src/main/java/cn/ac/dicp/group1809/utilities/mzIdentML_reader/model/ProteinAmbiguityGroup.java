package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A set of logically related results from a protein detection, for example to represent conflicting assignments of peptides to proteins.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinAmbiguityGroupType", propOrder = {
		"proteinDetectionHypothesis",
		"paramGroup"
})
public class ProteinAmbiguityGroup extends Identifiable {
	private static final long serialVersionUID = 2412547435595261762L;
	@XmlElement(name = "ProteinDetectionHypothesis")
	private List<ProteinDetectionHypothesis> proteinDetectionHypothesis;

	/**
	 * Scores or parameters associated with the ProteinAmbiguityGroup.
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;

	public List<ProteinDetectionHypothesis> getProteinDetectionHypothesis() {
		return proteinDetectionHypothesis;
	}

	public void setProteinDetectionHypothesis(List<ProteinDetectionHypothesis> proteinDetectionHypothesis) {
		this.proteinDetectionHypothesis = proteinDetectionHypothesis;
	}

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}
}
