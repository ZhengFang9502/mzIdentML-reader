package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A data set containing spectra data (consisting of one or more spectra).
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpectraDataType")
public class SpectraData extends ExternalData {
	private static final long serialVersionUID = -9161966526091633458L;
	@XmlElement(name = "SpectrumIDFormat")
	private SpectrumIDFormat spectrumIDFormat;

	public SpectrumIDFormat getSpectrumIDFormat() {
		return spectrumIDFormat;
	}

	public void setSpectrumIDFormat(SpectrumIDFormat spectrumIDFormat) {
		this.spectrumIDFormat = spectrumIDFormat;
	}
}
