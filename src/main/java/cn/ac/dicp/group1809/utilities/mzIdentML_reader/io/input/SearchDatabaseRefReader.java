package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.InputSpectra;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SearchDatabaseRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SearchDatabaseRefReader {
	private static Logger logger = LoggerFactory.getLogger(SearchDatabaseRefReader.class);

	public static SearchDatabaseRef read(XMLStreamReader reader) {
		SearchDatabaseRef searchDatabaseRef = new SearchDatabaseRef();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("searchDatabase_ref".equals(attributeName)) {
				searchDatabaseRef.setSearchDatabase_ref(attributeValue);
			} else {
				logger.error("Invalid attribute name in SearchDatabaseRef section: " + attributeName);
				throw new IllegalArgumentException("Invalid attribute name in SearchDatabaseRef section: " + attributeName);
			}
		}
		return searchDatabaseRef;
	}
}
