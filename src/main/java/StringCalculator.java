import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String stringNumber) throws IllegalArgumentException {
        int result = 0;
        String separators = ",\n";
        List<String> negatives = new ArrayList<String>();

        if(stringNumber == null){
            return 0;
        }

        separators += format(stringNumber);

        String[] numbers = stringNumber.split("[" + separators + "]");

        for (String number : numbers) {
            if(number.matches(".*\\d.*")){
                int n = Integer.parseInt(number);
                if(n < 0){
                    negatives.add(number);
                }
                if(n < 1001){
                    result += n;
                }
            }
        }

        if(!negatives.isEmpty()){
            throw new IllegalArgumentException(
                    "Error: negatives not allowed: " + String.join(",", negatives)
            );
        }

        return result;
    }

    private String format(String stringNumber){
        String newSeparators = "";
        if(stringNumber.startsWith("//")){
            String[] array = stringNumber.split("\n");
            newSeparators = array[0].substring(2);

            if(newSeparators.contains("[")){
                String[] Separators = newSeparators.substring(1, newSeparators.length()-1).split("\\]\\[");
                newSeparators = String.join("|", Separators);
            }

        }
        return newSeparators;

    }

}
