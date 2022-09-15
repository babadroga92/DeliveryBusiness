package com.solvd.deliverybusiness.service;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public interface IReadRestaurantXml {
    public void readXml() throws FileNotFoundException, XMLStreamException;
}
