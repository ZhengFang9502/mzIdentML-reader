package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * The inputs to the analyses including the databases searched, the spectral data and the source file converted to mzIdentML.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputsType",propOrder = {
		"sourceFile",
		"searchDatabase",
		"spectraData"
})
public class Inputs implements Serializable {
	private static final long serialVersionUID = 4685524277394101446L;
	@XmlElement(name = "SourceFile")
	private List<SourceFile> sourceFile;
	@XmlElement(name = "SearchDatabase")
	private List<SearchDatabase> searchDatabase;
	@XmlElement(name = "SpectraData")
	private List<SpectraData> spectraData;

	public List<SourceFile> getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(List<SourceFile> sourceFile) {
		this.sourceFile = sourceFile;
	}

	public List<SearchDatabase> getSearchDatabase() {
		return searchDatabase;
	}

	public void setSearchDatabase(List<SearchDatabase> searchDatabase) {
		this.searchDatabase = searchDatabase;
	}

	public List<SpectraData> getSpectraData() {
		return spectraData;
	}

	public void setSpectraData(List<SpectraData> spectraData) {
		this.spectraData = spectraData;
	}
}
