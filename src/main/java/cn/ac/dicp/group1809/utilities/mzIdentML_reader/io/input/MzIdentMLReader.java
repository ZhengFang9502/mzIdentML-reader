package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class MzIdentMLReader {
	private Logger logger = LoggerFactory.getLogger(MzIdentMLReader.class);

	public MzIdentMLReader() {
	}

	public MzIdentML read(String path) throws XMLStreamException, IOException {
		String extension = FilenameUtils.getExtension(path);
		if (!extension.equals("mzid")) {
			logger.error("Invalid mzIdentML file format: " + path);
			throw new IllegalArgumentException("Invalid mzIdentML file format: " + path);
		}
		logger.info("Reading mzIdentML file: " + path);
		FileInputStream inputStream = new FileInputStream(new File(path));
		XMLInputFactory factory = XMLInputFactory.newInstance();
		MzIdentML mzIdentML = null;
		XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("MzIdentML".equals(localName)) {
						mzIdentML = readMzIdentML(reader);
					} else {
						throw new IllegalArgumentException("Invalid local name in MzIdentML section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					String name = reader.getLocalName();
					if (name.equals("MzIdentML")) {
						break loop;
					}
			}
		}
		reader.close();
		inputStream.close();
		return mzIdentML;
	}

	private MzIdentML readMzIdentML(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		MzIdentML mzIdentML = new MzIdentML();
		IdentifiableReader.read(reader, mzIdentML);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "creationDate":
					mzIdentML.setCreationDate(attributeValue);
					break;
				case "version":
					mzIdentML.setVersion(attributeValue);
					break;
			}
		}

		List<BibliographicReference> bibliographicReferences = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "cvList":
							CVList cvList = CVListReader.read(reader);
							mzIdentML.setCvList(cvList);
							break;
						case "AnalysisSoftwareList":
							AnalysisSoftwareList analysisSoftwareList = AnalysisSoftwareListReader.read(reader);
							mzIdentML.setAnalysisSoftwareList(analysisSoftwareList);
							break;
						case "Provider":
							Provider provider = ProviderReader.read(reader);
							mzIdentML.setProvider(provider);
							break;
						case "AuditCollection":
							AuditCollection auditCollection = AuditCollectionReader.read(reader);
							mzIdentML.setAuditCollection(auditCollection);
							break;
						case "AnalysisSampleCollection":
							AnalysisSampleCollection analysisSampleCollection = AnalysisSampleCollectionReader.read(reader);
							mzIdentML.setAnalysisSampleCollection(analysisSampleCollection);
							break;
						case "SequenceCollection":
							SequenceCollection sequenceCollection = SequenceCollectionReader.read(reader);
							mzIdentML.setSequenceCollection(sequenceCollection);
							break;
						case "AnalysisCollection":
							AnalysisCollection analysisCollection = AnalysisCollectionReader.read(reader);
							mzIdentML.setAnalysisCollection(analysisCollection);
							break;
						case "AnalysisProtocolCollection":
							AnalysisProtocolCollection analysisProtocolCollection = AnalysisProtocolCollectionReader.read(reader);
							mzIdentML.setAnalysisProtocolCollection(analysisProtocolCollection);
							break;
						case "DataCollection":
							DataCollection dataCollection = DataCollectionReader.read(reader);
							mzIdentML.setDataCollection(dataCollection);
							break;
						case "BibliographicReference":
							BibliographicReference bibliographicReference = BibliographicReferenceReader.read(reader);
							bibliographicReferences.add(bibliographicReference);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in MzIdentML section: " + localName);
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
		mzIdentML.setBibliographicReference(bibliographicReferences);
		return mzIdentML;
	}
}
