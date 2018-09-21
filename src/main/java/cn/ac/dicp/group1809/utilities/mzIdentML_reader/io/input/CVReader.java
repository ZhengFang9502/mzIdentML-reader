package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CV;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.net.URI;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class CVReader {
	private static Logger logger = LoggerFactory.getLogger(CVReader.class);

	public static CV read(XMLStreamReader reader) {
		CV cv = new CV();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "fullName":
					cv.setFullName(attributeValue);
					break;
				case "version":
					cv.setVersion(attributeValue);
					break;
				case "uri":
					URI uri = new UriAdapter().unmarshal(attributeValue);
					cv.setUri(uri);
					break;
				case "id":
					cv.setId(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in cv section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in cv section: " + attributeName);
			}
		}
		return cv;
	}
}
