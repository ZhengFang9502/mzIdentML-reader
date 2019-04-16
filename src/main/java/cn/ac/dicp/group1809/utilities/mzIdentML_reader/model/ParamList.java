package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Helper type to allow multiple cvParams or userParams to be given for an element.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"paramGroupList"
})
public class ParamList {
	private List<AbstractParam> paramGroupList;

	public List<AbstractParam> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<AbstractParam> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}
}
