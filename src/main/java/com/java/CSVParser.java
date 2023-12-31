package com.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements FileFormatParser {
    public List<CreditCardData> parse(InputStream inputStream) throws IOException {
        List<CreditCardData> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int c=0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(c==0 && parts[0].equals("cardNumber")){
                    c+=1;
                    continue;
                }
                if (parts.length > 0 && !parts[0].isEmpty()) {
                    String cardNumber = parts[0].trim();
                    String cardType = CreditCardFactory.getCreditCardType(cardNumber);
                    dataList.add(new CreditCardData(cardNumber, cardType));
                }
            }
        }
        return dataList;
    }
}