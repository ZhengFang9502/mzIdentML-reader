package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * The parameters and settings of a SpectrumIdentification analysis.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlType(propOrder = {
		"searchType",
		"additionalSearchParams",
		"modificationParams",
		"enzymes",
		"massTable",
		"fragmentTolerance",
		"parentTolerance",
		"threshold",
		"databaseFilters",
		"databaseTranslation",
		"analysisSoftware_ref"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class SpectrumIdentificationProtocol extends Identifiable {
	/**
	 * The type of search performed e.g. PMF, Tag searches, MS-MS
	 */
	@XmlElement(name = "SearchType")
	private Param searchType;
	/**
	 * The search parameters other than the modifications searched.
	 */
	@XmlElement(name = "AdditionalSearchParams")
	private ParamList additionalSearchParams;
	@XmlElement(name = "ModificationParams")
	private ModificationParams modificationParams;
	@XmlElement(name = "Enzymes")
	private Enzymes enzymes;
	@XmlElement(name = "MassTable")
	private List<MassTable> massTable;
	@XmlElement(name = "FragmentTolerance")
	private Tolerance fragmentTolerance;
	@XmlElement(name = "ParentTolerance")
	private Tolerance parentTolerance;
	/**
	 * The threshold(s) applied to determine that a result is significant.
	 * If multiple terms are used it is assumed that all conditions are satisfied by the passing results.
	 */
	@XmlElement(name = "Threshold")
	private ParamList threshold;
	@XmlElement(name = "DatabaseFilters")
	private DatabaseFilters databaseFilters;
	@XmlElement(name = "DatabaseTranslation")
	private DatabaseTranslation databaseTranslation;
	/**
	 * The search algorithm used, given as a reference to the SoftwareCollection section.
	 */
	@XmlAttribute(name = "analysisSoftware_ref")
	private String analysisSoftware_ref;

	public Param getSearchType() {
		return searchType;
	}

	public void setSearchType(Param searchType) {
		this.searchType = searchType;
	}

	public ParamList getAdditionalSearchParams() {
		return additionalSearchParams;
	}

	public void setAdditionalSearchParams(ParamList additionalSearchParams) {
		this.additionalSearchParams = additionalSearchParams;
	}

	public ModificationParams getModificationParams() {
		return modificationParams;
	}

	public void setModificationParams(ModificationParams modificationParams) {
		this.modificationParams = modificationParams;
	}

	public Enzymes getEnzymes() {
		return enzymes;
	}

	public void setEnzymes(Enzymes enzymes) {
		this.enzymes = enzymes;
	}

	public List<MassTable> getMassTable() {
		return massTable;
	}

	public void setMassTable(List<MassTable> massTable) {
		this.massTable = massTable;
	}

	public Tolerance getFragmentTolerance() {
		return fragmentTolerance;
	}

	public void setFragmentTolerance(Tolerance fragmentTolerance) {
		this.fragmentTolerance = fragmentTolerance;
	}

	public Tolerance getParentTolerance() {
		return parentTolerance;
	}

	public void setParentTolerance(Tolerance parentTolerance) {
		this.parentTolerance = parentTolerance;
	}

	public ParamList getThreshold() {
		return threshold;
	}

	public void setThreshold(ParamList threshold) {
		this.threshold = threshold;
	}

	public DatabaseFilters getDatabaseFilters() {
		return databaseFilters;
	}

	public void setDatabaseFilters(DatabaseFilters databaseFilters) {
		this.databaseFilters = databaseFilters;
	}

	public DatabaseTranslation getDatabaseTranslation() {
		return databaseTranslation;
	}

	public void setDatabaseTranslation(DatabaseTranslation databaseTranslation) {
		this.databaseTranslation = databaseTranslation;
	}

	public String getAnalysisSoftware_ref() {
		return analysisSoftware_ref;
	}

	public void setAnalysisSoftware_ref(String analysisSoftware_ref) {
		this.analysisSoftware_ref = analysisSoftware_ref;
	}
}
