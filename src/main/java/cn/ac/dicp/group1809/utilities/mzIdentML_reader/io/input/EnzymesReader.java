package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Enzyme;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Enzymes;

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
	public static Enzymes read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Enzymes enzymes = new Enzymes();

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("independent".equals(attributeName)) {
				enzymes.setIndependent(Boolean.valueOf(attributeValue));
			} else {
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
					if ("Enzyme".equals(localName)) {
						Enzyme enzyme = EnzymeReader.read(reader);
						enzymeList.add(enzyme);
					} else {
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
