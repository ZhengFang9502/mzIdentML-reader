package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Reference to the PeptideEvidence element identified.
 * If a specific sequence can be assigned to multiple proteins and or positions in a protein all possible PeptideEvidence elements should be referenced here.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeptideEvidenceRefType",propOrder = {
		"peptideEvidence_ref"
})
public class PeptideEvidenceRef implements Serializable {
	private static final long serialVersionUID = 643988991503120766L;
	/**
	 * A reference to the PeptideEvidenceItem element(s).
	 */
	@XmlAttribute(name = "peptideEvidence_ref", required = true)
	private String peptideEvidence_ref;

	public String getPeptideEvidence_ref() {
		return peptideEvidence_ref;
	}

	public void setPeptideEvidence_ref(String peptideEvidence_ref) {
		this.peptideEvidence_ref = peptideEvidence_ref;
	}
}
