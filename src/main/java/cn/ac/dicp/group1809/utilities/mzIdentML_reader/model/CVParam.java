package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * A single entry from an ontology or a controlled vocabulary.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cvParam", propOrder = {
		"cvRef",
		"accession"
})
public class CVParam extends AbstractParam implements ParamGroup{
	/**
	 * A reference to the cv element from which this term originates.
	 */
	@XmlAttribute(required = true)
	private String cvRef;
	/**
	 * The accession or ID number of this CV term in the source CV.
	 */
	@XmlAttribute(required = true)
	private String accession;

	public String getCvRef() {
		return cvRef;
	}

	public void setCvRef(String cvRef) {
		this.cvRef = cvRef;
	}

	public String getAccession() {
		return accession;
	}

	public void setAccession(String accession) {
		this.accession = accession;
	}
}
