package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URI;

/**
 * Data external to the XML instance document.
 * The location of the data file is given in the location attribute.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
		"externalFormatDocumentation",
		"fileFormat",
		"location"
})
public abstract class ExternalData extends Identifiable {
	/**
	 * A URI to access documentation and tools to interpret the external format of the ExternalData instance.
	 * For example, XML Schema or static libraries (APIs) to access binary formats.
	 */
	@XmlElement(name = "ExternalFormatDocumentation")
	@XmlJavaTypeAdapter(UriAdapter.class)
	private URI externalFormatDocumentation;
	@XmlElement(name = "FileFormat")
	private FileFormat fileFormat;
	/**
	 * The location of the data file.
	 */
	@XmlElement(name = "location")
	private String location;

	public URI getExternalFormatDocumentation() {
		return externalFormatDocumentation;
	}

	public void setExternalFormatDocumentation(URI externalFormatDocumentation) {
		this.externalFormatDocumentation = externalFormatDocumentation;
	}

	public FileFormat getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(FileFormat fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
