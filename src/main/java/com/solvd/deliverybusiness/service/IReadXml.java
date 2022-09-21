package com.solvd.deliverybusiness.service;
import jakarta.xml.bind.JAXBException;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public interface IReadXml {
    public void readXml() throws FileNotFoundException, XMLStreamException, JAXBException;

}
