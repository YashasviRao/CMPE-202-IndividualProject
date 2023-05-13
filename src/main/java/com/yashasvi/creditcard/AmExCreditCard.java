package com.yashasvi.creditcard;

public class AmExCreditCard extends CreditCard {

    @Override
    public String toString() {
        return "AmericanExpress";
    }

    public static boolean isValidCard(String card) {
        return card.length() == 15 && card.charAt(0) == '3' && (card.charAt(1) == '4' || card.charAt(1) == '7');
    }
}
