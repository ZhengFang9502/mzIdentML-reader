package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * An Analysis which tries to identify peptides in input spectra, referencing the database searched, the input spectra, the output results and the protocol that is run.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectrumIdentificationType", propOrder = {
		"inputSpectra",
		"searchDatabaseRef",
		"spectrumIdentificationProtocol_ref",
		"spectrumIdentificationList_ref"
})
public class SpectrumIdentification extends ProtocolApplication {
	private static final long serialVersionUID = 4331875144681178651L;
	/**
	 * One of the spectra data sets used.
	 */
	@XmlElement(name = "InputSpectra")
	private List<InputSpectra> inputSpectra;
	@XmlElement(name = "SearchDatabaseRef")
	private List<SearchDatabaseRef> searchDatabaseRef;
	/**
	 * A reference to the search protocol used for this SpectrumIdentification.
	 */
	@XmlAttribute(name = "spectrumIdentificationProtocol_ref", required = true)
	private String spectrumIdentificationProtocol_ref;
	/**
	 * A reference to the SpectrumIdentificationList produced by this analysis in the DataCollection section.
	 */
	@XmlAttribute(name = "spectrumIdentificationList_ref", required = true)
	private String spectrumIdentificationList_ref;

	public List<InputSpectra> getInputSpectra() {
		return inputSpectra;
	}

	public void setInputSpectra(List<InputSpectra> inputSpectra) {
		this.inputSpectra = inputSpectra;
	}

	public List<SearchDatabaseRef> getSearchDatabaseRef() {
		return searchDatabaseRef;
	}

	public void setSearchDatabaseRef(List<SearchDatabaseRef> searchDatabaseRef) {
		this.searchDatabaseRef = searchDatabaseRef;
	}

	public String getSpectrumIdentificationProtocol_ref() {
		return spectrumIdentificationProtocol_ref;
	}

	public void setSpectrumIdentificationProtocol_ref(String spectrumIdentificationProtocol_ref) {
		this.spectrumIdentificationProtocol_ref = spectrumIdentificationProtocol_ref;
	}

	public String getSpectrumIdentificationList_ref() {
		return spectrumIdentificationList_ref;
	}

	public void setSpectrumIdentificationList_ref(String spectrumIdentificationList_ref) {
		this.spectrumIdentificationList_ref = spectrumIdentificationList_ref;
	}
}
