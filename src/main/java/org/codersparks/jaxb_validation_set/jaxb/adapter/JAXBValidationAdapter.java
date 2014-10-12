package org.codersparks.jaxb_validation_set.jaxb.adapter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.codersparks.jaxb_validation_set.jaxb.HeaderValidation;
import org.codersparks.jaxb_validation_set.jaxb.ValidationSetItem;
import org.codersparks.jaxb_validation_set.jaxb.XPathValidation;
import org.codersparks.jaxb_validation_set.jaxb.type.JAXBValidation;
import org.codersparks.jaxb_validation_set.jaxb.type.ObjectFactory;

public class JAXBValidationAdapter extends
		XmlAdapter<JAXBValidation, ValidationSetItem> {

	@Override
	public JAXBValidation marshal(ValidationSetItem validationItem)
			throws Exception {

		ObjectFactory of = new ObjectFactory();

		JAXBValidation jaxbValidation = new JAXBValidation();
		
		

		if (validationItem instanceof HeaderValidation) {
			
			HeaderValidation headerValidation = (HeaderValidation) validationItem;

			JAXBElement<String> jaxbTarget = of
					.createHeaderElement(headerValidation.getHeader());
			jaxbValidation.setTarget(jaxbTarget);

			JAXBElement<String> jaxbValue = of
					.createValueElement(headerValidation.getValue());
			jaxbValidation.setValue(jaxbValue);
		} else if (validationItem instanceof XPathValidation) {
			
			XPathValidation xpathValidation = (XPathValidation) validationItem;

			jaxbValidation.setTarget(of.createXPathElement(
					xpathValidation.getXpath()));
			
			switch(xpathValidation.getValidationType()) {
			case VALUE:
				jaxbValidation.setValue(of.createValueElement(xpathValidation.getValidationValue()));
				break;
			case LITERAL_VALUE:
				jaxbValidation.setValue(of.createLiteralValueElement(xpathValidation.getValidationValue()));
				break;
			case VAR_SET:
				jaxbValidation.setValue(of.createVarSetElement(xpathValidation.getValidationValue()));
				break;
			case CHILDREN:
				jaxbValidation.setValue(of.createChildrenElement(xpathValidation.getValidationValue()));
				break;
			}
			
			if(xpathValidation.getOptional() != null) {
				jaxbValidation.setOptional(of.createOptionalElement(xpathValidation.getOptional()));
			}
			
			if(xpathValidation.getMatchCount() != null) {
				jaxbValidation.setMatchCount(of.createMatchCountElement(xpathValidation.getMatchCount()));
			}
			
			if(xpathValidation.getThreshold() != null) {
				jaxbValidation.setThreshold(of.createThresholdElement(xpathValidation.getThreshold()));
			}


			

		} else {
			throw new IllegalArgumentException("Unknow validaiton type: " + validationItem.getClass().getCanonicalName());
		}
		
		return jaxbValidation;

	}

	@Override
	public ValidationSetItem unmarshal(JAXBValidation jaxbValidation) throws Exception {
		String targetName = jaxbValidation.getTarget().getName().getLocalPart();
		System.out.println("Here! Target Name: " + targetName);
		if(targetName.equalsIgnoreCase("header")) {
			
			return ValidationUnmarshaller.unMarshallHeaderValidation(jaxbValidation);
		} else if(targetName.equalsIgnoreCase("xpath")) {
			return ValidationUnmarshaller.unMarshallXPathValidation(jaxbValidation);
		} else {
			throw new JAXBException("Cannot unmarshall validation for type: " + targetName);
		}
	}

}
