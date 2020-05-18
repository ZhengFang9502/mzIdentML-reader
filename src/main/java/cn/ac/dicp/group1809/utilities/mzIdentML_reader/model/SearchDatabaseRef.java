package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * One of the search databases used.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchDatabaseRefType", propOrder = {
		"searchDatabase_ref"
})
public class SearchDatabaseRef implements Serializable {
	private static final long serialVersionUID = 7554091110880085415L;
	/**
	 * A reference to the database searched.
	 */
	@XmlAttribute(name = "searchDatabase_ref")
	private String searchDatabase_ref;

	public String getSearchDatabase_ref() {
		return searchDatabase_ref;
	}

	public void setSearchDatabase_ref(String searchDatabase_ref) {
		this.searchDatabase_ref = searchDatabase_ref;
	}
}
