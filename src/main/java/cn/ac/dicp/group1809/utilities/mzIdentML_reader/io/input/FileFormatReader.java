package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FileFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class FileFormatReader {
	private static Logger logger = LoggerFactory.getLogger(FileFormatReader.class);

	public static FileFormat read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		FileFormat fileFormat = new FileFormat();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("cvParam".equals(localName)) {
						CVParam cvParam = CVParamReader.read(reader);
						fileFormat.setCvParam(cvParam);
					} else {
						logger.error("Invalid local name in FileFormat section: " + localName);
						throw new IllegalArgumentException("Invalid local name in FileFormat section: " + localName);
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
		return fileFormat;
	}
}
