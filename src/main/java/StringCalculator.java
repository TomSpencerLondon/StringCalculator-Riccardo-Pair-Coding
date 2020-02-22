public class StringCalculator {

    public int add(String stringNumber) {
        int result = 0;
        String separators = ", \n";

        if(stringNumber == null){
            return 0;
        }

        if(stringNumber.startsWith("//")){
            String[] array = stringNumber.split("\n");
            String newSeparators = array[0].substring(1);
            separators += newSeparators;
            System.out.println(newSeparators);
            stringNumber = array[1];
        }

        String[] numbers = stringNumber.split("[" + separators + "]");

        for (String number : numbers) {
            int n = Integer.parseInt(number);
            result += n;
        }

        return result;

    }

}
