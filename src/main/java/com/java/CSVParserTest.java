package com.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class CSVParserTest {

    @Test
    public void testParseWithValidData() throws IOException {
        String csvData = "1234567890123456\n4123456789012";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(csvData.getBytes());
        CSVParser parser = new CSVParser();

        List<CreditCardData> result = parser.parse(inputStream);
        assertEquals(2, result.size());
        assertEquals("1234567890123456", result.get(0).getCardNumber());
        assertEquals("MasterCard", result.get(0).getCardType());
        assertEquals("4123456789012", result.get(1).getCardNumber());
        assertEquals("Visa", result.get(1).getCardType());
    }

    @Test
    public void testParseWithEmptyData() throws IOException {
        String csvData = "";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(csvData.getBytes());
        CSVParser parser = new CSVParser();

        List<CreditCardData> result = parser.parse(inputStream);
        assertTrue(result.isEmpty());
    }
}
