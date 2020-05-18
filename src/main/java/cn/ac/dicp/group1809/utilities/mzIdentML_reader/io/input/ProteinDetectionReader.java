package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.InputSpectrumIdentifications;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinDetection;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ProteinDetectionReader {
	public static ProteinDetection read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ProteinDetection proteinDetection = new ProteinDetection();
		ProtocolApplicationReader.read(reader, proteinDetection);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "proteinDetectionList_ref":
					proteinDetection.setProteinDetectionList_ref(attributeValue);
					break;
				case "proteinDetectionProtocol_ref":
					proteinDetection.setProteinDetectionProtocol_ref(attributeValue);
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in ProteinDetection section: " + attributeName);
			}
		}

		List<InputSpectrumIdentifications> inputSpectrumIdentifications = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("InputSpectrumIdentifications".equals(localName)) {
						InputSpectrumIdentifications spectrumIdentifications = InputSpectrumIdentificationsReader.read(reader);
						inputSpectrumIdentifications.add(spectrumIdentifications);
					} else {
						throw new IllegalArgumentException("Invalid local name in ProteinDetection section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		proteinDetection.setInputSpectrumIdentifications(inputSpectrumIdentifications);
		return proteinDetection;
	}
}
