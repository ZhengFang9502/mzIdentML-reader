package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.DatabaseFilters;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Filter;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class DatabaseFiltersReader {
	public static DatabaseFilters read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		DatabaseFilters databaseFilters = new DatabaseFilters();

		List<Filter> filters = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("Filter".equals(localName)) {
						Filter filter = FilterReader.read(reader);
						filters.add(filter);
					} else {
						throw new IllegalArgumentException("Invalid local name in DatabaseFilters section: " + localName);
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
		databaseFilters.setFilter(filters);
		return databaseFilters;
	}
}
