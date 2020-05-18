package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FileFormat;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Param;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SearchDatabase;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SearchDatabaseReader {
	public static SearchDatabase read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		SearchDatabase searchDatabase = new SearchDatabase();
		ExternalDataReader.read(reader, searchDatabase);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "version":
					searchDatabase.setVersion(attributeValue);
					break;
				case "releaseDate":
					searchDatabase.setReleaseDate(attributeValue);
					break;
				case "numDatabaseSequences":
					searchDatabase.setNumDatabaseSequences(Long.valueOf(attributeValue));
					break;
				case "numResidues":
					searchDatabase.setNumResidues(Long.valueOf(attributeValue));
					break;
				case "id":
				case "name":
				case "location":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in SearchDatabase section: " + attributeName);
			}
		}

		List<CVParam> cvParams = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "ExternalFormatDocumentation":
							searchDatabase.setExternalFormatDocumentation(new UriAdapter().unmarshal(reader.getElementText()));
							break;
						case "FileFormat":
							FileFormat fileFormat = FileFormatReader.read(reader);
							searchDatabase.setFileFormat(fileFormat);
							break;
						case "DatabaseName":
							Param databaseName = ParamReader.read(reader);
							searchDatabase.setDatabaseName(databaseName);
							break;
						case "cvParam":
							CVParam cvParam = CVParamReader.read(reader);
							cvParams.add(cvParam);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in SearchDatabase section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		searchDatabase.setCvParam(cvParams);
		return searchDatabase;
	}
}
