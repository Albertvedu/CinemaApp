package LlegirXML;

import model.Pelis;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class LlegirXmlPeliculas extends DefaultHandler {
    private boolean idFilm;
    private boolean name;
    private boolean any;
    private boolean original;
    private boolean direccio;
    private boolean versio;
    private boolean idioma;
    private boolean data;
    private boolean interpret;
    private boolean cartell;
    private boolean sinopsi;

    private Pelis actualPeli = new Pelis();
    private List<Pelis> pelisList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        super.startElement(uri, localName, qName, attributes);
        if (qName.equalsIgnoreCase("IDFILM")) {
            idFilm = true;
        }else
        if (qName.equalsIgnoreCase("Titol")) {
            name = true;
        }else
        if (qName.equalsIgnoreCase("Any")) {
            any = true;
        }else
        if (qName.equalsIgnoreCase("Cartell")) {
            cartell = true;
        }else
        if (qName.equalsIgnoreCase("Original")) {
            original = true;
        }else
        if (qName.equalsIgnoreCase("Direccio")) {
            direccio = true;
        }else
        if (qName.equalsIgnoreCase("Versio")) {
            versio = true;
        }else
        if (qName.equalsIgnoreCase("IDIOMA_x0020_ORIGINAL")) {
            idioma = true;
        }else
        if (qName.equalsIgnoreCase("Estrena")) {
            data = true;
        }else
        if (qName.equalsIgnoreCase("Interprets")) {
            interpret = true;
        }else
        if (qName.equalsIgnoreCase("Sinopsi")) {
            sinopsi = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (idFilm) {
            actualPeli.setIdFilm(new String(ch, start, length));
            idFilm = false;
        }
        if (name) {
            actualPeli.setTitol(new String(ch, start, length));
            name = false;
        }
        if (any) {
            actualPeli.setAny(new String(ch, start, length));
            any = false;
        }
        if (cartell) {
            actualPeli.setCartell(new String(ch, start, length));
            cartell = false;
        }
        if (original) {
            actualPeli.setOriginal(new String(ch, start, length));
            original = false;
        }
        if (direccio) {
            actualPeli.setDireccio(new String(ch, start, length));
            direccio = false;
        }
        if (versio) {
            actualPeli.setVersio(new String(ch, start, length));
            versio = false;
        }
        if (idioma) {
            actualPeli.setIdioma(new String(ch, start, length));
            idioma = false;
        }
        if (data) {
            actualPeli.setDataEstrena(new String(ch, start, length));
            data = false;
        }
        if (interpret) {
            actualPeli.setInterprets(List.of(new String(ch, start, length)));
            interpret = false;
        }
        if (sinopsi) {
            actualPeli.setSinopsi(new String(ch, start, length));
            sinopsi = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Film")) {
            pelisList.add(actualPeli);
            actualPeli = new Pelis();
        }
    }

    public List<Pelis> getListPelis() {
        return pelisList;
    }
}

