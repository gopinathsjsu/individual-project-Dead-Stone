package com.java;

import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

public class JSONWriter implements FileFormatWriter {
    @Override
    public void write(List<CreditCardData> creditCardData, OutputStream outputStream) throws IOException {
         ObjectMapper mapper = new ObjectMapper();
         mapper.writeValue(outputStream, creditCardData);
    }
}
