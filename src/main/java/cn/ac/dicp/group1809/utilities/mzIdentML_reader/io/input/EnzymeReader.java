package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Enzyme;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParamList;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.Map;

import static java.lang.System.out;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class EnzymeReader {
	public static Enzyme read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Enzyme enzyme = new Enzyme();
		IdentifiableReader.read(reader, enzyme);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "nTermGain":
					enzyme.setnTermGain(attributeValue);
					break;
				case "cTermGain":
					enzyme.setcTermGain(attributeValue);
					break;
				case "semiSpecific":
					enzyme.setSemiSpecific(Boolean.valueOf(attributeValue));
					break;
				case "missedCleavages":
					enzyme.setMissedCleavages(Integer.valueOf(attributeValue));
					break;
				case "minDistance":
					out.println(reader.getLocation().getLineNumber());
					enzyme.setMinDistance(Integer.valueOf(attributeValue));
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in Enzyme section: " + attributeName);
			}
		}

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SiteRegexp":
							enzyme.setSiteRegexp(reader.getElementText());
							break;
						case "EnzymeName":
							ParamList enzymeName = ParamListReader.read(reader);
							enzyme.setEnzymeName(enzymeName);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in Enzyme section: " + localName);
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
		return enzyme;
	}
}
