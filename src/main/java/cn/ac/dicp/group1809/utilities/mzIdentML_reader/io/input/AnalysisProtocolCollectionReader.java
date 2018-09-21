package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisProtocolCollection;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinDetectionProtocol;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIdentificationProtocol;
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
public class AnalysisProtocolCollectionReader {
	private static Logger logger = LoggerFactory.getLogger(AnalysisProtocolCollectionReader.class);

	public static AnalysisProtocolCollection read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AnalysisProtocolCollection analysisProtocolCollection = new AnalysisProtocolCollection();
		List<SpectrumIdentificationProtocol> spectrumIdentificationProtocols = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "SpectrumIdentificationProtocol":
							SpectrumIdentificationProtocol spectrumIdentificationProtocol = SpectrumIdentificationProtocolReader.read(reader);
							spectrumIdentificationProtocols.add(spectrumIdentificationProtocol);
							break;
						case "ProteinDetectionProtocol":
							ProteinDetectionProtocol proteinDetectionProtocol = ProteinDetectionProtocolReader.read(reader);
							analysisProtocolCollection.setProteinDetectionProtocol(proteinDetectionProtocol);
							break;
						default:
							logger.error("Invalid local name in AnalysisProtocolCollection section: " + localName);
							throw new IllegalArgumentException("Invalid local name in AnalysisProtocolCollection section: " + localName);
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
		analysisProtocolCollection.setSpectrumIdentificationProtocol(spectrumIdentificationProtocols);
		return analysisProtocolCollection;
	}
}
