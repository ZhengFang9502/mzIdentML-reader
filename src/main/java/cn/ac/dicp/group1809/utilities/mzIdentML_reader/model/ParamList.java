package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Helper type to allow multiple cvParams or userParams to be given for an element.
 *
 * @author Zheng Fang 2020/5/18
 * @since V1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamListType", propOrder = {
		"paramGroup"
})
public class ParamList {
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}
}
