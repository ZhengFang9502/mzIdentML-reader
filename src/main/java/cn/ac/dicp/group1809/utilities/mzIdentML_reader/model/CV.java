package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URI;

/**
 * A source controlled vocabulary from which cvParams will be obtained.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cv", propOrder = {
		"fullName",
		"version",
		"uri",
		"id"
})
public class CV {
	/**
	 * The full name of the CV.
	 */
	@XmlAttribute(required = true)
	private String fullName;
	/**
	 * The version of the CV.
	 */
	@XmlAttribute
	private String version;
	/**
	 * The URI of the source CV.
	 */
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(UriAdapter.class)
	private URI uri;
	/**
	 * The unique identifier of this cv within the document to be referenced by cvParam elements.
	 */
	@XmlAttribute(required = true)
	private String id;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
