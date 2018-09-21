package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Contains the types of measures that will be reported in generic arrays for each SpectrumIdentificationItem e.g. product ion m/z, product ion intensity, product ion m/z error
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
public class FragmentationTable {
	@XmlElement(name = "Measure")
	private List<Measure> measure;

	public List<Measure> getMeasure() {
		return measure;
	}

	public void setMeasure(List<Measure> measure) {
		this.measure = measure;
	}
}
