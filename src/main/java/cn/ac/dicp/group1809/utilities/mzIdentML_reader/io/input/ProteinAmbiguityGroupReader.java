package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinAmbiguityGroup;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProteinDetectionHypothesis;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ProteinAmbiguityGroupReader {
	public static ProteinAmbiguityGroup read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		ProteinAmbiguityGroup proteinAmbiguityGroup = new ProteinAmbiguityGroup();

		IdentifiableReader.read(reader, proteinAmbiguityGroup);

		List<ProteinDetectionHypothesis> proteinDetectionHypotheses = new ArrayList<>();
		List<AbstractParam> paramGroup = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "ProteinDetectionHypothesis":
							ProteinDetectionHypothesis proteinDetectionHypothesis = ProteinDetectionHypothesisReader.read(reader);
							proteinDetectionHypotheses.add(proteinDetectionHypothesis);
							break;
						case "cvParam":
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in ProteinAmbiguityGroup section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		proteinAmbiguityGroup.setParamGroup(paramGroup);
		proteinAmbiguityGroup.setProteinDetectionHypothesis(proteinDetectionHypotheses);
		return proteinAmbiguityGroup;
	}
}
