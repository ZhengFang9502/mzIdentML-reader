package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Other classes in the model can be specified as sub-classes, inheriting from Identifiable.
 * Identifiable gives classes a unique identifier within the scope and a name that need not be unique.
 *
 * @author Zheng Fang 2020/5/18
 * @since V1.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifiableType", propOrder = {
		"id",
		"name"
})
public abstract class Identifiable implements Serializable {
	private static final long serialVersionUID = 1141448722242565399L;
	/**
	 * An identifier is an unambiguous string that is unique within the scope (i.e. a document, a set of related documents, or a repository) of its use.
	 */
	@XmlAttribute(name = "id", required = true)
	private String id;
	/**
	 * The potentially ambiguous common identifier, such as a human-readable name for the instance.
	 */
	@XmlAttribute(name = "name")
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
