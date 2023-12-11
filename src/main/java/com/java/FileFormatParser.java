package com.java;

import java.io.InputStream;
import java.util.List;

public interface FileFormatParser {
    List<CreditCardData> parse(InputStream inputStream) throws Exception;
}
