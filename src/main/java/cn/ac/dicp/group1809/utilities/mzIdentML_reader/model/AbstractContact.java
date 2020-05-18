package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A contact is either a person or an organization.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractContactType", propOrder = {
		"paramGroup"
})
public abstract class AbstractContact extends Identifiable {
	private static final long serialVersionUID = -7374651341511607052L;
	/**
	 * Attributes of this contact such as address, email, telephone etc.
	 */
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
