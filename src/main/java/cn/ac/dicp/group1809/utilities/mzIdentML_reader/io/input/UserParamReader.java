package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.UserParam;

import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/8/25
 * @since V1.0
 */
public class UserParamReader {
	public static UserParam read(XMLStreamReader reader) {
		UserParam userParam = new UserParam();
		int count = reader.getAttributeCount();
		for (int i = 0; i < count; i++) {
			String attributeLocalName = reader.getAttributeLocalName(i);
			String attributeValue = reader.getAttributeValue(i);
			switch (attributeLocalName) {
				case "name":
					userParam.setName(attributeValue);
					break;
				case "type":
					userParam.setType(attributeValue);
					break;
				case "unitAccession":
					userParam.setUnitAccession(attributeValue);
					break;
				case "unitCvRef":
					userParam.setUnitCvRef(attributeValue);
					break;
				case "unitName":
					userParam.setUnitName(attributeValue);
					break;
				case "value":
					userParam.setValue(attributeValue);
					break;
				default:
					throw new IllegalArgumentException("Invalid Attribute Local Name in User Param: " + attributeLocalName);
			}
		}
		return userParam;
	}
}
