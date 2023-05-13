package com.yashasvi.inputoutput;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.yashasvi.creditcard.CreditCard;
import com.yashasvi.creditcard.CreditCardFactory;
import com.yashasvi.creditcard.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XmlRecordInputOutput implements RecordInputOutput {

    @Override
    public List<CreditCard> readFile(String filePath) {
        List<CreditCard> data = new ArrayList<>();
        File f = new File(filePath);
        try (Reader r = new FileReader(f)) {
            MappingIterator<CreditCard> i = getXmlFileReader().readValues(r);
            while (i.hasNext()) {
                CreditCard c = i.next();
                data.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean writeFile(String filePath, List<CreditCard> data) {
        File f = new File(filePath);
        List<OutputRecord> list = getOutputFileRecords(data);
        try {
            getXmlFileMapper().writeValue(f, list);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private XmlMapper getXmlFileMapper() {
        XmlMapper m = new XmlMapper();
        m.enable(SerializationFeature.INDENT_OUTPUT);
        m.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return m;
    }

    private ObjectReader getXmlFileReader() {
        return getXmlFileMapper().readerFor(CreditCard.class);
    }

    private List<OutputRecord> getOutputFileRecords(List<CreditCard> creditCards) {
        return creditCards
                .stream()
                .map(r -> {
                    String number = r.getCardNumber();
                    try {
                        return new OutputRecord(
                                number,
                                new CreditCardFactory().getCreditCard(number).toString());
                    } catch (UnsupportedOperationException e) {
                        return new OutputRecord(
                                number,
                                e.getMessage());
                    }
                })
                .collect(Collectors.toList());
    }
}