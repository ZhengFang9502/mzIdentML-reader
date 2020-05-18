package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.InputSpectrumIdentifications;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class InputSpectrumIdentificationsReader {

	public static InputSpectrumIdentifications read(XMLStreamReader reader) {
		InputSpectrumIdentifications inputSpectrumIdentifications = new InputSpectrumIdentifications();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("spectrumIdentificationList_ref".equals(attributeName)) {
				inputSpectrumIdentifications.setSpectrumIdentificationList_ref(attributeValue);
			} else {
				throw new IllegalArgumentException("Invalid attribute name in InputSpectrumIdentifications section: " + attributeName);
			}
		}
		return inputSpectrumIdentifications;
	}
}
