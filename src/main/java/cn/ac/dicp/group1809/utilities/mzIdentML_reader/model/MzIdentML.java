package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * The upper-most hierarchy level of mzIdentML with sub-containers for example describing software, protocols and search results (spectrum identifications or protein detection results).
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlRootElement(name = "MzIdentML")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"cvList",
		"analysisSoftwareList",
		"provider",
		"auditCollection",
		"analysisSampleCollection",
		"sequenceCollection",
		"analysisCollection",
		"analysisProtocolCollection",
		"dataCollection",
		"bibliographicReference",
		"creationDate",
		"version"
})
public class MzIdentML extends Identifiable {
	@XmlElement(name = "cvList")
	private CVList cvList;
	@XmlElement(name = "AnalysisSoftwareList")
	private AnalysisSoftwareList analysisSoftwareList;
	/**
	 * The Provider of the mzIdentML record in terms of the contact and software.
	 */
	@XmlElement(name = "Provider")
	private Provider provider;
	@XmlElement(name = "AuditCollection")
	private AuditCollection auditCollection;
	@XmlElement(name = "AnalysisSampleCollection")
	private AnalysisSampleCollection analysisSampleCollection;
	@XmlElement(name = "SequenceCollection")
	private SequenceCollection sequenceCollection;
	@XmlElement(name = "AnalysisCollection")
	private AnalysisCollection analysisCollection;
	@XmlElement(name = "AnalysisProtocolCollection")
	private AnalysisProtocolCollection analysisProtocolCollection;
	@XmlElement(name = "DataCollection")
	private DataCollection dataCollection;
	/**
	 * Any bibliographic references associated with the file
	 */
	@XmlElement(name = "BibliographicReference")
	private List<BibliographicReference> bibliographicReference;
	/**
	 * The date on which the file was produced.
	 */
	@XmlAttribute(name = "creationDate")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date creationDate;
	/**
	 * The version of the schema this instance document refers to, in the format x.y.z.
	 * Changes to z should not affect prevent instance documents from validating.
	 */
	@XmlAttribute(name = "version",required = true)
	private String version;

	public CVList getCvList() {
		return cvList;
	}

	public void setCvList(CVList cvList) {
		this.cvList = cvList;
	}

	public AnalysisSoftwareList getAnalysisSoftwareList() {
		return analysisSoftwareList;
	}

	public void setAnalysisSoftwareList(AnalysisSoftwareList analysisSoftwareList) {
		this.analysisSoftwareList = analysisSoftwareList;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public AuditCollection getAuditCollection() {
		return auditCollection;
	}

	public void setAuditCollection(AuditCollection auditCollection) {
		this.auditCollection = auditCollection;
	}

	public AnalysisSampleCollection getAnalysisSampleCollection() {
		return analysisSampleCollection;
	}

	public void setAnalysisSampleCollection(AnalysisSampleCollection analysisSampleCollection) {
		this.analysisSampleCollection = analysisSampleCollection;
	}

	public SequenceCollection getSequenceCollection() {
		return sequenceCollection;
	}

	public void setSequenceCollection(SequenceCollection sequenceCollection) {
		this.sequenceCollection = sequenceCollection;
	}

	public AnalysisCollection getAnalysisCollection() {
		return analysisCollection;
	}

	public void setAnalysisCollection(AnalysisCollection analysisCollection) {
		this.analysisCollection = analysisCollection;
	}

	public AnalysisProtocolCollection getAnalysisProtocolCollection() {
		return analysisProtocolCollection;
	}

	public void setAnalysisProtocolCollection(AnalysisProtocolCollection analysisProtocolCollection) {
		this.analysisProtocolCollection = analysisProtocolCollection;
	}

	public DataCollection getDataCollection() {
		return dataCollection;
	}

	public void setDataCollection(DataCollection dataCollection) {
		this.dataCollection = dataCollection;
	}

	public List<BibliographicReference> getBibliographicReference() {
		return bibliographicReference;
	}

	public void setBibliographicReference(List<BibliographicReference> bibliographicReference) {
		this.bibliographicReference = bibliographicReference;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		if (version.matches("1\\.1\\.\\d+")) {
			this.version = version;
		} else {
			throw new IllegalArgumentException("Invalid version format: " + version);
		}
	}
}
