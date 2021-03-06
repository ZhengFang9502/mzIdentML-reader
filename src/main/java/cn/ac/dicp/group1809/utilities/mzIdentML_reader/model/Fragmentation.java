package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * The product ions identified in this result.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Fragmentation {
	@XmlElement(name = "IonType")
	private List<IonType> ionType;

	public List<IonType> getIonType() {
		return ionType;
	}

	public void setIonType(List<IonType> ionType) {
		this.ionType = ionType;
	}
}
