package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationItemRef;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SpectrumIdentificationItemRefReader {
	public static SpectrumIdentificationItemRef read(XMLStreamReader reader) {
		SpectrumIdentificationItemRef spectrumIdentificationItemRef = new SpectrumIdentificationItemRef();

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("spectrumIdentificationItem_ref".equals(attributeName)) {
				spectrumIdentificationItemRef.setSpectrumIdentificationItem_ref(attributeValue);
			} else {
				throw new IllegalArgumentException("Invalid attribute name in SpectrumIdentificationItemRef section: " + attributeName);
			}
		}
		return spectrumIdentificationItemRef;
	}
}
