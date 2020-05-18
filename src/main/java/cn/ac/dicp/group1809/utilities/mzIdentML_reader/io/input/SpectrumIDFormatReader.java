package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIDFormat;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SpectrumIDFormatReader {
	public static SpectrumIDFormat read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		SpectrumIDFormat spectrumIDFormat = new SpectrumIDFormat();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("cvParam".equals(localName)) {
						CVParam cvParam = CVParamReader.read(reader);
						spectrumIDFormat.setCvParam(cvParam);
					} else {
						throw new IllegalArgumentException("Invalid local name in SpectrumIDFormat section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		return spectrumIDFormat;
	}
}
