package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParamList;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheng Fang 2020/5/18
 * @since V1.0.0
 */
public class ParamListReader {
	public static ParamList read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ParamList paramList = new ParamList();
		List<AbstractParam> paramGroup = new ArrayList<>();
		String localName;
		l1:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "cvParam":
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in ParamList section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (localName.equals(name)) {
						break l1;
					}
					break;
			}
		}
		paramList.setParamGroup(paramGroup);
		return paramList;
	}
}
