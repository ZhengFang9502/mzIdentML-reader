package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Contains the types of measures that will be reported in generic arrays for each SpectrumIdentificationItem e.g. product ion m/z, product ion intensity, product ion m/z error
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FragmentationTableType", propOrder = {
		"measure"
})
public class FragmentationTable implements Serializable {
	private static final long serialVersionUID = 4268364734389808090L;
	@XmlElement(name = "Measure")
	private List<Measure> measure;

	public List<Measure> getMeasure() {
		return measure;
	}

	public void setMeasure(List<Measure> measure) {
		this.measure = measure;
	}
}
