import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String stringNumber) throws IllegalArgumentException {
        int result = 0;
        String separators = ",\n";
        List<String> negatives = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");

        if(stringNumber == null){
            return 0;
        }

        if(stringNumber.startsWith("//")){
            String[] array = stringNumber.split("\n");
            String newSeparators = array[0].substring(1);

            if(newSeparators.contains("[")){
                Matcher match = pattern.matcher(stringNumber);
                if(match.find()){
                    separators += match.group(1);
                }
            }else {
                separators += newSeparators;
            }

            stringNumber = array[1];
        }

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

}
