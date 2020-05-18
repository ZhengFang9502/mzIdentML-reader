package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FileFormat;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SourceFile;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SourceFileReader {
	public static SourceFile read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		SourceFile sourceFile = new SourceFile();
		ExternalDataReader.read(reader, sourceFile);

		List<AbstractParam> paramGroup = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "ExternalFormatDocumentation":
							sourceFile.setExternalFormatDocumentation(new UriAdapter().unmarshal(reader.getElementText()));
							break;
						case "FileFormat":
							FileFormat fileFormat = FileFormatReader.read(reader);
							sourceFile.setFileFormat(fileFormat);
							break;
						case "cvParam":
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in SourceFile section: " + localName);
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
		sourceFile.setParamGroup(paramGroup);
		return sourceFile;
	}
}
