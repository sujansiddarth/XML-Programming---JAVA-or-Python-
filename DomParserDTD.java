package assignment3_XML;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class DomParserDTD {
    public static void main(String[] args) {
        try {
            // specify the location of the xml and dtd files
            File xmlFile = new File("res/library.xml");
            File dtdFile = new File("res/library.dtd");

            // create a schema factory and set the schema language to DTD
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // create a validator object using the dtd file
            Validator validator = factory.newSchema(dtdFile).newValidator();

            // validate the xml file using the validator object
            validator.validate(new StreamSource(xmlFile));

            System.out.println("Validation successful.");

        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
