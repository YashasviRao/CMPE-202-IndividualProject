package com.yashasvi.creditcard;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardFactoryTest {

    @Test
    public void test_DiscoverCard() {
        CreditCardFactory f = new CreditCardFactory();
        CreditCard card = f.getCreditCard("6011111100007756");
        assertTrue(card instanceof DiscoverCreditCard);
        assertEquals("Discover", card.toString());
    }

    @Test
    public void test_VisaCC() {
        CreditCardFactory f = new CreditCardFactory();
        CreditCard card = f.getCreditCard("4123456789123");
        assertTrue(card instanceof VisaCreditCard);
        assertEquals("Visa", card.toString());
    }

    @Test
    public void test_AmexCC() {
        CreditCardFactory f = new CreditCardFactory();
        CreditCard card = f.getCreditCard("347856341908126");
        assertTrue(card instanceof AmExCreditCard);
        assertEquals("AmericanExpress", card.toString());
    }

    @Test
    public void test_MasterCC() {
        CreditCardFactory f = new CreditCardFactory();
        CreditCard card = f.getCreditCard("5367894523129089");
        assertTrue(card instanceof MasterCreditCard);
        assertEquals("MasterCard", card.toString());

    }

    @Test
    public void test_invalidCreditCardNumber() {
        CreditCardFactory f = new CreditCardFactory();
        assertThrows(UnsupportedOperationException.class, () -> f.getCreditCard("000"));
    }

}
