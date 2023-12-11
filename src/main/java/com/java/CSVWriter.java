package com.java;

import java.io.*;
import java.util.List;

public class CSVWriter implements FileFormatWriter {
    public void write(List<CreditCardData> creditCardData, OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("cardNumber,cardType\n");
        for (CreditCardData data : creditCardData) {
            writer.write(data.getCardNumber() + "," + data.getCardType() + "\n");
        }
        writer.flush();
    }
}