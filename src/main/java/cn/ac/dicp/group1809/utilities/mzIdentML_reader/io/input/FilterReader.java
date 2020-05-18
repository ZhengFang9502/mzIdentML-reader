package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Filter;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Param;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParamList;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class FilterReader {
	public static Filter read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		Filter filter = new Filter();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "FilterType":
							Param filterType = ParamReader.read(reader);
							filter.setFilterType(filterType);
							break;
						case "Include":
							ParamList include = ParamListReader.read(reader);
							filter.setInclude(include);
							break;
						case "Exclude":
							ParamList exclude = ParamListReader.read(reader);
							filter.setExclude(exclude);
							break;
						default:
							throw new IllegalArgumentException("Invalid local name in Filter section: " + localName);
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
		return filter;
	}
}
