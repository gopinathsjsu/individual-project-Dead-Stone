import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

public class JSONParser implements FileFormatParser {
    @Override
    public List<CreditCardData> parse(InputStream inputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> list = mapper.readValue(inputStream, new TypeReference<List<Map<String, String>>>() {});
        List<CreditCardData> dataList = new ArrayList<>();
        for (Map<String, String> map : list) {
            String cardNumber = map.get("cardNumber");
            String cardType = CreditCardFactory.getCreditCardType(cardNumber);
            dataList.add(new CreditCardData(cardNumber, cardType));
        }
        return dataList;
    }
}
