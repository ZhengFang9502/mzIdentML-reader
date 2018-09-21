package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.InputSpectra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class InputSpectraReader {
	private static Logger logger = LoggerFactory.getLogger(InputSpectraReader.class);

	public static InputSpectra read(XMLStreamReader reader) {
		InputSpectra inputSpectra = new InputSpectra();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "spectraData_ref":
					inputSpectra.setSpectraData_ref(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in InputSpectra section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in InputSpectra section: " + attributeName);
			}
		}
		return inputSpectra;
	}
}
