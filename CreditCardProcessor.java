import java.io.*;

public class CreditCardProcessor {

    public static void main(String[] args) {
        // Please replace these with your actual file paths
        String inputFilename = "input_file.csv";
        String outputFilename = "output_file.csv";
        processFile(inputFilename, outputFilename);
    }

    public static void processFile(String inputFilename, String outputFilename) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFilename))
        ) {
            // Write the header
            writer.println("cardNumber,cardType");

            String line;
            int c=0;
            while ((line = reader.readLine()) != null) {
                if (c==0){
                    c+=1;
                    continue;
                }
                String[] parts = line.split(",");
                String result;
                if (parts.length > 0 && !parts[0].isEmpty()) {
                    String cardNumber = parts[0].trim();
                    String cardType = CreditCardFactory.getCreditCardType(cardNumber);
                    result = cardNumber + "," + cardType;
                } else {
                    result = "," + "Invalid: empty/null card number";
                }
                writer.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CreditCardFactory {
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