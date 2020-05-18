package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.proteomics_framework.database.modification.unimod.Unimod;
import cn.ac.dicp.group1809.utilities.proteomics_framework.database.ontology.PSIMSOntology;
import cn.ac.dicp.group1809.utilities.proteomics_framework.database.ontology.model.OntologyTerm;
import cn.ac.dicp.group1809.utilities.proteomics_framework.model.definition.proteomics.Modification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A single entry from an ontology or a controlled vocabulary.
 *
 * @author ZhengFang 2018/8/20
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVParam", propOrder = {
		"cvRef",
		"accession",
})
public class CVParam extends AbstractParam {
	public static final TreeMap<String, CVParam> UNIMOD_ACCESSION_MAP;
	public static final TreeMap<String, CVParam> UNIMOD_NAME_MAP;
	public static final TreeMap<String, CVParam> PSI_MS_MAP;
	private static final long serialVersionUID = -8366541462255708050L;

	static {
		UNIMOD_ACCESSION_MAP = new TreeMap<>();
		UNIMOD_NAME_MAP = new TreeMap<>();
		Unimod unimod = Unimod.getInstance();
		HashMap<String, Modification> modificationTable = unimod.getModificationTable();
		for (String name : modificationTable.keySet()) {
			Modification modification = modificationTable.get(name);
			int id = modification.getId();
			String accession = "UNIMOD:" + id;
			CVParam cvParam = getCVParam("UNIMOD", accession, name);
			UNIMOD_ACCESSION_MAP.put(accession, cvParam);
			UNIMOD_NAME_MAP.put(name, cvParam);
		}

		PSI_MS_MAP = new TreeMap<>();
		TreeMap<String, OntologyTerm> psi_ms_termMap = PSIMSOntology.getTermMap();
		for (Map.Entry<String, OntologyTerm> termEntry : psi_ms_termMap.entrySet()) {
			String accession = termEntry.getKey();
			CVParam cvParam = getCVParam("PSI-MS", termEntry.getValue());
			PSI_MS_MAP.put(accession, cvParam);
		}
	}

	/**
	 * A reference to the cv element from which this term originates.
	 */
	@XmlAttribute(name = "cvRef", required = true)
	private String cvRef;
	/**
	 * The accession or ID number of this CV term in the source CV.
	 */
	@XmlAttribute(name = "accession", required = true)
	private String accession;

	public static CVParam getCVParam(String cvRef,
	                                 String accession,
	                                 String name,
	                                 String value,
	                                 String unitCvRef,
	                                 String unitAccession,
	                                 String unitName) {
		CVParam cvParam = new CVParam();
		cvParam.setCvRef(cvRef);
		cvParam.setAccession(accession);
		cvParam.setName(name);
		cvParam.setValue(value);
		cvParam.setUnitCvRef(unitCvRef);
		cvParam.setUnitAccession(unitAccession);
		cvParam.setUnitName(unitName);
		return cvParam;
	}

	public static CVParam getCVParam(String cvRef,
	                                 String accession,
	                                 String name) {
		CVParam cvParam = new CVParam();
		cvParam.setCvRef(cvRef);
		cvParam.setAccession(accession);
		cvParam.setName(name);
		return cvParam;
	}

	public static CVParam getCVParam(String cvRef, OntologyTerm paramTerm, String value, String unitCvRef, OntologyTerm unitTerm) {
		CVParam cvParam = new CVParam();
		cvParam.setCvRef(cvRef);
		cvParam.setAccession(paramTerm.getId());
		cvParam.setName(paramTerm.getName());
		cvParam.setValue(value);
		cvParam.setUnitCvRef(unitCvRef);
		cvParam.setUnitAccession(unitTerm.getId());
		cvParam.setUnitName(unitTerm.getName());
		return cvParam;
	}

	public static CVParam getCVParam(String cvRef, OntologyTerm paramTerm) {
		CVParam cvParam = new CVParam();
		cvParam.setCvRef(cvRef);
		cvParam.setAccession(paramTerm.getId());
		cvParam.setName(paramTerm.getName());
		return cvParam;
	}

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

	public void setUnit(String unitCvRef, OntologyTerm unitTerm) {
		this.setUnitCvRef(unitCvRef);
		this.setUnitAccession(unitTerm.getId());
		this.setUnitName(unitTerm.getName());
	}

	public CVParam copy() {
		CVParam cvParam = new CVParam();
		cvParam.setCvRef(this.getCvRef());
		cvParam.setAccession(this.getAccession());
		cvParam.setName(this.getName());
		cvParam.setValue(this.getValue());
		cvParam.setUnitCvRef(this.getUnitCvRef());
		cvParam.setUnitAccession(this.getUnitAccession());
		cvParam.setUnitName(this.getUnitName());
		return cvParam;
	}
}
