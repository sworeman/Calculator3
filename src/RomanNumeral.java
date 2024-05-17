public enum RomanNumeral {
    C(100), XC(90), L(50), XL(40), X(10), IX(9),V(5), IV(4), I(1);

    final int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    public static int convertToArabic(String num) {
        int arabic = 0;
        int prevValue = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            int curValue = RomanNumeral.valueOf(String.valueOf(num.charAt(i))).getValue();
            if (curValue < prevValue) {
                arabic -= curValue;
            } else {
                arabic += curValue;
            }
            prevValue = curValue;
        }
        return arabic;
    }
    public static String convertToRoman(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        String result = "";

        for (RomanNumeral numeral : RomanNumeral.values()) {
            while (num >= numeral.value) {
                result += numeral.name();
                num -= numeral.value;
            }
        }
        return result;
    }
}

