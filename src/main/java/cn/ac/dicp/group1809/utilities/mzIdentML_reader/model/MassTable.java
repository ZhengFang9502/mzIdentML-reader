package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * The masses of residues used in the search.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MassTableType", propOrder = {
		"residue",
		"ambiguousResidue",
		"paramGroup",
		"msLevel"
})
public class MassTable extends Identifiable {
	private static final long serialVersionUID = -3905101376695685631L;
	/**
	 * The specification of a single residue within the mass table.
	 */
	@XmlElement(name = "Residue")
	private List<Residue> residue;
	@XmlElement(name = "AmbiguousResidue")
	private List<AmbiguousResidue> ambiguousResidue;
	/**
	 * Additional parameters or descriptors for the MassTable.
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;
	/**
	 * The MS spectrum that the MassTable refers to e.g. "1" for MS1 "2" for MS2 or "1 2" for MS1 or MS2.
	 */
	@XmlAttribute(name = "msLevel", required = true)
	private List<Integer> msLevel;

	public List<Residue> getResidue() {
		return residue;
	}

	public void setResidue(List<Residue> residue) {
		this.residue = residue;
	}

	public List<AmbiguousResidue> getAmbiguousResidue() {
		return ambiguousResidue;
	}

	public void setAmbiguousResidue(List<AmbiguousResidue> ambiguousResidue) {
		this.ambiguousResidue = ambiguousResidue;
	}

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}

	public List<Integer> getMsLevel() {
		return msLevel;
	}

	public void setMsLevel(List<Integer> msLevel) {
		this.msLevel = msLevel;
	}
}
