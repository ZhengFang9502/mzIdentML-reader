package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FragmentArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class FragmentArrayReader {
	private static Logger logger = LoggerFactory.getLogger(FragmentArrayReader.class);

	public static FragmentArray read(XMLStreamReader reader) {
		FragmentArray fragmentArray = new FragmentArray();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "values":
					String[] split = attributeValue.split(" ");
					List<Float> floats = new ArrayList<>();
					for (String s : split) {
						floats.add(Float.valueOf(s));
					}
					fragmentArray.setValues(floats);
					break;
				case "measure_ref":
					fragmentArray.setMeasure_ref(attributeValue);
					break;
				default:
					logger.error("Invalid attribute name in FragmentArray section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in FragmentArray section: " + attributeName);
			}
		}
		return fragmentArray;
	}
}
