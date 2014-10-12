package org.codersparks.jaxb_validation_set.jaxb;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class HeaderValidation implements ValidationSetItem {

	private String header;
	private String value;
	
	public HeaderValidation() {}

	public HeaderValidation(String header, String value) {
		this.header = header;
		this.value = value;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return "HeaderValidation: " + ToStringBuilder.reflectionToString(this);
	}
	
	
}
