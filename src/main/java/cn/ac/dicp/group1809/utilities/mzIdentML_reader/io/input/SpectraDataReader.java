package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FileFormat;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectraData;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SpectrumIDFormat;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SpectraDataReader {
	public static SpectraData read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		SpectraData spectraData = new SpectraData();
		ExternalDataReader.read(reader, spectraData);

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "ExternalFormatDocumentation":
							spectraData.setExternalFormatDocumentation(new UriAdapter().unmarshal(reader.getElementText()));
							break;
						case "FileFormat":
							FileFormat fileFormat = FileFormatReader.read(reader);
							spectraData.setFileFormat(fileFormat);
							break;
						case "SpectrumIDFormat":
							SpectrumIDFormat spectrumIDFormat = SpectrumIDFormatReader.read(reader);
							spectraData.setSpectrumIDFormat(spectrumIDFormat);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in SpectraData section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		return spectraData;
	}
}
