package com.yashasvi.creditcard;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCard {
    @JsonProperty("CARD_NUMBER")
    @JsonAlias({ "cardNumber", "CardNumber" })
    private String cardNumber;
    @JsonProperty("EXPIRATION_DATE")
    @JsonAlias({ "expirationDate", "ExpirationDate" })
    private String expirationDate;
    @JsonProperty("CARD_HOLDER_NAME")
    @JsonAlias({ "cardHolderName", "NameOfCardholder" })
    private String nameOfHolder;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getNameOfHolder() {
        return nameOfHolder;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setNameOfHolder(String nameOfCardholder) {
        this.nameOfHolder = nameOfCardholder;
    }
}