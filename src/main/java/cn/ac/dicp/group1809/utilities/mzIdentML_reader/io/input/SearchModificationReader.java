package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SearchModification;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpecificityRules;
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
public class SearchModificationReader {
	private static Logger logger = LoggerFactory.getLogger(SearchModificationReader.class);

	public static SearchModification read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		SearchModification searchModification = new SearchModification();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "fixedMod":
					searchModification.setFixedMod(attributeValue.equals("true"));
					break;
				case "massDelta":
					searchModification.setMassDelta(Double.valueOf(attributeValue));
					break;
				case "residues":
					searchModification.setResidues(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in SearchModification section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in SearchModification section: " + attributeName);
			}
		}

		List<SpecificityRules> specificityRules = new ArrayList<>();
		List<CVParam> cvParams = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SpecificityRules":
							SpecificityRules rules = SpecificityRulesReader.read(reader);
							specificityRules.add(rules);
							break;
						case "cvParam":
							CVParam cvParam = CVParamReader.read(reader);
							cvParams.add(cvParam);
							break;
						default:
							logger.error("Invalid local name in SearchModification section: " + localName);
							throw new IllegalArgumentException("Invalid local name in SearchModification section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		searchModification.setSpecificityRules(specificityRules);
		searchModification.setCvParam(cvParams);
		return searchModification;
	}
}
