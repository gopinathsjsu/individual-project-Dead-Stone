package com.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class JSONParser implements FileFormatParser {
    @Override
    public List<CreditCardData> parse(InputStream inputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Assuming the JSON structure starts with an object containing an array of cards
        Map<String, List<Map<String, String>>> root = mapper.readValue(inputStream, new TypeReference<Map<String, List<Map<String, String>>>>() {});
        List<Map<String, String>> list = root.get("cards"); // Assuming "cards" is the key for the array
        List<CreditCardData> dataList = new ArrayList<>();
        for (Map<String, String> map : list) {
            String cardNumber = map.get("cardNumber");
            String cardType = CreditCardFactory.getCreditCardType(cardNumber);
            dataList.add(new CreditCardData(cardNumber, cardType));
        }
        return dataList;
    }
}
