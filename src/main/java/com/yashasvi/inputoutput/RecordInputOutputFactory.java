package com.yashasvi.inputoutput;

public class RecordInputOutputFactory {
    public RecordInputOutput getRecordIO(String filename) {
        if (filename.endsWith(".csv")) {
            return new CsvRecordInputOutput();
        } else if (filename.endsWith(".json")) {
            return new JsonRecordInputOutput();
        } else if (filename.endsWith(".xml")) {
            return new XmlRecordInputOutput();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}