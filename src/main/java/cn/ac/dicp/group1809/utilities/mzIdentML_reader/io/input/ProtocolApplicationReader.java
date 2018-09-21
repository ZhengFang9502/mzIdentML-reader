package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ProtocolApplication;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.DateAdapter;

import javax.xml.stream.XMLStreamReader;
import java.text.ParseException;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ProtocolApplicationReader {

	public static void read(XMLStreamReader reader, ProtocolApplication protocolApplication) {
		IdentifiableReader.read(reader, protocolApplication);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "activityDate":
					try {
						protocolApplication.setActivityDate(new DateAdapter().unmarshal(attributeValue));
					} catch (ParseException e) {
						throw new IllegalArgumentException(e.getMessage());
					}
					break;
			}
		}
	}
}
