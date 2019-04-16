package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * A description of the sample analysed by mass spectrometry using CVParams or UserParams.
 * If a composite sample has been analysed, a parent sample should be defined, which references subsamples.
 * This represents any kind of substance used in an experimental workflow, such as whole organisms, cells, DNA, solutions, compounds and experimental substances (gels, arrays etc.).
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"contactRole",
		"subSample",
		"paramGroupList"
})
public class Sample extends Identifiable {
	/**
	 * Contact details for the Material. The association to ContactRole could specify, for example, the creator or provider of the Material.
	 */
	@XmlElement(name = "ContactRole")
	private List<ContactRole> contactRole;
	@XmlElement(name = "SubSample")
	private List<SubSample> subSample;
	/**
	 * The characteristics of a Material.
	 */
	private List<AbstractParam> paramGroupList;

	public List<ContactRole> getContactRole() {
		return contactRole;
	}

	public void setContactRole(List<ContactRole> contactRole) {
		this.contactRole = contactRole;
	}

	public List<SubSample> getSubSample() {
		return subSample;
	}

	public void setSubSample(List<SubSample> subSample) {
		this.subSample = subSample;
	}

	public List<AbstractParam> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<AbstractParam> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}
}
