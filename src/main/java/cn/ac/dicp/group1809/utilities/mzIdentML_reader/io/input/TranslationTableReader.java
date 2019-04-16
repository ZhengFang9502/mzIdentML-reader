package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.TranslationTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class TranslationTableReader {
	private static Logger logger = LoggerFactory.getLogger(TranslationTableReader.class);

	public static TranslationTable read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		TranslationTable translationTable = new TranslationTable();
		IdentifiableReader.read(reader, translationTable);
		List<CVParam> cvParams = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("cvParam".equals(localName)) {
						CVParam cvParam = CVParamReader.read(reader);
						cvParams.add(cvParam);
					} else {
						logger.error("Invalid local name in TranslationTable section: " + localName);
						throw new IllegalArgumentException("Invalid local name in TranslationTable section: " + localName);
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
		translationTable.setCvParam(cvParams);
		return translationTable;
	}
}
