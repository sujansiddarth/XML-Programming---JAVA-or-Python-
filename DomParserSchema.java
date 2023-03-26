package assignment3_XML;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class DomParserSchema {
    public static void main(String[] args) {
        String xmlFilePath = "res/library.xml";
        String xsdFilePath = "res/library.xsd";

        try {
            // Create a SchemaFactory and set the schema language
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Create a Schema object from the XSD file
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));

            // Create a Validator object from the Schema object
            Validator validator = schema.newValidator();

            // Validate the XML file against the schema
            Source xmlFile = new StreamSource(new File(xmlFilePath));
            validator.validate(xmlFile);

            System.out.println("Validation successful.");
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
