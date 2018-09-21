package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Ambiguous residues e.g. X can be specified by the Code attribute and a set of parameters for example giving the different masses that will be used in the search.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"paramGroupList",
		"code"
})
public class AmbiguousResidue {
	/**
	 * Parameters for capturing e.g. "alternate single letter codes"
	 */
	private List<ParamGroup> paramGroupList;
	/**
	 * The single letter code of the ambiguous residue e.g. X.
	 */
	@XmlAttribute(name = "code", required = true)
	private String code;

	public List<ParamGroup> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<ParamGroup> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (!code.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]")) {
			throw new IllegalArgumentException("Invalid code: " + code);
		}
		this.code = code;
	}
}
