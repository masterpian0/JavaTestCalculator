package Calculiator;

public class RomanNumber extends Number {

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
                case 'L':
                    values_int[i] = 50;
                    break;
                case 'C':
                    values_int[i] = 100;
                    break;
            }
        }

        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++) {
            if (values_int[i] >= values_int[i+1]) {
                result += values_int[i+1];
            }
            else if (values_int[i] < values_int[i+1]) {
                result += values_int[i+1] - 2;
            }
        }
        return result;
    }

    private String convertResultToRomanNumbersSymbol(int n) {

        String s = sign;
        int tempValue = n;

        if (n < 0) {
            tempValue = n *(-1);
            sign = "-";
        }

        while (tempValue >= 100) {
            s += "C";
            tempValue -= 100;
        }
        while (tempValue >= 90) {
            s += "XC";
            tempValue -= 90;
        }
        while (tempValue >= 50) {
            s += "L";
            tempValue -= 50;
        }
        while (tempValue >= 40) {
            s += "XL";
            tempValue -= 40;
        }
        while (tempValue >= 10) {
            s += "X";
            tempValue -= 10;
        }
        while (tempValue >= 9) {
            s += "IX";
            tempValue -= 9;
        }
        while (tempValue >= 5) {
            s += "V";
            tempValue -= 5;
        }
        while (tempValue >= 4) {
            s += "IV";
            tempValue -= 4;
        }
        while (tempValue >= 1) {
            s += "I";
            tempValue -= 1;
        }
            return sign + s;
    }

    @Override
    public void sum() {
        result_int = romes_value1_int + romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int);
    }

    @Override
    public void sub() {
        result_int = romes_value1_int - romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int);
    }

    @Override
    public void mul() {
        result_int = romes_value1_int * romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int);
    }

    @Override
    public void div() {
        result_int = romes_value1_int / romes_value2_int;
        result_string = convertResultToRomanNumbersSymbol(result_int);
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


