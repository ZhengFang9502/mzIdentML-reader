package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Other classes in the model can be specified as sub-classes, inheriting from Identifiable.
 * Identifiable gives classes a unique identifier within the scope and a name that need not be unique.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Identifiable {
	/**
	 * An identifier is an unambiguous string that is unique within the scope (i.e. a document, a set of related documents, or a repository) of its use.
	 */
	@XmlAttribute(required = true)
	private String id;
	/**
	 * The potentially ambiguous common identifier, such as a human-readable name for the instance.
	 */
	@XmlAttribute
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
