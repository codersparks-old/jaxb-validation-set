package org.codersparks.jaxb_validation_set.jaxb.type;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="validation")
@XmlAccessorType(XmlAccessType.FIELD)
public class JAXBValidation implements JAXBValidationItem {
	
	// The target field is going to store the "identifier"
	// of how/where to apply a validation to
	@XmlElementRefs({
		@XmlElementRef(name="xpath", required=true),
		@XmlElementRef(name="header", required=true)
	})
	private JAXBElement<String> target;
	
	
	// The value field is going to store the "action" 
	// configuration (i.e. regex, value to use for literal
	// search, var name etc)
	@XmlElementRefs({
		@XmlElementRef(name="value", required=true),
		@XmlElementRef(name="literalvalue", required=true),
		@XmlElementRef(name="var_set", required=true),
		@XmlElementRef(name="children", required=true)
	})
	private JAXBElement<String> value;
	
	
	// Now we have the extra items that are in XPath validation
	@XmlElementRef(name="optional", required=false)
	private JAXBElement<Boolean> optional = null;
	
	@XmlElementRef(name="matchcount", required=false)
	private JAXBElement<Integer> matchCount = null;
	
	@XmlElementRef(name="threshold", required=false) 
	private JAXBElement<Float> threshold = null;
	
	/**
	 * Blank constructor as required by JAXB
	 */
	public JAXBValidation() {}

	public JAXBElement<String> getTarget() {
		return target;
	}

	public void setTarget(JAXBElement<String> target) {
		this.target = target;
	}

	public JAXBElement<String> getValue() {
		return value;
	}

	public void setValue(JAXBElement<String> value) {
		this.value = value;
	}

	public JAXBElement<Boolean> getOptional() {
		return optional;
	}

	public void setOptional(JAXBElement<Boolean> optional) {
		this.optional = optional;
	}

	public JAXBElement<Integer> getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(JAXBElement<Integer> matchCount) {
		this.matchCount = matchCount;
	}

	public JAXBElement<Float> getThreshold() {
		return threshold;
	}

	public void setThreshold(JAXBElement<Float> threshold) {
		this.threshold = threshold;
	}
	
	
}
