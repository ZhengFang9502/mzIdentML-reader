package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class SpectrumIdentificationListReader {
	private static Logger logger = LoggerFactory.getLogger(SpectrumIdentificationListReader.class);

	public static SpectrumIdentificationList read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		SpectrumIdentificationList spectrumIdentificationList = new SpectrumIdentificationList();

		IdentifiableReader.read(reader, spectrumIdentificationList);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "numSequencesSearched":
					spectrumIdentificationList.setNumSequencesSearched(Long.valueOf(attributeValue));
					break;
			}
		}

		List<SpectrumIdentificationResult> spectrumIdentificationResults = new ArrayList<>();
		List<ParamGroup> paramGroups = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "FragmentationTable":
							FragmentationTable fragmentationTable = FragmentationTableReader.read(reader);
							spectrumIdentificationList.setFragmentationTable(fragmentationTable);
							break;
						case "SpectrumIdentificationResult":
							SpectrumIdentificationResult spectrumIdentificationResult = SpectrumIdentificationResultReader.read(reader);
							spectrumIdentificationResults.add(spectrumIdentificationResult);
							break;
						case "cvParam":
							ParamGroup cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							ParamGroup userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						default:
							logger.error("Invalid local name in SpectrumIdentificationList section: " + localName);
							throw new IllegalArgumentException("Invalid local name in SpectrumIdentificationList section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		spectrumIdentificationList.setSpectrumIdentificationResult(spectrumIdentificationResults);
		spectrumIdentificationList.setParamGroupList(paramGroups);
		return spectrumIdentificationList;
	}
}
