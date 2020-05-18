package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Zheng Fang 2020/5/18
 * @since V1.0.0
 */
public class AbstractParamReader {
	public static AbstractParam read(XMLStreamReader reader) throws XMLStreamException {
		AbstractParam abstractParam;
		String name = reader.getLocalName();
		switch (name) {
			case "cvParam":
				abstractParam = CVParamReader.read(reader);
				break;
			case "userParam":
				abstractParam = UserParamReader.read(reader);
				break;
			default:
				throw new IllegalArgumentException("Invalid local name in Param section: " + name);
		}
		String localName;
		while (reader.hasNext()) {
			int next = reader.next();
			if (next == XMLStreamReader.END_ELEMENT) {
				localName = reader.getLocalName();
				if (name.equals(localName)) {
					break;
				}
			}
		}
		return abstractParam;
	}
}
