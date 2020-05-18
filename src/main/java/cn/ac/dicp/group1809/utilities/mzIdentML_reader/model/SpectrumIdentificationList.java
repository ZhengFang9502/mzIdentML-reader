package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Represents the set of all search results from SpectrumIdentification.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectrumIdentificationListType", propOrder = {
		"fragmentationTable",
		"spectrumIdentificationResult",
		"paramGroup",
		"numSequencesSearched"
})
public class SpectrumIdentificationList extends Identifiable {
	private static final long serialVersionUID = 3416186788646105454L;
	@XmlElement(name = "FragmentationTable")
	private FragmentationTable fragmentationTable;
	@XmlElement(name = "SpectrumIdentificationResult")
	private List<SpectrumIdentificationResult> spectrumIdentificationResult;
	/**
	 * Scores or output parameters associated with the SpectrumIdentificationList.
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;

	/**
	 * The number of database sequences searched against.
	 * This value should be provided unless a de novo search has been performed.
	 */
	@XmlAttribute(name = "numSequencesSearched")
	private long numSequencesSearched;

	public FragmentationTable getFragmentationTable() {
		return fragmentationTable;
	}

	public void setFragmentationTable(FragmentationTable fragmentationTable) {
		this.fragmentationTable = fragmentationTable;
	}

	public List<SpectrumIdentificationResult> getSpectrumIdentificationResult() {
		return spectrumIdentificationResult;
	}

	public void setSpectrumIdentificationResult(List<SpectrumIdentificationResult> spectrumIdentificationResult) {
		this.spectrumIdentificationResult = spectrumIdentificationResult;
	}

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}

	public long getNumSequencesSearched() {
		return numSequencesSearched;
	}

	public void setNumSequencesSearched(long numSequencesSearched) {
		this.numSequencesSearched = numSequencesSearched;
	}
}
