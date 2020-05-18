package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * A specification of how a nucleic acid sequence database was translated for searching.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatabaseTranslationType", propOrder = {
		"translationTable",
		"frames"
})
public class DatabaseTranslation implements Serializable {
	private static final long serialVersionUID = -106225460578962988L;
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
