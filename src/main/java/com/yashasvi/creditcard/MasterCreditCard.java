package com.yashasvi.creditcard;

public class MasterCreditCard extends CreditCard {

    @Override
    public String toString() {
        return "MasterCard";
    }

    public static boolean isValidCard(String card) {
        return card.length() == 16 &&
                card.charAt(0) == '5' &&
                card.charAt(1) >= '1' &&
                card.charAt(1) <= '5';
    }
}
