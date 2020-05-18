package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * All identifications made from searching one spectrum.
 * For PMF data, all peptide identifications will be listed underneath as SpectrumIdentificationItems.
 * For MS/MS data, there will be ranked SpectrumIdentificationItems corresponding to possible different peptide IDs.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectrumIdentificationResultType", propOrder = {
		"spectrumIdentificationItem",
		"paramGroup",
		"spectrumID",
		"spectraData_ref",
})
public class SpectrumIdentificationResult extends Identifiable {
	private static final long serialVersionUID = 396228410497971166L;
	@XmlElement(name = "SpectrumIdentificationItem")
	private List<SpectrumIdentificationItem> spectrumIdentificationItem;
	/**
	 * Scores or parameters associated with the SpectrumIdentificationResult (i.e the set of SpectrumIdentificationItems derived from one spectrum) e.g. the number of peptide sequences within the parent tolerance for this spectrum.
	 */
	@XmlElements(value = {
			@XmlElement(name = "cvParam", type = CVParam.class),
			@XmlElement(name = "userParam", type = UserParam.class)
	})
	private List<AbstractParam> paramGroup;

	/**
	 * The locally unique id for the spectrum in the spectra data set specified by SpectraData_ref.
	 * External guidelines are provided on the use of consistent identifiers for spectra in different external formats.
	 */
	@XmlAttribute(name = "spectrumID", required = true)
	private String spectrumID;
	/**
	 * A reference to a spectra data set (e.g. a spectra file).
	 */
	@XmlAttribute(name = "spectraData_ref", required = true)
	private String spectraData_ref;

	public List<SpectrumIdentificationItem> getSpectrumIdentificationItem() {
		return spectrumIdentificationItem;
	}

	public void setSpectrumIdentificationItem(List<SpectrumIdentificationItem> spectrumIdentificationItem) {
		this.spectrumIdentificationItem = spectrumIdentificationItem;
	}

	public List<AbstractParam> getParamGroup() {
		return paramGroup;
	}

	public void setParamGroup(List<AbstractParam> paramGroup) {
		this.paramGroup = paramGroup;
	}

	public String getSpectrumID() {
		return spectrumID;
	}

	public void setSpectrumID(String spectrumID) {
		this.spectrumID = spectrumID;
	}

	public String getSpectraData_ref() {
		return spectraData_ref;
	}

	public void setSpectraData_ref(String spectraData_ref) {
		this.spectraData_ref = spectraData_ref;
	}
}
