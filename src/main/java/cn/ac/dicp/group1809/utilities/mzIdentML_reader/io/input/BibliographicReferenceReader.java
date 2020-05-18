package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.BibliographicReference;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class BibliographicReferenceReader {
	public static BibliographicReference read(XMLStreamReader reader) {
		BibliographicReference bibliographicReference = new BibliographicReference();
		IdentifiableReader.read(reader, bibliographicReference);
		Map<String, String> attributes = AttributeReader.getAttributes(reader);
		for (String attributeName : attributes.keySet()) {
			String attributeValue = attributes.get(attributeName);
			switch (attributeName) {
				case "authors":
					bibliographicReference.setAuthors(attributeValue);
					break;
				case "publication":
					bibliographicReference.setPublication(attributeValue);
					break;
				case "publisher":
					bibliographicReference.setPublisher(attributeValue);
					break;
				case "editor":
					bibliographicReference.setEditor(attributeValue);
					break;
				case "year":
					bibliographicReference.setYear(Integer.valueOf(attributeValue));
					break;
				case "volume":
					bibliographicReference.setVolume(attributeValue);
					break;
				case "issue":
					bibliographicReference.setIssue(attributeValue);
					break;
				case "pages":
					bibliographicReference.setPages(attributeValue);
					break;
				case "title":
					bibliographicReference.setTitle(attributeValue);
					break;
				case "doi":
					bibliographicReference.setDoi(attributeValue);
					break;
				case "id":
				case "name":
					break;
				default:
					throw new IllegalArgumentException("Invalid attribute name in BibliographicReference section: " + attributeName);
			}
		}
		return bibliographicReference;
	}
}
