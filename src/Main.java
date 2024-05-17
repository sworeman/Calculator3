import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Invalid input");
        }
        String operand1 = parts[0];
        String operator = parts[1];
        String operand2 = parts[2];

        NumberType type1 = NumberType.DetermineType1(operand1);
        NumberType type2 = NumberType.DetermineType2(operand2);
        ;
        if (type1 != type2) {
            throw new Exception("Invalid input");
        }

        int num1, num2;

        if (type1 == NumberType.ROMAN) {
            num1 = RomanNumeral.convertToArabic(operand1);
            num2 = RomanNumeral.convertToArabic(operand2);
        } else {
            num1 = Integer.parseInt(operand1);
            num2 = Integer.parseInt(operand2);
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Invalid input");
        }
        String result = "";
        switch (operator) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "/":
                result = String.valueOf(num1 / num2);
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            default:
                throw new Exception("Invalid input");
        }
        if (type1 == NumberType.ROMAN) {
            int intResult = Integer.parseInt(result);
            return RomanNumeral.convertToRoman(intResult);
        } else {
            return result;
        }
    }
}
