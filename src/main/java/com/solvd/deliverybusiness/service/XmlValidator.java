package com.solvd.deliverybusiness.service;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
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

    private String xsdPath;

    private String xmlPath;

    public XmlValidator() {
    }

    public void xsdXmlValidation(String xsdPath, String xmlPath) throws SAXException, IOException {
        Configurator.setLevel(log.getName(), Level.INFO);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(xsdPath));
        Source xmlFile = new StreamSource(new File(xmlPath));
        Validator validator = schema.newValidator();
        validator.validate(xmlFile);
        log.info(xmlFile.getSystemId() + " is valid");
    }

    /*public void anotherExampleXsdXml(){
        try{
            xsdXmlValidation(xsdPath, xmlPath);
          NOTE FOR ME  -  ANOTHER WAY OF SOLVING THE PROBLEM
          SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("src/main/resources/xsd/menu.xsd"));
            Source xmlFile = new StreamSource(new File("src/main/resources/xml/menu.xml"));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
        }
        catch (SAXException | IOException e){
            log.error(e.getMessage());
        }
    }*/
}
