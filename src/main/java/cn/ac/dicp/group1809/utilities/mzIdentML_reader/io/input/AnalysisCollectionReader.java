package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisCollection;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinDetection;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentification;
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
public class AnalysisCollectionReader {
	private static Logger logger = LoggerFactory.getLogger(AnalysisCollectionReader.class);

	public static AnalysisCollection read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AnalysisCollection analysisCollection = new AnalysisCollection();
		List<SpectrumIdentification> spectrumIdentifications = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SpectrumIdentification":
							SpectrumIdentification spectrumIdentification = SpectrumIdentificationReader.read(reader);
							spectrumIdentifications.add(spectrumIdentification);
							break;
						case "ProteinDetection":
							ProteinDetection proteinDetection = ProteinDetectionReader.read(reader);
							analysisCollection.setProteinDetection(proteinDetection);
							break;
						default:
							logger.error("Invalid local name in AnalysisCollection section: " + localName);
							throw new IllegalArgumentException("Invalid local name in AnalysisCollection section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		analysisCollection.setSpectrumIdentification(spectrumIdentifications);
		return analysisCollection;
	}
}
