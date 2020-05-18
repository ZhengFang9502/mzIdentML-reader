package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AnalysisSampleCollection;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Sample;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class AnalysisSampleCollectionReader {
	public static AnalysisSampleCollection read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		AnalysisSampleCollection analysisSampleCollection = new AnalysisSampleCollection();
		List<Sample> samples = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("Sample".equals(localName)) {
						Sample sample = SampleReader.read(reader);
						samples.add(sample);
					} else {
						throw new IllegalArgumentException("Invalid local name in AnalysisSampleCollection section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		analysisSampleCollection.setSample(samples);
		return analysisSampleCollection;
	}
}
