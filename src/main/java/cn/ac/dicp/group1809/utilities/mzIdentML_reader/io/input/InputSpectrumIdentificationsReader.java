package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.InputSpectrumIdentifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class InputSpectrumIdentificationsReader {
	private static Logger logger = LoggerFactory.getLogger(InputSpectrumIdentificationsReader.class);

	public static InputSpectrumIdentifications read(XMLStreamReader reader) {
		InputSpectrumIdentifications inputSpectrumIdentifications = new InputSpectrumIdentifications();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "spectrumIdentificationList_ref":
					inputSpectrumIdentifications.setSpectrumIdentificationList_ref(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in InputSpectrumIdentifications section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in InputSpectrumIdentifications section: " + attributeName);
			}
		}
		return inputSpectrumIdentifications;
	}
}
