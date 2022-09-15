package com.solvd.deliverybusiness.service;

import com.solvd.deliverybusiness.model.Customer;
import com.solvd.deliverybusiness.model.Restaurant;

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

public class ReadRestaurantXmlImpl implements IReadRestaurantXml{
    @Override
    public void readXml() throws FileNotFoundException, XMLStreamException {
        List<Restaurant> listaRestorana = new ArrayList<>();
        Restaurant restaurant = null;
        File file = new File("src/main/resources/xml/restaurant.xml");
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if(startElement.getName().getLocalPart().equalsIgnoreCase("restaurant")) {
                    restaurant = new Restaurant();
                }
                if (startElement.getName().getLocalPart().equalsIgnoreCase("ID")) {
                    restaurant.setID(Integer.parseInt(((Characters) reader.nextEvent()).getData()));
                }
                if (startElement.getName().getLocalPart().equalsIgnoreCase("Name")) {
                    restaurant.setName(((Characters) reader.nextEvent()).getData());
                }
                if (startElement.getName().getLocalPart().equalsIgnoreCase("City_ID")) {
                    restaurant.setCityID(Integer.parseInt(((Characters) reader.nextEvent()).getData()));
                }
            }
            if (xmlEvent.isEndElement()){
                EndElement endElement = xmlEvent.asEndElement();
                if("restaurant".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    listaRestorana.add(restaurant);
                }
            }
        }
        for (Restaurant restaurant1 : listaRestorana) {
            System.out.println(restaurant1);
        }
    }
}
