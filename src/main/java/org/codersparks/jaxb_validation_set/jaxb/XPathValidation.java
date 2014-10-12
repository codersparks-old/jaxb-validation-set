package org.codersparks.jaxb_validation_set.jaxb;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class XPathValidation implements ValidationSetItem {
	
	public enum ValidationType {
		CHILDREN("children"),
		LITERAL_VALUE("literalvalue"),
		VALUE("value"),
		VAR_SET("var_set");
		
		private String qName;
		
		private ValidationType(String name) {
			this.qName = name;
		}
		
		public String toString() {
			return qName;
		}
		
		public static ValidationType fromString(String name) {
			if(VALUE.toString().equalsIgnoreCase(name)) {
				return VALUE;
			}
			
			if(LITERAL_VALUE.toString().equalsIgnoreCase(name)) {
				return LITERAL_VALUE;
			}
			
			if(VAR_SET.toString().equalsIgnoreCase(name)) {
				return VAR_SET;
			}
			
			if(CHILDREN.toString().equalsIgnoreCase(name)) {
				return CHILDREN;
			}
			
			// If we get here it is not a known type
			throw new IllegalArgumentException("Unknown XPath Validation type: " + name);
		}
	}
	
	// The xpath used to target the validation
	private String xpath;
	// The validation value - The type of validation is defined by
	//  the value of validationType
	private String validationValue;
	private ValidationType validationType;
	
	// We give the following null values by default
	// as then they will not be added to the xml
	// i.e. if the value is null then we are not including
	// this element (this is also the reason they are
	// not primative types
	private Boolean optional = null;
	private Integer matchCount = null;
	private Float threshold = null;
	
	public XPathValidation() {};
	
	public XPathValidation(String xpath, String validationValue,
			ValidationType validationType) {
		this.xpath = xpath;
		this.validationValue = validationValue;
		this.validationType = validationType;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getValidationValue() {
		return validationValue;
	}

	public void setValidationValue(String validationValue) {
		this.validationValue = validationValue;
	}

	public ValidationType getValidationType() {
		return validationType;
	}

	public void setValidationType(ValidationType validationType) {
		this.validationType = validationType;
	}

	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	public Integer getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(Integer matchCount) {
		this.matchCount = matchCount;
	}

	public Float getThreshold() {
		return threshold;
	}

	public void setThreshold(Float threshold) {
		this.threshold = threshold;
	}
	
	public String toString() {
		return "XPathValidation: " + ToStringBuilder.reflectionToString(this);
	}
	
	
	
	
	
	

}


