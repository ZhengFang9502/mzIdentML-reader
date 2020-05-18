package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinAmbiguityGroup;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinDetectionList;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ProteinDetectionListReader {
	public static ProteinDetectionList read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ProteinDetectionList proteinDetectionList = new ProteinDetectionList();
		IdentifiableReader.read(reader, proteinDetectionList);
		List<ProteinAmbiguityGroup> proteinAmbiguityGroups = new ArrayList<>();
		List<AbstractParam> paramGroup = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "ProteinAmbiguityGroup":
							ProteinAmbiguityGroup proteinAmbiguityGroup = ProteinAmbiguityGroupReader.read(reader);
							proteinAmbiguityGroups.add(proteinAmbiguityGroup);
							break;
						case "cvParam":
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in ProteinDetectionList section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		proteinDetectionList.setParamGroup(paramGroup);
		proteinDetectionList.setProteinAmbiguityGroup(proteinAmbiguityGroups);
		return proteinDetectionList;
	}
}
