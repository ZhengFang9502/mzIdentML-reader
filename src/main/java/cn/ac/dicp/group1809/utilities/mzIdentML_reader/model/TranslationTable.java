package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The table used to translate codons into nucleic acids e.g. by reference to the NCBI translation table.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TranslationTableType", propOrder = {
		"cvParam"
})
public class TranslationTable extends Identifiable {
	private static final long serialVersionUID = 4949461416985843625L;
	/**
	 * The details specifying this translation table are captured as cvParams, e.g. translation table, translation start codons and translation table description (see specification document and mapping file)
	 */
	@XmlElement(name = "cvParam")
	private List<CVParam> cvParam;

	public List<CVParam> getCvParam() {
		return cvParam;
	}

	public void setCvParam(List<CVParam> cvParam) {
		this.cvParam = cvParam;
	}
}
