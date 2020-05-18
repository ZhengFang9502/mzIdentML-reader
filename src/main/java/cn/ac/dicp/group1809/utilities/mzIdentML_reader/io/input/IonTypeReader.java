package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FragmentArray;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.IonType;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.UserParam;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class IonTypeReader {

	public static IonType read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		IonType ionType = new IonType();
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "index":
					String[] split = attributeValue.split(" ");
					List<Integer> integers = new ArrayList<>();
					for (String s : split) {
						integers.add(Integer.valueOf(s));
					}
					ionType.setIndex(integers);
					break;
				case "charge":
					ionType.setCharge(Integer.valueOf(attributeValue));
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in IonType section: " + attributeName);
			}
		}

		List<FragmentArray> fragmentArrays = new ArrayList<>();
		List<CVParam> cvParams = new ArrayList<>();
		List<UserParam> userParams = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "FragmentArray":
							FragmentArray fragmentArray = FragmentArrayReader.read(reader);
							fragmentArrays.add(fragmentArray);
							break;
						case "userParam":
							UserParam userParam = UserParamReader.read(reader);
							userParams.add(userParam);
							break;
						case "cvParam":
							CVParam cvParam = CVParamReader.read(reader);
							cvParams.add(cvParam);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in IonType section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		ionType.setFragmentArray(fragmentArrays);
		ionType.setUserParam(userParams);
		ionType.setCvParam(cvParams);
		return ionType;
	}
}
