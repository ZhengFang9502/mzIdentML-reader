package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SubSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SubSampleReader {
	private static Logger logger = LoggerFactory.getLogger(SubSampleReader.class);

	public static SubSample read(XMLStreamReader reader) {
		SubSample subSample = new SubSample();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "sample_ref":
					subSample.setSample_ref(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in SubSample section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in SubSample section: " + attributeName);
			}
		}
		return subSample;
	}
}
