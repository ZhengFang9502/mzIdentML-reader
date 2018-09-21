package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class CVParamReader {
	private static Logger logger = LoggerFactory.getLogger(CVParamReader.class);

	public static CVParam read(XMLStreamReader reader) {
		CVParam cvParam = new CVParam();
		AbstractParamReader.read(reader, cvParam);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "cvRef":
					cvParam.setCvRef(attributeValue);
					break;
				case "accession":
					cvParam.setAccession(attributeValue);
					break;
				case "name":
				case "value":
				case "unitAccession":
				case "unitName":
				case "unitCvRef":
					break;
				default:
					logger.error("Invalid attribute name in CVParam section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in CVParam section: " + attributeName);
			}
		}
		return cvParam;
	}
}
