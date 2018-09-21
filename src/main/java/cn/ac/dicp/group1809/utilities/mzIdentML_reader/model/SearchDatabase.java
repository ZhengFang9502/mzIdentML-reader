package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * A database for searching mass spectra. Examples include a set of amino acid sequence entries, or annotated spectra libraries.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"databaseName",
		"cvParam",
		"version",
		"releaseDate",
		"numDatabaseSequences",
		"numResidues"
})
public class SearchDatabase extends ExternalData {
	/**
	 * The database name may be given as a cvParam if it maps exactly to one of the release databases listed in the CV, otherwise a userParam should be used.
	 */
	@XmlElement(name = "DatabaseName")
	private Param databaseName;
	@XmlElement(name = "cvParam")
	private List<CVParam> cvParam;
	/**
	 * The version of the database.
	 */
	@XmlAttribute(name = "version")
	private String version;
	/**
	 * The date and time the database was released to the public; omit this attribute when the date and time are unknown or not applicable (e.g. custom databases).
	 */
	@XmlAttribute(name = "releaseDate")
	private Date releaseDate;
	/**
	 * The total number of sequences in the database.
	 */
	@XmlAttribute(name = "numDatabaseSequences")
	private long numDatabaseSequences;
	/**
	 * The number of residues in the database.
	 */
	@XmlAttribute(name = "numResidues")
	private long numResidues;

	public Param getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(Param databaseName) {
		this.databaseName = databaseName;
	}

	public List<CVParam> getCvParam() {
		return cvParam;
	}

	public void setCvParam(List<CVParam> cvParam) {
		this.cvParam = cvParam;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getNumDatabaseSequences() {
		return numDatabaseSequences;
	}

	public void setNumDatabaseSequences(long numDatabaseSequences) {
		this.numDatabaseSequences = numDatabaseSequences;
	}

	public long getNumResidues() {
		return numResidues;
	}

	public void setNumResidues(long numResidues) {
		this.numResidues = numResidues;
	}
}
