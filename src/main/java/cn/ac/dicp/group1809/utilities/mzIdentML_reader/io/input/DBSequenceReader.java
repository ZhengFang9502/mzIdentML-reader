package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.DBSequence;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.UserParam;
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
public class DBSequenceReader {
	private static Logger logger = LoggerFactory.getLogger(DBSequenceReader.class);

	public static DBSequence read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		DBSequence dbSequence = new DBSequence();
		List<AbstractParam> paramGroupList = new ArrayList<>();
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
					logger.error("Invalid attribute name in DBSequence section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in DBSequence section: " + attributeName);
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
						case "Seq":
							String seq = reader.getElementText();
							dbSequence.setSeq(seq);
							break;
						case "cvParam":
							AbstractParam cvParam = ParamGroupReader.read(reader, new UserParam());
							paramGroupList.add(cvParam);
							break;
						case "userParam":
							AbstractParam userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroupList.add(userParam);
							break;
						default:
							logger.error("Invalid local name in DBSequence section: " + localName);
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
		dbSequence.setParamGroupList(paramGroupList);
		return dbSequence;
	}
}
