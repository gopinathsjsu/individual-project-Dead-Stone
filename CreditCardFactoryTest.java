import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreditCardFactoryTest {

    @Test
    public void testGetCreditCardTypeWithNull() {
        assertEquals("Invalid: empty/null card number", CreditCardFactory.getCreditCardType(null));
    }

    @Test
    public void testGetCreditCardTypeWithEmptyString() {
        assertEquals("Invalid: empty/null card number", CreditCardFactory.getCreditCardType(""));
    }

    @Test
    public void testGetCreditCardTypeWithNonNumeric() {
        assertEquals("Invalid: non numeric characters", CreditCardFactory.getCreditCardType("abcd"));
    }

    @Test
    public void testGetCreditCardTypeWithMoreThan19Digits() {
        assertEquals("Invalid: more than 19 digits", CreditCardFactory.getCreditCardType("12345678901234567890"));
    }

    @Test
    public void testGetCreditCardTypeForValidMasterCard() {
        assertEquals("MasterCard", CreditCardFactory.getCreditCardType("5123456789012345"));
    }

    @Test
    public void testGetCreditCardTypeForValidVisaCard() {
        assertEquals("Visa", CreditCardFactory.getCreditCardType("4123456789012"));
    }

    @Test
    public void testGetCreditCardTypeForValidAmExCard() {
        assertEquals("AmericanExpress", CreditCardFactory.getCreditCardType("341234567890123"));
    }

    @Test
    public void testGetCreditCardTypeForValidDiscoverCard() {
        assertEquals("Discover", CreditCardFactory.getCreditCardType("6011123456789012"));
    }

    @Test
    public void testGetCreditCardTypeForInvalidCard() {
        assertEquals("Invalid: not a possible card number", CreditCardFactory.getCreditCardType("1111222233334444"));
    }
}
