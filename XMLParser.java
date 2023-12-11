import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements FileFormatParser {
    @Override
    public List<CreditCardData> parse(InputStream inputStream) throws Exception {
        List<CreditCardData> dataList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputStream);

        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element cardElement = (Element) node;
                String cardNumber = cardElement.getElementsByTagName("cardNumber").item(0).getTextContent();
                String cardType = CreditCardFactory.getCreditCardType(cardNumber);
                dataList.add(new CreditCardData(cardNumber, cardType));
            }
        }
        return dataList;
    }
}
