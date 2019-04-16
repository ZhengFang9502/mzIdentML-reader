package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SpectrumIdentificationResultReader {
	private static Logger logger = LoggerFactory.getLogger(SpectrumIdentificationResultReader.class);

	public static SpectrumIdentificationResult read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		SpectrumIdentificationResult spectrumIdentificationResult = new SpectrumIdentificationResult();
		IdentifiableReader.read(reader, spectrumIdentificationResult);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "spectrumID":
					spectrumIdentificationResult.setSpectrumID(attributeValue);
					break;
				case "spectraData_ref":
					spectrumIdentificationResult.setSpectraData_ref(attributeValue);
					break;
			}
		}

		List<SpectrumIdentificationItem> spectrumIdentificationItems = new ArrayList<>();
		List<AbstractParam> paramGroups = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SpectrumIdentificationItem":
							SpectrumIdentificationItem spectrumIdentificationItem = SpectrumIdentificationItemReader.read(reader);
							spectrumIdentificationItems.add(spectrumIdentificationItem);
							break;
						case "cvParam":
							AbstractParam cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							AbstractParam userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						default:
							logger.error("Invalid local name in SpectrumIdentificationResult section: " + localName);
							throw new IllegalArgumentException("Invalid local name in SpectrumIdentificationResult section: " + localName);
					}
					break;
				case XMLStreamReader.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
					break;
			}
		}
		spectrumIdentificationResult.setSpectrumIdentificationItem(spectrumIdentificationItems);
		spectrumIdentificationResult.setParamGroupList(paramGroups);
		return spectrumIdentificationResult;
	}
}
