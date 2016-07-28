package ca.uqam.projet.resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Converter {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
    
    //convertis XML en object java
    public Object doUnMarshaling(String fileName) throws IOException, JAXBException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("https://montreal.bixi.com/data/bikeStations.xml");
            return unmarshaller.unmarshal(new StreamSource(fis));
        } finally {
        	fis.close();
        }
    }
} 
