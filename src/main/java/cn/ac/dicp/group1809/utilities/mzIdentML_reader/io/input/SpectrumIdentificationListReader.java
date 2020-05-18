package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FragmentationTable;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationList;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationResult;

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
	public static SpectrumIdentificationList read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		SpectrumIdentificationList spectrumIdentificationList = new SpectrumIdentificationList();

		IdentifiableReader.read(reader, spectrumIdentificationList);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("numSequencesSearched".equals(attributeName)) {
				spectrumIdentificationList.setNumSequencesSearched(Long.valueOf(attributeValue));
			}
		}

		List<SpectrumIdentificationResult> spectrumIdentificationResults = new ArrayList<>();
		List<AbstractParam> paramGroup = new ArrayList<>();

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
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
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
		spectrumIdentificationList.setParamGroup(paramGroup);
		return spectrumIdentificationList;
	}
}
