package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ContactRole;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Sample;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SubSample;

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
	public static Sample read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Sample sample = new Sample();
		IdentifiableReader.read(reader, sample);
		List<ContactRole> contactRoleList = new ArrayList<>();
		List<SubSample> subSampleList = new ArrayList<>();
		List<AbstractParam> paramGroup = new ArrayList<>();

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
						case "userParam":
							AbstractParam abstractParam = AbstractParamReader.read(reader);
							paramGroup.add(abstractParam);
							break;
						default:
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
		sample.setParamGroup(paramGroup);
		sample.setSubSample(subSampleList);
		return sample;
	}
}
