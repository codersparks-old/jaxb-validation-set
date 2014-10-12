package org.codersparks.jaxb_validation_set;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.codersparks.jaxb_validation_set.jaxb.HeaderValidation;
import org.codersparks.jaxb_validation_set.jaxb.ValidationSet;
import org.codersparks.jaxb_validation_set.jaxb.ValidationSetItem;
import org.codersparks.jaxb_validation_set.jaxb.XPathValidation;
import org.codersparks.jaxb_validation_set.jaxb.XPathValidation.ValidationType;
import org.codersparks.jaxb_validation_set.jaxb.type.ObjectFactory;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Constructing xml from objects" );
        
        ObjectFactory of = new ObjectFactory();
        
        ValidationSet valSet = new ValidationSet();
        
        List<ValidationSetItem> vsiList = valSet.getValidationItems();
        
        XPathValidation x1 = new XPathValidation();
        x1.setXpath("/ab/cd/fg/@hi");
        x1.setValidationType(ValidationType.VALUE);
        x1.setValidationValue("regex_value");
        x1.setOptional(false);
        x1.setThreshold(1.2f);
        vsiList.add(x1);
        
        XPathValidation x2 = new XPathValidation();
        x2.setXpath("/sdfsaf/asdfas");
        x2.setValidationType(ValidationType.LITERAL_VALUE);
        x2.setValidationValue("asl<k);afsk");
        vsiList.add(x2);
        
        XPathValidation x3 = new XPathValidation();
        x3.setXpath("//sdfsd[@sdfs]");
        x3.setValidationType(ValidationType.VAR_SET);
        x3.setValidationValue("var1");
        vsiList.add(x3);
        
        HeaderValidation h1 = new HeaderValidation();
        h1.setHeader("test.header");
        h1.setValue("test_value");
        vsiList.add(h1);
        
        XPathValidation x4 = new XPathValidation();
        x4.setXpath("/sdjkflsdfj/sdfsdf");
        x4.setValidationType(ValidationType.CHILDREN);
        x4.setValidationValue("childalsdll");
        vsiList.add(x4);
        
        try {
        	Class<?>[] classes = new Class<?>[] {
        		ValidationSet.class,
        		ObjectFactory.class
        	};
			JAXBContext jaxbContext = JAXBContext.newInstance(classes);
			Marshaller m = jaxbContext.createMarshaller();
			
			// Output pretty printed
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(valSet, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("\n******** Creating objects from XML File **********");
        
        InputStream in = App.class.getClassLoader().getResourceAsStream("validationSet.xml");
        
        try {
			JAXBContext ctx = JAXBContext.newInstance(new Class<?>[] {ValidationSet.class, ObjectFactory.class});
			
			Unmarshaller um = ctx.createUnmarshaller();
			
			ValidationSet vs = (ValidationSet) um.unmarshal(in);
			
			//System.out.println(vs);
			
			List<ValidationSetItem> vsi = vs.getValidationItems();
			
			for(ValidationSetItem i : vsi) {
				System.out.println(i.toString());
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
