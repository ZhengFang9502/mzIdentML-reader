package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * An array of values for a given type of measure and for a particular ion type, in parallel to the index of ions identified.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlType(propOrder = {
		"values",
		"measure_ref"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class FragmentArray {
	/**
	 * The values of this particular measure, corresponding to the index defined in ion type
	 */
	@XmlAttribute(name = "values", required = true)
	private List<Float> values;
	/**
	 * A reference to the Measure defined in the FragmentationTable
	 */
	@XmlAttribute(name = "measure_ref",required = true)
	private String measure_ref;

	public List<Float> getValues() {
		return values;
	}

	public void setValues(List<Float> values) {
		this.values = values;
	}

	public String getMeasure_ref() {
		return measure_ref;
	}

	public void setMeasure_ref(String measure_ref) {
		this.measure_ref = measure_ref;
	}
}
