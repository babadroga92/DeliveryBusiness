package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.model.Customer;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadXmlImpl implements IReadXml {
    @Override
    public void readXml() throws FileNotFoundException, XMLStreamException {
        List<Customer> listaMusterija = new ArrayList<>();
        Customer customer = null;
        File file = new File("src/main/resources/customer.xml");
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
        while (reader.hasNext()) {
           // reader.next();
            XMLEvent event = reader.nextEvent();
            if(event.isStartElement()){
                StartElement startElement = event.asStartElement();
                if(startElement.getName().getLocalPart().equalsIgnoreCase("customer")){
                    customer = new Customer();
                    if (startElement.getName().getLocalPart().equalsIgnoreCase("FullName")) {
                        customer.setFullName(event.asCharacters().getData());
//                        if (reader.getLocalName().equalsIgnoreCase("Address")) {
//                            customer.setAddress(reader.getElementText());
//                            if (reader.getLocalName().equalsIgnoreCase("City")) {
//                                customer.setCity(Integer.parseInt(reader.getElementText()));
                }

            }
//            if (reader.getEventType() == XMLStreamReader.START_ELEMENT) {
//                if (reader.getLocalName().equalsIgnoreCase("customer")) {
//                    customer = new Customer();
//                    if (reader.getLocalName().equalsIgnoreCase("FullName")) {
//                        customer.setFullName(reader.getElementText());
//                        if (reader.getLocalName().equalsIgnoreCase("Address")) {
//                            customer.setAddress(reader.getElementText());
//                            if (reader.getLocalName().equalsIgnoreCase("City")) {
//                                customer.setCity(Integer.parseInt(reader.getElementText()));

                            }
            if(event.isEndElement()){
                EndElement element= event.asEndElement();
                if(element.getName().getLocalPart().equalsIgnoreCase("customer")){
                    listaMusterija.add(customer);
                        }
                    }
                }
//                }
//                if (reader.getEventType() == XMLStreamReader.END_ELEMENT) {
//                    if (reader.getLocalName().equalsIgnoreCase("customer")) {
//                        listaMusterija.add(customer);
//                    }
//                }
//            }
            for (Customer customer1 : listaMusterija) {
                System.out.println(customer1);
            }
        }
    }
