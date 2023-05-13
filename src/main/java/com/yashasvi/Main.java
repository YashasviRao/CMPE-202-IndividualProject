package com.yashasvi;

import com.yashasvi.creditcard.CreditCard;
import com.yashasvi.inputoutput.RecordInputOutput;
import com.yashasvi.inputoutput.RecordInputOutputFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Invalid syntax. Usage: java Main <input filename> <output filename>");
            System.exit(1);
        }

        String inputFilename = args[0];
        String outputFilename = args[1];
        Utils.validatePaths(inputFilename, outputFilename);
        RecordInputOutput io = new RecordInputOutputFactory().getRecordIO(inputFilename);
        List<CreditCard> creditCards = io.readFile(inputFilename);
        boolean writeSuccess = io.writeFile(outputFilename, creditCards);
        if (writeSuccess) {
            System.out.println("Output successfully written to " + outputFilename);
        } else {
            System.out.println("Failed to write output");
        }
    }
}