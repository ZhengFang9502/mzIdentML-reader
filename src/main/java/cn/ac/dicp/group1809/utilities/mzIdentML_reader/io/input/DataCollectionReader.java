package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisData;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.DataCollection;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Inputs;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class DataCollectionReader {
	public static DataCollection read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		DataCollection dataCollection = new DataCollection();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "Inputs":
							Inputs inputs = InputsReader.read(reader);
							dataCollection.setInputs(inputs);
							break;
						case "AnalysisData":
							AnalysisData analysisData = AnalysisDataReader.read(reader);
							dataCollection.setAnalysisData(analysisData);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in DataCollection section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		return dataCollection;
	}
}
