package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.net.URI;

/**
 * A source controlled vocabulary from which cvParams will be obtained.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cvType", propOrder = {
		"id",
		"uri",
		"fullName",
		"version",
})
public class CV implements Serializable {
	private static final long serialVersionUID = -9191067490337965638L;
	/**
	 * The unique identifier of this cv within the document to be referenced by cvParam elements.
	 */
	@XmlAttribute(name = "id", required = true)
	private String id;
	/**
	 * The URI of the source CV.
	 */
	@XmlAttribute(name = "uri", required = true)
	@XmlJavaTypeAdapter(UriAdapter.class)
	private URI uri;
	/**
	 * The full name of the CV.
	 */
	@XmlAttribute(name = "fullName", required = true)
	private String fullName;
	/**
	 * The version of the CV.
	 */
	@XmlAttribute(name = "version")
	private String version;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

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
}
