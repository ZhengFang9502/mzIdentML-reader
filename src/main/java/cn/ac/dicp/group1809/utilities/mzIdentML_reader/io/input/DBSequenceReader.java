package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.DBSequence;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class DBSequenceReader {

	public static DBSequence read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		DBSequence dbSequence = new DBSequence();
		IdentifiableReader.read(reader, dbSequence);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "length":
					dbSequence.setLength(Integer.valueOf(attributeValue));
					break;
				case "searchDatabase_ref":
					dbSequence.setSearchDatabase_ref(attributeValue);
					break;
				case "accession":
					dbSequence.setAccession(attributeValue);
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in DBSequence section: " + attributeName);
			}
		}

		List<AbstractParam> paramGroup = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "Seq":
							String seq = reader.getElementText();
							dbSequence.setSeq(seq);
							break;
						case "cvParam":
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in DBSequence section: " + localName);
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
		dbSequence.setParamGroup(paramGroup);
		return dbSequence;
	}
}
