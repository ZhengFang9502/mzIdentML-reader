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
public class SpectrumIdentificationItemReader {
	private static Logger logger = LoggerFactory.getLogger(SpectrumIdentificationItemReader.class);

	public static SpectrumIdentificationItem read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		SpectrumIdentificationItem spectrumIdentificationItem = new SpectrumIdentificationItem();

		IdentifiableReader.read(reader, spectrumIdentificationItem);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "chargeState":
					spectrumIdentificationItem.setChargeState(Integer.valueOf(attributeValue));
					break;
				case "experimentalMassToCharge":
					spectrumIdentificationItem.setExperimentalMassToCharge(Double.valueOf(attributeValue));
					break;
				case "calculatedMassToCharge":
					spectrumIdentificationItem.setCalculatedMassToCharge(Double.valueOf(attributeValue));
					break;
				case "calculatedPI":
					spectrumIdentificationItem.setCalculatedPI(Float.valueOf(attributeValue));
					break;
				case "peptide_ref":
					spectrumIdentificationItem.setPeptide_ref(attributeValue);
					break;
				case "rank":
					spectrumIdentificationItem.setRank(Integer.valueOf(attributeValue));
					break;
				case "passThreshold":
					spectrumIdentificationItem.setPassThreshold(attributeValue.equals("true"));
					break;
				case "massTable_ref":
					spectrumIdentificationItem.setMassTable_ref(attributeValue);
					break;
				case "sample_ref":
					spectrumIdentificationItem.setSample_ref(attributeValue);
					break;
			}
		}

		List<PeptideEvidenceRef> peptideEvidenceRefs = new ArrayList<>();
		List<AbstractParam> paramGroups = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "PeptideEvidenceRef":
							PeptideEvidenceRef peptideEvidenceRef = PeptideEvidenceRefReader.read(reader);
							peptideEvidenceRefs.add(peptideEvidenceRef);
							break;
						case "Fragmentation":
							Fragmentation fragmentation = FragmentationReader.read(reader);
							spectrumIdentificationItem.setFragmentation(fragmentation);
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
							logger.error("Invalid local name in SpectrumIdentificationItem section: " + localName);
							throw new IllegalArgumentException("Invalid local name in SpectrumIdentificationItem section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		spectrumIdentificationItem.setPeptideEvidenceRef(peptideEvidenceRefs);
		spectrumIdentificationItem.setParamGroupList(paramGroups);
		return spectrumIdentificationItem;
	}
}
