package io.github.synepis.trains.darwin;

import io.github.synepis.trains.darwin.model.cttreferenceschema.PportTimetableRef;
import io.github.synepis.trains.darwin.model.cttschema.PportTimetable;
import io.github.synepis.trains.darwin.model.pptschema.Pport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlParser {
    private Map<Class, JAXBContext> jaxbContexts;

    public XmlParser() throws JAXBException {
        jaxbContexts = new HashMap<>();
        jaxbContexts.put(PportTimetableRef.class, JAXBContext.newInstance(PportTimetableRef.class));
        jaxbContexts.put(PportTimetable.class, JAXBContext.newInstance(PportTimetable.class));
        jaxbContexts.put(Pport.class, JAXBContext.newInstance(Pport.class));
    }

    public PportTimetableRef parseCttiReferenceSchema(InputStream inputStream) throws JAXBException {
        return (PportTimetableRef)jaxbContexts.get(PportTimetableRef.class)
                .createUnmarshaller()
                .unmarshal(inputStream);
    }

    public PportTimetable parseCttiSchema(InputStream inputStream) throws JAXBException {
        return (PportTimetable)jaxbContexts.get(PportTimetable.class)
                .createUnmarshaller()
                .unmarshal(inputStream);
    }

    public Pport parsePPTSchema(InputStream inputStream) {
        try {
            return (Pport)jaxbContexts.get(Pport.class)
                    .createUnmarshaller()
                    .unmarshal(inputStream);
        } catch (JAXBException e) {
            return null;
        }
    }
}
