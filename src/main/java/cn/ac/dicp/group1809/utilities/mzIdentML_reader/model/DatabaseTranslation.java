package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * A specification of how a nucleic acid sequence database was translated for searching.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DatabaseTranslation {
	@XmlElement(name = "TranslationTable")
	private List<TranslationTable> translationTable;
	/**
	 * The frames in which the nucleic acid sequence has been translated as a space separated list
	 */
	@XmlAttribute(name = "frames")
	private List<AllowedFrame> frames;

	public List<TranslationTable> getTranslationTable() {
		return translationTable;
	}

	public void setTranslationTable(List<TranslationTable> translationTable) {
		this.translationTable = translationTable;
	}

	public List<AllowedFrame> getFrames() {
		return frames;
	}

	public void setFrames(List<AllowedFrame> frames) {
		this.frames = frames;
	}
}
