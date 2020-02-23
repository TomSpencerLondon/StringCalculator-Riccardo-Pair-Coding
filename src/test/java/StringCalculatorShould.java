import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorShould {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"!0",
                        "1! 1",
                        "2! 2",
                        "2,2! 4",
                        "1,2,3,4,5,6,7,8,9! 45"}, delimiter = '!')
    public void covertsStringToNumber(String stringOfNumbers, int result){
        assertEquals(result, stringCalculator.add(stringOfNumbers));
    }

    @Test
    public void convertsNewLineStringToNumber(){
        String stringOfNumbers = "1,2,3";
        int result = 6;
        assertEquals(result, stringCalculator.add(stringOfNumbers));
    }

    @Test
    void includesCustomSeparators() {
        String stringOfNumbers = "//;\n1;2";
        int result = 3;
        assertEquals(result, stringCalculator.add(stringOfNumbers));
    }

    @Test
    void throwsExceptionForNegatives() {
        String stringOfNumbers = "1,-2,-3";
        try{
            stringCalculator.add(stringOfNumbers);
        }catch(IllegalArgumentException e){
            assertEquals("Error: negatives not allowed: -2,-3", e.getMessage());
        }
    }

    @Test
    void ignoresNumbersGreaterThan1001() {
        String stringOfNumbers = "1001,2";
        assertEquals(2, stringCalculator.add(stringOfNumbers));
    }
}
