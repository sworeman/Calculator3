public enum NumberType {
    ARABIC, ROMAN;

    public static NumberType DetermineType1(String operand1) {
        if (Character.isDigit(operand1.charAt(0))) {
            return NumberType.ARABIC;
        } else {
            return NumberType.ROMAN;
        }
    }
    public static NumberType DetermineType2(String operand2) {
        if (Character.isDigit(operand2.charAt(0))) {
            return NumberType.ARABIC;
        } else {
            return NumberType.ROMAN;
        }
    }
}
