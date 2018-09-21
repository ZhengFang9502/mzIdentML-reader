package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpecificityRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SpecificityRulesReader {
	private static Logger logger = LoggerFactory.getLogger(SpecificityRulesReader.class);

	public static SpecificityRules read(XMLStreamReader reader) throws XMLStreamException {
		SpecificityRules specificityRules = new SpecificityRules();
		String name = reader.getLocalName();
		List<CVParam> cvParams = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "cvParam":
							CVParam cvParam = CVParamReader.read(reader);
							cvParams.add(cvParam);
							break;
						default:
							logger.error("Invalid local name in SpecificityRules section: " + localName);
							throw new IllegalArgumentException("Invalid local name in SpecificityRules section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		specificityRules.setCvParam(cvParams);
		return specificityRules;
	}
}
