package com.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class CSVWriterTest {

    @Test
    public void testWriteWithValidData() throws IOException {
        List<CreditCardData> data = Arrays.asList(
            new CreditCardData("5567894523129089", "MasterCard"),
            new CreditCardData("4123456789012", "Visa")
        );

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CSVWriter writer = new CSVWriter();
        writer.write(data, outputStream);

        String output = outputStream.toString();
        assertTrue(output.contains("5567894523129089,MasterCard"));
        assertTrue(output.contains("4123456789012,Visa"));
    }
}
