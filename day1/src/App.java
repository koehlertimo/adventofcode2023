import java.util.ArrayList;
import java.util.HashMap;

public class App {

    private static HashMap<String, Integer> numbers = new HashMap<>() {
        {
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }
    };

    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("input.txt");
        // Part 1
        int sum = sumValues(reader.getInput());
        System.out.println("Part 1:" + sum);

        // Part 2
        int sumWithLetters = sumValuesWithWrittenNames(reader.getInput());
        System.out.println("Part 2:" + sumWithLetters);
    }

    private static int sumValuesWithWrittenNames(ArrayList<String> inputValues) {
        ArrayList<Integer> digits = new ArrayList<>();
        int sum = 0;

        for (String value : inputValues) {
            value = replaceWrittenNumber(value);
            Integer firstNum = null;
            Integer lastNum = null;
            for (String charStr : value.split("")) {
                try {
                    if (firstNum == null) {
                        firstNum = Integer.parseInt(charStr);
                        lastNum = Integer.parseInt(charStr);
                    } else {
                        lastNum = Integer.parseInt(charStr);
                    }
                } catch (NumberFormatException e) {

                }
            }
            if (firstNum != null && lastNum != null) {
                String digitsAsString = "" + firstNum + lastNum;
                digits.add(Integer.parseInt(digitsAsString));
            }
        }

        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }

    private static String replaceWrittenNumber(String str) {
        for (String numberString : numbers.keySet()) {
            str = str.replaceAll(numberString, numberString.charAt(0) + numbers.get(numberString).toString()
                    + numberString.charAt(numberString.length() - 1));
        }

        return str;
    }

    private static int sumValues(ArrayList<String> inputValues) {
        ArrayList<Integer> digits = new ArrayList<>();
        int sum = 0;

        for (String value : inputValues) {
            Integer firstNum = null;
            Integer lastNum = null;
            for (String charStr : value.split("")) {
                try {
                    if (firstNum == null) {
                        firstNum = Integer.parseInt(charStr);
                        lastNum = Integer.parseInt(charStr);
                    } else {
                        lastNum = Integer.parseInt(charStr);
                    }
                } catch (NumberFormatException e) {

                }
            }
            if (firstNum != null && lastNum != null) {
                String digitsAsString = "" + firstNum + lastNum;
                digits.add(Integer.parseInt(digitsAsString));
            }
        }

        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }
}
