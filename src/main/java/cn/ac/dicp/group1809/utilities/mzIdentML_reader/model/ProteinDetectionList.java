package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * The protein list resulting from a protein detection process.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinDetectionListType", propOrder = {
		"proteinAmbiguityGroup",
		"paramGroup",
})
public class ProteinDetectionList extends Identifiable {
	private static final long serialVersionUID = -4082757588850655032L;
	@XmlElement(name = "ProteinAmbiguityGroup")
	private List<ProteinAmbiguityGroup> proteinAmbiguityGroup;
	/**
	 * Scores or output parameters associated with the whole ProteinDetectionList
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;

	public List<ProteinAmbiguityGroup> getProteinAmbiguityGroup() {
		return proteinAmbiguityGroup;
	}

	public void setProteinAmbiguityGroup(List<ProteinAmbiguityGroup> proteinAmbiguityGroup) {
		this.proteinAmbiguityGroup = proteinAmbiguityGroup;
	}

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}
}
