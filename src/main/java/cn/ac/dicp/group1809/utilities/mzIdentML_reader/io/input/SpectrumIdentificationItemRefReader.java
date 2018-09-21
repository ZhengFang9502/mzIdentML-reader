package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationItemRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SpectrumIdentificationItemRefReader {
	private static Logger logger = LoggerFactory.getLogger(SpectrumIdentificationItemRefReader.class);

	public static SpectrumIdentificationItemRef read(XMLStreamReader reader) {
		SpectrumIdentificationItemRef spectrumIdentificationItemRef = new SpectrumIdentificationItemRef();

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "spectrumIdentificationItem_ref":
					spectrumIdentificationItemRef.setSpectrumIdentificationItem_ref(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in SpectrumIdentificationItemRef section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in SpectrumIdentificationItemRef section: " + attributeName);
			}
		}
		return spectrumIdentificationItemRef;
	}
}
