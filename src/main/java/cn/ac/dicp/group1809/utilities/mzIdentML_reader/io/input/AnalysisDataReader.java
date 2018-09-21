package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisData;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinDetectionList;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationList;
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
public class AnalysisDataReader {
	private static Logger logger = LoggerFactory.getLogger(AnalysisDataReader.class);

	public static AnalysisData read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AnalysisData analysisData = new AnalysisData();
		List<SpectrumIdentificationList> spectrumIdentificationLists = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SpectrumIdentificationList":
							SpectrumIdentificationList spectrumIdentificationList = SpectrumIdentificationListReader.read(reader);
							spectrumIdentificationLists.add(spectrumIdentificationList);
							break;
						case "ProteinDetectionList":
							ProteinDetectionList proteinDetectionList = ProteinDetectionListReader.read(reader);
							analysisData.setProteinDetectionList(proteinDetectionList);
							break;
						default:
							logger.error("Invalid local name in AnalysisData section: " + localName);
							throw new IllegalArgumentException("Invalid local name in AnalysisData section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		analysisData.setSpectrumIdentificationList(spectrumIdentificationLists);
		return analysisData;
	}
}
