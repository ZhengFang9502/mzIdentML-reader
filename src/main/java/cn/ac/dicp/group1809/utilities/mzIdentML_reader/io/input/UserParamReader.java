package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.UserParam;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class UserParamReader {
	public static UserParam read(XMLStreamReader reader) {
		UserParam userParam = new UserParam();
		AbstractParamReader.read(reader, userParam);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("type".equals(attributeName)) {
				userParam.setType(attributeValue);
			}
		}
		return userParam;
	}
}
