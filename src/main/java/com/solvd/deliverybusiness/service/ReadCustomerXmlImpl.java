package com.solvd.deliverybusiness.service;
import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Restaurant;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import javax.xml.stream.*;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerXmlImpl implements IReadXml {
    private static Logger log = LogManager.getLogger(ReadRestaurantXmlImpl.class);
    private String path;
    public String getPath() {

        return path;
    }

    public ReadCustomerXmlImpl(String path) {
        this.path = path;
    }



    @Override
    public void readXml() throws FileNotFoundException, XMLStreamException, JAXBException {
        Configurator.setLevel(log.getName(), Level.INFO);
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        List<Customer> listaMusterija = new ArrayList<>();
        Unmarshaller um = jaxbContext.createUnmarshaller();
        XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlFactory.createXMLStreamReader(new FileReader(this.path));
        while (reader.hasNext() && (!reader.isStartElement() || !reader.getLocalName().equals("customer"))) {
            reader.next();
        }
        while (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
            JAXBElement<Customer> boolElement = um.unmarshal(reader, Customer.class);
            Customer cust = boolElement.getValue();
            listaMusterija.add(cust);
            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                reader.next();
            }
        }
        listaMusterija.forEach(s -> log.info(s));
    }
}
       /* Configurator.setLevel(log.getName(), Level.INFO);
        List<Customer> listaMusterija = new ArrayList<>();
        Customer customer = null;
        File file = new File(getPath());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if(startElement.getName().getLocalPart().equalsIgnoreCase("customer")) {
                    customer = new Customer();
                }
              /* if (startElement.getName().getLocalPart().equalsIgnoreCase("ID")) {
                  customer.setID(Integer.parseInt(((Characters) reader.nextEvent()).getData()));
                }
                if (startElement.getName().getLocalPart().equalsIgnoreCase("FullName")) {
                    customer.setFullName(((Characters) reader.nextEvent()).getData());
               }
                if (startElement.getName().getLocalPart().equalsIgnoreCase("Address")) {
                   customer.setAddress(((Characters) reader.nextEvent()).getData());
               }
               if (startElement.getName().getLocalPart().equalsIgnoreCase("City")) {
                    customer.setCity(Integer.parseInt(((Characters) reader.nextEvent()).getData()));
                }
            }
            if (xmlEvent.isEndElement()){
                EndElement endElement = xmlEvent.asEndElement();
                if("customer".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    listaMusterija.add(customer);
                }
            }
        }
        listaMusterija.forEach(s->log.info(s));
        } */

