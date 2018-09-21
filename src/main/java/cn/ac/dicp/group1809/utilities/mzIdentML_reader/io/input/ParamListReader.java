package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParamGroup;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParamList;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.UserParam;
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
public class ParamListReader {
	private static Logger logger = LoggerFactory.getLogger(ParamListReader.class);

	public static ParamList read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ParamList paramList = new ParamList();
		List<ParamGroup> paramGroups = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "cvParam":
							ParamGroup cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							ParamGroup userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						default:
							logger.error("Invalid local name in ParamList section: " + localName);
							throw new IllegalArgumentException("Invalid local name in ParamList section: " + localName);
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
		paramList.setParamGroupList(paramGroups);
		return paramList;
	}
}
