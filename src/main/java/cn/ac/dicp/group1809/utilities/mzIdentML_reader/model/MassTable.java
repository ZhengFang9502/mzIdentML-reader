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
@XmlType(propOrder = {
		"residue",
		"ambiguousResidue",
		"paramGroupList",
		"msLevel"
})
public class MassTable extends Identifiable {
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
	private List<ParamGroup> paramGroupList;
	/**
	 * The MS spectrum that the MassTable refers to e.g. "1" for MS1 "2" for MS2 or "1 2" for MS1 or MS2.
	 */
	@XmlAttribute(required = true)
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

	public List<ParamGroup> getParamGroupList() {
		return paramGroupList;
	}

	public void setParamGroupList(List<ParamGroup> paramGroupList) {
		this.paramGroupList = paramGroupList;
	}

	public List<Integer> getMsLevel() {
		return msLevel;
	}

	public void setMsLevel(List<Integer> msLevel) {
		this.msLevel = msLevel;
	}
}
