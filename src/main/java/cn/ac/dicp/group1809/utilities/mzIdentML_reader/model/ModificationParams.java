package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * The specification of static/variable modifications (e.g. Oxidation of Methionine) that are to be considered in the spectra search.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModificationParams")
public class ModificationParams {
	@XmlElement(name = "SearchModification")
	private List<SearchModification> searchModification;

	public List<SearchModification> getSearchModification() {
		return searchModification;
	}

	public void setSearchModification(List<SearchModification> searchModification) {
		this.searchModification = searchModification;
	}
}
