package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;

import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/8/24
 * @since V1.0
 */
public class CVParamReader {
	public static CVParam read(XMLStreamReader reader) {
		CVParam cvParam = new CVParam();
		int attributeCount = reader.getAttributeCount();
		for (int i = 0; i < attributeCount; i++) {
			String attributeLocalName = reader.getAttributeLocalName(i);
			String attributeValue = reader.getAttributeValue(i);
			switch (attributeLocalName) {
				case "cvRef":
					cvParam.setCvRef(attributeValue);
					break;
				case "accession":
					cvParam.setAccession(attributeValue);
					break;
				case "name":
					cvParam.setName(attributeValue);
					break;
				case "value":
					cvParam.setValue(attributeValue);
					break;
				case "unitCvRef":
					cvParam.setUnitCvRef(attributeValue);
					break;
				case "unitAccession":
					cvParam.setUnitAccession(attributeValue);
					break;
				case "unitName":
					cvParam.setUnitName(attributeValue);
					break;
				default:
					throw new IllegalArgumentException("Invalid Attribute Local Name in CV Param: " + attributeLocalName);
			}
		}
		return cvParam;
	}
}
