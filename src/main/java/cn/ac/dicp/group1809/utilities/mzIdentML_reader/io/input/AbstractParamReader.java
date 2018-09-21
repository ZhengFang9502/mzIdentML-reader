package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AbstractParamReader {
	public static void read(XMLStreamReader reader, AbstractParam abstractParam) {
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "name":
					abstractParam.setName(attributeValue);
					break;
				case "value":
					abstractParam.setValue(attributeValue);
					break;
				case "unitAccession":
					abstractParam.setUnitAccession(attributeValue);
					break;
				case "unitName":
					abstractParam.setUnitName(attributeValue);
					break;
				case "unitCvRef":
					abstractParam.setUnitCvRef(attributeValue);
					break;
			}
		}
	}
}
