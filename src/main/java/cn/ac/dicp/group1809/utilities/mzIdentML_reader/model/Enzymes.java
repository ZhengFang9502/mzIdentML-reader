package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * The list of enzymes used in experiment
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnzymesType",propOrder = {
		"enzyme",
		"independent"
})
public class Enzymes implements Serializable {
	private static final long serialVersionUID = -3699972890586397474L;
	@XmlElement(name = "Enzyme")
	private List<Enzyme> enzyme;
	/**
	 * If there are multiple enzymes specified, this attribute is set to true if cleavage with different enzymes is performed independently.
	 */
	@XmlAttribute(name = "independent")
	private Boolean independent;

	public List<Enzyme> getEnzyme() {
		return enzyme;
	}

	public void setEnzyme(List<Enzyme> enzyme) {
		this.enzyme = enzyme;
	}

	public Boolean getIndependent() {
		return independent;
	}

	public void setIndependent(Boolean independent) {
		this.independent = independent;
	}
}
