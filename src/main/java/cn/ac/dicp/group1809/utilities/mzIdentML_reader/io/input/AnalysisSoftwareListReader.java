package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisSoftware;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisSoftwareList;
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
public class AnalysisSoftwareListReader {
	private static Logger logger = LoggerFactory.getLogger(AnalysisSoftwareListReader.class);

	public static AnalysisSoftwareList read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AnalysisSoftwareList analysisSoftwareList = new AnalysisSoftwareList();
		List<AnalysisSoftware> analysisSoftwares = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("AnalysisSoftware".equals(localName)) {
						AnalysisSoftware analysisSoftware = AnalysisSoftwareReader.read(reader);
						analysisSoftwares.add(analysisSoftware);
					} else {
						logger.error("Invalid local name in AnalysisSoftwareList section: " + localName);
						throw new IllegalArgumentException("Invalid local name in AnalysisSoftwareList section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		analysisSoftwareList.setAnalysisSoftware(analysisSoftwares);
		return analysisSoftwareList;
	}
}
