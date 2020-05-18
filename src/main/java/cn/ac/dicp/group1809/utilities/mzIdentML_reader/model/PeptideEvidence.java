package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter.FrameAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * PeptideEvidence links a specific Peptide element to a specific position in a DBSequence.
 * There must only be one PeptideEvidence item per Peptide-to-DBSequence-position.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeptideEvidenceType", propOrder = {
		"paramGroup",
		"dBSequence_ref",
		"peptide_ref",
		"start",
		"end",
		"pre",
		"post",
		"translationTable_ref",
		"frame",
		"isDecoy"
})
public class PeptideEvidence extends Identifiable {
	private static final long serialVersionUID = 3289213395474189880L;
	/**
	 * Additional parameters or descriptors for the PeptideEvidence.
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;
	/**
	 * A reference to the protein sequence in which the specified peptide has been linked.
	 */
	@XmlAttribute(name = "dBSequence_ref", required = true)
	private String dBSequence_ref;
	/**
	 * A reference to the identified (poly)peptide sequence in the Peptide element.
	 */
	@XmlAttribute(name = "peptide_ref", required = true)
	private String peptide_ref;

	/**
	 * Start position of the peptide inside the protein sequence, where the first amino acid of the protein sequence is position 1.
	 * Must be provided unless this is a de novo search.
	 */
	@XmlAttribute(name = "start")
	private Integer start;
	/**
	 * The index position of the last amino acid of the peptide inside the protein sequence, where the first amino acid of the protein sequence is position 1.
	 * Must be provided unless this is a de novo search.
	 */
	@XmlAttribute(name = "end")
	private Integer end;
	/**
	 * Previous flanking residue. If the peptide is N-terminal, pre="-" and not pre="".
	 * If for any reason it is unknown (e.g. denovo), pre="?" should be used.
	 */
	@XmlAttribute(name = "pre")
	private String pre;
	/**
	 * Post flanking residue. If the peptide is C-terminal, post="-" and not post="".
	 * If for any reason it is unknown (e.g. denovo), post="?" should be used.
	 */
	@XmlAttribute(name = "post")
	private String post;
	/**
	 * A reference to the translation table used if this is PeptideEvidence derived from nucleic acid sequence
	 */
	@XmlAttribute(name = "translationTable_ref")
	private String translationTable_ref;
	/**
	 * The translation frame of this sequence if this is PeptideEvidence derived from nucleic acid sequence
	 */
	@XmlAttribute(name = "frame")
	@XmlJavaTypeAdapter(FrameAdapter.class)
	private AllowedFrame frame;
	/**
	 * Set to true if the peptide is matched to a decoy sequence.
	 */
	@XmlAttribute(name = "isDecoy")
	private Boolean isDecoy;

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}

	public String getdBSequence_ref() {
		return dBSequence_ref;
	}

	public void setdBSequence_ref(String dBSequence_ref) {
		this.dBSequence_ref = dBSequence_ref;
	}

	public String getPeptide_ref() {
		return peptide_ref;
	}

	public void setPeptide_ref(String peptide_ref) {
		this.peptide_ref = peptide_ref;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getPre() {
		return pre;
	}

	public void setPre(String pre) {
		if (pre.matches("[A-Z|\\-]")) {
			this.pre = pre;
		} else {
			throw new IllegalArgumentException("Invalid pre amino acid: " + pre);
		}
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		if (post.matches("[A-Z|\\-]")) {
			this.post = post;
		} else {
			throw new IllegalArgumentException("Invalid post amino acid: " + post);
		}
	}

	public String getTranslationTable_ref() {
		return translationTable_ref;
	}

	public void setTranslationTable_ref(String translationTable_ref) {
		this.translationTable_ref = translationTable_ref;
	}

	public AllowedFrame getFrame() {
		return frame;
	}

	public void setFrame(AllowedFrame frame) {
		this.frame = frame;
	}

	public Boolean getDecoy() {
		return isDecoy;
	}

	public void setDecoy(Boolean decoy) {
		isDecoy = decoy;
	}
}
