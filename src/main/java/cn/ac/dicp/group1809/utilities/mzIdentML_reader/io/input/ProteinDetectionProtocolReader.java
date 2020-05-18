package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParamList;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinDetectionProtocol;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ProteinDetectionProtocolReader {
	public static ProteinDetectionProtocol read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ProteinDetectionProtocol proteinDetectionProtocol = new ProteinDetectionProtocol();
		IdentifiableReader.read(reader, proteinDetectionProtocol);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "analysisSoftware_ref":
					proteinDetectionProtocol.setAnalysisSoftware_ref(attributeValue);
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in ProteinDetectionProtocol section: " + attributeName);
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
						case "AnalysisParams":
							ParamList analysisParams = ParamListReader.read(reader);
							proteinDetectionProtocol.setAnalysisParams(analysisParams);
							break;
						case "Threshold":
							ParamList threshold = ParamListReader.read(reader);
							proteinDetectionProtocol.setThreshold(threshold);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in ProteinDetectionProtocol section: " + localName);
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
		return proteinDetectionProtocol;
	}
}
