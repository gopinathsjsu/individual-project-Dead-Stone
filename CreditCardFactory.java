public class CreditCardFactory {
    public static String getCreditCardType(String cardNumber) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            return "Invalid: empty/null card number";
        } else if (!cardNumber.matches("\\d+")) {
            return "Invalid: non numeric characters";
        } else if (cardNumber.length() > 19) {
            return "Invalid: more than 19 digits";
        } else if (isValidMasterCard(cardNumber)) {
            return "MasterCard";
        } else if (isValidVisaCard(cardNumber)) {
            return "Visa";
        } else if (isValidAmExCard(cardNumber)) {
            return "AmericanExpress";
        } else if (isValidDiscoverCard(cardNumber)) {
            return "Discover";
        } else {
            return "Invalid: not a possible card number";
        }
    }

    private static boolean isValidMasterCard(String cardNumber) {
        return cardNumber.startsWith("5") && cardNumber.length() == 16;
    }

    private static boolean isValidVisaCard(String cardNumber) {
        return cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16);
    }

    private static boolean isValidAmExCard(String cardNumber) {
        return (cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15;
    }

    private static boolean isValidDiscoverCard(String cardNumber) {
        return cardNumber.startsWith("6011") && cardNumber.length() == 16;
    }
}