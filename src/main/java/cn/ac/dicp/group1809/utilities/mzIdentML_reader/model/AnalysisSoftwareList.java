package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * The software packages used to perform the analyses.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AnalysisSoftwareList {
	@XmlElement(name = "AnalysisSoftware")
	private List<AnalysisSoftware> analysisSoftware;

	public List<AnalysisSoftware> getAnalysisSoftware() {
		return analysisSoftware;
	}

	public void setAnalysisSoftware(List<AnalysisSoftware> analysisSoftware) {
		this.analysisSoftware = analysisSoftware;
	}
}
