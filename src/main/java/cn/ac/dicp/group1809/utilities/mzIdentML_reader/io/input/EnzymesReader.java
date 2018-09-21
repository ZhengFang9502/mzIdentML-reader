package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Enzyme;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Enzymes;
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
public class EnzymesReader {
	private static Logger logger = LoggerFactory.getLogger(EnzymesReader.class);

	public static Enzymes read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Enzymes enzymes = new Enzymes();

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "independent":
					enzymes.setIndependent(attributeValue.equals("true"));
					break;
				default:
					logger.error("Invalid attribute name in Enzymes section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in Enzymes section: " + attributeName);
			}
		}

		List<Enzyme> enzymeList = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "Enzyme":
							Enzyme enzyme = EnzymeReader.read(reader);
							enzymeList.add(enzyme);
							break;
						default:
							logger.error("Invalid local name in Enzymes section: " + localName);
							throw new IllegalArgumentException("Invalid local name in Enzymes section: " + localName);
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
		enzymes.setEnzyme(enzymeList);
		return enzymes;
	}
}
