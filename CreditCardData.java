public class CreditCardData {
    private String cardNumber;
    private String cardType;

    public CreditCardData(String cardNumber, String cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    // You can add setters if needed
}