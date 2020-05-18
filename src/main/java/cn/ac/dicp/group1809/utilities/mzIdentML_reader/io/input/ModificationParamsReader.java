package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ModificationParams;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.SearchModification;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ModificationParamsReader {
	public static ModificationParams read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		ModificationParams modificationParams = new ModificationParams();
		List<SearchModification> searchModifications = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("SearchModification".equals(localName)) {
						SearchModification searchModification = SearchModificationReader.read(reader);
						searchModifications.add(searchModification);
					} else {
						throw new IllegalArgumentException("Invalid local name in ModificationParams section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		modificationParams.setSearchModification(searchModifications);
		return modificationParams;
	}
}
