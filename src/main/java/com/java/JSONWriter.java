package com.java;

import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONWriter implements FileFormatWriter {
    @Override
    public void write(List<CreditCardData> creditCardData, OutputStream outputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Wrap the data list in a Map to match the expected JSON structure
        Map<String, List<CreditCardData>> root = new HashMap<>();
        root.put("cards", creditCardData);
        mapper.writeValue(outputStream, root);
    }
}

