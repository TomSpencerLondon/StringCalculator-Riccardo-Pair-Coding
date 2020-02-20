import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorShould {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"0!",
                        "1! 1",
                        "2! 2"}, delimiter = '!')
    public void covertsStringToNumber(int number, String stringNumber){
        assertEquals(number, stringCalculator.add(stringNumber));
    }

}
