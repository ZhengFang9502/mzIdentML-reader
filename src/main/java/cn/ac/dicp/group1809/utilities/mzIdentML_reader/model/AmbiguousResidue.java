package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Ambiguous residues e.g. X can be specified by the Code attribute and a set of parameters for example giving the different masses that will be used in the search.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmbiguousResidueType", propOrder = {
		"paramGroup",
		"code"
})
public class AmbiguousResidue implements Serializable {
	private static final long serialVersionUID = -1961636236683559232L;
	/**
	 * Parameters for capturing e.g. "alternate single letter codes"
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;
	/**
	 * The single letter code of the ambiguous residue e.g. X.
	 */
	@XmlAttribute(name = "code", required = true)
	private String code;

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (!code.matches("[A-Z]")) {
			throw new IllegalArgumentException("Invalid code: " + code);
		}
		this.code = code;
	}
}
