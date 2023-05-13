package com.yashasvi.creditcard;

public class OutputRecord {

    private String cardType;
    private String cardNumber;

    public OutputRecord(String number, String type) {
        this.cardNumber = number;
        if (this.cardNumber == "") {
            this.cardNumber = "null";

        }
        this.cardType = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardNumber(String number) {
        this.cardNumber = number;
    }

    public void setCardType(String type) {
        this.cardType = type;
    }
}