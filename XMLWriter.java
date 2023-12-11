import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.List;

public class XMLWriter implements FileFormatWriter {
    @Override
    public void write(List<CreditCardData> creditCardData, OutputStream outputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("CreditCards");
        doc.appendChild(root);

        for (CreditCardData data : creditCardData) {
            Element cardElement = doc.createElement("Card");
            root.appendChild(cardElement);

            addElementWithText(doc, cardElement, "cardNumber", data.getCardNumber());
            addElementWithText(doc, cardElement, "cardType", data.getCardType());
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(outputStream);
        transformer.transform(domSource, streamResult);
    }

    private void addElementWithText(Document doc, Element parent, String tagName, String textContent) {
        Element elem = doc.createElement(tagName);
        if (textContent != null) {
            elem.appendChild(doc.createTextNode(textContent));
        } else {
            elem.appendChild(doc.createTextNode(""));
        }
        parent.appendChild(elem);
    }
}
