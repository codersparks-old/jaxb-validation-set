package org.codersparks.jaxb_validation_set.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codersparks.jaxb_validation_set.jaxb.adapter.JAXBValidationAdapter;
import org.codersparks.jaxb_validation_set.jaxb.type.JAXBValidation;


@XmlType
@XmlRootElement(name="validationset")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationSet {
	
	@XmlElementRefs({
		@XmlElementRef(type=JAXBValidation.class)
	})
	@XmlJavaTypeAdapter(JAXBValidationAdapter.class)
	private List<ValidationSetItem> validationItems;

	
	public ValidationSet() {
		this.validationItems = new ArrayList<ValidationSetItem>();
	}
	
	public ValidationSet(List<ValidationSetItem> validationItems) {
		this.validationItems = validationItems;
	}

	public List<ValidationSetItem> getValidationItems() {
		return validationItems;
	}

	public void setValidationItems(List<ValidationSetItem> validationItems) {
		this.validationItems = validationItems;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

}

