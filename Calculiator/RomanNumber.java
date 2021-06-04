package Calculiator;

public class RomanNumber extends Number {

    private final String[] ROMAN_NUMBERS_SYMBOL = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private String romes_value1;
    private String romes_value2;
    private int romes_value1_int;
    private int romes_value2_int;
    private int result_int;
    private String sign = "";
    private String result_string;

    public String getRomes_value1() {
        return romes_value1;
    }

    public String getRomes_value2() {
        return romes_value2;
    }

    public int getRomes_value1_int() {
        return romes_value1_int;
    }

    public int getRomes_value2_int() {
        return romes_value2_int;
    }

    public void setRomes_value1(String romes_value1) {
        this.romes_value1 = romes_value1;
    }

    public void setRomes_value2(String romes_value2) {
        this.romes_value2 = romes_value2;
    }

    public void setRomes_value1_int(int romes_value1_int) {
        this.romes_value1_int = romes_value1_int;
    }

    public void setRomes_value2_int(int romes_value2_int) {
        this.romes_value2_int = romes_value2_int;
    }

    RomanNumber(String value1, String value2) {
        this.romes_value1 = value1;
        this.romes_value2 = value2;
        this.romes_value1_int = convertToInt(romes_value1);
        this.romes_value2_int = convertToInt(romes_value2);
    }

    private int convertToInt(String romes_value){
        char[] value_char = romes_value.toCharArray();
        int[] values_int = new int[value_char.length];
        for (int i = 0; i < value_char.length; i++) {
            switch (value_char[i]) {
                case 'I':
                    values_int[i] = 1;
                    break;
                case 'V':
                    values_int[i] = 5;
                    break;
                case 'X':
                    values_int[i] = 10;
                    break;
            }
        }

        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++) {
            if (values_int[i] >= values_int[i+1]) {
                result += values_int[i+1];
            } else if (values_int[i] < values_int[i+1]) {
                result = result + values_int[i+1] - 2;
            }
        }
        return result;
    }

    private String convertResultToRomanNumbersSymbol(int n, int balanceValue) {

        balanceValue = n % 10;

        if (balanceValue != 0) {
            try
            {
                return convertResultToRomanNumbersSymbol(n - balanceValue, 0) + ROMAN_NUMBERS_SYMBOL[balanceValue - 1];
            }
            catch (ArrayIndexOutOfBoundsException e) {
                sign = "-";
                return convertResultToRomanNumbersSymbol(n - balanceValue, 0) + ROMAN_NUMBERS_SYMBOL[(balanceValue + 1) * -1];
            }
        }

        /* Negative roman number */

        if (n > 0) {
            n = n - 10;
            return convertResultToRomanNumbersSymbol(n,0) + "X";
        } else if (n < 0) {
            n = n + 10;
            return convertResultToRomanNumbersSymbol(n,0) + "X";
        }   else {
            return sign;
        }
    }

    @Override
    public void sum() {
        result_int = romes_value1_int + romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int, result_int);
    }

    @Override
    public void sub() {
        result_int = romes_value1_int - romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int, result_int);
    }

    @Override
    public void mul() {
        result_int = romes_value1_int * romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int, result_int);
    }

    @Override
    public void div() {
        result_int = romes_value1_int / romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int, result_int);
    }

    @Override
    public int getResult() {
        return result_int;
    }

    @Override
    public String getStringResult() {
        return result_string;
    }
}


