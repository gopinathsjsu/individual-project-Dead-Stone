package com.java;

import java.io.OutputStream;
import java.util.List;

public interface FileFormatWriter {
    void write(List<CreditCardData> creditCardData, OutputStream outputStream) throws Exception;
}