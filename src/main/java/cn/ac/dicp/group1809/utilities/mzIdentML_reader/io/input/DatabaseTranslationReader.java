package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AllowedFrame;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.DatabaseTranslation;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.TranslationTable;
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
public class DatabaseTranslationReader {
	private static Logger logger = LoggerFactory.getLogger(DatabaseTranslationReader.class);

	public static DatabaseTranslation read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		DatabaseTranslation databaseTranslation = new DatabaseTranslation();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			if ("frames".equals(attributeName)) {
				String[] split = attributeValue.split(" ");
				List<AllowedFrame> frames = new ArrayList<>();
				for (String s : split) {
					frames.add(AllowedFrame.forAllowedFrame(Integer.valueOf(s)));
				}
				databaseTranslation.setFrames(frames);
			} else {
				logger.error("Invalid attribute name in DatabaseTranslation section: " + attributeName);
				throw new IllegalArgumentException("Invalid attribute name in DatabaseTranslation section: " + attributeName);
			}
		}

		List<TranslationTable> translationTables = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("TranslationTable".equals(localName)) {
						TranslationTable translationTable = TranslationTableReader.read(reader);
						translationTables.add(translationTable);
					} else {
						logger.error("Invalid local name in DatabaseTranslation section: " + localName);
						throw new IllegalArgumentException("Invalid local name in DatabaseTranslation section: " + localName);
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
		databaseTranslation.setTranslationTable(translationTables);
		return databaseTranslation;
	}
}
