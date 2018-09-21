package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * The specificity rules of the searched modification including for example the probability of a modification's presence or peptide or protein termini.
 * Standard fixed or variable status should be provided by the attribute fixedMod.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecificityRules {
	@XmlElement(name = "cvParam")
	private List<CVParam> cvParam;

	public List<CVParam> getCvParam() {
		return cvParam;
	}

	public void setCvParam(List<CVParam> cvParam) {
		this.cvParam = cvParam;
	}
}
