package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * A database sequence from the specified SearchDatabase (nucleic acid or amino acid).
 * If the sequence is nucleic acid, the source nucleic acid sequence should be given in the seq attribute rather than a translated sequence.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBSequenceType", propOrder = {
		"seq",
		"paramGroup",
		"length",
		"searchDatabase_ref",
		"accession"
})
public class DBSequence extends Identifiable {
	private static final long serialVersionUID = -609941451259943843L;
	/**
	 * The actual sequence of amino acids or nucleic acid.
	 */
	@XmlElement(name = "Seq")
	private String seq;
	/**
	 * Additional descriptors for the sequence, such as taxon, description line etc.
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;

	/**
	 * The length of the sequence as a number of bases or residues.
	 */
	@XmlAttribute(name = "length")
	private Integer length;
	/**
	 * The source database of this sequence.
	 */
	@XmlAttribute(name = "searchDatabase_ref", required = true)
	private String searchDatabase_ref;
	/**
	 * The unique accession of this sequence.
	 */
	@XmlAttribute(name = "accession", required = true)
	private String accession;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		if (!seq.matches("[A-Z]*")) {
			throw new IllegalArgumentException("Invalid sequence: " + seq);
		}
		this.seq = seq;
	}

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getSearchDatabase_ref() {
		return searchDatabase_ref;
	}

	public void setSearchDatabase_ref(String searchDatabase_ref) {
		this.searchDatabase_ref = searchDatabase_ref;
	}

	public String getAccession() {
		return accession;
	}

	public void setAccession(String accession) {
		this.accession = accession;
	}
}
