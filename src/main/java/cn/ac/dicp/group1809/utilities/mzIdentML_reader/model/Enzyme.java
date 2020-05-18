package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

import javax.xml.bind.annotation.*;

/**
 * The details of an individual cleavage enzyme should be provided by giving a regular expression or a CV term if a "standard" enzyme cleavage has been performed.
 *
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnzymeType", propOrder = {
		"siteRegexp",
		"enzymeName",
		"nTermGain",
		"cTermGain",
		"semiSpecific",
		"missedCleavages",
		"minDistance",
})
public class Enzyme extends Identifiable {
	private static final long serialVersionUID = -6527568851373771987L;
	/**
	 * Regular expression for specifying the enzyme cleavage site.
	 */
	@XmlElement(name = "SiteRegexp")
	private String siteRegexp;
	/**
	 * The name of the enzyme from a CV.
	 */
	@XmlElement(name = "EnzymeName")
	private ParamList enzymeName;
	/**
	 * Element formula gained at NTerm.
	 */
	@XmlAttribute(name = "nTermGain")
	private String nTermGain;
	/**
	 * Element formula gained at CTerm.
	 */
	@XmlAttribute(name = "cTermGain")
	private String cTermGain;
	/**
	 * Set to true if the enzyme cleaves semi-specifically (i.e. one terminus must cleave according to the rules, the other can cleave at any residue), false if the enzyme cleavage is assumed to be specific to both termini (accepting for any missed cleavages).
	 */
	@XmlAttribute(name = "semiSpecific")
	private Boolean semiSpecific;
	/**
	 * The number of missed cleavage sites allowed by the search. The attribute must be provided if an enzyme has been used.
	 */
	@XmlAttribute(name = "missedCleavages")
	private Integer missedCleavages;
	/**
	 * Minimal distance for another cleavage (minimum: 1).
	 */
	@XmlAttribute(name = "minDistance")
	private Integer minDistance;

	public String getSiteRegexp() {
		return siteRegexp;
	}

	public void setSiteRegexp(String siteRegexp) {
		this.siteRegexp = siteRegexp;
	}

	public ParamList getEnzymeName() {
		return enzymeName;
	}

	public void setEnzymeName(ParamList enzymeName) {
		this.enzymeName = enzymeName;
	}

	public String getnTermGain() {
		return nTermGain;
	}

	public void setnTermGain(String nTermGain) {
		if (nTermGain.matches("[A-Za-z0-9 ]+")) {
			this.nTermGain = nTermGain;
		} else {
			throw new IllegalArgumentException("Invalid formula: " + nTermGain);
		}
	}

	public String getcTermGain() {
		return cTermGain;
	}

	public void setcTermGain(String cTermGain) {
		if (cTermGain.matches("[A-Za-z0-9 ]+")) {
			this.cTermGain = cTermGain;
		} else {
			throw new IllegalArgumentException("Invalid formula: " + cTermGain);
		}
	}

	public Boolean getSemiSpecific() {
		return semiSpecific;
	}

	public void setSemiSpecific(Boolean semiSpecific) {
		this.semiSpecific = semiSpecific;
	}

	public Integer getMissedCleavages() {
		return missedCleavages;
	}

	public void setMissedCleavages(Integer missedCleavages) {
		this.missedCleavages = missedCleavages;
	}

	public int getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(Integer minDistance) {
		if (minDistance >= 1) {
			this.minDistance = minDistance;
		} else {
			throw new IllegalArgumentException("Minimal distance for another cleavage should more than 1: " + minDistance);
		}

	}
}
