package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * The collection of input and output data sets of the analyses.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataCollectionType",propOrder = {
		"inputs",
		"analysisData"
})
public class DataCollection implements Serializable {
	private static final long serialVersionUID = 1705781932585344942L;
	@XmlElement(name = "Inputs")
	private Inputs inputs;
	@XmlElement(name = "AnalysisData")
	private AnalysisData analysisData;

	public Inputs getInputs() {
		return inputs;
	}

	public void setInputs(Inputs inputs) {
		this.inputs = inputs;
	}

	public AnalysisData getAnalysisData() {
		return analysisData;
	}

	public void setAnalysisData(AnalysisData analysisData) {
		this.analysisData = analysisData;
	}
}
