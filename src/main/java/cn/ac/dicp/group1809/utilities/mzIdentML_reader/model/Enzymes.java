package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * The list of enzymes used in experiment
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Enzymes {
	@XmlElement(name = "Enzyme")
	private List<Enzyme> enzyme;
	/**
	 * If there are multiple enzymes specified, this attribute is set to true if cleavage with different enzymes is performed independently.
	 */
	@XmlAttribute(name = "independent")
	private boolean independent;

	public List<Enzyme> getEnzyme() {
		return enzyme;
	}

	public void setEnzyme(List<Enzyme> enzyme) {
		this.enzyme = enzyme;
	}

	public boolean isIndependent() {
		return independent;
	}

	public void setIndependent(boolean independent) {
		this.independent = independent;
	}
}
