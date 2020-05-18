package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * A choice of either a cvParam or userParam.
 *
 * @author Zheng Fang 2020/5/18
 * @since V1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamType", propOrder = {
		"paramGroup"
})
public class Param implements Serializable {
	private static final long serialVersionUID = 2875154476154101964L;
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class),
	})
	private AbstractParam paramGroup;

	public AbstractParam getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(AbstractParam paramGroup) {
		this.paramGroup = paramGroup;
	}
}
