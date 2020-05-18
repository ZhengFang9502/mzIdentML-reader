package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.FragmentationTable;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.Measure;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class FragmentationTableReader {

	public static FragmentationTable read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();
		FragmentationTable fragmentationTable = new FragmentationTable();
		List<Measure> measures = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					if ("Measure".equals(localName)) {
						Measure measure = MeasureReader.read(reader);
						measures.add(measure);
					} else {
						throw new IllegalArgumentException("Invalid local name in FragmentationTable section: " + localName);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					localName = reader.getLocalName();
					if (name.equals(localName)) {
						break loop;
					}
			}
		}
		fragmentationTable.setMeasure(measures);
		return fragmentationTable;
	}
}
