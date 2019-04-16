package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Helper type to allow either a cvParam or a userParam to be provided for an element.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Param {
	@XmlElement
	private AbstractParam paramGroup;

	public AbstractParam getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(AbstractParam paramGroup) {
		this.paramGroup = paramGroup;
	}
}
