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
public class SpectrumIdentificationProtocolReader {
	private static Logger logger = LoggerFactory.getLogger(SpectrumIdentificationProtocolReader.class);

	public static SpectrumIdentificationProtocol read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		SpectrumIdentificationProtocol spectrumIdentificationProtocol = new SpectrumIdentificationProtocol();
		IdentifiableReader.read(reader, spectrumIdentificationProtocol);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "analysisSoftware_ref":
					spectrumIdentificationProtocol.setAnalysisSoftware_ref(attributeValue);
					break;
			}
		}

		List<MassTable> massTables = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SearchType":
							Param searchType = ParamReader.read(reader);
							spectrumIdentificationProtocol.setSearchType(searchType);
							break;
						case "AdditionalSearchParams":
							ParamList additionalSearchParams = ParamListReader.read(reader);
							spectrumIdentificationProtocol.setAdditionalSearchParams(additionalSearchParams);
							break;
						case "ModificationParams":
							ModificationParams modificationParams = ModificationParamsReader.read(reader);
							spectrumIdentificationProtocol.setModificationParams(modificationParams);
							break;
						case "Enzymes":
							Enzymes enzymes = EnzymesReader.read(reader);
							spectrumIdentificationProtocol.setEnzymes(enzymes);
							break;
						case "MassTable":
							MassTable massTable = MassTableReader.read(reader);
							massTables.add(massTable);
							break;
						case "FragmentTolerance":
							Tolerance fragmentTolerance = ToleranceReader.read(reader);
							spectrumIdentificationProtocol.setFragmentTolerance(fragmentTolerance);
							break;
						case "ParentTolerance":
							Tolerance parentTolerance = ToleranceReader.read(reader);
							spectrumIdentificationProtocol.setParentTolerance(parentTolerance);
							break;
						case "Threshold":
							ParamList threshold = ParamListReader.read(reader);
							spectrumIdentificationProtocol.setThreshold(threshold);
							break;
						case "DatabaseFilters":
							DatabaseFilters databaseFilters = DatabaseFiltersReader.read(reader);
							spectrumIdentificationProtocol.setDatabaseFilters(databaseFilters);
							break;
						case "DatabaseTranslation":
							DatabaseTranslation databaseTranslation = DatabaseTranslationReader.read(reader);
							spectrumIdentificationProtocol.setDatabaseTranslation(databaseTranslation);
							break;
						default:
							logger.error("Invalid local name in SpectrumIdentificationProtocol section: " + localName);
							throw new IllegalArgumentException("Invalid local name in SpectrumIdentificationProtocol section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		spectrumIdentificationProtocol.setMassTable(massTables);
		return spectrumIdentificationProtocol;
	}
}

