package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The samples analysed can optionally be recorded using CV terms for descriptions.
 * If a composite sample has been analysed, the subsample association can be used to build a hierarchical description.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AnalysisSampleCollection {
	@XmlElement(name = "Sample")
	private List<Sample> sample;

	public List<Sample> getSample() {
		return sample;
	}

	public void setSample(List<Sample> sample) {
		this.sample = sample;
	}
}
