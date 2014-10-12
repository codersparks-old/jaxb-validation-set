package org.codersparks.jaxb_validation_set.jaxb.type;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

import org.codersparks.jaxb_validation_set.jaxb.ValidationSet;

public class ObjectFactory {

	private static final String XPATH = "xpath";
	private static final String HEADER = "header";
	private static final String VALUE = "value";
	private static final String LITERAL_VALUE = "literalvalue";
	private static final String CHILDREN = "children";
	private static final String VAR_SET = "var_set";
	private static final String MATCH_COUNT = "matchcount";
	private static final String THRESHOLD = "threshold";
	private static final String OPTIONAL = "optional";
	
	
	public ValidationSet createValidationSet() {
		return new ValidationSet();
	}

	@XmlElementDecl(name = XPATH)
	public JAXBElement<String> createXPathElement(String value) {
		return new JAXBElement<String>(new QName(XPATH), String.class, value);
	}

	@XmlElementDecl(name = HEADER)
	public JAXBElement<String> createHeaderElement(String value) {
		return new JAXBElement<String>(new QName(HEADER), String.class, value);
	}

	@XmlElementDecl(name = VALUE)
	public JAXBElement<String> createValueElement(String value) {
		return new JAXBElement<String>(new QName(VALUE), String.class, value);
	}

	@XmlElementDecl(name = LITERAL_VALUE)
	public JAXBElement<String> createLiteralValueElement(String value) {
		return new JAXBElement<String>(new QName(LITERAL_VALUE), String.class,
				value);
	}

	@XmlElementDecl(name = CHILDREN)
	public JAXBElement<String> createChildrenElement(String value) {
		return new JAXBElement<String>(new QName(CHILDREN), String.class, value);
	}
	
	@XmlElementDecl(name = VAR_SET)
	public JAXBElement<String> createVarSetElement(String value) {
		return new JAXBElement<String>(new QName(VAR_SET), String.class, value);
	}

	@XmlElementDecl(name = MATCH_COUNT)
	public JAXBElement<Integer> createMatchCountElement(Integer value) {
		return new JAXBElement<Integer>(new QName(MATCH_COUNT), Integer.class, value);
	}

	@XmlElementDecl(name = THRESHOLD)
	public JAXBElement<Float> createThresholdElement(Float value) {
		return new JAXBElement<Float>(new QName(THRESHOLD), Float.class, value);
	}

	@XmlElementDecl(name = OPTIONAL)
	public JAXBElement<Boolean> createOptionalElement(Boolean value) {
		return new JAXBElement<Boolean>(new QName(OPTIONAL), Boolean.class, value);
	}

	

}
