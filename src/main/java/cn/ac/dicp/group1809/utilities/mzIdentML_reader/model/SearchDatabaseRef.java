package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * One of the search databases used.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchDatabaseRef {
	/**
	 * A reference to the database searched.
	 */
	@XmlAttribute
	private String searchDatabase_ref;

	public String getSearchDatabase_ref() {
		return searchDatabase_ref;
	}

	public void setSearchDatabase_ref(String searchDatabase_ref) {
		this.searchDatabase_ref = searchDatabase_ref;
	}
}
