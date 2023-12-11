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

            Element numberElement = doc.createElement("cardNumber");
            numberElement.appendChild(doc.createTextNode(data.getCardNumber()));
            cardElement.appendChild(numberElement);

            Element typeElement = doc.createElement("cardType");
            typeElement.appendChild(doc.createTextNode(data.getCardType()));
            cardElement.appendChild(typeElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(outputStream);
        transformer.transform(domSource, streamResult);
    }
}
