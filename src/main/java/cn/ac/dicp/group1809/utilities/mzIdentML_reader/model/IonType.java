package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * IonType defines the index of fragmentation ions being reported, importing a CV term for the type of ion e.g. b ion. Example: if b3 b7 b8 and b10 have been identified, the index attribute will contain 3 7 8 10, and the corresponding values will be reported in parallel arrays below
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IonTypeType", propOrder = {
		"fragmentArray",
		"userParam",
		"cvParam",
		"index",
		"charge",
})
public class IonType implements Serializable {
	private static final long serialVersionUID = 7785383623764808853L;
	@XmlElement(name = "FragmentArray")
	private List<FragmentArray> fragmentArray;
	/**
	 * In case more information about the ions annotation has to be conveyed, that has no fit in FragmentArray. Note: It is suggested that the value attribute takes the form of a list of the same size as FragmentArray values.
	 * However, there is no formal encoding and it cannot be expeceted that other software will process or impart that information properly.
	 */
	@XmlElement(name = "userParam")
	private List<UserParam> userParam;
	/**
	 * The type of ion identified. In the case of neutral losses, one term should report the ion type, a second term should report the neutral loss - note: this is a change in practice from mzIdentML 1.1.
	 */
	@XmlElement(name = "cvParam")
	private List<CVParam> cvParam;
	/**
	 * The index of ions identified as integers, following standard notation for a-c, x-z e.g. if b3 b5 and b6 have been identified, the index would store "3 5 6".
	 * For internal ions, the index contains pairs defining the start and end point - see specification document for examples.
	 * For immonium ions, the index is the position of the identified ion within the peptide sequence - if the peptide contains the same amino acid in multiple positions that cannot be distinguished, all positions should be given.
	 * For precursor ions, including neutral losses, the index value MUST be 0.
	 * For any other ions not related to the position within the peptide sequence e.g. quantification reporter ions, the index value MUST be 0.
	 */
	@XmlAttribute(name = "index")
	private List<Integer> index;
	/**
	 * The charge of the identified fragmentation ions.
	 */
	@XmlAttribute(name = "charge", required = true)
	private Integer charge;

	public List<FragmentArray> getFragmentArray() {
		return fragmentArray;
	}

	public void setFragmentArray(List<FragmentArray> fragmentArray) {
		this.fragmentArray = fragmentArray;
	}

	public List<UserParam> getUserParam() {
		return userParam;
	}

	public void setUserParam(List<UserParam> userParam) {
		this.userParam = userParam;
	}

	public List<CVParam> getCvParam() {
		return cvParam;
	}

	public void setCvParam(List<CVParam> cvParam) {
		this.cvParam = cvParam;
	}

	public List<Integer> getIndex() {
		return index;
	}

	public void setIndex(List<Integer> index) {
		this.index = index;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}
}
