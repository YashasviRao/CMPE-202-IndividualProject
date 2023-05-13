package com.yashasvi.creditcard;

public class CreditCardFactory {
    public CreditCard getCreditCard(String cardNumber) {
        if (cardNumber.contains("*")) {
            throw new UnsupportedOperationException("Invalid: non numeric characters");
        } else if (cardNumber.length() > 19) {
            throw new UnsupportedOperationException("Invalid: more than 19 digits");
        } else if (cardNumber.isEmpty()) {
            throw new UnsupportedOperationException("Invalid: empty/null card number");
        } else if (MasterCreditCard.isValidCard(cardNumber)) {
            return new MasterCreditCard();
        } else if (VisaCreditCard.isValidCard(cardNumber)) {
            return new VisaCreditCard();
        } else if (AmExCreditCard.isValidCard(cardNumber)) {
            return new AmExCreditCard();
        } else if (DiscoverCreditCard.isValidCard(cardNumber)) {
            return new DiscoverCreditCard();
        } else {
            throw new UnsupportedOperationException("Invalid: not a possible card number");
        }
    }
}