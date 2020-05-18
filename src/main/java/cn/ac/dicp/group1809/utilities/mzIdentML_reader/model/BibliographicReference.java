package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Represents bibliographic references.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BibliographicReferenceType", propOrder = {
		"authors",
		"publication",
		"publisher",
		"editor",
		"year",
		"volume",
		"issue",
		"pages",
		"title",
		"doi"
})
public class BibliographicReference extends Identifiable {
	private static final long serialVersionUID = 3490462526250171651L;
	/**
	 * The names of the authors of the reference.
	 */
	@XmlAttribute(name = "authors")
	private String authors;
	/**
	 * The name of the journal, book etc.
	 */
	@XmlAttribute(name = "publication")
	private String publication;
	/**
	 * The publisher of the publication.
	 */
	@XmlAttribute(name = "publisher")
	private String publisher;
	/**
	 * The editor(s) of the reference.
	 */
	@XmlAttribute(name = "editor")
	private String editor;
	/**
	 * The year of publication.
	 */
	@XmlAttribute(name = "year")
	private Integer year;
	/**
	 * The volume name or number.
	 */
	@XmlAttribute(name = "volume")
	private String volume;
	/**
	 * The issue name or number.
	 */
	@XmlAttribute(name = "issue")
	private String issue;
	/**
	 * The page numbers.
	 */
	@XmlAttribute(name = "pages")
	private String pages;
	/**
	 * The title of the BibliographicReference.
	 */
	@XmlAttribute(name = "title")
	private String title;
	/**
	 * The DOI of the referenced publication.
	 */
	@XmlAttribute(name = "doi")
	private String doi;

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}
}
