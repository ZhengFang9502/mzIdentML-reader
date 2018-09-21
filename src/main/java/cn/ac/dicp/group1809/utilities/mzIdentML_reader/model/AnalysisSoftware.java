package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.UriAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.net.URI;

/**
 * The software used for performing the analyses.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalysisSoftware",propOrder = {
		"contactRole",
		"softwareName",
		"customizations",
		"version",
		"uri"
})
public class AnalysisSoftware extends Identifiable {
	/**
	 * The contact details of the organisation or person that produced the software
	 */
	@XmlElement(name = "ContactRole")
	private ContactRole contactRole;
	/**
	 * The name of the analysis software package, sourced from a CV if available.
	 */
	@XmlElement(name = "SoftwareName")
	private Param softwareName;
	/**
	 * Any customizations to the software, such as alternative scoring mechanisms implemented, should be documented here as free text.
	 */
	@XmlElement(name = "Customizations")
	private String customizations;

	/**
	 * The version of Software used.
	 */
	@XmlAttribute
	private String version;
	/**
	 * URI of the analysis software e.g. manufacturer's website
	 */
	@XmlAttribute
	@XmlJavaTypeAdapter(UriAdapter.class)
	private URI uri;

	public ContactRole getContactRole() {
		return contactRole;
	}

	public void setContactRole(ContactRole contactRole) {
		this.contactRole = contactRole;
	}

	public Param getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(Param softwareName) {
		this.softwareName = softwareName;
	}

	public String getCustomizations() {
		return customizations;
	}

	public void setCustomizations(String customizations) {
		this.customizations = customizations;
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
}
