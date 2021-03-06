package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class MassTableReader {
	private static Logger logger = LoggerFactory.getLogger(MassTableReader.class);

	public static MassTable read(XMLStreamReader reader) throws XMLStreamException {
		String name = reader.getLocalName();

		MassTable massTable = new MassTable();
		IdentifiableReader.read(reader, massTable);

		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "msLevel":
					String[] split = attributeValue.split(" ");
					List<Integer> integers = new ArrayList<>();
					for (String s : split) {
						if (!s.equals("")) {
							integers.add(Integer.valueOf(s));
						}
					}
					massTable.setMsLevel(integers);
					break;
				case "id":
				case "name":
					break;
				default:
					logger.error("Invalid attribute name in MassTable section: " + attributeName);
					throw new IllegalArgumentException("Invalid attribute name in MassTable section: " + attributeName);
			}
		}

		List<Residue> residues = new ArrayList<>();
		List<AmbiguousResidue> ambiguousResidues = new ArrayList<>();
		List<ParamGroup> paramGroups = new ArrayList<>();
		String localName;
		loop:
		while (reader.hasNext()) {
			int next = reader.next();
			switch (next) {
				case XMLStreamReader.START_ELEMENT:
					localName = reader.getLocalName();
					switch (localName) {
						case "Residue":
							residues.add(ResidueReader.read(reader));
							break;
						case "AmbiguousResidue":
							ambiguousResidues.add(AmbiguousResidueReader.read(reader));
							break;
						case "cvParam":
							ParamGroup cvParam = ParamGroupReader.read(reader, new CVParam());
							paramGroups.add(cvParam);
							break;
						case "userParam":
							ParamGroup userParam = ParamGroupReader.read(reader, new UserParam());
							paramGroups.add(userParam);
							break;
						default:
							logger.error("Invalid local name in MassTable section: " + localName);
							throw new IllegalArgumentException("Invalid local name in MassTable section: " + localName);
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
		massTable.setResidue(residues);
		massTable.setAmbiguousResidue(ambiguousResidues);
		massTable.setParamGroupList(paramGroups);
		return massTable;
	}
}
