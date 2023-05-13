package com.yashasvi;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class UtilsTest {

    @Test
    public void test_validateTheFileExtension_notThrowOnValidExtensions() {
        Utils.validateTheFileExtension("input.csv", "output.csv");
    }

    @Test
    public void test_validateTheFileExtension_throwsErrorOnInvalidExtensions() {
        assertThrows(RuntimeException.class, () -> Utils.validateTheFileExtension("input.json", "output.csv"));
    }

    @Test
    public void test_validateInputPathIfExists_notThrowOnValidPath() {
        Utils.validateInputPathIfExists("src/main/resources/input.csv");
    }

    @Test
    public void test_validateInputPathIfExists_throwsOnInvalidPath() {
        assertThrows(RuntimeException.class, () -> Utils.validateInputPathIfExists("input1.csv"));
    }
}