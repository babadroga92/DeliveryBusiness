package com.solvd.deliverybusiness.service;
import com.solvd.deliverybusiness.dao.CustomerDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    private static Logger log = LogManager.getLogger(XmlValidator.class.getName());


    public void validateCustomerXml() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("src/main/resources/xsd/customer.xsd"));
            Source xmlFile = new StreamSource(new File("src/main/resources/xml/customer.xml"));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        }
        catch (SAXException | IOException e){
            log.error(e.getMessage());
        }
    }

    public void validateRestaurantXml() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("src/main/resources/xsd/restaurant.xsd"));
            Source xmlFile = new StreamSource(new File("src/main/resources/xml/restaurant.xml"));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        }
        catch (SAXException | IOException e){
            log.error(e.getMessage());
        }
    }
}
