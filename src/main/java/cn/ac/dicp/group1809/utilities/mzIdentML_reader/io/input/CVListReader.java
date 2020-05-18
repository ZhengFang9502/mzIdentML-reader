package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CV;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVList;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class CVListReader {
	public static CVList read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		CVList cvList = new CVList();
		List<CV> cvs = new ArrayList<>();
		String localName;

		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("cv".equals(localName)) {
						CV cv = CVReader.read(reader);
						cvs.add(cv);
					} else {
						throw new IllegalArgumentException("Invalid local name in CVList section: " + localName);
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
		cvList.setCv(cvs);
		return cvList;
	}
}
