package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.InputSpectra;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SearchDatabaseRef;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentification;
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
public class SpectrumIdentificationReader {
	private static Logger logger = LoggerFactory.getLogger(SpectrumIdentificationReader.class);

	public static SpectrumIdentification read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		SpectrumIdentification spectrumIdentification = new SpectrumIdentification();
		ProtocolApplicationReader.read(reader, spectrumIdentification);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "spectrumIdentificationProtocol_ref":
					spectrumIdentification.setSpectrumIdentificationProtocol_ref(attributeValue);
					break;
				case "spectrumIdentificationList_ref":
					spectrumIdentification.setSpectrumIdentificationList_ref(attributeValue);
					break;
			}
		}

		List<InputSpectra> inputSpectras = new ArrayList<>();
		List<SearchDatabaseRef> searchDatabaseRefs = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "InputSpectra":
							InputSpectra inputSpectra = InputSpectraReader.read(reader);
							inputSpectras.add(inputSpectra);
							break;
						case "SearchDatabaseRef":
							SearchDatabaseRef searchDatabaseRef = SearchDatabaseRefReader.read(reader);
							searchDatabaseRefs.add(searchDatabaseRef);
							break;
						default:
							logger.error("Invalid local name in SpectrumIdentification section: " + localName);
							throw new IllegalArgumentException("Invalid local name in SpectrumIdentification section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		spectrumIdentification.setInputSpectra(inputSpectras);
		spectrumIdentification.setSearchDatabaseRef(searchDatabaseRefs);
		return spectrumIdentification;
	}
}
