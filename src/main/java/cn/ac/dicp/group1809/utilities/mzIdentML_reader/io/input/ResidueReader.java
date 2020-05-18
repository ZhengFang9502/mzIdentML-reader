package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Residue;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ResidueReader {
	public static Residue read(XMLStreamReader reader) {
		Residue residue = new Residue();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "code":
					residue.setCode(attributeValue);
					break;
				case "mass":
					residue.setMass(Float.valueOf(attributeValue));
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in Residue section: " + attributeName);
			}
		}
		return residue;
	}
}
