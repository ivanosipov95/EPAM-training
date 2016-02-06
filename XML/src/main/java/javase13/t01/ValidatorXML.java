package javase13.t01;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXML {

    public static boolean checkXML(String pathXml, String pathXsd) {
        try {

            File xml = new File(pathXml);
            File xsd = new File(pathXsd);

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = factory.newSchema(new StreamSource(pathXsd));
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(pathXml));
            return true;
        } catch (SAXException | IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main (String args[]) throws IOException, SAXException, ParserConfigurationException {
        boolean b = ValidatorXML.checkXML("C:\\Users\\Ivano\\EPAM-training\\XML\\src\\main\\java\\javase13\\t01\\books.xml",
                "C:\\Users\\Ivano\\EPAM-training\\XML\\src\\main\\java\\javase13\\t01\\books.xsd");
        System.out.println("XML соответствует XSD");
    }
}
