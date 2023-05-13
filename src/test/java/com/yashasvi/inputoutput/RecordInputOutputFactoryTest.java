package com.yashasvi.inputoutput;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class RecordInputOutputFactoryTest {

    @Test
    public void test_CSV() {
        RecordInputOutputFactory f = new RecordInputOutputFactory();
        assert (f.getRecordIO("file.csv") instanceof CsvRecordInputOutput);
    }

    @Test
    public void test_XML() {
        RecordInputOutputFactory f = new RecordInputOutputFactory();
        assert (f.getRecordIO("file.xml") instanceof XmlRecordInputOutput);
    }

    @Test
    public void test_JSON() {
        RecordInputOutputFactory f = new RecordInputOutputFactory();
        assert (f.getRecordIO("file.json") instanceof JsonRecordInputOutput);
    }

    @Test
    public void test_unsupported() {
        RecordInputOutputFactory f = new RecordInputOutputFactory();
        assertThrows(UnsupportedOperationException.class, () -> f.getRecordIO("file.proto"));
    }

}
