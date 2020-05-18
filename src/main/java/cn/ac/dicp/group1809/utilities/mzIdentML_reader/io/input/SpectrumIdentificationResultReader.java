package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationItem;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationResult;

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
		List<AbstractParam> paramGroup = new ArrayList<>();
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
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
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
		spectrumIdentificationResult.setParamGroup(paramGroup);
		return spectrumIdentificationResult;
	}
}
