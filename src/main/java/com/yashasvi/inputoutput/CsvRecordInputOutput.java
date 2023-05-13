package com.yashasvi.inputoutput;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
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

public class CsvRecordInputOutput implements RecordInputOutput {

    @Override
    public List<CreditCard> readFile(String filePath) {
        List<CreditCard> data = new ArrayList<>();
        File f = new File(filePath);
        try (Reader r = new FileReader(f)) {
            MappingIterator<CreditCard> mappingIterator = getCsvFileReader().readValues(r);
            while (mappingIterator.hasNext()) {
                CreditCard c = mappingIterator.next();
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
            ObjectWriter w = getCsvFileMapper().writer(getOutputFileSchema());
            w.writeValue(f, list);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ObjectReader getCsvFileReader() {
        CsvMapper m = getCsvFileMapper();
        CsvSchema s = CsvSchema.emptySchema().withHeader();
        return m.readerFor(CreditCard.class).with(s);
    }

    private CsvSchema getOutputFileSchema() {
        return CsvSchema.builder()
                .addColumn("cardNumber")
                .addColumn("cardType")
                .build()
                .withHeader();
    }

    private CsvMapper getCsvFileMapper() {
        CsvMapper cm = new CsvMapper();
        // cm.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return cm;
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