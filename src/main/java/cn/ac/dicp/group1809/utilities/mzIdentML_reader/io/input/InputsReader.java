package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Inputs;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SearchDatabase;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SourceFile;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectraData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class InputsReader {
	private static Logger logger = LoggerFactory.getLogger(InputsReader.class);

	public static Inputs read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		Inputs inputs = new Inputs();
		List<SourceFile> sourceFiles = new ArrayList<>();
		List<SearchDatabase> searchDatabases = new ArrayList<>();
		List<SpectraData> spectraData = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SourceFile":
							SourceFile sourceFile = SourceFileReader.read(reader);
							sourceFiles.add(sourceFile);
							break;
						case "SearchDatabase":
							SearchDatabase searchDatabase = SearchDatabaseReader.read(reader);
							searchDatabases.add(searchDatabase);
							break;
						case "SpectraData":
							SpectraData data = SpectraDataReader.read(reader);
							spectraData.add(data);
							break;
						default:
							logger.error("Invalid local name in Inputs section: " + localName);
							throw new IllegalArgumentException("Invalid local name in Inputs section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		inputs.setSourceFile(sourceFiles);
		inputs.setSearchDatabase(searchDatabases);
		inputs.setSpectraData(spectraData);
		return inputs;
	}
}
