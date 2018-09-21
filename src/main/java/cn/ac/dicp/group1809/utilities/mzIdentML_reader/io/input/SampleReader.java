package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class SampleReader {
	private static Logger logger = LoggerFactory.getLogger(SampleReader.class);

	public static Sample read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Sample sample = new Sample();
		IdentifiableReader.read(reader, sample);
		List<ContactRole> contactRoleList = new ArrayList<>();
		List<SubSample> subSampleList = new ArrayList<>();
		List<ParamGroup> paramGroupList = new ArrayList<>();

		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "ContactRole":
							ContactRole contactRole = ContactRoleReader.read(reader);
							contactRoleList.add(contactRole);
							break;
						case "SubSample":
							SubSample subSample = SubSampleReader.read(reader);
							subSampleList.add(subSample);
							break;
						case "cvParam":
							ParamGroup cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroupList.add(cvParam);
							break;
						case "userParam":
							ParamGroup userParam = ParamGroupReader.read(reader, new CVParam());
							paramGroupList.add(userParam);
							break;
						default:
							logger.error("Invalid local name in Sample section: " + localName);
							throw new IllegalArgumentException("Invalid local name in Sample section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		sample.setContactRole(contactRoleList);
		sample.setParamGroupList(paramGroupList);
		sample.setSubSample(subSampleList);
		return sample;
	}
}
