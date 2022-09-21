package com.solvd.deliverybusiness.service;

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

public class ReadRestaurantXmlImpl implements IReadXml {

    private static Logger log = LogManager.getLogger(ReadRestaurantXmlImpl.class);


    private String path;

    public ReadRestaurantXmlImpl(String path) {

        this.path = path;
    }

    public String getPath() {

        return path;
    }

    @Override
    public void readXml() throws FileNotFoundException, XMLStreamException, JAXBException {
        Configurator.setLevel(log.getName(), Level.INFO);
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        List<Restaurant> listaRestorana = new ArrayList<>();
        Unmarshaller um = jaxbContext.createUnmarshaller();
        XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlFactory.createXMLStreamReader(new FileReader(this.path));
        while (reader.hasNext() && (!reader.isStartElement() || !reader.getLocalName().equals("restaurant"))) {
            reader.next();
        }
        while (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
            JAXBElement<Restaurant> boolElement = um.unmarshal(reader, Restaurant.class);
            Restaurant rest = boolElement.getValue();
            listaRestorana.add(rest);
            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                reader.next();
            }
        }
        listaRestorana.forEach(s -> log.info(s));
    }
       /* Configurator.setLevel(log.getName(), Level.INFO);
        List<Restaurant> listaRestorana = new ArrayList<>();
        Restaurant restaurant = null;
        File file = new File(getPath());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(new FileReader(file));
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();
        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if(startElement.getName().getLocalPart().equalsIgnoreCase("restaurant")) {
                    restaurant = (Restaurant) um.unmarshal(reader);
                }
                listaRestorana.add(restaurant);
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
        listaRestorana.forEach(s->System.out.println(s));
        }*/
}
