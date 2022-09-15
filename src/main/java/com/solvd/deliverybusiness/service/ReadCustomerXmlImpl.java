package com.solvd.deliverybusiness.service;
import com.solvd.deliverybusiness.model.Customer;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerXmlImpl implements IReadCustomerXml {
    @Override
    public void readXml() throws FileNotFoundException, XMLStreamException {
        List<Customer> listaMusterija = new ArrayList<>();
        Customer customer = null;
        File file = new File("src/main/resources/xml/customer.xml");
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if(startElement.getName().getLocalPart().equalsIgnoreCase("customer")) {
                    customer = new Customer();
                }
                if (startElement.getName().getLocalPart().equalsIgnoreCase("ID")) {
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
        for (Customer customer1 : listaMusterija) {
            System.out.println(customer1);
        }
    }
}
