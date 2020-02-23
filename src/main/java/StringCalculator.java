import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String stringNumber) throws IllegalArgumentException {
        int result = 0;
        String separators = ", \n";
        List<String> negatives = new ArrayList<String>();

        if(stringNumber == null){
            return 0;
        }

        if(stringNumber.startsWith("//")){
            String[] array = stringNumber.split("\n");
            String newSeparators = array[0].substring(1);
            separators += newSeparators;
            stringNumber = array[1];
        }
        String[] numbers = stringNumber.split("[" + separators + "]");
        for (String number : numbers) {
            int n = Integer.parseInt(number);
            if(n < 0){
                negatives.add(number);
            }
            result += n;

        }

        if(!negatives.isEmpty()){
            System.out.println("Inside negatives if statement");
            throw new IllegalArgumentException(
                    "Error: negatives not allowed: " + String.join(",", negatives)
            );
        }

        return result;

    }

}
