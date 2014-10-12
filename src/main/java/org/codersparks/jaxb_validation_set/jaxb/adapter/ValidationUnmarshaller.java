package org.codersparks.jaxb_validation_set.jaxb.adapter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.codersparks.jaxb_validation_set.jaxb.HeaderValidation;
import org.codersparks.jaxb_validation_set.jaxb.ValidationSetItem;
import org.codersparks.jaxb_validation_set.jaxb.XPathValidation;
import org.codersparks.jaxb_validation_set.jaxb.XPathValidation.ValidationType;
import org.codersparks.jaxb_validation_set.jaxb.type.JAXBValidation;

public class ValidationUnmarshaller {
	
	public static ValidationSetItem unMarshallXPathValidation(JAXBValidation jaxbValidation) throws JAXBException {
		XPathValidation xpathValidation = new XPathValidation();
		
		xpathValidation.setXpath(jaxbValidation.getTarget().getValue());
		xpathValidation.setValidationValue(jaxbValidation.getValue().getValue());
		
		String validationTypeString = jaxbValidation.getValue().getName().getLocalPart();
		xpathValidation.setValidationType(ValidationType.fromString(validationTypeString));
		
		if(jaxbValidation.getOptional() != null) {
			xpathValidation.setOptional(jaxbValidation.getOptional().getValue());
		}
		
		if(jaxbValidation.getThreshold() != null) {
			Float threshold = jaxbValidation.getThreshold().getValue();
			
			if(threshold != null) {
				xpathValidation.setThreshold(threshold);
			}
			
		}
		
		if(jaxbValidation.getMatchCount() != null) {
			
			xpathValidation.setMatchCount(jaxbValidation.getMatchCount().getValue());
		}

		
		return xpathValidation;
	}
	
	public static ValidationSetItem unMarshallHeaderValidation(JAXBValidation jaxbValidation) {
		HeaderValidation headerValidation = new HeaderValidation();
		
		headerValidation.setHeader(jaxbValidation.getTarget().getValue());
		headerValidation.setValue(jaxbValidation.getValue().getValue());
		
		
		return headerValidation;
	}

}
