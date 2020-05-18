package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Filters applied to the search database.
 * The filter must include at least one of Include and Exclude.
 * If both are used, it is assumed that inclusion is performed first.
 *
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterType", propOrder = {
		"filterType",
		"include",
		"exclude"
})
public class Filter implements Serializable {
	private static final long serialVersionUID = 7443988523580484001L;
	/**
	 * The type of filter e.g. database taxonomy filter, pi filter, mw filter
	 */
	@XmlElement(name = "FilterType")
	private Param filterType;
	/**
	 * All sequences fulfilling the specifed criteria are included.
	 */
	@XmlElement(name = "Include")
	private ParamList include;
	/**
	 * All sequences fulfilling the specifed criteria are excluded.
	 */
	@XmlElement(name = "Exclude")
	private ParamList exclude;

	public Param getFilterType() {
		return filterType;
	}

	public void setFilterType(Param filterType) {
		this.filterType = filterType;
	}

	public ParamList getInclude() {
		return include;
	}

	public void setInclude(ParamList include) {
		this.include = include;
	}

	public ParamList getExclude() {
		return exclude;
	}

	public void setExclude(ParamList exclude) {
		this.exclude = exclude;
	}
}
